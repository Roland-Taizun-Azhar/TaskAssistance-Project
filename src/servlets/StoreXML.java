package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import validations.Validations;

/**
 * Servlet implementation class StoreXML
 */
public class StoreXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int counter = 0;
	static boolean check = true;
	ArrayList<Task> theTasks = new ArrayList<Task>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Display on invalid log in.
	
		String NameOfTask = request.getParameter("NameOfTask"); // Storing the username.
		String EmailAddress = request.getParameter("EmailAddress");
		String Number = request.getParameter("Number");
		String Wager = request.getParameter("Wager");
		String TaskDescription = request.getParameter("TaskDescription");
		String myIP = request.getRemoteAddr();
		Task myTask = new Task();
		myTask.NameOfTask = NameOfTask;
		myTask.EmailAddress = EmailAddress;
		myTask.Number = Number;
		myTask.Wager = Wager;
		myTask.TaskDescription = TaskDescription;
		System.out.println(myIP);	
		theTasks.add(myTask);
		XMLOperations myOperations = new XMLOperations();
		try {
			if(check)
			{
				myOperations.createTheXMLFile(myTask.NameOfTask ,myTask.EmailAddress ,myTask.Number, 
						myTask.Wager, myTask.TaskDescription);
				check = false;
			}
		/*	if(counter==0)
			{
			myOperations.createTheXMLFile(NameOfTask,EmailAddress,Number,Wager,TaskDescription);
			counter++;
			}*/
			else
			{
			myOperations.writeToExistingXMLFile(theTasks);
			myOperations.readFromXML();
			}
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Validations validate = new Validations();
		if(validate.emailValidation(EmailAddress)&& validate.numberValidation(Number)&&validate.wagerValidation(Wager))
		{	        	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Index.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
