$(function(){
  $(".header ul.pulldown li.slidebtn>a").addClass("menuClose");
  $(".header ul.submenu").addClass("menuClose");

  $(".header ul.pulldown li.slidebtn>a").each(function(){
  var allsubmenu = $(".header ul.submenu");
  var btn = $(this);
  var submenu = $(this).next();
  btn.click(function(){
    if($(this).hasClass("menuOpen")){
            $(this).removeClass("menuOpen").addClass("menuClose");
            $(submenu).slideUp("fast");
    }else{
            $(allsubmenu).slideUp("fast");
      $(".header ul.pulldown li.slidebtn>a").removeClass("menuOpen").addClass("menuClose");
            $(submenu).slideDown("fast");
            $(btn).removeClass("menuClose").addClass("menuOpen");
        }
        return false;
        });
  });
});


$(document).ready( function(){
// ページ読み込み時に実行したい処理
 if (location.pathname != "/c4cbook/top") {
	 $('.use_top').css("display", "none");
}
});