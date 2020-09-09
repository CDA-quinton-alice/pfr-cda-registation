$(document).ready(function(){
    $("span#evenement").on('click',function(){
        console.log("Vous avezc cliqué sur un évènement.");
        return false;
    });
    
    $("#actionGauche").on('click', function(e){
    	e.preventDefault();
    	var annee = $("#anneeActuel").val();
    	var mois = $("#moisActuel").val();
    	var myData = {
    		year:annee,
    		month:mois,
    		action:'p',
    	};
    	updateCalendar(myData);
    });
    
    $("#actionDroite").on('click', function(e){
    	e.preventDefault();
    	var annee = $("#anneeActuel").val();
    	var mois = $("#moisActuel").val();
    	var myData = {
    		year:annee,
    		month:mois,
    		action:'s',
    	};
    	updateCalendar(myData);
    });
})

function updateCalendar(myData){
	$.ajax({
		url: '/evenement/accueil',
		type: "POST",
		data: myData,
		dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            var cur = data.current;
            var year = cur.split("-")[0];
            var month = cur.split("-")[1];
            
            $("#calTitre").html(data.titre);
            $("#anneeActuel").val(year);
            $("#moisActuel").val(month);
        },
	});
}