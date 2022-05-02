// window.addEventListener('DOMContentLoaded', function() {
// 이 파일의 실행순서를 모든 컨텐츠가 로딩된 후로 함.
// document.querySelector('.header').style.display = 'none';
// })
// 이 길다란 명령을 제이쿼리로는 아래처럼 씀.
// $(function () {
//     $('.header').hide();
// })

$(function () {
    $('.main_slider').slick({
        arrows: false,
        autoplay: true,
        autoplaySpeed: 1000,
        vertical: true,
        // 1000 = 1s / 자바스크립트에서 시간을 쓸 땐 ms 단위로 씀
        dots: true
    })
})
// 슬릭: 우리가 만들어주지 않아도 div로 요소 하나하나를 싸고, class로 이름도 만들어둠.