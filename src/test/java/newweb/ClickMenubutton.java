
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
 

public class ClickMenubutton {

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
		
		
	}
		
	@Test
	public void ClickMenuItems() throws InterruptedException
	{
        //driver.get("http://yourwebsite.com");

        // Wait for the page to load
        Thread.sleep(2000);

        // Find the hamburger menu button and click it
        WebElement hamburgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerMenuButton.click();

        // Wait for the menu to open
        Thread.sleep(2000);

        // Find the "About" link and click it
        WebElement aboutLink = driver.findElement(By.id("about_sidebar_link"));
        aboutLink.click();

        // Wait for the new page to load
        Thread.sleep(2000);

        // Verify that the new page has loaded
        System.out.println("Current URL: " + driver.getCurrentUrl());

	}
	
}
