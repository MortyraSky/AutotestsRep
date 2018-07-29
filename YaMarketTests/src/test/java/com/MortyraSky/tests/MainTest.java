package com.MortyraSky.tests;

import com.MortyraSky.pages.MarketComparePage;
import com.MortyraSky.pages.MarketPage;
import com.MortyraSky.pages.MarketSortPage;
import com.MortyraSky.pages.YaMainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 25.07.2018.
 * после перехода вылазит всплывающее окно
 * разобраться как с ним работать!
 */

public class MainTest extends BaseTest {
    public MarketPage marketPage;
    public MarketSortPage marketSortPage;
    public MarketComparePage marketComparePage;
    public YaMainPage yaMainPage;

    final String URL = "https://market.yandex.ru";
    final String MATCHINTEXT = "Товаров нет";
    final String GOMARKETMAINPAGE = "//a[contains(text(),'Перейти на главную')]"; //  "//*[@class='layout layout_type_maya n-page-compare']/descendant::div/a[2]"
    final String[] titlePages = {"","видео", "Картинки", "Новости", "Карты", "Маркет", "Переводчик", "Музыка"};

    final int TWELVEITEMS = 12;
    final int FORTYEIGHTITEMS = 48;//forty eight
    final int COUNTITEMSTOCOMPARE = 2;
    final int FIRSTITEMINLIST = 0;
    final int SECONDITEMINLIST = 1;

    @Test
    public void marketTest1(){
        marketPage = new MarketPage(driver);
        int countItems;

        marketPage.navigate(URL);
        marketPage.selectCategory();
        countItems = marketPage.getItemsCount(TWELVEITEMS);
        Assert.assertEquals(countItems,TWELVEITEMS);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countItems = marketPage.getItemsCount(FORTYEIGHTITEMS);
        Assert.assertEquals(countItems, FORTYEIGHTITEMS);

    }

    @Test
    public void marketTest2(){
        marketSortPage = new MarketSortPage(driver);
        boolean resultSort, usedSortByPryce;

        usedSortByPryce = marketSortPage.sortByPrice();
        resultSort = marketSortPage.isSortedItems();
        Assert.assertEquals(resultSort, usedSortByPryce);
    }

    @Test
    public void marketTest3(){
        marketComparePage = new MarketComparePage(driver);
        String takeTitle;
        int countItemsInCompare;

        marketComparePage.getItemsToCompare(FIRSTITEMINLIST, SECONDITEMINLIST);
        countItemsInCompare = marketComparePage.getCountCompareItems();
        Assert.assertEquals(COUNTITEMSTOCOMPARE, countItemsInCompare);
        marketComparePage.removeItemsFromCompare();
        takeTitle = marketComparePage.getAfterRemoveText();
        Assert.assertTrue(takeTitle.contains(MATCHINTEXT));
        marketComparePage.goToMarket(By.xpath(GOMARKETMAINPAGE));

    }
    @Test
    public void marketTest4(){
        yaMainPage = new YaMainPage(driver);

        boolean resultToNavigate;
        // добавить через цикл вызов метода goToPAge
        /*
        * //div[@role='navigation']/a["+i+"]
        *
        * переписать goTopage добавив, второй элемент таб меню
        * пожумать, как возвращать 2 значения труе(из гоТоПадже вызывать два метода сравнеия и если оба тру, возвращать тру
        * и выполнять ассерт с тру
        *
        * для новостей отдельное условие!
        * */

        yaMainPage.goToYa();
        for (int i=1; i < 8; i++){
        resultToNavigate = yaMainPage.goToPage(By.xpath("//div[@role='navigation']/a["+i+"]"), titlePages[i]);
        System.out.println("Result navigate to pages: " + resultToNavigate);
        Assert.assertTrue(resultToNavigate);

        }
    }

}