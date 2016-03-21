<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment Feedback</title>
</head>
<body>
<form method='post' action='RentOut'>
<input type="hidden" name="appointID" value="appointID"></input>
Enter termination date<input type="date" name="termination"></input></br></br>
Lease holder's name<input type="text" name="name"></input></br></br>
List of documents<textarea rows="2" cols="16"></textarea></br></br>
<input type="hidden" name="AppointmentID" value="${appointmentID }">
<input type="submit" value="submit"></input>
</form>
<a href='logout'>Logout</a>

</body>
</html>