<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Enter Sender Details</h2>
	<form action="sendmail">
		<table>
			<tr>
				<td>To Address</td>
				<td><input type="text" name="to"></td>
			</tr>
			<tr>
				<td>subject</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>Body</td>
				<td><input type="text" name="body"></td>
			</tr>
			<tr>
				<td><input type="submit" value="send"></td>
			</tr>
		</table>
	</form>
	<h1>${send}</h1>
</body>
</html>