<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import='java.util.ArrayList, LeaseManagementSystem.*'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
	<h1>Sign Up</h1>
	<form method='post' action='RegisterResident'>
		<table style='width: 100%'>
			<tr>
				<td>Username</td>
				<td><input rows='4' columns='2' name='name'></input></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input rows='4' columns='2' name='email'></input></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input rows='4' columns='2' name='pwd'></input></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input rows='4' columns='2' name='cpwd'></input></td>
			</tr>
			<tr>
				<td>Contact #</td>
				<td><input rows='4' columns='2' name='contact_num'></input></td>
			</tr>
			<tr>
				<td>#People</td>
				<td><input rows='4' columns='2' name='people_num'></input></td>
			</tr>
			<tr>
				<td>Occupation</td>
				<td><input type='radio' name='occupation' value='1' id='1'>Student</input></td>
				<td><input type='radio' name='occupation' value='2' id='2'>Family</input></td>
				<td><input type='radio' name='occupation' value='3' id='3'>Business</input></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><input type='radio' name='type' value='1' id='1'>1BHK</input>
				<td />
				<td><input type='radio' name='type' value='2' id='2'>2BHK-1Bath</input></td>
				<td><input type='radio' name='type' value='3' id='3'>2BHK-2Bath</input></td>
			</tr>
			<tr>
				<td>Preferences</td>
				<td><input rows='4' columns='6' name='preference'></input></td>
			</tr>
			<tr>
				<td>Need from date</td>
				<td><input rows='4' columns='2' name='nfd'></input></td>
			</tr>
		</table>
		<input type='reset' value='clear' /> <a class='btn'></a> <input
			type='submit' name='logout' value='submit'></input>
	</form>

	</c:when>
	</c:choose>
</body>
</html>