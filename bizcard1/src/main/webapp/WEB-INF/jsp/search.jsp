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
          <li><a href="search">检索</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4 text-center">
        <input type="text" class="form-control" placeholder="检索..." id="keyword"/>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <hr/>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <table class="table table-striped">
          <thead>
            <tr>
              <td>姓名</td>
              <td>公司（单位）</td>
              <td>职务</td>
            </tr>
          </thead>
          <tbody id="list">
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <script src="lib/jquery.min.js"></script>
  <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
  <script src="lib/handlebars.min.js"></script>

  <script id="template" type="text/template">
    {{#each item}}
    <tr>
      <td>{{name}}</td>
      <td>{{company}}</td>
      <td>{{title}}</td>
    </tr>
    {{/each}}
  </script>

  <script type="text/javascript">
    $(function () {
      $('#keyword').on('keypress', function (event) {
        // ASCII
        if (event.keyCode == '13') {
          $.ajax({
            url: 'search',
            type: 'post',
            data: {keyword: $('#keyword').val()},
            dataType: 'json',
            // xhr = XMLHttpRequest
            // res = response
            // status = 200, 400, 500
            success: function (res, status, xhr) {
              console.log(res);
              var source = $('#template').html()
              var template = Handlebars.compile(source)
              var data = {'item': res}
              $('#list').html(template(data))
            }
          })
        }
      })
    })
  </script>
</body>
</html>
