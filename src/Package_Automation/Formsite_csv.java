package Package_Automation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class Formsite_csv {
	static WebDriver driver;

	@Test(priority = 1)
	public static void setup() 

	{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonika.chaudhary\\Desktop\\shar\\chromedriver.exe");	

			driver = new ChromeDriver();

			driver.get("https://www.formsite.com");
			driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test(priority = 2)	

	public void signup() throws FileNotFoundException {
		driver.findElement(By.xpath("//span[contains(text(),'Sign up free')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			CSVReader reader = new CSVReader(
					new FileReader("C:\\Users\\sonika.chaudhary\\eclipse-workspace\\code\\Testng framework\\src\\Package_Automation\\Detail.csv"));

			String[] cell;

			try {
				while ((cell = reader.readNext()) != null) {

					for (int i = 0; i < 1; i++) {

						String username = cell[i];
						String password = cell[i + 1];
						String email = cell[i + 2];

						driver.findElement(By.id("UserId")).click();

						driver.findElement(By.id("UserId")).sendKeys(username);
						driver.findElement(By.id("Password1")).click();

						driver.findElement(By.id("Password1")).sendKeys(password);

						driver.findElement(By.id("UserEmail")).click();

						driver.findElement(By.id("UserEmail")).sendKeys(email);

						driver.findElement(By.className("auth-form__submit")).click();
						
					}}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	@Test(priority = 4)		
			public static void Title_verify() 	{
				
				
					String actualTitle = driver.getTitle();

					String expectedTitle = "Formsite - Logging in...";
					if (actualTitle.equalsIgnoreCase(expectedTitle)) {
						System.out.println("user landed into correct homepage");
					} else
						System.out.println("homepage didn't match");
				}

	@Test(priority = 5)
public static void Billing_selection() 	{
	
				driver.findElement(By.id("menu-user-trigger")).click();

				driver.findElement(By.xpath("//*[@id=\"menu-user\"]/li[1]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"menu-left\"]/li[2]/a")).click();
               
               
}
	@Test(priority = 6) 
				public static void Get_list() 	{ 
					
					List<WebElement> rows1 = driver.findElements(By.xpath("//table[@class = 'table-services']/tbody/tr"));
				for(int i=3;i<=rows1.size();i++) {
//					boolean text_pro1 = driver.findElement(By.xpath("//*[@id='wrapper-right']//tr["+i+"]/td[contains(@class,'pro1')]")).getText()!=null;
//					boolean text_ent= driver.findElement(By.xpath("//*[@id='wrapper-right']//tr["+i+"]/td[contains(@class,'level-enterprise')]")).getText()!=null;
//					if(text_pro1==false && text_ent==true ) {
//						String component= driver.findElement(By.xpath("//*[@id='wrapper-right']//tr["+i+"]/th")).getText();
//						System.out.println("The component is "+component);
//					}
					boolean tick_pro1= driver.findElements(By.xpath("//*[@id='wrapper-right']//tr["+i+"]/td[contains(@class,'pro1')]/img")).size()>0;
					boolean tick_ent= driver.findElements(By.xpath("//*[@id='wrapper-right']//tr["+i+"]/td[contains(@class,'enterprise ')]/img")).size()>0;
					if(tick_pro1==false && tick_ent==true ) {
						String component= driver.findElement(By.xpath("//*[@id='wrapper-right']//tr["+i+"]/th")).getText();
						System.out.println("The component is "+component);
					}
					
					
				} 
				
				driver.quit();	
				}
}

		
		
	

	


