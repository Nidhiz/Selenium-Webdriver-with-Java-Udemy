package udemyAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		//System.out.println(driver.findElement(By.tagName("frame")).getSize());
		
		driver.switchTo().frame("frame-top");
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
		
	}

}
