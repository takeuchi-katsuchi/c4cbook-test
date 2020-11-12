$(function() {

	var windowWidth = window.innerWidth;

	$(".header ul.submenu").addClass("menuClose");
	$(".header ul.pulldown li.slidebtn>a").addClass("menuClose");

	$(".header ul.pulldown li.slidebtn>a").each(function() {
		var allsubmenu = $(".header ul.submenu");
		var btn1 = $(this);
		var submenu = $(this).next();
		btn1.click(function() {
			if ($(this).hasClass("menuOpen")) {
				$(this).removeClass("menuOpen").addClass("menuClose");
				$(submenu).slideUp("fast");
			} else {
				$(allsubmenu).slideUp("fast");
				$(".header ul.pulldown li.slidebtn>a").removeClass("menuOpen").addClass("menuClose");
				$(submenu).slideDown("fast");
				$(btn1).removeClass("menuClose").addClass("menuOpen");
			}
			return false;
		});
	});

	$(".header ul.drowermenu").addClass("menuClose");
	$(".header ul.pulldown li.drowerbtn>a").addClass("menuClose");

	$(".header ul.pulldown li.drowerbtn>a").each(function() {
		var alldrowermenu = $(".header ul.drowermenu");
		var btn2 = $(this);
		var drowermenu = $(this).next();
		btn2.click(function() {
			if ($(this).hasClass("menuOpen")) {
				$(this).removeClass("menuOpen").addClass("menuClose");
				$(drowermenu).slideUp("fast");
			} else if ($(this).hasClass("menuClose") && windowWidth < 768)  {
				$(alldrowermenu).slideUp("fast");
				$(".header ul.pulldown li.drowerbtn>a").removeClass("menuOpen").addClass("menuClose");
				$(alldrowermenu).slideDown("fast");
				$(btn2).removeClass("menuClose").addClass("menuOpen");
			}
			return false;
		})
	});

	$(document).ready(function() {
		// ページ読み込み時に実行したい処理
		if (location.pathname != "/c4cbook/top") {
			$('.use_top').css("display", "none");
			$('.slidebtn').css("display", "none");
			$('.menu').css("padding-left", "160px");
		}
	});
});
