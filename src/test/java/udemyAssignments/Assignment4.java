package udemyAssignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it= windows.iterator();
		String parentID= it.next();
		String childID= it.next();
		
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());

		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
	}
	
	

}
