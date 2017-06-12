<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
  <div class="container">
    <div class="row">
      <div class="col-md-12 page-header">
        <h2 class="text-center">Spring MVC 框架</h2>
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
      <div class="col-md-4">
        <div class="panel panel-default">
          <div class="panel-heading">注册</div>
            <div class="panel-body">
              <form method="post" action="">
                <div class="form-group">
                  <label for="account">账号</label>
                  <input class="form-control" id="account" name="account" type="text"/>
                  <span class="text-danger" id="tip"></span>
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" class="form-control" name="password"/>
                </div>
                <div class="form-group">
                  <label for="password">重复密码</label>
                  <input type="password" class="form-control" name="password2"/>
                </div>
                <div class="form-group">
                  <label for="password">昵称</label>
                  <input type="text" class="form-control" name="name"/>
                </div>
                <button type="submit" class="btn btn-primary btn-block" id="submit">确认</button>
                <br/>
                <p class="text-center">
                  <a href="login">登录</p>
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

  <script type="text/javascript">
    $(function () {
      $('#account').on('blur', function () {
        $.ajax({
          url: 'checkUser',
          type: 'get',
          data: {account: $('#account').val()},
          dataType: 'json',
          success: function (res, status, xhr) {
            console.log(res)
            $('#tip').text(res.message)
          }
        })
      })
    })
  </script>
</body>
</html>
