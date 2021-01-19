package factory;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import dataProvider.ReportDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import org.testng.ITestResult ;
import utility.Helper;

import java.io.IOException;
import java.util.Arrays;

public class TestListener implements ITestListener{

    private static ExtentReports extent = ReportDataProvider.createInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }



    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getTestClass().getName() + ": :" +
                result.getMethod().getMethodName());

        extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Successful</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS,m);// .get is because of thread local

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b>Test Method" + result.getMethod().getMethodName() + "SKIPPED</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP,m);// .get is because of thread local

    }

    @Override
    public void onTestFailure(ITestResult result) {
       String methodName = result.getMethod().getMethodName();
       String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
       extentTest.get().fail("<details><summary><b><font color =red>" + "Exception Occured, click to see details:" +
                "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>")+"</details> \n");

       WebDriver driver = ((TestBase)result.getInstance()).driver;
       String path = Helper.takeScreenshot(driver,methodName);
       try{
           extentTest.get().fail("<b><font color =red>" + "Screenshot of Failure:" + "</font></b>" ,
                   MediaEntityBuilder.createScreenCaptureFromPath(path).build());
       }catch (IOException e)
       {
           extentTest.get().fail("Test failed,Cannot attach screenshot");
       }

    }

    @Override
    public void onFinish(ITestContext arg0) {
        if(extent!=null)
        {
            extent.flush();
        }

    }

}
