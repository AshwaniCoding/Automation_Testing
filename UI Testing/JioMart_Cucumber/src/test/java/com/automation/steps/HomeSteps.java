package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user open website")
    public void userOpenWebsite(){
        homePage.openWebsite();
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user hover to electronics link and click on mobiles and tablets")
    public void userHoverToElectronicsLinkAndClickOnMobilesAndTablets() {
        homePage.hoverToElectronicsAndClickOnMobilesAndTablets();
    }

    @When("user search for an {string}")
    public void userSearchForAn(String itemName) {
        homePage.searchItem(itemName);
    }
}
