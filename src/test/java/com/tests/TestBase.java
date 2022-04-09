package com.tests;

import com.pageObjects.RahulShettyHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {
static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        driver = DriverFactory.getInstance().createBrowser(BrowserType.CHROME);
    }


    @AfterMethod(alwaysRun = true)
    public void close() {
       DriverFactory.getInstance().closeBrowser();
    }

}
