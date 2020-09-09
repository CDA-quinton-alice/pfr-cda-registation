$(document).ready(function(){
    $("span#evenement").on('click',function(){
        console.log("Vous avezc cliqué sur un évènement.");
        return false;
    });
    
    $("#btnAujoudhui").on('click',function(e){
    	var annee = getNow().split("-")[2];
    	var mois = getNow().split("-")[1];
    	var myData = {
    		year:annee,
    		month:mois,
    		action:'n',
    	};
    	updateCalendar(myData);
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
    initCalendar();
})
function initCalendar(){
	var myData = {
			year: getNow().split("-")[2],
			month: getNow().split("-")[1],
			action: 'n'
	}
	updateCalendar(myData);
}

function updateCalendar(myData){
	$.ajax({
		url: '/evenement/accueil',
		type: "POST",
		data: myData,
		dataType : 'json',
        timeout : 100000,
        success : function(data) {
        	console.log(data);
            updateCalendarTitle(data);
            updateCalendarDays(data);
            return data;
        },
	});
}
function updateCalendarTitle(myData){
	var cur = myData.current;
    var year = cur.split("-")[0];
    var month = cur.split("-")[1];
    
    $("#calTitre").html(myData.titre+" "+year);
    $("#anneeActuel").val(year);
    $("#moisActuel").val(month);
}

function updateCalendarDays(myData){
	var calendrier = $("#calendarHere");
	calendrier.empty();
	//Récupération et formatage des jours
	var calValeurs = myData.calendrier;
	calValeurs = calValeurs.substring(1,calValeurs.length-1);
	calValeurs = calValeurs.split(",");
	var nbJours = calValeurs.length;
	var nbSemaines = nbJours/7;
	var tmpSemaine = -1;
	
	var table = $('<table>');
	table.attr('id','calendrier').addClass("table").addClass("evenement-table").addClass("table-bordered");
	var tbody = $("<tbody>");
	for(var i=0;i<nbSemaines;i++){
		var row =$("<tr>");
		for(var j=0;j<7;j++){
			var cel = $("<td>");
			var jour = i*7+j;
			var celJour = calValeurs[jour].split("-");;
			if(i==0){
				var span1 = $("<span>").addClass("cellule-jour").text(celJour[0]);
				var span2 = $("<span>").addClass("cellule-jour").text(celJour[1]);
				
				
				cel.append(span1);
				cel.append(span2);
			}else{
				var span2 = $("<span>").addClass("cellule-jour").text(celJour[1]);
				
				
				cel.append(span2);
			}
			row.append(cel);
		}
		tbody.append(row);
	}
	table.append(tbody);
	calendrier.append(table);
	
}

function getNow(){
	var today = new Date();
	var dd = today.getDate();

	var mm = today.getMonth()+1; 
	var yyyy = today.getFullYear();
	if(dd<10) 
	{
	    dd='0'+dd;
	} 

	if(mm<10) 
	{
	    mm='0'+mm;
	} 
	today = dd+'-'+mm+'-'+yyyy;
	return today;
}