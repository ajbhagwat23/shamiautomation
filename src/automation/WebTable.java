package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static void main(String[]args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers");
		
		//Create List of All companys
		List<WebElement> allcompanys=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		System.out.println(allcompanys.size());
		
		//Create List of all current price
		List<WebElement> currentprice=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println(currentprice.size());
				
		String expected="Scan Steels";
		for(int i=0;i<allcompanys.size();i++)
		{
			if(allcompanys.get(i).getText().equalsIgnoreCase(expected))
			{
				
				System.out.println(allcompanys.get(i).getText() + "==" + currentprice.get(i).getText());
				allcompanys.get(i).click();
				break;
			}
		}
	
				
		
		
	}

}
