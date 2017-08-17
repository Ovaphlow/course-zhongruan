const express = require('express')

const mysql = require('../util/mysql');
const sequelize = require('../util/sequelize');

const router = express.Router()

// var multer = require('multer');

// var upload = multer()

// router.use(function timeLog(req, res, next) {
//   console.log('[info] Time:', Date.now());
//   next();
// });

router.route('/login')
  .post(function (req, res) {
    let sql = `
    select id, count(*) as counter
    from user
    where zhanghao = :account
      and mima = :password`
    sequelize.query(sql, {
      // replacements: {
      //   account: req.body.account,
      //   password: req.body.password
      // },
      replacements: req.body,
      type: sequelize.QueryTypes.SELECT
    }).then(function (result) {
      if (result[0].counter === 1) {
        // cookie
        res.json({message: 'OK'})
      } else {
        res.json({message: 'ERROR'})
      }
    })
  })

router.route('/info')
  .get(function (req, res) {
    mysql.pool.getConnection(function (err, connection) {
      if (err) {
        // console.log(err)
        res.send({message: 'ERROR_ON_CONNECT_TO_DATABASE'})
        return
      }
      let sql = 'select id, account, nickname '
          + 'from users '
          + 'where id = ? '
          + 'limit 1'
      let param = [req.cookies.user]
      connection.query({
        sql: sql,
        values: param
      }, function (err, data) {
        connection.release()
        if (err) {
          res.send({message: 'QUERY_FAILED'})
          return
        }
        res.json(data[0])
      })
    })
  })

router.route('/check')
  .get(function (req, res) {
    console.log('Cookies: ', req.cookies.user)
    res.send({message: 'OK', counter: 1})
  })

// 修改密码
router.route('/change-password')
  .post(function (req, res) {
    res.send({message: 'NOT_FINISHED'})
  })

// 修改昵称
router.route('/change-nickname')
  .post(function (req, res) {
    res.send({message: 'NOT_FINISHED'})
  })

module.exports = router
