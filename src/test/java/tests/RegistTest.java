package tests;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.util.Random;

import static tests.TestBase.app;

public class RegistTest extends TestBase {


    @BeforeMethod
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(System.currentTimeMillis());
        int z = (int)System.currentTimeMillis()/1000%3600;
        User user = new User()
                .withEmail("mark"+z+"@gmail.com")
                .withPassword("Spuppu98333542$)(");
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "No Contacts here!");
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
   /* @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOkButton();
    }*/

}
