package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlev@google.com", "220821SBsb)(!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());


    }
    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlev@google.com", "220821SBsb)(!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlevgoogle.com", "220821SBsb)(!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("alexlev@google.com", "ndjdj");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));


    }
    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistForm();
        app.getHelperUser().fillLoginRegistrationForm("luck@gmail.com", "Lluk123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }


}
