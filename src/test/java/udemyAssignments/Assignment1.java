/*
Questions for this assignment 1
1. Check the first checkbox and verify if it is successfully checked and uncheck it again to verify if it is successfully unchecked.
2. How to get the Count of number of check boxes present in the page.
*/

package udemyAssignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		WebElement ele = driver.findElement(By.id("checkBoxOption1"));
		
		// to check checkbox
		ele.click();
		Assert.assertTrue(ele.isSelected());
		Thread.sleep(1000);
		
		// to uncheck checkbox
		ele.click();
		Assert.assertFalse(ele.isSelected());

		List<WebElement> countCheckbox = driver.findElements(By.cssSelector("label input[type='checkbox']"));
		System.out.println("Checkbox count = " + countCheckbox.size());
	}

}
