<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<div id="getForm">

<a href='#' onclick="getAllStudents();"> &lt Back</a>
<br/>
<br/>

	<div>
		<h4 style='color: #000080;'>Enter Student details:</h4>
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
			<div style="float: right; right: 10%;">
				<input type="submit" class="btn btn-info" value="save"> <a
					href="./index.jsp" class="btn btn-info">cancel</a>
			</div>
		</form>
	</div>
</div>