package com.MortyraSky.tests;

import com.MortyraSky.pages.LocationPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 23.07.2018.
 */
public class LocationPageTest extends LocationPage {

    public LocationPageTest(WebDriver driver) {
        super(driver);
    }

    public void setInputLocationField(String city){

        if(inputLocationField.isSelected())
        {

            inputLocationField.clear();
            inputLocationField.sendKeys(city);
            System.out.println("Поле инпут заполнено: " + city);
        }
        else {
            inputLocationField.click();
            inputLocationField.clear();
            inputLocationField.sendKeys(city);
            System.out.println("Поле инпут заполнено: " + city);
        }
    }

    public void takeCityInList(){
        //System.out.println("Нажат локатор: " + cityInList.getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cityInList.click();
        //
    }
}
