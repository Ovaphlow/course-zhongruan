const logger = require('tracer').colorConsole();
const xlsx = require('node-xlsx');

const prepare = require('../service/prepare-data');

const sheetService = function (file) {
  const sheets = xlsx.parse(file);
  logger.info('共有 %d 页', sheets.length);
  sheets.map((sheet, index) => {
    logger.info('页: %s --包含 %d 行', sheet.name, sheet.data.length);
    // sheet.data.map((row, index) => {
    //   if (!row[1]) {
    //     logger.warn('第 %d 行 (%s) 异常，跳过。', index, row[1]);
    //   } else {
    //   }
    // })
    prepare(sheet);
  })
};

module.exports = sheetService;