<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="datasource" driver="com.mysql.jdbc.Driver"
	 url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123"
	user="cs320stu123"
	password="K06uWNwy" />
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Rent</title>
</head>
<body>
	<center>
		<h2>PAY RENT</h2>
	</center>
	
	<table border=1>
		<tr>
			<th>Apartment ID</th>
			<th>Username</th>
			<th>Rent</th>
			<th>Rent Paid</th>
			<th>Month</th>
			<th>Year</th>
			<th>Operation</th>
		</tr>
		
		<sql:query var="rent" dataSource="${datasource }">
		
		SELECT apartment.apartmentNo,userdetails.username,apartment.rent,rent.rentID FROM userdetails,apartment,rent where   
userdetails.userID=rent.userID and apartment.apartmentID=rent.apartmentID order by apartment.apartmentID asc;
		</sql:query>
	
		<c:forEach items="${rent.rows}" var="r">
		
		<tr>
		<form method='post' action="PayRent">
		<input type="hidden" value="<c:out value="${r.rentID}" />"
										name="rentID" />
		<td><c:out value="${r.apartmentNo }"></c:out></td>
		<td><c:out value="${r.username }"></c:out></td>
		<td><c:out value="${r.rent }"></c:out></td>
		<td>
		
		<input type=text name="rentPaid" ></td>
		<td><input type=text name="rentMonth" ></td>
		<td><input type=text name="rentYear" >
		
		</td>
		<td><input type="submit" value="Done"></td>
			</form>
		</tr>
		
		</c:forEach>
		
	</table>
<a href="logout">Logout</a>
</body>
</html>