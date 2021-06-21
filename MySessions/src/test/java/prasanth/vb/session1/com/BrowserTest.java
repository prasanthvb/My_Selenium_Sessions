package prasanth.vb.session1.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://github.com/prasanthvb");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String repo = driver.findElement(By.xpath("//span[@title='Selenium_Framework']")).getText();

		if (repo.contains("Selenium_Framework")) {
			System.out.println("Test is passed");
			driver.quit();
		}
		
		
	}
}
