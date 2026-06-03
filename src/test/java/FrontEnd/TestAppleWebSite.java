package FrontEnd;

import org.template.framework.FrontEnd.BaseClass;
import org.template.framework.FrontEnd.Pages.HomePage;
import org.template.framework.FrontEnd.Pages.Iphone17Page;
import org.template.framework.FrontEnd.Pages.IphonePage;
import org.template.framework.Utility.Annotation.Author;
import org.testng.annotations.Test;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class TestAppleWebSite extends BaseClass {

    @Test
    public void testAppleWebsite(){

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAppleSite("https://www.apple.com/in/").verifyAppleLogo().clickOnIphoneLink("/iphone");

        IphonePage iphonePage = new IphonePage(driver);
        iphonePage.verifyAllProducts().clickIphone17Pro("/iphone-17-pro/");

        Iphone17Page iphone17Page = new Iphone17Page(driver);
        iphone17Page.verifyIfBuyButtonIsDisplayed();

    }

}
