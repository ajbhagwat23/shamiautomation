package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[]args) throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//First way- not recommended but industry mostly used 
		Thread.sleep(2000);
		List<WebElement> birthmonth= driver.findElements(By.xpath("//select[@id='month']/option"));
		System.out.println("Total drop down values=" +birthmonth.size());
		System.out.println(birthmonth.get(8).isEnabled());//September 
		Thread.sleep(3000);
		birthmonth.get(7).click();//August
		System.out.println(birthmonth.get(8).isSelected());//September 
		Thread.sleep(3000);
		
		//Second way- Recommended
		WebElement bm= driver.findElement(By.xpath("//select[@id='month']"));
		Select month=new Select(bm);//Select class parameterized constructor
		month.selectByVisibleText("Apr");//Select by visible text Apr
		month.selectByValue("12");//select by value dec
		month.selectByIndex(10);//select by index nov
		System.out.println(month.getFirstSelectedOption().getText());//get current selected value Nov
		
		//3rd way- will store all dropdown values in list
		List<WebElement> dropdown=month.getOptions();
		System.out.println("Total dropdown values=" +dropdown.size());
		for(int i=1;i < dropdown.size();i++) {
			String dropdownvalues=dropdown.get(i).getText();
			
			if(dropdownvalues.equalsIgnoreCase("Aug")) {
				dropdown.get(i).click();
			}	
		}
		
		//4th way- check if the dropdown supports multi selection
		System.out.println(month.isMultiple());//false
		month.selectByVisibleText("Dec");//select by visible text desc
		month.selectByValue("10");//select by value oct
		month.selectByIndex(10);//select by index nov
		
		//Deselect the selected drop down value
		/*Thread.sleep(2000);
		month.deselectByVisibleText("Dec");//select by visible text dec
		month.deselectByValue("10");//select by value oct
		month.deselectByIndex(10);//select by index nov
		month.deselectAll();*/
		//that dropdown doesn't allow deselect option 
	
		//5th wam
		bm.sendKeys("Feb");
		
		//6th way
		Thread.sleep(4000);
		driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Mar");
		
			
	}	

}
