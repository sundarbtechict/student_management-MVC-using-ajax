$(document).ready(function(){
	// console.log("hi");
	
	// Execute on Page Load
	
	// Get Home Page
	$.ajax({
        url: appContextPath + "/getAllStudents",
        method: "GET",
        success: function (result) 
        {
            $("#content").html(result);
        }
    });
	
	
});