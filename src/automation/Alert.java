package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alert {
	public static void main(String[]args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/alerts");
		
		Thread.sleep(2000);
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		
		//Verify Alert Text
		System.out.println(driver.switchTo().alert().getText());
		String expectedresult="Do you confirm action?";
		Assert.assertEquals(driver.switchTo().alert().getText(), expectedresult);
		System.out.println("Alert text verified");
		
		//Accept the alert
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Accept Worked");
		
		//Dismiss the alert
		Thread.sleep(2000);
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		System.out.println("Dismiss worked");
		
		
	
	}

}
