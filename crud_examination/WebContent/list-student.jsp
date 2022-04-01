<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Student</title>
<link type="text/css" rel="stylesheet" href="css/index.css">
</head>
<body>
	<div class="wrapper"> 
		<h1>Foorbar Title</h1>
		<input type="button" value="Add" onclick="window.location.href='add-student-form.jsp'; return false;">
		<table>
			<tr>
				<th>id</th>
				<th>first name</th>
				<th>last name</th>
				<th>email</th>
				<th>action</th>
			</tr>
		
			<c:forEach var="index" items="${Student_List}"> <!-- Student_List là được setAtribute trong controller --> 
				<c:url var="loadLink" value="students">
					<c:param name="command" value="LOAD"></c:param>
					<!-- studentId này là giá trị tự cho để hiển thị lên url mà thôi -->
					<c:param name="studentId" value="${index.id}"></c:param>
				</c:url>
				
				<c:url var="deleteLink" value="students">
					<c:param name="command" value="DELETE"></c:param>
					<!-- studentId này là giá trị tự cho để hiển thị lên url mà thôi -->
					<c:param name="studentId" value="${index.id}"></c:param>
				</c:url>
				<tr>
					<td>${index.id}</td>
					<td>${index.firstName}</td>
					<td>${index.lastName}</td>
					<td>${index.email}</td>
					<td>
						<a href="${loadLink}">Update</a>
						<a href="${deleteLink}" onclick="if(!(confirm('Ban co chac muon xoa khong'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>