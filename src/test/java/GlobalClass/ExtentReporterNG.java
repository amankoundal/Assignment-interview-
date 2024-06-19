package GlobalClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;
    public static ExtentReports getReporterObject(){

        // extendsReports, ExtendSparkReporter
        String path = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA", "Aman koundal");
        return extent;

    }

    private void setSystemInfo(String Tester, String name) {
    }

    private void attachReporter(ExtentSparkReporter reporter) {
    }
}
