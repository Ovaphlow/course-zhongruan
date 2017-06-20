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
        <a class="navbar-brand" href="#">档案管理</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="/">首页 <span class="sr-only">(current)</span></a></li>
          <li><a href="#">添加档案</a></li>
          <li><a href="search">检索</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class="row">
      <div class="col-md-12 page-header">
        <h3>档案管理</h4>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="form-group">
          <input class="form-control" id="search" type="text"/>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <table class="table table-striped">
          <thead>
            <tr>
              <td>档案号</td>
              <td>身份证</td>
              <td>姓名</td>
              <td>性别</td>
              <td>出生日期</td>
              <td>联系方式</td>
            </tr>
          </thead>
          <tbody id="list">
            <c:forEach items="${dangan}" var="d">
              <tr>
                <td>${d.danganhao}</td>
                <td>${d.shenfenzheng}</td>
                <td>${d.xingming}</td>
                <td>${d.xingbie}</td>
                <td>${d.chushengriqi}</td>
                <td>${d.lianxifangshi}</td>
              </tr>
            </c:forEach>
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
    <td>{{danganhao}}</td>
    <td>{{shenfenzheng}}</td>
    <td>{{xingming}}</td>
    <td>{{xingbie}}</td>
    <td>{{chushengriqi}}</td>
    <td>{{lianxifangshi}}</td>
  </tr>
  {{/each}}
  </script>

  <script type="text/javascript">
  // $ 等价于 jQuery
  $(function () { // 页面加载完毕之后运行后面的代码
    // jQuery 的选择器
    // # 开头代表选择 id 为 # 后面字符的元素
    // on 代表绑定事件
    // keypress 代表键盘按键
    $('#search').on('keypress', function (event) {
      // 如果按下的按键是回车，event 代表事件，keyCode 代表按键
      if (event.keyCode == '13') {
        $.ajax({
          // 请求的地址
          url: 'search',
          // 请求方式
          type: 'post',
          // 发送给后端的诗句
          data: {keyword: $('#search').val()},
          // 后端返回数据的类型，其它还有 html，text，xml 等
          dataType: 'json',
          // 通讯成功后后触发的回调函数
          // response 代表后端返回的数据
          // status 代表通讯状态，比如 200，400，500，404 等
          // xhr 代表 原生 ajax 通讯使用的 XMLHttpRequest 对象
          success: function (response, status, xhr) {
            var source = $('#template').html()
            var template = Handlebars.compile(source)
            var data = {'item': res}
            $('#list').html(template(data))
          },
          // 通讯失败后触发的回调函数
          error: function () {},
          // 无论通讯成功或失败均会触发的回调函数
          complete: function () {}
        })
      }
    })
  })
  </script>
</body>
</html>
