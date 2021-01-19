package RahulShetty.ExtentReports;

import dataProvider.ConfigDataProvider;
import factory.DataProviderFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Baseclass {

    public static ConfigDataProvider config= DataProviderFactory.getConfig();
    static WebDriver driver;

    public WebDriver initialiseDriver()
    {
        System.setProperty("webdriver.chrome.driver",config.getChromePath());
        driver = new ChromeDriver();
        return driver;
    }


}
