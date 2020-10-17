$(function(){
  $(".nav-menu ul.menu-area li>a").addClass("menuClose");

  var hederbtn = $(".header ul.pulldown li.drowerbtn>a");
  hederbtn.click(function(){
    if ($(".nav-menu ul.menu-area li>a").hasClass("menuOpen")) {
        $(".nav-menu").css('transform' , 'translateX(100%)')
        $(".nav-menu ul.menu-area li>a").removeClass("menuOpen").addClass("menuClose");
    } else {
        $(".nav-menu").css('transform' , 'translateX(50%)')
        $(".nav-menu ul.menu-area li>a").removeClass("menuClose").addClass("menuOpen");
    }
  });

// ブラウザバックに対しての対処
  var menubtn = $(".nav-menu ul.menu-area li>a");
  menubtn.click(function(){
     $(".nav-menu").css('display' , 'none')
});

  if ($(".nav-menu").css('display') == 'none') {
     $(".nav-menu").css('display' , 'block')
  }

});