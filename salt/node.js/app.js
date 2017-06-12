var express = require('express');
var bodyParser = require('body-parser');
var cookieParser = require('cookie-parser');
var mysql = require('./util/mysql.js');

var app = express();

app.use(express.static('public'));
app.use(bodyParser.urlencoded({extended: true}));
app.use(cookieParser());

var index = require('./router/index');
app.use('/', index);

app.get('/', function (req, res) {
  res.send('1123');
});

app.get('/test', function (req, res) {
  res.send({message: 'OK'});
});

app.listen(8000);
