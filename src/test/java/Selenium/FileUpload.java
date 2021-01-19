package Selenium;

import dataProvider.ConfigDataProvider;
import factory.DataProviderFactory;
import factory.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload extends Base
{

    @Test
    public void clickaddfiles() throws InterruptedException {
        Thread.sleep(2000);
        WebElement upload = driver.findElement(By.xpath("//input[@id ='inputFile']"));

        upload.sendKeys("F:\\Automation\\eShipper\\src\\main\\resources\\executables\\chromedriver.exe");

        WebDriverWait wait = new WebDriverWait(driver,30);
        String uploadsuccessxpath = "//span[contains(@class,'step-number-1')]/parent::div[contains(@class,'step-complete')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uploadsuccessxpath)));
        //WebElement uploadsuccess= driver.findElement(By.xpath(uploadsuccessxpath));

        System.out.println("File selected");

        Thread.sleep(2000);


        //input tag cannot be clicked, if needs to be clicked use actions class
//        Actions builder = new Actions(driver);
//        builder.moveToElement(upload).click().build().perform();
    }

}