<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sundar.studentmanagement.student.vo.*"%>

<div id="editStudent">
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
	
	<a href='<c:url value="/" />'> &lt Back</a>
	<br/>
	<br/>
	
	<div>
	<form class="form-inline" id="myForm" onsubmit="return updateStudent()">
		<table class="table table-striped">
			<tr>
				<th>Register no:</th>
				<td><input type="text" class="form-inline" name="regno"
					value=<c:out value="${student.getRegNo()}"/> readonly></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" class="form-inline" name="name"
					value=<c:out value="${student.getName()}"/>></td>
			</tr>
			<tr>
				<th>Date of Birth:</th>
				<td><input type="date" class="form-inline" name="dob"
					value=<c:out value="${student.getDob()}"/>></td>
			</tr>
			<tr>
				<th>Department:</th>
				<td><input type="text" class="form-inline" name="dept"
					value=<c:out value="${student.getDept()}"/>></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" class="form-inline" name="email"
					value=<c:out value="${student.getEmail()}"/>></td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><input type="text" class="form-inline" name="mobile"
					value=<c:out value="${student.getMobile()}"/>></td>
			</tr>
		</table>
		<div style="float: right;right:10%;">
			<input type="submit" class="btn btn-info" value="update">
			<a href="./index.jsp" class="btn btn-info">cancel</a>
		</div>
	</form>
	</div>
</div>
