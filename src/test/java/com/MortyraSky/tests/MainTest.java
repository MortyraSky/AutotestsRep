package com.MortyraSky.tests;

import com.MortyraSky.pages.SearchResultPage;
import com.MortyraSky.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;       

public class MainTest {

    private static WebDriver driver;
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
        driver.get("https://ya.ru");

    }

    @Test
    public void SearchPageTest() {
        String query = "погода пенза";

        searchPage.queryInInputField(query);
        searchPage.clickFindButton();
       
    }

    @Test
    public void SearchResultPageTest(){
        String wordInQuery = "Погода";
        String textLink = searchResultPage.getTextLink();
        Assert.assertTrue(textLink.contains(wordInQuery));
    }
    
        
    @AfterClass
    public static void tearDown() {      

        driver.quit();
    }

}
