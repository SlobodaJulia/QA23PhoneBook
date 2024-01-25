package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTest extends TestBase {


    @BeforeMethod

    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("uuuuu@google.ru").withPassword("228877Sv!"));
            logger.info("before method need log in");
        }
            app.getHelperContact().provideContacts();//if list <3 ===> add 3 contacts
    }


    @Test
    public void removeFirstContact() {
        //Assert size list less by one
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);
    }

    @Test
    public void removeAllContacts() {
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());
        //"No contacts here"
    }


}
