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
            logger.info("before method finish logout");
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
                .withPassword("Spuppu98333542$");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "No Contacts here!");
        logger.info("Assert checks if is written 'No contacts here!'");
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert checks if button 'sign out' present");
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }

   /* @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOkButton();
    }*/

   @Test(description = "Bug report #23456 Fixed")
   public void registrationWrongEmail(){
       User user = new User().withEmail("bongmail.com").withPassword("Bon987456$");
       logger.info("Tests run with data: --->"+user.toString());
       app.getHelperUser().openLoginRegistForm();
       app.getHelperUser().fillLoginRegistrationForm(user);
       app.getHelperUser().submit();
       Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
       logger.info("Assert check is alert present with error text 'Wrong email or password'");

   }


    @Test
    public void registrationWrongPassword(){
        User user = new User().withEmail("bon@gmail.com").withPassword("Bon984");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

    @Test
    public void registrationExistsUser(){
        User user = new User().withEmail("mara@gmail.com").withPassword("Mmar123456$");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
        logger.info("Assert check is alert present with error text 'User already exist'");

    }


}
