$(function() {
    // 인기 검색에 글자 롤링 애니메이션
    const $words = $(".popular-word ul li");
    const len = $words.length;
    let index = 0;
    const textInTimer = 3000;
    const textOutTimer = 2800;

    // 함수 선언
    function animationText() {
        $words.removeClass("text-in text-out");
        $words.eq(index).addClass("text-in");

        // 2.8초에 한번씩 실행하는 함수
        setTimeout(function() {
            $words.eq(index).addClass("text-out");
        }, textOutTimer);

        // 3초에 한번씩 실행하는 합수
        setTimeout(function() {
            // 인덱스번호가 1, 2, 3, 4, 5, 6, 7, 8, 9, 10이 되면 다시 0으로 초기화
            index = (index + 1) % len;
            // 자기 자신 함수를 호출(재귀함수)
            animationText();
        }, textInTimer);
    }
    // 함수 호출
    animationText();

    let total_menu_sw = 0;
    $(".total-menu").click(function() {
        if(total_menu_sw == 0) {
            total_menu_sw = 1;
            $(".total-menu-area").show();
            $(".total-menu-area img").fadeIn();
        }else {
            total_menu_sw = 0;
            $(".total-menu-area").hide();
            $(".total-menu-area img").hide();
        }
    });

    // .s1 main swiper
    let swiper1 = new Swiper(".swiper1", {
        loop:true,
        autoplay: {
            delay: 4000
        },
    });
    let swiper2 = new Swiper(".swiper2", {
        loop:true,
        pagination: {
            el: ".s1 .swiper-pagination",
            type: "fraction",
        },
        navigation: {
            prevEl: ".s1 .swiper-button-prev",
            nextEl: ".s1 .swiper-button-next"
        }
    });
    swiper1.controller.control = swiper2;
    swiper2.controller.control = swiper1;

    // .s2 swiper-slide
    let swiper3 = new Swiper(".swiper3", {
        loop: false,
        slidesPerView: 2.7,
        spaceBetween: 24,
        navigation: {
            prevEl: ".s2 .swiper-button-prev",
            nextEl: ".s2 .swiper-button-next"
        }
    });

    // .s3 swiper-slide
    let swiper4 = new Swiper(".swiper4", {
        loop: false,
        slidesPerView: 1,
        navigation: {
            prevEl: ".s3 .swiper-button-prev",
            nextEl: ".s3 .swiper-button-next"
        }
    });
    let swiper5 = new Swiper(".swiper5", {
        loop: false,
        slidesPerView: 4.24,
        spaceBetween: 12
    });

    let swiper6 = new Swiper(".swiper6", {
        loop: true,
        spaceBetween: 40,
        pagination: {
                el: ".s3 .swiper-pagination",
        },
    });
    // .s4 swiper slide
    let swiper7 = new Swiper(".swiper7", {
        loop: true,
        slidesPerView: 2,
        spaceBetween: 50,
        navigation: {
            prevEl: ".s4 .swiper-button-prev",
            nextEl: ".s4 .swiper-button-next"
        }
    });

    let swiper8 = new Swiper(".swiper8", {

        loop: true,
        slidesPerView: 5,
        centeredSlides: true,
        spaceBetween: 50,
        centeredSlides: true,
    });

    // footer family site
    $(".family > a").click(function(e) {
        e.preventDefault();
        $(".family-list").slideToggle();
        $(this).find("span").toggleClass("active");
    });


    // 글쓰기, 읽기 textarea 높이 자동 조절
    $(document).ready(function() {
      $("table").on("keyup", "textarea", function(e) {
        $(this).css("height", "auto");
        $(this).height(this.scrollHeight);
      });
      $("table").find("textarea").keyup();
    })
});