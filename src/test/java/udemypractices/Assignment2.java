/*1. Select todays date
2. click on Adults dropdown and select any number.
3. click on children  drop down and select any number
4. click on "More options: Class of travel, Airline preference" link
5. Enter "indigo" in the Preffered Airline textbox.
6. click on Search flights button.
7. grab the error message and print in output.*/

package udemypractices;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 1.
		WebElement ele = driver.findElement(By.cssSelector("div.flex.flex-middle.p-relative.homeCalender button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div[aria-selected='true']")).click();

		// 2
		List<WebElement> listOfSelect = driver.findElements(By.cssSelector(
				"#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div:nth-child(6) > div > div > select"));
		WebElement adult = listOfSelect.get(0);
		// System.out.println(opt1.getText());
		// opt1.click();
		Select select = new Select(adult);
		select.selectByValue("5");
		// System.out.println(select.getFirstSelectedOption().getText());

		// 3.
		WebElement child = listOfSelect.get(1);
		// System.out.println(opt1.getText());
		Select select2 = new Select(child);
		select2.selectByValue("3");
		// System.out.println(select.getFirstSelectedOption().getText());

		// 4.
		driver.findElement(By.cssSelector("#root  div.container.w-100p.flex-1 div.col-13.homeba div:nth-child(7) a"))
				.click();
		driver.findElement(By.cssSelector("div.row.p-relative.px-4.mb-4 div:nth-child(3) input")).sendKeys("indigo");

		// 5
		driver.findElement(By.cssSelector(" div.col.flex.flex-middle > button")).click();
		String text = driver
				.findElement(By.cssSelector(
						"div.container.w-100p.flex-1 > div.container.p-fixed.z-20.w-100p.b-0.mb-2 > div span"))
				.getText();
		System.out.println(text);
		Assert.assertEquals(text, "Select Departure and Arrival airports/cities.");
	}

}