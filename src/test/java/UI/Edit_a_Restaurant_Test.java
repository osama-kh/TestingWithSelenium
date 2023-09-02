package UI;
import API.responses.RequestController;
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
        Integer old_id=124;
        Integer id = null;
        String name = "Sh place";
        String address = "kali";
        Double score= null;
        ResponseData js2 = RequestController.PATCH_Update_a_property_of_a_restaurant(old_id,id,name,score,address);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.navigate().refresh();
        Restaurant place = new Restaurant(driver);

        for(List<String> i:place.elemnts_in_table()){
            if(i.get(1)==""+id){
                Assert.assertEquals(i.get(1),""+id);
                Assert.assertEquals(i.get(2),name);
                Assert.assertEquals(i.get(3),address);
                Assert.assertEquals(i.get(4),""+score);
            }

        }


    }

    @After
    public void finishing(){
        driver.close();
    }




}
