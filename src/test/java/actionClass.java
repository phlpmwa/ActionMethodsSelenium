import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClass {

	public static WebDriver driver;
	public static String baseUrl = "https://www.guru99.com/";
	public static Actions act;

	@BeforeMethod
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
		act = new Actions(driver);
	}

	@Test@Ignore
	public void mouseHover(){
		
		 		act.moveToElement(driver.findElement(By.xpath("//span[@class='g-separator g-menu-item-content']"
				+ "//span[@class='g-menu-item-title'][contains(text(),'SAP')]"))).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'HANA')]")).click();
	}
	
	@Test@Ignore
	public void rightClickAction()
	{
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Home')]"))).build().perform();
		act.contextClick(driver.findElement(By.xpath("//span[contains(text(),'Home')]")))
		.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	@Test
	public void switchTab()
	{
		
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
