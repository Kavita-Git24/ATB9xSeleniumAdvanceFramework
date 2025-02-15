package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal.LoginPage;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestKatalon_04_Login_POM_PropertyReader {

    @Description("Verify that user is able to login with valid credentials")
    @Test
    public void test_katalon_loginwithvalidcredentials() throws InterruptedException {
        WebDriver driver=new EdgeDriver();

        LoginPage loginPage_katalon=new LoginPage(driver);
        String katalon_app_url=loginPage_katalon.loginToKatalonLoginValidCreds(PropertiesReader.readKey("katalon_username"),PropertiesReader.readKey("katalon_password"));
        Assert.assertEquals(katalon_app_url, "https://katalon-demo-cura.herokuapp.com/#appointment");

        driver.quit();
    }

    @Description("Verify that error message is displayed for invalid credentials")
    @Test
    public void test_katalon_loginwithinvalidcredentials() {
        WebDriver driver=new EdgeDriver();

        LoginPage loginPage_katalon=new LoginPage(driver);
        String actual_error_msg=loginPage_katalon.loginToKatalonLoginInvalidCreds(PropertiesReader.readKey("katalon_invalid_username"),PropertiesReader.readKey("katalon_invalid_password"));
        String exp_error_msg="Login failed! Please ensure the username and password are valid.";
        Assert.assertEquals(actual_error_msg, exp_error_msg);

        driver.quit();
    }
}
