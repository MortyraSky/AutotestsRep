package com.MortyraSky.tests;

import com.MortyraSky.pages.MainPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 23.07.2018.
 */
public class MainPageTest extends MainPage {

    public MainPageTest(WebDriver driver) {
        super(driver);
    }

    public void clickLocationLink(){
        System.out.println("Переход по локатору:" + locationLink.getText());
        locationLink.click();

    }

    public void clickTabMoreLink(){
        System.out.println("Переход по локатору:" + tabMoreLink.getText());
        tabMoreLink.click();

    }

    public String countMoreLinks(String city){
        System.out.println("Количество элементов во вкладке 'ещё' для города : "+ city + " = " + moreLinks.size() );
        String count = "";
        return count += moreLinks.size();
    }

    public void navigate(String URL){
        driver.get(URL);
        System.out.println("Переход на:" + URL);
    }
}
