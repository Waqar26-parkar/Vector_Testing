////package newweb;
////
////import java.io.IOException;
////import java.net.HttpURLConnection;
////import java.net.MalformedURLException;
////import java.net.ProtocolException;
////import java.net.URL;
////import java.util.List;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.firefox.FirefoxDriver;
////import org.openqa.selenium.support.ui.Select;
////
////
////
////public class Launchbrow {
////	
////	
////	
////	public static String browser = "Firefox";
////	
////	public static void main(String[] args) throws IOException {
////		// TODO Auto-generated method stub
////		
//////		if(browser.equals("Firefox"))
//////		{
//////			WebDriver driver;
//////			driver= new FirefoxDriver();
//////			//driver.get("https://waqa26r.blogspot.com/");
//////			//driver.navigate().to("https://javatpoint.com/selenium-tutorial");
//////			driver.get("https://www.saucedemo.com/v1/");
//////		}
//////	
////		
////		
////		WebDriver driver;
////		driver= new ChromeDriver();
////		//driver.get("https://waqa26r.blogspot.com/");
////		//driver.navigate().to("https://javatpoint.com/selenium-tutorial");
////		/*driver.get("https://www.saucedemo.com/v1/");
////		driver.findElement(By.id("user-name")).sendKeys("standard_user");
////		driver.findElement(By.id("password")).sendKeys("secret_sauce");
////		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
////		
////	*/
//////		driver.close();
////		
////		//System.out.print(driver.getTitle());
////
////		//opening the main page of the website 
////		
////		String currentwindowhandle = driver.getWindowHandle();
////		driver.switchTo().window(currentwindowhandle);
////		
////		
//////		driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
////		
////		//driver.findElement(By.partialLinkText("Sauce")).click();
////		
//////		List <WebElement> elementlist = driver.findElements(By.partialLinkText("Sauce"));
////		
//////		System.out.print("Element size" + elementlist.size());
////		
////		
////		//Using the selector by CSS
////		
//////		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
//////		
//////		
//////		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("secret_sauce");
//////		
//////		driver.findElement(By.cssSelector("input.submit-button")).click();
//////		
//////		
////	
////		
////		// ADD TO CART THE PRODUCT
////		
////		
//////		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
//////		
//////		driver.findElement(By.cssSelector("button.btn[name=add-to-cart-sauce-labs-backpack]")).click();
//////		
////		
////		
////		
////		
////	//  COUNT OF LIST OF ALL HYPERLINK ELEMENTS
////		/*
////		
////		driver.get("https://www.calculator.net/");
////		
////		List <WebElement> linkelements = driver.findElements(By.tagName("a"));
////		System.out.print("Total links on webpage: "+ linkelements.size());
////		
////		*/
////		
////		// It Prints the total links which is present on webpage
////	/*	
////		for(WebElement ele:linkelements)
////		{
////			System.out.println(ele.getText());
////		}
////		
////		*/
//////		driver.close();
////		
////		
////		
////		//  Practice for DropDown
////		
////	
////		
////		/*
////		 
////		driver.get("https://www.opencart.com/index.php?route=account/register");
////		WebElement element = driver.findElement(By.id("input-country"));
////		
////		Select dropdown = new Select(element);
////		
////		//dropdown.selectByVisibleText("Iceland");
////		
////		
////		if(dropdown.isMultiple())
////		{
////			System.out.print("Dropdown is Multiple");
////			
////		}
////		
////		else
////		{
////			System.out.println("It's not multiple");
////		}
////		
////		List <WebElement> alldropdownoptions = dropdown.getOptions();
////		
////		for(WebElement el: alldropdownoptions)
////		{
////			System.out.println(el.getText());
////		}
////		
////		
////		*/
////		
////		
////		
////		// Identify the broken Link and  Valid Link
////		
////		
////
////	
////		
////		/*
////		
////		
////		driver.get("http://www.deadlinkcity.com/");
////		
////		
////		List <WebElement>   linklist = driver.findElements(By.tagName("a"));
////		
////		
////		int rescode=200;
////		int linkcnt=0;
////		
////		for(WebElement element:linklist)
////		{
////			String url = element.getAttribute("href");
////			
////			try
////			{
////				
////				URL urlLink = new URL(url);
////				
////				HttpURLConnection huc= (HttpURLConnection)urlLink.openConnection();
////				huc.setRequestMethod("HEAD");
////				huc.connect();
////				
////				rescode=huc.getResponseCode();
////				
////				if(rescode>=200)
////				{
////					System.out.println(url+"broken link");
////					linkcnt++;
////					
////				}
////				
////			}
////			
////			
////			catch(MalformedURLException e)
////			{
////				
////			}
////			
////			catch(Exception e)
////			{
////				
////			}
////			
////			
////			
////		}
////		
////		System.out.println("Total Broken link "+ linkcnt);
////		
////		
////		
////		*/
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////	
////}
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.JavascriptExecutor;
//
//public class Launchbrow {
//    private WebDriver driver;
//
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1296,  696));
//    }
//
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public void testOk() {
//        // Your test steps here, similar 
//        // For example:
//    	
//        driver.get("https://automationexercise.com/");
//        driver.findElement(By.linkText("Signup / Login")).click();
//        WebElement element = driver.findElement(By.linkText("Video Tutorials"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).perform();
//        element = driver.findElement(By.cssSelector("body"));
//        actions.moveToElement(element,  0,  0).perform();
//        driver.findElement(By.cssSelector(".signup-form input:nth-child(3)")).sendKeys("rej12@gmail.com");
//        driver.findElement(By.name("email")).sendKeys("rej12@gmail.com");
//        driver.findElement(By.name("password")).sendKeys("12345678");
//        driver.findElement(By.name("name")).click();
//        driver.findElement(By.name("name")).sendKeys("tejas");
//        driver.findElement(By.cssSelector(".signup-form input:nth-child(3)")).click();
//        driver.findElement(By.cssSelector(".signup-form input:nth-child(3)")).sendKeys("tejtambvekar07@gmail.com");
//        driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
//        driver.findElement(By.name("email")).sendKeys("rej12@gmail.com");
//        driver.findElement(By.name("password")).sendKeys("12345678");
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).sendKeys("tejtambvekar07@gmail.com");
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
//        driver.findElement(By.cssSelector(".signup-form input:nth-child(3)")).sendKeys("rej12@gmail.com");
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("name")).click();
//        driver.findElement(By.name("name")).sendKeys("tejas");
//        driver.findElement(By.cssSelector(".signup-form input:nth-child(3)")).click();
//        driver.findElement(By.cssSelector(".signup-form input:nth-child(3)")).sendKeys("tejtambvekar07@gmail.com");
//        driver.findElement(By.cssSelector(".signup-form .btn")).click();
//        driver.findElement(By.name("email")).sendKeys("rej12@gmail.com");
//        driver.findElement(By.name("password")).sendKeys("12345678");
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).sendKeys("12345677");
//        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
//        driver.findElement(By.linkText(" Products")).click();
//        driver.findElement(By.cssSelector(".col-sm-4:nth-child(4) .product-overlay .btn")).click();
//        driver.findElement(By.cssSelector(".btn-success")).click();
//        driver.findElement(By.linkText("Cart")).click();
//        driver.findElement(By.linkText("Proceed To Checkout")).click();
//        driver.findElement(By.linkText("Place Order")).click();
//        driver.findElement(By.name("name_on_card")).click();
//        driver.findElement(By.name("name_on_card")).sendKeys("fedygfdey");
//        driver.findElement(By.name("card_number")).click();
//        driver.findElement(By.name("card_number")).sendKeys("121212121");
//        driver.findElement(By.name("cvc")).click();
//        driver.findElement(By.name("cvc")).sendKeys("123");
//        driver.findElement(By.name("expiry_month")).click();
//        driver.findElement(By.name("expiry_month")).sendKeys("12");
//        driver.findElement(By.name("expiry_year")).click();
//        driver.findElement(By.name("expiry_year")).sendKeys("1211");
//        driver.findElement(By.id("submit")).click();
//        driver.findElement(By.linkText("Download Invoice")).click();
//        driver.findElement(By.linkText("Continue")).click();
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,112)");
//        driver.findElement(By.linkText("API Testing")).click();
//        driver.findElement(By.linkText("Test Cases")).click();
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,302)");
//        driver.findElement(By.linkText("Delete Account")).click();
//        element = driver.findElement(By.linkText("Contact us"));
//        actions.moveToElement(element).perform();
//        driver.findElement(By.linkText("Continue")).click();
//        driver.findElement(By.cssSelector(".col-sm-4:nth-child(4) .product-overlay .btn")).click();
//        driver.findElement(By.cssSelector(".btn-success")).click();
//    }
//
//    
//
//    public static void main(String[] args) {
//        Launchbrow launchbrow = new Launchbrow();
//        launchbrow.setup();
//        launchbrow.testOk();
//        launchbrow.teardown();
//    }
//    
//    
//}
//
