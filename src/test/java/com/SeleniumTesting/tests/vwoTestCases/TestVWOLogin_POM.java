package com.SeleniumTesting.tests.vwoTestCases;

import com.SeleniumTesting.pages.pageObjectModel.vwo.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_POM {
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
}
