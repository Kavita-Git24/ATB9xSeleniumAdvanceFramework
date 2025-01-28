package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal.LoginPage;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestKatalon_05_Login_POM_PropertyReader_DriverManager extends CommonToAllTest {

    @Description("Verify that user is able to login with valid credentials")
    @Test
    public void test_katalon_loginwithvalidcredentials() throws InterruptedException {

        LoginPage loginPage_katalon=new LoginPage(DriverManager.getDriver());
        String katalon_app_url=loginPage_katalon.loginToKatalonLoginValidCreds(PropertiesReader.readKey("katalon_username"),PropertiesReader.readKey("katalon_password"));

        assertThat(katalon_app_url).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(katalon_app_url, "https://katalon-demo-cura.herokuapp.com/#appointment");

    }

    @Description("Verify that error message is displayed for invalid credentials")
    @Test
    public void test_katalon_loginwithinvalidcredentials() {
        LoginPage loginPage_katalon=new LoginPage(DriverManager.getDriver());
        String actual_error_msg=loginPage_katalon.loginToKatalonLoginInvalidCreds(PropertiesReader.readKey("katalon_invalid_username"),PropertiesReader.readKey("katalon_invalid_password"));
        String exp_error_msg="Login failed! Please ensure the username and password are valid.";

        assertThat(actual_error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(actual_error_msg, exp_error_msg);

        }
}
