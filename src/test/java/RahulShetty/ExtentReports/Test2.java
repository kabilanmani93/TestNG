package RahulShetty.ExtentReports;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test2 extends Baseclass {

     WebDriver driver;

    @Test
    public void googlevalidation()
    {
         driver=initialiseDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        Assert.assertTrue(true);
        driver.close();
    }


}
