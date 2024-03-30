package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimulation {
	public static void main(String[]args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(2000);
		//create webelement reference 
		driver.findElement(By.cssSelector("._2KpZ6l._2doB4z")).click();
		
		WebElement Electronics= driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		//mouse simulation using action class
		Actions act=new Actions(driver);
		
		//Mouse hover electronics Web Elements
		Thread.sleep(2000);
		act.moveToElement(Electronics).build().perform();
		
		//Right click on webelement
		Thread.sleep(2000);
		act.contextClick(Electronics).build().perform();
		
		//Release controll from WebElement
		Thread.sleep(2000);
		act.release(Electronics).build().perform();
		
		//Perform key event
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		
		//Press Enter key to home webelement
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		WebElement home=driver.findElement(By.xpath("//*[text()='Home & Kitchen']"));
		Thread.sleep(2000);
		act.sendKeys(home,Keys.ENTER).build().perform();
		System.out.println("Home & Kitchen cicked");
		Thread.sleep(2000);
		//driver.close();
		
		//rigth click on webpage
		Thread.sleep(3000);
		act.contextClick().perform();
		
		
		
		
		
	}

}
