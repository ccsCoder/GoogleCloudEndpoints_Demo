/**
 * 
 */	

$(document).ready(function() {
	//attach click listeners.
	$("#listContactsButton").on("click",showAllContacts);
	$("#createNewContactButton").on("click",createNewContact);
});

function showLoader(nextToThis) {
	var elem = document.createElement("div");
	$(elem).attr("id","loaderGIF");
	$(elem).addClass("overlay");

	console.debug(elem);
	$(nextToThis).append(elem);

};

function hideLoader() {
	$("#loaderGIF").remove();
}

function createNewContact(event) {
	showLoader($("#createNewContactButton"));
}

function showAllContacts(event) {
	showLoader($("#listContactsButton"));
	
}