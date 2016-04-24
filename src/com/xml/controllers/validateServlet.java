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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xml.beans.Registration;

/**
 * Servlet implementation class validateServlet
 */
@WebServlet("/validateServlet")
public class validateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateServlet() {
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
	
		System.out.println(reg.getFirstName()+"in  validate servlet");
		
		try{
			     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			     DocumentBuilder builder = factory.newDocumentBuilder();
			     Document document = builder.parse(new File("G:\\file.xml"));
			     document.getDocumentElement().normalize();
			     NodeList nList = document.getElementsByTagName("User");
			     
			     System.out.println("in try block............");
			    String f="";
			     for (int temp = 1; temp < nList.getLength(); temp++)
			     {
			        Node node = nList.item(temp);
			        if (node.getNodeType() == Node.ELEMENT_NODE)
			        {
			           Element eElement = (Element) node;
			           System.out.println(eElement.getElementsByTagName("firstName").item(0).getTextContent());
			            f = eElement.getElementsByTagName("firstName").item(0).getTextContent();
			           if(f.equals(reg.getFirstName()))
			           {
			        	   System.out.println("already exists");
			        	   request.getRequestDispatcher("/Userexists.jsp").include(request, response);
			        	  break;
			           }
			          
			        }
				}
			     
			     if(!f.equals(reg.getFirstName())){
			    	 request.getRequestDispatcher("/registrationServlet").include(request, response);
			     }
		}
		catch(ParserConfigurationException pe){
			
		}
		catch(SAXException se){
			
		}
	    catch(IOException ie){
	    	
	    }
	}

}
