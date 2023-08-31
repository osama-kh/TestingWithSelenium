package UI;

import UI.WebPageBAse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

class Restaurant extends WebPageBAse {
    String  CREATE_BUTTON ="//app-main//div[@style=\"text-align: center;\"]//button";
    String TABLE="//div[@id=\"main-table\"]//table";

    WebElement create_button;
    WebElement Table;
    public Restaurant(WebDriver Driver ){
    super(Driver);
    initPage();
    }

    @Override
    public void initPage() {
        create_button = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(CREATE_BUTTON)));

        Table = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(TABLE)));
    }
    public String button_string(){
        return create_button.getText();
    }
//    a) Add new restaurant
//    b) Delete a restaurant

    void Add_new_restaurant(String Id,String Name,String Address,String Score){


    }

    ArrayList <ArrayList> elemnts_in_table(){
        ArrayList <String> data = new ArrayList<String>();

        ArrayList<ArrayList> Elements=new  ArrayList<ArrayList>();
//        List<WebElement> rows = Table.findElements(By.tagName("tr"));
        List<WebElement> rows =  new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.tagName("tr")));
// Iterate through each row and print the data in the columns
        for (WebElement row : rows) {
            List<WebElement> cols =  new WebDriverWait(driver,  Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .presenceOfAllElementsLocatedBy(By.tagName("td")));
//            System.out.println(row.getText() + "\t");

            for (WebElement col : cols) {
                data.add(col.getText());
//                System.out.print(col.getText() + "\t");

            }
            System.out.println();
        }
        
        Elements.add(data);



        return Elements;
    }




}