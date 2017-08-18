<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
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
  <%-- 容器 --%>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>中软睿达 - MC电影院<small><br/>登录</small></h1>
        <hr/>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
      </div>
    </div>
    <div class="row">
      <div class="col-md-8 text-center">
        <img src="/images/logo.jpg"/>
      </div>
      <div class="col-md-4">
        <div class="panel panel-primary">
          <div class="panel-heading"><strong>登录</strong></div>
            <div class="panel-body">
              <form id="login">
                <div class="control-group">
                  <label>账号</label>
                  <input name="username" type="text" class="form-control" placeholder="请输入账号"/>
                </div>
                <p>&nbsp;</p>
                <div class="control-group">
                  <label>密码</label>
                  <input name="password" type="password" class="form-control" placeholder="请输入密码"/>
                </div>
                <p>&nbsp;</p>
                <a id="submit" class="btn btn-info btn-block">确认</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="lib/jquery.min.js"></script>
  <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
  <script>
  $('#submit').on('click', function () {
    console.log($('#login').serialize())
    $.ajax({
      url: 'login',
      type: 'post',
      data: $('#login').serialize(),
      dataType: 'json',
      success: function (res) {
        console.log(res)
      }
    })
  })
  </script>
</body>
</html>
