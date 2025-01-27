package com.SeleniumTesting.tests.KatalonTestcase;

import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestKatalon_03_Login_PropertyReader {

    @Description("Verify that user is able to login with valid credentials")
    @Test
    public void test_katalon_loginwithvalidcredentials() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get(PropertiesReader.readKey("katalon_login_url"));
        driver.manage().window().maximize();
        driver.findElement(By.id("txt-username")).sendKeys(PropertiesReader.readKey("katalon_username"));
        driver.findElement(By.id("txt-password")).sendKeys(PropertiesReader.readKey("katalon_password"));
        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), PropertiesReader.readKey("katalon_app_form_url"));

        driver.quit();
    }

    @Description("Verify that error message is displayed for invalid credentials")
    @Test
    public void test_katalon_loginwithinvalidcredentials() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get(PropertiesReader.readKey("katalon_login_url"));
        driver.manage().window().maximize();
        driver.findElement(By.id("txt-username")).sendKeys(PropertiesReader.readKey("katalon_invalid_username"));
        driver.findElement(By.id("txt-password")).sendKeys(PropertiesReader.readKey("katalon_invalid_password"));
        driver.findElement(By.id("btn-login")).click();
        WebElement error_msg_ele=driver.findElement(By.xpath("//p[@class='lead']/following::p"));
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOf(error_msg_ele));

        String exp_error_msg="Login failed! Please ensure the username and password are valid.";
        String act_error_msg=error_msg_ele.getText();

        Assert.assertEquals(act_error_msg, exp_error_msg);

        driver.quit();
    }
}
