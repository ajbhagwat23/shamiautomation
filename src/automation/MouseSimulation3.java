package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimulation3 {
	public static void main(String[]args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");//open url
		
		//Switching fames
		List<WebElement> allFrames=driver.findElements(By.tagName("iframe"));
		System.out.println("Total Frames="+allFrames.size());
		driver.switchTo().frame(0);
		
		//Will find draggable Web Element
		WebElement draggableElement= driver.findElement(By.id("draggable"));
		
		//Using Action class,drag the webelement
		Thread.sleep(2000);
		Actions Act=new Actions(driver);
		Act.dragAndDropBy(draggableElement,30,20).build().perform();
		
		//drag the Web Element and click hold using cordinates
		Thread.sleep(3000);
		Act.clickAndHold(draggableElement).dragAndDropBy(draggableElement,30,30).build().perform();
		
		
		
	}

}
