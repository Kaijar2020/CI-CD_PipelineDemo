package testgrouping;

import org.testng.annotations.Test;

public class PaymentTest{

    @Test(priority = 1, groups = {"sanity","regression"})
    void pay_in_BDT(){
        System.out.println("This Payment make with BDT.");
    }

    @Test(priority = 2, groups = {"sanity","regression"})
    void pay_in_USD(){
        System.out.println("This Payment make with USD.");
    }
}
