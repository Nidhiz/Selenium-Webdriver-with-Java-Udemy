package udemypractices;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DropdownHandle {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		/*driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		WebElement ele = driver.findElement(By.id("divpaxinfo"));
		driver.findElement(By.id("divpaxinfo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		System.out.println("initially: "+ele.getText());
		WebElement element=driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		
		Select select= new Select(element);
		select.selectByValue("5");
		System.out.println(select.getFirstSelectedOption().getText());
		
		System.out.println("After: "+ele.getText());*/
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		WebElement ele= driver.findElement(By.id("checkBoxOption1"));
		//to check checkbox
		ele.click();
		Assert.assertTrue(ele.isSelected());
		Thread.sleep(1000);
		//to uncheck checkbox
		ele.click();
		Assert.assertFalse(ele.isSelected());
		
		List<WebElement> countCheckbox= driver.findElements(By.cssSelector("label input[type='checkbox']"));
		System.out.println("Checkbox count = "+countCheckbox.size());
		
		
		
		
	}

}
