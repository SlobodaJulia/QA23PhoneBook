package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("alexlev@google.com").withPassword("220821SBsb)(!"));
        }

    }

    @Test
    public void addContactSuccessAll(){
        Contact contact = Contact.builder()


                .build();

    }

    @Test
    public void addContactSuccessRequiredFields(){

    }
}