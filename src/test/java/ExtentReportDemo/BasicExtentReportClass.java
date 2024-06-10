package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExtentReportClass {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void startReport() {
        // Corrected the syntax for instantiating ExtentSparkReporter
        htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
    }
}
