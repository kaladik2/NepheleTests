package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class pipelineselectionpage {

	public RemoteWebDriver driver;

	By selectpipeline=By.xpath("/html/body/div[1]/div[3]/div/form/div/table/tbody/tr[7]/td[2]/button");

	public pipelineselectionpage(RemoteWebDriver driver) {
		this.driver=driver;} 

	public void selectpipeline() throws IOException {driver.findElement(selectpipeline).click();}}
