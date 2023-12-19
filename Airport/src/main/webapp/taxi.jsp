<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Taxi</title>
</head>
<body>
	<h2>Enter Taxi details</h2>
	<form action="saveTaxi">
		<table>
			
			<h1>${save}</h1>
			<tr>
				<td>Airport id</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Driver Name</td>
				<td><input type="text" name="dName"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="number" name="mNumber"></td>
			</tr>
			<tr>
				<td>Taxi Number</td>
				<td><input type="number" name="tNumber"></td>
			</tr>
			<tr>
				<td>AC or Non Ac</td>
				<td><input type="text" name="ac"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
	
	<form action="searchTaxibyId">
		search Available taxies:<br>
		<input type="number" name="id"><br>
		<input type="submit" value="search">
		
	</form>
	
	 <table>
	 	<tr>
	 		<th>airport id</th>
	 		<th>Driver Name</th>
	 		<th>Mobile Number</th>
	 		<th>Taxi Number</th>
	 		<th>AC/NONAC</th>
	 		<th>Edit</th>
	 		
	 	</tr>
	 	<c:forEach var="taxi" items="${list}">
	 		<tr>
	 			<td>${taxi.airId }</td>
	 			<td>${ taxi.dName}</td>
	 			<td>${taxi.mobile }</td>
	 			<td>${taxi.tNumber }</td>
	 			<td>${taxi.tType }</td>
	 			<td><a href="editTaxi/${taxi.dName}">edit</a></td>
	 		</tr>
	 	
	 	</c:forEach>
	 </table>
	
	
	
	
	
	
</body>
</html>