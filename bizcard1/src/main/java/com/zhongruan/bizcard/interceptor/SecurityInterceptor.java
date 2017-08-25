package com.zhongruan.bizcard.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SecurityInterceptor implements HandlerInterceptor {

  // 保存例外的url，比如login和register
  private List<String> excludeUrls;

  public List<String> getExcludeUrls() {
    return excludeUrls;
  }

  public void setExcludeUrls(List<String> excludeUrls) {
    this.excludeUrls = excludeUrls;
  }

  // 客户端发起的请求在到达controller前触发，拦截该请求
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
      return false;
    }
    return true;
  }

  // 请求被controller接收后触发
  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView mav
  ) throws Exception {}

  // 请求和响应处理完毕后触发
  @Override
  public void afterCompletion (
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      Exception exception
  ) throws Exception {}
}
