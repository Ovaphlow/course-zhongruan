const logger = require('tracer').colorConsole();

const sequelize = require('../util/sequelize');

const checkExistsService = function (row) {
  return new Promise(function (resolve, reject) {
    if (row) {
      logger.trace(row);
      resolve(1);
    } else {
      reject(0);
    }
  })
}

module.exports = checkExistsService;