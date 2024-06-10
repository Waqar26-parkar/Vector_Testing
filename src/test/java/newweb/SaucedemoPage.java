package newweb;
 
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class SaucedemoPage {
	public ChromeDriver driver;
	@BeforeTest
	public void LoginInApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
 
		WebElement Username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		Username.sendKeys("standard_user");
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		Password.sendKeys("secret_sauce");
		WebElement Login = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
		Login.click();
		System.out.println("Login Successful");
		
		
		
//------LogOut  Functionalities
        
        /*
	       WebElement l = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
			l.click();
			
			// identify all elements under tagname ul
			WebElement elements = driver.findElement(By.className("bm-item-list"));
			
			// identify first li element under ul then click
			WebElement element = elements.findElement(By.id("logout_sidebar_link"));
			element.click();
			
			*/
		
	}
	
	
	
	@Test
	public void TitleCheck() throws InterruptedException {
		String Expected = "Swag Labs";
		String Actual = driver.getTitle();
		SoftAssert SoftA = new SoftAssert();
		SoftA.assertEquals(Actual, Expected);
		Thread.sleep(3000);
	}
	
	
	@Test
	public void sortmethod()
	{
		WebElement ddown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		Select select = new Select(ddown);
		select.selectByValue("za");
	}
	
	@Test
	public void AddtoCart() throws InterruptedException {
		WebElement AddtoCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		AddtoCart.click();
		System.out.println("Product Added to Cart");
		Thread.sleep(3000);
	}
	@Test
	public void CheckCartItems() throws InterruptedException {
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]"));
		cart.click();
		Thread.sleep(3000);
	}
	@Test
	public void Checkout() throws InterruptedException {
		WebElement CheckoutButton = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		CheckoutButton.click();
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("james");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Anderson ");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("412512");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		Thread.sleep(3000);
	}
	@Test
	public void Finish() throws InterruptedException {
		WebElement FinishButton = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
		FinishButton.click();
	}
	

	@Test
	public void RemoveFromCart() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		WebElement AddtoCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		AddtoCart.click();
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]"));
		cart.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
	}
	
	

	
	
	@Test
	public void printLinks() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/inventory.html");

        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Print each link
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }
    }
	
	
	@Test
	
	public void CheckAbout()
	{
		// Assuming the ID "react-burger-menu-btn" is unique to the hamburger menu button
		WebElement menuButton = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
		menuButton.click();


		// Assuming the class "bm-item-list" is unique to the list container
		WebElement menuItems = driver.findElement(By.cssSelector(".bm-item-list"));

		// Assuming the structure allows for a more straightforward CSS selector for the first li element
		// This is a bit tricky without seeing the full HTML structure, but assuming the first li is the first child of the ul
		WebElement firstMenuItem = menuItems.findElement(By.cssSelector(".bm-item-list a:nth-child(2)"));
		firstMenuItem.click();

		
	}
	
	
	
	@Test
	public void Logout()
	{
		WebElement l = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
		l.click();
		
		// identify all elements under tagname ul
		WebElement elements = driver.findElement(By.className("bm-item-list"));
		
		// identify first li element under ul then click
		WebElement element = elements.findElement(By.id("logout_sidebar_link"));
		element.click();
	}
	
	
	
	
}