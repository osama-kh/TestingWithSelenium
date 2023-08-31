package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

class Restaurant extends WebPageBAse{
    String  CREATE_BUTTON ="//app-main//div[@style=\"text-align: center;\"]//button";
    String TABLE="table table-striped";

    WebElement create_button;
    WebElement Table;
    public Restaurant(WebDriver Driver ){
    super(Driver);
    initPage();
    }

    @Override
    public void initPage() {
    create_button= this.driver.findElement(By.xpath(CREATE_BUTTON));
    Table=this.driver.findElement(By.className(TABLE));

    }

//    a) Add new restaurant
//    b) Delete a restaurant

    void Add_new_restaurant(String Id,String Name,String Address,String Score){


    }




}