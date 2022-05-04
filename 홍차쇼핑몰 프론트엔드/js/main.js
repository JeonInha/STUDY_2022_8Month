$(function () {
  $('.notice_slider').slick({
    //slidesToShow: 1,
    arrows: false,
    autoplay: true,
    autoplaySpeed: 3000,
    vertical: true,
  })

  $('.main_slider').slick({
    slidesToShow: 1,
    arrows: false,
    autoplay: true,
    autoplaySpeed: 3000,
  })


  $('.mopen').on('click', function () {
    $('.gnb').toggleClass('on')
    $('.mopen').toggleClass('on')
  })

})
