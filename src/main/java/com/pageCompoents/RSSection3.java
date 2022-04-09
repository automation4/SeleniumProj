package com.pageCompoents;

import com.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RSSection3 extends AbstractComponents {
    WebDriver driver;
    private By table = By.xpath("//table[@id='product'])[1]//tbody");
    private By totalprice = By.xpath("(//table[@id='product'])[1]//tr/td[3]");
    private By allcources = By.xpath("(//table[@id='product'])[1]//tr/td[2]");
    private By hide = By.xpath("//input[@value='Hide']");
    private By hiddedelement = By.xpath("//input[@name='show-hide']");


    public RSSection3(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
        this.driver = driver;
    }

    public void getallCourses(){
        List<WebElement> a = findElements(allcources);
        for(WebElement e : a){
            System.out.println(e.getText());
        }
    }

    public void getTotalPrice(){
        int total=0;
        List<WebElement> a = findElements(totalprice);
      for(WebElement e : a){
          total = total + Integer.parseInt(e.getText());
      }
        System.out.println(total);
    }

    public void hideElement(){
        boolean flag = false;
       findElement(hide).click();
       if(!findElement(hiddedelement).isDisplayed()){
           System.out.println("element is hidden successfully");
       }

    }
}
