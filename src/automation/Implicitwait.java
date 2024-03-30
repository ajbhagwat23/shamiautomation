package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicitwait {
	public static void main(String[]args) {
		//setting property of chrome browser and passing path of chromedriver
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();//Launching browser instance
		driver.manage().window().maximize();//maximize the windo 
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");//open url for google
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("How Stuff Works");
		
		//handling auto suggestions
		List<WebElement> Allsuggestions=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println("Total Auto Suggestion=" +Allsuggestions.size());
		
		for(int i=0;i < Allsuggestions.size();i++)
		{
			String Expectedresult="how stuff works videos";
			
			if(Allsuggestions.get(i).getText().equalsIgnoreCase(Expectedresult)) 
			{
				Allsuggestions.get(i).click();
				System.out.println(Expectedresult+"clicked");
				break;
			}
		}
		driver.quit();
	}

}


