package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * Created by ovaphlow on 2017/6/10.
 * Source http://www.jdon.com/dl/best/json-web-tokens-spring-cloud-microservices.html
 */
public class JsonWebToken {

  private SignatureAlgorithm signatureAlgorithm;
  private Key secretKey;

  public JsonWebToken() {
    signatureAlgorithm = SignatureAlgorithm.HS512;
    String encodedKey = "ovaphlow";
    secretKey = deserializeKey(encodedKey);
  }

  public String createJsonWebToken(AuthTokenDetailsDTO authTokenDetailsDTO) {
    String token = Jwts.builder().setSubject(authTokenDetailsDTO)
        .claim("email", authTokenDetailsDTO.email)
        .claim("roles", authTokenDetailsDTO.roleName)
        .setExpiration(authTokenDetailsDTO.expirationDate)
        .signWith(getSignatureAlgorithm(), getSecretKey())
        .compact();
    return token;
  }

  private Key deserializeKey(String encodedKey) {
    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
    Key key = new SecretKeySpec(decodedKey, getSignatureAlgorithm().getJcaName());
    return key;
  }

  private Key getSecretKey() {
    return secretKey;
  }

  public SignatureAlgorithm getSignatureAlgorithm() {
    return signatureAlgorithm;
  }

  public AuthTokenDetailsDTO parseAndValidate(String token) {
    AuthTokenDetailsDTO authTokenDetailsDTO = null;
    try {
      Claims claims = Jwts.parser().setSignningKey(getSecretKey())
          .parseClaimsJws(token).getBody();
      String userId = claims.getSubject();
      String email = (String) claims.get("email");
      List roleNames = (List) claims.get("roles");
      Date expirationDate = claims.getExpiration();

      authTokenDetailsDTO = new AuthTokenDetailsDTO();
      autoTokenDetailsDTO.userId = userId;
      authTokenDetailsDTO.email = email;
      authTokenDetailsDTO.roleName = roleNames;
      authTokenDetailsDTO.expirationDate = expirationDate;
    } catch (JwtException e) {
      System.out.println(e);
    }
    return authTokenDetailsDTO;
  }

  private String serializeKey(Key key) {
    String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
    return encodedKey;
  }
}
