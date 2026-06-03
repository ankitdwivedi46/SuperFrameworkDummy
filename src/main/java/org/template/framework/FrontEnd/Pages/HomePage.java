package org.template.framework.FrontEnd.Pages;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.template.framework.FrontEnd.Waits.ExplicitWaits;
import org.template.framework.Utility.Annotation.Author;
import org.template.framework.Utility.FrontEnd.FrontEndUtils;

/*
Page Factory Pattern
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class HomePage {

    private WebDriver driver;
    private ExplicitWaits explicitWaits;

    @FindBy(xpath = "//a[@aria-label='Apple']")
    private WebElement appleLogo;

    @FindBy(partialLinkText = "iPhone")
    private WebElement iphoneLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.explicitWaits = new ExplicitWaits();
        PageFactory.initElements(driver,this);
    }

    public HomePage navigateToAppleSite(String url){
        driver.get(url);
        return this;
    }

    public HomePage verifyAppleLogo(){
        explicitWaits.waitForElementToBeVisible(driver,10,appleLogo);
        appleLogo.isDisplayed();
        return this;
    }

    public HomePage clickOnIphoneLink(String path){
        explicitWaits.waitForElementToBeClickable(driver,10,iphoneLink);
        iphoneLink.click();
        MatcherAssert.assertThat(FrontEndUtils.verifyNewPageUrl(driver,10,path),Matchers.equalTo(true));
        return this;
    }

}
