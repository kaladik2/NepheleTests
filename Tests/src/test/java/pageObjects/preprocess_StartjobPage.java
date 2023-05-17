package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class preprocess_StartjobPage {

	public RemoteWebDriver driver;

	By pre_process=By.xpath("//*[@id=\"process-tab\"]");
	By startjob=By.xpath("//*[@id=\"process\"]/div/div/div[1]/a[2]");

	public preprocess_StartjobPage(RemoteWebDriver driver) {
		this.driver=driver;}

	public void clickonpreprocess() throws InterruptedException{ 
		driver.findElement(pre_process).click();
		Thread.sleep(10000);}

	public void clickonstartjob(){ 
		driver.findElement(startjob).click();}}
