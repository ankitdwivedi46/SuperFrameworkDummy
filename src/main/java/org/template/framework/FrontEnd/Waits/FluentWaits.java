package org.template.framework.FrontEnd.Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.template.framework.Utility.Annotation.Author;

import java.time.Duration;
import java.util.List;

/*
Strategy based pattern
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class FluentWaits implements SeleniumWaits{

    @Override
    public WebDriverWait waitForElement(WebDriver driver, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitForElementToBeVisible(WebDriver driver, long seconds, WebElement element){
        return waitForElement(driver,seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementsToBeVisible(WebDriver driver, long seconds, List<WebElement> elements){
        return waitForElement(driver,seconds).until(ExpectedConditions.visibilityOf(elements.get(0)));
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, long seconds, WebElement element){
        return waitForElement(driver,seconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementsToBeClickable(WebDriver driver, long seconds, List<WebElement> elements){
        return waitForElement(driver,seconds).until(ExpectedConditions.elementToBeClickable(elements.get(0)));
    }

    public boolean waitForUrlToContains(WebDriver driver, long seconds, String path){
        return waitForElement(driver,seconds).until(ExpectedConditions.urlContains(path));
    }

}
