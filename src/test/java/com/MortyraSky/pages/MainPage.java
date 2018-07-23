package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public int getCountMoreLinks(String city){

        System.out.println("Переход по локатору:" + tabMoreLink.getText());
        tabMoreLink.click();
        System.out.println("Количество элементов во вкладке 'ещё' для города : "+ city + " = " + moreLinks.size() );
        //count += moreLinks.size();

        for(WebElement e : moreLinks) {
            System.out.println(e.getText());
            //не количесвто
            //а то тексты ссылок одинаковы
            // нужно сравнивать массивы ссылок разных городов, наверное использовать массив String сначало записать в массив, передать а сравнивать через ассерт
            //changeLocation - надо переписать, там метод в 3-4 строчки
            //Если первый раз не кликнуть, то драйвер не найдет ссылки в меню еще. А второй для закрытия вкладки ещене может такого быть
            //changeLocation - надо переписать, там метод в 3-4 строчки
            //имплисити вейт больше поставь
        }

        tabMoreLink.click();
        return moreLinks.size();

    }

    /*
    public void clickTabMoreLink(){
        System.out.println("Переход по локатору:" + tabMoreLink.getText());
        tabMoreLink.click();

    }

    public String countMoreLinks(String city){
        System.out.println("Количество элементов во вкладке 'ещё' для города : "+ city + " = " + moreLinks.size() );
        String count = "";
        return count += moreLinks.size();
    }
    */

    public void navigate(String URL){
        driver.get(URL);
        System.out.println("Переход на:" + URL);
    }



}
