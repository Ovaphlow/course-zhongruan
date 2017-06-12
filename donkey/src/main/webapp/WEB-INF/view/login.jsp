<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>登录</title>
</head>
<body>
  <h1>系统登录</h1>
  <form action="loginPost" method="post">
    <label>账号</label>
    <input name="account"/>
    <label>密码</label>
    <input name="password"/>
    <button type="submit" value="Submit">登录</button>
  </form>
</body>
</html>
