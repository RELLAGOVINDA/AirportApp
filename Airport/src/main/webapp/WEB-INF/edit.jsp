<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Airport</title>
</head>
<body>
	<h2>Edit Airport Details</h2>
	<form action="${pageContext.request.contextPath }/updateAirport">
		<table>
			<tr>
				<td>Airport id</td>
				<td><input type="number" value="${id}" name="id"> </td>
			</tr>
			<tr>
				<td>Airport Name</td>
				<td><input type="text" value="${name}" name="name"> </td>
			</tr>
			<tr>
				<td>Airport Location</td>
				<td><input type="text" value="${location}" name="location"> </td>
			</tr>
			<tr>
				<td>NO OF Planes</td>
				<td><input type="number" value="${planes}" name="planes"> </td>
			</tr>
			<tr>
				<td>Airport Runways</td>
				<td><input type="number" value="${runways}" name="runways"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="update"> </td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>