
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

var utilisateurEnCours;

$(document).ready(function() {

	utilisateurEnCours = JSON.parse(sessionStorage.getItem("utilisateur_en_cours"));

	$('#ajoutMsgBtn').click(function() {
		$('#ajoutMsgDiv').css('display', 'none');
	});

	$('#ajoutBtn').click(function(event) {
		event.preventDefault();
		var errors = false;

		var inputNom = $('input[name="nom"]');
		var inputPrenom = $('input[name="prenom"]');

		if (!inputNom.get(0).checkValidity()) {
			$('#nomMsg').text('le champ nom est obligatoire !');
			errors = true;
		}
		if (!inputPrenom.get(0).checkValidity()) {
			$('#prenomMsg').text('le champ prenom est obligatoire !');
			errors = true;
		}

		if (!errors) {
			$('#nomMsg').text('');
			$('#prenomMsg').text('');

			$.ajax({
				url: 'etudiants',
				type: 'POST',
				data: {
					nom: inputNom.val(),
					prenom: $('input[name="prenom"]').val(),
					mail: $('input[name="mail"]').val(),
					dateNaissance: $('input[name="dateNaissance"]').val()
				},
				success: function(response) {
					$('#ajoutMsgDiv').removeClass('alert-danger');
					$('#ajoutMsgDiv').addClass('alert-primary');
					$('#ajoutMsgText').text(response);

					$('input[name="nom"]').val('');
					$('input[name="prenom"]').val('');
					$('input[name="mail"]').val('');
					$('input[name="dateNaissance"]').val('');

				},
				error: function(responseHttp) {
					if (responseHttp.status == 403) {
						logout();
					} else {
						$('#ajoutMsgDiv').addClass('alert-danger');
						$('#ajoutMsgDiv').removeClass('alert-primary');
						$('#ajoutMsgText').text(responseHttp.responseText);
					}
				},
				beforeSend: function() {
					$('#ajoutMsgDiv').css('display', 'none');
				},
				complete: function() {
					$('#ajoutMsgDiv').css('display', 'block');
				}
			});
		}
	});

	$('#listLien').click(function() {
		$('#ajoutLien').removeClass('active');
		$('#loginLien').removeClass('active');
		$('#listLien').addClass('active');

		$('#ajoutDiv').css('display', 'none');
		$('#loginDiv').css('display', 'none');
		$('#listDiv').css('display', 'block');
	});

	$('#ajoutLien').click(function() {
		$('#listLien').removeClass('active');
		$('#loginLien').removeClass('active');
		$('#ajoutLien').addClass('active');

		$('#listDiv').css('display', 'none');
		$('#loginDiv').css('display', 'none');
		$('#ajoutDiv').css('display', 'block');
	});

	$('#loginLien').click(function() {
		$('#ajoutLien').removeClass('active');
		$('#listLien').removeClass('active');
		$('#loginLien').addClass('active');

		$('#listDiv').css('display', 'none');
		$('#ajoutDiv').css('display', 'none');
		$('#loginDiv').css('display', 'block');
	});

	$('#logoutLien').click(function() {
		logout();
	});

	$('#deleteBtn').click(function() {
		var idToDelete = $('#idToDelete').val();
		$.ajax({
			url: 'etudiants/' + idToDelete,
			type: 'DELETE',
			success: function(response) {
				$('#deleteMsgDiv').removeClass('alert-danger');
				$('#deleteMsgDiv').addClass('alert-primary');
				$('#deleteMsgText').text(response);
			},
			error: function(responseHttp) {
				if (responseHttp.status == 403) {
					logout();
				} else {
					$('#deleteMsgDiv').addClass('alert-danger');
					$('#deleteMsgDiv').removeClass('alert-primary');
					$('#deleteMsgText').text(responseHttp.responseText);
				}
			},
			beforeSend: function() {
				$('#modaleSuppression').modal('hide');
				$('#deleteMsgDiv').css('display', 'none');
			},
			complete: function() {
				$('#deleteMsgDiv').css('display', 'block');
			}
		});
	});

	$('#deleteMsgBtn').click(function() {
		$('#deleteMsgDiv').css('display', 'none');
	});

	$('#loginBtn').click(function() {
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
				$('#loginMsgDiv').css('display', 'none');
				$('#listLien').click();
				infoUserEnCours();
			},
			error: function(responseHttp) {
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
	});

	$('#loginMsgBtn').click(function() {
		$('#loginMsgDiv').css('display', 'none');
	});

	affichageBouttonSelonRole(utilisateurEnCours);
});


function afficherModaleSuppression(idEtudiant) {
	$('#idToDeleteText').text(idEtudiant);
	$('#idToDelete').val(idEtudiant);
	$('#modaleSuppression').modal('show');
}

function rendreLignCliquablePourDetail() {
	$('.etudiantTr td:not(:last-child)').click(function() {
		var idEnCours = $(this).parent().children('td:first-child').text();
		$('#idDetail').val(idEnCours);
		$.ajax({
			url: 'etudiants/' + idEnCours,
			type: 'GET',
			success: function(response) {
				$('#etudiantDetailDiv').css('display', 'block');
				$('#inputNom').val(response.nom);
				$('#inputprenom').val(response.prenom);
				$('#inputage').val(response.age);
				$('#inputmail').val(response.mail);
				$('#inputdateInsertion').val(new Date(response.dateInsertion).toLocaleDateString());
				$(window).scrollTop($('#etudiantDetailDiv').offset().top);
			},
			error: function(responseHttp) {
				if (responseHttp.status == 403) {
					logout();
				} else {
					$('#etudiantDetailDiv').css('display', 'none');
					$('#inputNom').val('');
					$('#inputprenom').val('');
					$('#inputage').val('');
					$('#inputmail').val('');
					$('#inputdateInsertion').val('');
				}
			}
		});
	});
}

function affichageBouttonSelonRole(utilisateurEnCours) {

	if (!utilisateurEnCours) {
		$('#loginLien').css('display', 'block').parent().css('margin-left', 'auto');
		$('#logoutLien').css('display', 'none').parent().css('margin-left', '');
		$('#ajoutLien').css('display', 'none');
		$('.actionTd').css('display', 'none');
	} else {
		$('#logoutLien').css('display', 'block').parent().css('margin-left', 'auto');
		$('#loginLien').css('display', 'none').parent().css('margin-left', '');
		rendreLignCliquablePourDetail();

		if ('ROLE_ADMIN' == utilisateurEnCours.role) {
			$('.actionTd').css('display', 'block');
			$('#ajoutLien').css('display', 'block');

		} else if ('ROLE_FORMATEUR' == utilisateurEnCours.role) {
			$('#ajoutLien').css('display', 'none');
			$('.actionTd').css('display', 'none');

		} else {
			logout();
		}
	}
}

function logout() {
	utilisateurEnCours = null;
	sessionStorage.removeItem("utilisateur_en_cours");
	$('#listLien').click();
	$('.etudiantTr td:not(:last-child)').off();
	$('#ajoutLien').css('display', 'none');
	$('.actionTd').css('display', 'none');
	$('#etudiantDetailDiv').css('display', 'none');
	$('#loginLien').css('display', 'block').parent().css('margin-left', 'auto');
	$('#logoutLien').css('display', 'none').parent().css('margin-left', '');
	$('#ajoutMsgDiv').css('display', 'none');
	$('#loginMsgDiv').css('display', 'none');
	$('#deleteMsgDiv').css('display', 'none');
}

function infoUserEnCours() {
	$.ajax({
		url: 'user',
		type: 'GET',
		success: function(reponse) {
			sessionStorage.setItem("utilisateur_en_cours", JSON.stringify(reponse));
			utilisateurEnCours = reponse;
			affichageBouttonSelonRole(utilisateurEnCours);
		},
		error: function(responseHttp) {
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