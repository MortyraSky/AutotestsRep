package com.MortyraSky.Manage;

import com.MortyraSky.tests.LocationPageTest;
import com.MortyraSky.tests.MainPageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class ControlDriver {

    public static WebDriver driver;
    public static MainPageTest mainPageTest;
    public static LocationPageTest locationPageTest;


    

    @BeforeClass
    public static void setDriver(){

        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
        driver = new ChromeDriver();
        mainPageTest = new MainPageTest(driver);
        locationPageTest = new LocationPageTest(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
        
    @AfterClass
    public static void tearDown() {

        driver.quit();
    }

}
