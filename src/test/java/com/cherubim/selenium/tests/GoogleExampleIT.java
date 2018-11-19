package com.cherubim.selenium.tests;

import com.cherubim.selenium.DriverBase;
import com.cherubim.selenium.page_objects.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Google test
 */
public class GoogleExampleIT extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    @Test
    public void googleCheeseExample() throws Exception {
        // 创建 WebDriver instance

        WebDriver driver = getDriver();

        // 访问 Google
        driver.get("http://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage();

        // title
        System.out.println("Page title is: " + driver.getTitle());

        googleHomePage.enterSearchTerm("google")
            .submitSearch();

        //等待加载, 超时时间 10s
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith("Cheese"));

        // 搜索页title
        System.out.println("Page title is: " + driver.getTitle());
    }

}