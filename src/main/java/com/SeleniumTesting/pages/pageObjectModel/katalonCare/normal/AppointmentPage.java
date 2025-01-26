package com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AppointmentPage {
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
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(makeapppointment).click();

        String url_text = driver.getCurrentUrl();
        return url_text;
    }
}
