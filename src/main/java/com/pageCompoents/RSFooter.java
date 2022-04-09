package com.pageCompoents;

import com.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class RSFooter extends AbstractComponents {
    By footer = By.xpath("//table[@class='gf-t']");
    private List<WebElement> links;
    WebDriver driver;

    public RSFooter(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }
    public void countlink(){
        links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links : " +links.size());
    }

    public void brokenLinks() throws IOException {
       for(WebElement link : links){
           String URL = link.getAttribute("href");

           verifyURL(URL);
       }
    }
}
