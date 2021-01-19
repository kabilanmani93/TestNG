package RahulShetty.ExtentReports;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test3 extends Baseclass {

     WebDriver driver;

    @Test
    public void editbox(){
        driver=initialiseDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("hello");
        System.out.println("driver.getTitle");
        Assert.assertTrue(true);
        driver.close();

    }


}
