package TestNG_Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.security.ec.point.ProjectivePoint;

public class Factory {

    @org.testng.annotations.Factory
    public Object[] factoryMethod()
    {
        return new Object[]
                {
                     new Dprovider(),
                     new Dprovider()
                };
    }
}
