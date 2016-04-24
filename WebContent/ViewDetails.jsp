<%@ page contentType="text/html; charset=utf-8" language="java" import="javax.xml.parsers.DocumentBuilderFactory,javax.xml.parsers.DocumentBuilder,org.w3c.dom.*" errorPage="" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<% 
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 

DocumentBuilder db = dbf.newDocumentBuilder(); 

Document doc = db.parse("G:\\file.xml"); 

NodeList FirstName = doc.getElementsByTagName("firstName"); 
NodeList LastName = doc.getElementsByTagName("lastName");
NodeList Password = doc.getElementsByTagName("password");
NodeList Department =doc.getElementsByTagName("department"); 
NodeList Age = doc.getElementsByTagName("age");
NodeList Salary = doc.getElementsByTagName("salary"); 
%> 
 <html> 
<head> 
<title>View Details</title> 
</head> 

<body> 

<h3> User with the given firstname already exits </h3><br></br><br></br><br></br>

<table align ="center" border="1">
<tr>
<td>FirstName</td><td>LastName</td><td>Password</td><td>Department</td><td>Age</td><td>Salary</td>
</tr>
</table>

<table align ="center" border="1"> 
<% 
int i; 
for(i=0;i<=FirstName.getLength()-1;i++) 
{ 
%> 
<tr> 
<td> 

<%= FirstName.item(i).getFirstChild().getNodeValue()%> 
 </td> 
<td> 
<%= LastName.item(i).getFirstChild().getNodeValue()%> 
</td>
<td> 
<%= Password.item(i).getFirstChild().getNodeValue()%> 
</td>  
<td> 
<%= Department.item(i).getFirstChild().getNodeValue()%> 
</td> 
<td> 
<%= Age.item(i).getFirstChild().getNodeValue()%> 
</td>
<td> 
<%= Salary.item(i).getFirstChild().getNodeValue()%> 
</td> 
</tr> 
<% 
} 
%> 
</table> 
<a href="Registration.jsp">click here for registering new user</a>
</body> 
</html>