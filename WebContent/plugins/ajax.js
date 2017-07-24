$(document).ready(function(){
	console.log("hi");
	$.ajax({
        url: "././indexOfStudent",
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#getAllStudents");
            console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            console.log(finalText);
            console.log("final");
            $("#content").html(finalText);
        }
    });
});
function createStudent()
{
	console.log("hi create");
	$.ajax({
        url: "./createStudent",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#getForm");
            var finalText = htmlFiltered.html();
            console.log(finalText);
            $("#content").html(finalText);
        }
    });
}
function saveStudent()
{
	console.log("hi save");
	$.ajax({
        url: "././createStudent",
        type:"POST",
        data:$("#myForm").serialize(),
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#getAllStudents");
            var finalText = htmlFiltered.html();
            console.log(finalText);
            $("#content").html(finalText);
        }
    });
	return false;
}

function viewStudent(regno)
{
	console.log("hi view");
	$.ajax({
        url: "././viewStudent?regno="+regno,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#viewStudent");
            console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            console.log(finalText);
            console.log("final");
            $("#content").html(finalText);
        }
    });
}
function editStudent(regno)
{
	console.log("hi edit");
	$.ajax({
		url: "././editStudent?regno="+regno,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#editStudent");
            console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            console.log(finalText);
            console.log("final");
            $("#content").html(finalText);
        }
    });
}
function updateStudent()
{
	console.log("hi update");
	$.ajax({
        url: "././updateStudent",
        type:"POST",
        data:$("#myForm").serialize(),
        success: function (result) 
        {
        	console.log($("#myForm").serialize());
            var htmlFiltered = $(result).filter("#getAllStudents");
            var finalText = htmlFiltered.html();
            console.log(finalText);
            $("#content").html(finalText);
        }
    });
	return false;
}

function deleteStudent(regno)
{
	console.log("hi delete");
	$.ajax({
		url: "././deleteStudent?regno="+regno,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#getAllStudents");
            console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            console.log(finalText);
            console.log("final");
            $("#content").html(finalText);
        }
    });
}