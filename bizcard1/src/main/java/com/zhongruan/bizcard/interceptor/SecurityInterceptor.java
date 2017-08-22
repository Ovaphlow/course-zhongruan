package com.zhongruan.bizcard.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SecurityInterceptor implements HandlerInterceptor {

  private List<String> excludeUrls;

  public List<String> getExcludeUrls() {
    return excludeUrls;
  }

  public void setExcludeUrls(List<String> excludeUrls) {
    this.excludeUrls = excludeUrls;
  }

  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {
    String requestUri = request.getRequestURI();
    for (String url : excludeUrls) {
      if (requestUri.endsWith(url)) {
        return true;
      }
    }
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      response.sendRedirect("/login");
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView mav
  ) throws Exception {}

  @Override
  public void afterCompletion (
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      Exception exception
  ) throws Exception {}
}
