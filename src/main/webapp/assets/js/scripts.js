/*
Theme Name: IAMX
Author: Trendy Theme
Author URL: trendytheme.net
*/

/*
    = Preloader
    = Animated scrolling / Scroll Up
    = Full Screen Slider
    = Sticky Menu
    = Back To Top
    = Countup
    = Progress Bar
    = More skill
    = Shuffle
    = Magnific Popup
    = Vidio auto play
    = Fit Vids
    = Google Map

*/

jQuery(function ($) {

    'use strict';

    /* ---------------------------------------------- /*
     * Preloader
    /* ---------------------------------------------- */

    $(window).ready(function() {
        $('#pre-status').fadeOut();
        $('#tt-preloader').delay(350).fadeOut('slow');
    });




    // -------------------------------------------------------------
    // Animated scrolling / Scroll Up
    // -------------------------------------------------------------

    (function () {
        $('a[href*=#]').bind("click", function(e){
            var anchor = $(this);
            $('html, body').stop().animate({
                scrollTop: $(anchor.attr('href')).offset().top
            }, 1000);
            e.preventDefault();
        });
    }());



    // -------------------------------------------------------------
    // Full Screen Slider
    // -------------------------------------------------------------
    (function () {
        $(".tt-fullHeight").height($(window).height());

        $(window).resize(function(){
            $(".tt-fullHeight").height($(window).height());
        });

    }());


    // -------------------------------------------------------------
    // Sticky Menu
    // -------------------------------------------------------------

    (function () {
        $('.header').sticky({
            topSpacing: 0
        });

        $('body').scrollspy({
            target: '.navbar-custom',
            offset: 70
        })
    }());




    // -------------------------------------------------------------
    // Back To Top
    // -------------------------------------------------------------

    (function () {
        $(window).scroll(function() {
            if ($(this).scrollTop() > 100) {
                $('.scroll-up').fadeIn();
            } else {
                $('.scroll-up').fadeOut();
            }
        });
    }());


    // -------------------------------------------------------------
    // Countup
    // -------------------------------------------------------------
    $('.count-wrap').bind('inview', function(event, visible, visiblePartX, visiblePartY) {
        if (visible) {
            $(this).find('.timer').each(function () {
                var $this = $(this);
                $({ Counter: 0 }).animate({ Counter: $this.text() }, {
                    duration: 2000,
                    easing: 'swing',
                    step: function () {
                        $this.text(Math.ceil(this.Counter));
                    }
                });
            });
            $(this).unbind('inview');
        }
    });


    // -------------------------------------------------------------
    // STELLAR FOR BACKGROUND SCROLLING
    // -------------------------------------------------------------

    $(window).load(function() {

        if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
         
        }else {
            $.stellar({
                horizontalScrolling: false,
                responsive: true
            });
        }

    });


    // -------------------------------------------------------------
    // WOW JS
    // -------------------------------------------------------------

    (function () {

        new WOW({

            mobile:  false

        }).init();

    }());
    // -------------------------------------------------------------
    // Send mail
    // -------------------------------------------------------------

    $("#error-mail-msg").hide();
    $("#success-mail-msg").hide();
    $(".pulse").hide();

    $('#sendEmail').click(function(event){

        $("#error-mail-msg").hide();
        $("#success-mail-msg").hide();

        $(".pulse").show();
        var errMsg = "";

        var mailArgs = {
    		   name: $("#name").val(),
    		   email: $("#email").val(),
    		   subject: $("#subject").val(),
    		   message: $("#message").val(),
       };

        if (!mailArgs.name) {
            errMsg += "Името е задължително поле.<br />";
        }
        if (!mailArgs.email) {
            errMsg += "Email е задължително поле.<br />";
        }
        if (!mailArgs.subject) {
            errMsg += "Относно е задължително поле.<br />";
        }
        if (!mailArgs.message) {
            errMsg += "Съобщение е задължително поле.<br />";
        }

        if (errMsg != "") {
            $("#error-mail-msg").show();
            $("#err-content").html(errMsg);
            $(".pulse").hide();
            return;
        }

       $.post('rest', {
    	   name: mailArgs.name,
		   email: mailArgs.email,
		   subject: mailArgs.subject,
		   message: mailArgs.message,
   		
	   	}, function() {
           $("#success-mail-msg").show();
           $(".pulse").hide();
	   	}).fail(function(response) {
           alert('Error: ' + response.responseText);
           $(".pulse").hide();
       });
        
    });
    
    // -------------------------------------------------------------
    // Google Map
    // -------------------------------------------------------------

    (function () {
        var myLatlng = new google.maps.LatLng(42.764418, 26.727684);

            var styles = [
                {
                    featureType: "landscape",
                    stylers: [
                        { color: '#f7f7f7' }
                    ]
                },{
                    featureType: "natural",
                    stylers: [
                        { hue: '#00ffe6' }
                    ]
                },{
                    featureType: "road",
                    stylers: [
                        { hue: '#fff' },
                        { saturation: -70 }
                    ]
                },{
                    featureType: "building",
                    elementType: "labels",
                    stylers: [
                        { hue: '' }
                    ]
                },{
                    featureType: "poi", //points of interest
                    stylers: [
                        { hue: '' }
                    ]
                }
            ];

            var mapOptions = {
                zoom: 15,
                scrollwheel: false,
                center: myLatlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP,
                disableDefaultUI: true,
                styles: styles,
                draggable: false
            }
            var map = new google.maps.Map(document.getElementById('mapCanvas'), mapOptions);

            var marker = new google.maps.Marker({
                position: myLatlng,
                map: map,
                animation: google.maps.Animation.DROP,
                title: 'Hello World!'
            });

            var contentString = '' +
                    '' +
                    '';

            var infowindow = new google.maps.InfoWindow({
                content: contentString
            });

            google.maps.event.addListener(marker, 'click', function () {
                infowindow.open(map, marker);
            });

    }());
});


function showWineInfo (args) {
	$('#' + args.wineType).hide();
	$('#' + args.wineType + "-info").show();

	
	//$('#' + args.wineType + "-info").delay(20300).fadeOut('slow');

	//$('#' + args.wineType).delay(21000).fadeIn('slow');
}

function hideWineInfo (args) {
	$('#' + args.wineType + "-info").hide();
	$('#' + args.wineType).show();
}


$('.info').hide();

