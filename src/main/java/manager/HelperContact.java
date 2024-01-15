package manager;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
        public HelperContact(WebDriver wd) {
            super(wd);
        }


    public void openAddForm() {
        click(By.cssSelector("a[href='/add']"));
    }

}

