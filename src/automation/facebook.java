package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebook {
	public static void main(String[]args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com/");
	
	Thread.sleep(3000);
	
	WebElement userid= driver.findElement(By.xpath("//input[@id='email']"));
	userid.sendKeys("9881138851");
	
	WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
	
	password.sendKeys("Akshay@12");
	
	
	driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
	
	//WebElement pr=driver.findElement(By.xpath("//div[@class='_9ay7']"));
	//System.out.println(pr);
	
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Akshay@123");
	
	
	driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
	Thread.sleep(5000);
	driver.switchTo().alert().dismiss();
	
	driver.findElement(By.xpath("//*[name()='g' and contains(@mask,'url(#:R3ab')]//*[name()='image' and contains(@x,'0')]")).click();
	
	Thread.sleep(3000);
	
	//driver.close();

}
}
