package pageobjectwithpagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    //Constructor.
    LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators.
    /*
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
    WebElement username_loc;
    This is using How keywords.
    * */
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username_loc;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password_loc;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement login_btn_loc;

    //Actions.

    public void setUsername(String user){
        username_loc.sendKeys(user);
    }

    public void setPassword(String pass){
        password_loc.sendKeys(pass);
    }

    public void clickLogin(){
        login_btn_loc.click();
    }
}
