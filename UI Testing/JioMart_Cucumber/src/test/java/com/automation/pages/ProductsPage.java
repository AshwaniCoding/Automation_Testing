package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[@class='plp-card-image-wrapper']")
    List<WebElement> productsList;

    @FindBy(xpath = "//div[contains(text(),'Category')]")
    WebElement categoryText;

    @FindBy(xpath = "//div[contains(@class,'plp-card-details-name')]")
    List<WebElement> productsNameList;

    @FindBy(xpath = "//div[contains(text(),'Category')]")
    WebElement filtersText;

    @FindBy(xpath = "//span[text()='Sort by:']")
    WebElement sortByText;

    public boolean isProductsPageDisplayed() {
        try{
            return sortByText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnFirstItem() {
        productsList.getFirst().click();
    }

    public boolean isSearchedItemDisplayed(String itemName) {
        int count = 0;
        for (WebElement item : productsNameList){
            if(item.getText().toLowerCase().contains(itemName)){
                count++;
            }
        }
        return count > 0;
    }
}
