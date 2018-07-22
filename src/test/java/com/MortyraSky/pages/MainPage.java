package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Admin on 23.07.2018.
 */
public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@class='row']/descendant::div[1]/a")
    protected WebElement locationLink;
    // WebElement inputField = driver.findElement(By.cssSelector("input[name='text']"));

    @FindBy(xpath = "//*[@class='home-tabs__more-item']")
    protected List<WebElement> moreLinks;

    @FindBy(xpath = "//a[@data-statlog='tabs.more']")
    protected WebElement tabMoreLink;

    //List <WebElement> moreLinks = driver.findElements(By.xpath("//*[@class='home-tabs__more-item']"));



}
