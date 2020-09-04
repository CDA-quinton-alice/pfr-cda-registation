/*Menu-toggle*/
$("#menu-toggle").click(function(e) {
	e.preventDefault();
	$("#wrapper").toggleClass("active");
});

$("#co_ins").mouseover(function() {
	$("#co_ins").toggleClass("active");
});

$("#co_ins").mouseout(function() {
	$("#co_ins").toggleClass("active");
});

$('#loginBtn').click(function() {
	event.preventDefault();
	$.ajax({
		url : 'login',
		type : 'POST',
		data : {
			username : $('#loginInput').val(),
			password : $('#passwordInput').val()
		},
		success : function() {
			$('#loginInput').val('');
			$('#passwordInput').val('');
			infoUserEnCours();
		},
		error : function(responseHttp) {
			if (responseHttp.status == 401) {
				$('#loginMsgText').text('mauvais login/mot de passe');
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

// affichageBouttonSelonRole(utilisateurEnCours);

function infoUserEnCours() {
	$.ajax({
		url : 'user',
		type : 'GET',
		success : function(reponse) {
			sessionStorage.setItem("utilisateur_en_cours", JSON.stringify(reponse));
			utilisateurEnCours = reponse;
			affichageBouttonSelonRole(utilisateurEnCours);
		},
		error : function(responseHttp) {
			if (responseHttp.status == 401) {
				$('#loginMsgDiv').addClass('alert-danger');
				$('#loginMsgDiv').removeClass('alert-primary');
				$('#loginMsgText').text('mauvais login/mot de passe');
				$('#loginMsgDiv').css('display', 'block');
			} else {
				console.log(responseHttp);
			}
		},
	});
}