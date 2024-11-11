package com.automation.steps;

import com.automation.pages.ProductsPage;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;

public class ProductsSteps {

    ProductsPage productsPage = new ProductsPage();

    @Then("verify user is on products page")
    public void verifyUserIsOnProductsPage() {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }

    @When("user click on first item")
    public void userClickOnFirstItem() {
        productsPage.clickOnFirstItem();
    }

    @Then("verify user get the same {string} in search")
    public void verifyUserGetTheSameInSearch(String itemName) {
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(productsPage.isSearchedItemDisplayed(itemName));
    }
}
