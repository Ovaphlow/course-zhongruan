$(function () {
  $('#search').on('keypress', function (event) {
    if (event.keyCode == 13) {
      return
    }
    console.log($('#search').val())
  })
})