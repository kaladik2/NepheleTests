package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class succesfulsubmissionpage {

	public RemoteWebDriver driver;
	public String jobid="";

	By msg=By.xpath("/html/body/div[1]/div[3]/div/h1");
	By p=By.xpath("/html/body/div[1]/div[3]/div/p[1]");
	By codeE=By.xpath("/html/body/div[1]/div[3]/div/p[1]/code");

	public succesfulsubmissionpage(RemoteWebDriver driver) {
		this.driver=driver;} 

	public boolean validatemsg() throws IOException, InterruptedException {
		boolean b=false;
		Thread.sleep(10000);
		String actualtxt=driver.findElement(msg).getText();
		String actualp=driver.findElement(p).getText();
		jobid=driver.findElement(codeE).getText();
		if(actualtxt.contains("Submission success") && actualp.contains("has been submitted to the system")) {b=true;}
		else {b=false;}
		return b;}}
