package UI;


import API.responses.RequestController;
import logic.ResponseData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Add_New_Restaurant_Test {
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
    public void add_new_restaurant_TEST(){
        ResponseData js2 = RequestController.POST_Creates_a_new_restaurant(124,"Sh place",3.5," jk 50");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.navigate().refresh();
       Restaurant place = new Restaurant(driver);
        System.out.println(place.button_string());



    }

    @After
    public void finishing(){




    }



}