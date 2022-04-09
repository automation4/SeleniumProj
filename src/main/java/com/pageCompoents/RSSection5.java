package com.pageCompoents;

import com.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.ls.LSOutput;

public class RSSection5 extends AbstractComponents {
    WebDriver driver;

    private By frame = By.xpath("//iframe[@id='courses-iframe']");

    public RSSection5(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
        this.driver = driver;
    }


    public void verifyswitchtoframe(){
        driver.switchTo().frame(findElement(frame));
        driver.switchTo().defaultContent();
    }

}


