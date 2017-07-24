<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="editStudent">

<a href='#' onclick="getAllStudents();"> &lt Back</a>

<h2>Edit Student :</h2>


	<div>
		<form class="form-inline" id="myForm"
			onsubmit="return updateStudent()">
			<table class="table table-striped">
				<tr>
					<th>Register no:</th>
					<td><input type="text" class="form-inline" name="regno"
						value=<c:out value="${student.regNo}"/> readonly></td>
				</tr>
				<tr>
					<th>Name:</th>
					<td><input type="text" class="form-inline" name="name"
						value=<c:out value="${student.name}"/>></td>
				</tr>
				<tr>
					<th>Date of Birth:</th>
					<td><input type="date" class="form-inline" name="dob"
						value=<c:out value="${student.dob}"/>></td>
				</tr>
				<tr>
					<th>Department:</th>
					<td><input type="text" class="form-inline" name="dept"
						value=<c:out value="${student.dept}"/>></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><input type="text" class="form-inline" name="email"
						value=<c:out value="${student.email}"/>></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><input type="text" class="form-inline" name="mobile"
						value=<c:out value="${student.mobile}"/>></td>
				</tr>
			</table>


			<div>
				<div class="pull-right">

						
					<button type="button" class="btn btn-default" onclick="getAllStudents();"> Cancel </button>
					<button type="submit" class="btn btn-primary"> Save </button>
					
				</div>

			</div>


		</form>
	</div>
</div>
