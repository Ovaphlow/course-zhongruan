<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>列表</title>
</head>
<body>
	<a href="JPALearnServlet?action=add">添加随机记录</a>
	<a href="JPALearnServlet?action=list">所有记录列表</a>
	<table border=1 cellpadding=0 cellspacing=0 width=100% >
		<tr><th>Id</th><th>Name</th><th>Age</th></tr>
		<c:forEach items="${list }" var="item">
			<tr align=center><td>${item.id }</td><td>${item.name }</td><td>${item.age }</td></tr>
		</c:forEach>
	</table>
</body>
</html>
