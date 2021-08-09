/*
1. Select any checkbox
2. Grab the label of selected checkbox.
3. Select option in dropdown. Option to be selected should come from step 2.
4. Enter grabbed label from step 2 into text box and click on Alert.
5. Verify if text grabbed in step 2 is present in alert pop up message or not.
Do not hardcode label part.
*/

package udemyAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");

		driver.findElement(By.id("checkBoxOption2")).click();

		String label = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		// System.out.println(label);
		WebElement ele = driver.findElement(By.id("dropdown-class-example"));
		ele.click();
		Select opt = new Select(ele);
		opt.selectByVisibleText(label);
		// System.out.println(opt.getFirstSelectedOption().getText());

		driver.findElement(By.cssSelector("#name")).sendKeys(label);
		driver.findElement(By.cssSelector("#alertbtn")).click();

		// System.out.println(driver.switchTo().alert().getText());
		String text = driver.switchTo().alert().getText();

		Assert.assertTrue(text.contains(label));

		driver.switchTo().alert().accept();
	}

}
