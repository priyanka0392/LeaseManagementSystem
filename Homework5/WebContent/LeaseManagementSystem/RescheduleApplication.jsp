<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import='java.util.ArrayList, LeaseManagementSystem.*'%>
<%@page import='LeaseManagementSystem.appointment'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
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
	<table border=1>
		<th>Application #</th>
		<th>Application Name</th>
		<th>Contact #</th>
		<th># People</th>
		<th>Occupation</th>
		<th>Preferences</th>
		<th>Need from Date</th>
		<th>Appointment Date</th>
		<th>Status</th>
		<th>Ruled Out dates</th>
		<th>Rented Out</th>
		<sql:query var="appointment" dataSource="${dataSource}">
		select ruleddate.ruled_dates,ruleddate.application_id,appointment.appointID,userdetails.username,userdetails.contactNo,userdetails.maxPeople,userdetails.occupation,userdetails.preference,userdetails.nfd,appointment.statusAppointment,appointment.appointDate from userdetails,appointment,ruleddate where userdetails.userID=appointment.userID and appointment.apartmentID=${param.ApartmentID} and ruleddate.application_id=appointment.appointID;
	
      <%--  SELECT appointment.appointID, appointment.statusAppointment,appointment.appointDate, userdetails.username,userdetails.contactNo,userdetails.maxPeople,userdetails.occupation,userdetails.preference,userdetails.nfd from appointment INNER JOIN userdetails ON userdetails.userID= appointment.userID where appointment.apartmentID=${param.ApartmentID}; --%>
        </sql:query>
		<c:forEach items="${appointment.rows}" var="appoint">
			<c:if test="${appoint.apartment.apartmentNo==param.ApartmentNo}">

				<tr>
					<td><c:out value="${appoint.appointID}" /></td>
					<td><c:out value="${appoint.username}" /></td>
					<td><c:out value="${appoint.contactNo }" /></td>
					<td><c:out value="${appoint.maxPeople }" /></td>
					<td><c:out value="${appoint.occupation }" /></td>
					<td><c:out value="${appoint.preference }" /></td>
					<td><c:out value="${appoint.nfd }" /></td>

					<c:choose>
						<c:when
							test="${appoint.statusAppointment.equals('Requested') || appoint.statusAppointment.equals('Deny')}">
							<td>
								<form method="post">
									<input type="hidden"
										value="<c:out value="${appoint.appointID}" />"
										name="txtappointID" /> <input type=text name="apotdate">
									<input type="submit" value="submit" />
								</form>
							</td>
						</c:when>
						<c:when test="${appoint.statusAppointment.equals('Scheduled') }"> 
 <td></td>
						</c:when>
					</c:choose>

					<td><c:out value="${appoint.statusAppointment}" /></td>
					
					<c:if test="${appoint.ruled_dates!=null }">
						<td><c:out value="${appoint.ruled_dates }" /></td>
					</c:if>
					
			
					<td><a
						href="RentOut?AppointmentID=<c:out value="${appoint.appointID}" />">Rent</a></td>
				</tr>
</c:if>
			
		</c:forEach>

	</table>
	<a href='logout'>Logout</a>
</body>
</html>