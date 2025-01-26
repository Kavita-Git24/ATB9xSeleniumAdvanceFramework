package com.SeleniumTesting.pages.pageObjectModel.katalonCare.improved_pom;

import com.SeleniumTesting.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AppointmentPage extends CommonToAllPages {
    WebDriver driver;
    //Page Locators
    //Page Actions
    public AppointmentPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Step1- Page Locataors
    private By makeapppointment=By.xpath("//a[@id='btn-make-appointment']");
    @Test
    public String make_appointment()
    {
        openKatalonUrl();
        clickElement(makeapppointment);
        custom_wait();
        String url_text = driver.getCurrentUrl();
        return url_text;
    }
}
