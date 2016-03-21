<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import='java.util.ArrayList, LeaseManagementSystem.*'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ManagerHome</title>
</head>
<body>
<c:choose>
		<c:when test="${pageContext.session['new']}">
			<c:redirect url="Login" />
		</c:when>
		<c:when test="${!pageContext.session['new']}">
		

	
	<h1>Welcome</h1>
	<p>
		<c:out value="${username}"></c:out>
		!
	</p>
	
		<a href='AddApartment'>Add Apartment<br/></a>
		 <a href='ViewApartment'>View Apartment<br /></a>  
		 <a href='logout'>Logout</a>
		
	
	</c:when>
	</c:choose>
</body>
</html>