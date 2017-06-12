<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>SpringMVC</title>
  <!--[if lt IE 9]>
  <script src="lib/html5shiv.min.js"></script>
  <script src="lib/respond.min.js"></script>
  <![endif]-->
  <script src="lib/jquery-1.12.1.min.js"></script>
  <script src="lib/JavaScript-MD5-2.3.0/js/md5.min.js"></script>
  <link href="lib/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet">
  <script src="lib/bootstrap-3.3.6/js/bootstrap.min.js"></script>
  <script src="lib/layer/layer.js"></script>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md12 page-header">
        <h2 class="text-center">SpringMVC<br /><small>用户登录</small></h2>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <br /><br /><br /><br />
      <div class="col-md-8">
        <div class="text-center">
          <img src="<%= request.getContextPath() %>/images/logo.jpg" />
        </div>
      </div>
      <div class="col-md-3">
        <div class="panel panel-default">
          <div class="panel-heading">登录</div>
            <div class="panel-body">
              <form method="post" action="<%= request.getContextPath() %>/login.do">
                <div class="form-group">
                  <label for="account">账号</label>
                  <input type="text" class="form-control" name="account"/>
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" class="form-control" name="password"/>
                </div>
                <button type="submit" class="btn btn-primary btn-block">登录</button>
                <br />
                <p class="text-center"><a href="signup.do">注册账号</a></p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
