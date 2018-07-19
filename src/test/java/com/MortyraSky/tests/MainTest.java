package com.MortyraSky.tests;

        import com.MortyraSky.Manage.InitializeDeleteDriver;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class MainTest extends InitializeDeleteDriver {


    @Test
    public void SearchTest() {
        
        String URL = "https://ya.ru";
        String query = "погода пенза";
        String wordInQuery = "Погода";

        searchPage.navigate(URL);
        searchPage.queryInInputField(query);
        searchPage.clickFindButton();

        String textLink = searchResultPage.getTextLink();
        Assert.assertTrue(textLink.contains(wordInQuery));

    }

}
