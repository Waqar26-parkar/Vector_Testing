package newweb;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
 
public class Projectextentreports {
 
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    WebDriver driver;
 
    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Atti.html");
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
        usernameField.sendKeys("standard_user");
        test.log(Status.INFO, "Entering username: standard_user");
        
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys("secret_sauce");
        test.log(Status.INFO, "Entering password");
 
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
loginButton.click();
        
        test.log(Status.PASS, "Login successful");
    }
 
    @Test
    public void loginFailed() {
        test = reports.createTest("Login Failed Test Case", "Attempting to log in with invalid credentials.");
driver.get("https://www.saucedemo.com/");
        
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        String usernameValue = "invalid_user";
        usernameField.sendKeys(usernameValue);
        test.log(Status.INFO, "Entering username: " + usernameValue);
        
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        String passwordValue = "invalid_sauce";
        passwordField.sendKeys(passwordValue);
        test.log(Status.INFO, "Entering password");
 
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Login\"]"));
loginButton.click();
        
        // Assuming the application shows an error message on login failure, we capture that
        boolean loginFailed = driver.findElements(By.xpath("//div[contains(text(),'Username and password do not match')]")).size() > 0;
        
        if (loginFailed) {
            test.log(Status.PASS, "Login failed as expected");
        } else {
            test.log(Status.FAIL, "Login did not fail as expected");
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