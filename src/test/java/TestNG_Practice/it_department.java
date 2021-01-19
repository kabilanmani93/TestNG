package TestNG_Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class it_department
{

    @BeforeTest                                             // annotated method placed in the beginning.
    public void before_test()
    {
        System.out.println("It will be executed first for IT");
    }

    @BeforeClass
    public void before_class()
    {
        System.out.println("This method is executed before Class1");
    }

    @Test
    public void software_qevelopers()
    {
        System.out.println("Software Developers");
    }

    @Test (groups= {"IT_Department"})
    public void software_testers()
    {
        System.out.println("Software Testers");
    }

    @BeforeGroups("IT_Department")
    public void qa_analyst()
    {
        System.out.println("QA Analyst : Before group");
    }}