package com.MortyraSky.tests;

import com.MortyraSky.pages.LocationPage;
import com.MortyraSky.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MainTest extends BaseTest {


    public MainPage mainPage;
    public LocationPage locationPage;

    final String CITY1 = "Роттердам";
    final String CITY2 = "Лос-Анджелес";
    final String URL = "https://yandex.ru";

    @Test
    public void SearchTest() {
        


        ArrayList<String> moreLinkCity1;
        ArrayList<String> moreLinkCity2;
        
        mainPage = new MainPage(driver);
        locationPage= new LocationPage(driver);

        mainPage.navigate(URL);

        mainPage.clickLocationLink();
        locationPage.changeLocation(CITY1);
        moreLinkCity1 = mainPage.getCountMoreLinks(CITY1);

        mainPage.clickLocationLink();
        locationPage.changeLocation(CITY2);
        moreLinkCity2 = mainPage.getCountMoreLinks(CITY2);

        for (int i = 0; i < moreLinkCity1.size(); i++) {
            Assert.assertEquals(moreLinkCity1.get(i), moreLinkCity2.get(i));

        }

    }

}
