package uk.co.cartaxcheck.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.co.cartaxcheck.pages.HomePage;
import uk.co.cartaxcheck.support.World;
import uk.co.cartaxcheck.utilites.TextExtractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarCheckSteps {

    private World helper;
    private HomePage homePage;

    public CarCheckSteps(World helper){
        this.helper = helper;
    }


    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws IOException {
        homePage =  helper.getBasePage().loadApplication();
//        PlateNumReader extratorFactory = new PlateNumReader();
//        List<String> store = extratorFactory.extractRegNumber();
    }

    @When("^I check (\\d+) registration number$")
    public void iCheckRegistrationNumber(Integer noOfCars) throws IOException {
        homePage = homePage.checkRegNumber(noOfCars);
    }

    @Then("^I will get result for (\\d+)$")
    public void iWillGetResult(Integer index) throws IOException, InterruptedException {
        List<String> fromWebSite = homePage.getCarDataFromWebApp();

        List<String> fromOutFile = TextExtractor.extractValues();
        List<String> myList = new ArrayList<String>(Arrays.asList(fromOutFile.get(index).split(",")));

        Assert.assertEquals(myList, fromWebSite);
    }

}
