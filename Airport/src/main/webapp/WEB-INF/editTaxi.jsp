<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Taxi Details</h2>
	<form action="${pageContext.request.contextPath }/upadteTAxiDetails">
		<table>
			<tr>
				<td>Airport ID</td>
				<td><input type="int" value="${id }" name="id"></td>
			</tr>
			<tr>
				<td>Driver Name</td>
				<td><input type="text" value="${name}" name="dName"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="int" value="${mobile}" name="mNumber"></td>
			</tr>
			<tr>
				<td>Taxi Number</td>
				<td> <input type="int" value="${taxiNum}" name="tNumber"></td>
			</tr>
			<tr>
				<td>AC OR NON AC</td>
				<td><input type="text" value="${type}" name="ac"></td>
			</tr>
			<tr>
				<td><input type="submit" value="UPDATE"></td>
			</tr>
		</table>
	</form>
</body>
</html>