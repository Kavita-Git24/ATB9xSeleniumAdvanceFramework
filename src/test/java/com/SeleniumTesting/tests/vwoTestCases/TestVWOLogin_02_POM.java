package com.SeleniumTesting.tests.vwoTestCases;

import com.SeleniumTesting.pages.pageObjectModel.vwo.DashboardPage;
import com.SeleniumTesting.pages.pageObjectModel.vwo.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_POM {
    @Owner("Kavita")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {
        WebDriver driver=new EdgeDriver();
        LoginPage loginPage_vwo=new LoginPage(driver);

        String error_msg=loginPage_vwo.loginToVWOLoginInvalidCreds("admin","123");

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

    }

    @Owner("Kavita")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashBoardPage  = new DashboardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");
    }
}
