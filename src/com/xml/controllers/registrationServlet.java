package com.xml.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.xml.beans.Registration;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Registration reg = new Registration();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("uname");
		String lastName = request.getParameter("ulastname");
		String password = request.getParameter("upass");
		String department = request.getParameter("udept");
		String age = request.getParameter("uage");
		String salary = request.getParameter("usalary");

		reg.setFirstName(firstName);
		reg.setLastName(lastName);
		reg.setPassword(password);
		reg.setDepartment(department);
		reg.setAge(age);
		reg.setSalary(salary);
	
		System.out.println(reg.getFirstName()+"in  reg servlet");
		
		
		AppendXml  axml = new AppendXml();
		axml.appendUser(reg.getFirstName(),reg.getLastName(),reg.getPassword(),reg.getDepartment(),reg.getAge(),reg.getSalary());
		
		request.getRequestDispatcher("/Success.jsp").include(request, response);
		     
	}
	public class AppendXml{
		
	
		public static final String xmlFilePath = "G:\\xmlfile.xml";
		
		
		
		public void appendUser(String firstName,String lastname,String password,String department,String age,String salary) {
			
			System.out.println("in append xml appenduser method");
			try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			     DocumentBuilder builder = factory.newDocumentBuilder();
			     Document document = builder.parse("G:\\file.xml");
			     document.getDocumentElement().normalize();
			     
			     Element usersTag =  (Element) document.getElementsByTagName("Users").item(0);
			     Element newUser = document.createElement("User");

			     Element firstNameElement = document.createElement("firstName");
			     firstNameElement.setTextContent(firstName);

			     Element lastNameElement = document.createElement("lastName");
			     lastNameElement.setTextContent(lastname);
			     
			     
			     Element passwordElement = document.createElement("password");
			     passwordElement.setTextContent(password);
			     
			     
			     Element departmentElement = document.createElement("department");
			     departmentElement.setTextContent(department);
			     
			     Element ageElement = document.createElement("age");
			     ageElement.setTextContent(age);
			     
			     Element salaryElement = document.createElement("salary");
			     salaryElement.setTextContent(salary);
			     

			     newUser.appendChild(firstNameElement);
			     newUser.appendChild(lastNameElement);
			     newUser.appendChild(passwordElement);
			     newUser.appendChild(departmentElement);
			     newUser.appendChild(ageElement);
			     newUser.appendChild(salaryElement);

			     usersTag.appendChild(newUser);
			     
			     TransformerFactory transformerFactory = TransformerFactory.newInstance();
			       Transformer transformer = transformerFactory.newTransformer();
			       DOMSource source = new DOMSource(document);
			       StreamResult result = new StreamResult(new File("G:\\file.xml"));
			       transformer.transform(source, result);

			       System.out.println("Done");
			     
			}
			catch(ParserConfigurationException pe ){
				
			}
			catch(TransformerException te){
				
			}
			catch(SAXException se){
				
			}
			catch(IOException ie){
				
			}
		}

	}

}
