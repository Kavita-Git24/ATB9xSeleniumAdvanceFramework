package com.SeleniumTesting.tests.vwoTestCases;

import com.SeleniumTesting.pages.pageObjectModel.vwo.DashboardPage;
import com.SeleniumTesting.pages.pageObjectModel.vwo.LoginPage;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_04_POM_PropertyReader {
    @Owner("Kavita")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {
        WebDriver driver=new EdgeDriver();
        LoginPage loginPage_vwo=new LoginPage(driver);

        String error_msg=loginPage_vwo.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("Kavita")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPage dashBoardPage  = new DashboardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
    }
}
