const Sequelize = require('sequelize');

const database = require('../config/database')

let sequelize = new Sequelize(
  database.database,
  database.user,
  database.password,
  {
    host: database.host,
    dialect: 'mysql',
    pool: {
      max: database.pool.max,
      min: database.pool.min,
      idle: database.pool.idle
    },
    logging: database.logging
  }
);

module.exports = sequelize;