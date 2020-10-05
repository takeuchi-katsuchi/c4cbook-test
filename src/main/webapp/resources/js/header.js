$(function(){
  $(".header ul.pulldown li.slidebtn>a").addClass("close");
  $(".header ul.submenu").addClass("close");

  $(".header ul.pulldown li.slidebtn>a").each(function(){
  var allsubmenu = $(".header ul.submenu");
  var btn = $(this);
  var submenu = $(this).next();
  btn.click(function(){
    if($(this).hasClass("open")){
            $(this).removeClass("open").addClass("close");
            $(submenu).slideUp("fast");
    }else{
            $(allsubmenu).slideUp("fast");
      $(".header ul.pulldown li.slidebtn>a").removeClass("open").addClass("close");
            $(submenu).slideDown("fast");
            $(btn).removeClass("close").addClass("open");
        }
        return false;
        });
  });
});