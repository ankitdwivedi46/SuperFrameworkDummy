package org.template.framework.FrontEnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.template.framework.FrontEnd.Enums.Browsers;
import org.template.framework.Utility.Annotation.Author;

/*
For Driver Factory -> Using factory desing pattern, based on browser different Web Driver setup happen using switch case
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class DriverFactory {

    public static WebDriver createWebDriver(Browsers browser){

        return switch (browser){

            case CHROME -> createChromeDriver();
            case EDGE -> createEdgeDriver();
            case SAFARI -> createSafariDriver();
            case FIREFOX -> createFireFoxDriver();

        };
    }

    public static WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver createEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public static WebDriver createSafariDriver(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    public static WebDriver createFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
