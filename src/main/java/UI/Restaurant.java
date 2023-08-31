package UI;

import UI.WebPageBAse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class Restaurant extends WebPageBAse {
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
        WebElement luckyButton = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(CREATE_BUTTON)));
//        create_button= this.driver.findElement(By.xpath(CREATE_BUTTON));
    Table=this.driver.findElement(By.className(TABLE));

    }
    public String button_string(){
        return create_button.getText();
    }
//    a) Add new restaurant
//    b) Delete a restaurant

    void Add_new_restaurant(String Id,String Name,String Address,String Score){


    }




}