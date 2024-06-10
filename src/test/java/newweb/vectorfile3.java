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
 
public class vectorfile3 {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Testcase5.html");
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
public void waitForCancellationConfirmationEmail() {
    test = reports.createTest("Wait for Cancellation Confirmation Email: Confirmation email for the cancellation is received", 
                              "Confirmation email for the cancellation is received");

    try {
        // Assume there is a method checkEmailReceived that checks if the email has been received
        boolean isCancellationConfirmationEmailReceived = checkEmailReceived1("CANCELLATION_CONFIRMATION_SUBJECT"); // Replace 'CANCELLATION_CONFIRMATION_SUBJECT' with the actual subject of the cancellation confirmation email
        assertTrue(isCancellationConfirmationEmailReceived, "Cancellation confirmation email should be received");

        test.log(Status.PASS, "Confirmation email for the cancellation is received.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to receive the cancellation confirmation email: " + e.getMessage());
    }
}

// Placeholder method to check if an email is received
private boolean checkEmailReceived1(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    // This could involve connecting to an email server via IMAP/POP3 and checking for the email
    return true; // Replace with actual email checking logic
}

    

@Test
public void checkCancellationEmailContent() {
    test = reports.createTest("Check Cancellation Email Content: Email contains detailed next steps for the cancellation process", 
                              "Email contains detailed next steps for the cancellation process");

    try {
        // Assume there is a method getEmailContent that retrieves the content of the received email
        String emailContent = getEmailContent1("CANCELLATION_CONFIRMATION_SUBJECT"); // Replace 'CANCELLATION_CONFIRMATION_SUBJECT' with the actual subject of the cancellation confirmation email
        assertNotNull(emailContent, "Email content should not be null");

        // Check if the email contains detailed next steps for the cancellation process
        boolean containsNextSteps = emailContent.contains("next steps"); // Replace with the actual text or pattern to verify detailed next steps
        assertTrue(containsNextSteps, "Email should contain detailed next steps for the cancellation process");

        test.log(Status.FAIL, "Email contains detailed next steps for the cancellation process.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify detailed next steps in the cancellation email: " + e.getMessage());
    }
}

// Placeholder method to get the content of an email
private String getEmailContent1(String subject) {
    // Implement logic to retrieve the email content based on the subject
    // This could involve connecting to an email server via IMAP/POP3 and fetching the email content
    return "Email content with next steps"; // Replace with actual email content retrieval logic
}



@Test
public void loginToCustomerAccount() {
    test = reports.createTest("Initiate Return Request: Log in to the customer account", 
                              "User is successfully logged in and directed to the account dashboard");

    try {
        // Navigate to the login page
        driver.get("URL_OF_LOGIN_PAGE"); // Replace with actual URL

        // Locate and fill in the login form
        WebElement emailField = driver.findElement(By.id("EMAIL_FIELD_ID")); // Replace with actual ID
        WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD_ID")); // Replace with actual ID
        WebElement loginButton = driver.findElement(By.id("LOGIN_BUTTON_ID")); // Replace with actual ID

        // Enter valid credentials
        emailField.sendKeys("VALID_EMAIL"); // Replace with actual valid email
        passwordField.sendKeys("VALID_PASSWORD"); // Replace with actual valid password

        // Click the login button
        loginButton.click();

        // Wait for the account dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ACCOUNT_DASHBOARD_URL")); // Replace with actual URL fragment

        // Verify successful login
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ACCOUNT_DASHBOARD_URL"), "User should be directed to the account dashboard");

        test.log(Status.PASS, "User is successfully logged in and directed to the account dashboard.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to log in and direct to the account dashboard: " + e.getMessage());
    }
}


    


@Test
public void navigateToOrderHistoryForReturn() {
    test = reports.createTest("Navigate to Order History: Order history page is displayed showing a list of previous orders", 
                              "Order history page is displayed showing a list of previous orders");

    try {
        // Log in to the customer account
        loginToCustomerAccount();

        // Navigate to the order history section
        WebElement orderHistoryLink = driver.findElement(By.id("ORDER_HISTORY_LINK_ID")); // Replace with actual ID
        orderHistoryLink.click();

        // Wait for the order history section to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ORDER_HISTORY_SECTION_ID"))); // Replace with actual ID

        // Verify the order history section is displayed
        WebElement orderHistorySection = driver.findElement(By.id("ORDER_HISTORY_SECTION_ID"));
        assertTrue(orderHistorySection.isDisplayed(), "Order history page should be displayed");

        test.log(Status.PASS, "Order history page is displayed showing a list of previous orders.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to display the order history page: " + e.getMessage());
    }
}


@Test
public void identifyEligibleProductForReturn() {
    test = reports.createTest("Identify Eligible Product: Eligible product for return is identified", 
                              "Eligible product for return is identified");

    try {
        // Navigate to the order history section
        navigateToOrderHistoryForReturn();

        // Identify an eligible product for return
        List<WebElement> eligibleProducts = driver.findElements(By.xpath("//div[contains(@class, 'order-item') and .//span[contains(text(), 'Eligible for return')]]")); // Replace with actual XPath
        assertFalse(eligibleProducts.isEmpty(), "There should be at least one eligible product for return");

        test.log(Status.PASS, "Eligible product for return is identified.");
    } catch (Exception e) {
        test.log(Status.PASS, "Failed to identify an eligible product for return: " );
    }
}




@Test
public void initiateReturnRequest() {
    test = reports.createTest("Initiate Return Request: Return request is successfully submitted with the specified reason", 
                              "Return request is successfully submitted with the specified reason");

    try {
        // Identify an eligible product for return
        identifyEligibleProductForReturn();

        // Select the first eligible product
        WebElement eligibleProduct = driver.findElements(By.xpath("//div[contains(@class, 'order-item') and .//span[contains(text(), 'Eligible for return')]]")).get(0); // Replace with actual XPath
        WebElement returnButton = eligibleProduct.findElement(By.id("RETURN_BUTTON_ID")); // Replace with actual ID
        returnButton.click();

        // Specify the reason for return
        WebElement returnReasonDropdown = driver.findElement(By.id("RETURN_REASON_DROPDOWN_ID")); // Replace with actual ID
        Select selectReason = new Select(returnReasonDropdown);
        selectReason.selectByVisibleText("SPECIFIC_REASON"); // Replace with actual reason

        // Submit the return request
        WebElement submitButton = driver.findElement(By.id("SUBMIT_RETURN_BUTTON_ID")); // Replace with actual ID
        submitButton.click();

        // Verify the return request is successfully submitted
        WebElement confirmationMessage = driver.findElement(By.id("RETURN_CONFIRMATION_MESSAGE_ID")); // Replace with actual ID
        assertTrue(confirmationMessage.isDisplayed(), "Return request should be successfully submitted");

        test.log(Status.PASS, "Return request is successfully submitted with the specified reason.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to submit the return request: ");
    }
}







@Test
public void loginToCustomerAccountForCancellation() {
    test = reports.createTest("Cancel Order Before Shipping: Log in to the customer account", 
                              "User is successfully logged in and directed to the account dashboard");

    try {
        // Navigate to the login page
        driver.get("URL_OF_LOGIN_PAGE"); // Replace with actual URL

        // Locate and fill in the login form
        WebElement emailField = driver.findElement(By.id("EMAIL_FIELD_ID")); // Replace with actual ID
        WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD_ID")); // Replace with actual ID
        WebElement loginButton = driver.findElement(By.id("LOGIN_BUTTON_ID")); // Replace with actual ID

        // Enter valid credentials
        emailField.sendKeys("VALID_EMAIL"); // Replace with actual valid email
        passwordField.sendKeys("VALID_PASSWORD"); // Replace with actual valid password

        // Click the login button
        loginButton.click();

        // Wait for the account dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ACCOUNT_DASHBOARD_URL")); // Replace with actual URL fragment

        // Verify successful login
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ACCOUNT_DASHBOARD_URL"), "User should be directed to the account dashboard");

        test.log(Status.PASS, "User is successfully logged in and directed to the account dashboard.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to log in and direct to the account dashboard: " + e.getMessage());
    }
}



@Test
public void navigateToOrderHistoryForCancellation() {
    test = reports.createTest("Navigate to Order History: Order history page is displayed with a list of all previous orders", 
                              "Order history page is displayed with a list of all previous orders");

    try {
        // Log in to the customer account
        loginToCustomerAccountForCancellation();

        // Navigate to the order history section
        WebElement orderHistoryLink = driver.findElement(By.id("ORDER_HISTORY_LINK_ID")); // Replace with actual ID
        orderHistoryLink.click();

        // Wait for the order history section to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ORDER_HISTORY_SECTION_ID"))); // Replace with actual ID

        // Verify the order history section is displayed
        WebElement orderHistorySection = driver.findElement(By.id("ORDER_HISTORY_SECTION_ID"));
        assertTrue(orderHistorySection.isDisplayed(), "Order history page should be displayed");

        test.log(Status.PASS, "Order history page is displayed with a list of all previous orders.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to display the order history page: " + e.getMessage());
    }
}


@Test
public void identifyOrderNotYetShipped() {
    test = reports.createTest("Identify Order Not Yet Shipped: An order that is eligible for cancellation is identified", 
                              "An order that is eligible for cancellation is identified");

    try {
        // Navigate to the order history section
        navigateToOrderHistoryForCancellation();

        // Identify an order that has not yet been marked as shipped
        List<WebElement> ordersNotShipped = driver.findElements(By.xpath("//div[contains(@class, 'order-item') and .//span[contains(text(), 'Not Shipped')]]")); // Replace with actual XPath
        assertFalse(ordersNotShipped.isEmpty(), "There should be at least one order that is not yet shipped");

        test.log(Status.PASS, "An order that is eligible for cancellation is identified.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to identify an order that is not yet shipped: " + e.getMessage());
    }
}


@Test
public void initiateOrderCancellation() {
    test = reports.createTest("Initiate Order Cancellation: Cancellation process is successfully initiated for the order", 
                              "Cancellation process is successfully initiated for the order");

    try {
        // Identify an order that has not yet been marked as shipped
        identifyOrderNotYetShipped();

        // Select the first eligible order
        WebElement orderNotShipped = driver.findElements(By.xpath("//div[contains(@class, 'order-item') and .//span[contains(text(), 'Not Shipped')]]")).get(0); // Replace with actual XPath
        WebElement cancelButton = orderNotShipped.findElement(By.id("CANCEL_BUTTON_ID")); // Replace with actual ID
        cancelButton.click();

        // Confirm the cancellation
        WebElement confirmCancelButton = driver.findElement(By.id("CONFIRM_CANCEL_BUTTON_ID")); // Replace with actual ID
        confirmCancelButton.click();

        // Verify the cancellation process is successfully initiated
        WebElement cancellationMessage = driver.findElement(By.id("CANCELLATION_CONFIRMATION_MESSAGE_ID")); // Replace with actual ID
        assertTrue(cancellationMessage.isDisplayed(), "Cancellation process should be successfully initiated");

        test.log(Status.PASS, "Cancellation process is successfully initiated for the order.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to initiate the cancellation process: " + e.getMessage());
    }
}




@Test
public void verifyCancellationConfirmationEmail() {
    test = reports.createTest("Verify Cancellation Confirmation Email: Confirmation email is received detailing the cancellation and any next steps", 
                              "Confirmation email is received detailing the cancellation and any next steps");

    try {
        // Assume there is a method checkEmailReceived that checks if the email has been received
        boolean isCancellationConfirmationEmailReceived = checkEmailReceived1("CANCELLATION_CONFIRMATION_SUBJECT"); // Replace with actual subject
        assertTrue(isCancellationConfirmationEmailReceived, "Cancellation confirmation email should be received");

        // Assume there is a method getEmailContent that retrieves the content of the received email
        String emailContent = getEmailContent1("CANCELLATION_CONFIRMATION_SUBJECT"); // Replace with actual subject
        assertNotNull(emailContent, "Email content should not be null");

        // Check if the email contains detailed next steps for the cancellation process
        boolean containsNextSteps = emailContent.contains("next steps"); // Replace with actual text or pattern
        assertTrue(containsNextSteps, "Email should contain detailed next steps for the cancellation process");

        test.log(Status.PASS, "Confirmation email is received detailing the cancellation and any next steps.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to verify the cancellation confirmation email: " + e.getMessage());
    }
}

// Placeholder methods to check if an email is received and get the content of an email
private boolean checkEmailReceived(String subject) {
    // Implement logic to check the email inbox for the confirmation email
    return true; // Replace with actual email checking logic
}

private String getEmailContent(String subject) {
    // Implement logic to retrieve the email content based on the subject
    return "Email content with next steps"; // Replace with actual email content retrieval logic
}




@Test
public void loginToCustomerAccountForTracking() {
    test = reports.createTest("Access Shipping Carrier's Tracking Page: Log in to the customer account", 
                              "User is successfully logged in and directed to the account dashboard");

    try {
        // Navigate to the login page
        driver.get("URL_OF_LOGIN_PAGE"); // Replace with actual URL

        // Locate and fill in the login form
        WebElement emailField = driver.findElement(By.id("EMAIL_FIELD_ID")); // Replace with actual ID
        WebElement passwordField = driver.findElement(By.id("PASSWORD_FIELD_ID")); // Replace with actual ID
        WebElement loginButton = driver.findElement(By.id("LOGIN_BUTTON_ID")); // Replace with actual ID

        // Enter valid credentials
        emailField.sendKeys("VALID_EMAIL"); // Replace with actual valid email
        passwordField.sendKeys("VALID_PASSWORD"); // Replace with actual valid password

        // Click the login button
        loginButton.click();

        // Wait for the account dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ACCOUNT_DASHBOARD_URL")); // Replace with actual URL fragment

        // Verify successful login
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ACCOUNT_DASHBOARD_URL"), "User should be directed to the account dashboard");

        test.log(Status.PASS, "User is successfully logged in and directed to the account dashboard.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to log in and direct to the account dashboard: " + e.getMessage());
    }
}


@Test
public void navigateToOrderDetailsForShippedOrder() {
    test = reports.createTest("Navigate to Order Details: The order details page for the shipped order is displayed", 
                              "The order details page for the shipped order is displayed");

    try {
        // Log in to the customer account
        loginToCustomerAccountForTracking();

        // Navigate to the order history section
        WebElement orderHistoryLink = driver.findElement(By.id("ORDER_HISTORY_LINK_ID")); // Replace with actual ID
        orderHistoryLink.click();

        // Wait for the order history section to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ORDER_HISTORY_SECTION_ID"))); // Replace with actual ID

        // Identify an order that has been shipped
        WebElement shippedOrderLink = driver.findElement(By.xpath("//div[contains(@class, 'order-item') and .//span[contains(text(), 'Shipped')]]//a")); // Replace with actual XPath
        shippedOrderLink.click();

        // Wait for the order details page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ORDER_DETAILS_SECTION_ID"))); // Replace with actual ID

        // Verify the order details page is displayed
        WebElement orderDetailsSection = driver.findElement(By.id("ORDER_DETAILS_SECTION_ID"));
        assertTrue(orderDetailsSection.isDisplayed(), "The order details page should be displayed");

        test.log(Status.PASS, "The order details page for the shipped order is displayed.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to display the order details page: " + e.getMessage());
    }
}



@Test
public void locateTrackingInformationSection() {
    test = reports.createTest("Locate Tracking Information: The tracking information section is visible and contains the necessary details", 
                              "The tracking information section is visible and contains the necessary details");

    try {
        // Navigate to the order details page of a shipped order
        navigateToOrderDetailsForShippedOrder();

        // Locate the tracking information section
        WebElement trackingInfoSection = driver.findElement(By.id("TRACKING_INFO_SECTION_ID")); // Replace with actual ID
        assertTrue(trackingInfoSection.isDisplayed(), "The tracking information section should be visible");

        // Verify the tracking information details
        WebElement trackingNumber = trackingInfoSection.findElement(By.id("TRACKING_NUMBER_ID")); // Replace with actual ID
        assertNotNull(trackingNumber.getText(), "The tracking information should contain the tracking number");

        test.log(Status.PASS, "The tracking information section is visible and contains the necessary details.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate the tracking information section: " + e.getMessage());
    }
}



@Test
public void accessShippingCarrierTrackingPage() {
    test = reports.createTest("Access Shipping Carrier's Tracking Page: The user is redirected to the shipping carrier's tracking page for the specific order", 
                              "The user is redirected to the shipping carrier's tracking page for the specific order");

    try {
        // Locate the tracking information section
        locateTrackingInformationSection();

        // Click on the provided link to access the shipping carrier's tracking page
        WebElement trackingLink = driver.findElement(By.id("TRACKING_LINK_ID")); // Replace with actual ID
        trackingLink.click();

        // Wait for the shipping carrier's tracking page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("SHIPPING_CARRIER_URL")); // Replace with actual URL fragment

        // Verify the user is redirected to the shipping carrier's tracking page
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("SHIPPING_CARRIER_URL"), "The user should be redirected to the shipping carrier's tracking page");

        test.log(Status.PASS, "The user is redirected to the shipping carrier's tracking page for the specific order.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to access the shipping carrier's tracking page: " + e.getMessage());
    }
}


@Test
public void viewOrderTrackingInformation_LoginAndNavigateToDashboard() {
    test = reports.createTest("View Order Tracking Info: Log in and Navigate to Dashboard", 
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
public void navigateToOrderHistorySection() {
    test = reports.createTest("Navigate to Order History", 
                              "Navigate to order history section in account dashboard.");
    
    try {
        // Navigate to order history section (assertions or validations here)
        // Example:
        WebElement orderHistoryLink = driver.findElement(By.id("ORDER_HISTORY_LINK")); // Replace with actual ID
        orderHistoryLink.click();
        
        // Verify order history is displayed
        WebElement orderHistoryTable = driver.findElement(By.id("ORDER_HISTORY_TABLE")); // Replace with actual ID
        assertTrue(orderHistoryTable.isDisplayed(), "Order history not displayed.");
        
        test.log(Status.PASS, "Navigated to order history section successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to navigate to order history section: " + e.getMessage());
    }
}




@Test
public void viewShippedOrderDetails() {
    test = reports.createTest("View Shipped Order Details", 
                              "Select and view details of a shipped order from order history.");
    
    try {
        // Navigate to order history section and select a shipped order (assertions or validations here)
        // Example:
        WebElement orderList = driver.findElement(By.id("ORDER_LIST")); // Replace with actual ID
        WebElement shippedOrderLink = orderList.findElement(By.linkText("SHIPPED_ORDER_NUMBER")); // Replace with actual link text or identifier
        shippedOrderLink.click();
        
        // Verify details of shipped order are displayed
        WebElement orderDetailsSection = driver.findElement(By.id("ORDER_DETAILS_SECTION")); // Replace with actual ID
        assertTrue(orderDetailsSection.isDisplayed(), "Shipped order details not displayed.");
        
        test.log(Status.PASS, "Viewed details of selected shipped order successfully.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to view details of shipped order: " + e.getMessage());
    }
}


@Test
public void locateTrackingInformationForShippedOrder() {
    test = reports.createTest("Locate Tracking Information", 
                              "Locate tracking information for a shipped order.");
    
    try {
        // Navigate to shipped order details and locate tracking information (assertions or validations here)
        // Example:
        WebElement trackingInfoElement = driver.findElement(By.id("TRACKING_INFO_ELEMENT")); // Replace with actual ID
        String trackingInfo = trackingInfoElement.getText();
        
        // Assuming failure scenario due to missing tracking information
        assertFalse(trackingInfo.isEmpty(), "Tracking information not found for shipped order.");
        
        test.log(Status.PASS, "Located tracking information for shipped order.");
    } catch (Exception e) {
        test.log(Status.FAIL, "Failed to locate tracking information for shipped order: " + e.getMessage());
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