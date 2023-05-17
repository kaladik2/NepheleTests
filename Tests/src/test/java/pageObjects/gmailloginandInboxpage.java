package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import Utilities.getprop;
public class gmailloginandInboxpage {

	public RemoteWebDriver driver;
	public String txt1,txt2;
	public boolean checkemail1;
	public boolean checkemail2;
	public boolean checkgamil;



	By emailE=By.xpath("//*[@id=\"identifierId\"]");
	By nextbutton_emailE=By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
	By pwdE=By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
	By nextbutton_pwdE=By.xpath("//*[@id=\"passwordNext\"]/div/button/span");

	public gmailloginandInboxpage(RemoteWebDriver driver) {
		this.driver=driver;} 

	/*
	 * ------------------------------------
	 * Open Gmail with valid credentials
	 * ---------------------------------------
	 */
	public boolean gmaillogin(String jobid) throws IOException, InterruptedException {
		try{getprop gp=new getprop();
		Properties prop=new Properties();
		prop=gp.get();
		String gmail=prop.getProperty("gmailurl");
		String email=prop.getProperty("testemail");
		driver.get(gmail);
		driver.findElement(emailE).sendKeys(email);
		driver.findElement(nextbutton_emailE).click();
		byte[] decodedpassword=Base64.decodeBase64("I3FhdGVhbUBiaW9pbmZvcm1hdGljcw==");
		String pwd=new String(decodedpassword); 
		driver.findElement(pwdE).sendKeys(pwd);
		driver.findElement(nextbutton_pwdE).click();

		List<WebElement> unreademail = driver.findElements(By.className("zE"));
		// Display count of unread emails
		System.out.println("Total No. of Unread Mails: " + unreademail.size());

		List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
		System.out.println(a.size()); 

		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i).getText());
			if(a.get(i).getText().contains("NIAID BCBB Nephele .")){
				a.get(0).click();

				WebElement e=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[1]/div[1]"));
				System.out.println(e.getText());
				txt1=e.getText();


				WebElement backtoinboxE=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div[1]/div/div"));
				backtoinboxE.click();

				a.get(1).click();
				Thread.sleep(5000);
				WebElement e1=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[1]"));
				System.out.println(e1.getText());
				txt2=e1.getText();}}
		checkemail1=validate_email1(txt1,txt2,jobid);
		System.out.println("email1"+checkemail1);

		checkemail2=validate_email2(txt1,txt2,jobid); 
		System.out.println("email2"+checkemail2);
		checkgamil=true;}
		catch(Exception e) {
			checkgamil=false;}
		return checkgamil;}


	/*
	 * -------------------------
	 * Validating the Email 1
	 * --------------------------
	 */
	public  boolean  validate_email2(String txt1,String txt2,String jobid) {
		boolean b=false;
		if(txt1.contains("Thank you for your Nephele Analysis pipeline submission") || txt2.contains("Thank you for your Nephele Analysis pipeline submission") ) {

			if(txt1.contains("Nephele Version:") && txt1.contains("Run Type") && txt1.contains("Job Description")  && txt1.contains("Job ID") && txt1.contains("Pipeline parameters") && txt1.contains(jobid) ||
					txt2.contains("Nephele Version:") && txt2.contains("Run Type") && txt2.contains("Job Description")  && txt2.contains("Job ID") && txt2.contains("Pipeline parameters") && txt2.contains(jobid))
				b=true;}
		else {b=false; }
		return b;}

	/*
	 * ------------------------
	 * Validating the Email 2
	 * ---------------------------
	 */
	public  boolean  validate_email1(String txt1,String txt2,String jobid) {
		boolean b=false;
		if(txt1.contains("Your pipeline submission with ID") && txt1.contains(jobid)|| txt2.contains("Your pipeline submission with ID") && txt2.contains(jobid)) {b=true;}
		else {b=false;}
		return b;}}
