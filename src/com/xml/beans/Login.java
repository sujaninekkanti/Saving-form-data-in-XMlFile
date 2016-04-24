package com.xml.beans;

public class Login {
String firstName;
String password;
public Login() {
	super();
	// TODO Auto-generated constructor stub
}
public Login(String firstName, String password) {
	super();
	this.firstName = firstName;
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
