package com.MortyraSky.Manage;

import com.MortyraSky.pages.SearchResultPage;
import com.MortyraSky.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InitializeDeleteDriver {

    public static WebDriver driver;
    public static SearchPage searchPage;
    public static SearchResultPage searchResultPage;
    

    @BeforeClass
    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://ya.ru");

    }   
    
        
    @AfterClass
    public static void tearDown() {      

        driver.quit();
    }

}
