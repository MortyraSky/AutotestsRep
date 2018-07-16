package com.MortyraSky;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

        /*
             UPD
             если определить и найти локатор на одной странице и
             попытаться использовать его на другой, при условии что локаторы совпадают
             тесты будут валиться.
             Нужно заводить новые переменные! со значение
          */

public class MainTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru");
    }
    @Test
    public void lookingForWthrFrcst() throws InterruptedException {
        WebElement inputField = driver.findElement(By.cssSelector("input[name='text']"));
        inputField.sendKeys("погода пенза");
        Thread.sleep(1000);
        WebElement findBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        findBtn.click();
        WebElement headerLink = driver.findElement(By.cssSelector("a[href*='pogoda/penza?'] > .organic__url-text"));
        String takeTextLink  = headerLink.getText();

        Assert.assertTrue(takeTextLink.contains("Погода"));


    }

    @Test
    public static void setClearInputFld(){
        WebElement inpFld =  driver.findElement(By.cssSelector("input[name='text']"));
        if (inpFld.isEnabled())
            inpFld.clear();
        else {
            inpFld.click();
            inpFld.clear();
        }


    }
    @AfterClass
    public static void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
