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
              <form id="form">
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
                <a class="btn btn-primary btn-block" id="submit">确认</a>
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
  // $(document).ready(function () { })
  $(function () {
    // document.getElementById('account').onblur = function () {
      // console.log('blur');
    // }
    // 给id为account的元素绑定blur事件
    $('#account').on('blur', function () {
      $('#tip').text('')
      // 触发事件时执行ajax请求
      // 参数为js对象
      $.ajax({
        // 请求的地址
        url: 'check',
        // ajax请求附带的数据
        data: {account: $('#account').val()},
        // 请求的方法
        type: 'post',
        // 后端返回数据的类型
        dataType: 'json',
        // 通讯成功后执行的回调函数
        success: function (response, status, xhr) {
          if (response.message == 'OK') {
            $('#tip').text('用户名可用')
          } else {
            $('#tip').text('账号已被占用')
          }
        }
      })
    })
    $('#submit').on('click', function () {
      // console.log(11)
      console.log($('#form').serialize())
      $.ajax({
        url: '/register',
        type: 'post',
        data: $('#form').serialize(),
        dataType: 'text',
        success: function (response, status, xhr) {
          console.log(response)
          if (response == 'OK') {
            window.location.href = 'login'
          }
        }
      })
    })
  })
  </script>
</body>
</html>
