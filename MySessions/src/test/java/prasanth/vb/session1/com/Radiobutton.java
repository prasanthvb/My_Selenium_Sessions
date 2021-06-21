package prasanth.vb.session1.com;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobutton {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// click on male radio button
		WebElement maleradiobtn = driver.findElement(By.xpath("//input[@id='male' and @type='radio']"));
		maleradiobtn.click();
		Thread.sleep(2000);
		// click on male radio button
		WebElement femaleradiobtn = driver.findElement(By.xpath("//input[@id='female' and @type='radio']"));
		femaleradiobtn.click();
		Thread.sleep(2000);
		driver.quit();
	}
}
