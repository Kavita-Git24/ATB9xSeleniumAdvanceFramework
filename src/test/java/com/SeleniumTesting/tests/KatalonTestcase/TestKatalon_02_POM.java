package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal.AppointmentPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKatalon_02_POM {

    @Description("Verify that make appointment button clicked and valid url is navigatedi")
    @Test
    public void test_katalon_make_appointment() {
        WebDriver driver=new EdgeDriver();
        AppointmentPage appointmentPage=new AppointmentPage(driver);
        String exp_url_text=appointmentPage.make_appointment();
        Assert.assertEquals(exp_url_text, "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        }
}
