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

public class myntra {

    public ChromeDriver driver;

    @Test
    public void GetDetailsProductintoTextFile() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.myntra.com/");

        WebElement Search = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input"));
        Search.sendKeys("Shirt");

        Actions a = new Actions(driver);
        a.sendKeys(Search, Keys.ENTER).perform();

        // Find the first shirt product
        WebElement firstShirtProduct = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[1]/div/div/div/picture/img"));

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // This closes the alert
        } catch (NoAlertPresentException e) {
            // No alert present, proceed with the test
        }
        // Extract the product description
        String firstShirtProdu = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[2]")).getText();
        System.out.println(firstShirtProdu);

        // Write the description to a text file
        try (FileWriter writer = new FileWriter("product_description.txt")) {
            writer.write(firstShirtProdu);
            System.out.println("Product description written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
