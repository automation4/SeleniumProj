package utils;

/*
* creating property utils
* */

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utils {

    private static Utils instance = new Utils();
    private Utils(){ }

    public static Utils getInstance() {
        return instance;
    }

    static FileInputStream fis ;// achieved singleton
    static Properties prop;


public String getdata(String key) throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties");
       prop = new Properties();
       prop.load(fis);
    return prop.getProperty(key);
}

    public String getlocator(String key) throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\locators.properties");
        prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }

    public Object[][] getExcelData(String sheetname, String user) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Logindata.xlsx"));
        XSSFSheet sheet = wb.getSheet(sheetname);


        int totalrows = sheet.getPhysicalNumberOfRows();
        int totalcolsms = sheet.getRow(0).getPhysicalNumberOfCells();

       Object[][] data = new Object[totalrows-1][totalcolsms];

       for(int r= 1;r<totalrows;r++){
           XSSFRow row = sheet.getRow(r);
           for(int c = 0; c<totalcolsms;c++){
               XSSFCell cell = row.getCell(c);
               data[r-1][c]= cell.getStringCellValue();
           }
       }
        Object[][] focuseddata;
       if(data.length>1) {
            focuseddata = new Object[data.length - 1][data[0].length - 1];
       }else{
           focuseddata = new Object[data.length][data[0].length - 1];
       }

       for(int r = 0; r<data.length;r++){
           for(int c=0; c<data[0].length;c++){
               if(data[r][c].toString().equalsIgnoreCase(user))
               {
                   focuseddata[0][0] = data[r][c+1];
                   focuseddata[0][1] = data[r][c+2];
                   break;
               }
           }

       }

    return focuseddata;
    }
    static String dateformat = new SimpleDateFormat("YYYY-MM-DD SSSS").format(new Date());

    public String captureScreenshot(String screenName, WebDriver driver) throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\Screenshot\\" + screenName + dateformat + ".png";
        File destination = new File(path);
        FileUtils.copyFile(src, destination);
        return path;
    }


}
