$(function () {
    $('.main_slider').slick({
        arrows: false,
        autoplay: true,
        autoplaySpeed: 3000,
        // 1000 = 1s / 자바스크립트에서 시간을 쓸 땐 ms 단위로 씀
        dots: true
    })

    $('.menu_content>li').slick({
        autoplay: false,
        slidesToShow: 4,
        arrows: false,
        button: false,
    })

    $('.subway_menu i.menu_left').on('click', function () {
        $('.menu_content>li').slick('slickPrev')
    })

    $('.subway_menu i.menu_right').on('click', function () {
        $('.menu_content>li').slick('slickNext')
    })

    // ///////////////////////////////////////////////////////

    $('.menu_link>li:nth-child(1)').addClass('on')
    $('.menu_content>li:nth-child(1)').addClass('on')

    $('.menu_link>li').on('click', function () {
        // console.log($(this).index())
        $(this).addClass('on').siblings().removeClass('on')
        var idx = $(this).index();
        $('.menu_content>li').eq(idx).addClass('on').siblings().removeClass('on');
    })
    //////////////////////////////////////////////

})