package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()='Electronics']")
    WebElement electronicsNavLink;

    @FindBy(xpath = "//a[text()='Mobiles & Tablets']")
    WebElement mobilesAndTabletsLink;

    @FindBy(xpath = "//img[@class='banner_img animation_img']")
    WebElement bannerImage;

    @FindBy(xpath = "//input[contains(@class,'search_input')]")
    WebElement searchInput;

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean isHomePageDisplayed() {
        try{
            return bannerImage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void hoverToElectronicsAndClickOnMobilesAndTablets() {
        actions.moveToElement(electronicsNavLink).pause(1000).click(mobilesAndTabletsLink).build().perform();
    }

    public void searchItem(String itemName) {
        searchInput.sendKeys(itemName + Keys.ENTER);
    }
}
