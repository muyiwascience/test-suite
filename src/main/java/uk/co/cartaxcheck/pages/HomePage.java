package uk.co.cartaxcheck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.cartaxcheck.utilites.PlateNumReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id="vrm-input")
    private WebElement vrmInput = null;

    @FindBy(css="form > button")
    private WebElement formButton = null;

    @FindBy(id = "m")
    private WebElement carDataElement = null;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage checkRegNumber(Integer noOfCars) throws IOException {
        PlateNumReader extratorFactory = new PlateNumReader();
        List<String> store = extratorFactory.extractRegNumber();

        vrmInput.sendKeys(store.get(noOfCars));
        formButton.click();
        return this;
    }

    public List<String> getCarDataFromWebApp() throws InterruptedException {
        Thread.sleep(1000);
        List<String> data = new ArrayList<>();
        int numberOfItems = 1;
        for (WebElement element : carDataElement.findElements(By.cssSelector("div[class*='m-w-']")).get(3).findElements(By.tagName("dd"))){
            if(element.getText() != null && numberOfItems <=5)data.add(element.getText());
            numberOfItems ++;
        }
        System.out.println(data);
        return data;
    }
}
