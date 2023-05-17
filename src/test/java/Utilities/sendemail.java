package Utilities;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendemail {
	public  List<String> receiverlist = new ArrayList<String>();

	public  void  sendemailsnotofications(String htmltxt,String subject,String imageLocation) {
		System.out.println(subject);
		try { 
			receiverlist.add(0,"krishnaveni.kaladi@nih.gov");

			for(int i=0;i<receiverlist.size();i++){
				String to=receiverlist.get(i);
				String from="krishnaveni.kaladi@nih.gov"; 
				Properties prop=System.getProperties();

				prop.put("mail.smtp.auth",false);
				prop.put("mail.host","post.niaid.nih.gov"); 
				prop.put("mail.debug","true"); 

				// Setup authentication, get session
				Session session = Session.getInstance(prop,
						new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"***", "***");}});

				MimeMessage msg=new MimeMessage(session);
				msg.setFrom(new InternetAddress(from));
				msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
				msg.setSubject(subject);

				// This mail has 2 part, the BODY and the embedded image
				MimeMultipart multipart = new MimeMultipart("related");
				BodyPart messageBodyPart = new MimeBodyPart(); 
				//String htmltxt= "<p><b>Hello All,</b></p><p> Failure is detected for <a href=\"https://qa.gris.niaid.nih.gov\">SEQRQA</a> </p><p><b>Failure Details</b></p><table  border= 1  style=\"width:100%\"><tr><th>Nature of Error</th><th>Possible Issue</th><th>Contact</th></tr><tr><td>Server Error</td><td>Postgres DB</td><td>OEB</td></tr></table><p><b>Other Details</b></p><table  border= 1  style=\"width:100%\"><tr><th>Test Frequency </th><th>Server(s)</th><th>GoCD Pipeline</th><tr><td>MON-FRI @5 PM</td><td>ai-cgsappqa3 (application) and ai-cgsdbqa3 (DataBase)</td><td>BCBB_GRIS/Seqr2QACheck/SeqrPageLaunchTestOnQA</td></table><p><b>Screenshot</b></p><table border=1 style=\"width:100%\"><tr><td><img src=\"cid:image\"></td></tr></table><br><p>Thanks,<br>GRIS Testing Team";
				messageBodyPart.setContent(htmltxt,"text/html");


				// add it
				multipart.addBodyPart(messageBodyPart);

				// second part (the image)
				messageBodyPart = new MimeBodyPart();
				DataSource fds = new FileDataSource(imageLocation);

				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setHeader("Content-ID", "<image>");

				// add image to the MultiPart
				multipart.addBodyPart(messageBodyPart);

				// put everything together
				msg.setContent(multipart);
				Transport.send(msg);
				System.out.println("mesg sent");}//end for loop
		}//end try
		catch(Exception e) {  
			System.out.println(e.getMessage());}}}
