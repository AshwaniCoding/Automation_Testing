package com.automation.steps;

import com.automation.pages.ItemPage;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;

public class ItemSteps {

    ItemPage itemPage = new ItemPage();

    @Then("verify user is on item page")
    public void verifyUserIsOnItemPage() {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(itemPage.isItemPageDisplayed());
    }

    @When("user click on add to cart button")
    public void userClickOnAddToCartButton() {
        itemPage.clickOnAddToCartBtn();
    }

    @Then("verify cart quantity is {string}")
    public void verifyCartQuantityIs(String cartQuantity) {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertEquals(cartQuantity, itemPage.getCartQuantity());
    }

    @When("user click on view button")
    public void userClickOnViewButton() {
        itemPage.clickOnViewCartBtn();
    }

}
