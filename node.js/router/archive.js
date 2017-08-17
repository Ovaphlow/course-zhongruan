const express = require('express')
const logger = require('tracer').colorConsole()
const sequelize = require('../util/sequelize');

const router = express.Router()

router.route('/api/search')
  .post(function (req, res) {
    // logger.info(req.body)
    let sql = `
    select id, count(*) as counter
    from dangan
    where danganhao = :keyword
      or shenfenzheng = :keyword
    `
    sequelize.query(sql, {
      replacements: req.body,
      type: sequelize.QueryTypes.SELECT
    }).then(function (result) {
      // logger.info(result)
      if (result[0].counter === 1) {
        res.json({
          message: 'OK',
          data: {
            id: result[0].id
          }
        })
      } else {
        res.json({message: 'ERROR'})
      }
    })
  })

module.exports = router
