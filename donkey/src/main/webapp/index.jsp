<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
  <h1>Welcome To Struts 2!</h1>
  <p><a href="hello">Hello World</a></p>
  <form action="login">
    <!--<input name="account" label="Account" value="${account}"/>-->
    <!--<input name="password" label="Password" value="${password}"/>-->
    <input name="user.account" label="User Account"/>
    <input name="user.password" label="User Password"/>
    <button type="submit" value="Submit">Submit</button>
  </form>
  <p><a href="register.jsp">Please register</a> for our prize drawing</p>
  <!--<p><s:property value="#account"/></p>-->
  <p class="${account}">${account}</p>
  <p>${password}</p>
</body>
</html>
