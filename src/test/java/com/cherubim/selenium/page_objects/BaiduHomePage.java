package com.cherubim.selenium.page_objects;

import com.cherubim.selenium.DriverBase;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * 百度
 */
public class BaiduHomePage {

    private final RemoteWebDriver driver = DriverBase.getDriver();

    private Query searchBar = new Query(By.name("wd"), driver);
    private Query baiduSearch = new Query(By.id("su"), driver);

    public BaiduHomePage() throws Exception {
    }

    public BaiduHomePage enterSearchTerm(String searchTerm) {
        searchBar.findWebElement().clear();
        searchBar.findWebElement().sendKeys(searchTerm);

        return this;
    }

    public BaiduHomePage submitSearch() {
        baiduSearch.findWebElement().click();

        return this;
    }

}