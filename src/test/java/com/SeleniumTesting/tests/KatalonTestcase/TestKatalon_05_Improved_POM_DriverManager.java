package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal.AppointmentPage;
import com.SeleniumTesting.tests.vwoTestCases.TestVWOLogin_06_Improved_POM_PropertyReader_DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKatalon_05_Improved_POM_DriverManager extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestKatalon_05_Improved_POM_DriverManager.class);
    @Owner("Kavita")
    @Description("Verify that make appointment button clicked")
    @Test
    public void test_katalon_make_appointment() {

        AppointmentPage appointmentPage=new AppointmentPage(DriverManager.getDriver());

        String exp_url_text=appointmentPage.make_appointment();
        Assert.assertEquals(exp_url_text, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        }
}
