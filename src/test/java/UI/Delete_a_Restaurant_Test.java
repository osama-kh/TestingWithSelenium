package UI;
import API.responses.ResponseController;
import logic.ResponseData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class Delete_a_Restaurant_Test {

    WebDriver driver;

    @Before
    public void run_driver(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\osamakh\\IdeaProjects\\SelenuimPractice\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://testomate-test.web.app/home");
        driver.manage().window().maximize();

    }


    @Test
    public void Delete_a_restaurant_TEST(){
        int id = 124;

        ResponseData js2 = ResponseController.DELETE_Delete_a_restaurant(id);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        driver.navigate().refresh();
        Restaurant place = new Restaurant(driver);
        boolean checker=true;
        for(List<String> i:place.elemnts_in_table()){
            if(i.get(1)==""+id){
            checker=false;
            }

        }
        Assert.assertTrue(checker);

    }

    @After
    public void finishing(){
        driver.close();
    }






}
