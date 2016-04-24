<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegistrationPage</title>
<script> 
function validateform()
{
var fname=document.form.uname.value;
var lname=document.form.ulastname.value;
var pass=document.form.upass.value;
var dept=document.form.udept.value;
var age=document.form.uage.value;
var salary=document.form.usalary.value;
  if(fname=="")
  {  
  alert("first name can't be blank");  
  return false;  
  }
  if(lname=="")
   {
    alert("last name can't be blank");
     return false;
    }
  if(pass=="")
  {
   alert("Password can't be blank");
    return false;
   }
  if(dept=="")
  {
   alert("department name can't be blank");
    return false;
   }
  if(age=="")
  {
   alert("age can't be blank");
    return false;
   }
  if(salary=="")
  {
   alert("salary can't be blank");
    return false;
   }
   } 
</script>
</head>
<body>
<form name="form" action='ValidateServlet' method=post onsubmit="return validateform();">
<table align="center" border='1'>
                <tr><td align="center">
                <th>Registration Form</th>
                </tr>
				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text" name="ulastname"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="upass"></td>
				</tr>
				<tr>
					<td>Department :</td>
					<td><input type="text" name="udept"></td>
				</tr>
				<tr>
					<td>Age :</td>
					<td><input type="text" name="uage"></td>
				</tr>
				<tr>
					<td>Salary :</td>
					<td><input type="text" name="usalary"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
		</table>
		</form>
</body>
</html>