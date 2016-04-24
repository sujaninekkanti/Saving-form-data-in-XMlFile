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

/**
 * Servlet implementation class defaultServlet
 */
@WebServlet("/defaultServlet")
public class defaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public defaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CreateXml xml = new CreateXml();
		xml.createxml();
		
		 request.getRequestDispatcher("/Registration.jsp").include(request, response);
	}
		public class CreateXml{
			
			public static final String xmlFilePath = "D:\\xmlfile.xml";

			public void createxml(){
				try {
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

					// root elements
					Document doc = docBuilder.newDocument();
					Element rootElement = doc.createElement("Users");
					doc.appendChild(rootElement);

					// staff elements
					Element userdetails = doc.createElement("User");
					rootElement.appendChild(userdetails);


					// firstname elements
					Element def = doc.createElement("default");
					def.appendChild(doc.createTextNode("default"));
					userdetails.appendChild(def);

					

					// write the content into xml file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					
					            
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File("G:\\file.xml"));

					// Output to console for testing
					// StreamResult result = new StreamResult(System.out);

					transformer.transform(source, result);

					System.out.println("File saved!");

					 } catch (ParserConfigurationException pce) {
					pce.printStackTrace();
					 } catch (TransformerException tfe) {
					tfe.printStackTrace();
					 }
					}
		}
	}


