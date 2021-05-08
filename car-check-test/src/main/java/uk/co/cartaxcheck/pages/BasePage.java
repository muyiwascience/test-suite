package uk.co.cartaxcheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.cartaxcheck.utilites.PropFileMgr;

public class BasePage {

    protected   WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage loadApplication(){
        String baseUrl = PropFileMgr.getSettings("base.url");
        driver.navigate().to(baseUrl);
        return PageFactory.initElements(driver, HomePage.class);

    }
}

