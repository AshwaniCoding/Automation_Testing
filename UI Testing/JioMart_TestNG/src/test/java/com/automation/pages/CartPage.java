package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//h1")
    WebElement myCartText;

    @FindBy(xpath = "//span[@aria-label='icon IcMinus']//ancestor::button")
    WebElement removeItemBtn;

    @FindBy(xpath = "//div[contains(@class,'emptycart-title')]")
    WebElement emptyCartTitle;

    public boolean isCartPageDisplayed() {
        try{
            return myCartText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnRemoveItemBtn() {
        removeItemBtn.click();
    }

    public String getCartText() {
        return emptyCartTitle.getText();
    }
}
