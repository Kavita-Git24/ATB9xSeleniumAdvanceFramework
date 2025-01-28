package com.SeleniumTesting.pages.pageObjectModel.katalonCare.improved_pom;

import com.SeleniumTesting.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonToAllPages {
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
        openKatalonLoginUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(Btnlogin);
        presenceOfElement(error_msg);
        return getText(error_msg);
    }

    public String loginToKatalonLoginValidCreds(String user,String pwd)  {
        openKatalonLoginUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(Btnlogin);

        custom_wait();
        return geturl();
    }
}
