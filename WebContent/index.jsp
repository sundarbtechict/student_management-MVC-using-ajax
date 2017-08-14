<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<!--  CSS and JS imports -->
<jsp:include page="/jsp/common/allImports.jsp" />


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