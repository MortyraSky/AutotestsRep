package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.07.2018.
 */
public class MarketSortPage {

    public MarketSortPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    //ArrayList<String> stringPriceItems = new ArrayList<String>();
    ArrayList<Integer> priceItems = new ArrayList<Integer>();

    @FindBy (xpath = "//*[@class='n-filter-block_pos_left i-bem']/descendant::div[3]/a")
    private WebElement sortByPriceLink;

    @FindBy (xpath = "//*[@class='n-snippet-card2__main-price']")
    private List<WebElement> sortedPrice;

    // @FindBy (xpath = "//*[@class='n-filter-block_pos_left i-bem']/descendant::div[3]") проверить с этим
    @FindBy (xpath = "//*[@class='n-filter-block_pos_left i-bem']/descendant::div[3]")
    private WebElement sortByPrice;


    public boolean sortByPrice(){
        int i = 0;

        getAttributeElement(sortByPrice);
        sortByPriceLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Attribute sortLink by class: " + sortByPriceLink.getAttribute("class"));
        getAttributeElement(sortByPrice);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Количество отсортированных элементов по цене : " + sortedPrice.size() );


        if (!priceItems.isEmpty())
            priceItems.clear();

        for(WebElement e : sortedPrice) {

            System.out.println(e.getText());
            String strThousand = e.getText().substring(0,1) + e.getText().substring(2,5);
            System.out.println("Перевод : " + strThousand);
            priceItems.add(Integer.parseInt(strThousand));
            System.out.println("Результат в числовом варианет: " + priceItems.get(i));
            i++;
        }
        return true;
        /*
        for(int i = 0; i < stringPriceItems.size(); i++){
            String strThousand = stringPriceItems.get(i).substring(0,1);
            strThousand += stringPriceItems.get(i).substring(2,5);
            System.out.println("Перевод : "+ stringPriceItems.get(i)+" в :" + strThousand);
            priceItems.add(Integer.parseInt(strThousand));
            System.out.println("Результат в числовом варианет: " + priceItems.get(i));
        }
        // рабочий вариант клика по нужному элементу, использовать для добавления в сравнение!!!!!!!!!!!!!!!!!!!!!
        sortedPrice.get(1).click();
        */
    }

    public void getAttributeElement(WebElement element){
        System.out.println("Attribute sortLink by class: " + element.getAttribute("class"));
        System.out.println("Attribute sortLink by class: " + element.getAttribute("class"));
        System.out.println("Attribute sortLink by getText: " + element.getText());

    }

    public boolean isSortedItems(){
        boolean result = true;

        for (int i = 0; i < priceItems.size() - 1; i++){
            if (priceItems.get(i) <= priceItems.get(i+1))
                result = true;
            else{
                result = false;
                break;
            }
        }
        return result;
    }
}
