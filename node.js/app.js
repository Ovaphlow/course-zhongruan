const path = require('path')

const express = require('express');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const mysql = require('./util/mysql.js');

const app = express();

let _static = path.join(path.normalize(__dirname + '/..'), 'webapp');
app.use(express.static(_static));

let _upload = path.join(path.normalize(__dirname + '/..'), 'archieve', 'static')
app.use(express.static(_upload))

app.use(bodyParser.urlencoded({extended: true}));

app.use(cookieParser());

const getConnection = function (req, res, next) {
  next();
};

app.post('/login', function (request, response) {
  mysql.pool.getConnection(function(error, connection) {
    if (error) {
      response.json({message: '连接数据库失败'});
      return;
    }
    console.log('[info] mysql client id:', connection.threadId);
    const sqlText = 'select id, count(*) counter '
        + 'from users '
        + 'where account = ? '
        + 'and password = ? '
        + 'limit 1';
    const param = [request.body['account'], request.body['password']];
    connection.query({
      sql: sqlText,
      values: param
    }, function (error, data) {
      connection.release();
      if (error) {
        response.send({message: 'ERROR'});
        return;
      }
      if (data[0].counter == 1) {
        response.send({
          message: 'OK',
          userId: data[0].id
        });
      } else {
        response.send({
          message: 'ERROR',
          error: 'INVALID_ACCOUNT_PASSWORD'
        });
      }
    });
  });
});

app.get('/test', [getConnection], function (req, res) {
  res.send({message: 'OK'});
});

const user = require('./router/user');
app.use('/user', user);

const file = require('./router/file');
app.use('/file', file);

const archive = require('./router/archive')
app.use('/', archive)

const publicUser = require('./router/public-user');
app.use('/api/public', publicUser);

app.listen(8888);

console.log('服务器启动，端口：8888');
console.log('静态文件位置：' + _static);
