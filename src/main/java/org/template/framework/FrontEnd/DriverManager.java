package org.template.framework.FrontEnd;

import org.openqa.selenium.WebDriver;
import org.template.framework.FrontEnd.Enums.Browsers;
import org.template.framework.Utility.Annotation.Author;

/*
SingleTon desing pattern to make sure only one instance of driver is there and not multiple
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(Browsers browser){
        if(driver == null){
            driver = DriverFactory.createWebDriver(browser);
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
