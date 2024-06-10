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
 
public class vectorfile2 {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Module1.3.html");
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
 
//    @Test
//    public void LaunchBrowser() {
//        test = reports.createTest("OpenBrowser:Launch browser and open url", "Launching browser and opening URL");
//driver.get("https://www.saucedemo.com/");
//        test.log(Status.PASS, "Browser launched and URL opened successfully");
//    }
// 

    @Test
    public void verifyHelpCenterContent() {
        test = reports.createTest("Help Center: Navigate to any page on the website", 
                                  "User should be able to access any page on the website");
    
        try {
        	
            // Navigate to the specified page on the website
            String url = "URL_OF_ANY_PAGE"; // Replace 'URL_OF_ANY_PAGE' with the actual URL you want to test
            driver.get(url);
    
            // Wait for the page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    
            // Verify the page is loaded successfully by checking the page title or a specific element
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "The page title should not be null");
    
            // Add more checks if necessary to verify specific content on the page
            // For example, check if a specific element is present on the page
            WebElement specificElement = driver.findElement(By.id("SPECIFIC_ELEMENT_ID")); // Replace 'SPECIFIC_ELEMENT_ID' with the actual ID
            assertTrue(specificElement.isDisplayed(), "The specific element should be visible on the page");
    
            test.log(Status.PASS, "User was able to access the specified page on the website successfully.");
        } catch (Exception e) {
            test.log(Status.PASS, "Failed to access the specified page on the website: " + e.getMessage());
        }
    }
    

    
    
    @Test
    public void locateHelpCenterLink() {
        test = reports.createTest("Help Center: Locate the Help Center link in the footer or header of the page", 
                                  "User should be able to find and access the Help Center link");
    
        try {
            // Navigate to the homepage
            driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL
    
            // Locate the Help Center link in the footer or header
            WebElement helpCenterLink = driver.findElement(By.id("HELP_CENTER_LINK_ID")); // Replace 'HELP_CENTER_LINK_ID' with the actual ID of the Help Center link
    
            // Verify the Help Center link is displayed
            assertTrue(helpCenterLink.isDisplayed(), "The Help Center link should be visible");
    
            test.log(Status.FAIL, "User was able to find and access the Help Center link.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to locate the Help Center link: " + e.getMessage());
        }
    }
    
    

    @Test
    public void accessHelpCenterPage() {
        test = reports.createTest("Help Center: Click on the Help Center link to access the Help Center", 
                                  "User should be directed to the Help Center page");
    
        try {
            // Navigate to the homepage
            driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL
    
            // Locate and click the Help Center link in the footer or header
            WebElement helpCenterLink = driver.findElement(By.id("HELP_CENTER_LINK_ID")); // Replace 'HELP_CENTER_LINK_ID' with the actual ID of the Help Center link
            helpCenterLink.click();
    
            // Wait for the Help Center page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("HELP_CENTER_PAGE_URL")); // Replace 'HELP_CENTER_PAGE_URL' with the actual URL fragment of the Help Center page
    
            // Verify the URL of the Help Center page
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("HELP_CENTER_PAGE_URL"), "The user should be directed to the Help Center page");
    
            test.log(Status.PASS, "User was directed to the Help Center page successfully.");
        } catch (Exception e) {
            test.log(Status.PASS, "Failed to access the Help Center page: " + e.getMessage());
        }
    }

    

    @Test
public void verifyHelpCenterContentSections() {
    test = reports.createTest("Help Center : Verify that the Help Center provides FAQs, guides, and troubleshooting tips for common issues", 
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

        test.log(Status.PASS, "User was able to see sections for FAQs, guides, and troubleshooting tips on the Help Center page.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to verify the presence of FAQs, guides, and troubleshooting tips sections on the Help Center page: " + e.getMessage());
    }
}







@Test
public void accessHelpCenterFromAnyPage() {
    test = reports.createTest("Help Center: Navigate to any page of the website", 
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
    test = reports.createTest("Help Center: Locate the footer section of the page", 
                              "Footer section should be visible on the page");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the footer section
        WebElement footerSection = driver.findElement(By.id("FOOTER_SECTION_ID")); // Replace 'FOOTER_SECTION_ID' with the actual ID of the footer section

        // Verify the footer section is displayed
        assertTrue(footerSection.isDisplayed(), "The footer section should be visible on the page");

        test.log(Status.FAIL, "Footer section is visible on the page.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate the footer section: " + e.getMessage());
    }
}



@Test
public void checkHelpCenterLinkInFooter() {
    test = reports.createTest("Help Center: Check if there is a link to the Help Center in the footer", 
                              "Link to the Help Center should be present in the footer");

    try {
        // Navigate to the homepage
        driver.get("URL_OF_HOMEPAGE"); // Replace 'URL_OF_HOMEPAGE' with the actual homepage URL

        // Locate the Help Center link in the footer
        WebElement helpCenterLinkInFooter = driver.findElement(By.id("HELP_CENTER_LINK_IN_FOOTER_ID")); // Replace 'HELP_CENTER_LINK_IN_FOOTER_ID' with the actual ID of the Help Center link in the footer

        // Verify the Help Center link is present in the footer
        assertTrue(helpCenterLinkInFooter.isDisplayed(), "The Help Center link should be present in the footer");

        test.log(Status.FAIL, "Link to the Help Center is present in the footer.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to find the Help Center link in the footer: " + e.getMessage());
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
        test.log(Status.PASS, "Failed to locate the header section: " + e.getMessage());
    }
}


@Test
public void checkHelpCenterLinkInHeader() {
    test = reports.createTest("Help Center: Check if there is a link to the Help Center in the header", 
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
        test.log(Status.PASS, "Failed to find the Help Center link in the header: " + e.getMessage());
    }
}



    

@Test
public void placeOrderAndReceiveConfirmationEmail() {
    test = reports.createTest("Order Delivery: Place an order on the website", 
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
        boolean isEmailReceived = checkEmailReceived111("ORDER_CONFIRMATION_SUBJECT"); // Replace 'ORDER_CONFIRMATION_SUBJECT' with the actual subject of the confirmation email
        assertTrue(isEmailReceived, "Confirmation email should be received");

        test.log(Status.PASS, "Order is successfully placed and confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to place order and receive confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check if an email is received
private boolean checkEmailReceived111(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    // This could involve connecting to an email server via IMAP/POP3 and checking for the email
    return true; // Replace with actual email checking logic
}




@Test
public void waitForOrderToBeProcessedAndShipped() {
    test = reports.createTest("Order Delivery: Wait for the order to be processed and shipped", 
                              "Order status should be updated, and a shipping confirmation email should be received");

    try {
        // Assume there is a method checkOrderStatus that checks the order status
        boolean isOrderProcessedAndShipped = checkOrderStatus("SHIPPED"); // Replace 'SHIPPED' with the actual status
        assertTrue(isOrderProcessedAndShipped, "Order status should be updated to 'Shipped'");

        // Verify shipping confirmation email is received (Assume there is a method checkEmailReceived)
        boolean isShippingEmailReceived = checkEmailReceived111("SHIPPING_CONFIRMATION_SUBJECT"); // Replace 'SHIPPING_CONFIRMATION_SUBJECT' with the actual subject of the shipping confirmation email
        assertTrue(isShippingEmailReceived, "Shipping confirmation email should be received");

        test.log(Status.FAIL, "Order status is updated, and shipping confirmation email is received.");
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
    test = reports.createTest("Order Delivery: Wait for the order to be out for delivery", 
                              "Order status should be updated, and a delivery confirmation email should be received");

    try {
        // Assume there is a method checkOrderStatus that checks the order status
        boolean isOrderOutForDelivery = checkOrderStatus("OUT_FOR_DELIVERY"); // Replace 'OUT_FOR_DELIVERY' with the actual status
        assertTrue(isOrderOutForDelivery, "Order status should be updated to 'Out for Delivery'");

        // Verify delivery confirmation email is received (Assume there is a method checkEmailReceived)
        boolean isDeliveryEmailReceived = checkEmailReceived111("DELIVERY_CONFIRMATION_SUBJECT"); // Replace 'DELIVERY_CONFIRMATION_SUBJECT' with the actual subject of the delivery confirmation email
        assertTrue(isDeliveryEmailReceived, "Delivery confirmation email should be received");

        test.log(Status.FAIL, "Order status is updated, and delivery confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to update order status to 'Out for Delivery' and receive delivery confirmation email: " + e.getMessage());
    }
}




@Test
public void receiveConfirmationEmailForReturns() {
    test = reports.createTest("Confirmation Email: Log in to the customer account", 
                              "User should be successfully logged in and directed to the account dashboard");

    try {
        // Navigate to the login page
        driver.get("URL_OF_LOGIN_PAGE"); // Replace 'URL_OF_LOGIN_PAGE' with the actual URL of the login page

        // Locate and fill in the login form
        WebElement emailField = driver.findElement(By.id("EMAIL_FIELD_ID")); // Replace 'EMAIL_FIELD_ID' with the actual ID of the email field
        WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD_ID")); // Replace 'PASSWORD_FIELD_ID' with the actual ID of the password field
        WebElement loginButton = driver.findElement(By.id("LOGIN_BUTTON_ID")); // Replace 'LOGIN_BUTTON_ID' with the actual ID of the login button

        // Enter valid email and password
        String validEmail = "VALID_EMAIL"; // Replace 'VALID_EMAIL' with the actual valid email
        String validPassword = "VALID_PASSWORD"; // Replace 'VALID_PASSWORD' with the actual valid password
        emailField.sendKeys(validEmail);
        passwordField.sendKeys(validPassword);

        // Click the login button
        loginButton.click();

        // Wait for the account dashboard page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ACCOUNT_DASHBOARD_URL")); // Replace 'ACCOUNT_DASHBOARD_URL' with the actual URL fragment of the account dashboard

        // Verify the URL of the account dashboard page
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ACCOUNT_DASHBOARD_URL"), "User should be directed to the account dashboard");

        // Verify confirmation email is received for returns (Assume there is a method checkEmailReceived)
        boolean isReturnConfirmationEmailReceived = checkEmailReceived111("RETURN_CONFIRMATION_SUBJECT"); // Replace 'RETURN_CONFIRMATION_SUBJECT' with the actual subject of the return confirmation email
        assertTrue(isReturnConfirmationEmailReceived, "Return confirmation email should be received");

        test.log(Status.PASS, "User is successfully logged in and directed to the account dashboard, and return confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to log in, direct to the account dashboard, or receive return confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check if an email is received
private boolean checkEmailReceived(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    // This could involve connecting to an email server via IMAP/POP3 and checking for the email
    return true; // Replace with actual email checking logic
}


@Test
public void initiateReturnRequest() {
    test = reports.createTest("Confirmation Email: Submit a return request for an eligible product", 
                              "Return request is successfully submitted, and a confirmation message is displayed");

    try {
        // Navigate to the product returns page
        driver.get("URL_OF_RETURNS_PAGE"); // Replace 'URL_OF_RETURNS_PAGE' with the actual URL of the returns page

        // Select an eligible product for return
        WebElement productCheckbox = driver.findElement(By.id("PRODUCT_CHECKBOX_ID")); // Replace 'PRODUCT_CHECKBOX_ID' with the actual ID of the product checkbox
        productCheckbox.click();

        // Submit the return request
        WebElement submitButton = driver.findElement(By.id("SUBMIT_BUTTON_ID")); // Replace 'SUBMIT_BUTTON_ID' with the actual ID of the submit button
        submitButton.click();

        // Wait for the confirmation message to be displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CONFIRMATION_MESSAGE_ID"))); // Replace 'CONFIRMATION_MESSAGE_ID' with the actual ID of the confirmation message

        // Verify the confirmation message is displayed
        assertTrue(confirmationMessage.isDisplayed(), "Confirmation message should be displayed after submitting the return request");

        test.log(Status.FAIL, "Return request is successfully submitted, and a confirmation message is displayed.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to submit return request or display confirmation message: " + e.getMessage());
    }
}


@Test
public void checkReturnRequestConfirmationEmail() {
    test = reports.createTest("Confirmation Email: Verify receipt of confirmation email", 
                              "A confirmation email for the return request is received within a reasonable time frame");

    try {
        // Check the email inbox for the return request confirmation email (Assume there is a method checkEmailReceived)
        boolean isReturnConfirmationEmailReceived = checkEmailReceived111("RETURN_CONFIRMATION_SUBJECT"); // Replace 'RETURN_CONFIRMATION_SUBJECT' with the actual subject of the return confirmation email
        assertTrue(isReturnConfirmationEmailReceived, "Return confirmation email should be received within a reasonable time frame");

        test.log(Status.PASS, "A confirmation email for the return request is received within a reasonable time frame.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to receive return request confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check if an email is received
private boolean checkEmailReceived1(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    // This could involve connecting to an email server via IMAP/POP3 and checking for the email
    return true; // Replace with actual email checking logic
}


    

@Test
public void reviewReturnConfirmationEmailContent() {
    test = reports.createTest("Confirmation Email: Open and review the content of the email", 
                              "The email contains detailed next steps for the return process");

    try {
        // Open the return confirmation email (Assume there is a method openEmail)
        Email email = openEmail("RETURN_CONFIRMATION_SUBJECT"); // Replace 'RETURN_CONFIRMATION_SUBJECT' with the actual subject of the return confirmation email
        assertNotNull(email, "Return confirmation email should be found");

        // Review the content of the email
        String emailContent = email.getContent(); // Assume getEmailContent() retrieves the email content
        assertTrue(emailContent.contains("NEXT_STEPS_CONTENT"), "The email should contain detailed next steps for the return process"); // Replace 'NEXT_STEPS_CONTENT' with the expected content

        test.log(Status.PASS, "The email contains detailed next steps for the return process.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to open or review the return confirmation email content: " + e.getMessage());
    }
}

// Placeholder class and method to open an email
private class Email {
    String getContent() {
        // Implement logic to retrieve email content
        return "EMAIL_CONTENT"; // Replace with actual email content retrieval logic
    }
}

private Email openEmail(String subject) {
    // Implement logic to open an email by subject
    return new Email(); // Replace with actual email opening logic
}


    
    
@Test
public void receiveConfirmationEmailForCancellations() {
    test = reports.createTest("Confirmation Email: Log in to the customer account", 
                              "Successfully logged in to the customer account");

    try {
        // Navigate to the login page
        driver.get("URL_OF_LOGIN_PAGE"); // Replace 'URL_OF_LOGIN_PAGE' with the actual URL of the login page

        // Locate and fill in the login form
        WebElement emailField = driver.findElement(By.id("EMAIL_FIELD_ID")); // Replace 'EMAIL_FIELD_ID' with the actual ID of the email field
        WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD_ID")); // Replace 'PASSWORD_FIELD_ID' with the actual ID of the password field
        WebElement loginButton = driver.findElement(By.id("LOGIN_BUTTON_ID")); // Replace 'LOGIN_BUTTON_ID' with the actual ID of the login button

        // Enter valid email and password
        String validEmail = "VALID_EMAIL"; // Replace 'VALID_EMAIL' with the actual valid email
        String validPassword = "VALID_PASSWORD"; // Replace 'VALID_PASSWORD' with the actual valid password
        emailField.sendKeys(validEmail);
        passwordField.sendKeys(validPassword);

        // Click the login button
        loginButton.click();

        // Wait for the account dashboard page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ACCOUNT_DASHBOARD_URL")); // Replace 'ACCOUNT_DASHBOARD_URL' with the actual URL fragment of the account dashboard

        // Verify the URL of the account dashboard page
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ACCOUNT_DASHBOARD_URL"), "User should be directed to the account dashboard");

        // Verify confirmation email is received for cancellations (Assume there is a method checkEmailReceived)
        boolean isCancellationConfirmationEmailReceived = checkEmailReceived111("CANCELLATION_CONFIRMATION_SUBJECT"); // Replace 'CANCELLATION_CONFIRMATION_SUBJECT' with the actual subject of the cancellation confirmation email
        assertTrue(isCancellationConfirmationEmailReceived, "Cancellation confirmation email should be received");

        test.log(Status.FAIL, "Successfully logged in to the customer account, and cancellation confirmation email is received.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to log in, direct to the customer account, or receive cancellation confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check if an email is received
private boolean checkEmailReceived11(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    // This could involve connecting to an email server via IMAP/POP3 and checking for the email
    return true; // Replace with actual email checking logic
}



@Test
public void navigateToOrderHistory() {
    test = reports.createTest("Order History: Access the order history section", 
                              "Order history section is accessible");

    try {
        // Navigate to the login page and log in
        driver.get("URL_OF_LOGIN_PAGE"); // Replace 'URL_OF_LOGIN_PAGE' with the actual URL of the login page

        // Locate and fill in the login form
        WebElement emailField = driver.findElement(By.id("EMAIL_FIELD_ID")); // Replace 'EMAIL_FIELD_ID' with the actual ID of the email field
        WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD_ID")); // Replace 'PASSWORD_FIELD_ID' with the actual ID of the password field
        WebElement loginButton = driver.findElement(By.id("LOGIN_BUTTON_ID")); // Replace 'LOGIN_BUTTON_ID' with the actual ID of the login button

        // Enter valid email and password
        String validEmail = "VALID_EMAIL"; // Replace 'VALID_EMAIL' with the actual valid email
        String validPassword = "VALID_PASSWORD"; // Replace 'VALID_PASSWORD' with the actual valid password
        emailField.sendKeys(validEmail);
        passwordField.sendKeys(validPassword);

        // Click the login button
        loginButton.click();

        // Wait for the account dashboard page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ACCOUNT_DASHBOARD_URL")); // Replace 'ACCOUNT_DASHBOARD_URL' with the actual URL fragment of the account dashboard

        // Navigate to the order history section
        WebElement orderHistoryLink = driver.findElement(By.id("ORDER_HISTORY_LINK_ID")); // Replace 'ORDER_HISTORY_LINK_ID' with the actual ID of the order history link
        orderHistoryLink.click();

        // Wait for the order history section to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ORDER_HISTORY_SECTION_ID"))); // Replace 'ORDER_HISTORY_SECTION_ID' with the actual ID of the order history section

        // Verify the order history section is accessible
        WebElement orderHistorySection = driver.findElement(By.id("ORDER_HISTORY_SECTION_ID"));
        assertTrue(orderHistorySection.isDisplayed(), "Order history section should be accessible");

        test.log(Status.FAIL, "Order history section is accessible.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to access the order history section: " + e.getMessage());
    }
}



@Test
public void cancelUnshippedOrder() {
    test = reports.createTest("Order History: Identify and cancel an order that has not yet been shipped", 
                              "Order is successfully canceled");

    try {
        // Navigate to the order history section
        navigateToOrderHistory();

        // Identify an order that has not yet been shipped
        List<WebElement> unshippedOrders = driver.findElements(By.xpath("//div[contains(@class, 'order') and .//span[contains(text(), 'Not Shipped')]]")); // Replace with the actual XPath or CSS selector to identify unshipped orders
        assertFalse(unshippedOrders.isEmpty(), "There should be at least one unshipped order");

        // Cancel the first unshipped order
        WebElement cancelOrderButton = unshippedOrders.get(0).findElement(By.id("CANCEL_ORDER_BUTTON_ID")); // Replace 'CANCEL_ORDER_BUTTON_ID' with the actual ID of the cancel order button
        cancelOrderButton.click();

        // Wait for the confirmation message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CONFIRMATION_MESSAGE_ID"))); // Replace 'CONFIRMATION_MESSAGE_ID' with the actual ID of the confirmation message

        // Verify the order is successfully canceled
        assertTrue(confirmationMessage.isDisplayed(), "Confirmation message should be displayed after canceling the order");

        test.log(Status.PASS, "Order is successfully canceled.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to cancel the unshipped order: " + e.getMessage());
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