package uk.co.cartaxcheck.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.cartaxcheck.browsers.WebDriverFactory;
import uk.co.cartaxcheck.pages.BasePage;

public class World {

    private static BasePage basePage;
    private static final WebDriver webDriver = WebDriverFactory.getThreadedDriver();

    public BasePage getBasePage(){
        if(basePage != null)return basePage;
        basePage = PageFactory.initElements(webDriver, BasePage.class);
        return basePage;
    }
}

