package com.MortyraSky.tests;

import com.MortyraSky.pages.LocationPage;
import com.MortyraSky.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MainTest extends BaseTest {


    public MainPage mainPage;
    public LocationPage locationPage;

    final String city1 = "Роттердам";
    final String city2 = "Лос-Анджелес";

    @Test
    public void SearchTest() {
        
        String URL = "https://yandex.ru";

        ArrayList<String> moreLinkCity1;
        ArrayList<String> moreLinkCity2;
        //List<String> strList = new ArrayList<String>();
        //strList.clear();
        mainPage = new MainPage(driver);
        locationPage= new LocationPage(driver);

        mainPage.navigate(URL);

        mainPage.clickLocationLink();
        locationPage.changeLocation(city1);
        moreLinkCity1 = mainPage.getCountMoreLinks(city1);

        mainPage.clickLocationLink();
        locationPage.changeLocation(city2);
        moreLinkCity2 = mainPage.getCountMoreLinks(city2);

        for (int i = 0; i < moreLinkCity1.size(); i++) {
            Assert.assertEquals(moreLinkCity1.get(i), moreLinkCity2.get(i));

        }

    }

}
