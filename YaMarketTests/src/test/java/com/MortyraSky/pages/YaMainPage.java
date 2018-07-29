package com.MortyraSky.pages;

import com.MortyraSky.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
Проверить навигацию. Открыть яндекс,
нажать на видео, картинки, новости, карты, маркет, переводчик, музыка.
 */

public class YaMainPage {
    public YaMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = "a.logo:nth-child(1)")
    private WebElement linkTitle;


    public String getAttributeHref(WebElement element){
        String href = element.getAttribute("href");
        System.out.println("Href of element " + href);
        return href;
    }


    public void goToYa(){
        System.out.println("Переход на яндекс, кликнув по: " + linkTitle.getText());
        linkTitle.click();
    }

    public boolean goToPage(By locator, String pageTitle){
        String currentURL,currentTitle, hrefElements;
        boolean addresCompareRes, titleCompareRes, resuleNavigate;
        int time = 3;


        WebElement element = driver.findElement(locator);
        hrefElements = getAttributeHref(element);

        element.click();
        BaseTest.waitForElements(time);

        currentURL = driver.getCurrentUrl();
        currentTitle = driver.getTitle();

        System.out.println("Current URL and Title page is: " + currentURL + " : " +  currentTitle);

        addresCompareRes= addressesMatched(hrefElements, currentURL);
        titleCompareRes = titleMatched(pageTitle, currentTitle);
        if(addresCompareRes == titleCompareRes == true)
            resuleNavigate = true;
        else
            resuleNavigate =false;


        driver.navigate().back();

        return resuleNavigate;


    }

    public boolean addressesMatched(String href, String currentURL){
        return currentURL.contains(href);
    }

    public boolean titleMatched(String pageTitle, String currentTitle){
        return currentTitle.contains(pageTitle);
    }
}
