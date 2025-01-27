package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.listeners.RetryAnalyzer;
import com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal.AppointmentPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestKatalon_06_Improved_POM_DriverManager_Listener extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestKatalon_06_Improved_POM_DriverManager_Listener.class);

    @Owner("Kavita")
    @Description("Verify that make appointment button clicked")
    @Test

    public void test_katalon_make_appointment() {
        logger.info("Starting the Testcases Page Object Model");
        AppointmentPage appointmentPage=new AppointmentPage(DriverManager.getDriver());

        String exp_url_text=appointmentPage.make_appointment();
        logger.info("End of the testKatalon for URL !");
        Assert.assertEquals(exp_url_text, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        }
}
