package org.template.framework.Utility.FrontEnd;

import org.openqa.selenium.WebDriver;
import org.template.framework.FrontEnd.Waits.ExplicitWaits;
import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class FrontEndUtils {

    public static boolean verifyNewPageUrl(WebDriver driver, long second, String path){
        return new ExplicitWaits().waitForUrlToContains(driver,second,path);
    }

}
