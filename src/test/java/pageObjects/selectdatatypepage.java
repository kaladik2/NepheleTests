package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class selectdatatypepage {

	public RemoteWebDriver driver;

	By pairedendFASTQ=By.xpath("//*[@id=\"data_type-0\"]");
	By next=By.xpath("/html/body/div[1]/div[3]/div/form/button");

	public selectdatatypepage(RemoteWebDriver driver) {
		this.driver=driver;} 

	public void selectdatatype() {
		driver.findElement(pairedendFASTQ).click();
		driver.findElement(next).click();}}
