package com.zhongruan.sic.controller;

import io.jsonwebtoken.Claims;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.zhongruan.sic.config.JSONWebToken;
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
	public String signIn(
    UserEntity user
  ) {
    logger.info("Sign in: {}", user);
    logger.info("secret key: {}", JSONWebToken.SECRET_KEY);
    return "OK";
	}
}
