package org.template.framework.FrontEnd.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.template.framework.Utility.Annotation.Author;

/*
Strategy based pattern
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public interface SeleniumWaits {

    WebDriverWait waitForElement(WebDriver driver, long seconds);

}
