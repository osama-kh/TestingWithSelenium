package UI;
import API.responses.ResponseController;
import infra.HttpFacade;
import logic.ResponseData;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Delete_a_Restaurant_Test {

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

    //to test api response of deleting specific restaurant if equals the page data

    @Test
    public void Delete_a_restaurant_TEST(){
        int id = 124;

        ResponseData js2 = ResponseController.DELETE_Delete_a_restaurant(id);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        driver.navigate().refresh();
        Restaurant place = new Restaurant(driver);
        boolean checker=true;
        for(List<String> i:place.elements_in_table()){
            if(i.get(1)==""+id){
            checker=false;
            }

        }
        Assert.assertEquals(HttpFacade.getStatus(),200 | 201);
        Assert.assertTrue(checker);

    }
    @After
    public void takeScreenshot() {
        String testName="Delete a restaurant Test";
        if (HttpFacade.getStatus()!=200){
            File screenshot =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Save the screenshot to a file
                FileUtils.copyFile(screenshot,
                        new File("screenshots/" + testName + ".png"));
                System.out.println("Screenshot saved to: "
                        + "screenshots/"
                        + testName + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // Take a screenshot of the page

    }
    //close the driver after finishing the test
    @After
    public void finishing(){
        driver.close();
    }






}
