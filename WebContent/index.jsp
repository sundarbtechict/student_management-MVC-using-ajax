<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sundar.studentmanagement.student.vo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- import: CSS -->
<!-- plugin css-->
<link href="./plugins/bootstrap.css" rel="stylesheet" />

<!-- app css -->
<link href="./assets/css/styles.css" rel="stylesheet" />


<!-- import: JS -->
<!-- plugin js-->
<script type="text/javascript" src="./plugins/jquery.2.2.3.min.js"></script>
<script type="text/javascript" src="./plugins/bootstrap.min.js"></script>


<!-- app js -->
<script>
	var appContextPath = "${pageContext.request.contextPath}";
</script>

<script type="text/javascript" src="./assets/js/student.js"></script>
<script type="text/javascript" src="./assets/js/index.js"></script>

</head>


<body>

	<nav class="navbar navbar-default navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href='<c:url value="/" />'>Student
					Management</a>
			</div>
		</div>
	</nav>

	<div id="content" class="container"></div>
</body>
</html>