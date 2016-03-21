<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddApartment</title>
</head>
<body>
<form method='post' action='AddApartment'>
		<table style='width: 100%'>
			<tr>
				<td>Apartment Number</td>
				<td><textarea rows='4' columns='5' name='apartment_num'></textarea></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><input type='radio' name='type' value='1' id='1'>1BHK</input>
				<td />
				<td><input type='radio' name='type' value='2' id='2'>2BHK-Bath</input></td>
				<td><input type='radio' name='type' value='3' id='3'>2BHK-2Bath</input></td>
			</tr>
			<tr>
				<td>Maximum People</td>
				<td><textarea rows='4' columns='1' name='max_people'></textarea></td>
			</tr>
			<tr>
				<td>Rent</td>
				<td><textarea rows='4' columns='1' name='rent'></textarea></td>
			</tr>
			<tr>
				<td>Deposits</td>
				<td><textarea rows='4' columns='1' name='deposit'></textarea></td>
			</tr>
			<tr>
			<td>Facility</td>
			<td><textarea rows='4' columns='1' name='facility'></textarea></td>
			</tr>
			
 			<tr> 
 			<td>VACANT</td> 
			<td><textarea rows='4' columns='1' name='vacant'></textarea></td> 
 			</tr> 
			
		</table>

		<input type='submit' value='clear'></input> <a class='btn'
			href='/submit'></a> <input class='btn' type='submit' value='submit'><br />
	</form>
	<a href='logout'>Logout</a>

</body>
</html>