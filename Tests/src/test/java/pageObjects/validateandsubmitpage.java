package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class validateandsubmitpage {

	public RemoteWebDriver driver;

	By validate_submit=By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/button[1]");

	public validateandsubmitpage(RemoteWebDriver driver) {
		this.driver=driver;} 

	public void validateANDSubmit() throws IOException {
		driver.findElement(validate_submit).click();}}
