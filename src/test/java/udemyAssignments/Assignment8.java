package udemyAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://qaclickacademy.com/practice.php");

		driver.findElement(By.id("autocomplete")).sendKeys("in");

		Thread.sleep(2000);
		List<WebElement> option = driver.findElements(By.cssSelector("li.ui-menu-item"));

		int count = option.size();

		for (int i = 0; i < count; i++) {

			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			String options = option.get(i).getText();

			if (options.equalsIgnoreCase("INDIA")) {
				
				System.out.println(option.get(i).getText());
				option.get(i).click();
				break;

			}
	
		}

	}

}
