package com.pageObjects;

import com.pageCompoents.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RahulShettyHomePage {
/*setting scope level members in main page and pass to page when calling*/
    By section1 = By.xpath("//h1[.='Practice Page']/following::div[1]");
    By section2 = By.xpath("//div[@class='block large-row-spacer'][2]");
    By section3 = By.xpath("//div[@class='block large-row-spacer'][3]");
    By section4 = By.xpath("//div[@class='block large-row-spacer'][4]");
    By framesection = By.xpath("//div[@class='block large-row-spacer'][4]");
    By footersection = By.cssSelector("div[class*='top_agile_w3ls'])");

    WebDriver driver;
    public RahulShettyHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RSSection1 getRSSection1() throws IOException {
        return new RSSection1(driver,section1);
    }
    public RSSection2 getRSSection2() throws IOException {
        return new RSSection2(driver,section2);
    }
    public RSSection3 getRSSection3() throws IOException {
        return new RSSection3(driver,section3);
    }
    public RSSection4 getRSSection4() throws IOException {
        return new RSSection4(driver,section4);
    }
    public RSSection5 getRSSection5() throws IOException {
        return new RSSection5(driver,framesection);
    }
    public RSFooter getfooter() throws IOException {
        return new RSFooter(driver,footersection);
    }
}
