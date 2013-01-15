package servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLOperations {

	//We can read from the XML file by using Xpath on it!
	public void readFromXML() throws ParserConfigurationException, SAXException, 
    IOException, XPathExpressionException {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse("file.xml");

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr 
	     = xpath.compile("//Task/NameOfTask/text()");

	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
	    for (int i = 0; i < nodes.getLength(); i++) {
	        System.out.println(nodes.item(i).getNodeValue()); 
	    }

	}
	
	
	public void writeToExistingXMLFile(ArrayList<Task> theTasks) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	     Document document = documentBuilder.parse("file.xml");
	     Element rootElement = document.getDocumentElement();
                
    	       
		for(int i = 1 ; i < theTasks.size() ; i++)
		{
     // Task as its sub element
		Element Task = document.createElement("Task");
		rootElement.appendChild(Task);
 
		// set attribute to staff element
		Attr attr = document.createAttribute("id");
		attr.setValue(Integer.toString(i));
		Task.setAttributeNode(attr);
 
		
		// NameOfTask elements
		Element NameOfTask = document.createElement("NameOfTask");
		NameOfTask.appendChild(document.createTextNode(((servlets.Task)theTasks.get(i)).NameOfTask));
		Task.appendChild(NameOfTask);
 
		// EmailAddress elements
		Element EmailAddress = document.createElement("EmailAddress");
		EmailAddress.appendChild(document.createTextNode(((servlets.Task)theTasks.get(i)).EmailAddress));
		Task.appendChild(EmailAddress);		 

		// Number elements
		Element Number = document.createElement("Number");
		Task.appendChild(Number);
 
		// EmailAddress elements
		Element Wager = document.createElement("Wager");
		Wager.appendChild(document.createTextNode(((servlets.Task)theTasks.get(i)).Wager));
		Task.appendChild(Wager);
		
		// TaskDescription elements
		Element TaskDescription = document.createElement("TaskDescription");
		TaskDescription.appendChild(document.createTextNode(((servlets.Task)theTasks.get(i)).TaskDescription));
		Task.appendChild(TaskDescription);
		}
		
        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("file.xml");
        transformer.transform(source, result);
    }

	public void createTheXMLFile(String nameOfTask , String emailAddress, String number, String wager, String taskDescription)
	{
		 try {
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		 
				// root elements as Task Assistant
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("TaskAssistant");
				doc.appendChild(rootElement);
		 
				// Task as its sub element
				Element Task = doc.createElement("Task");
				rootElement.appendChild(Task);
		 
				// set attribute to staff element
				Attr attr = doc.createAttribute("id");
				attr.setValue("0");
				Task.setAttributeNode(attr);
		 
						 
				// NameOfTask elements
				Element NameOfTask = doc.createElement("NameOfTask");
				NameOfTask.appendChild(doc.createTextNode(nameOfTask));
				Task.appendChild(NameOfTask);
		 
				// EmailAddress elements
				Element EmailAddress = doc.createElement("EmailAddress");
				EmailAddress.appendChild(doc.createTextNode(emailAddress));
				Task.appendChild(EmailAddress);		 

				// Number elements
				Element Number = doc.createElement("Number");
				Number.appendChild(doc.createTextNode(number));
				Task.appendChild(Number);
		 
				// EmailAddress elements
				Element Wager = doc.createElement("Wager");
				Wager.appendChild(doc.createTextNode(wager));
				Task.appendChild(Wager);
				
				// TaskDescription elements
				Element TaskDescription = doc.createElement("TaskDescription");
				TaskDescription.appendChild(doc.createTextNode(taskDescription));
				Task.appendChild(TaskDescription);
		 
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("C:\\Users\\Taizun\\Downloads\\eclipse-jee-juno-SR1-win32-x86_64\\eclipse\\file.xml"));
		 
				transformer.transform(source, result);
		 
				System.out.println("Successfuly saved the File!");
		 
			  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				tfe.printStackTrace();
			  }
			
	}
}
	

