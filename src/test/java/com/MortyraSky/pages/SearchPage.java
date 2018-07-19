package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 18.07.2018.
 */
public class SearchPage {

    public SearchPage(WebDriver driver){

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    public WebDriver driver;


    @FindBy(css = "input[name='text']")
    private WebElement inputField;

    @FindBy(css = "button[type='submit']")
    private WebElement findBtn;

    public void queryInInputField(String query) {
        inputField.sendKeys(query);
    }

     public void clickFindButton(){
        findBtn.click();
     }

     public void navigate(String URL){
         driver.get(URL);
     }

}
