$(document).ready(function(){
	// console.log("hi");
	
	// Execute on Page Load
	
	// Get Home Page
	getAllModules();
	
	
});



function getAllModules()
{
	$.ajax({
        url: appContextPath + "/getAllModules",
        method: "GET",
        success: function (result) 
        {
            $("#content").html(result);
        }
    });
}
