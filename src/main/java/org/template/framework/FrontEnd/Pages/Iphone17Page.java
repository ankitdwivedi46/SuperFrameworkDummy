package org.template.framework.FrontEnd.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.template.framework.FrontEnd.Waits.ExplicitWaits;
import org.template.framework.Utility.Annotation.Author;


/*
Page Factory Pattern
*/


@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class Iphone17Page {

    private WebDriver driver;
    private ExplicitWaits explicitWaits;

    @FindBy(partialLinkText = "Buy")
    private WebElement buyBtn;

    public Iphone17Page(WebDriver driver){
        this.driver = driver;
        this.explicitWaits = new ExplicitWaits();
        PageFactory.initElements(driver,this);
    }

    public void verifyIfBuyButtonIsDisplayed(){
        explicitWaits.waitForElementToBeVisible(driver,10,buyBtn);
        buyBtn.isDisplayed();
    }

}
