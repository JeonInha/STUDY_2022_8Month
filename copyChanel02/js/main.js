$(function () {

    //////////////////////////////////////////
    $('.top_banner i').on('click', function () {
        $('.top_banner').slideUp(300);
    })

    $('.main_slider').on('init reInit afterChange', function () {
        console.log('변했네');
        let current = $('.slick-current');
        current.addClass('on').siblings().removeClass('on');
    })


    $('.main_slider').slick({
        arrows: false,
        dots: true,
        autoplay: true,
        pauseOnHover: false,
        pauseOnFocus: false,
    });





    /////////////////////////////////////////

})