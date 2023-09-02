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
public class Edit_a_Restaurant_Test {
    WebDriver driver;
    
    //to initialize the driver and open the targeted url
    @Before
    public void run_driver(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\osamakh\\IdeaProjects\\SelenuimPractice\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://testomate-test.web.app/home");
        driver.manage().window().maximize();

    }

    //to test api response of editing a restaurant property if equals the page data
    @Test
    public void Edit_a_restaurant_TEST(){
        Integer old_id=124;
        Integer id = 124;
        String name = "Sh place";
        String address = "kali";
        Double score= 3.5;
        ResponseData js2 = ResponseController.PATCH_Update_a_property_of_a_restaurant(old_id,null,name,null,address);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.navigate().refresh();
        Restaurant place = new Restaurant(driver);

        for(List<String> i:place.elements_in_table()){
            if(i.get(1)==""+id){
                Assert.assertEquals(i.get(1),""+id);
                Assert.assertEquals(i.get(2),name);
                Assert.assertEquals(i.get(3),address);
                Assert.assertEquals(i.get(4),""+score);
            }

        }


    }

    //close the driver after finishing the test
    @After
    public void finishing(){
        driver.close();
    }




}
