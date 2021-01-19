package TestNG_Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SimpleTest
{
    private String param1 = "";
    private String param2 = "";

    public SimpleTest()
    {

    }

    public SimpleTest(String param1,String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }
 
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before SimpleTest class executed.");
    }
 
    @Test
    public void testMethod() {
        System.out.println("testMethod parameter value is: " + param1 + " " + param2);
    }



    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                new SimpleTest("one","check"),
                new SimpleTest("two","check") ,
                new SimpleTest("three","check")
        };
    }
}