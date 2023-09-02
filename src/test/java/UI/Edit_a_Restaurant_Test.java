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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
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
        System.out.println(HttpFacade.getStatus());
        driver.navigate().refresh();
        Restaurant place = new Restaurant(driver);


            Assert.assertEquals(HttpFacade.getStatus(),200 );
        for(List<String> i:place.elements_in_table()){
            System.out.println(i);
            if(i.get(1)==""+id){

                Assert.assertEquals(i.get(1),""+id);
                Assert.assertEquals(i.get(2),name);
                Assert.assertEquals(i.get(3),address);
                Assert.assertEquals(i.get(4),""+score);
            }

        }
//    takeScreenshot("Edit a restaurant Test");

    }
    @After
    public void takeScreenshot() {
        String testName="Edit a restaurant Test";
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
        System.out.println("browser log: \n");
        LogEntries  browserLogs =
                (LogEntries) driver.manage().logs().get(LogType.BROWSER).getAll();
        for (LogEntry logEntry : browserLogs) {
            System.out.println(logEntry.getMessage());
        }
//        System.out.println(browserLogs);
        // Take a screenshot of the page

    }

    //close the driver after finishing the test
    @After
    public void finishing(){
        driver.close();
    }




}
