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
        
        WebElement findBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        findBtn.click();
        
        WebElement headerLink = driver.findElement(By.cssSelector("a[href*='pogoda/penza?']"));
        String takeTextLink  = headerLink.getText();
        Assert.assertTrue(takeTextLink.contains("Погода"));


    }

    @Test
    public static void setClearInputFld(){
            //очистка поля инпут для будущих тестов!            
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

        driver.quit();
    }

}
