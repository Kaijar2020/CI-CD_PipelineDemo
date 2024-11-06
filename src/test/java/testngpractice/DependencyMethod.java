package testngpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {

    @Test(priority = 1)
    void open_app(){
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"open_app"})
    void login_app(){
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = {"login_app"})
    void search_app(){
        Assert.assertTrue(false);
    }

    @Test(priority = 4, dependsOnMethods = {"login_app", "search_app"}) //Multiple dependency.
    void adv_search_app(){
        Assert.assertTrue(true);
    }

    @Test(priority = 5, dependsOnMethods = {"login_app"})
    void logout_app(){
        Assert.assertTrue(true);
    }
}
