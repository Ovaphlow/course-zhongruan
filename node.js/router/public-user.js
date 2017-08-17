const express = require('express')
const logger = require('tracer').colorConsole()

const sequelize = require('../util/sequelize')

const router = express.Router()

router.route('/checkIdentity')
  .post(function (req, res) {
    logger.info('检查身份证是否有效')
    let sql = 'select id, shenfenzheng, count(*) as counter '
      + 'from dangan '
      + 'where shenfenzheng = :identity '
      + 'limit 1'
    sequelize.query(sql, {
      replacements: {identity: req.body['identity']},
      type: sequelize.QueryTypes.SELECT
    }).then(function (archive) {
      logger.debug(archive);
      if (archive[0].counter == 1) {
        res.json({message: 'OK', id: archive[0].id})
      } else {
        res.json({message: 'ERROR', error: 'DUPLICATED_IDENTITY'})
      }
    })
  })

router.route('/info').post(function (req, res) {
    // logger.info('档案信息')
    // logger.debug(req.body)
    const sql = `
    select
      a.id as archive_id
      , shenfenzheng as identity
      , danganhao as archive
      , f.id as file_id
      , wenjianming as file_name
    from
      dangan as a
      , wenjian as f
    where
      a.id = f.aid
        and a.id = :id `
    sequelize.query(sql, {
      replacements: {id: req.body['id']},
      type: sequelize.QueryTypes.SELECT
    }).then(function (archive) {
      // logger.debug(archive)
      res.json(archive)
    })
  })

router.route('/pic').post(function (req, res) {
  const sql = `
  select
    a.id as archive_id
    , danganhao as archive
    , f.id as file_id
    , wenjianming as file_name
  from
    dangan as a
    , wenjian as f
  where
    a.id = f.aid
      and f.id = :file_id
      and a.id = :archive_id
  limit 1`
  sequelize.query(sql, {
    replacements: {
      file_id: req.body['file_id']
      , archive_id: req.body['archive_id']
    },
    type: sequelize.QueryTypes.SELECT
  }).then(function (picture) {
    // logger.debug(picture)
    res.json(picture)
  })
})

router.route('/prev').post(function (req, res) {
  const sql = `
  select
    a.id as archive_id
    , danganhao as archive
    , f.id as file_id
    , wenjianming as file_name
  from
    dangan as a
    , wenjian as f
  where
    a.id = f.aid
      and f.id < :file_id
      and a.id = :archive_id
  order by
    f.id desc
  limit 1`
  sequelize.query(sql, {
    replacements: {
      file_id: req.body['file_id']
      , archive_id: req.body['archive_id']
    }
    , type: sequelize.QueryTypes.SELECT
  }).then(function (picture) {
    res.json(picture)
  })
})

router.route('/next').post(function (req, res) {
  const sql = `
  select
    a.id as archive_id
    , danganhao as archive
    , f.id as file_id
    , wenjianming as file_name
  from
    dangan as a
    , wenjian as f
  where
    a.id = f.aid
      and f.id > :file_id
      and a.id = :archive_id
  limit 1`
  sequelize.query(sql, {
    replacements: {
      file_id: req.body['file_id']
      , archive_id: req.body['archive_id']
    }
    , type: sequelize.QueryTypes.SELECT
  }).then(function (picture) {
    res.json(picture)
  })
})


module.exports = router