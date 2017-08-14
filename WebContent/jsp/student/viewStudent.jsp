<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="viewStudent">


	<a href='#' onclick="getAllStudents();"> &lt Back</a> <br />
	<br />

	<div class="panel panel-default">
		<div class="panel-heading">View Student :</div>
		<div class="panel-body">

			<table class="table table-striped">
				<tr>
					<th>Student Id:</th>
					<td><c:out value="${studentVO.studentId}" /></td>
				</tr>
				<tr>
					<th>Name:</th>
					<td><c:out value="${studentVO.name}" /></td>
				</tr>
				<tr>
					<th>Register No:</th>
					<td><c:out value="${studentVO.regNo}" /></td>
				</tr>
				<tr>
					<th>Date of Birth:</th>
					<td><c:out value="${studentVO.dob}" /></td>
				</tr>
				<tr>
					<th>Department:</th>
					<td><c:out value="${studentVO.dept}" /></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><c:out value="${studentVO.email}" /></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><c:out value="${studentVO.mobile}" /></td>
				</tr>
			</table>
		</div>
	</div>

</div>
