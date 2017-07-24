<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<div id="getForm">

<a href='#' onclick="getAllStudents();"> &lt Back</a>

<h2>Create Student :</h2>

	<div>
		<form class="form-inline" id="myForm" onsubmit="return createStudent();">
			<table class="table table-striped">
				<tr>
					<th>Name:</th>
					<td><input type="text" class="form-control" name="name"></td>
				</tr>
				<tr>
					<th>Register No:</th>
					<td><input type="text" class="form-control" name="regno"></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" class="form-control" name="dob"
						max="2000-12-31"></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><input type="email" class="form-control" name="email"></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><input type="text" class="form-control" name="mobile"></td>
				</tr>
				<tr>
					<th>Department:</th>
					<td><input type="text" class="form-control" name="dept"></td>
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