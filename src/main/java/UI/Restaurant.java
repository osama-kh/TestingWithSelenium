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
    String TABLE="//div[@id=\"main-table\"]//table//tbody";

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
                        .presenceOfElementLocated(By.xpath(TABLE)));
    }
    public String button_string(){
        return create_button.getText();
    }
//    a) Add new restaurant
//    b) Delete a restaurant

    void Add_new_restaurant(String Id,String Name,String Address,String Score){


    }

    List<List<String>>  elemnts_in_table(){
//
//        List<List<String>> tableData = new ArrayList<>();
//        /////////////////////////////
//
////        ArrayList <String> data = new ArrayList<String>();
////        String temp="";
////        ArrayList<ArrayList> Elements=new  ArrayList<ArrayList>();
////        List<WebElement> rows = Table.findElements(By.tagName("tr"));
//
//
//        List<WebElement> rows =  new WebDriverWait(driver,  Duration.ofSeconds(10))
//                .until(ExpectedConditions
//                        .presenceOfAllElementsLocatedBy(By.tagName("tr")));
//
//
//// Iterate through each row and print the data in the columns
//        for (WebElement row : rows) {
//            List<WebElement> cols =  new WebDriverWait(driver,  Duration.ofSeconds(10))
//                    .until(ExpectedConditions
//                            .presenceOfAllElementsLocatedBy(By.tagName("td")));
////            System.out.println(row.getText() + "\t");
//            List<String> rowData = new ArrayList<>();
//
//            for (WebElement col : cols) {
//                rowData.add(col.getText());
//
////                data.add(col.getText());
////                temp+= col.getText()+" ";
////                System.out.print(col.getText() + "\t");
//
//            }
//            tableData.add(rowData);
//
//            System.out.println();
//        }
//
//        return tableData;

        System.out.println(Table.getText());
        List<List<String>> tableData = new ArrayList<>();
        List<WebElement> f =  new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.tagName("tr")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> rows = Table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            tableData.add(rowData);
        }
        System.out.println(tableData);

        return tableData;
    }
    }




