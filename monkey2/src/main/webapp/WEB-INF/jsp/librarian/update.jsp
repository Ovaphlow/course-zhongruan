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
  <script src="/lib/html5shiv.min.js"></script>
  <script src="/lib/respond.min.js"></script>
  <![endif]-->
  <link href="/lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
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
        <a class="navbar-brand" href="#">Spring MVC / Hibernate 入门</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li><a href="/">首页 <span class="sr-only">(current)</span></a></li>
          <li class="active"><a href="/librarian">图书馆管理系统</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
              代码实现
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">文件说明</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">数据库</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Maven 配置</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">框架配置</a></li>
              <li><a href="#">DAO (数据访问对象 / 数据库接口层)</a></li>
              <li><a href="#">Service (业务逻辑 / 服务层)</a></li>
              <li><a href="#">Controller (控制器 / 控制层)</a></li>
              <li><a href="#">JSP 页面</a></li>
            </ul>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">当前用户 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">用户中心</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">退出登录</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h3>图书馆管理系统</h3>
        <hr/>
      </div>
      <div class="col-md-8">
        <ul class="nav nav-pills">
          <li role="presentation"><a href="/librarian">首页</a></li>
          <li role="presentation"><a href="/librarian/append">添加书籍</a></li>
        </ul>
      </div>
      <div class="col-md-4">
        <!--<input class="form-control" id="search"/>-->
      </div>
      <div class="col-md-12">
        <hr/>
      </div>
    </div>
  </div>

  <div class="container">
    <form id="form">
      <div class="row">
        <div class="col-md-12 form-group">
          <label for="isbn">ISBN</label>
          <input class="form-control" name="isbn" type="text" value="${book.isbn}"/>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6 form-group">
          <label for="name">名称</label>
          <input class="form-control" name="name" type="text" value="${book.name}"/>
        </div>
        <div class="col-md-6 form-group">
          <label for="former-name">原名</label>
          <input class="form-control" name="formerName" type="text" value="${book.formerName}"/>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6 form-group">
          <label for="author">作者</label>
          <input class="form-control" name="author" type="text" value="${book.author}"/>
        </div>
        <div class="col-md-6 form-group">
          <label for="translator">译者</label>
          <input class="form-control" name="translator" type="text" value="${book.translator}"/>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4 form-group">
          <label for="publisher">出版社</label>
          <input class="form-control" name="publisher" type="text" value="${book.publisher}"/>
        </div>
        <div class="col-md-4 form-group">
          <label for="publication-date">出版日期</label>
          <input class="form-control" name="publicationDate" type="text" value="${book.publicationDate}"/>
        </div>
        <div class="col-md-4 form-group">
          <label for="series">系列</label>
          <input class="form-control" name="series" type="text" value="${book.series}"/>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4 form-group">
          <label for="language">语言</label>
          <input class="form-control" name="language" type="text" value="${book.language}"/>
        </div>
        <div class="col-md-4 form-group">
          <label for="pages">页数</label>
          <input class="form-control" name="pages" type="text" value="${book.pages}"/>
        </div>
        <div class="col-md-4 form-group">
          <label for="format">开本</label>
          <input class="form-control" name="format" type="text" value="${book.format}"/>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 form-group">
          <label for="intro">简介</label>
          <textarea class="form-control" name="intro" rows="7">${book.intro}</textarea>
        </div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <a class="btn btn-default btn-block" href="../../librarian">后退</a>
        </div>
        <div class="col-md-2 col-md-offset-3">
          <a class="btn btn-danger btn-block" id="delete">删除</a>
        </div>
        <div class="col-md-2 col-md-offset-3">
          <a class="btn btn-primary btn-block" id="submit">提交</a>
        </div>
      </div>
    </form>
  </div>

  <script src="/lib/jquery.min.js"></script>
  <script src="/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>

  <script type="text/javascript">
  $(function () {
    // console.log(location.href)
    $('#delete').on('click', function () {
      $.ajax({
        url: location.href,
        type: 'delete',
        data: {},
        dataType: 'text',
        success: function (response, status, xhr) {
          console.log(response)
          if ('OK' == response) {
            window.location.href = '../../librarian'
          } else {
            alert('操作失败')
          }
        }
      })
    })
    $('#submit').on('click', function () {
      $.ajax({
        url: location.href,
        type: 'post',
        data: $('#form').serialize(),
        dataType: 'text',
        success: function (response, status, xhr) {
          console.log(response)
          if ('OK' == response) {
            alert('操作成功')
            location.reload()
          } else {
            alert('操作失败')
          }
        }
      })
    })
  })
  </script>
</body>
</html>
