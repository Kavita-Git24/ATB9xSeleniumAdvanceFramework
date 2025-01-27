package com.SeleniumTesting.pages.pageObjectModel.katalonCare.normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Page Locator
    private By username=By.id("txt-username");
    private By password=By.id("txt-password");
    private By Btnlogin=By.id("btn-login");
    private By error_msg=By.xpath("//p[@class='lead']/following::p");

    //Page Actions
    public String loginToKatalonLoginInvalidCreds(String user,String pwd) {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(Btnlogin).click();

        WebElement error_msg_ele=driver.findElement(error_msg);
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOf(error_msg_ele));
        String act_error_msg=error_msg_ele.getText();
        return act_error_msg;
    }

    public String loginToKatalonLoginValidCreds(String user,String pwd) throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(Btnlogin).click();

        Thread.sleep(3000);
        String url_app=driver.getCurrentUrl();
        return url_app;
    }

}
