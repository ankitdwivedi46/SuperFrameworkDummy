package org.template.framework.FrontEnd;

import org.openqa.selenium.WebDriver;
import org.template.framework.FrontEnd.Enums.Browsers;
import org.template.framework.Utility.Annotation.Author;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
Template Design Pattern -> defines execution flow
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = DriverManager.getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }

}

