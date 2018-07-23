package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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
    ArrayList<String> elementsMore = new ArrayList<String>();


    @FindBy(xpath = "//*[@class='row']/descendant::div[1]/a")
    private WebElement locationLink;
    // WebElement inputField = driver.findElement(By.cssSelector("input[name='text']"));

    @FindBy(xpath = "//*[@class='home-tabs__more-item']")
    private List<WebElement> moreLinks;

    @FindBy(xpath = "//a[@data-statlog='tabs.more']")
    private WebElement tabMoreLink;

    //List <WebElement> moreLinks = driver.findElements(By.xpath("//*[@class='home-tabs__more-item']"));

    public void clickLocationLink(){

        System.out.println("Переход по локатору:" + locationLink.getText());
        locationLink.click();

    }

    public ArrayList<String> getCountMoreLinks(String city){

        System.out.println("Переход по локатору:" + tabMoreLink.getText());
        tabMoreLink.click();
        System.out.println("Количество элементов во вкладке 'ещё' для города : "+ city + " = " + moreLinks.size() );

        if (!elementsMore.isEmpty())
            elementsMore.clear();

        for(WebElement e : moreLinks) {
            System.out.println(e.getText());
            elementsMore.add(e.getText());

        }
        return elementsMore;

    }

    public void navigate(String URL){
        driver.get(URL);
        System.out.println("Переход на:" + URL);
    }



}
