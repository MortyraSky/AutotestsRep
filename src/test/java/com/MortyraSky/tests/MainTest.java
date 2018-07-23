package com.MortyraSky.tests;

import com.MortyraSky.pages.LocationPage;
import com.MortyraSky.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {


    public MainPage mainPage;
    public LocationPage locationPage;

    final String city1 = "Роттердам";
    final String city2 = "Лос-Анджелес";



    @Test
    public void SearchTest() {
        
        String URL = "https://yandex.ru";

        int countMoreLinkC1;
        int countMoreLinkC2;
        mainPage = new MainPage(driver);
        locationPage= new LocationPage(driver);

        mainPage.navigate(URL);

        mainPage.clickLocationLink();
        locationPage.changeLocation(city1);
        countMoreLinkC1 = mainPage.getCountMoreLinks(city1);

        mainPage.clickLocationLink();
        locationPage.changeLocation(city2);
        countMoreLinkC2 = mainPage.getCountMoreLinks(city2);

        Assert.assertEquals(countMoreLinkC1, countMoreLinkC2);


    }

}
