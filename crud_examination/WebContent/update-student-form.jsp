<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update page</h1>
	
	<form action="students" method="get">
		<input type="hidden" name="command" value="UPDATE">
		
		<input type="hidden" name="studentId" value="${The_Student.id}">
		
		<div class="form-group">
			<label>FirstName: </label>
			<input type="text" name="firstName" value="${The_Student.firstName}">
		</div>
		
		<div class="form-group">
			<label>LastName: </label>
			<input type="text" name="lastName" value="${The_Student.lastName}">
		</div>
		
		<div class="form-group">
			<label>Email: </label>
			<input type="text" name="email" value="${The_Student.email}">
		</div>
		
		<div class="submit">
			<input type="submit" value="Save">
		</div>
	</form>
	
		<a href="students">Back-to-list</a>
</body>
</html>