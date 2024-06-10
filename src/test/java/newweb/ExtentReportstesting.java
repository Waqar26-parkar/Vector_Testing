package newweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ExtentReportstesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\waqar.farooqui\\Downloads\\First\\src\\test\\java\\Extent-reports\\Attributes-1.html");
        extent.attachReporter(spark);
        spark.config().setTheme (Theme.DARK);
        spark.config().setReportName("Report name");
        spark.config().setDocumentTitle("Doc Title");
        spark.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        spark.config().setCss(".badge-primary{background-color:#da0b2b}");
        spark.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");

        extent.attachReporter(spark);
   /*     
     ExtentTest test1 =   extent.createTest("Test 1");
     test1.pass("Thsi is passed");
     
     ExtentTest test2 =   extent.createTest("Test 2");
     test2.log(Status.FAIL, "Thsi is Failed");
     
     ExtentTest test3 =   extent.createTest("Test 3");
     test3.log(Status.SKIP, "Thsi is Skipped");
     
       */
        // All the log must arrange in an order
       
        /*
        extent
        .createTest("Test 1")
        .log(Status.FAIL, "fail")
        .log(Status.FAIL, "fail")
        .log(Status.SKIP, "skip")
        .log(Status.WARNING, "WARNING")
        .log(Status.WARNING, "WARNING")
        .log(Status.PASS, "Pass")
        .log(Status.PASS, "pass")
        .log(Status.INFO, "info1")
        .log(Status.INFO, "info2");
        
*/
        
        /*
        
        ExtentTest test = extent.createTest("Text based Test");

        test.log(Status.INFO, "info1");
        test.log(Status.INFO, "<b>info2</b>");
        test.log(Status.INFO, "<i>info3</i>");
        test.log(Status.INFO, "<b><i>info4</i></b>");

        String xmlData = "<menu id=\"file\" value=\"File\">\r\n"
                + "<popup>\r\n"
                + "<menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
                + "<menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
                + "<menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
                + "</popup>\r\n"
                + "</menu>";
        
        
        String jsonData = "{\r\n"
                + "  \"menu\": {\r\n"
                + "    \"id\": \"file\",\r\n"
                + "    \"value\": \"File\",\r\n"
                + "    \"popup\": {\r\n"
                + "      \"menuitem\": [\r\n"
                + "        {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
                + "        {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
                + "        {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
                + "      ]\r\n"
                + "    }\r\n"
                + "  }\r\n"
                + "}";
        
        
        ExtentTest xmlTest = extent.createTest("XML based Test");
        xmlTest.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));

        ExtentTest jsonTest = extent.createTest("JSON based Test");
        jsonTest.log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

        test.log(Status.INFO, "XML Data: " + xmlData);
        
*/
        
        
     // Test 1: Successus
        ExtentTest test1 = extent.createTest("Test 1", "Test desc");
        test1.assignAuthor("Waqar"); 
        test1.assignCategory("Sedge"); 
        test1.assignDevice("Chrome 99"); 
        test1.pass("This is a passed test"); 
        
        // Test 2: Defectus
        ExtentTest test2 = extent.createTest("Test 2", "Test desc");
        test2.assignAuthor("Jhon"); // 
        test2.assignCategory("Sanity"); //
        test2.assignDevice("Edge 99"); // 
        test2.fail("This is a failed test"); 
        
     // Test 3: Defectus
        ExtentTest test3 = extent.createTest("Test 3", "Test desc");
        test3.assignCategory("Regression"); 
        test3.assignAuthor("Rebecca"); // 
        test3.assignDevice("Firefox 60"); // 
        test3.fail("This is a failed test"); // 
        
        extent.flush();


	}

}
