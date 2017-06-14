<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>中软睿达</title>
  <!--[if lt IE 9]>
  <script src="lib/html5shiv.min.js"></script>
  <script src="lib/respond.min.js"></script>
  <![endif]-->
  <link href="lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
  <nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">BizCard&nbsp;电话薄</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="/">首页 <span class="sr-only">(current)</span></a></li>
          <li><a href="#">添加联系人</a></li>
        </ul>
        <form class="navbar-form navbar-left">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="检索...">
          </div>
        </form>
      </div>
    </div>
  </nav>

  <!--<div class="container">
    <div class="row">
      <div class="col-md-12 page-header">
        <h4>Spring MVC / MyBatis 框架</h4>
      </div>
    </div>
  </div>-->

  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <table class="table table-striped">
          <thead>
            <tr>
              <td>姓名</td>
              <td>公司（单位）</td>
              <td>职务</td>
              <td>地址</td>
              <td>IM</td>
              <td>备注</td>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list}" var="bizcard">
              <tr>
                <td>${bizcard.name}</td>
                <td>${bizcard.company}</td>
                <td>${bizcard.title}</td>
                <td>${bizcard.address}</td>
                <td>${bizcard.im}</td>
                <td>${bizcard.remark}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <script src="lib/jquery.min.js"></script>
  <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
