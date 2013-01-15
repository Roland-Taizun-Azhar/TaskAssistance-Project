package demos;

import java.net.URI;
import java.net.URISyntaxException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import org.jvoicexml.ConnectionInformation;
import org.jvoicexml.JVoiceXml;
import org.jvoicexml.Session;
import org.jvoicexml.client.BasicConnectionInformation;



public class Demo1{

	public void sayHelloWorld (String IP) throws NamingException
	{
		try
		{				
			Hashtable<String, String> myHash = new Hashtable<String, String>();
			myHash.put("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
			myHash.put("java.naming.provider.url", "rmi://"+IP+":1099");
			myHash.put("java.naming.rmi.security.manager", "true");

			InitialContext myContext = new InitialContext(myHash);
			JVoiceXml myJVoiceXml = (JVoiceXml) myContext.lookup("JVoiceXml");
			ConnectionInformation info = new BasicConnectionInformation("dummy", "jsapi10", "jsapi10");
			Session session = myJVoiceXml.createSession(info);
			URI uri = new URI("http://129.21.71.19:8080/TaskAssistant/hello.vxml");
			session.call(uri);
			session.waitSessionEnd();
			session.hangup();
		} catch (org.jvoicexml.event.JVoiceXMLEvent e)
		{
			e.printStackTrace();
			System.exit(-1);
		} catch (URISyntaxException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void promptInFormFilling(String IP) throws NamingException
	{
		try
		{
			Hashtable<String, String> myHash = new Hashtable<String, String>();
			myHash.put("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
			myHash.put("java.naming.provider.url", "rmi://"+IP+":1099");
			myHash.put("java.naming.rmi.security.manager", "true");

			InitialContext myContext = new InitialContext(myHash);
			JVoiceXml myJVoiceXml = (JVoiceXml) myContext.lookup("JVoiceXml");
			ConnectionInformation info = new BasicConnectionInformation("dummy", "jsapi10", "jsapi10");
			Session session = myJVoiceXml.createSession(info);
			URI uri = new URI("http://129.21.71.19:8080/TaskAssistant/VoiceAssistedTaskJVXML.vxml");
			session.call(uri);
			session.waitSessionEnd();
			session.hangup();
		} catch (org.jvoicexml.event.JVoiceXMLEvent e)
		{
			e.printStackTrace();
			System.exit(-1);
		} catch (URISyntaxException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
}