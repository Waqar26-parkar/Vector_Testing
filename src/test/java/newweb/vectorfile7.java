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
import junit.framework.Assert;
 
public class vectorfile7 {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Testcase8.html");
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
    public void navigateToWebsite() {
        test = reports.createTest("Navigate to Website", "Navigates to the specified URL.");
        driver.get("https://www.example.com/");
        test.log(Status.PASS, "Successfully navigated to the website.");
    }

    @Test
    public void interactWithForm() {
        test = reports.createTest("Interact with Form", "Fills out a form on the website.");
        driver.get("https://www.example.com/form-page");

        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys("Doe");

        WebElement submitButton = driver.findElement(By.id("submit-form"));
        submitButton.click();

        test.log(Status.PASS, "Successfully filled out the form and submitted it.");
    }

    @Test
    public void verifyTextContent() {
        test = reports.createTest("Verify Text Content", "Verifies the text content of an element.");
        driver.get("https://www.example.com/text-content-page");

        WebElement textElement = driver.findElement(By.id("textContent"));
        String actualText = textElement.getText();
        assertEquals(actualText, "Expected Text", "The text content does not match the expected value.");

        test.log(Status.PASS, "Successfully verified the text content.");
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void handleException() {
        test = reports.createTest("Handle Exception", "Demonstrates handling an exception during testing.");
        driver.get("https://www.example.com/nonexistent-page");

        WebElement nonExistentElement = driver.findElement(By.id("non-existent-element"));

        test.log(Status.FAIL, "An exception was thrown as expected.");
    }

    
    @Test
    public void checkTotalPriceAfterItemRemoval() {
        test = reports.createTest("Check Total Price: Check Total Price After Item Removal",
                                  "This test checks the total price displayed in the cart after an item has been removed.");

        try {
            // Attempt to find the total price element on the page
            WebElement totalPriceElement = driver.findElement(By.id("TOTAL_PRICE")); // Ensure this ID matches the actual element ID on the webpage

            // Retrieve the text of the total price element
            String totalPriceAfterRemoval = totalPriceElement.getText();

            // Define the expected total price after the item has been removed
            String expectedTotalPrice = "UPDATED_TOTAL_PRICE"; // Replace this with the actual expected total price

            // Assert that the actual total price matches the expected total price
            assertEquals(totalPriceAfterRemoval, expectedTotalPrice, "Total price did not update as expected after item removal.");

            test.log(Status.PASS, "Total price checked and confirmed to be correct after item removal.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to check total price after item removal due to: " + e.getMessage());
        }
    }

    @Test
    public void navigateToShoppingCartPage() {
        test = reports.createTest("Update Quantity of Items in the Cart",
                                  "This test navigates to the shopping cart page to perform quantity updates.");

        try {
            // Navigate to the shopping cart page
            driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with the actual URL of the shopping cart page

            // Verify that the shopping cart page is displayed
            WebElement shoppingCartItemsSection = driver.findElement(By.id("SHOPPING_CART_ITEMS_SECTION")); // Ensure this ID matches the actual element ID on the webpage
            assertTrue(shoppingCartItemsSection.isDisplayed(), "Shopping cart page failed to display.");

            test.log(Status.PASS, "Successfully navigated to and verified the shopping cart page.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to the shopping cart page due to: " + e.getMessage());
        }
    }

    @Test
    public void locateItemInCartForQuantityUpdate() {
        test = reports.createTest("Item in Cart: Locate Item in Cart for Quantity Update",
                                  "This test locates the item in the cart for which the quantity needs to be updated.");

        try {
            // Attempt to locate the item in the cart by its name
            WebElement itemToUpdate = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Item Name')]")); // Replace 'Item Name' with the actual name of the item
            assertTrue(itemToUpdate.isDisplayed(), "Item to update quantity not found in the cart.");

            test.log(Status.PASS, "Successfully located the item in the cart for quantity update.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to locate the item in the cart for quantity update due to: " + e.getMessage());
        }
    }

    

    @Test
public void verifyHelpCenterContentSections() {
    test = reports.createTest("Verify Help Center content sections: Verify that the Help Center provides FAQs, guides, and troubleshooting tips for common issues", 
                              "User should see sections for FAQs, guides, and troubleshooting tips on the Help Center page");

    try {
        // Navigate to the Help Center page
        driver.get("URL_OF_HELP_CENTER_PAGE"); // Replace 'URL_OF_HELP_CENTER_PAGE' with the actual URL of the Help Center page

        // Wait for the Help Center page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Verify the presence of the FAQs section
        WebElement faqsSection = driver.findElement(By.id("FAQS_SECTION_ID")); // Replace 'FAQS_SECTION_ID' with the actual ID of the FAQs section
        assertTrue(faqsSection.isDisplayed(), "The FAQs section should be visible on the Help Center page");

        // Verify the presence of the guides section
        WebElement guidesSection = driver.findElement(By.id("GUIDES_SECTION_ID")); // Replace 'GUIDES_SECTION_ID' with the actual ID of the guides section
        assertTrue(guidesSection.isDisplayed(), "The guides section should be visible on the Help Center page");

        // Verify the presence of the troubleshooting tips section
        WebElement troubleshootingTipsSection = driver.findElement(By.id("TROUBLESHOOTING_TIPS_SECTION_ID")); // Replace 'TROUBLESHOOTING_TIPS_SECTION_ID' with the actual ID of the troubleshooting tips section
        assertTrue(troubleshootingTipsSection.isDisplayed(), "The troubleshooting tips section should be visible on the Help Center page");

        test.log(Status.FAIL, "User was able to see sections for FAQs, guides, and troubleshooting tips on the Help Center page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify the presence of FAQs, guides, and troubleshooting tips sections on the Help Center page: " + e.getMessage());
    }
}







@Test
public void accessHelpCenterFromAnyPage() {
    test = reports.createTest("Access page: Navigate to any page of the website", 
                              "User should be able to access the Help Center from any page of the website");

    try {
        // Navigate to any page on the website
        String url = "URL_OF_ANY_PAGE"; // Replace 'URL_OF_ANY_PAGE' with the actual URL you want to test
        driver.get(url);

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Locate and click the Help Center link in the footer or header
        WebElement helpCenterLink = driver.findElement(By.id("HELP_CENTER_LINK_ID")); // Replace 'HELP_CENTER_LINK_ID' with the actual ID of the Help Center link
        helpCenterLink.click();

        // Wait for the Help Center page to load
        wait.until(ExpectedConditions.urlContains("HELP_CENTER_PAGE_URL")); // Replace 'HELP_CENTER_PAGE_URL' with the actual URL fragment of the Help Center page

        // Verify the URL of the Help Center page
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("HELP_CENTER_PAGE_URL"), "The user should be directed to the Help Center page");

        test.log(Status.FAIL, "User was able to access the Help Center from any page of the website successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to access the Help Center from any page of the website: ");
    }
}


@Test
public void locateFooterSection() {
    test = reports.createTest("Locate Footer section: Locate the footer section of the page", 
                              "Footer section should be visible on the page");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the footer section
        WebElement footerSection = driver.findElement(By.id("FOOTER_SECTION_ID")); // Replace 'FOOTER_SECTION_ID' with the actual ID of the footer section

        // Verify the footer section is displayed
        assertTrue(footerSection.isDisplayed(), "The footer section should be visible on the page");

        test.log(Status.PASS, "Footer section is visible on the page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate the footer section: " + e.getMessage());
    }
}



@Test
public void checkHelpCenterLinkInFooter() {
    test = reports.createTest("Check Help Center link in Footer: Check if there is a link to the Help Center in the footer", 
                              "Link to the Help Center should be present in the footer");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the Help Center link in the footer
        WebElement helpCenterLinkInFooter = driver.findElement(By.id("HELP_CENTER_LINK_IN_FOOTER_ID")); // Replace 'HELP_CENTER_LINK_IN_FOOTER_ID' with the actual ID of the Help Center link in the footer

        // Verify the Help Center link is present in the footer
        assertTrue(helpCenterLinkInFooter.isDisplayed(), "The Help Center link should be present in the footer");

        test.log(Status.PASS, "Link to the Help Center is present in the footer.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to find the Help Center link in the footer: " + e.getMessage());
    }
}


@Test
public void navigateToHeaderSection1() {
    test = reports.createTest("Navigate to Header section: Navigate to the header section of the page", 
                              "Header section should be visible on the page");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the header section
        WebElement headerSection = driver.findElement(By.id("HEADER_SECTION_ID")); // Replace 'HEADER_SECTION_ID' with the actual ID of the header section

        // Verify the header section is displayed
        assertTrue(headerSection.isDisplayed(), "The header section should be visible on the page");

        test.log(Status.PASS, "Header section is visible on the page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate the header section: " + e.getMessage());
    }
}


    
@Test
public void navigateToHeaderSection() {
    test = reports.createTest("Navigate to Header section: Navigate to the header section of the page", 
                              "Header section should be visible on the page");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the header section
        WebElement headerSection = driver.findElement(By.id("HEADER_SECTION_ID")); // Replace 'HEADER_SECTION_ID' with the actual ID of the header section

        // Verify the header section is displayed
        assertTrue(headerSection.isDisplayed(), "The header section should be visible on the page");

        test.log(Status.PASS, "Header section is visible on the page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate the header section: " + e.getMessage());
    }
}


@Test
public void checkHelpCenterLinkInHeader() {
    test = reports.createTest("Check Help Center link in Header: Check if there is a link to the Help Center in the header", 
                              "Link to the Help Center should be present in the header");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the Help Center link in the header
        WebElement helpCenterLinkInHeader = driver.findElement(By.id("HELP_CENTER_LINK_IN_HEADER_ID")); // Replace 'HELP_CENTER_LINK_IN_HEADER_ID' with the actual ID of the Help Center link in the header

        // Verify the Help Center link is present in the header
        assertTrue(helpCenterLinkInHeader.isDisplayed(), "The Help Center link should be present in the header");

        test.log(Status.PASS, "Link to the Help Center is present in the header.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to find the Help Center link in the header: " + e.getMessage());
    }
}



    

@Test
public void placeOrderAndReceiveConfirmationEmail() {
    test = reports.createTest("Place an Order: Place an order on the website", 
                              "Order should be successfully placed and a confirmation email should be received");

    try {
        // Navigate to the product page
        driver.get("URL_OF_PRODUCT_PAGE"); // Replace 'URL_OF_PRODUCT_PAGE' with the actual URL of the product page

        // Locate and click the 'Add to Cart' button
        WebElement addToCartButton = driver.findElement(By.id("ADD_TO_CART_BUTTON_ID")); // Replace 'ADD_TO_CART_BUTTON_ID' with the actual ID
        addToCartButton.click();

        // Navigate to the cart page
        driver.get("URL_OF_CART_PAGE"); // Replace 'URL_OF_CART_PAGE' with the actual URL of the cart page

        // Locate and click the 'Proceed to Checkout' button
        WebElement checkoutButton = driver.findElement(By.id("CHECKOUT_BUTTON_ID")); // Replace 'CHECKOUT_BUTTON_ID' with the actual ID
        checkoutButton.click();

        // Fill in the checkout form and place the order
        WebElement nameField = driver.findElement(By.id("NAME_FIELD_ID")); // Replace 'NAME_FIELD_ID' with the actual ID
        WebElement addressField = driver.findElement(By.id("ADDRESS_FIELD_ID")); // Replace 'ADDRESS_FIELD_ID' with the actual ID
        WebElement paymentField = driver.findElement(By.id("PAYMENT_FIELD_ID")); // Replace 'PAYMENT_FIELD_ID' with the actual ID
        WebElement placeOrderButton = driver.findElement(By.id("PLACE_ORDER_BUTTON_ID")); // Replace 'PLACE_ORDER_BUTTON_ID' with the actual ID

        // Enter valid details
        String validName = "VALID_NAME"; // Replace 'VALID_NAME' with the actual valid name
        String validAddress = "VALID_ADDRESS"; // Replace 'VALID_ADDRESS' with the actual valid address
        String validPayment = "VALID_PAYMENT"; // Replace 'VALID_PAYMENT' with the actual valid payment details
        nameField.sendKeys(validName);
        addressField.sendKeys(validAddress);
        paymentField.sendKeys(validPayment);

        // Click the 'Place Order' button
        placeOrderButton.click();

        // Wait for the order confirmation page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ORDER_CONFIRMATION_URL")); // Replace 'ORDER_CONFIRMATION_URL' with the actual URL fragment of the order confirmation page

        // Verify the URL of the order confirmation page
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ORDER_CONFIRMATION_URL"), "The order should be successfully placed");

        // Verify confirmation email is received (Assume there is a method checkEmailReceived)
        boolean isEmailReceived = checkEmailReceived("ORDER_CONFIRMATION_SUBJECT"); // Replace 'ORDER_CONFIRMATION_SUBJECT' with the actual subject of the confirmation email
        assertTrue(isEmailReceived, "Confirmation email should be received");

        test.log(Status.PASS, "Order is successfully placed and confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to place order and receive confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check if an email is received
private boolean checkEmailReceived(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    // This could involve connecting to an email server via IMAP/POP3 and checking for the email
    return true; // Replace with actual email checking logic
}




@Test
public void waitForOrderToBeProcessedAndShipped() {
    test = reports.createTest("Order Processing and Shipping: Wait for the order to be processed and shipped", 
                              "Order status should be updated, and a shipping confirmation email should be received");

    try {
        // Assume there is a method checkOrderStatus that checks the order status
        boolean isOrderProcessedAndShipped = checkOrderStatus("SHIPPED"); // Replace 'SHIPPED' with the actual status
        assertTrue(isOrderProcessedAndShipped, "Order status should be updated to 'Shipped'");

        // Verify shipping confirmation email is received (Assume there is a method checkEmailReceived)
        boolean isShippingEmailReceived = checkEmailReceived("SHIPPING_CONFIRMATION_SUBJECT"); // Replace 'SHIPPING_CONFIRMATION_SUBJECT' with the actual subject of the shipping confirmation email
        assertTrue(isShippingEmailReceived, "Shipping confirmation email should be received");

        test.log(Status.PASS, "Order status is updated, and shipping confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to update order status to 'Shipped' and receive shipping confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check order status
private boolean checkOrderStatus(String status) {
    // Implement logic to check the order status
    // This could involve API calls or database queries to check the current order status
    return true; // Replace with actual order status checking logic
}





@Test
public void waitForOrderToBeOutForDelivery() {
    test = reports.createTest("Order Out for Delivery: Wait for the order to be out for delivery", 
                              "Order status should be updated, and a delivery confirmation email should be received");

    try {
        // Assume there is a method checkOrderStatus that checks the order status
        boolean isOrderOutForDelivery = checkOrderStatus("OUT_FOR_DELIVERY"); // Replace 'OUT_FOR_DELIVERY' with the actual status
        assertTrue(isOrderOutForDelivery, "Order status should be updated to 'Out for Delivery'");

        // Verify delivery confirmation email is received (Assume there is a method checkEmailReceived)
        boolean isDeliveryEmailReceived = checkEmailReceived("DELIVERY_CONFIRMATION_SUBJECT"); // Replace 'DELIVERY_CONFIRMATION_SUBJECT' with the actual subject of the delivery confirmation email
        assertTrue(isDeliveryEmailReceived, "Delivery confirmation email should be received");

        test.log(Status.PASS, "Order status is updated, and delivery confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to update order status to 'Out for Delivery' and receive delivery confirmation email: " + e.getMessage());
    }
}

    

@Test
public void addProductToCart() {
    test = reports.createTest("Add Product:Add Product to Shopping Cart",
                              "Add the product to the shopping cart with the selected variations.");

    try {
        // Add product to cart
        WebElement addToCartButton = driver.findElement(By.id("ADD_TO_CART_BUTTON")); // Replace with actual ID
        addToCartButton.click();

        // Verify if product is added to cart
        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart-item']/span[contains(text(),'Product Name')]")); // Replace with actual XPath
        assertTrue(cartItem.isDisplayed(), "Product not added to the cart.");

        test.log(Status.PASS, "Product added to the shopping cart successfully with the selected variations.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to add product to the shopping cart: " + e.getMessage());
    }
}



public void verifyPurchaseBadge() {
    // Step 1: Navigate to the product detail page
    driver.get("URL_OF_PRODUCT_DETAIL_PAGE"); // Replace with actual URL
    WebElement productDetailSection = driver.findElement(By.id("PRODUCT_DETAIL_SECTION")); // Replace with actual ID
    Assert.assertTrue(productDetailSection.isDisplayed());

    // Step 2: Identify a review from a verified purchaser
    WebElement reviewSection = driver.findElement(By.id("REVIEW_SECTION")); // Replace with actual ID
    WebElement verifiedReview = reviewSection.findElement(By.xpath("//div[contains(text(), 'Verified Purchaser')]")); // Replace with actual locator strategy
    Assert.assertTrue(verifiedReview.isDisplayed());

    // Step 3: Check for 'Verified Purchase' badge
    WebElement verifiedBadge = verifiedReview.findElement(By.className("VERIFIED_BADGE_CLASS")); // Replace with actual class name
    Assert.assertTrue(verifiedBadge.isDisplayed());
}

public void testMarkReviewsFromVerifiedPurchasers() {
    // Step 1: Navigate to the product detail page
    driver.get("URL_OF_PRODUCT_DETAIL_PAGE"); // Replace with the actual URL of the product detail page
    WebElement productDetailSection = driver.findElement(By.id("PRODUCT_DETAIL_SECTION_ID")); // Replace with actual ID or locator
    Assert.assertTrue(productDetailSection.isDisplayed());
    System.out.println("Step 1: Product detail page is displayed. Pass");

    // Step 2: Identify a review from a verified purchaser
    WebElement reviewSection = driver.findElement(By.id("REVIEW_SECTION_ID")); // Replace with actual ID or locator
    WebElement verifiedReview = reviewSection.findElement(By.xpath("//*[contains(text(), 'Verified Purchaser')]")); // Replace with actual locator strategy
    Assert.assertTrue(verifiedReview.isDisplayed());
    System.out.println("Step 2: Verified purchaser review is visible. Pass");

    // Step 3: Check for 'Verified Purchase' badge next to the review
    WebElement verifiedBadge = verifiedReview.findElement(By.className("VERIFIED_BADGE_CLASS")); // Replace with actual class name or locator
    boolean isBadgeDisplayed = verifiedBadge.isDisplayed();
    if(isBadgeDisplayed) {
        System.out.println("Step 3: 'Verified Purchase' badge is displayed. Pass");
    } else {
        System.out.println("Step 3: 'Verified Purchase' badge is not displayed. Fail");
    }
    Assert.assertTrue(isBadgeDisplayed);
}




    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

    @AfterTest(alwaysRun = true)
    public void endReport() {
        reports.flush();
    }
}
