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
          	//attach click listeners.
           	$("#listContactsButton").on("click",showAllContacts);
           	$("#createNewContactButton").on("click",createNewContact);
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
	$("#hiddenContactForm").slideDown("slow");
	
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
    			$("#hiddenContactMessage").css("color","red").fadeIn("fast").text("A contact with the same E-Mail ID exists...");
    		}
            if (!resp.code) {
                    //Just logging to console now, you can do your check here/display message
                    console.log(resp.id + ":" + resp.author + ":" + resp.message);
                    $("#hiddenContactForm").hide();
                    $("#hiddenContactMessage").css("color","green").fadeIn("fast").text("Saved Successfully!");
            }
    });
    //request a refresh of all contacts.
    showAllContacts();
    hideLoader();

}

function showAllContacts(event) {
	showLoader($("#listContactsButton"));
	gapi.client.contactendpoint.listContact().execute(function(response) {
//		console.debug(response);
		var resultHTML="";
		if(!response.items || response.items==undefined) {
			resultHTML="<li>No Contacts yet, Why don't you create one?</li>";
		}
		else {
			for(var i=0;i<response.items.length;i++) {
				resultHTML+="<li><div class='addressContainer'>" +
				"<div class='name'>"+response.items[i].contactName+" </div>" +
				"<div class='email'>"+response.items[i].emailID+"</div>" +
				"<div class='companyName'>"	+response.items[i].companyName+"</div>"+
				"<div class='mailingAddress'>"+response.items[i].address+"</div>" +
				"</div></li>";
				
			}
		}
		$("#listContactsButton").parent().siblings(".dataList").html(resultHTML);
		//now remove the indicator.
		hideLoader();
	});
	
}