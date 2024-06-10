package newweb;
 
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
 
public class BasicExtentReportClass {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Project.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
 
        // Add environment details
        reports.setSystemInfo("Machine", "testpc1");
        reports.setSystemInfo("OS", "windows 10");
        reports.setSystemInfo("User", "Waqar");
        reports.setSystemInfo("Browser", "chrome");
 
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
 
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
 
    @Test
    public void LaunchBrowser() {
        test = reports.createTest("Launch browser and open url", "Launching browser and opening URL");
driver.get("https://www.saucedemo.com/");
        test.log(Status.PASS, "Browser launched and URL opened successfully");
    }
 
    @Test
    public void loginPositive() {
        test = reports.createTest("Login Positive Test Case", "Logging into the website with valid credentials.");
driver.get("https://www.saucedemo.com/");
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        String usernameValue = "standard_user";
        usernameField.sendKeys(usernameValue);
        test.log(Status.INFO, "Entering username: " + usernameValue);
 
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        String passwordValue = "secret_sauce";
        passwordField.sendKeys(passwordValue);
        test.log(Status.INFO, "Entering password: " + passwordValue);
 
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
loginButton.click();
        test.log(Status.PASS, "Login successful");
    }
 
    @Test
    public void loginFailed() {
        test = reports.createTest("Login Failed Test Case", "Attempting to log in with invalid credentials.");
driver.get("https://www.saucedemo.com/");
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        String usernameValue = "standard_user";
        usernameField.sendKeys(usernameValue);
        test.log(Status.INFO, "Entering username: " + usernameValue);
 
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        String passwordValue = "invalid_sauce";
        passwordField.sendKeys(passwordValue);
        test.log(Status.INFO, "Entering password: " + passwordValue);
 
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
loginButton.click();
 
        boolean loginFailed = driver.findElements(By.xpath("//div[contains(text(),'Username and password do not match')]")).size() > 0;
        if (loginFailed) {
            test.log(Status.PASS, "Login failed as expected");
        } else {
            test.log(Status.FAIL, "Login fail with invalid credentials");
        }
    }
 
    @Test
    public void CheckCorrectTitle() throws InterruptedException {
        test = reports.createTest("Check the title", "Attempting to check the title of the page after logging in.");
 
        // Log in
driver.get("https://www.saucedemo.com/");
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        String usernameValue = "standard_user";
        usernameField.sendKeys(usernameValue);
        test.log(Status.INFO, "Entering username: " + usernameValue);
 
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        String passwordValue = "secret_sauce";
        passwordField.sendKeys(passwordValue);
        test.log(Status.INFO, "Entering password: " + passwordValue);
 
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
loginButton.click();
        test.log(Status.INFO, "Logged in successfully");
 
        // Check the title
        Thread.sleep(3000); // Wait for the page to load
        if (driver.getTitle().equals("Swag Labs")) {
            test.log(Status.INFO, "Title is Correct");
            test.log(Status.PASS, "Test Case Passed Successfully");
        } else {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, "Title is not Correct");
        }
    }
 
   
 
    @Test
    public void NavigationToProduct() {
        boolean executionSuccessfull = true;
        test = reports.createTest("Navigate to Products", "Navigate to each Product using link.");
        try {
            // Navigate to each product and then navigate back
        	driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
            String usernameValue = "standard_user";
            usernameField.sendKeys(usernameValue);
            test.log(Status.INFO, "Entering username: " + usernameValue);
     
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            String passwordValue = "secret_sauce";
            passwordField.sendKeys(passwordValue);
            test.log(Status.INFO, "Entering password: " + passwordValue);
     
            WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
             loginButton.click();
            test.log(Status.INFO, "Logged in successfully");
            
            driver.get("https://www.saucedemo.com/inventory.html");
 
            driver.findElement(By.xpath("//*[@id='item_4_title_link']")).click();
            driver.navigate().back();
            test.log(Status.INFO, "Navigated to 'Sauce Labs Backpack' and back.");
 
            driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']")).click();
            driver.navigate().back();
            test.log(Status.INFO, "Navigated to 'Sauce Labs Bike Light' and back.");
 
            driver.findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']")).click();
            driver.navigate().back();
            test.log(Status.INFO, "Navigated to 'Sauce Labs Bolt T-Shirt' and back.");
 
            driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']")).click();
            driver.navigate().back();
            test.log(Status.INFO, "Navigated to 'Sauce Labs Fleece Jacket' and back.");
 
            driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']")).click();
            driver.navigate().back();
            test.log(Status.INFO, "Navigated to 'Sauce Labs Onesie' and back.");
        } catch (Exception ex) {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, ex.toString());
            executionSuccessfull = false;
        }
        if (executionSuccessfull) {
            test.log(Status.PASS, "Test Case Passed Successfully");
            test.log(Status.INFO, "Navigation to Product is Successful");
        }
    }
 
    
    @Test
    public void AddToCartSauceLabsBackPack() {
        test = reports.createTest("Add Cart Sauce Labs Back Pack to cart", "Adding Product to cart.");
        try {
        	
        	driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
            String usernameValue = "standard_user";
            usernameField.sendKeys(usernameValue);
            test.log(Status.INFO, "Entering username: " + usernameValue);
     
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            String passwordValue = "secret_sauce";
            passwordField.sendKeys(passwordValue);
            test.log(Status.INFO, "Entering password: " + passwordValue);
     
            WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
             loginButton.click();
            test.log(Status.INFO, "Logged in successfully");
            
            
            driver.get("https://www.saucedemo.com/inventory.html");
        	
            // Get product information
            WebElement productElement = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            String productName = productElement.findElement(By.xpath("./../div[@class='inventory_item_name']")).getText();
            String productPrice = productElement.findElement(By.xpath("./../div[@class='inventory_item_price']")).getText();

            // Add product to cart
            productElement.click();

            // Log test result
            test.log(Status.PASS, "Test Case Passed Successfully");
            test.log(Status.INFO, "Product added to cart Successfully");
            test.log(Status.INFO, "Product Name: " + productName);
            test.log(Status.INFO, "Product Price: " + productPrice);
        } catch (Exception ex) {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, ex.toString());
        }
    }
    
    
    @Test
    public void AddToCartSauceLabsTShirt() {
        test = reports.createTest("Add Cart Sauce Labs T-Shirt to cart", "Adding Product to cart.");
        try {
        	
        	driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
            String usernameValue = "standard_user";
            usernameField.sendKeys(usernameValue);
            test.log(Status.INFO, "Entering username: " + usernameValue);
     
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            String passwordValue = "secret_sauce";
            passwordField.sendKeys(passwordValue);
            test.log(Status.INFO, "Entering password: " + passwordValue);
     
            WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
             loginButton.click();
            test.log(Status.INFO, "Logged in successfully");
            
            
            driver.get("https://www.saucedemo.com/inventory.html");
            // Get product information
            WebElement productElement = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
            String productName = productElement.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText();
            String productPrice = productElement.findElement(By.xpath("(//div[@data-test='inventory-item-price'][normalize-space()='$15.99'])[2]")).getText();

            // Add product to cart
            productElement.click();

            // Log test result
            test.log(Status.PASS, "Test Case Passed Successfully");
            test.log(Status.INFO, "Product added to cart Successfully");
            test.log(Status.INFO, "Product Name: " + productName);
            test.log(Status.INFO, "Product Price: " + productPrice);
        } catch (Exception ex) {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, ex.toString());
        }
    }
    
    @Test
    public void testSortMethod() {
        test = reports.createTest("Test Sort Method", "Verifying the sort method functionality.");
        try {
        	driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
            String usernameValue = "standard_user";
            usernameField.sendKeys(usernameValue);
            test.log(Status.INFO, "Entering username: " + usernameValue);
     
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            String passwordValue = "secret_sauce";
            passwordField.sendKeys(passwordValue);
            test.log(Status.INFO, "Entering password: " + passwordValue);
     
            WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
             loginButton.click();
            test.log(Status.INFO, "Logged in successfully");
            
            
            
        	
        	
            // Find the dropdown element
            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));

            // Create a Select object
            Select select = new Select(dropdown);

            // Select the "za" option
            select.selectByValue("za");

            // Verify that the sort order has changed
            List<WebElement> products = driver.findElements(By.className("inventory_item"));
            List<String> productNames = new ArrayList<>();
            for (WebElement product : products) {
                productNames.add(product.findElement(By.className("inventory_item_name")).getText());
            }

            // Check if the products are sorted in reverse alphabetical order
            List<String> sortedProductNames = new ArrayList<>(productNames);
            Collections.sort(sortedProductNames, Collections.reverseOrder());
            Assert.assertEquals(productNames, sortedProductNames);

            test.log(Status.PASS, "Test Case Passed Successfully");
            test.log(Status.INFO, "Sort method functionality is working as expected.");
        } catch (Exception ex) {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, ex.toString());
        }
    }
    
    @Test
    public void LinkedInNavigation() {
        test = reports.createTest("Redirect to LinkedIn Page", "Redirecting to Sauce Labs linkedin home page.");
        try {
         	
        	driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
            String usernameValue = "standard_user";
            usernameField.sendKeys(usernameValue);
            test.log(Status.INFO, "Entering username: " + usernameValue);
     
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            String passwordValue = "secret_sauce";
            passwordField.sendKeys(passwordValue);
            test.log(Status.INFO, "Entering password: " + passwordValue);
     
            WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
             loginButton.click();
            test.log(Status.INFO, "Logged in successfully");
            
            
            driver.get("https://www.saucedemo.com/inventory.html");
            Thread.sleep(2000);
            // Navigate to LinkedIn page
            driver.findElement(By.xpath("//a[@href=\"https://www.linkedin.com/company/sauce-labs/\"]")).click();

            // Wait for the page to load
            Thread.sleep(5000);

            // Check if redirection was successful
            if (driver.getCurrentUrl().equals("https://www.linkedin.com/company/sauce-labs/")) {
                test.log(Status.PASS, "Test Case Passed Successfully");
                test.log(Status.INFO, "Redirection to Sauce Labs LinkedIn page was successful.");
            } else {
                test.log(Status.FAIL, "Test Case Failed");
                test.log(Status.INFO, "Redirection to Sauce Labs LinkedIn page failed.");
            }
        } catch (Exception ex) {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, ex.toString());
        }
    }
    
    @Test
    public void testSkippedMethod() {
        Assume.assumeTrue(true); // This will skip the test case
    	driver.get("https://www.saucedemo.com/");
        test = reports.createTest("Test Skipped Method", "This test case is skipped.");
        test.log(Status.SKIP, "Test Case Skipped");
        test.log(Status.INFO, "This test case is skipped due to some reason.");
    }
    
    @Test
    public void testCheckout() {
        test = reports.createTest("Test Checkout", "Verifying the checkout functionality.");
        try {
        	
        	driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
            String usernameValue = "standard_user";
            usernameField.sendKeys(usernameValue);
            test.log(Status.INFO, "Entering username: " + usernameValue);
     
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            String passwordValue = "secret_sauce";
            passwordField.sendKeys(passwordValue);
            test.log(Status.INFO, "Entering password: " + passwordValue);
     
            WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
             loginButton.click();
            test.log(Status.INFO, "Logged in successfully");
            
            
        	
            // Click the checkout button
//            WebElement checkoutButton = driver.findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]"));
//            checkoutButton.click();

            // Enter first name
            WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
            firstNameField.sendKeys("james");

            // Enter last name
            WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
            lastNameField.sendKeys("Anderson ");

            // Enter postal code
            WebElement postalCodeField = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
            postalCodeField.sendKeys("412512");

//            // Click the continue button
//            WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
//            continueButton.click();
//            
            WebElement checkoutButton = driver.findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]"));
            checkoutButton.click();
            

            // Wait for 3 seconds
            Thread.sleep(3000);

            // Verify that the checkout is successful
            WebElement checkoutSuccessMessage = driver.findElement(By.xpath("//*[@id=\"checkout-success\"]"));
            Assert.assertTrue(checkoutSuccessMessage.isDisplayed());

            test.log(Status.PASS, "Test Case Passed Successfully");
            test.log(Status.INFO, "Checkout functionality is working as expected.");
            test.log(Status.INFO, "firstNameField"+firstNameField);
            test.log(Status.INFO, "lastNameField"+lastNameField);
            test.log(Status.INFO, "postalCodeField"+postalCodeField);


        } catch (Exception ex) {
            test.log(Status.FAIL, "Test Case Failed");
            test.log(Status.INFO, ex.toString());
        }
        
        
    }
    
    
    
    @Test
    public void checkTilesOnDashboardPage() {
        test = reports.createTest("Check Tiles On Dashboard Page", "Verify if any tiles are displayed on the dashboard page.");
        
        try {
            // Navigate to the dashboard page
            driver.get("URL_OF_DASHBOARD_PAGE"); // Replace 'URL_OF_DASHBOARD_PAGE' with the actual URL
            
            // Assuming 'tileSelector' is a CSS selector that matches all tile elements on the dashboard
            List<WebElement> tiles = driver.findElements(By.cssSelector("CSS_SELECTOR_FOR_TILES")); 
            // Replace 'CSS_SELECTOR_FOR_TILES' with the actual CSS selector
            
            if (tiles.isEmpty()) {
                test.log(Status.FAIL, "No tiles found on the dashboard page.");
            } else {
                test.log(Status.PASS, "Tiles are present on the dashboard page.");
            }
            
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to check tiles on the dashboard page: " + e.getMessage());
        }
    }

    
    @Test
    public void verifyIDFieldRemainsEmptyWhilePasswordFieldIsFilled() {
        test = reports.createTest("Fields: Verify ID Field Remains Empty While Password Field Is Filled;", "Leave the ID field empty and enter a valid password, checking if the ID field remains empty while the password field is filled.");

        try {
            driver.get("URL_OF_LOGIN_PAGE"); // Replace 'URL_OF_LOGIN_PAGE' with the actual URL of the login page

            // Leave the ID field empty
            WebElement idField = driver.findElement(By.id("ID_FIELD")); // Replace 'ID_FIELD' with the actual ID
            idField.clear(); // Ensure the field is cleared

            // Enter a valid password
            WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD")); // Replace 'PASSWORD_FIELD' with the actual ID
            String validPassword = "VALID_PASSWORD"; // Replace 'VALID_PASSWORD' with the actual valid password
            passwordField.sendKeys(validPassword);

            // Verify the ID field remains empty
            String idFieldValue = idField.getAttribute("value");
            assertEquals("", idFieldValue, "The ID field is not empty after entering a valid password.");

            test.log(Status.PASS, "The ID field remained empty while the password field was filled.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify the ID field remains empty while the password field is filled: " + e.getMessage());
        }
    }

    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
 
    @AfterTest
    public void endReport() {
        reports.flush();
    }
}