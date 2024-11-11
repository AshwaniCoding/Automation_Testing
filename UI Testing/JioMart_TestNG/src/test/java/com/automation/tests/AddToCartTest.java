package com.automation.tests;

import com.automation.utils.DriverManager;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    @Test
    public void verifyUserCanAddAndRemoveItemFromCart(){

        homePage.openWebsite();
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.hoverToElectronicsAndClickOnMobilesAndTablets();

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(productsPage.isProductsPageDisplayed());

        productsPage.clickOnFirstItem();

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(itemPage.isItemPageDisplayed());

        itemPage.clickOnAddToCartBtn();

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertEquals(itemPage.getCartQuantity(),"1");

        itemPage.clickOnViewCartBtn();

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(cartPage.isCartPageDisplayed());

        cartPage.clickOnRemoveItemBtn();

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertEquals(cartPage.getCartText(),"Your Cart is Empty!");

    }

}
