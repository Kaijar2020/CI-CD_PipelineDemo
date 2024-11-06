package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftVsHardAssertion {

    @Test
    void hard_assert(){
        System.out.println("Test Hard Assertion");

        Assert.assertEquals(1,10); //hard assertion stop running code if the assertion is fail.

        System.out.println("Test Hard Assertion after assert");
    }

    @Test
    void soft_assert(){
        System.out.println("Test Soft Assertion");

        SoftAssert asrt = new SoftAssert();
        asrt.assertEquals(1,10); //soft assertion is not stop running code if the assertion is fail.

        System.out.println("Test Soft Assertion after assert");

        asrt.assertAll(); //mandatory to show error.
    }
}
