package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class methods {
	
	public static void main(String[]args) throws Exception {
		//setting property for chrome driver
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		
		//lounching browser instance
		WebDriver driver=new ChromeDriver();
		
		//maximize windo
		driver.manage().window().maximize();
		
		//open application using get url
		driver.get("http://www.facebook.com");
		Thread.sleep(3000);
		driver.navigate().to("http://www.google.com");
		
		//Refresh the browser page
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		//Navigate back
		Thread.sleep(3000);
		driver.navigate().back();
		
		//Navigate forward
		Thread.sleep(3000);
		driver.navigate().forward();
		
		//Navigate wepage back
		Thread.sleep(3000);
		driver.navigate().back();
		
		//Featch URL priont catogory
		Thread.sleep(3000);
		String CurrenUrl=driver.getCurrentUrl();
		System.out.println(CurrenUrl);
		//System.out.println(driver.getCurrentUrl());
		
		//Get title of the web page
		Thread.sleep(2000);
		String GetTitle=driver.getTitle();
		System.out.println(GetTitle);
		
		//Close the curret browser instance
		Thread.sleep(3000);
		driver.close();
		
		//close all browser instances
		Thread.sleep(3000);
		driver.quit();

}
}
