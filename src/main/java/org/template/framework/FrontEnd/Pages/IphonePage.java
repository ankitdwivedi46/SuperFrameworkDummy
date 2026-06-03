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

import java.util.List;

/*
Page Factory Pattern
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class IphonePage {

    private WebDriver driver;
    private ExplicitWaits explicitWaits;

    @FindBy(xpath = "//ul[@class='product-list']//a")
    private List<WebElement> productsList;

    @FindBy(xpath = "//ul[@class='product-list']//a//p")
    private List<WebElement> productsListText;

    @FindBy(xpath = "//a[@href='https://www.apple.com/in/iphone-17-pro/']")
    private WebElement iphoneSeventeenLink;

    public IphonePage(WebDriver driver){
        this.driver = driver;
        this.explicitWaits = new ExplicitWaits();
        PageFactory.initElements(driver,this);
    }

    public IphonePage verifyAllProducts(){
        explicitWaits.waitForElementsToBeClickable(driver,10,productsList);
        MatcherAssert.assertThat(productsList.size(), Matchers.equalTo(9));
        return this;
    }

    public IphonePage clickIphone17Pro(String path){
        for(int i = 0; i < productsListText.size(); i++){
            if(productsListText.get(i).getText().toLowerCase().contains("iphone 17 pro")){
                productsListText.get(i).click();
                MatcherAssert.assertThat(FrontEndUtils.verifyNewPageUrl(driver,10,path),Matchers.equalTo(true));
                return this;
            }
        }
        return this;
    }

}
