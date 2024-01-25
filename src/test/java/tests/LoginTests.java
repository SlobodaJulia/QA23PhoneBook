package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("before method finish logout");
        }
    }

    @Test
    public void loginSuccess1() {
        logger.info("Start test with name `login success` ");
        logger.info("Test data:-------> email:'uuuuu@google.ru' password: '228877Sv!'");
            User user = new User().withEmail("uuuuu@google.ru").withPassword("228877Sv!");
            app.getHelperUser().openLoginRegistForm();
            app.getHelperUser().fillLoginRegistrationForm(user);
            app.getHelperUser().submitLogin();
            Assert.assertTrue(app.getHelperUser().isLogged());
            logger.info("Assert checks if button 'sign out' present");



        }


  /*  @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlev@google.com", "220821SBsb)(!");
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isLogged());


    }*/
   /* @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlev@google.com", "220821SBsb)(!");
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }*/
    @Test
    public void loginWrongEmail(){
        logger.info("Test data:-------> email:'alexlevgoogle.com' password: '220821SBsb)(!'");
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlevgoogle.com", "220821SBsb)(!");
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data:-------> email:'alexlev@google.com' password: 'ndjdj'");
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlev@google.com", "ndjdj");
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");


    }
    @Test
    public void loginUnregisteredUser(){
       // logger.info("Test data:-------> email:'luck@gmail.com' password: 'Lluk123456$'");
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("luck@gmail.com", "Lluk123456$");
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
       // logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

}
