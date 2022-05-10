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
        loop : true,
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



})