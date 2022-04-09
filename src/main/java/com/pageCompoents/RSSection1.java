package com.pageCompoents;

import com.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class RSSection1 extends AbstractComponents {
    //achieving encapluation in page cases making members as private

    WebDriver driver;
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private By radiogroup = By.xpath("//legend[.='Radio Button Example']/following-sibling::label/input[@name='radioButton']");
    private By countrysuggestion = By.xpath("//input[@id='autocomplete']");
    private By getCountrysuggestion = By.xpath("//ul[@id='ui-id-1']/li");
    private By dropdown = By.xpath("//select[@id='dropdown-class-example']");
    private By checkbox = By.xpath("//div[@id='checkbox-example']//input[@type='checkbox']");


    public RSSection1(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        this.driver = driver;
    }

    public RSSection1 selectRadio(String radiotoselect) {
        List<WebElement> radiolist = findElements(radiogroup);
        for (WebElement element : radiolist) {
            if (element.getAttribute("value").equalsIgnoreCase(radiotoselect)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public RSSection1 selectcountry(String countrytoselect) throws InterruptedException {
        findElement(countrysuggestion).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> countrylist = findElements(getCountrysuggestion);
        for (WebElement element : countrylist) {
            if (element.getText().equalsIgnoreCase(countrytoselect)) {
                element.click();
            }
        }
        return this;
    }

    public RSSection1 selectDropdown(String valuetoselect) {
        Select sel = new Select(findElement(dropdown));
        List<WebElement> ListOptions = sel.getOptions();
        for (WebElement element : ListOptions) {
            if (element.getText().equalsIgnoreCase(valuetoselect)) {
                element.click();
            }
        }
        return this;
    }

   public RSSection1 selectCheckbox(String valuetoselect) {
        List<WebElement> checkboxlist = findElements(checkbox);
        for (WebElement element : checkboxlist) {
            if (element.getAttribute("value").equalsIgnoreCase(valuetoselect)) {
                element.click();
            }
        }
        return this;
    }

}
