package com.MortyraSky.tests;

import com.MortyraSky.Manage.ControlDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends ControlDriver {



    @Test
    public void SearchTest() {
        
        String URL = "https://yandex.ru";
        String city1 = "Роттердам";
        String city2 = "Лос-Анджелес";
        String countMoreLinkC1;
        String countMoreLinkC2;

        mainPageTest.navigate(URL);
        mainPageTest.clickLocationLink();

        locationPageTest.setInputLocationField(city1);
        locationPageTest.takeCityInList();

        mainPageTest.clickTabMoreLink();
        countMoreLinkC1 = mainPageTest.countMoreLinks(city1);
        mainPageTest.clickTabMoreLink();

        mainPageTest.clickLocationLink();

        locationPageTest.setInputLocationField(city2);
        locationPageTest.takeCityInList();

        mainPageTest.clickTabMoreLink();
        countMoreLinkC2 = mainPageTest.countMoreLinks(city2);
        mainPageTest.clickTabMoreLink();

        Assert.assertTrue(countMoreLinkC1.contains(countMoreLinkC2));


    }

}
