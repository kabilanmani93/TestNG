package Selenium;

import dataProvider.ConfigDataProvider;
import factory.DataProviderFactory;
import factory.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class Base
{


    WebDriver driver;
    public static ConfigDataProvider config= DataProviderFactory.getConfig();

    @BeforeClass
    public void setupApplication()
    {

        Reporter.log("=====Browser Session Started=====", true);

         System.out.println(DataProviderFactory.getConfig().getChromePath());
        System.setProperty("webdriver.chrome.driver", config.getChromePath());
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.zamzar.com/");

        Reporter.log("=====Application Started=====", true);
    }

    @Test
    public void test(){
        System.out.println("Check");
    }

    @AfterClass
    public void closeApplication()
    {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);

    }



}