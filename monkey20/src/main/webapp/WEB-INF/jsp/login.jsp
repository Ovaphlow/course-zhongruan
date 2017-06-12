<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>登录</title>
  <!--[if lt IE 9]>
  <script src="lib/html5shiv.min.js"></script>
  <script src="lib/respond.min.js"></script>
  <![endif]-->
  <link href="lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-12 page-header">
        <h2 class="text-center">Spring MVC / Hibernate 入门</h2>
        <br/>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <br/><br/><br/>
      <div class="col-md-8">
        <div class="text-center">
          <img src="<%= request.getContextPath() %>/images/logo.jpg"/>
        </div>
      </div>
      <div class="col-md-3">
        <div class="panel panel-default">
          <div class="panel-heading">登录</div>
            <div class="panel-body">
              <form method="post" action="<%= request.getContextPath() %>/login">
                <div class="form-group">
                  <label for="account">账号</label>
                  <input type="text" class="form-control" name="account"/>
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" class="form-control" name="password"/>
                </div>
                <button type="submit" class="btn btn-primary btn-block">确认</button>
                <br/>
                <p class="text-center">
                  <a href="register">注册账号</a>
                </p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="lib/jquery.min.js"></script>
  <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
