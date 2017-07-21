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
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.zhongruan.sic.Config;
import com.zhongruan.sic.entity.UserEntity;

@RestController
@RequestMapping("auth")
public class MainController {

  Logger logger = LoggerFactory.getLogger(ApiController.class);

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
      .claim("role", "用户")
      .setIssuedAt(new Date())
      .signWith(SignatureAlgorithm.HS256, Config.JWT_SECRET_KEY)
      .compact();
    Map<String, String> result = new HashMap<String, String>();
    result.put("message", "OK");
    result.put("token", token);
    logger.info("{}", result);
    return result;
	}
}
