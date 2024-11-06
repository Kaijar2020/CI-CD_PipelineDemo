package testngpractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationDemo1 {

    @BeforeMethod //Before method will execute immediately before test method.
    void login(){
        System.out.println("This is Login");
    }

    @Test(priority = 1)
    void search(){
        System.out.println("This is search");
    }

    @Test(priority = 2)
    void advance_search(){
        System.out.println("This is advance_search");
    }

    @AfterMethod //After method will execute immediately before test method.
    void logout(){
        System.out.println("This is Logout");
    }
}
