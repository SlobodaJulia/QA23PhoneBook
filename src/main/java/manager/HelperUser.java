package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginRegistForm(){
       // WebElement LoginTab = wd.findElement(By.xpath("//a[text()='LOGIN']"));
        //LoginTab.click();
        click(By.xpath("//a[text()='LOGIN']"));


    }
    public void fillLoginRegistrationForm(String email, String password) {
        //WebElement emailInput = wd.findElement(By.xpath("//input[placeholder='Email']"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[last()]"), password);
    }

    public void fillLoginRegistrationForm(User user) {
            type(By.cssSelector("input[placeholder='Email']"), user.getEmail());
            type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
        }



        //WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys(password);



    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));

    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//*[text()='Sign Out']"));
    }



}


