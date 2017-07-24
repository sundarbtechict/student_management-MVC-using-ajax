<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="viewStudent">
	<c:if test="${status.statusCode != null}">
		<c:if test="${status.statusCode=='Success'}">
		<div class="alert alert-success alert-dismissable" style="text-align:center;">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${status.statusCode}" /></strong>
			<c:out value="${status.statusMsg}" />
		</div>
	</c:if>
		<c:if test="${status.statusCode == 'Problem'}">
		<div class="alert alert-warning alert-dismissable" style="text-align:center;" >
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${status.statusCode}" /></strong>
			<c:out value="${status.statusMsg}" />
		</div>
		</c:if>
	</c:if>
	
	<br><br>

	<a href='#' onclick="getAllStudents();"> &lt Back</a>
	<br/>
	<br/>
	
	<div>
			<table class="table table-striped">
				<tr>
					<th>Register no:</th>
					<td><c:out value="${student.regNo}"/></td>
				</tr>
				<tr>
					<th>Name:</th>
					<td><c:out value="${student.name}"/></td>
				</tr>
				<tr>
					<th>Date of Birth:</th>
					<td><c:out value="${student.dob}"/></td>
				</tr>
				<tr>
					<th>Department:</th>
					<td><c:out value="${student.dept}"/></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><c:out value="${student.email}"/></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><c:out value="${student.mobile}"/></td>
				</tr>
			</table>
	</div>
</div>
