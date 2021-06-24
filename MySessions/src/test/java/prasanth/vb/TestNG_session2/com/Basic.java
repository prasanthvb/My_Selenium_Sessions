package prasanth.vb.TestNG_session2.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void VerifyTitle() {
		String title = driver.getTitle();
		System.out.println(title);

		Assert.assertEquals(title, "Sample Test Page");
	}

	@Test
	public void verifyTextbox() {
		WebElement textbox = driver.findElement(By.xpath("//input[@id='fname']"));
		textbox.clear();
		textbox.sendKeys("Prasanth");

		// Select Automation Check box
		driver.findElement(By.xpath("//input[@type='checkbox' and @class='Automation']")).click();
	}

	@AfterMethod
	public void quit() {
		driver.close();
	}
}
