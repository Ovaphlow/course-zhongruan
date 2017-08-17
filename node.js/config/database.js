const config = {
  host: '127.0.0.1',
  user: 'root',
  password: '',
  database: 'cm_archieve',
  pool: {
    max: 50,
    min: 10,
    idle: 10000
  },
  debug: false,
  packSize: 20000,
  logging: false
}

module.exports = config
