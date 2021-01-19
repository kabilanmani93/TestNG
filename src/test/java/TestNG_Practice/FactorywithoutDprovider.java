package TestNG_Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactorywithoutDprovider {

    private String Shipfrom ;
    private String Shipto ;
    private Integer packagecount;


    @Factory
    public FactorywithoutDprovider(String Shipfrom, String Shipto, Integer packagecount)
    {
        this.Shipfrom =Shipfrom;
        this.Shipto = Shipto;
        this.packagecount = packagecount;
    }

    @BeforeClass
    public void launch()
    {
        System.out.println("Launch Browser");
    }

    @Test
    public void shipment()
    {
        System.out.println("Ship From country is : " + Shipfrom );
        System.out.println("Ship To Country is : " + Shipto );
        System.out.println("Package count is : " + packagecount );
    }


}
class factoryclass
{
    @org.testng.annotations.Factory
    public Object[] factoryMethod()
    {
        return new Object[]
                {
                        new FactorywithoutDprovider("Canada","India",4),
                        new FactorywithoutDprovider("USA","Mexico",9)
                };
    }
}
