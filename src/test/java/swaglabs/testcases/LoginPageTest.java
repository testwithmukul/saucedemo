package swaglabs.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import swaglabs.base.TestBase;
import swaglabs.pages.LoginPage;
import swaglabs.pages.ProductsPage;

public class LoginPageTest extends TestBase {

    //Since methods are not static in loginPage that's why created object:
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginPageTest(){
        super();            //keyword helps in calling super class constructor
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    //TEST CASES:
    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    @Test(priority = 2)
    public void loginTest(){
        productsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
