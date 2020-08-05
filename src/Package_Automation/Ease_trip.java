package Package_Automation;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ease_trip {

	static WebDriver driver;

	@Test(priority = 1)
	public static void setup() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonika.chaudhary\\Desktop\\shar\\chromedriver.exe");		
     	driver = new ChromeDriver();
//		driver = new ChromeDriver(options);
		driver.get("https://www.easemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("User has landed on the homepage");
	}

	@Test(priority = 2)
	public void verify_homepage() {
		boolean logo = driver.findElement(By.className("newHeaderLogo")).isDisplayed();
		if (logo = true) {
			System.out.println(logo +"The logo is displayed");
		} else
			System.out.println("The logo is not displayed");
		// Verifying the title of the page
		String actual_title = driver.getTitle();
		String exp_title = "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com";
		if (actual_title.equals(exp_title)) {
			System.out.println("The correct webpage is opened");
		} else
			System.out.println("Incorrect webpage");
	}

	@Test(priority = 3)
	public void Flights() {

		driver.findElement(By.xpath("//a[contains(@href,'flights.html')and (text()='Flights')]")).click();
		boolean logo = driver.findElements(By.xpath("//a[(text()='Flights') and contains(@class,'active')]"))
				.size() > 0;
		if (logo == true) {
			System.out.println("Clicked on Flight");
		} else
			System.err.println("Error Clicking on Flight");

	}

	@Test(priority = 4)
	public void details() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean popup = driver.findElements(By.id("NC_CLOSE_ICON")).size() > 0;
		if (popup == true) {
			driver.findElement(By.id("NC_CLOSE_ICON")).click();
		}

		driver.findElement(By.xpath("//input[@id='ddate']")).click();
		driver.findElement(By.xpath("//*[@class='box1']//div[@class='days']//li[text()='1']")).click();
		System.out.println("Departure date selected");
		// driver.findElement(By.xpath("//*[@id='rdate']")).click();
		// driver.findElement(By.xpath("//*[@class='box1']//div[@class='days']//li[text()='1']")).click();
		driver.findElement(By.xpath("//a[@onclick='myFunction4()']/span[text()='1 Traveller(s)']")).click();
		driver.findElement(By.xpath("//*[@id='myDropdown_n']//*[@value='+' and @class='plus_box1']")).click();
		driver.findElement(By.xpath("//*[@id='myDropdown_n']//label[contains(text(),'Business')]")).click();
		driver.findElement(By.linkText("Done")).click();
		System.out.println("Travellers and class selected");
		driver.findElement(By.xpath("//div[@id='search']//child::input")).click();
		System.out.println("The list is displayed");
	}

	@Test(priority = 5)
	public void filters() {
		// non-stop
		WebElement departure = driver.findElement(By.xpath("//*[@id='slider-range3']/span[1]"));
//	    int iaxis = departure.getSize().getWidth();
//	    System.out.println(iaxis);
	   
		Actions act = new Actions(driver);
		
		
	act.clickAndHold(departure).moveByOffset(49,0).release().perform();
		
	
	
		WebElement arrival = driver.findElement(By.xpath("//*[@id='slider-range31']/span[2]"));

//		int yaxis = arrival.getSize().getWidth();
//		System.out.println(yaxis);

		Actions act1 = new Actions(driver);
	

		act1.clickAndHold(arrival).moveByOffset(-135, 0).release().perform();
		
     
		
		
		
		WebElement price = driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));  
				
		
//	    int bothaxis = price.getSize().getWidth();
//	    System.out.println(bothaxis);
	   
		Actions act12 = new Actions(driver);
		
		
		act12.clickAndHold(price).moveByOffset(10,0).release().perform();

		
WebElement price2 = driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));  
	    //int bothaxis1 = price2.getSize().getWidth();
	    //System.out.println(bothaxis1);
		Actions act123 = new Actions(driver);
		act123.clickAndHold(price2).moveByOffset(-110,0).release().perform();
		
	}
	@Test(priority = 6)
	public void get_list() {
		List<WebElement> flights = driver.findElements(
				By.xpath("//*[@id='ResultDiv']//div[contains(@class,'fltResult') and contains(@class,'AC')]"));
		System.out.println(flights.size() +"  Results found");
		for (int i = 1; i <= flights.size(); i++) {
			String flt_no = driver.findElement(
					By.xpath("//*[@id='ResultDiv']//div[contains(@class,'fltResult') and contains(@class,'AC')][" + i
							+ "]//span[@class='txt-r5']"))
					.getText();
			System.out.println(flt_no);
		}

	}

	@Test(priority = 7)
	public void tear_down() {
		driver.quit();
	}
}


