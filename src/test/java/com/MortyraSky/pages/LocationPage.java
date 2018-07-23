package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 23.07.2018.
 */
public class LocationPage{

    public LocationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    public WebDriver driver;

    @FindBy(css = "input[name='name']")
    private WebElement inputLocationField;


    @FindBy(css = "button[type='submit']")
    private WebElement saveLocationBtn;

    @FindBy(xpath = "//*[@class='popup__content']/descendant::ul/li[1]")
    private WebElement cityInList;

    public void changeLocation(String city){

        inputLocationField.clear();
        inputLocationField.sendKeys(city);
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cityInList.click();
        System.out.println("Поле инпут заполнено: " + city);
    }


}
