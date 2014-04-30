function exefunction(checkBoxName){	
	var count = 0;
    for (var i = 0; i < document.getElementsByName(checkBoxName).length; i++){         
        if (document.getElementsByName(checkBoxName)[i].checked) {
         	count++;
        }
    }
    
    if(count > 0){
    	if (confirm('Are you sure you want to delete this record?')) {
    		form.submit();
    	} else {
    	    // Do nothing!
    	}         
    }else{
     	alert("You have not choose anything!");
    }	    
}

/**
 * dialog save confirmation
 * @param buttonSave
 */
function confirmationSave(buttonSave) {
    $("#dialog:ui-dialog").dialog("destroy");
    $('#dialog-save').dialog({
        autoOpen: false,
        resizable: false,
        height:140,
        show: "blind",
        hide: "explode",
        modal: true,
        title: "Save Confirmation",
        buttons: {
            Yes: function() {
                $(this).dialog("close");
                $(buttonSave).click();
            },
            No: function() {
                $(this).dialog("close");
            }
        }
    });
}

/**
 * dialog reject confirmation
 * @param buttonSave
 */
function confirmationReject(buttonReject) {
    $("#dialog:ui-dialog").dialog("destroy");
    $('#dialog-reject').dialog({
        autoOpen: false,
        resizable: false,
        height:140,
        show: "blind",
        hide: "explode",
        modal: true,
        title: "Reject Confirmation",
        buttons: {
            Yes: function() {
                $(this).dialog("close");
                $(buttonReject).click();
            },
            No: function() {
                $(this).dialog("close");
            }
        }
    });
}



/**
 * dialog Approve confirmation
 * @param buttonSave
 */
function confirmationApprove(buttonApprove) {
    $("#dialog:ui-dialog").dialog("destroy");
    $('#dialog-approve').dialog({
        autoOpen: false,
        resizable: false,
        height:140,
        show: "blind",
        hide: "explode",
        modal: true,
        title: "Approve Confirmation",
        buttons: {
            Yes: function() {
                $(this).dialog("close");
                $(buttonApprove).click();
            },
            No: function() {
                $(this).dialog("close");
            }
        }
    });
}