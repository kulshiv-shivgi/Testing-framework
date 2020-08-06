package Package_Automation;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Amazon_sort {
	static WebDriver driver;

	
	@Test(priority=1)
	public static void Login() {
		
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonika.chaudhary\\Desktop\\shar\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();
			System.out.println("User has landed on the homepage");
		System.out.println("User has landed on the homepage");
			driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
			}

	
	
	@Test(priority=2)
	public void Today_deal()  {
		// Click on Today's deal present at the top of the page

		driver.findElement(By.linkText("Today's Deals")).click();
		
	

				String deals = driver.findElement(By.xpath("//*[@id='fst-hybrid-dynamic-h1']//h1")).getText();
				if (deals.equals("Deals and Promotions")) {
					System.out.println("User landed on Deals section");
				} else
					System.err.println("Error landing");
	}
	    @Test(priority=3)
	public void Filter() {
		// Apply filter on books
				WebElement Book_Filter = driver
						.findElement(By.xpath("//span[ @class = 'a-label a-checkbox-label' and  contains(text(), 'Books')]//preceding::input[@type='checkbox'][1]"));
				Book_Filter.click();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement Book_Filter1 = driver
						.findElement(By.xpath("//span[ @class = 'a-label a-checkbox-label' and  contains(text(), 'Books')]//preceding::input[@type='checkbox'][1]"));

				boolean Book_Filter_Applied = Book_Filter1.isSelected();
				if (Book_Filter_Applied == true) {
					System.out.println("The filter is applied");
				} else
					System.err.println("Error in applying filter");
	}
	    @Test(priority=4)
	public void sort_option() {
		// Select Price low to high from the "Sort By" drop down
		Select sort = new Select(driver.findElement(By.name("sortOptions")));
		sort.selectByValue("BY_PRICE_ASCENDING");

		System.out.println("------------");
		boolean sort_option = driver
				.findElement(By.xpath("//select[@name='sortOptions']/option[@value='BY_PRICE_ASCENDING']"))
				.isSelected();
//		String sort_option = option.getText().trim();
//		System.out.println(sort_option);
		if (sort_option == true) {
			System.out.println("Sorting option selected");
		} else
			System.err.println("Error in applying sort");
	}
	    @Test(priority=5)
	public void verify_sort() {
		// Verify that the items displayed are sorted
				List<WebElement> list_of_price = driver.findElements(By.xpath("//*[contains(@class,'dealPriceText')]"));
				// System.out.println(list_of_price);
				String[] StrArray = new String[list_of_price.size()];
				Double[] Doublearray = new Double[list_of_price.size()];

				for (int i = 0; i < list_of_price.size(); i++) {

					StrArray[i] = list_of_price.get(i).getText().substring(0, 5).trim().replace("$", "");

					// System.out.println("The " + (i + 1) + "th item in the list is"
					// + list_of_price.get(i).getText().substring(0, 5).trim());

					Doublearray[i] = Double.parseDouble(StrArray[i]);

					System.out.println(Doublearray[i]);

				}
				for (int j = 0; j < list_of_price.size(); j++) {
					try{
					if (Doublearray[j] <= Doublearray[j + 1]) {
						System.out.println();
					} else
						System.err.println("The list is not sorted");

				}
				catch(IndexOutOfBoundsException e) {
					e.getMessage();
				}
				}
				
				
				System.out.println("The list is sorted");
	}
	
	 @Test(priority=6)
		public void tear_down() {
			driver.quit();
		}
	
	

}
