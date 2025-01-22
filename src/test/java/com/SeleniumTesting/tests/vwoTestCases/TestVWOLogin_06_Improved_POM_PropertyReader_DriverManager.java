package com.SeleniumTesting.tests.vwoTestCases;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.pages.pageObjectModel.vwo.normal.DashboardPage;
import com.SeleniumTesting.pages.pageObjectModel.vwo.normal.LoginPage;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_06_Improved_POM_PropertyReader_DriverManager extends CommonToAllTest{
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_06_Improved_POM_PropertyReader_DriverManager.class);

    @Owner("Kavita")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {
        logger.info("Starting the Testcases Page Object Model");

        LoginPage loginPage_vwo=new LoginPage(DriverManager.getDriver());
        String error_msg=loginPage_vwo.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("End of the testLoginNegativeVWO !");

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("Kavita")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPage dashBoardPage  = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        logger.info("End and Asserting testLoginPositiveVWO");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
    }
}
