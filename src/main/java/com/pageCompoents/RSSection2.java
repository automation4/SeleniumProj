package com.pageCompoents;

import com.abstractComponents.AbstractComponents;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Set;

public class RSSection2 extends AbstractComponents {
    WebDriver driver;
    private By windowbtn = By.xpath("//button[@id='openwindow']");
    private By Alerttexbox = By.xpath("(//legend[.='Switch To Alert Example']/following-sibling::input)[1]");
    private By Alertbtn = By.xpath("(//legend[.='Switch To Alert Example']/following-sibling::input)[2]");
    private By Alertconfirmbtn = By.xpath("(//legend[.='Switch To Alert Example']/following-sibling::input)[3]");

    public RSSection2(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
        this.driver = driver;
    }

    public RSSection2 switchBetweenWindows() {
        String mainwindow = driver.getWindowHandle();
        String childwindow =null;
        findElement(windowbtn).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowhandle : allWindowHandles)
            if (!mainwindow.equalsIgnoreCase(windowhandle)) {
                childwindow = windowhandle;
                }
        driver.switchTo().window(childwindow);
        driver.switchTo().window(mainwindow);

        if (findElement(By.xpath("//h1[.='Practice Page']")).isDisplayed()) {
            System.out.println("User is back for Parent page");
            }
        return this;
    }


    public RSSection2 switchToAlretcheck(String name){
        findElement(Alerttexbox).sendKeys(name);
        driver.findElement(Alertbtn).click();
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        System.out.println(alertmessage);
        alert.accept();

        return this;
        }



    }
