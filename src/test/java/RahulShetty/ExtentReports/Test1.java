package RahulShetty.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import dataProvider.ConfigDataProvider;
import factory.DataProviderFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Test1 extends Baseclass {

     WebDriver driver;

    @Test
    public void InitialDemo(){
        driver=initialiseDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        Assert.assertTrue(true);
        driver.close();
    }


}
