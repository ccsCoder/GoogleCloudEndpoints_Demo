/**
 * 
 */	

function init() {
		 console.log("init()");
         //Parameters are APIName,APIVersion,CallBack function,API Root 
         gapi.client.load('contactendpoint', 'v1', null, 'http://localhost:8888/_ah/api');
         gapi.client.load('ratesendpoint', 'v1', null, 'http://localhost:8888/_ah/api');
         gapi.client.load('billendpoint', 'v1', null, 'http://localhost:8888/_ah/api');
         
         console.log("Loaded endpoints...");
         
         $(document).ready(function() {
          	//attach click listeners for Contacts
           	$("#listContactsButton").on("click",showAllContacts);
           	$("#createNewContactButton").on("click",createNewContact);
           	//sidebar - contacts
           	$("#contactSidebar").find("a").on("click",handleContactSidebarActions);
         });
}

/**
 * contact sidebar actions
 */

function handleContactSidebarActions(event) {
	console.debug(event.target.text);
	if (event.target.text=="View All Contacts") {
		console.log("In View AllContacts");
		showAllContacts(event);
	}
	else if (event.target.text=="Search for a Contact") {
		searchContact();
	}
	else if (event.target.text=="Edit a Contact") {
		updateContact();
	}
	else if (event.target.text=="Remove a Contact") {
		deleteContact();
	}
	
}

function updateContact() {
	if ($("#contactUpdateForm").css("display")!="none") {
		$("#contactUpdateForm").slideUp("fast");
		return;
	}
	$("#contactUpdateForm").slideDown("fast");
	$("#contactUpdateForm #contact_email").focus();
	$("#contactUpdateForm #updateContact").off();
	$("#contactUpdateForm #updateContact").on("click",function(e) {
		//First get this contact...
		//Build the Request Object
	    var requestData = {};
	    requestData.id = $("#contactUpdateForm #contact_email").val();
	    if(!requestData.id || requestData.id==undefined || requestData.id=="")
	    	return;
	    gapi.client.contactendpoint.getContact(requestData).execute(function(response) {
	    	console.debug(response);
	    	if(response.error || response.error!=undefined) {   		
	    		showMessage("error","I cannot find anyone with this Email-ID");
	    		return;
	    	}
	    	//Populate the create form with this data...
	    	populateCreateFormData(response);
	    	$("#hiddenContactForm").slideDown("slow",function(e) {
	    		$("#contact_email").attr("disabled","disabled");
	    	});
	    	
	    	//add event to the Cancel thingy.
	    	$("#hiddenContactForm").find("#cancelContact").off();//remove existing event(s).
	    	$("#hiddenContactForm").find("#cancelContact").on("click",function(event) {
	    		$("#hiddenContactForm").slideUp("slow");
	    	});
	    	
	    	//add event to the save thingy
	    	$("#hiddenContactForm").find("#saveContact").off();//remove existing event(s).
	    	$("#hiddenContactForm").find("#saveContact").on("click",function(event) {
	    		saveContactChanges();
	    	});
	    });
	});
	
}

/**
 * method to persist the said changes...
 */
function saveContactChanges() {
	showLoader($("#createNewContactButton"));
	//Build the Request Object
	//Validate the entries
    var email = $("#contact_email").val();
    var name = $("#contact_name").val();
    var company = $("#contact_company").val();
    var address = $("#contact_address").val();
    
    var requestData = {};
    requestData.emailID = email;
    requestData.contactName = name;
    requestData.address = address;
    requestData.companyName = company;
    
    gapi.client.contactendpoint.updateContact(requestData).execute(function(resp) {
		console.debug(resp);
		if(resp.message=="javax.persistence.EntityNotFoundException: Object does not exist") {
			$("#hiddenUpdateForm").hide();
			showMessage("error","I cannot find anyone with this e-mail ID...");
		}
        if (!resp.code) {
               
                $("#hiddenUpdateForm").hide();
                showMessage("success","Saved Successfully!");
        }
    });
    hideLoader();
}

/**
 * function to populate the email id being updated on the create form.
 * @param response
 */
function populateCreateFormData(response) {
	//Set the entries on fields
    $("#hiddenContactForm #contact_email").val(response.emailID);
    $("#hiddenContactForm #contact_name").val(response.contactName);
    $("#hiddenContactForm #contact_company").val(response.company);
    $("#hiddenContactForm #contact_address").val(response.address);
    
    
}
/**
 * function to delete a contact
 */
function deleteContact() {
	if ($("#contactRemoveForm").css("display")!="none") {
		$("#contactRemoveForm").slideUp("fast");
		return;
	}
	$("#contactRemoveForm").slideDown("fast");
	$("#contactRemoveForm #contact_email").focus();
	$("#contactRemoveForm #deleteContact").off();
	$("#contactRemoveForm #deleteContact").on("click",function(e) {
		var searchEmail = $("#contactRemoveForm #contact_email").val();
		if(!searchEmail || searchEmail==undefined || searchEmail=="") {
			return;
		}
		//Build the Request Object
	    var requestData = {};
	    requestData.id = searchEmail;
	    gapi.client.contactendpoint.removeContact(requestData).execute(function(response) {
	    	console.debug(response);
	    	if (!response || response==undefined) {
	    		showMessage("success","Removed contact with E-Mail:"+searchEmail+" !");
	    		
	    	}
	    	else  {
	    		showMessage("error","I cannot find a contact with E-Mail:"+searchEmail+" !");
	    		
	    	}
	    	
			$("#contactRemoveForm").fadeOut("fast");
	    });
	});
}


/**
 * function to search a contact.
 */
function searchContact() {
		if ($("#contactSearchForm").css("display")!="none") {
			$("#contactSearchForm").slideUp("fast");
			return;
		}
		$("#contactSearchForm").slideDown("fast");
		$("#contactSearchForm #contact_email").focus();
		$("#contactSearchForm #searchContact").off();
		$("#contactSearchForm #searchContact").on("click",function(e) {
			var searchEmail = $("#contactSearchForm #contact_email").val();
			if(!searchEmail || searchEmail==undefined || searchEmail=="") {
				return;
			}
			//Build the Request Object
		    var requestData = {};
		    requestData.id = searchEmail;
		    gapi.client.contactendpoint.getContact(requestData).execute(function(response) {
		    	console.debug(response);
		    	//call method that displays the contacts in a pretty fashion
		    	displaySearchedContacts(response);
				$("#contactSearchForm").fadeOut("fast");
		    });
		});
}

/**
 * function to show the Loading animation
 * @param nextToThis
 */
function showLoader(nextToThis) {
	var elem = document.createElement("div");
	$(elem).attr("id","loaderGIF");
	$(elem).addClass("overlay");

	$(nextToThis).append(elem);

};

/**
 * function to hide the loading animation
 */
function hideLoader() {
	$("#loaderGIF").remove();
}

function createNewContact(event) {
	$("#hiddenContactMessage").hide();
	$("#hiddenContactForm").slideDown("slow",function(e) {
		$("#contact_email").focus();
	});
	
	//add event to the Cancel thingy.
	$("#hiddenContactForm").find("#cancelContact").off();//remove existing event(s).
	$("#hiddenContactForm").find("#cancelContact").on("click",function(event) {
		$("#hiddenContactForm").slideUp("slow");
	});
	
	//add event to the save thingy
	$("#hiddenContactForm").find("#saveContact").off();//remove existing event(s).
	$("#hiddenContactForm").find("#saveContact").on("click",function(event) {
		saveNewContact();
	});
	
	
//	
}
/**
 * function to save a contact
 */
function saveNewContact () {
	showLoader($("#createNewContactButton"));
	//Validate the entries
    var email = $("#contact_email").val();
    var name = $("#contact_name").val();
    var company = $("#contact_company").val();
    var address = $("#contact_address").val();
    
    //validate here...
    
    //Build the Request Object
    var requestData = {};
    requestData.emailID = email;
    requestData.contactName = name;
    requestData.address = address;
    requestData.companyName = company;
    
    gapi.client.contactendpoint.insertContact(requestData).execute(function(resp) {
    		console.debug(resp);
    		if(resp.message=="javax.persistence.EntityExistsException: Object already exists") {
    			$("#hiddenContactForm").hide();
    			showMessage("error","A contact with the same E-Mail ID exists...");
    		}
            if (!resp.code) {
                    //Just logging to console now, you can do your check here/display message
                    console.log(resp.id + ":" + resp.author + ":" + resp.message);
                    $("#hiddenContactForm").hide();
                    showMessage("success","Saved Successfully!");
            }
    });
    //request a refresh of all contacts.
    //showAllContacts();
    hideLoader();

}

function showAllContacts(event) {
	console.debug(event);
	showLoader($("#listContactsButton"));
	gapi.client.contactendpoint.listContact().execute(function(response) {
//		console.debug(response);
		//call method that displays the contacts in a pretty fashion
		displayContacts(response);
		//now remove the indicator.
		hideLoader();
	});
	
}
/**
 * function to display some searched contacts...
 * @param response
 */
function displaySearchedContacts(response) {
	var resultHTML="";
	if(response.error || response.error!=undefined) {
		/*resultHTML="<li>Cannot Find anyone with this Email ID...!</li>";
		$("#listContactsButton").parent().siblings(".dataList").html(resultHTML);*/
		showMessage("error","It's Lonely here... ! I cannot find anyone !");
		return;
	}
	$(".hiddenMessage").hide();
	resultHTML+="<li><div class='addressContainer'>" +
	"<div class='name'>"+response.contactName+" </div>" +
	"<div class='email'>"+response.emailID+"</div>" +
	"<div class='companyName'>"	+response.companyName+"</div>"+
	"<div class='mailingAddress'>"+response.address+"</div>" +
	"</div></li>";
	
	$("#listContactsButton").parent().siblings(".dataList").html(resultHTML);
	
}

function showMessage(type,descr) {
	
	$(".hiddenMessage").text(descr).removeClass("sucessMessage").removeClass("errorMessage").addClass(type+"Message").fadeIn("fast");
}

/**
 * function to display the contacts ( searched ) in a pretty fashion.
 * @param response
 */
function displayContacts(response) {
	var resultHTML="";
	if(!response.items || response.items==undefined) {
		/*resultHTML="<li>No Contacts yet, Why don't you create one?</li>";*/
		showMessage("error","It's Lonely here... ! I cannot find anyone !");
		return;
	}
	
	$(".hiddenMessage").hide();
	for(var i=0;i<response.items.length;i++) {
		resultHTML+="<li><div class='addressContainer'>" +
		"<div class='name'>"+response.items[i].contactName+" </div>" +
		"<div class='email'>"+response.items[i].emailID+"</div>" +
		"<div class='companyName'>"	+response.items[i].companyName+"</div>"+
		"<div class='mailingAddress'>"+response.items[i].address+"</div>" +
		"</div></li>";
			
	}
	
	$("#listContactsButton").parent().siblings(".dataList").html(resultHTML);
}