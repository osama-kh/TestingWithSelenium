package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    //InitPage method to initialize the elements of the page
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

    //elements_in_table: is a method that returns the table data inside a nested list
    List<List<String>> elements_in_table(){

        System.out.println(Table.getText());
        List<List<String>> tableData = new ArrayList<>();
        List<WebElement> f =  new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.tagName("tr")));
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




