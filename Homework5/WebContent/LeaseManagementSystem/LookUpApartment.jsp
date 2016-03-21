<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import='java.util.ArrayList, LeaseManagementSystem.*'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
 url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123"
	user="cs320stu123"
	password="K06uWNwy" />
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

			<h1>Look Up Apartments</h1>
			<table style='width: 100%' border=1>
				<tr>
					<th>Apartment ID</th>
					<th>Apartment Type</th>
					<th>Facility</th>
					<th>Max People</th>
					<th>Rent</th>
					<th>Deposit</th>
					<th>Appointment Date</th>
					<th>Operation</th>
				</tr>
				<sql:query var="apartment" dataSource="${dataSource}">
        SELECT * FROM apartment where apartmentVacancy=1;
        </sql:query>
				<c:forEach items="${apartment.rows}" var="a2">
					<tr>
						<td><c:out value="${a2.apartmentNo}" /></td>
						<td><c:out value="${a2.typePeople}" /></td>
						<td><c:out value="${a2.apartmentFacility}" />
						<td><c:out value="${a2.apartmetnMaxPeople}" /></td>
						<td><c:out value="${a2.rent}" /></td>
						<td><c:out value="${a2.deposit}" /></td>
						<c:choose>
							<%-- If apartment is vacant --%>
							<c:when test="${a2.apartmentVacancy}">
								<c:set var="apptrequest" value="false" />
								<c:set var="appointment" />

								<sql:query var="Appoint" dataSource="${dataSource}">
								SELECT appointID,appointDate,statusAppointment FROM appointment WHERE (userID=userID && apartmentID=${a2.apartmentID})
								</sql:query>
								<%-- If Request is made --%>
									<c:choose>
										<c:when test="${Appoint.rowCount==1}">
										<c:forEach items="${Appoint.rows}" var="a3">
											<c:choose>
												<%-- Print Date --%>
												<c:when test="${a3.appointDate != null }">
													<td><c:out value="${a3.appointDate}" /></td>
												</c:when>
												<c:when test="${a3.appointDate == null }">
													<td>Date not Available</td>
												</c:when>
												<%-- Print Date --%>
											</c:choose>
											<%-- Print Status --%>
											 <c:choose>
												<c:when
													test="${a3.statusAppointment == 'Requested' || a3.statusAppointment == 'Accepted' || a3.statusAppointment == 'Deny'}">
													<td><c:out value="${a3.statusAppointment}" /></td>
												</c:when>
 												<%--for accept/deny --%>
												<c:when test="${a3.statusAppointment != 'Requested' && a3.statusAppointment != 'Accepted' && a3.statusAppointment != 'Deny'}">
													<td><a
														href="LookUpApartment?appointmentId=<c:out value="${a3.appointID}" />">Accept</a>
													<a
														href="Deny?appointmentId=<c:out value="${a3.appointID }" />&apotdate=<c:out value="${a3.appointDate }" />">Deny</a>
														</td>
												</c:when>
											</c:choose>
											</c:forEach>
										</c:when>
										<c:when test="${Appoint.rowCount==0}">
											<td></td>
											<td><a
												href="RequestAppointment?aptID=<c:out value="${a2.apartmentID}" />">Request
													for Appointment</a></td>									
										</c:when>
									</c:choose>
								<%-- If request is made --%>
							</c:when>
							<%-- If apartment is vacant --%>
							<c:when test="${!a2.apartmentVacancy}">
								<td></td>
								<td></td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
			<a href='logout'>Logout</a>
		</c:when>
	</c:choose>
</body>
</html>