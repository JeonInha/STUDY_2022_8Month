$(function () {

    //////////////////////////////////////////
    $('.top_banner i').on('click', function () {
        $('.top_banner').slideUp(300);
    })

    $('.main_slider').on('init reInit afterChange', function () {
        // console.log('변했네');
        let current = $('.slick-current');
        current.addClass('on').siblings().removeClass('on');
    })


    $('.main_slider').slick({
        arrows: false,
        dots: true,
        autoplay: true,
        pauseOnHover: false,
        pauseOnFocus: false,
    })

    $('.movie .dec i:nth-of-type(1)').on('click', function () {
        $('.movie video').trigger('play')
    })

    $('.movie .dec i:nth-of-type(2)').on('click', function () {
        $('.movie video').trigger('pause')
    })




    $('.m1').YTPlayer({
        videoURL: 'https://youtu.be/eOOsAeOx5a0',
        containment: '.bgmv',
        autoPlay: true,
        mute: true,
        startAt: 0.5,
        opacity: 1,
        loop: true,
        showControls: false,
        playOnlyIfVisible: true
    });

    $('.m1').YTPApplyFilters({
        grayscale: 70,
        brightness: 50,
    })

    $('.bgmv i:nth-of-type(1)').on('click', function () {
        $('.m1').YTPPlay()
    })

    $('.bgmv i:nth-of-type(2)').on('click', function () {
        $('.m1').YTPPause()
    })
    /////////////////////////////////////////

    $('.product_slider').slick({
        slidesToShow: 5,
        centerMode: true,
        arrows: false,
        dots: true,
        autoplay: true,


        responsive: [
            {
              breakpoint: 768,
              settings: {
                slidesToShow: 1,
                centerMode: false,
                autoplay: false,
              }
            }
            // You can unslick at a given breakpoint now by adding:
            // settings: "unslick"
            // instead of a settings object
          ]


    });

    $('.product_list i.s_left').on('click', function () {
        $('.product_slider').slick('slickPrev')
    })

    $('.product_list i.s_right').on('click', function () {
        $('.product_slider').slick('slickNext')
    })

    //////////////////////////////////////
    $('.tab_link>li:nth-child(1)').addClass('on')
    $('.tab_content>li:nth-child(1)').addClass('on')

    $('.tab_link>li').on('click', function () {
        // console.log($(this).index())
        $(this).addClass('on').siblings().removeClass('on')
        var idx = $(this).index();
        $('.tab_content>li').eq(idx).addClass('on').siblings().removeClass('on');
    })

    $('.footer #link').on('change', function () {
        var link = $(this).val();
        if (link) window.open(link)
    })

    $('.mbtn').on('click', function () {
        $('nav').toggleClass('on')
        $(this).toggleClass('is-active')
    })

})