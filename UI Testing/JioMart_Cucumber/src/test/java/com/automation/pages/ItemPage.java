package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends BasePage{

    @FindBy(xpath = "//button[text()='Add to Cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[contains(@class,'counter-number')]")
    WebElement cartQuantity;

    @FindBy(css = "button#btn_minicart")
    WebElement cartBtn;

    @FindBy(id = "view_cart_link")
    WebElement viewCartBtn;

    @FindBy(css = "#minicart_proceed")
    WebElement proceedToCartBtn;

    public boolean isItemPageDisplayed() {
        try{
            return addToCartBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }

    public String getCartQuantity() {
        wait.until(ExpectedConditions.visibilityOf(cartQuantity));
        return cartQuantity.getText();
    }

    public void clickOnViewCartBtn() {
        viewCartBtn.click();
    }

//    public void hoverOnCartBtnAndclickOnProceedToCartBtn() {
//        Point point = cartBtn.getLocation();
//        System.out.println(point.getX()-2);
//        System.out.println(point.getY()+1);
//        actions.moveByOffset(point.getX(),point.getY()).click().perform();
////        actions.moveToElement(cartBtn).pause(2000).click(proceedToCartBtn).build().perform();
//    }
}
