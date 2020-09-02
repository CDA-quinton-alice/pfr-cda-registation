	/*Menu-toggle*/
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("active");
});

$("#co_ins").mouseover(function(){
  $("#co_ins").toggleClass("active");
});

$("#co_ins").mouseout(function(){
  $("#co_ins").toggleClass("active");
});