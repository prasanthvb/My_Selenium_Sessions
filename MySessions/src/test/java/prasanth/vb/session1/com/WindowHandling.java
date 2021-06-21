package prasanth.vb.session1.com;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Prasanth V B\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String mainwin = driver.getWindowHandle();
		//switch to frame to click on the button
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it = allwin.iterator();

		while (it.hasNext()) {
			String childwin = it.next();
			if (!mainwin.equalsIgnoreCase(childwin)) {
				driver.switchTo().window(childwin);
				System.out.println("Switched to child Window");
				driver.close();
				System.out.println("Closed child Window");
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(mainwin);
		System.out.println("Returned to Main Window");
		driver.close();
	}
}
