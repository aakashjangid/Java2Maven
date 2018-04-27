<html>

<body>
	<h2 style="text-align: center;">Employee Demo Application</h2>

	<a href="./employees"><button>List All Employees</button></a>
	<br />
	<br />
	<div>
		<fieldset style="width: 30%">
			<legend style="text-align: center;">Employee Registration</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" required="required" /></td>
					</tr>
					<tr>
						<td>Salary</td>
						<td><input type="number" name="salary" required="required" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" required="required" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="Add" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>

<h3>Add Multiple Employees Using Excel File</h3>

	<div>
		<form method="POST" action="./uploadFile" enctype="multipart/form-data">
			<input type="file" name="file" /><input type="submit"
				value="Upload" />
		</form>
	</div>
</body>
</html>
