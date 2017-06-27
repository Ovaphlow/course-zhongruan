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
  <link href="<%= request.getContextPath() %>lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
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
          <li role="presentation" class="active"><a href="/librarian">首页</a></li>
          <li role="presentation"><a href="/librarian/append">添加书籍</a></li>
        </ul>
      </div>
      <div class="col-md-4">
        <input class="form-control" id="search"/>
      </div>
      <div class="col-md-12">
        <hr/>
      </div>
    </div>
  </div>

  <div class="container" id="list">
    <c:forEach items="${books}" var="book">
      <div class="row">
        <div class="panel panel-default">
          <div class="panel-body">
            <div class="col-md-12">
              <h3><a href="librarian/book/${book.id}">${book.name}</a></h3>
            </div>
            <div class="col-md-4">
              <p>${book.author} ${book.translator}</p>
              <p>${book.publisher} - ${book.publication_date}</p>
              <p>${book.series} / ${book.pages} 页 / ${book.language} / ${book.format} 开</p>
            </div>
            <div class="col-md-8">
              <p>${book.intro}</p>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>

  <script src="lib/jquery.min.js"></script>
  <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
  <script src="lib/handlebars.min.js"></script>

  <script id="template" type="text/template">
  {{#each items}}
      <div class="row">
        <div class="panel panel-default">
          <div class="panel-body">
            <div class="col-md-12">
              <h3><a href="librarian/book/{{id}}">{{name}}</a></h3>
            </div>
            <div class="col-md-4">
              <p>{{author}} {{translator}}</p>
              <p>{{publisher}} - {{publication_date}}</p>
              <p>{{series}} / {{pages}} 页 / {{language}} / {{format}} 开</p>
            </div>
            <div class="col-md-8">
              <p>{{intro}}</p>
            </div>
          </div>
        </div>
      </div>
  {{/each}}
  </script>

  <script type="text/javascript">
    $(function () {
      $('#search').on('keypress', function (event) {
        if (event.keyCode == '13') {
          $.ajax({
            url: 'librarian/search',
            type: 'post',
            data: {keyword: $('#search').val()},
            dataType: 'json',
            success: function (res, status, xhr) {
              // console.log(res);
              var source = $('#template').html()
              var template = Handlebars.compile(source)
              var data = {'items': res}
              $('#list').html(template(data))
            }
          })
        }
      })
    })
  </script>
</body>
</html>
