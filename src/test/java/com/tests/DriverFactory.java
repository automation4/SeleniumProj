package com.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final DriverFactory instance = new DriverFactory();  // no other class can override
    private DriverFactory() { }
    public static DriverFactory getInstance() { return instance; }   //this point we have achieved Singleton pattern
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public WebDriver createBrowser(BrowserType type) {      // creating get Driver taking enum in parameter

            switch (type) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
                    threadLocal.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
                    threadLocal.set(new FirefoxDriver());
                default:
                    break;
            }

        return threadLocal.get();
    }

    public void closeBrowser() {
        threadLocal.get().close();
        threadLocal.remove();
    }
}


