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
    public void lookingForWeatherForecast() throws InterruptedException {
                    
        WebElement inputField = driver.findElement(By.cssSelector("input[name='text']"));
        WebElement findBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        
        if(inputField.isEnabled()){
            inputField.clear();
            inputField.sendKeys("погода пенза");
        }
        else{
            inputField.click();
            inputField.clear();
            inputField.sendKeys("погода пенза");
        }     
                
        findBtn.click();
        
        WebElement headerLink = driver.findElement(By.xpath("//*[@role='main']/descendant::h2[1]/a"));       
        String takeTextLink  = headerLink.getText();
        
        Assert.assertTrue(takeTextLink.contains("Погода"));


    }
    
        
    @AfterClass
    public static void tearDown() {      

        driver.quit();
    }

}
