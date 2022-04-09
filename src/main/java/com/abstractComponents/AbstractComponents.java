package com.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AbstractComponents {
    WebElement sectionElement;

    public AbstractComponents(WebDriver driver, By sectionElement){
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement findElement(By findElementBy){
        return sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementBy){
        return sectionElement.findElements(findElementBy);
    }

    public void getLinks(){
        }

    public void enterText(String text){
        sectionElement.sendKeys(text);
    }

    public void click(){
        sectionElement.sendKeys(Keys.ENTER);

    }

    public void verifyURL(String linkString) throws IOException {
        int invalidlink =0;
        // storing link in URL class object
         URL url = new URL(linkString);
        //open connection using URL class option and store in HTTPURLConnection obj
        HttpURLConnection urlconnect = (HttpURLConnection) url.openConnection();
        //setting httpurlconnection timeout
        urlconnect.setConnectTimeout(50000);  //50 sec
        //Hit url
        urlconnect.connect();
        //check responsecode
        if (urlconnect.getResponseCode()==200){

        }
        else {
            System.out.println(linkString +":" + urlconnect.getResponseMessage() + ":" + urlconnect.HTTP_NOT_FOUND);
            invalidlink++;
        }

    }

}
