const util = require('util');
const logger = require('tracer').colorConsole();

const columnIndex = require('../config/column-index');
const database = require('../config/database');
const importData = require('../service/import-data');
const sequelize = require('../util/sequelize');

const prepareDataService = function (sheet) {
  sheet.data.map((row, i) => {
    if (i == 0) return;
    if (!row[columnIndex.archive]) {
      logger.warn(
        '第 %d 行 (%s) 异常，跳过。',
        i,
        row[columnIndex.archive]);
      return;
    }
    let sqlCheck = 'select count(*) as counter, id, danganhao '
      + 'from dangan '
      + 'where danganhao = :danganhao '
      + 'limit 1';
    sequelize.query(sqlCheck, {
      replacements: {danganhao: String(sheet.data[i][columnIndex.archive])},
      type: sequelize.QueryTypes.SELECT
    }) .then(function (archive) {
      if (archive[0].counter != 0) {
        logger.warn('数据 (%s) 已存在，跳过。', row[columnIndex.archive]);
        return;
      }
      importData(row);
    });
  });
}

module.exports = prepareDataService;