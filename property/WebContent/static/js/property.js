function get_property(id) {
	var div = document.getElementById('description_form');
	var url = 'http://imbi.ld.ttu.ee:7500/property/propertyservice?id=' + id;
	
	var xmlHttp = null;
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open( 'GET', url, false );
    xmlHttp.send( null );
    
    var property = JSON.parse(xmlHttp.responseText);
    
	div.style.visibility = 'visible';
	
	document.forms['description_form'].property_id.value = property.propertyID;
	document.forms['description_form'].description.value = property.description;
}

function hide_description_form() {
	var div = document.getElementById('description_form');
	div.style.visibility = 'hidden';
}