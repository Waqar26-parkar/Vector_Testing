package newweb;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newdemofile {


public static void main(String[] args) throws InterruptedException




{
	
//WebDriver driver;
	
	
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\waqar.farooqui\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
   /*
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
  
// 		driver= new ChromeDriver();
		driver.get("https://waqa26r.blogspot.com/");
		
        // Navigate to the specified URL
        driver.get("http://www.ebay.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Perform actions on the webpage
        // Example: Search for "mobile" on eBay
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobile");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();

        // Close the browser
        driver.close();
        */
        
        
        // Locators
	
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
	  
	  //driver.get("https://www.saucedemo.com/");
//	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
//	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
//	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  
        
    
	  //Using Xpath
/*
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	
*/
	  
	  /*
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  
	  String currentUrl = driver.getCurrentUrl();
	  System.out.println(currentUrl);
	  
	  String title = driver.getTitle();
	  System.out.println(title);
	  
	  
	  String pagesource = driver.getPageSource();
	  System.out.println(pagesource);
	  
	  driver.navigate().to("https://www.waqa26r.blogspot.com");
	  
	  
	  driver.close();
	  
	  */
	  
	  
	  /*
	  driver.get("https://www.sugarcrm.com/au/request-demo/");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("firstname")).sendKeys("Testing");
	  driver.findElement(By.name("firstname")).clear();
	  System.out.println(driver.findElement(By.name("firstname")).getAttribute("class"));
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getCssValue("text-transform");
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getSize();
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getLocation();
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).getText();
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).isEnabled();
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).isDisplayed();
	  driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).isSelected();
	  
	  */
	
	
	  
	  
	  
	  // Select the dropdown window 
	  
	  /*
	  
	  driver.get("https://www.sugarcrm.com/au/request-demo");
	  driver.manage().window().maximize();
	  WebElement ddown = driver.findElement(By.name("employees_c"));
	  Select select = new Select(ddown);
	  select.selectByValue("level1");
	  
	  Thread.sleep(2000);
	  
	  select.selectByVisibleText("51 - 100 employees");
	  Thread.sleep(2000);
	  
	  select.selectByIndex(5);
	  
	  
	  */
	  
	  
	  
	  
	  
	  
	  //Multi Select Dropdown
	  
	  
	  
	  /*
	  driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

	  driver.manage().window().maximize();
	  
	  WebElement ddown = driver.findElement(By.id("multi-select"));
	  Select select = new Select(ddown);
	  select.selectByValue("California");
	  select.selectByIndex(5);
	  List<WebElement> allItems = (List<WebElement>) select.getAllSelectedOptions();
	  System.out.println(allItems.size());
	  select.deselectAll();
	  select.selectByValue("California");
	  select.selectByIndex(5);
	  
	  select.deselectByIndex(5);
	  List<WebElement> allItems1 = (List<WebElement>) select.getAllSelectedOptions();
	  System.out.println(allItems1.size());
	  */
	  
	  
	  
	  
	  
	  /*
	  
	  driver.get("https://saucedemo.com/");
	  
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();	  
	  
	  List<WebElement> alltags = findElement(By.tagName("a"));
	  
	  System.out.println("Total tags are:"+ alltags.size());
	  
	  
//	  List<WebElement> allTags = driver.findElements(By.tagName("a"));
//
//      // Iterate over the list and print the text of each element
//      for (WebElement element : allTags) {
//          System.out.println(element.getText());
//      }
	  
	  
	  for(int i=0; i<alltags.size(); i++)
	  {
		  System.out.println("Links on page are:"+alltags.get(i).getAttribute("href"));
		  System.out.println("Links on page are:"+alltags.get(i).getText());
	  }
	  
	  */
	  
	  
	  
	  
	  // Click the button inside the button
/*	  
	  driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt"); // Open the specified webpage
	  driver.manage().window().maximize(); // Maximize the browser window

	  // Find and switch to the iframe with id "iframeResult"
	  WebElement frame1 = driver.findElement(By.id("iframeResult"));
	  driver.switchTo().frame(frame1);
	  

	  // Find and click the button inside the iframe
	  driver.findElement(By.xpath("/html/body/button")).click();
	  Thread.sleep(2000);
	  // Switch back to the parent frame
	 
	  String alertText = driver.switchTo().alert().getText();
	  System.out.println(alertText);
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  
	  

	  driver.switchTo().parentFrame();
	  System.out.println(driver.getTitle());
	  
*/

	  
	  
	  
	  //Accept the alert box of javascript 
	  
	  /*
	  
	  driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert"); // Open the specified webpage
	  driver.manage().window().maximize(); // Maximize the browser window

	  // Find and switch to the iframe with id "iframeResult"
	  WebElement frame1 = driver.findElement(By.id("iframeResult"));
	  driver.switchTo().frame(frame1);
	  

	  // Find and click the button inside the iframe
	  driver.findElement(By.xpath("/html/body/button")).click();
	  Thread.sleep(2000);
	  // Switch back to the parent frame
	 
	  String alertText = driver.switchTo().alert().getText();
	  System.out.println(alertText);
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  
	  

	  driver.switchTo().parentFrame();
	  System.out.println(driver.getTitle());
	  
*/
	  
	  
	  // Handle multiple windows
	  
	  /*
	  driver.get("https://www.salesforce.com/au/");
	  driver.findElement(By.xpath("//*[@id=\\\"main\\\"]/div[4]/div/div[6]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/a")).click();
	  Thread.sleep(4000);
	  Set<String> windowHandles = driver.getWindowHandles();
	  System.out.println(windowHandles);
	  
	  
	  Iterator<String> iterator =windowHandles.iterator();
	  String parentwindow = iterator.next();
	  System.out.println(parentwindow);
	  
	  String childwindow = iterator.next();
	  System.out.println(childwindow);
	  
	  driver.switchTo().window(childwindow);
	  driver.findElement(By.name("UserFirstName")).sendKeys("RVC");
	  driver.findElement(By.name("UserLastName")).sendKeys("Academy");
	  */
	  
	  
	 
	  
	  /*
	  // copy and paste 
	  
	  driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
  
	 // WebDriverWait wait = new WebDriverWait(driver, 15);

	  WebElement e = driver.findElement(By.xpath("//*[@id='name']"));

	  e.sendKeys("Selenium");
	  
	  // Identify the second input box with xpath locator
      WebElement s = driver.findElement(By.xpath("//*[@id='email']"));
    //  e.sendKeys(Keys.COMMAND, "a");
      e.sendKeys(Keys.COMMAND, "c");

      // paste to second input box
      s.sendKeys(Keys.COMMAND, "v");

      // Getting text in the second input box
      String text = s.getAttribute("value");
      System.out.println("Value copied and pasted: " + text);
	
      
      
      //---- This part is changing the window Tab-------
      
   // Initiate the Webdriver
      WebDriver newDriver1 =driver.switchTo().newWindow(WindowType.TAB);

      // Opening the webpage in new tab
      driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");

      */
	  
	  
	  
	  
	/*  
	  // -----------Radio Button-----------
	  
	  
      // Navigate to the page
      driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

      // Find the radio button by its value attribute
      WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"gender\"]"));

      // Click the radio button
      radioButton.click();

      // Check if the radio button is selected
      boolean result = radioButton.isSelected();

      // Print the result
      System.out.println("Checking the radio button is: " + result);

      // Close the browser
      driver.quit();
	  

      */
	  
	  
	  
	  
	  
      
      
      
}

private static List<WebElement> findElement(By tagName) {
	// TODO Auto-generated method stub
	return null;
}
}