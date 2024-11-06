package testgrouping;

import org.testng.annotations.Test;

public class RegistrationTest {

    @Test(priority = 1,groups = {"regression"})
    void reg_with_Email(){
        System.out.println("This is Reg with Email.");
    }

    @Test(priority = 2, groups = {"regression"})
    void reg_with_Facebook(){
        System.out.println("This is Reg with Facebook.");
    }

    @Test(priority = 3, groups = {"regression"})
    void reg_with_Google(){
        System.out.println("This is Reg with Google.");
    }
}
