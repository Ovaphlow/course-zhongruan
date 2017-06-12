<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
  <h1>Welcome To Struts 2!</h1>
  <p><a href="<s:url action='hello'/>">Hello World</a></p>
  <s:form action="hello">
    <s:textfield name="userName" label="Your name" />
    <s:submit value="Submit" />
  </s:form>
  <p><a href="register.jsp">Please register</a> for our prize drawing</p>
</body>
</html>
