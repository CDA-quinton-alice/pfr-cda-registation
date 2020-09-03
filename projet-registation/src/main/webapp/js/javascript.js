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



$('#div-connexion').click(function() {
	event.preventDefault();
	$.ajax({
		url: 'login',
		type: 'POST',
		data: {
			username: $('#loginInput').val(),
			password: $('#passwordInput').val()
		},
		success: function() {
			$('#loginInput').val('');
			$('#passwordInput').val('');
			// $('#loginMsgDiv').css('display', 'none');
			// $('#listLien').click();
			// infoUserEnCours();
		},
		error: function(responseHttp) {
			if (responseHttp.status == 401) {
				// $('#loginMsgDiv').addClass('alert-danger');
				// // $('#loginMsgDiv').removeClass('alert-primary');
				// $('#loginMsgText').text('mauvais login/mot de passe');
        // $('#loginMsgDiv').css('display', 'block');
        alert("Erreur authentification");
			} else {
				console.log(responseHttp);
			}
		},
	});
});
$('#loginMsgBtn').click(function() {
	$('#loginMsgDiv').css('display', 'none');
});

$('#co_ins').click(function() {
  $('#div-connection').css('display', 'block');
});

affichageBouttonSelonRole(utilisateurEnCours);