package testngpractice;

import org.testng.annotations.*;

public class AllAnnotations {

    @BeforeSuite
    void before_suite(){
        System.out.println("This is before suit example.");
    }

    @AfterSuite
    void after_suite(){
        System.out.println("This is after suit example.");
    }

    @BeforeTest
    void before_test(){
        System.out.println("This is before test example.");
    }

    @AfterTest
    void after_test(){
        System.out.println("This is after test example.");
    }

    @BeforeClass
    void before_class(){
        System.out.println("This is before class example.");
    }

    @AfterClass
    void after_class(){
        System.out.println("This is after class example.");
    }

    @BeforeMethod
    void before_method(){
        System.out.println("This is before method example.");
    }

    @AfterMethod
    void after_method(){
        System.out.println("This is after method example.");
    }
    @Test(priority = 1)
    void test_methodOne(){
        System.out.println("This is test method one");
    }
    @Test(priority = 2)
    void test_methodTwo(){
        System.out.println("This is test method two");
    }
}
