 $(document).ready(function()
{
	 $("#enregistrer").prop("disabled",true);
	 
	 $("#formLogin").focusout(function(){
    	var login = $("#formLogin").val();
    	if(login != ""){
    		$.ajax({
        		type: "POST",
        		url: "loginTest",
        		dataType: "json",
        		data:{"login":login},
        		complete: function(xhr, status){
        			if(status == 'error' || !xhr.responseText){
        				$.when($("#valLogin").val(0)).then(checkValidationInscription());
        				$("#errorLoginIns").html("Ce login est d&eacute;j&agrave; pris.")
        			}else{
        				$.when($("#valLogin").val(1)).then(checkValidationInscription());
        				$("#errorLoginIns").html("");
        			}
        		}
        	}); 
    	}
    });
    
    $("#formMdp").focusout(function(){
    	var mdp = $("#formMdp").val();
    	
    	if(mdp==""||mdp.length<3){
    		$("#valMdp").val(0);
    		$("#errorMdp").html("Mot de passe vide ou incorrect : 3 caract&egrave;res ou plus.");
    	}else{
    		$("#valMdp").val(1);
    		$("#errorMdp").html("");
    	}
    	checkValidationInscription();
    });
    
    $("#formMdpConf").focusout(function(){
    	var mdp = $("#formMdp").val();
    	var mdpConf = $("#formMdpConf").val();
    	
    	if(mdpConf==""||mdpConf.length<3){
    		$("#valMdpConf").val(0);
    		$("#errorMdpConf").html("Mot de passe vide ou incorrect : 3 caract&egrave;res ou plus.");
    	}else if(mdpConf != mdp) {
    		$("#valMdpConf").val(0);
    		$("#errorMdpConf").html("Les mots de passes doivent &ecirc;tre identique !");
    	}else{
    		$("#valMdpConf").val(1);
    		$("#errorMdpConf").html("");
    	}
    	checkValidationInscription();
    });
    
    $("#formNom").focusout(function(){
    	var nom = $("#formNom").val();
    	
    	if(nom==""||nom.length<3){
    		$("#valNom").val(0);
    		$("#errorNom").html("Nom incorrect : 3 caract&egrave;res ou plus.");
    	}else{
    		$("#valNom").val(1);
    		$("#errorNom").html("");
    	}
    	checkValidationInscription();
    });
    
    $("#formPrenom").focusout(function(){
    	var prenom = $("#formPrenom").val();
    	
    	if(prenom==""||prenom.length<3){
    		$("#valPrenom").val(0);
    		$("#errorPrenom").html("Pr&eacute;nom incorrect : 3 caract&egrave;res ou plus.");
    	}else{
    		$("#valPrenom").val(1);
    		$("#errorPrenom").html("");
    	}
    	checkValidationInscription();
    });
    
    $("#formAdresse").keypress(function(){
    	var adr = $("#formAdresse").val();
    	
    	if(adr==""||adr.length<2){
    		$("#valAdresse").val(0);
    		$("#errorAdresse").html("Adresse incorrect : 3 caract&egrave;res ou plus.");
    	}else{
    		$("#valAdresse").val(1);
    		$("#errorAdresse").html("");
    	}
    	checkValidationInscription();
    });
    
    $( "#formcontainer" ).submit(function(e) {
        var nom = $('#login').val();
        var mdp = $('#motdepasse').val();
        if(nom == ""){
          e.preventDefault();
          $('#errorLogin').html("<p>Un des champs est vide !</p>");
        }else if(mdp == ""){
          e.preventDefault();
          $('#errorLogin').html("<p>Un des champs est vide !</p>");
        }else{
            $.ajax({
                type: "POST",
                url: "./connexion",
                dataType: "json",
                data: {"login": nom,"motdepasse": mdp},
                error : function(){
                     $('#errorLogin').html("<p>Veuillez entrer un login correct!</p>");
                }
            });
        }
    });
    
    $("#modalCommande").click(function(){
    	var id = $("#modalCommande").attr("commandeId");
    	$("#commandeCancel").val(id);
    });
});
 
function checkValidationInscription(){
	if($("#valLogin").val()==1&&
			$("#valMdp").val()==1&&
			$("#valMdpConf").val()==1&&
			$("#valNom").val()==1&&
			$("#valPrenom").val()==1&&
			$("#valAdresse").val()==1){

		 $("#enregistrer").prop("disabled",false);
	}else{
		 $("#enregistrer").prop("disabled",true);
	}
}