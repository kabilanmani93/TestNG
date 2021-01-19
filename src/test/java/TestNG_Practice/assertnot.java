package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class assertnot {

    @Test(description = "GITHUB-1935", expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = "did not expect to find \\[x\\] but found \\[x\\]")
    public void testEqualityMessage() {
        Assert.assertNotEquals("x", "x");
    }

    @Test(expectedExceptions = AssertionError.class)
        public void boxedArrayAssertNotEquals(){
            Assert.assertNotEquals(
                    new Integer[] {42},
                    new Integer[] {42},
                    "arrays of wrapped values are compared by value in assertNotEquals");
        }

    }

