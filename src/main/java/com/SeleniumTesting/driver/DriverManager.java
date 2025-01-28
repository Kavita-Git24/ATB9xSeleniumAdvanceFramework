package com.SeleniumTesting.driver;

import com.SeleniumTesting.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
   public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    // When we want to start the browser
    public static void init() {
        String browser= PropertiesReader.readKey("browser");
        browser=browser.toLowerCase();
        if(driver==null)
        {
            switch (browser){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "firefox":
                    FirefoxOptions FirefoxOptions = new FirefoxOptions();
                    FirefoxOptions.addArguments("--start-maximized");
                    FirefoxOptions.addArguments("--guest");
                    driver = new FirefoxDriver(FirefoxOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--guest");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                default:
                    System.out.println("Browser Not Found!!");
            }
        }
    }

    public static void down(){
        if(driver!=null) {
            driver.quit();
            driver = null;
        }

    }
}
