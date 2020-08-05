package Package_Automation;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon_mail {
static WebDriver driver;

	
	@Test(priority = 1)
	public static void Login1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonika.chaudhary\\Desktop\\shar\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println("User has landed on the homepage");
		driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.partialLinkText("Account"));
		actions.moveToElement(target).perform();
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("email")).sendKeys("9540612775");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("kscc8791");
		driver.findElement(By.id("signInSubmit")).click();
		
		}
	@Test(priority = 2)
	public void Your_listicon() {
		// Click on Accounts and Lists
		
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.partialLinkText("Account"));
		actions.moveToElement(target).perform();
		
		System.out.println("Clicked on Accounts and Lists");

		// Click on "Your Wish List"
		driver.findElement(By.xpath("//*[@class=\"nav-text\" and contains(text(),'Create a List')]")).click();
	}
	@Test(priority=3)
	public void create_listbutton() {
		// Click on "Create a List" button
				driver.findElement(By.xpath("//*[@id='list-name']")).clear();
				driver.findElement(By.xpath("//*[@id='list-name']")).click();
				driver.findElement(By.xpath("//*[@id='list-name']")).sendKeys("item");
				driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id='wl-redesigned-create-list']/span/span/input")).click();

	
	}
	@Test(priority=4)
	public void send_list() {
		// Click to "Send list to others" icon
		driver.navigate().refresh();
				driver.findElement(By.xpath("//div[@id='shareWidgetContainer']//a")).click();
				
				// Click on Invite someone to - "VIEW ONLY" button -> Copy Link
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//				Actions actions = new Actions(driver);
//				WebElement access = driver.findElement(By.xpath("*//input[@name='invite-view-only-button']"));
//				actions.moveToElement(access).click(access).perform();
//				access.sendKeys(Keys.ENTER);
//				System.out.println("Clicked view only");
//				
//				
//				WebDriverWait wait = new WebDriverWait(driver,10);
//			    WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='invite-view-only-button']")));
//			    passwordElement.click();
//			
//driver.findElement(By.xpath("//*[@id='invite-view-only-copy']/li/span/a")).click();
//				System.out.println("Copied link");
	}
	@Test(priority=5)
	public void gmail()  {
		// Login to gmail and send the to Copied link from Step 9 to other user
		driver.get("https://accounts.google.com/");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sonika.chaudhary@magicfinserv.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement passwordElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		passwordElement.click();
		passwordElement.clear();
		passwordElement.sendKeys("Shivansh@789");

		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
@Test(priority=6)
public void send() throws InterruptedException {
		Actions actions = new Actions( driver);
        //Retrieve WebElement 'Music' to perform mouse hover 
     WebElement menuOption =  driver.findElement(By.xpath("//*[@id='gbwa']/div/a"));
     //Mouse hover menuOption 'Music'
     actions.moveToElement(menuOption).click().build().perform();
		Thread.sleep(4000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div[2]/iframe")));

		driver.findElement(By.xpath("//a[contains(@href,'https://mail.google.com/mail/?tab')]")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=':iw']/div/div")).click();
		driver.findElement(By.xpath("//form[@enctype='multipart/form-data']//textarea")).sendKeys("sonikach.91@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("List name");
		driver.findElement(By.xpath("//div[contains(@class,'editable')]")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		driver.findElement(By.xpath("//div[text()='Send' and (@role='button')]")).click();
		System.out.println("Mail sent");
		
	}
		
	} 
	



