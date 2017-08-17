let util = require('util')

function Foo(identity) {

  this.gender15 = function (identity) {
    identity = identity.toString()
    // console.log(identity[14])
    return identity[14] % 2 ? '男' : '女'
  }

  this.gender18 = function (identity) {
    identity = identity.toString()
    // console.log(identity[16])
    return identity[16] % 2 ? '男' : '女'
  }

  this.birthday15 = function (identity) {
    identity = identity.toString()
    return util.format(
      '19%s-%s-%s',
      identity.substring(6, 8),
      identity.substring(8, 10),
      identity.substring(10, 12)
    )
  }

  this.birthday18 = function (identity) {
    identity = identity.toString()
    return util.format(
        '%s-%s-%s',
        identity.substring(6, 10),
        identity.substring(10, 12),
        identity.substring(12, 14)
    )
  }

  this.calcCheckDigit = function (identity) {
    identity = identity.toString()
    var factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
    var parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
    var sum = 0;
    var ai = 0;
    var wi = 0;
    for (var i = 0; i < 17; i++) {
      ai = identity[i];
      wi = factor[i];
      sum += ai * wi;
    }
    var last = parity[sum % 11];
    return last;
  }

  this.repairIdCard = function (identity) {
    identity = identity.toString()
    if (/(^\d{17}$)/.test(identity)) {
      //console.log('convert: ' + identity)
      return identity + this.calcCheckDigit(identity)
    }
    if (/(^\d{18}$)/.test(identity)) {
      //console.log('rep18', identity)
      return identity.slice(0, 17) + this.calcCheckDigit(identity)
    }
  }

  this.convert = function (identity) {
    identity = identity.toString()
    if (/(^\d{15}$)/.test(identity)) {
      identity = this.repairIdCard(
        identity.slice(0, 6)
        + '19'
        + identity.slice(6, 15)
      )
      //console.log('convert end: ' + identity)
      return identity
    }
  }
}

module.exports = Foo;

// var identity15 = '230102810120103'
// var identity18 = '230102198101201037'
// foo = new Foo(),
// console.log('convert: ', foo.convert(identity15))
// console.log('gender15: ', foo.gender15(identity15))
// console.log('gender18: ', foo.gender18(identity18))
// console.log('birthday15: ', foo.birthday15(identity15))
// console.log('birthday18: ', foo.birthday18(identity18))
// console.log(foo.calcCheckDigit('230102198101201037'))
