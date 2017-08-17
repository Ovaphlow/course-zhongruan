const logger = require('tracer').colorConsole();

const columnIndex = require('../config/column-index');
const sequelize = require('../util/sequelize');

const Foo = require('../util/identity')

const importDataService = function (row) {
  let identity18 = ''
    , gender = ''
    , birthday = ''
  foo = new Foo()
  if (row[columnIndex.identity].length == 15) {
    identity18 = foo.convert(row[columnIndex.identity])
    // logger.debug(identity18)
  } else {
    identity18 = row[columnIndex.identity]
  }
  if (row[columnIndex.gender]) {
    gender = row[columnIndex.gender]
  } else {
    if (identity18.length == 18) {
      gender = foo.gender18(identity18)
      // logger.debug(gender)
    } else {
      gender = ''
    }
  }
  if (row[columnIndex.birthday]) {
    birthday = row[columnIndex.birthday]
  } else {
    if (identity18.length == 18) {
      birthday = foo.birthday18(identity18)
      // logger.debug(birthday)
    } else {
      gender = ''
    }
  }
  let sql = 'insert into dangan set '
    + 'danganhao = :archive, '
    + 'shenfenzheng = :identity, '
    + 'xingming = :name, '
    + 'xingbie = :gender, '
    + 'chushengriqi = :birthday, '
    + 'lianxifangshi = :contact, '
    + 'beizhu = :remark';
  sequelize.query(sql, {
    replacements: {
      archive: String(row[columnIndex.archive]),
      identity: identity18,
      name: String(row[columnIndex.name]) || '',
      gender: gender,
      birthday: birthday,
      contact: String(row[columnIndex.contact]) || '',
      remark: String(row[columnIndex.remark]) || ''
    },
    type: sequelize.QueryTypes.INSERT
  }) .then(function (result) {
    // logger.info(result);
    if (result) {
      logger.info('保存成功 (%s // %s)', result, row[columnIndex.archive]);
    }
  });
}

module.exports = importDataService;