package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal.LoginPage;
import com.SeleniumTesting.tests.vwoTestCases.TestVWOLogin_06_Improved_POM_PropertyReader_DriverManager;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestKatalon_06_Login_Improved_POM_PropertyReader_DriverManager extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestKatalon_06_Login_Improved_POM_PropertyReader_DriverManager.class);
    @Description("Verify that user is able to login with valid credentials")
    @Test
    public void test_katalon_loginwithvalidcredentials() throws InterruptedException {
        logger.info("Starting the Katalon Testcases Page Object Model");

        LoginPage loginPage_katalon=new LoginPage(DriverManager.getDriver());
        String katalon_app_url=loginPage_katalon.loginToKatalonLoginValidCreds(PropertiesReader.readKey("katalon_username"),PropertiesReader.readKey("katalon_password"));

        logger.info("End of the testLoginPositiveKatalon !");
        assertThat(katalon_app_url).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(katalon_app_url, "https://katalon-demo-cura.herokuapp.com/#appointment");

    }

    @Description("Verify that error message is displayed for invalid credentials")
    @Test
    public void test_katalon_loginwithinvalidcredentials() {
        logger.info("Starting the Katalon Testcases Page Object Model");
        LoginPage loginPage_katalon=new LoginPage(DriverManager.getDriver());
        String actual_error_msg=loginPage_katalon.loginToKatalonLoginInvalidCreds(PropertiesReader.readKey("katalon_invalid_username"),PropertiesReader.readKey("katalon_invalid_password"));
        String exp_error_msg="Login failed! Please ensure the username and password are valid.";

        logger.info("End of the testLoginNegativeKatalon !");

        assertThat(actual_error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(actual_error_msg, exp_error_msg);
        }
}
