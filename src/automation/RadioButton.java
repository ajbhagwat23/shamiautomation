package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[]args) throws Exception {
		//setting property of chrome driver and passing chrome driver path
		System.setProperty("webdriver.chrome.driver","D:\\\\Softwares\\\\chromedriver_win32 (2)\\\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@rel='async']")).click();
		Thread.sleep(3000);
		
		//1st way -it is not a good way to handle with multiple webelements
		driver.findElement(By.cssSelector("input[value='1']")).click();//Male Radio button 
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[value='2']")).click();//Female Radio button
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[value='-1']")).click();//Custom Radio Button
		
		//2nd way- By creating list of all radio button
		
		 List<WebElement> radios= driver.findElements(By.xpath("//input[@type='radio']"));
		 System.out.println("Total Radion Buttons="+radios.size());
		 
		 System.out.println(radios.get(1).isEnabled());//Male radio button isEnambled or not
		 System.out.println(radios.get(0).isDisplayed());//Female button is displayed or not
		 System.out.println(radios.get(2).isSelected());//Custom button is selected or not
		 Thread.sleep(3000);
		 
		 radios.get(0).click();
		 System.out.println( radios.get(1).isSelected());
		 Thread.sleep(2000);
	
		
		 //3rd way- correct way
		 List<WebElement> radios1=driver.findElements(By.className("_58mt"));
		 String ExpectedResult="Female";
		 
		 for(int i=0;i<radios1.size();i++)
		 {
			 if(radios1.get(i).getText().equalsIgnoreCase(ExpectedResult))
			 {
				 radios1.get(i).click();
				 System.out.println(ExpectedResult+ "Clicked");
			 }
			 
		 }
		 Thread.sleep(2000);
		 driver.close();
		
		
	}
}
