package com.pageCompoents;

import com.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RSSection4 extends AbstractComponents {
    WebDriver driver;
    private By button = By.xpath("//button[@id='mousehover']");
    private By mousehover = By.xpath("//div[@class='mouse-hover-content']/a");

    public RSSection4(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
        this.driver = driver;
    }


    public void doMouseHover(){

        Actions act = new  Actions(driver);
        act.moveToElement(findElement(button)).build().perform();

    }

    public void getMouseHoverdetails(){
        System.out.println(findElement(mousehover).getText());


    }


}
