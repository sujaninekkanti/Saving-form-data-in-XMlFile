<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<script type="text/javascript">
function validateform(){
	var fname=document.form.uname.value;
	var pass=document.form.upass.value;
	if(fname=="")
	  {  
	  alert("first name can't be blank");  
	  return false;  
	  }
	  if(pass=="")
	  {
	   alert("Password can't be blank");
	    return false;
	   }	
}


</script>
<body>
<form name="form" action='loginServlet' method=post onsubmit="return validateform();">
<table align="center" border='1'>
                <tr><td align="center">
                <th>Login Form</th>
                </tr>
				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="upass"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
				</table>
</form>
</body>
</html>