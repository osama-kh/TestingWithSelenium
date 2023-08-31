package UI;
import org.openqa.selenium.WebDriver;

public abstract class WebPageBAse {
    protected WebDriver driver;

    public WebPageBAse(WebDriver driver){
        this.driver=driver;
    }
    public abstract void initPage();



}
