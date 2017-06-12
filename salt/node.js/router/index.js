var express = require('express')
var router = express.Router()
var mysql = require('../util/mysql')

router.route('/api/description')
  .get(function (req, res) {
    res.json({
      'Classification': 'Micro',
      'Language': 'JavaScript',
      'Platform': 'None',
      'Frontend': 'None',
      'OS': 'Windows',
    })
  })

router.route('/api/user')
  .get(function (req, res) {
    mysql.pool.getConnection(function (err, connection) {
      if (err) {
        // console.log(err)
        res.send({message: 'ERROR_ON_CONNECT_TO_DATABASE'})
        return
      }
      let sql = 'select id, account, name '
          + 'from user'
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
        res.json(data)
      })
    })
  })

router.route('/api/test')
  .get(function (req, res) {
    mysql.pool.getConnection(function (err, connection) {
      if (err) {
        // console.log(err)
        res.send({message: 'ERROR_ON_CONNECT_TO_DATABASE'})
        return
      }
      let sql = 'select id, account, name '
          + 'from user'
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
        res.json({
          'Classification': 'Micro',
          'Language': 'JavaScript',
          'Platform': 'None',
          'Frontend': 'None',
          'OS': 'Windows',
          'Data': {
            'Length': data.length,
            'Content': data
          }
        })
      })
    })
  })

module.exports = router
