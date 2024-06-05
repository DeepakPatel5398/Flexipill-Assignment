package flexipill_assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://flexipill-ui-new-staging.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter your number']")).sendKeys("1111111111");
		driver.findElement(By.xpath("//p[text()='Continue']")).click();
		
		
		Thread.sleep(3000);
		driver.findElement(By.id(":r4:")).sendKeys("1");
		Thread.sleep(3000);

		driver.findElement(By.id(":r5:")).sendKeys("1");
		Thread.sleep(3000);

		driver.findElement(By.id(":r6:")).sendKeys("1");
		Thread.sleep(3000);

		driver.findElement(By.id(":r7:")).sendKeys("1");
		Thread.sleep(3000);
		
        JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement digestive = driver.findElement(By.xpath("//img[@alt='category-Digestive Care']"));

		jse.executeScript("arguments[0].scrollIntoView();", digestive);
		Thread.sleep(4000);
		digestive.click();
	
		driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]")).click();
		
		Thread.sleep(7000);


		WebElement frame1 = driver.findElement(By.className("Header_searchbarContainer__nbACG"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//button[@class='Header_cartButton__Giyrb']")).click();

		//  (//div[@class='AddToCartDropdown_arrow__pFEjt open-dropdown'])[1]
		driver.findElement(By.xpath("(//div[@class='AddToCartDropdown_arrow__pFEjt open-dropdown'])[1]")).click();
	    driver.findElement(By.xpath("//div[text()='2']")).click();
	    driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
	    driver.findElement(By.xpath("(//button[text()='Place Order'])[1]")).click();
	}

}
