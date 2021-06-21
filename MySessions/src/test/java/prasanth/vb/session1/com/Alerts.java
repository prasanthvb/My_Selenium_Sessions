package prasanth.vb.session1.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Double click to get the Alert using Action Class

		Actions act = new Actions(driver);
		WebElement generator = driver.findElement(By.xpath("//button[text()='Double-click to generate alert box']"));
		act.doubleClick(generator).perform();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		// Click on confirm alert box and verify

		WebElement genAlert = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));

		genAlert.click();
		//accept
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());

		genAlert.click();
		//dismiss
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());

		driver.quit();
		
		
		/*
		 * Notes:
		 * 1) void dismiss()  To click on the 'Cancel' button of the alert.
		 * 2) void accept() // To click on the 'OK' button of the alert.
		 * 3) String getText() // To capture the alert message.
		 * 4) void sendKeys(String stringToSend) // To send some data to alert box.
		 */
	}
}
