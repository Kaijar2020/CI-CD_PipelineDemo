package testngpractice;

import org.testng.annotations.Test;

public class DemoClass {

    @Test (priority = 2)
    void openApp(){
        System.out.println("Hello TestNG");
    }
    @Test(priority = 3)
    void login(){
        System.out.println("Hello Login");
    }
    @Test (priority = 1)
    void logout(){
        System.out.println("Hello LogOut");
    }
}
