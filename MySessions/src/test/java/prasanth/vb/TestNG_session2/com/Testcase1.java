package prasanth.vb.TestNG_session2.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Testcase1 extends BaseTest{

	@Test
public void Test1() {
		WebElement logo = driver.findElement(By.cssSelector("img.logo.img-responsive"));
		boolean value = logo.isDisplayed();
		if(value==true) {
		System.out.println("Site Logo Verified, Hence site launched successfully");
		}
}
	
@Test(dependsOnMethods = "Test1")
public void Test2() {
	WebElement searchbox = driver.findElement(By.cssSelector("input#search_query_top"));
	searchbox.sendKeys("Printed Chiffon Dress");
	driver.findElement(By.xpath("//button[@name='submit_search']")).click();

	boolean displayed = driver.findElement(By.xpath("(//a[@class='product_img_link'])[1]")).isDisplayed();
	if (displayed == true) {
		System.out.println("Site search Verified, Hence search functionality is tested successfully");
	} else {
		System.out.println("Search Failed");
	}
}

}
