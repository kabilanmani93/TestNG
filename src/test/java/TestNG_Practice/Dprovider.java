package TestNG_Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dprovider {

    @BeforeClass
    public static void launchBrowser()
    {
        System.out.println("Launch Browser");
    }

    @Test(dataProvider="data")
    public static void createshipment(String Shipfrom, String Shipto, Integer packagecount)
    {
        System.out.println("Ship From country is : " + Shipfrom );
        System.out.println("Ship To Country is : " + Shipto );
        System.out.println("Package count is : " + packagecount );
    }

    @DataProvider
    public Object[][] data()
    {
        return new Object[][]
                {{"Canada","India",4},{"Australia","Africa",2}};
    }
}
