package com.zhongruan.sic.controller;

import io.jsonwebtoken.Claims;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

  Logger logger = LoggerFactory.getLogger(ApiController.class);

	// request中的claims于过滤器JwtFilter中注入
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public Boolean login(@PathVariable final String role,
			final HttpServletRequest request) throws ServletException {
		logger.info("Role");
		final Claims claims = (Claims) request.getAttribute("claims");
		logger.info("claims: {}", claims);

		return ((List<String>) claims.get("roles")).contains(role);
	}
}
