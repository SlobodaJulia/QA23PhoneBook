package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import java.util.List;
import java.util.Set;

public class ApplicationManager {


    WebDriver wd;
    HelperUser helperUser;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://telranedu.web.app/");
        helperUser = new HelperUser(wd);
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop(){
        wd.quit();

    }

}
