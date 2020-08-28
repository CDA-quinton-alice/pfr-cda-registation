$(document).ready(function()
{
	$(".boutonSupprimer").click(function(){
		var element = $(this);
		var id = element.attr("livreId");
		$("#inputSupprimer").val(id);
	});
	
	$(".boutonAnnulerCommande").click(function(){
		var element = $(this);
		var id = element.attr("commandeId");
		$("#inputAnnulerCommande").val(id);
	});
	
	$(".boutonRefuser").click(function(){
		var element = $(this);
		var id = element.attr("utilisateurLogin");
		$("#inputRefuser").val(id);
	});
	
});

function afficherModaleSuppression(idLivre){
	$('#inputSupprimer').val(idLivre);
	$('#supprimerLivreModal').modal('show');
}
