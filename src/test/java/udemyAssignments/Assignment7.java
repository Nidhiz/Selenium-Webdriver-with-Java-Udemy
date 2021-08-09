/*
1. Display number of rows and columns from Web Table Example only.
2. Display 2nd record from that table only.
It should not display from any other table.
*/

package udemyAssignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");

		WebElement ele = driver.findElement(By.cssSelector("table#product"));

		List<WebElement> rows = ele.findElements(By.tagName("tr"));
		System.out.println("Number of rows: " + rows.size());

		int cols = rows.get(0).findElements(By.tagName("th")).size();
		System.out.println("Number of Columns: " + cols);

		List<WebElement> secondRows = rows.get(2).findElements(By.tagName("td"));
		for (int i = 0; i < secondRows.size(); i++)
		{
			System.out.println(secondRows.get(i).getText());
		}
	}

}
