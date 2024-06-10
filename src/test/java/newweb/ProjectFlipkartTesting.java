package newweb;

import static org.testng.Assert.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ProjectFlipkartTesting {

    public ChromeDriver driver;
    
    @Test
    
    void ClicktoSearch()
    {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        search.sendKeys("Shirts");
        
        Actions click = new Actions(driver);
        click.sendKeys(search, Keys.ENTER).perform();
   

    }
    
    
    @Test
    
    void DropdownSearch()
    {
    	driver = new ChromeDriver();
    	driver.get("https://www.flipkart.com/");
    	WebElement drop = driver.findElement(By.xpath("//div[@aria-label='Fashion']//div//span[@class='_27h2j1']"));
    	Actions actions = new Actions(driver);

         // Perform the hover action on the dropdown
         actions.moveToElement(drop).perform();
         driver.findElement(By.linkText("Men's Casual Shirts")).click();
         
        // driver.findElement(By.linkText("Men's Top Wear")).click();        
       // Close the browser
         driver.quit();
    	
    	
    	
    }

    
    @Test
    void changebackgroundimage()
    {
    	driver = new ChromeDriver();
//    	driver.get("https://www.flipkart.com/search?q=scratch+remover&sid=1mt%2Cs84&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_9_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_9_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=scratch+remover%7CVehicle+Cleaners&requestId=77bb8983-021f-4927-94cd-df49b98f940e");
//    	driver.findElement(By.xpath("//img[@alt='Wavex Scratch Remover Wax']")).click();
        //driver.findElement(By.linkText("realme Buds T300 with 12.4mm Driver, 30dB ANC, 360 Spatial Audio and 40 hours Playback Bluetooth Headset  (Stylish Black, True Wireless)")).click();
    	
    	
    	driver.get("https://www.flipkart.com/");
    	driver.findElement(By.xpath("(//img[@alt='Image'])[22]")).click();
    	
    }
    
    


	
    

}
