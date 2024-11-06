package testgrouping;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(priority = 1, groups = {"sanity"})
    void login_with_Email(){
        System.out.println("This is Log in with Email.");
    }

    @Test(priority = 2, groups = {"sanity"})
    void login_with_Facebook(){
        System.out.println("This is Log in with Facebook.");
    }

    @Test(priority = 3, groups = {"sanity"})
    void login_with_Google(){
        System.out.println("This is Log in with Google.");
    }
}
