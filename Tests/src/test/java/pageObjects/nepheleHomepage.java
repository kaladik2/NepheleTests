package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class nepheleHomepage {

	public RemoteWebDriver driver;

	By ulE=By.xpath("//*[@id=\"mytab\"]");

	public nepheleHomepage(RemoteWebDriver driver) {
		this.driver=driver;}

	public void validatethepageislaunched() {
		List<WebElement> list1=driver.findElements(By.tagName("a"));
		System.out.println(list1.size());

		for (int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i).getText());}}}
