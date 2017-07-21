package com.zhongruan.sic.controller;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.zhongruan.sic.Config;
import com.zhongruan.sic.entity.UserEntity;

@RestController
@RequestMapping("auth")
public class MainController {

  Logger logger = LoggerFactory.getLogger(ApiController.class);

  @GetMapping(value = "info")
  public Map<String, Object> info(@RequestHeader("Authorization") String auth) {
    logger.info("auth: {}", auth);
    Map<String, Object> result = new HashMap<String, Object>();
    if (auth == null || !auth.startsWith("Bearer ")) {
      result.put("statusCode", 401);
      return result;
    }
    final String token = auth.substring(7);
    logger.info("token: {}", token);
    try {
      final Claims claims = Jwts.parser()
          .setSigningKey(Config.JWT_SECRET_KEY)
          .parseClaimsJws(token)
          .getBody();
      logger.info("claims: {}", claims);
      logger.info("sub: {}", claims.get("sub"));
    }
    catch (Exception e) {
      e.printStackTrace();
      result.put("statusCode", 403);
      return result;
    }
    result.put("statusCode", 200);
    return result;
  }

  @GetMapping(value = "sign-in")
  public String testSignIn() {
    return "testing: OK";
  }

	// @SuppressWarnings("unchecked")
	@PostMapping(value = "sign-in")
	public Map<String, String> signIn(UserEntity user) {
    logger.info("Sign in: {}", user);
    String token = Jwts.builder()
      .setSubject(user.getAccount())
      .setIssuedAt(new Date())
      // .setExpiration()
      .claim("role", "用户")
      .signWith(SignatureAlgorithm.HS256, Config.JWT_SECRET_KEY)
      .compact();
    Map<String, String> result = new HashMap<String, String>();
    result.put("message", "OK");
    result.put("token", token);
    logger.info("{}", result);
    return result;
	}
}
