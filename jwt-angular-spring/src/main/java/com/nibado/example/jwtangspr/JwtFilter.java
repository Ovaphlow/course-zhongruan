package com.nibado.example.jwtangspr;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

    // 过滤器，于WebApplication中初始化并设置过滤条件。
    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("JwtFilter-- request");
        // System.out.println(String.format("JwtFilter-- %s", request));

        final String authHeader = request.getHeader("Authorization");
        System.out.println("JwtFilter-- get header");
        System.out.println(String.format("JwtFilter-- %s", authHeader));
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or invalid Authorization header.");
        }

        final String token = authHeader.substring(7); // The part after "Bearer "
        System.out.println("JwtFilter-- token");
        System.out.println(String.format("JwtFilter-- %s", token));

        try {
            final Claims claims = Jwts.parser().setSigningKey("secretkey")
                .parseClaimsJws(token).getBody();
            System.out.println("JwtFilter-- claims");
            System.out.println(String.format("JwtFilter-- %s", claims));
            request.setAttribute("claims", claims);
        }
        catch (final SignatureException e) {
            throw new ServletException("Invalid token.");
        }

        System.out.println("JwtFilter-- fin");
        chain.doFilter(req, res);
    }
}
