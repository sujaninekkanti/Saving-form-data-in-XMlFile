package com.xml.beans;

public class Registration {
String firstName;
String lastName;
String password;
String department;
String age;
String salary;
public Registration() {
	super();
	// TODO Auto-generated constructor stub
}
public Registration(String firstName, String lastName,String password, String department,
		String age, String salary) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.department = department;
	this.age = age;
	this.salary = salary;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public void setPassword(String password){
	this.password = password;
}
public String getDepartment() {
	return department;
}
public String getPassword(){
	return password;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}

}
