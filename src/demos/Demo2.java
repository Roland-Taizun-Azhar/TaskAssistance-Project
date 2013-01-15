package demos;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jvoicexml.ConnectionInformation;
import org.jvoicexml.JVoiceXml;
import org.jvoicexml.Session;
import org.jvoicexml.client.BasicConnectionInformation;

public class Demo2 {

	public void sayHelloWorld() throws NamingException
	{
		try
		{
			Hashtable<String, String> myHash = new Hashtable<String, String>();
			myHash.put("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
			myHash.put("java.naming.provider.url", "rmi://localhost:1099");
			myHash.put("java.naming.rmi.security.manager", "true");

			InitialContext myContext = new InitialContext(myHash);
			JVoiceXml myJVoiceXml = (JVoiceXml) myContext.lookup("JVoiceXml");
			ConnectionInformation info = new BasicConnectionInformation("dummy", "jsapi10", "jsapi10");
			Session session = myJVoiceXml.createSession(info);
			URI uri = new URI("http://localhost:8080/TaskAssistant/input.vxml");
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
