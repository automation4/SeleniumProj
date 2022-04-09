package com.tests;
import com.aventstack.extentreports.ExtentTest;
import com.pageObjects.RahulShettyHomePage;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;

@Listeners(RahulListener.class)
public class RahulshettyAcademyTests extends TestBase{
    ExtentTest test;

/*    @Test(groups = {"regression", "smoke"})
    public void rahulShettySection1() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh = new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection1().selectRadio("Radio2").selectcountry("India").selectDropdown("Option1").selectCheckbox("Option2");
        Thread.sleep(5000);
    }*/


    @Test(groups = "smoke")
    public void rahulShettySection1Radio() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh = new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection1().selectRadio("Radio2");
        Thread.sleep(5000);
    }

    @Test(groups = "smoke")
    public void rahulShettySection1Country() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh = new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection1().selectcountry("India");
        Thread.sleep(5000);
        System.out.println("Country selected3");
    }

    @Test(groups = "smoke")
    public void rahulShettySection1Dropdown() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh = new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection1().selectDropdown("Option1").selectCheckbox("Option2");
        Thread.sleep(5000);
    }
    @Test(groups = "regression")
    public void rahulShettySection1Checkbox() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh = new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection1().selectCheckbox("Option2");
        Thread.sleep(5000);
    }
    @Test(invocationCount = 2, dataProvider = "getData",groups = "regression")
    public void rahulShettySection2windowhandler() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh= new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection2().switchBetweenWindows();
        Thread.sleep(5000);
    }

    @Parameters({"Test"})
    @Test(invocationCount = 2, dataProvider = "getData",groups = "regression")
    public void rahulShettySection2Alert(String data) throws IOException, InterruptedException {
        RahulShettyHomePage  rsh= new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection2().switchToAlretcheck(data);
        Thread.sleep(5000);
    }

    @Test(groups = "regression")
    public void rahulShettySection3CoursesAndPrice() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh= new RahulShettyHomePage(driver);
       driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection3().getallCourses();
        rsh.getRSSection3().getTotalPrice();
        Thread.sleep(5000);
    }

    @Test(groups = "regression")
    public void rahulShettySection3HideElement() throws IOException, InterruptedException {
        RahulShettyHomePage  rsh= new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection3().hideElement();
        Thread.sleep(5000);
    }

    @Test(groups = "sanity")
    public void rahulShettySection4() throws IOException, InterruptedException {
       RahulShettyHomePage  rsh= new RahulShettyHomePage(driver);
       driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection4().doMouseHover();
        rsh.getRSSection4().getMouseHoverdetails();
    }


    @Test(groups = "sanity")
    public void frameCheck() throws IOException, InterruptedException {
       RahulShettyHomePage  rsh= new RahulShettyHomePage(driver);
        driver.get(Utils.getInstance().getdata("testurl1"));
        rsh.getRSSection5().verifyswitchtoframe();

    }

    @Test(dataProvider = "logindata",groups = "sanity")
    public void LoginIQVIA(String user, String pass) throws IOException, InterruptedException {
        driver.get(Utils.getInstance().getdata("testurl3"));
        driver.findElement(By.xpath(Utils.getInstance().getlocator("username"))).sendKeys(user);
        driver.findElement(By.xpath(Utils.getInstance().getlocator("password"))).sendKeys(pass);
        driver.findElement(By.xpath(Utils.getInstance().getlocator("loginbtn"))).click();
        Thread.sleep(5000);
    }

     @DataProvider(name = "logindata")
    public Object[][] getData() throws IOException {
         Object[][] getData1= Utils.getInstance().getExcelData("CI", "Intake supervisor");
         return getData1;
     }

}
