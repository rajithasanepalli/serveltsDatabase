<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentDataservelet" method="post">
 <input type="number" name="sid" placeholder="Enter the Student Id">
	<input type="text" name="sname" placeholder="Enter the Student Name">
	<input type="date" name="sdob" placeholder="Enter the Student DOB">
	 <input type="text" name="semail" placeholder="Enter the Student Email">
	<input type="tel" id="phone" name="stel" placeholder="Enter the student Phone">
	 <input type="text" name="scourse" placeholder="Enter the Student course">
	<input type="submit" value = "submit">
	</form>

</body>
</html>