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
<title>RentHistory</title>
</head>
<body>
	<center>Rent History</center>
	<table border=1>
		<th>Apartment ID</th>
		<th>Username</th>
		<th>Rent</th>
		<th>Rent Paid</th>
		<th>Month</th>
		<th>Year</th>

		<sql:query var="rentShow" dataSource="${datasource }">
		SELECT apartment.apartmentNo, userdetails.username,apartment.rent,payrent.rent_paid,payrent.rent_month,payrent.rent_year FROM apartment,userdetails,payrent,rent WHERE apartment.apartmentID=rent.apartmentID and userdetails.userID=rent.userID and payrent.rent_id=rent.rentID;
		</sql:query>
		
		<c:forEach items="${rentShow.rows }" var="r">
		
		<tr>
		<td><c:out value="${r.apartmentNo}"></c:out></td>
		<td><c:out value="${r.username}"></c:out></td>
		<td><c:out value="${r.rent}"></c:out></td>
		<td><c:out value="${r.rent_paid}"></c:out></td>
		<td><c:out value="${r.rent_month}"></c:out></td>
		<td><c:out value="${r.rent_year}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	<a href="logout">Logout</a>
</body>
</html>