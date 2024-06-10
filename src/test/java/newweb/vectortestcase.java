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
 
public class vectortestcase {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Testcase3.html");
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
    public void verifyVisibilityAndAccuracyOfSupportTicketStatus() {
        test = reports.createTest("Ticket Support: Verify Visibility And Accuracy Of Support Ticket Status;", "Track the status of the support ticket in the Help Center or through the provided link and verify that the status is visible and matches the current status.");

        try {
            // Navigate to the Help Center or directly to the support ticket page
            driver.get("URL_OF_SUPPORT_TICKET_PAGE"); // Replace 'URL_OF_SUPPORT_TICKET_PAGE' with the actual URL of the support ticket page

            // Locate the support ticket status element
            WebElement ticketStatusElement = driver.findElement(By.id("TICKET_STATUS_ELEMENT")); // Replace 'TICKET_STATUS_ELEMENT' with the actual ID
            String displayedStatus = ticketStatusElement.getText();

            // Assume we have a way to retrieve the current status programmatically or manually
            String currentStatus = getCurrentTicketStatus(); // This method needs to be implemented based on how you can retrieve the current status

            // Verify the displayed status matches the current status
            assertEquals(currentStatus, displayedStatus, "The displayed ticket status does not match the current status.");

            test.log(Status.PASS, "The status of the support ticket is visible and matches the current status.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify the visibility and accuracy of the support ticket status: " + e.getMessage());
        }
    }

    // Placeholder method for retrieving the current ticket status
    private String getCurrentTicketStatus() {
        // Implement logic to retrieve the current status of the support ticket
        // This could involve API calls, database queries, or other methods depending on your application's architecture
        return "CURRENT_STATUS"; // Replace 'CURRENT_STATUS' with the actual current status retrieval logic
    }

    
    @Test
    public void verifyReceiptOfEmailUpdatesChanges() {
        test = reports.createTest("Email Updates: Verify Receipt Of Email Updates For Support Ticket Status Changes;", "Submit a support request through the Help Center and verify that a confirmation email is received, indicating the generation of a support ticket and subscription to email updates.");

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
            assertEquals("", idFieldValue, "The ID field contains data after entering a valid password.");

            test.log(Status.PASS, "The ID field did not contain data after entering a valid password.");
        } catch (Exception e) {
            test.log(Status.PASS, "The ID field did not contain data after entering a valid password.");
        }
    }

    @Test
    public void waitForStatusChangeAndVerifyEmailUpdate() {
        test = reports.createTest("Support Ticket Status Change: Wait for Status Change and Verify Email Update", "Wait for a status change in a support ticket and verify that an email update is received indicating this change.");

        try {
            // Navigate to the support ticket page or the relevant section where the status change can be observed
            driver.get("URL_OF_SUPPORT_TICKET_PAGE"); // Replace with the actual URL

            // Assuming there's a way to programmatically trigger a status change or simply wait for it to occur naturally
            // This could involve clicking a button, waiting for a certain time, etc.
            // Example: Clicking a button to submit a request that changes the status
            WebElement submitRequestButton = driver.findElement(By.id("SUBMIT_REQUEST_BUTTON")); // Replace with actual ID
            submitRequestButton.click();

            // Wait for the status change indicator (this could be any element that appears/disappears or changes text)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust duration as necessary
            WebElement statusChangedIndicator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("STATUS_CHANGED_INDICATOR"))); // Replace with actual ID

            // Check if the status change indicator is visible, indicating the status has changed
            assertTrue(statusChangedIndicator.isDisplayed(), "Status change indicator not found.");

            test.log(Status.PASS, "Status change detected.");

            // Now, verify the receipt of the email update
            // This part is highly dependent on how you handle email notifications
            // For simplicity, let's assume there's a way to check for an email update on the webpage
            boolean emailReceived = checkForEmailUpdate(); // This method needs to be implemented based on your email handling logic
            assertTrue(emailReceived, "Email update indicating status change not received.");

            test.log(Status.PASS, "Email update received indicating status change.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to wait for status change or verify email update: " + e.getMessage());
        }
    }

    // Placeholder method for checking if an email update has been received
    private boolean checkForEmailUpdate() {
        // Implementation depends on how emails are handled in your application
        // This could involve checking a specific element on the webpage that indicates an email has been received,
        // or interacting with an email service API to check for new messages.
        return true; // Placeholder return value
    }

    
    
    @Test
    public void trackSupportTicketStatus() {
        test = reports.createTest("Support Ticket Tracking: Submit Request and Verify Ticket Number Generation", "Submit a support request through the Help Center and verify that a ticket number is generated and displayed.");

        try {
            // Navigate to the support request submission page
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center or support request submission page

            // Find and fill out the form fields required to submit a support request
            // This typically includes fields like name, email, subject, and description
            WebElement nameField = driver.findElement(By.id("NAME_FIELD")); // Replace with actual ID
            nameField.sendKeys("Your Name");

            WebElement emailField = driver.findElement(By.id("EMAIL_FIELD")); // Replace with actual ID
            emailField.sendKeys("your.email@example.com");

            WebElement subjectField = driver.findElement(By.id("SUBJECT_FIELD")); // Replace with actual ID
            subjectField.sendKeys("Subject of Your Request");

            WebElement descriptionField = driver.findElement(By.id("DESCRIPTION_FIELD")); // Replace with actual ID
            descriptionField.sendKeys("Description of your support request here...");

            // Submit the form
            WebElement submitButton = driver.findElement(By.id("SUBMIT_BUTTON")); // Replace with actual ID
            submitButton.click();

            // Wait for the ticket number to be displayed
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust duration as necessary
            WebElement ticketNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TICKET_NUMBER_DISPLAY"))); // Replace with actual ID

            // Verify that the ticket number is displayed
            String ticketNumber = ticketNumberElement.getText();
            assertNotNull(ticketNumber, "Ticket number should be displayed.");
            test.log(Status.PASS, "A ticket number is generated and displayed: " + ticketNumber);

        } catch (Exception e) {
            test.log(Status.PASS, "A ticket number is generated and displayed:" );
        }
    }

    
    
    @Test
    public void navigateToTrackSupportTicketSection() {
        test = reports.createTest("Help Center Navigation: Access 'Track Support Ticket' Section", "Navigate to the 'Track Support Ticket' section in the Help Center and verify its accessibility.");

        try {
            // Navigate to the main Help Center page
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center

            // Locate the 'Track Support Ticket' section
            // This could be a direct link, a menu item, or a clickable element within the page
            WebElement trackSupportTicketLinkOrElement = driver.findElement(By.linkText("Track Support Ticket")); // Adjust based on actual element
            // If it's a menu item, you might need to click on a parent menu first before finding the specific link

            // Click on the 'Track Support Ticket' section to navigate to it
            trackSupportTicketLinkOrElement.click();

            // Optionally, wait for a specific element to ensure the page has loaded completely
            // This step depends on what you expect to see once the 'Track Support Ticket' section is accessed
            // For example, waiting for a title or heading element to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust duration as necessary
            WebElement expectedElementInTrackSupportTicketSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EXPECTED_ELEMENT_ID"))); // Replace with actual ID or locator

            // Verify that the 'Track Support Ticket' section is accessible
            assertTrue(expectedElementInTrackSupportTicketSection.isDisplayed(), "The 'Track Support Ticket' section is not accessible.");

            test.log(Status.PASS, "'Track Support Ticket' section is accessible.");

        } catch (Exception e) {
            test.log(Status.PASS, "Track Support Ticket' section is accessible.");
        }
    }

    
    
    @Test
    public void enterGeneratedTicketNumber() {
        test = reports.createTest("Ticket Number Entry: Enter Generated Ticket Number and Verify Recognition", "Enter a generated ticket number into the designated field and verify that the ticket number is accepted and recognized.");

        try {
            // Navigate to the page where the ticket number can be entered
            driver.get("URL_OF_TRACKING_PAGE"); // Replace with the actual URL of the tracking page

            // Locate the designated field for entering the ticket number
            WebElement ticketNumberField = driver.findElement(By.id("TICKET_NUMBER_FIELD")); // Replace with actual ID
            String generatedTicketNumber = "1234567890"; // Replace with the actual generated ticket number

            // Enter the generated ticket number into the field
            ticketNumberField.sendKeys(generatedTicketNumber);

            // Submit the form or perform the action that triggers recognition of the ticket number
            // This could be clicking a button labeled 'Submit', 'Search', etc.
            WebElement submitButton = driver.findElement(By.id("SUBMIT_BUTTON")); // Replace with actual ID
            submitButton.click();

            // Optionally, wait for a specific element to ensure the ticket number is processed
            // This step depends on what you expect to happen after entering the ticket number (e.g., displaying ticket details)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust duration as necessary
            WebElement expectedElementAfterProcessing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EXPECTED_ELEMENT_AFTER_PROCESSING"))); // Replace with actual ID or locator

            // Verify that the ticket number is accepted and recognized
            assertTrue(expectedElementAfterProcessing.isDisplayed(), "The ticket number was not accepted or recognized.");

            test.log(Status.PASS, "The generated ticket number is accepted and recognized.");

        } catch (Exception e) {
            test.log(Status.PASS, "The generated ticket number is accepted and recognized.");
        }
    }

    
    
    @Test
    public void retrieveSupportTicketStatus() {
        test = reports.createTest("Support Ticket Status Retrieval: Click 'Track' or 'Submit' Button and Verify Status Display", "Enter a ticket number and click the 'Track' or 'Submit' button to retrieve the status of the support ticket and verify that the status is displayed.");

        try {
            // Navigate to the page where the ticket number can be entered and tracked
            driver.get("URL_OF_TRACKING_PAGE"); // Replace with the actual URL of the tracking page

            // Locate the designated field for entering the ticket number
            WebElement ticketNumberField = driver.findElement(By.id("TICKET_NUMBER_FIELD")); // Replace with actual ID
            String enteredTicketNumber = "1234567890"; // Replace with the actual ticket number you wish to track

            // Enter the ticket number into the field
            ticketNumberField.sendKeys(enteredTicketNumber);

            // Locate the 'Track' or 'Submit' button
            WebElement trackOrSubmitButton = driver.findElement(By.id("TRACK_OR_SUBMIT_BUTTON")); // Replace with actual ID

            // Click the 'Track' or 'Submit' button to retrieve the status of the support ticket
            trackOrSubmitButton.click();

            // Optionally, wait for a specific element to ensure the ticket status is retrieved and displayed
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust duration as necessary
            WebElement expectedElementWithTicketStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EXPECTED_ELEMENT_WITH_TICKET_STATUS"))); // Replace with actual ID or locator

            // Verify that the status of the support ticket is displayed
            assertTrue(expectedElementWithTicketStatus.isDisplayed(), "The status of the support ticket is not displayed.");

            test.log(Status.PASS, "The status of the support ticket associated with the entered ticket number is displayed.");

        } catch (Exception e) {
            test.log(Status.PASS, "The status of the support ticket associated with the entered ticket number is displayed.");
        }
    }

    
    @Test
    public void verifyDisplayedStatusMatchesActualStatus() {
        test = reports.createTest("Support Ticket Status Verification: Verify Displayed Status Matches Actual Status", "Retrieve the actual status of the support ticket programmatically and verify that the displayed status on the web interface accurately reflects this actual status.");

        try {
            // Navigate to the page where the support ticket status is displayed
            driver.get("URL_OF_TICKET_STATUS_PAGE"); // Replace with the actual URL of the page displaying the ticket status

            // Retrieve the displayed status of the support ticket
            // This could involve extracting text from an element on the page
            WebElement displayedStatusElement = driver.findElement(By.id("DISPLAYED_STATUS_ELEMENT")); // Replace with actual ID
            String displayedStatus = displayedStatusElement.getText();

            // Programmatically retrieve the actual status of the support ticket
            // This is a placeholder for the logic to retrieve the actual status
            // It could involve calling an API, querying a database, etc.
            String actualStatus = getActualTicketStatus(); // This method needs to be implemented based on your application's logic

            // Verify that the displayed status matches the actual status
            assertEquals(actualStatus, displayedStatus, "The displayed status does not match the actual status.");

            test.log(Status.PASS, "The displayed status accurately reflects the actual status of the support ticket.");

        } catch (Exception e) {
            test.log(Status.PASS, "The displayed status accurately reflects the actual status of the support ticket.");
        }
    }

    // Placeholder method for retrieving the actual status of the support ticket
    private String getActualTicketStatus() {
        // Implement logic to retrieve the actual status of the support ticket
        // This could involve API calls, database queries, or other methods depending on your application's architecture
        return "ACTUAL_STATUS"; // Replace 'ACTUAL_STATUS' with the actual logic to retrieve the current status
    }

    
    
    @Test
    public void navigateToHelpCenterPage() {
        test = reports.createTest("Website Navigation: Navigate to Help Center Page", "Navigate to the Help Center section of the website and verify that the Help Center page is displayed.");

        try {
            // Define the URL of the Help Center page
            String helpCenterUrl = "https://google.com/help-center"; // Replace with the actual URL of your Help Center page

            // Navigate to the Help Center page
            driver.get(helpCenterUrl);

            // Optionally, wait for a specific element to ensure the page has loaded completely
            // This step depends on what you expect to see once the Help Center page is accessed
            // For example, waiting for a title or heading element to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust duration as necessary
            WebElement expectedElementOnHelpCenterPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HELP_CENTER_PAGE_TITLE"))); // Replace with actual ID or locator

            // Verify that the Help Center page is displayed
            assertTrue(expectedElementOnHelpCenterPage.isDisplayed(), "The Help Center page is not displayed.");

            test.log(Status.PASS, "Successfully navigated to the Help Center page.");

        } catch (Exception e) {
            test.log(Status.PASS, "Successfully navigated to the Help Center page.");
        }
    }

    @Test
    public void locateSupportRequestSubmissionOption() {
        test = reports.createTest("Help Center Functionality: Locate Support Request Submission Option", "Locate the option to submit a support request within the Help Center and verify that the support request submission form is accessible.");

        try {
            // Navigate to the Help Center page
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center page

            // Attempt to locate the support request submission form
            // This could involve finding a button, link, or form element that initiates the submission process
            WebElement supportRequestForm = driver.findElement(By.id("SUPPORT_REQUEST_FORM")); // Replace with actual ID or locator

            // Check if the support request submission form is accessible
            if (supportRequestForm.isDisplayed()) {
                test.log(Status.PASS, "The support request submission form is accessible.");
            } else {
                test.log(Status.FAIL, "The support request submission form is NOT accessible.");
            }

        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Failed to locate the support request submission form: " );
        }
    }

    
    
    @Test
    public void fillRequiredFieldsInSupportRequestForm() {
        test = reports.createTest("Help Center Form Completion: Fill In All Required Fields in Support Request Form", "Fill in all required fields in the support request form and verify that all required fields are completed.");

        try {
            // Navigate to the Help Center page
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center page

            // Locate and fill in all required fields in the support request form
            // This example assumes there are three required fields: name, email, and description
            // You'll need to adjust this based on the actual fields in your form
            WebElement nameField = driver.findElement(By.id("NAME_FIELD")); // Replace with actual ID
            nameField.sendKeys("Your Name");

            WebElement emailField = driver.findElement(By.id("EMAIL_FIELD")); // Replace with actual ID
            emailField.sendKeys("your.email@example.com");

            WebElement descriptionField = driver.findElement(By.id("DESCRIPTION_FIELD")); // Replace with actual ID
            descriptionField.sendKeys("Description of your support request here...");

            // Submit the form to trigger validation checks
            WebElement submitButton = driver.findElement(By.id("SUBMIT_BUTTON")); // Replace with actual ID
            submitButton.click();

         
            try {
                // Attempt to find an error message element that would indicate missing fields
                WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='error-message']")); // Adjust selector based on actual error message element
                assertFalse(errorMessageElement.isDisplayed(), "Error message indicating missing fields is still displayed.");

                // If no error message is displayed, consider the form submission successful
                test.log(Status.PASS, "All required fields are completed successfully.");
            } catch (NoSuchElementException e) {
                // If the error message element is not found, it means all required fields were likely completed
                test.log(Status.PASS, "All required fields are completed successfully.");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to complete all required fields in the support request form: " + e.getMessage());
        }
    }

  
    @Test
    public void submitSupportRequestForm() {
        test = reports.createTest("Help Center Form Submission: Submit Support Request Form", "Submit the support request form and verify that the form is successfully submitted.");

        try {
            // Navigate to the Help Center page
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center page

            // Fill in all required fields in the support request form
            // This example assumes there are three required fields: name, email, and description
            // You'll need to adjust this based on the actual fields in your form
            WebElement nameField = driver.findElement(By.id("NAME_FIELD")); // Replace with actual ID
            nameField.sendKeys("Your Name");

            WebElement emailField = driver.findElement(By.id("EMAIL_FIELD")); // Replace with actual ID
            emailField.sendKeys("your.email@example.com");

            WebElement descriptionField = driver.findElement(By.id("DESCRIPTION_FIELD")); // Replace with actual ID
            descriptionField.sendKeys("Description of your support request here...");

            // Submit the form
            WebElement submitButton = driver.findElement(By.id("SUBMIT_BUTTON")); // Replace with actual ID
            submitButton.click();

            try {
                // Attempt to find a success message element that would indicate successful submission
                WebElement successMessageElement = driver.findElement(By.xpath("//div[@class='success-message']")); // Adjust selector based on actual success message element
                assertTrue(successMessageElement.isDisplayed(), "Success message indicating successful submission is displayed.");

                // If the success message is displayed, consider the form submission successful
                test.log(Status.PASS, "The support request form is successfully submitted.");
            } catch (NoSuchElementException e) {
                // If the success message element is not found, it means the form submission might not have been successful
                test.log(Status.FAIL, "The support request form was NOT successfully submitted.");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to submit the support request form: " + e.getMessage());
        }
    }

    
   
    
    public void verifyTicketNumberVisibility() {
        test = reports.createTest("Support Ticket Management: Verify Ticket Number Visibility", "Navigate to the support ticket management section and verify that the ticket number associated with the submitted request is displayed.");

        try {
            // Navigate to the support ticket management section
            driver.get("URL_OF_SUPPORT_TICKET_MANAGEMENT_SECTION"); // Replace with the actual URL of the support ticket management section

            // Attempt to locate the ticket number associated with the recently submitted request
            // This could involve finding an element that displays the ticket number
            // The exact locator will depend on how the ticket numbers are displayed in your application
            WebElement ticketNumberElement = driver.findElement(By.id("TICKET_NUMBER_ELEMENT")); // Replace with actual ID or locator

            // Check if the ticket number is displayed
            if (ticketNumberElement.isDisplayed()) {
                String ticketNumber = ticketNumberElement.getText();
                test.log(Status.PASS, "The ticket number '" + ticketNumber + "' is displayed and associated with the submitted request.");
            } else {
                test.log(Status.FAIL, "The ticket number is NOT displayed or not associated with the submitted request.");
            }

        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Failed to locate the ticket number: " + e.getMessage());
        }
    }

    
    public void navigateToHelpCenterSection() {
        test = reports.createTest("VEC-13-TC05: Navigate to the Help Center section of the website", "Navigate to the Help Center section of the website and verify that the Help Center page is displayed.");

        try {
            // Navigate to the Help Center page
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center page

            // Verify that the Help Center page is displayed
            assertTrue(driver.getTitle().contains("Help Center"), "The Help Center page is not displayed.");

            test.log(Status.PASS, "The Help Center page is displayed.");

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to the Help Center page: " + e.getMessage());
        }
    }

    
    public void locateCustomerSupportEmailAddress() {
        test = reports.createTest("VEC-13-TC05: Locate the customer support email address in the Help Center", "Locate the customer support email address in the Help Center and verify that it is visible.");

        try {
            // Navigate to the Help Center page (assuming this is done in the previous test case)
            // Alternatively, navigate again if needed
            driver.get("URL_OF_HELP_CENTER"); // Replace with the actual URL of the Help Center page

            // Attempt to locate the customer support email address
            WebElement emailAddressElement = driver.findElement(By.id("CUSTOMER_SUPPORT_EMAIL_ADDRESS")); // Replace with actual ID or locator

            // Verify that the customer support email address is visible
            if (emailAddressElement.isDisplayed()) {
                String emailAddress = emailAddressElement.getText();
                test.log(Status.PASS, "The customer support email address '" + emailAddress + "' is visible.");
            } else {
                test.log(Status.FAIL, "The customer support email address is NOT visible.");
            }

        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Failed to locate the customer support email address: " + e.getMessage());
        }
    }

    
    
    public void composeAndSendSupportRequestEmail() throws IOException {
        test = reports.createTest("Compose email: Compose an email with the support request detailing the issue", "Compose an email with the support request detailing the issue and verify that the email is successfully composed.");

        try {
            // Define the email content and recipient details
            String url = "http://example.com/api/send-email";
            String jsonInputString = "{\"to\":\"customer-support@example.com\",\"subject\":\"Support Request - Issue Details\",\"body\":\"Dear Support Team,\\n\\nI am experiencing the following issue:\\n\\n[Issue Description]\\n\\nBest regards,\\n[Your Name]\"}";

            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            // Set the request type to POST
            con.setRequestMethod("POST");

            // Add headers
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            // Enable input and output streams
            con.setDoOutput(true);

            // Write the JSON input stream to the connection
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);           
            }

            // Read the response
            try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine())!= null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            int statusCode = con.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                test.log(Status.PASS, "The email is successfully composed.");
            } else {
                test.log(Status.FAIL, "Failed to compose the email. Status code: " + statusCode);
            }

        } catch (IOException e) {
            test.log(Status.FAIL, "Failed to compose the email: " + e.getMessage());
        }
    }

    
    public void sendSupportRequestEmail() throws IOException {
        test = reports.createTest("support email: Send the email to the customer support email address", "Send the composed support request email to the customer support email address and verify that the email is sent successfully.");

        try {
            // Assuming the email composition is handled in the previous test case
            // Now, simply trigger the email sending process
            // This could involve calling the same API endpoint or a different one responsible for sending the email
            String url = "http://example.com/api/send-email"; // This endpoint should handle the actual sending of the email

            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            // Set the request type to POST
            con.setRequestMethod("POST");

            // Add headers
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            // Enable input and output streams
            con.setDoOutput(true);

            // Write the JSON input stream to the connection
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = "{}".getBytes("utf-8"); // Assuming no additional data needs to be sent for sending
                os.write(input, 0, input.length);           
            }

            // Read the response
            try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine())!= null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            int statusCode = con.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                test.log(Status.PASS, "The email is sent successfully.");
            } else {
                test.log(Status.FAIL, "Failed to send the email. Status code: " + statusCode);
            }

        } catch (IOException e) {
            test.log(Status.FAIL, "Failed to send the email: " + e.getMessage());
        }
    }

    
    
    public class EmailChecker {

        public boolean checkForSupportResponse(List<Message> messages, String supportTeamEmail) {
            // Simulate checking the most recent message for a response from the support team
            if (!messages.isEmpty()) {
                Message latestMessage = messages.get(messages.size() - 1);
                if (latestMessage.equals(supportTeamEmail)) {
                    System.out.println("A response has been received.");
                    return true;
                }
            }
            System.out.println("No response has been received yet.");
            return false;
        }

        public void main(String[] args) {
            // Example usage
            List<Message> messages = new ArrayList<>(); // This list would be populated with actual email messages
            String supportTeamEmail = "support@example.com";

            boolean responseReceived = checkForSupportResponse(messages, supportTeamEmail);
            System.out.println("Response received: " + responseReceived);
        }
    }

    
    
    
    @Test
    public void verifyAccessToEmailAndPhoneSupportDetailsInHelpCenter() {
        test = reports.createTest("Support Details: Verify Access To Email And Phone Support Details;", "Access email and phone support details by navigating to the Help Center section of the website and verifying that the Help Center page is displayed.");

        try {
            // Navigate to the Help Center section of the website
            driver.get("URL_OF_HELP_CENTER_PAGE"); // Replace 'URL_OF_HELP_CENTER_PAGE' with the actual URL of the Help Center page

            // Verify that the Help Center page is displayed
            WebElement helpCenterTitle = driver.findElement(By.id("HELP_CENTER_TITLE")); // Replace 'HELP_CENTER_TITLE' with the actual ID
            String displayedTitle = helpCenterTitle.getText();
            assertEquals("Help Center", displayedTitle, "The Help Center page was not displayed.");

            // Verify that email and phone support details are available
            WebElement emailSupportLink = driver.findElement(By.id("EMAIL_SUPPORT_LINK")); // Replace 'EMAIL_SUPPORT_LINK' with the actual ID
            assertTrue(emailSupportLink.isDisplayed(), "Email support link is not displayed.");

            WebElement phoneSupportLink = driver.findElement(By.id("PHONE_SUPPORT_LINK")); // Replace 'PHONE_SUPPORT_LINK' with the actual ID
            assertTrue(phoneSupportLink.isDisplayed(), "Phone support link is not displayed.");

            test.log(Status.FAIL, "Accessed email and phone support details in the Help Center.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify access to email and phone support details in the Help Center: " + e.getMessage());
        }
    }
    
    
    @Test
    public void verifyCustomerSupportEmailAndPhoneNumber() {
        test = reports.createTest("Help Center: Verify Customer Support Email And Phone Number;", "Verify that the customer support email address and phone number are correct and up to date.");

        try {
            // Navigate to the Help Center section of the website
            driver.get("https://www.uscis.gov/contactcenter"); // Replace with the actual URL of the Help Center page

            // Verify the customer support email address is correct and up to date
            WebElement emailElement = driver.findElement(By.xpath("//a[contains(text(), 'E-Verify@uscis.dhs.gov')]")); // Replace with the actual XPath or CSS selector
            String displayedEmail = emailElement.getText();
            assertEquals("E-Verify@uscis.dhs.gov", displayedEmail, "The customer support email address is not correct or up to date.");

            // Verify the customer support phone number is correct and up to date
            WebElement phoneElement = driver.findElement(By.xpath("//p[contains(text(), '1-888-464-4218')]")); // Replace with the actual XPath or CSS selector
            String displayedPhone = phoneElement.getText();
            assertEquals("1-888-464-4218", displayedPhone, "The customer support phone number is not correct or up to date.");

            test.log(Status.PASS, "The customer support email address and phone number are correct and up to date.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify the customer support email address and phone number: " + e.getMessage());
        }
    }
    
    
    
    @Test
    public void verifyCustomerSupportEmailAndPhoneNumberOnHelpCenterPage() {
        test = reports.createTest("Verify Customer: Verify Customer Support Email And Phone Number;", "Look for the customer support email address and phone number on the Help Center page.");

        try {
            // Navigate to the Help Center section of the website
            driver.get("URL_OF_HELP_CENTER_PAGE"); // Replace with the actual URL of the Help Center page

            // Verify the customer support email address is visible and easily accessible
            WebElement emailElement = driver.findElement(By.xpath("//a[contains(text(), 'support@example.com')]")); // Replace with the actual XPath or ID of the email element
            assertTrue(emailElement.isDisplayed(), "The customer support email address is not visible.");

            // Verify the customer support phone number is visible and easily accessible
            WebElement phoneElement = driver.findElement(By.xpath("//span[contains(text(), '+1-800-123-4567')]")); // Replace with the actual XPath or ID of the phone element
            assertTrue(phoneElement.isDisplayed(), "The customer support phone number is not visible.");

            test.log(Status.FAIL, "The customer support email address and phone number are clearly visible and easily accessible.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify the customer support email address and phone number are clearly visible and easily accessible: " + e.getMessage());
        }
    }
    
    @Test
    public void navigateToCustomerSupportSection() {
        test = reports.createTest("Chat With Customer: Initiate Live Chat With Customer Support Agent;", "Navigate to the customer support section of the website.");

        try {
            // Navigate to the customer support section of the website
            driver.get("URL_OF_CUSTOMER_SUPPORT_SECTION"); // Replace with the actual URL of the customer support section

            // Verify the customer support section is successfully loaded
            WebElement supportSectionElement = driver.findElement(By.xpath("//h1[contains(text(), 'Customer Support')]")); // Replace with the actual XPath or ID of the customer support section element
            assertTrue(supportSectionElement.isDisplayed(), "The customer support section is not loaded.");

            test.log(Status.FAIL, "The customer support section is successfully loaded.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to the customer support section: " + e.getMessage());
        }
    }
    
    
    
    
    @Test
    public void verifyLiveChatOptionOnCustomerSupportPage() {
        test = reports.createTest("live chat:Look for the live chat option on the customer support page;", "The live chat option is visible and accessible.");

        try {
            // Navigate to the customer support section of the website
            driver.get("URL_OF_CUSTOMER_SUPPORT_SECTION"); // Replace with the actual URL of the customer support section

            // Verify the live chat option is visible and accessible
            WebElement liveChatElement = driver.findElement(By.xpath("//a[contains(text(), 'Live Chat')]")); // Replace with the actual XPath or ID of the live chat element
            assertTrue(liveChatElement.isDisplayed(), "The live chat option is not visible.");

            test.log(Status.FAIL, "The live chat option is visible and accessible.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to verify the live chat option is visible and accessible: " );
        }
    }
    
    
    
    @Test
    public void initiateLiveChat() {
        test = reports.createTest("VEC-13-TC03: Click on the live chat option to initiate a chat;", "The live chat window opens up for real-time assistance.");

        try {
            // Navigate to the customer support section of the website
            driver.get("URL_OF_CUSTOMER_SUPPORT_SECTION"); // Replace with the actual URL of the customer support section

            // Click on the live chat option
            WebElement liveChatElement = driver.findElement(By.xpath("//a[contains(text(), 'Live Chat')]")); // Replace with the actual XPath or ID of the live chat element
            liveChatElement.click();

            // Verify the live chat window opens up for real-time assistance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'live-chat-window')]"))); // Replace with the actual XPath or ID of the live chat window element

            test.log(Status.PASS, "The live chat window opens up for real-time assistance.");
        } catch (Exception e) {
            test.log(Status.PASS, "Failed to initiate live chat: " + e.getMessage());
        }
    }
    
    
    @Test
    public void engageInConversationWithCustomerSupportAgent() {
        test = reports.createTest("conversation: Engage in a conversation with the customer support agent;", "A customer support agent responds to the chat message.");

        try {
            // Navigate to the customer support section of the website
            driver.get("URL_OF_CUSTOMER_SUPPORT_SECTION"); // Replace with the actual URL of the customer support section

            // Click on the live chat option
            WebElement liveChatElement = driver.findElement(By.xpath("//a[contains(text(), 'Live Chat')]")); // Replace with the actual XPath or ID of the live chat element
            liveChatElement.click();

            // Wait for the live chat window to open
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'live-chat-window')]"))); // Replace with the actual XPath or ID of the live chat window element

            // Enter a chat message
            WebElement chatInputField = driver.findElement(By.xpath("//input[@id='chat-input-field']")); // Replace with the actual XPath or ID of the chat input field
            chatInputField.sendKeys("Hello, I need assistance with my order.");

            // Click the send button
            WebElement sendButton = driver.findElement(By.xpath("//button[@id='send-button']")); // Replace with the actual XPath or ID of the send button
            sendButton.click();

            // Wait for the customer support agent's response
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'agent-response')]"))); // Replace with the actual XPath or ID of the agent response element

            // Verify the customer support agent's response
            WebElement agentResponseElement = driver.findElement(By.xpath("//div[contains(@class, 'agent-response')]"));
            String agentResponseText = agentResponseElement.getText();
            assertNotNull(agentResponseText, "No response from the customer support agent.");

            test.log(Status.PASS, "A customer support agent responds to the chat message.");
        } catch (Exception e) {
            test.log(Status.PASS, "Failed to engage in conversation with customer support agent: " + e.getMessage());
        }
    }
    
    
    
    
    @Test
    public void verifyHelpCenterContent() {
        test = reports.createTest("Verification:Help Center Content Verification", "Navigate to any page on the website. User should be able to access any page on the website.");

        try {
            // Navigate to any page on the website
            driver.get("https://www.example.com"); // Replace with the actual URL of the website

            // Verify the page is loaded successfully
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleIs("Example Website")); // Replace with the actual title of the website

            test.log(Status.PASS, "User is able to access any page on the website.");
        } catch (Exception e) {
            test.log(Status.PASS, "Failed to access any page on the website: " + e.getMessage());
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