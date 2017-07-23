<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sundar.studentmanagement.student.vo.*"%>

<div id="viewStudent">
	<c:if test="${status.getStatusCode() != null}">
		<c:if test="${status.getStatusCode()=='Success'}">
		<div class="alert alert-success alert-dismissable" style="text-align:center;">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${status.getStatusCode()}" /></strong>
			<c:out value="${status.getStatusMsg()}" />
		</div>
	</c:if>
		<c:if test="${status.getStatusCode() == 'Problem'}">
		<div class="alert alert-warning alert-dismissable" style="text-align:center;" >
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${status.getStatusCode()}" /></strong>
			<c:out value="${status.getStatusMsg()}" />
		</div>
		</c:if>
	</c:if>
	
	<br><br>

	<div class="container">
			<table class="table table-striped">
				<tr>
					<th>Register no:</th>
					<td><c:out value="${student.getRegNo()}"/></td>
				</tr>
				<tr>
					<th>Name:</th>
					<td><c:out value="${student.getName()}"/></td>
				</tr>
				<tr>
					<th>Date of Birth:</th>
					<td><c:out value="${student.getDob()}"/></td>
				</tr>
				<tr>
					<th>Department:</th>
					<td><c:out value="${student.getDept()}"/></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><c:out value="${student.getEmail()}"/></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><c:out value="${student.getMobile()}"/></td>
				</tr>
			</table>
		<a href='./././index.jsp'> Back</a>
	</div>
</div>
