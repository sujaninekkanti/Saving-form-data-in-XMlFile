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

import com.xml.beans.Login;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("uname");
		String password = request.getParameter("upass");
		
		
		Login login = new Login();
		
		
		login.setFirstName(firstName);
		login.setPassword(password);
		
		System.out.println("in login servlet");
		
		try{
		     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		     DocumentBuilder builder = factory.newDocumentBuilder();
		     Document document = builder.parse(new File("G:\\file.xml"));
		     document.getDocumentElement().normalize();
		     NodeList nList = document.getElementsByTagName("User");
		     
		     System.out.println("in try block............");
			    String pass="";
			    String fname="";
			     for (int temp = 1; temp < nList.getLength(); temp++)
			     {
			        Node node = nList.item(temp);
			        if (node.getNodeType() == Node.ELEMENT_NODE)
			        {
			           Element eElement = (Element) node;
			           System.out.println(eElement.getElementsByTagName("firstName").item(0).getTextContent());
			           System.out.println(eElement.getElementsByTagName("password").item(0).getTextContent());
			            pass = eElement.getElementsByTagName("password").item(0).getTextContent();
			            fname = eElement.getElementsByTagName("firstName").item(0).getTextContent();
			           if(pass.equals(login.getPassword()) && fname.equals(login.getFirstName()))
			           {
			        	   System.out.println("logeddd in.......");
			        	   request.getRequestDispatcher("/Successlogin.jsp").include(request, response);
			        	  break;
			           }
			          
			        }
				}
			     
			     if(!(fname.equals(login.getFirstName()) && pass.equals(login.getPassword()))){
			    	 request.getRequestDispatcher("/Invalid.jsp").include(request, response);
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
