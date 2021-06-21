package prasanth.vb.session1.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Using select class
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='testingDropdown']")));
		// Select by value
		dropdown.selectByValue("Performance");
		Thread.sleep(2000);
		// select by index
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		// select by visible text
		dropdown.selectByVisibleText("Automation Testing");
		Thread.sleep(2000);
		driver.quit();
	}
}
