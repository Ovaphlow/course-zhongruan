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
        <a class="navbar-brand" href="#">Spring MVC / MyBatis 框架</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="/index">首页 <span class="sr-only">(current)</span></a></li>
          <li><a href="#">当前任务</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的工作 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">功能 1</a></li>
              <li><a href="#">功能 2</a></li>
              <li><a href="#">功能 3</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">附加功能 1</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">附加功能 A</a></li>
            </ul>
          </li>
        </ul>
        <form class="navbar-form navbar-left">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="检索...">
          </div>
        </form>
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
      <div class="col-md-12 page-header">
        <h4>Spring MVC / MyBatis 框架</h4>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <dl class="dl-horizontal">
          <dt>ID</dt><dd id="id"></dd>
          <dt>ISBN</dt><dd id="isbn"></dd>
          <dt>书名</dt><dd id="name"></dd>
          <dt>作者</dt><dd id="author"></dd>
        </dl>
        <a class="btn btn-primary" href="#" id="suibian-1">id: 1</a>
        <a class="btn btn-danger" href="#" id="suibian-2">id: 2</a>
      </div>
    </div>
  </div>

  <script src="lib/jquery.min.js"></script>
  <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>

  <script type="text/javascript">
  $(function () {
    // console.log($('[id^="suibian-"]'))
    $('[id^="suibian-"]').on('click', function () {
      $.ajax({
        url: 'book/' + this.id.split('-')[1],
        type: 'get',
        dataTypege: 'json',
        success: function (res) {
          // console.log(res)
          $('#id').text(res.id)
          $('#isbn').text(res.isbn)
          $('#name').text(res.name)
          $('#author').text(res.author)
        },
        error: function (xhr, status, res) {},
        complete: function () {}
      })
    })
    // $('#suibian1').on('click', function () {
    //   $.ajax({
    //     url: 'book/2',
    //     type: 'get',
    //     dataTypege: 'json',
    //     success: function (res) {
    //       // console.log(res)
    //       $('#id').text(res.id)
    //       $('#isbn').text(res.isbn)
    //       $('#name').text(res.name)
    //       $('#author').text(res.author)
    //     },
    //     error: function (xhr, status, res) {},
    //     complete: function () {}
    //   })
    // })
    // $.getJSON('book/' + this.id.split('-')[1], {}, function (res) {
    //   $('#id').text(res.id)
    //   $('#isbn').text(res.isbn)
    //   $('#name').text(res.name)
    //   $('#author').text(res.author)
    // })
    // $.post('', {}, function (res) {})
    // $.get('', {}, function (res) {})
  })
  </script>
</body>
</html>
