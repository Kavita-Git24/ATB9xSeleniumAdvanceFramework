package com.SeleniumTesting.pages.pageObjectModel.vwo.improved_pom;

import com.SeleniumTesting.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPages {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Page Actions
    public String loggedInUserName(){
        visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
