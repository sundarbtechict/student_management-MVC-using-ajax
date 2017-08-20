
function getAllStudents()
{
	$.ajax({
        url: appContextPath + "/getAllStudents",
        method: "GET",
        success: function (result) 
        {
            $("#content").html(result);
        }
    });
}



function getCreateStudentPage()
{
	// console.log("hi create");
	$.ajax({
        url: appContextPath + "/createStudent",
        method: "GET",
        success: function (result) 
        {
            // console.log(finalText);
            $("#content").html(result);
        }
    });
}


function createStudent()
{
	// console.log("hi save");
	$.ajax({
        url: appContextPath + "/createStudent",
        type:"POST",
        data:$("#myForm").serialize(),
        success: function (result) 
        {
            $("#content").html(result);
        }
    });
	return false;
}



function getViewStudentPage(studentId)
{
	// console.log("hi view");
	$.ajax({
        url: appContextPath + "/viewStudent?studentId="+studentId,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#viewStudent");
            // console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            // console.log(finalText);
            // console.log("final");
            $("#content").html(finalText);
        }
    });
}


function getUpdateStudentPage(studentId)
{
	// console.log("hi edit");
	$.ajax({
		url: appContextPath + "/updateStudent?studentId="+studentId,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#editStudent");
            // console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            // console.log(finalText);
            // console.log("final");
            $("#content").html(finalText);
        }
    });
}


function updateStudent()
{
	// console.log("hi update");
	$.ajax({
        url: appContextPath + "/updateStudent",
        type:"POST",
        data:$("#myForm").serialize(),
        success: function (result) 
        {
            $("#content").html(result);
        }
    });
	return false;
}


function confirmDeleteStudent(studentId)
{
	var isOkToDelete = confirm('Are you sure you want to delete Student (studentId: '+ studentId +')');
	if(isOkToDelete) {
		deleteStudent(studentId);
	}
}

function deleteStudent(studentId)
{
	// console.log("hi delete");
	$.ajax({
		url: appContextPath + "/deleteStudent?studentId="+studentId,
		method: "GET",
		success: function (result) 
		{
			$("#content").html(result);
		}
	});
}