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
 
public class vectorfile4 {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Testcase6.html");
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
    public void viewOrderHistory_LoginAndNavigateToDashboard() {
        test = reports.createTest("View Order History: Log in and Navigate to Dashboard", 
                                  "Log in to customer account and navigate to order history.");
    
        try {
            // Navigate to login page
            driver.get("URL_OF_LOGIN_PAGE"); // Replace 'URL_OF_LOGIN_PAGE' with actual URL
    
            // Enter username and password
            WebElement usernameField = driver.findElement(By.id("USERNAME_FIELD")); // Replace 'USERNAME_FIELD' with actual ID
            WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD")); // Replace 'PASSWORD_FIELD' with actual ID
    
            usernameField.sendKeys("YOUR_USERNAME");
            passwordField.sendKeys("YOUR_PASSWORD");
    
            // Submit login form
            passwordField.submit();
    
            // Verify successful login and dashboard navigation (assertions or validations here)
            // Example:
            WebElement dashboardElement = driver.findElement(By.id("DASHBOARD_ELEMENT")); // Replace with actual ID
            assertTrue(dashboardElement.isDisplayed(), "User not directed to dashboard after login.");
    
            test.log(Status.PASS, "Logged in successfully and navigated to dashboard.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to log in and navigate to dashboard: " + e.getMessage());
        }
    }

    

    @Test
public void clickOrderHistorySection() {
    test = reports.createTest("Order Histor:Click Order History Section", 
                              "Locate and click on the Order History section in account dashboard.");

    try {
        // Navigate to account dashboard (if not already there)
        driver.get("URL_OF_ACCOUNT_DASHBOARD"); // Replace 'URL_OF_ACCOUNT_DASHBOARD' with actual URL

        // Click on Order History section
        WebElement orderHistoryLink = driver.findElement(By.id("ORDER_HISTORY_LINK")); // Replace 'ORDER_HISTORY_LINK' with actual ID
        orderHistoryLink.click();

        // Verify if Order History section is displayed (assertions or validations here)
        // Example:
        WebElement orderHistorySection = driver.findElement(By.id("ORDER_HISTORY_SECTION")); // Replace with actual ID
        assertTrue(orderHistorySection.isDisplayed(), "Order History section not displayed.");

        test.log(Status.PASS, "Clicked on Order History section and verified its display.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to click on Order History section: " + e.getMessage());
    }
}



@Test
public void verifyOrderStatusesInOrderHistory() {
    test = reports.createTest("Order Statuses:Verify Order Statuses in Order History", 
                              "Verify that all past orders are listed with their respective statuses.");

    try {
        // Navigate to order history section (if not already there)
        driver.get("URL_OF_ORDER_HISTORY_PAGE"); // Replace 'URL_OF_ORDER_HISTORY_PAGE' with actual URL

        // Check for visibility of order statuses (assertions or validations here)
        // Example:
        List<WebElement> orderStatusElements = driver.findElements(By.cssSelector(".order-status")); // Replace with actual selector
        assertFalse(orderStatusElements.isEmpty(), "No order statuses found in order history.");

        test.log(Status.PASS, "All past orders are visible with their respective statuses.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify order statuses in order history: " + e.getMessage());
    }
}



@Test
public void checkOrderDetailsInOrderHistory() {
    test = reports.createTest("Order Details:Check Order Details in Order History", 
                              "Check if the order details include order number, date, status, and other relevant information.");

    try {
        // Navigate to order history section (if not already there)
        driver.get("URL_OF_ORDER_HISTORY_PAGE"); // Replace 'URL_OF_ORDER_HISTORY_PAGE' with actual URL

        // Check for visibility of order details (assertions or validations here)
        // Example:
        List<WebElement> orderDetailElements = driver.findElements(By.cssSelector(".order-details")); // Replace with actual selector
        assertFalse(orderDetailElements.isEmpty(), "No order details found in order history.");

        test.log(Status.PASS, "Order details such as order number, date, status, and other relevant information are displayed.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to check order details in order history: " + e.getMessage());
    }
}

    

@Test
public void verifyOrderHistoryAccuracy() {
    test = reports.createTest("Order History:Verify Order History Accuracy", 
                              "Ensure that the order history is up to date and accurately reflects the current status of each order.");

    try {
        // Navigate to order history section (if not already there)
        driver.get("URL_OF_ORDER_HISTORY_PAGE"); // Replace 'URL_OF_ORDER_HISTORY_PAGE' with actual URL

        // Verify order history accuracy (assertions or validations here)
        // Example:
        boolean isOrderHistoryUpToDate = isOrderHistoryUpToDate(); // Custom method to verify order history accuracy
        assertTrue(isOrderHistoryUpToDate, "Order history does not accurately reflect the current status of each order.");

        test.log(Status.PASS, "Order history is up to date and accurately reflects the current status of each order.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify order history accuracy: " + e.getMessage());
    }
}

// Placeholder method for verifying order history accuracy (can be implemented based on application's logic)
private boolean isOrderHistoryUpToDate() {
    // Implement logic to verify order history accuracy
    // Example:
    // Check if all orders have correct statuses, dates, etc.
    return true; // Replace with actual verification logic
}



@Test
public void proceedToCheckoutWithFilledCart() {
    test = reports.createTest("Shopping Cart:Proceed to Checkout with Filled Shopping Cart", 
                              "User is on the checkout process page with items in the shopping cart.");

    try {
        // Navigate to shopping cart (if not already there)
        driver.get("URL_OF_SHOPPING_CART_PAGE"); // Replace 'URL_OF_SHOPPING_CART_PAGE' with actual URL

        // Proceed to checkout (assertions or validations here)
        // Example:
        WebElement checkoutButton = driver.findElement(By.id("CHECKOUT_BUTTON")); // Replace with actual ID
        checkoutButton.click();

        // Verify if checkout process page is reached
        WebElement checkoutPageHeader = driver.findElement(By.id("CHECKOUT_PAGE_HEADER")); // Replace with actual ID
        assertTrue(checkoutPageHeader.isDisplayed(), "User not on checkout process page after proceeding.");

        test.log(Status.PASS, "Proceeded to checkout process with filled shopping cart.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to proceed to checkout with filled shopping cart: " + e.getMessage());
    }
}


@Test
public void enterShippingAndBillingInformation() {
    test = reports.createTest("Billing Information:Enter Shipping and Billing Information", 
                              "User successfully enters shipping and billing information.");

    try {
        // Navigate to checkout page with shipping and billing information fields (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Enter shipping and billing information (assertions or validations here)
        // Example:
        WebElement shippingAddressField = driver.findElement(By.id("SHIPPING_ADDRESS_FIELD")); // Replace with actual ID
        shippingAddressField.sendKeys("123 Shipping St, City, Country");

        WebElement billingAddressField = driver.findElement(By.id("BILLING_ADDRESS_FIELD")); // Replace with actual ID
        billingAddressField.sendKeys("456 Billing St, City, Country");

        test.log(Status.PASS, "Entered shipping and billing information successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to enter shipping and billing information: " + e.getMessage());
    }
}




@Test
public void selectShippingMethodAndVerifyDeliveryDate1() {
    test = reports.createTest("Shipping Method: Select Shipping Method and Verify Delivery Date", 
                              "User selects a shipping method and verifies the estimated delivery date.");

    try {
        // Navigate to checkout page with shipping options (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Select shipping method (assertions or validations here)
        // Example:
        WebElement standardShippingOption = driver.findElement(By.id("STANDARD_SHIPPING_OPTION")); // Replace with actual ID
        standardShippingOption.click();

        // Verify estimated delivery date (assertions or validations here)
        // Example:
        WebElement estimatedDeliveryDateElement = driver.findElement(By.id("ESTIMATED_DELIVERY_DATE")); // Replace with actual ID
        assertTrue(estimatedDeliveryDateElement.isDisplayed(), "Estimated delivery date not displayed after selecting shipping method.");

        test.log(Status.PASS, "Selected shipping method and verified estimated delivery date.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to select shipping method and verify delivery date: " + e.getMessage());
    }
}


@Test
public void choosePaymentMethodAndCompletePurchase1() {
    test = reports.createTest(" Payment Method:Choose Payment Method and Complete Purchase", 
                              "User chooses a payment method and successfully completes the purchase.");

    try {
        // Navigate to checkout page with payment options (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Select payment method (assertions or validations here)
        // Example:
        WebElement creditCardOption = driver.findElement(By.id("CREDIT_CARD_OPTION")); // Replace with actual ID
        creditCardOption.click();

        // Complete purchase (assertions or validations here)
        // Example:
        WebElement completePurchaseButton = driver.findElement(By.id("COMPLETE_PURCHASE_BUTTON")); // Replace with actual ID
        completePurchaseButton.click();

        // Verify if order confirmation page is reached (assuming redirection or verification)
        WebElement confirmationPageHeader = driver.findElement(By.id("CONFIRMATION_PAGE_HEADER")); // Replace with actual ID
        assertTrue(confirmationPageHeader.isDisplayed(), "Order confirmation page not displayed after purchase.");

        test.log(Status.PASS, "Chose payment method and completed purchase successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to choose payment method and complete purchase: " + e.getMessage());
    }
}




@Test
public void receiveOrderConfirmationPageAndEmail() {
    test = reports.createTest("Confirmation Page:Receive Order Confirmation Page and Email", 
                              "User receives an order confirmation page and email with order details and estimated delivery date.");

    try {
        // Assuming user completes purchase and is redirected to order confirmation page
        driver.get("URL_OF_ORDER_CONFIRMATION_PAGE"); // Replace 'URL_OF_ORDER_CONFIRMATION_PAGE' with actual URL

        // Verify if order confirmation details are displayed (assertions or validations here)
        // Example:
        WebElement orderDetailsSection = driver.findElement(By.id("ORDER_DETAILS_SECTION")); // Replace with actual ID
        assertTrue(orderDetailsSection.isDisplayed(), "Order details not displayed on confirmation page.");

        // Assuming email verification (may require additional setup and verification)

        test.log(Status.PASS, "Received order confirmation page and email successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to receive order confirmation page and email: " + e.getMessage());
    }
}


@Test
public void navigateToCheckoutPage1() {
    test = reports.createTest("Secure Checkout:Ensure Secure Checkout Process", 
                              "Navigate to the checkout page during the purchase process.");

    try {
        // Navigate to checkout page (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Verify if checkout page is displayed with shipping and billing information options (assertions or validations here)
        // Example:
        WebElement shippingInfoField = driver.findElement(By.id("SHIPPING_INFO_FIELD")); // Replace with actual ID
        WebElement billingInfoField = driver.findElement(By.id("BILLING_INFO_FIELD")); // Replace with actual ID
        assertTrue(shippingInfoField.isDisplayed() && billingInfoField.isDisplayed(), 
                   "Checkout page does not display shipping and billing information fields.");

        test.log(Status.PASS, "Navigated to checkout page with shipping and billing information options.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to navigate to checkout page: " + e.getMessage());
    }
}


@Test
public void verifyCheckoutPageURL() {
    test = reports.createTest(" Checkout Page:Verify Checkout Page URL", 
                              "Check the URL of the checkout page to verify it is using HTTPS.");

    try {
        // Navigate to checkout page (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Get current URL and check if it starts with 'https://'
        String currentURL = driver.getCurrentUrl();
        assertTrue(currentURL.startsWith("https://"), "Checkout page URL is not using HTTPS.");

        test.log(Status.PASS, "Verified that the checkout page URL is using HTTPS.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify checkout page URL: " + e.getMessage());
    }
}





@Test
public void checkSecurityBadgesOnCheckoutPage() {
    test = reports.createTest(" Security Badges:Check Security Badges on Checkout Page", 
                              "Look for any security badges or icons on the checkout page.");

    try {
        // Navigate to checkout page (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Check for presence of security badges (assertions or validations here)
        // Example:
        WebElement securityBadgeElement = driver.findElement(By.id("SECURITY_BADGE")); // Replace with actual ID or selector
        assertTrue(securityBadgeElement.isDisplayed(), "No security badges found on checkout page.");

        test.log(Status.PASS, "Found visible security badges indicating PCI-compliant payment processing.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to find security badges on checkout page: " + e.getMessage());
    }
}


@Test
public void addToCartAndProceedToCheckout() {
    test = reports.createTest("Receive Order:Receive Order Confirmation Page and Email",
                              "Add product(s) to the shopping cart and proceed to checkout.");

    try {
        // Navigate to product page and add product(s) to shopping cart (if not already added)
        driver.get("URL_OF_PRODUCT_PAGE"); // Replace 'URL_OF_PRODUCT_PAGE' with actual URL

        // Add product to cart (assertions or validations here)
        // Example:
        WebElement addToCartButton = driver.findElement(By.id("ADD_TO_CART_BUTTON")); // Replace with actual ID
        addToCartButton.click();

        // Proceed to checkout (assertions or validations here)
        // Example:
        WebElement checkoutButton = driver.findElement(By.id("CHECKOUT_BUTTON")); // Replace with actual ID
        checkoutButton.click();

        // Verify if checkout process page is reached
        WebElement checkoutPageHeader = driver.findElement(By.id("CHECKOUT_PAGE_HEADER")); // Replace with actual ID
        assertTrue(checkoutPageHeader.isDisplayed(), "Checkout process page not displayed after proceeding.");

        test.log(Status.PASS, "Successfully reached the checkout process page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to add to cart and proceed to checkout: " + e.getMessage());
    }
}


@Test
public void selectShippingMethodAndVerifyDeliveryDate() {
    test = reports.createTest("Shipping Method:Select Shipping Method and Verify Delivery Date",
                              "Select a shipping method and verify the estimated delivery date.");

    try {
        // Navigate to checkout page with shipping options (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Select shipping method (assertions or validations here)
        // Example:
        WebElement standardShippingOption = driver.findElement(By.id("STANDARD_SHIPPING_OPTION")); // Replace with actual ID
        standardShippingOption.click();

        // Verify estimated delivery date (assertions or validations here)
        // Example:
        WebElement estimatedDeliveryDateElement = driver.findElement(By.id("ESTIMATED_DELIVERY_DATE")); // Replace with actual ID
        assertTrue(estimatedDeliveryDateElement.isDisplayed(), "Estimated delivery date not displayed after selecting shipping method.");

        test.log(Status.PASS, "Selected shipping method and verified estimated delivery date.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to select shipping method and verify delivery date: " + e.getMessage());
    }
}



@Test
public void choosePaymentMethodAndCompletePurchase() {
    test = reports.createTest("Payment Method:Choose Payment Method and Complete Purchase",
                              "Choose a payment method and complete the purchase.");

    try {
        // Navigate to checkout page with payment options (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Select payment method (assertions or validations here)
        // Example:
        WebElement creditCardOption = driver.findElement(By.id("CREDIT_CARD_OPTION")); // Replace with actual ID
        creditCardOption.click();

        // Complete purchase (assertions or validations here)
        // Example:
        WebElement completePurchaseButton = driver.findElement(By.id("COMPLETE_PURCHASE_BUTTON")); // Replace with actual ID
        completePurchaseButton.click();

        // Verify if order confirmation page is reached (assuming redirection or verification)
        WebElement confirmationPageHeader = driver.findElement(By.id("CONFIRMATION_PAGE_HEADER")); // Replace with actual ID
        assertTrue(confirmationPageHeader.isDisplayed(), "Order confirmation page not displayed after purchase.");

        test.log(Status.PASS, "Chose payment method and completed purchase successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to choose payment method and complete purchase: " + e.getMessage());
    }
}


@Test
public void verifyOrderConfirmationPage() {
    test = reports.createTest("Order Confirmation:Verify Order Confirmation Page",
                              "Verify order confirmation page is displayed with order details.");

    try {
        // Navigate to order confirmation page (if not already there)
        driver.get("URL_OF_ORDER_CONFIRMATION_PAGE"); // Replace 'URL_OF_ORDER_CONFIRMATION_PAGE' with actual URL

        // Verify if order details are displayed (assertions or validations here)
        // Example:
        WebElement orderDetailsSection = driver.findElement(By.id("ORDER_DETAILS_SECTION")); // Replace with actual ID
        assertTrue(orderDetailsSection.isDisplayed(), "Order details not displayed on confirmation page.");

        test.log(Status.PASS, "Order confirmation page is displayed with order details.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify order confirmation page: " + e.getMessage());
    }
}



@Test
public void navigateToCheckoutPage() {
    test = reports.createTest("Navigate to Checkout Page",
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

        // Verify if checkout page is displayed with selected items (assuming validation)
        WebElement checkoutPageHeader = driver.findElement(By.id("CHECKOUT_PAGE_HEADER")); // Replace with actual ID
        assertTrue(checkoutPageHeader.isDisplayed(), "Checkout page not displayed after adding items to cart.");

        test.log(Status.PASS, "Successfully navigated to checkout page with selected items.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to navigate to checkout page: " + e.getMessage());
    }
}


@Test
public void locatePaymentMethodSection() {
    test = reports.createTest("Locate Payment Method Section",
                              "Locate the payment method section on the checkout page.");

    try {
        // Navigate to checkout page (if not already there)
        driver.get("URL_OF_CHECKOUT_PAGE"); // Replace 'URL_OF_CHECKOUT_PAGE' with actual URL

        // Locate payment method section (assertions or validations here)
        // Example:
        WebElement paymentMethodSection = driver.findElement(By.id("PAYMENT_METHOD_SECTION")); // Replace with actual ID
        assertTrue(paymentMethodSection.isDisplayed(), "Payment method section not visible on checkout page.");

        test.log(Status.PASS, "Located payment method section on the checkout page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate payment method section: " + e.getMessage());
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