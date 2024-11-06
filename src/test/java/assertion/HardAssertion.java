package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

    @Test
    void test(){
        Assert.assertEquals("xyz","xyz");
        Assert.assertNotEquals(123,458);
        Assert.assertTrue(true);

//        Assert.fail(String.valueOf(1 == 2));
    }
}
