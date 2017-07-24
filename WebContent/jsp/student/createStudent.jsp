<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="getForm">

	<a href='#' onclick="getAllStudents();"> &lt Back</a> <br/><br/>

	<div class="panel panel-default">
		<div class="panel-heading">Create Student :</div>
		<div class="panel-body">

			<form class="form-horizontal" id="myForm"
				onsubmit="return createStudent();">


				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name" id="name">
					</div>
				</div>




				<div class="form-group">
					<label for="regno" class="col-sm-2 control-label">Register
						No:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="regno" id="regno">
					</div>
				</div>




				<div class="form-group">
					<label for="dob" class="col-sm-2 control-label">DOB:</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="dob" id="dob"
							max="2000-12-31">
					</div>
				</div>




				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" name="email" id="email">
					</div>
				</div>





				<div class="form-group">
					<label for="mobile" class="col-sm-2 control-label">Mobile:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="mobile" id="mobile">
					</div>
				</div>




				<div class="form-group">
					<label for="dept" class="col-sm-2 control-label">Department:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept" id="dept">
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