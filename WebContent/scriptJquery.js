$(document).ready(function() {
	$("#nomId").blur(function() {// blur : perte de focus d'un champs
		$.ajax({
			url : 'ClimatisationAjax',
			type : 'GET',
			dataType : 'text',
			// On désire recevoir du HTML
			success : function(texte, statut) {
				$("#nbId").html(texte); // renvoyé
			}

		});

	});
});
