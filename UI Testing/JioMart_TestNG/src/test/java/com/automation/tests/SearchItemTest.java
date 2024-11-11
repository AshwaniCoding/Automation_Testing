package com.automation.tests;

import com.automation.utils.DriverManager;
import com.automation.utils.ExcelUtils;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchItemTest extends BaseTest{

    @Test(dataProvider = "getItemNames")
    public void verifyFindsTheSearchedItem(String itemName){

        homePage.openWebsite();
        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.searchItem(itemName);

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(productsPage.isProductsPageDisplayed());

        Allure.addAttachment("screenshot", DriverManager.takeScreenshot());
        Assert.assertTrue(productsPage.isSearchedItemDisplayed(itemName));

    }

    @DataProvider
    public Object[] getItemNames(){
        ExcelUtils excelUtils = new ExcelUtils("items.xlsx");
        List<List<String>> tableData = excelUtils.getData();
        Object[] itemName = new Object[tableData.size()];

        for (int i =0;i<tableData.size();i++){
            List<String> rowData = tableData.get(i);
            for (int j =0;j<rowData.size();j++){
                itemName[i] = rowData.get(j);
            }
        }
        return itemName;
    }

}
