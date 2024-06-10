package newweb;




import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import javax.print.attribute.standard.Sides;

import org.apache.hc.core5.http.Message;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
 
public class vectorfile5 {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Testcase7.html");
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
        test = reports.createTest("OpenBrowser:Launch browser and open url", "Launching browser and opening URL");
driver.get("https://www.saucedemo.com/");
        test.log(Status.PASS, "Browser launched and URL opened successfully");
    }
 


    @Test
    public void selectPaymentMethod() {
        test = reports.createTest("Payment:Select Payment Method",
                                  "Select a payment method (e.g., credit card, PayPal).");
    
        try {
            // Navigate to checkout page (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Select payment method (assertions or validations here)
            // Example:
            WebElement creditCardOption = driver.findElement(By.id("CREDIT_CARD_OPTION")); // Replace with actual ID
            creditCardOption.click();
    
            // Check if selected payment method is highlighted or marked as selected (assuming validation)
            assertTrue(creditCardOption.isSelected(), "Credit card payment method not selected.");
    
            test.log(Status.PASS, "Selected payment method successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to select payment method: " + e.getMessage());
        }
    }

    

    @Test
    public void enterPaymentDetails() {
        test = reports.createTest("Details:Enter Payment Details",
                                  "Proceed with the payment process by entering the required payment details.");
    
        try {
            // Navigate to checkout page (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Enter payment details (assertions or validations here)
            // Example:
            WebElement cardNumberField = driver.findElement(By.id("CARD_NUMBER_FIELD")); // Replace with actual ID
            cardNumberField.sendKeys("1234567890123456");
    
            WebElement expiryDateField = driver.findElement(By.id("EXPIRY_DATE_FIELD")); // Replace with actual ID
            expiryDateField.sendKeys("12/24");
    
            WebElement cvvField = driver.findElement(By.id("CVV_FIELD")); // Replace with actual ID
            cvvField.sendKeys("123");
    
            // Verify if payment details are accepted (assuming validation)
            WebElement confirmPaymentButton = driver.findElement(By.id("CONFIRM_PAYMENT_BUTTON")); // Replace with actual ID
            confirmPaymentButton.click();
    
            // Example validation: check if next step is available or if there are error messages
            assertFalse(driver.getPageSource().contains("ERROR_MESSAGE"), "Payment details not accepted.");
    
            test.log(Status.PASS, "Entered payment details successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to enter payment details: " + e.getMessage());
        }
    }
    



    @Test
    public void completePurchase() {
        test = reports.createTest("Purchase:Complete Purchase",
                                  "Complete the purchase by confirming the payment.");
    
        try {
            // Navigate to checkout page (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Perform actions to confirm payment and complete purchase (assertions or validations here)
            // Example:
            WebElement confirmPaymentButton = driver.findElement(By.id("CONFIRM_PAYMENT_BUTTON")); // Replace with actual ID
            confirmPaymentButton.click();
    
            // Verify if order confirmation page is reached (assuming redirection or verification)
            WebElement confirmationPageHeader = driver.findElement(By.id("CONFIRMATION_PAGE_HEADER")); // Replace with actual ID
            assertTrue(confirmationPageHeader.isDisplayed(), "Order confirmation page not displayed after payment.");
    
            test.log(Status.PASS, "Completed purchase and reached order confirmation page.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to complete purchase: " + e.getMessage());
        }
    }
    


    @Test
    public void navigateToCheckoutPageForShipping() {
        test = reports.createTest("Shipping:Select Shipping Method and View Estimated Delivery Date",
                                  "Navigate to the checkout page after adding items to the shopping cart.");
    
        try {
            // Navigate to product page and add product(s) to shopping cart (if not already added)
            driver.get("URL_OF_PRODUCT_PAGE"); // Replace 'URL_OF_PRODUCT_PAGE' with actual URL
    
            // Add product(s) to cart (assertions or validations here)
            // Example:
            WebElement addToCartButton = driver.findElement(By.id("ADD_TO_CART_BUTTON")); // Replace with actual ID
            addToCartButton.click();
    
            // Proceed to checkout (assertions or validations here)
            // Example:
            WebElement checkoutButton = driver.findElement(By.id("CHECKOUT_BUTTON")); // Replace with actual ID
            checkoutButton.click();
    
            // Verify if checkout page is displayed with shipping options (assuming validation)
            WebElement shippingOptionsSection = driver.findElement(By.id("SHIPPING_OPTIONS_SECTION")); // Replace with actual ID
            assertTrue(shippingOptionsSection.isDisplayed(), "Shipping options not displayed on checkout page.");
    
            test.log(Status.PASS, "Successfully navigated to checkout page with shipping options.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to checkout page for shipping: " + e.getMessage());
        }
    }
    
    @Test
    public void locateShippingMethodSection() {
        test = reports.createTest("Shipping Method:Locate Shipping Method Section",
                                  "Locate the shipping method section on the checkout page.");
    
        try {
            // Navigate to checkout page (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Locate shipping method section (assertions or validations here)
            // Example:
            WebElement shippingMethodSection = driver.findElement(By.id("SHIPPING_METHOD_SECTION")); // Replace with actual ID
            assertTrue(shippingMethodSection.isDisplayed(), "Shipping method section not visible on checkout page.");
    
            test.log(Status.PASS, "Located shipping method section on the checkout page.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to locate shipping method section: " + e.getMessage());
        }
    }

    
    @Test
    public void selectShippingMethod() {
        test = reports.createTest("Shipping:Select Shipping Method",
                                  "Select a shipping method (e.g., standard, expedited).");
    
        try {
            // Navigate to checkout page (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Select shipping method (assertions or validations here)
            // Example:
            WebElement standardShippingOption = driver.findElement(By.id("STANDARD_SHIPPING_OPTION")); // Replace with actual ID
            standardShippingOption.click();
    
            // Check if selected shipping method is highlighted or marked as selected (assuming validation)
            assertTrue(standardShippingOption.isSelected(), "Standard shipping method not selected.");
    
            test.log(Status.PASS, "Selected shipping method successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to select shipping method: " + e.getMessage());
        }
    }
    


    @Test
    public void verifyEstimatedDeliveryDate() {
        test = reports.createTest("Estimated Delivery Date:Verify Estimated Delivery Date",
                                  "Verify that the estimated delivery date is displayed based on the selected shipping method.");
    
        try {
            // Navigate to checkout page (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Select shipping method (assuming standard shipping is selected)
            WebElement standardShippingOption = driver.findElement(By.id("STANDARD_SHIPPING_OPTION")); // Replace with actual ID
            standardShippingOption.click();
    
            // Verify estimated delivery date (assuming validation)
            WebElement estimatedDeliveryDateElement = driver.findElement(By.id("ESTIMATED_DELIVERY_DATE")); // Replace with actual ID
            assertTrue(estimatedDeliveryDateElement.isDisplayed(), "Estimated delivery date not displayed.");
    
            test.log(Status.PASS, "Estimated delivery date is displayed based on the selected shipping method.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify estimated delivery date: " + e.getMessage());
        }
    }
    

    @Test
    public void navigateToShoppingCartPage11() {
        test = reports.createTest("Shipping Information:Proceed to Checkout and Enter Shipping Information",
                                  "Navigate to the shopping cart page after adding products.");
    
        try {
            // Navigate to product page and add product(s) to shopping cart (if not already added)
            driver.get("URL_OF_PRODUCT_PAGE"); // Replace 'URL_OF_PRODUCT_PAGE' with actual URL
    
            // Add product(s) to cart (assertions or validations here)
            // Example:
            WebElement addToCartButton = driver.findElement(By.id("ADD_TO_CART_BUTTON")); // Replace with actual ID
            addToCartButton.click();
    
            // Proceed to checkout (assertions or validations here)
            // Example:
            WebElement checkoutButton = driver.findElement(By.id("CHECKOUT_BUTTON")); // Replace with actual ID
            checkoutButton.click();
    
            // Verify if shopping cart page is displayed with added items (assuming validation)
            WebElement shoppingCartItemsSection = driver.findElement(By.id("SHOPPING_CART_ITEMS_SECTION")); // Replace with actual ID
            assertTrue(shoppingCartItemsSection.isDisplayed(), "Shopping cart items not displayed on cart page.");
    
            test.log(Status.PASS, "Successfully navigated to shopping cart page and entered shipping information.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to shopping cart page: " + e.getMessage());
        }
    }
    


    @Test
    public void proceedToCheckout() {
        test = reports.createTest("Shipping Information:Proceed to Checkout",
                                  "Locate and click on the 'Proceed to Checkout' button.");
    
        try {
            // Navigate to shopping cart page (if not already there)
            driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
    
            // Click on 'Proceed to Checkout' button (assertions or validations here)
            // Example:
            WebElement proceedToCheckoutButton = driver.findElement(By.id("PROCEED_TO_CHECKOUT_BUTTON")); // Replace with actual ID
            proceedToCheckoutButton.click();
    
            // Verify if checkout page is loaded with shipping information fields (assuming validation)
            WebElement shippingInformationSection = driver.findElement(By.id("SHIPPING_INFORMATION_SECTION")); // Replace with actual ID
            assertTrue(shippingInformationSection.isDisplayed(), "Checkout page not loaded with shipping information fields.");
    
            test.log(Status.PASS, "Clicked on 'Proceed to Checkout' button and loaded checkout page with shipping information fields.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to proceed to checkout: " + e.getMessage());
        }
    }
    


    @Test
    public void enterShippingInformation() {
        test = reports.createTest("Enter Shipping Information",
                                  "Enter valid shipping information such as name, address, city, zip code, and contact details.");
    
        try {
            // Navigate to checkout page with shipping information fields (if not already there)
            driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL
    
            // Enter shipping information (assertions or validations here)
            // Example:
            WebElement nameField = driver.findElement(By.id("NAME_FIELD")); // Replace with actual ID
            nameField.sendKeys("John Doe");
    
            WebElement addressField = driver.findElement(By.id("ADDRESS_FIELD")); // Replace with actual ID
            addressField.sendKeys("123 Shipping St");
    
            WebElement cityField = driver.findElement(By.id("CITY_FIELD")); // Replace with actual ID
            cityField.sendKeys("City");
    
            WebElement zipCodeField = driver.findElement(By.id("ZIP_CODE_FIELD")); // Replace with actual ID
            zipCodeField.sendKeys("12345");
    
            WebElement contactDetailsField = driver.findElement(By.id("CONTACT_DETAILS_FIELD")); // Replace with actual ID
            contactDetailsField.sendKeys("john.doe@example.com");
    
            // Validate if information is accepted and proceed (assuming validation logic)
            WebElement validateInfoButton = driver.findElement(By.id("VALIDATE_INFO_BUTTON")); // Replace with actual ID
            validateInfoButton.click();
            test.log(Status.PASS, "Successfully navigated to shopping cart page.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to shopping cart page: " + e.getMessage());
        }
    }
        
    
            // Example validation: check if next step is available
    




            @Test
            public void navigateToShoppingCartPage1() {
                test = reports.createTest("Shopping Cart:Remove Items from Shopping Cart",
                                          "Navigate to the shopping cart page after adding items to the cart.");
            
                try {
                    // Navigate to product page and add product(s) to shopping cart (if not already added)
                    driver.get("URL_OF_PRODUCT_PAGE"); // Replace 'URL_OF_PRODUCT_PAGE' with actual URL
            
                    // Add product(s) to cart (assertions or validations here)
                    // Example:
                    WebElement addToCartButton = driver.findElement(By.id("ADD_TO_CART_BUTTON")); // Replace with actual ID
                    addToCartButton.click();
            
                    // Proceed to shopping cart (assertions or validations here)
                    // Example:
                    WebElement shoppingCartIcon = driver.findElement(By.id("SHOPPING_CART_ICON")); // Replace with actual ID
                    shoppingCartIcon.click();
            
                    // Verify if shopping cart page is displayed (assuming validation)
                    WebElement shoppingCartItemsSection = driver.findElement(By.id("SHOPPING_CART_ITEMS_SECTION")); // Replace with actual ID
                    assertTrue(shoppingCartItemsSection.isDisplayed(), "Shopping cart page not displayed.");
            
                    test.log(Status.PASS, "Successfully navigated to shopping cart page.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to navigate to shopping cart page: " + e.getMessage());
                }
            }
            



            @Test
            public void locateItemInCartToRemove1() {
                test = reports.createTest("Cart to Remove:Locate Item in Cart to Remove",
                                          "Locate the item in the cart that needs to be removed.");
            
                try {
                    // Navigate to shopping cart page (assuming already on the page)
                    driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
            
                    // Locate item to be removed (assertions or validations here)
                    // Example:
                    WebElement itemToRemove = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Item Name')]")); // Replace with actual XPath
                    assertTrue(itemToRemove.isDisplayed(), "Item to remove not found in the cart.");
            
                    test.log(Status.PASS, "Located item in the cart to be removed.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to locate item in the cart to remove: " + e.getMessage());
                }
            }
            

            @Test
            public void findOptionToRemoveItem1() {
                test = reports.createTest("Remove Item:Find Option to Remove Item from Cart",
                                          "Find the option to remove the item from the cart.");
            
                try {
                    // Navigate to shopping cart page (assuming already on the page)
                    driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
            
                    // Find option to remove item (assertions or validations here)
                    // Example:
                    WebElement removeButton = driver.findElement(By.xpath("//div[@class='cart-item']//button[@class='remove-button']")); // Replace with actual XPath
                    assertTrue(removeButton.isDisplayed(), "Option to remove item not found.");
            
                    test.log(Status.PASS, "Found option to remove the item from the cart.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to find option to remove item: " + e.getMessage());
                }
            }

            

            @Test
            public void clickToRemoveItemFromCart1() {
                test = reports.createTest("Remove Item :Click to Remove Item from Cart",
                                          "Click on the remove option for the specific item.");
            
                try {
                    // Navigate to shopping cart page (assuming already on the page)
                    driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
            
                    // Click on remove option for item (assertions or validations here)
                    // Example:
                    WebElement removeButton = driver.findElement(By.xpath("//div[@class='cart-item']//button[@class='remove-button']")); // Replace with actual XPath
                    removeButton.click();
            
                    // Validate if item is removed (assuming validation logic)
                    WebElement removedItem = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Item Name')]")); // Replace with actual XPath
                    assertFalse(removedItem.isDisplayed(), "Item still displayed after removal.");
            
                    test.log(Status.FAIL, "Item was not successfully removed from the cart.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to click to remove item from cart: " + e.getMessage());
                }
            }
                      


            @Test
            public void verifyItemRemovedFromCart() {
                test = reports.createTest("Verify Item:Verify Item Removed from Cart",
                                          "Verify that the item is no longer displayed in the cart.");
            
                try {
                    // Navigate to shopping cart page (assuming already on the page)
                    driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
            
                    // Validate if item is no longer displayed (assuming validation logic)
                    WebElement removedItem = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Item Name')]")); // Replace with actual XPath
                    assertFalse(removedItem.isDisplayed(), "Item still displayed in cart after removal.");
            
                    test.log(Status.FAIL, "Item is still visible in the cart after removal.");
                } catch (NoSuchElementException e) {
                    test.log(Status.PASS, "Item is no longer displayed in the cart after removal.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to verify item removed from cart: " + e.getMessage());
                }
            }

            @Test
            public void checkTotalPriceAfterItemRemoval() {
                test = reports.createTest("Total Price:Check Total Price After Item Removal",
                                          "Check the total price displayed in the cart after item removal.");
            
                try {
                    // Navigate to shopping cart page (assuming already on the page)
                    driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
            
                    // Check total price after item removal (assuming validation logic)
                    WebElement totalPriceElement = driver.findElement(By.id("TOTAL_PRICE")); // Replace with actual ID
                    String totalPriceAfterRemoval = totalPriceElement.getText();
            
                    // Compare with expected total price (after removal logic)
                    String expectedTotalPrice = "UPDATED_TOTAL_PRICE"; // Replace with actual expected total price
            
                    assertEquals(totalPriceAfterRemoval, expectedTotalPrice, "Total price not updated after item removal.");
            
                    test.log(Status.FAIL, "Total price is not updated after item removal.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to check total price after item removal: " + e.getMessage());
                }
            }
                       


            @Test
            public void navigateToShoppingCartPage() {
                test = reports.createTest("Remove Items from Shopping Cart",
                                          "Navigate to the shopping cart page after adding items to the cart.");
            
                try {
                    // Navigate to shopping cart page
                    driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL
            
                    // Verify if shopping cart page is displayed
                    WebElement shoppingCartItemsSection = driver.findElement(By.id("SHOPPING_CART_ITEMS_SECTION")); // Replace with actual ID
                    assertTrue(shoppingCartItemsSection.isDisplayed(), "Shopping cart page is not displayed.");
            
                    test.log(Status.PASS, "Successfully navigated to shopping cart page.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to navigate to shopping cart page: " + e.getMessage());
                }
            }
            

            @Test
            public void locateItemInCartToRemove() {
                test = reports.createTest("Locate Item:Locate Item in Cart to Remove",
                                          "Locate the item in the cart that needs to be removed.");
            
                try {
                    // Locate item to be removed
                    WebElement itemToRemove = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Item Name')]")); // Replace with actual XPath
                    assertTrue(itemToRemove.isDisplayed(), "Item to remove not found in the cart.");
            
                    test.log(Status.PASS, "Located item in the cart to be removed.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to locate item in the cart to remove: " + e.getMessage());
                }
            }
            
            @Test
            public void findOptionToRemoveItem() {
                test = reports.createTest("Find Option:Find Option to Remove Item from Cart",
                                          "Find the option to remove the item from the cart.");
            
                try {
                    // Find option to remove item
                    WebElement removeButton = driver.findElement(By.xpath("//div[@class='cart-item']//button[@class='remove-button']")); // Replace with actual XPath
                    assertTrue(removeButton.isDisplayed(), "Option to remove item not found.");
            
                    test.log(Status.PASS, "Found option to remove the item from the cart.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to find option to remove item: " + e.getMessage());
                }
            }

            
            @Test
            public void clickToRemoveItemFromCart() {
                test = reports.createTest("Click to Remove:Click to Remove Item from Cart",
                                          "Click on the remove option for the specific item.");
            
                try {
                    // Click on remove option for item
                    WebElement removeButton = driver.findElement(By.xpath("//div[@class='cart-item']//button[@class='remove-button']")); // Replace with actual XPath
                    removeButton.click();
            
                    // Validate if item is removed
                    WebElement removedItem = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Item Name')]")); // Replace with actual XPath
                    assertFalse(removedItem.isDisplayed(), "Item still displayed after removal.");
            
                    test.log(Status.FAIL, "Item was not successfully removed from the cart.");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Failed to click to remove item from cart: " + e.getMessage());
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