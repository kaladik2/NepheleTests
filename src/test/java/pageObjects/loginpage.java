package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Utilities.getprop;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class loginpage {

	public RemoteWebDriver driver;

	By email=By.xpath("//*[@id=\"email_addr\"]");
	By signin=By.xpath("/html/body/div[1]/div[3]/div/form/div/div[3]/input");

	public loginpage(RemoteWebDriver driver) {
		this.driver=driver;} 


	public void loginusingregisteredemail() throws IOException {
		getprop gp=new getprop();
		Properties prop=new Properties();
		prop=gp.get();
		String  emailtxt=prop.getProperty("testemail");
		driver.findElement(email).sendKeys(emailtxt);
		driver.findElement(signin).click();}}
