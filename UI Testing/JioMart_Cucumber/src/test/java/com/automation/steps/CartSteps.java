package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @When("user click on remove item button")
    public void userClickOnRemoveItemButton() {
        cartPage.clickOnRemoveItemBtn();
    }

    @Then("verify cart page displays {string}")
    public void verifyCartPageDisplays(String cartText) {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertEquals(cartText,cartPage.getCartText());
    }

}
