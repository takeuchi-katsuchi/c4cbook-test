$(function(){
  var btn = $(".header ul.pulldown li.drowerbtn>a");
  btn.click(function(){
//if ($(".nav-menu").css('display') == 'none') {
if ($(".nav-menu").css('transform') == 'translateX(100%)') {
//    $(".nav-menu").css('display' , 'block')
    $(".nav-menu").css('transform' , 'translateX(100%)')
} else {
//    $(".nav-menu").css('display' , 'none')
    $(".nav-menu").css('transform' , 'translateX(50%)')
}
        });
});