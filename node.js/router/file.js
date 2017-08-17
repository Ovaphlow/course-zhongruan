const express = require('express')
const multer = require('multer');
const xlsx = require('node-xlsx');

const mysql = require('../util/mysql');
const sequelize = require('../util/sequelize');

const sheet = require('../service/sheet');

const router = express.Router()
const upload = multer({dest: 'upload/'});

router.route('/test').get(function (req, res) {
  let sql = 'select id, danganhao, shenfenzheng, xingming '
    + 'from dangan '
    + 'order by id desc '
    + 'limit 1';
  sequelize.query(sql, {type: sequelize.QueryTypes.SELECT})
    .then(function (archive) {
      console.log(archive[0].id);
    });
  res.json({"message": "OK"});
});

router.post('/upload', upload.single('file'), function (req, res) {
  sheet(req.file.path);
  res.json({"message": "OK"});
});

module.exports = router
