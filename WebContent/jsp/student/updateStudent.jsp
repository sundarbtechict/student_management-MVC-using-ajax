<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="editStudent">

	<a href='#' onclick="getAllStudents();"> &lt Back</a> <br />
	<br />

	<div class="panel panel-default">
		<div class="panel-heading">Edit Student :</div>
		<div class="panel-body">

			<form class="form-horizontal" id="myForm"
				onsubmit="return updateStudent();">

				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">studentId
						no:</label>
					<div class="col-sm-10">

						<input type="text" class="form-control" name="studentId" id="studentId"
							value=<c:out value="${studentVO.studentId}"/> readonly>

					</div>
				</div>



				<div class="form-group">
					<label for="regNo" class="col-sm-2 control-label">Register
						no:</label>
					<div class="col-sm-10">


						<input type="text" class="form-control" name="regNo" id="regNo"
							value=<c:out value="${studentVO.regNo}"/> readonly>

					</div>
				</div>



				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name"
							value=<c:out value="${studentVO.name}"/>>
					</div>
				</div>




				<div class="form-group">
					<label for="dob" class="col-sm-2 control-label">Date of
						Birth::</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="dob"
							value=<c:out value="${studentVO.dob}"/>>
					</div>
				</div>




				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="email"
							value=<c:out value="${studentVO.email}"/>>
					</div>
				</div>





				<div class="form-group">
					<label for="mobile" class="col-sm-2 control-label">Mobile:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="mobile"
							value=<c:out value="${studentVO.mobile}"/>>
					</div>
				</div>




				<div class="form-group">
					<label for="dept" class="col-sm-2 control-label">Department:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept"
							value=<c:out value="${studentVO.dept}"/>>
					</div>
				</div>




				<div>
					<div class="pull-right">

						<button type="button" class="btn btn-default"
							onclick="getAllStudents();">Cancel</button>
						<button type="submit" class="btn btn-primary">Save</button>

					</div>
				</div>
			</form>


		</div>
	</div>
</div>