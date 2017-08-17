const mysql = require('mysql');

const database = require('../config/database.js')

exports.pool = mysql.createPool({
  connectionLimit: database.pool.max,
  host: database.host,
  user: database.user,
  password: database.password,
  database: database.database,
  debug: database.debug
});

// exports.pool = mysql.createPool(database);