<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="gray">
<form method="get" action="Transfer" enctype="multipart/form-data">
<table align="left">

<tr>
<td>Enter the credit amount you want to transfer</td>
<td><input type="text" name="amount"> </td>
</tr>

<tr>
<td>Select the user to transfer</td>
<td><select name="users">
<option value="Radhika">Radhika</option>
<option value="Reema">Reema</option>
<option value="Reena">Reena</option>
<option value="Riya">Riya</option>
<option value="Priya">Priya</option>
<option value="Laxmi">Laxmi</option>
<option value="Rajnandini">Rajnandini</option>
<option value="Isha">Isha</option>
<option value="Anushree">Anushree</option>
<option value="Saanvi">Saanvi</option>



</select></td>
</tr>
<tr>
<td><input type="submit" value="Transfer" name="Submit"> 

</tr>



</table>




</form>
</body>
</html>