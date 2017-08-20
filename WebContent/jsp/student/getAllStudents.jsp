<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="getAllStudents">



	<!--  CSS and JS imports -->
	<jsp:include page="/jsp/common/status.jsp" />


	<div>

		<div class="pull-left">
			<a href='#' onclick="getAllModules();"> &lt Back</a>

		</div>
		<div class="pull-right">


			<div>
				<button class="btn btn-primary pull-right"
					onclick="getCreateStudentPage()">
					<span class="glyphicon glyphicon-plus"></span> Create Student
				</button>

			</div>

		</div>

	</div>


	<br> <br>
	<div>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<tr class="info">
					<th>Student Id</th>
					<th>Name:</th>
					<th>Register No:</th>
					<th>Date of Birth:</th>
					<th>Department:</th>
					<th>Email:</th>
					<th>Mobile:</th>
					<th colspan="3">ACTION</th>
				</tr>
				<c:forEach items="${studentVOs}" var="studentVO">
					<tr>
						<td><c:out value="${studentVO.studentId}"></c:out></td>
						<td><c:out value="${studentVO.name}"></c:out></td>
						<td><c:out value="${studentVO.regNo}"></c:out></td>
						<td><c:out value="${studentVO.dob}"></c:out></td>
						<td><c:out value="${studentVO.dept}"></c:out></td>
						<td><c:out value="${studentVO.email}"></c:out></td>
						<td><c:out value="${studentVO.mobile}"></c:out></td>
						<td><a href="#"
							onclick="getViewStudentPage(<c:out value="${studentVO.studentId}"></c:out>)">View</a></td>
						<td><a href="#"
							onclick="getUpdateStudentPage(<c:out value="${studentVO.studentId}"></c:out>)">Edit</a></td>
						<td><a href="#"
							onclick="confirmDeleteStudent(<c:out value="${studentVO.studentId}"></c:out>)">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>