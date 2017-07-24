<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sundar.studentmanagement.student.vo.*"%>

<div id="getAllStudents">
	<button class="btn btn-primary" style="float: right;"
		onclick="getCreateStudentPage()">
		<span class="glyphicon glyphicon-plus"></span> Create Student
	</button>
	<br>
	<br>
	<c:if test="${status.getStatusCode() != null}">
		<c:if test="${status.getStatusCode()=='Success'}">
			<div class="alert alert-success alert-dismissable"
				style="text-align: center;">
				<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
						value="${status.getStatusCode()}" /></strong>
				<c:out value="${status.getStatusMsg()}" />
			</div>
		</c:if>
		<c:if test="${status.getStatusCode() == 'Problem'}">
			<div class="alert alert-warning alert-dismissable"
				style="text-align: center;">
				<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
						value="${status.getStatusCode()}" /></strong>
				<c:out value="${status.getStatusMsg()}" />
			</div>
		</c:if>
	</c:if>

	<br> <br>
	<div>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<tr class="info">
					<th>Register no:</th>
					<th>Name:</th>
					<th>Date of Birth:</th>
					<th>Department:</th>
					<th>Email:</th>
					<th>Mobile:</th>
					<th colspan="3">ACTION</th>
				</tr>
				<c:forEach items="${studentList}" var="st">
					<tr>
						<td><c:out value="${st.getRegNo()}"></c:out></td>
						<td><c:out value="${st.getName()}"></c:out></td>
						<td><c:out value="${st.getDob()}"></c:out></td>
						<td><c:out value="${st.getDept()}"></c:out></td>
						<td><c:out value="${st.getEmail()}"></c:out></td>
						<td><c:out value="${st.getMobile()}"></c:out></td>
						<td><a href="#"
							onclick="getViewStudentPage(<c:out value="${st.getRegNo()}"></c:out>)">View</a></td>
						<td><a href="#"
							onclick="getUpdateStudentPage(<c:out value="${st.getRegNo()}"></c:out>)">Edit</a></td>
						<td><a href="#"
							onclick="deleteStudent(<c:out value="${st.getRegNo()}"></c:out>)">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>