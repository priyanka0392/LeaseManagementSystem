<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import='LeaseManagementSystem.AddApartment'%>
<%@page import='java.util.ArrayList, LeaseManagementSystem.*'%>
<%@page import='LeaseManagementSystem.appointment'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource
var="apartment"
	 url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123"
	user="cs320stu123"
	password="K06uWNwy"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Management System</title>
</head>
<body>

	<c:choose>
		<c:when test="${pageContext.session['new']}">
			<c:redirect url="Login" />
		</c:when>
		<c:when test="${!pageContext.session['new']}">

			<h1>Welcome</h1>
			<p>
				<c:out value="${sessionScope.username }"></c:out>

				 !</br> 
				 
				 Apartment Details
				 
				 <br><a href="PayRent">Pay Rent</a>
				 <br><a href="RentHistory">Rent history</a>
			</p>
			<table style='width: 100%' border=1>
				<tr>
					<th>Apartment ID</th>
					<th>apartment Type</th>
					<th>Facility</th>
					<th>Max People</th>
					<th>Rent</th>
					<th>Deposit</th>
					<th>Vacant</th>
					<th>Change availability</th>
					<th>View Appointments</th>
				</tr>

<sql:query var="apartment"   dataSource="${apartment}">
    <%--  SELECT apartment.apartmentID,apartment.apartmentNo,apartment.typePeople,apartment.apartmentFacility,apartmentMaxPeople,apartment.apartmentVacancy,apartment.rent,apartment.deposit,appointment.statusAppointment FROM apartment,appointment WHERE apartment.apartmentID=appointment.apartmentID;
   SELECT * FROM apartment; --%> 
   SELECT * FROM apartment ;
    </sql:query>
				<c:forEach items="${apartment.rows}" var="a1">


					<tr>
						<td><c:out value="${a1.apartmentNo }" /></td>
						<td><c:out value="${a1.typePeople }" /></td>
						<td><c:out value="${a1.apartmentFacility }" />
						<td><c:out value="${a1.apartmentMaxPeople }" /></td>
						<td><c:out value="${a1.rent }" /></td>
						<td><c:out value="${a1.deposit }" /></td>
						<td><c:out value="${a1.apartmentVacancy }" /></td>
						<c:choose>
							<c:when test="${a1.apartmentVacancy==false }">
							
								<td><a
									href='ViewApartment?ApartmentID=<c:out value="${a1.apartmentID}" />'>Make
										Available</a></td>
										<td></td>
										</c:when>
							<c:when test="${a1.apartmentVacancy==true }">
							<td></td>
								<td><a
									href='RescheduleApplication?ApartmentID=<c:out value="${a1.apartmentID}" />'>View
										Appointment</a></td>
										
							</c:when>
						</c:choose>

					</tr>
				</c:forEach>
			</table>
			</c:when>
	</c:choose>
	<a href='logout'>Logout</a>
</body>
</html>