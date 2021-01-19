package RahulShetty.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.Helper;

import java.io.IOException;
import java.util.Arrays;

public class Listener extends Baseclass implements ITestListener {

    ExtentReports extent = ExtentReportNG.extentReportsGenerator();
    ExtentTest test;
    // make it private static so its confined to this class
    // ThreadLocal class for Extent Test
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {

         test = extent.createTest(result.getMethod().getMethodName());
         extentTest.set(test);
    }


    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        //test is replaced with extenttest.get()
        //extentTest.get().log(Status.PASS,"Successfull");

        String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Successful</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS,m);// .get is because of thread local

        // Find the correct driver
        WebDriver driver = null;
        Object testObject = result.getInstance();
        Class clazz = result.getTestClass().getRealClass();
        try
        {
            driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        //pass the above driver and take sc
        try
        {
            String path = Helper.takeScreenshot(driver,methodName);
            extentTest.get().addScreenCaptureFromPath(path,methodName);
            extentTest.get().pass("<b><font color =red>" + "Screenshot of Pass:" + "</font></b>" ,
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        extentTest.get().fail("<details><summary><b><font color =red>" + "Exception Occured, click to see details:" +
                "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>")+"</details> \n");


        // Find the correct driver
        WebDriver driver = null;
        Object testObject = result.getInstance();
        Class clazz = result.getTestClass().getRealClass();
        try
        {
            driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        //pass the above driver and take sc
        try
        {
            String path = Helper.takeScreenshot(driver,methodName);
            //extentTest.get().addScreenCaptureFromPath(path,methodName);
            extentTest.get().fail("<b><font color =red>" + "Screenshot of Failure:" + "</font></b>" ,
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());


        } catch (IOException e)
        {
            e.printStackTrace();
        }

        //test.fail(result.getThrowable());
        //extentTest.get().fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        String logText = "<b>Test Method" + result.getMethod().getMethodName() + "SKIPPED</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP,m);// .get is because of thread local

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
