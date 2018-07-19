package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 18.07.2018.
 */
public class SearchResultPage {

    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@role='main']/descendant::h2[1]/a")
    private WebElement headerLink;

    public String getTextLink(){

        String takeTextLink  = headerLink.getText();
        return takeTextLink;
    }

}
