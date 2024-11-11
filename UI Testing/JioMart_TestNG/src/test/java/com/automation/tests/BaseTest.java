package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ItemPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ItemPage itemPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp(){
        DriverManager.createDriver();
        ConfigReader.initConfig();
        homePage = new HomePage();
        productsPage = new ProductsPage();
        itemPage = new ItemPage();
        cartPage = new CartPage();
    }

    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }

}
