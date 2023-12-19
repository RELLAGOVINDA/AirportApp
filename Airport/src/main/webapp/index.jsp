<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Airport</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ephesis&display=swap" rel="stylesheet">
	<style>
		.table{
		 color: #ED7B7B
		}
		.input{
		 background-color: #C5E898
		}
		body{
		background-color: #793FDF;
		font-family: 'Ephesis', cursive;
		font-family: 'Libre Baskerville', serif;
		padding: 3% 5%
		}
		.form{
		margin-left: 50%;
		margin-top: -19%
		}
		.output{
		margin-top: 10%;
		
		
		}
	</style>
</head>
<body>

	<h2>Enter Airport Details</h2>
	<form action="insertAirportDetails">
		<h1>${saveEntity}</h1>
		<h1 style="color:red">${Error}</h1>
		<table class="table">
			<tr>
				<td>Airport Id : </td>
				<td><input type="number" name="id" class="input"> </td>
			</tr>
			<tr>
				<td>Airport Name : </td>
				<td><input type="text" name="name" class="input"> </td>
			</tr>
			<tr>
				<td>Airport location : </td>
				<td><input type="text" name="location" class="input"> </td>
			</tr>
			<tr>
				<td>No of Planes : </td>
				<td><input type="number" name="planes" class="input"> </td>
			</tr>
			<tr>
				<td>No of Runways: </td>
				<td><input type="number" name="runway" class="input"> </td>
			</tr>
			<tr>
				<td><input type="submit" class="input"> </td>
			</tr>
		</table>
	</form>
	<h1 style="color:red">${resource}</h1>
	
	
	<div class="form">
	<form action="getAirportDetailsById" >
		Search Airport by ID :
		<input type="number" name="id">
		<input type="submit">
	
	</form>
	
	
	
	<form action="getAirportDetailsByName">
		Search Airport by NAME :
		<input type="text" name="name">
		<input type="submit">
	
	</form>
	
	
	
	
	
	<form action="deleteAirportDetailsById">
		Delete Airport by ID :
		<input type="number" name="id">
		<input type="submit">
	
	</form>
	
	<form action="deleteAirportDetailsByName">
		Delete Airport by Name :
		<input type="text" name="name">
		<input type="submit">
	
	</form>
	
	<form action="getAll">
		Click here for All Airport Details:<input type="submit" value="Click here">
		
	</form>
	
	</div>
	<div class="output">
	
	    <table border="3px" >
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>LOCATION</th>
				<th>NO OF PLANES</th>
				<th>NO OF RUNWAYS</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
		<c:forEach var="airport" items="${airports}" >
			<tr>
				<td>${airport.airId }</td>
				<td>${airport.name }</td>
				<td>${airport.location }</td>
				<td>${airport.noOfPlanes }</td>
				<td>${airport.noOfrunways }</td>
				<td><a href="editAirport/${airport.airId}">Edit</a></td>
				<td><a href="deleteAirport/${airport.airId}">delete</a></td>
				
			</tr>
		</c:forEach>
		
	
	</table>
	
	</div>
	
	
		<table class="output" border="3px">
		<tr>
			<th>${Airport_id}</th>
			<th>${Airport_Name}</th>
			<th>${Location}</th>
			<th>${No_of_Planes}</th>
			<th>${no_of_Runways}</th>
			
		</tr>
		
		<tr>
			<td>${id}</td>
			<td>${name}</td>
			<td>${location}</td>
			<td>${planes}</td>
			<td>${runways}</td>
		</tr>
	</table>
	
	
	
	
</body>
</html>
