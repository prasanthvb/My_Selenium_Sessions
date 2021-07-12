package prasanth.vb.TestNG_session2.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	
	@Parameters({ "URL" })
	@BeforeMethod	
	public void Start(String url) {
		chrome(url);
	}
	
	
	private void chrome(String URL) {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void quit() {
		driver.close();
	}
}
