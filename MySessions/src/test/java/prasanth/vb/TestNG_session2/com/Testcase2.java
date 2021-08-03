package prasanth.vb.TestNG_session2.com;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Testcase2 extends BaseTest{

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

	WebElement item = driver.findElement(By.xpath("(//a[@class='product_img_link'])[1]"));
	if (item.isDisplayed() == true) {
		Actions act = new Actions(driver);
		act.moveToElement(item).perform();
		System.out.println("Site search Verified, Hence search functionality is tested successfully");
	} else {
		System.out.println("Search Failed");
	}
}

@Test(dependsOnMethods = "Test2")
public void Test3() {
	driver.findElement(By.xpath("//a[contains(text(),'Printed Chiffon Dress')]/parent::h5/following-sibling::div[@class='button-container']//a[1]")).click();
	WebElement addcart = driver.findElement(By.xpath("//h2[text()[normalize-space()='Product successfully added to your shopping cart']]"));
	assertTrue(addcart.isDisplayed()== true, null);
			
}
}
