package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascript {
	public static void main(String[]args) throws InterruptedException{
		
		//setting the property of chrome browser and path
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\sw2\\chromedriver_win32 (2)//chromedriver.exe");
		WebDriver driver=new ChromeDriver();//calling chrome driver instance
		driver.manage().window().maximize();//maximizing the window
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//using implicit wait for 
		driver.manage().deleteAllCookies();//Delete all cookies
		driver.get("https://www.facebook.com/");//hitting facebook url
		
		//introducing the javascriptexecutor interface and cast the interface
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		//Locate webelement by using javascript
		jse.executeScript("document.getElementById('email').value='abcd@gmail.com'");
		jse.executeScript("document.getElementById('pass').value='1234'");
		
		//Scrole down using javascript
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0, 400");
		
		//Scrole up using javascript
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-400");
		
		
		
		}

}
