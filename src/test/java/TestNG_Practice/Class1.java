package TestNG_Practice;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
public class Class1
{
    @BeforeGroups("IT_Department")
    public void before_it()
    {
        System.out.println("This method will be executed before the execution of IT Department group");
    }
    @Test
    public void testcase1()
    {
        System.out.println("HR");
    }
    @Test(groups= {"Kabilan"})
    public void testcase2()
    {
        System.out.println("Software Developer");
    }
    @Test(groups= {"Kabilan"})
    public void testcase3()
    {
        System.out.println("QA Analyst");
    }
}