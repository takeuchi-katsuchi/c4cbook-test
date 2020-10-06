$(function(){
  $(".nav-menu ul.menu-area li>a").addClass("close");

  var hederbtn = $(".header ul.pulldown li.drowerbtn>a");
  hederbtn.click(function(){
    if ($(".nav-menu ul.menu-area li>a").hasClass("open")) {
        $(".nav-menu").css('transform' , 'translateX(100%)')
        $(".nav-menu ul.menu-area li>a").removeClass("open").addClass("close");
    } else {
        $(".nav-menu").css('transform' , 'translateX(50%)')
        $(".nav-menu ul.menu-area li>a").removeClass("close").addClass("open");
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