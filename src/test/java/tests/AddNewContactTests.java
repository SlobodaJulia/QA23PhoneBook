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
            app.getHelperUser().login(new User().withEmail("uuuuu@google.ru").withPassword("228877Sv!"));
        }

    }

    @Test
    public void addContactSuccessAll(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("Julia"+i)
                .lastName("Bodik")
                .phone("0525904191"+i)
                .email("juju@yandex" + i + ".ru")
                .address("tirat carmel")
                .description("friend")
                .build();
                app.getHelperContact().openAddForm();
                app.getHelperContact().fillContactForm(contact);

                app.getHelperContact().saveContact();

    }

    @Test
    public void addContactSuccessRequiredFields(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("Julia"+i)
                .lastName("Bodik")
                .phone("0525904191"+i)
                .email("juju@yandex.ru"+i)
                .address("tirat carmel")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        
        app.getHelperContact().saveContact();

    }
}