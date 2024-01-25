package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("uuuuu@google.ru").withPassword("228877Sv!"));

            logger.info("before method need log in");
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
                logger.info("Tests run with data: --->"+contact.toString());
                app.getHelperContact().openAddForm();
                app.getHelperContact().fillContactForm(contact);
                app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");


                app.getHelperContact().saveContact();
                Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
                logger.info("Contact was added");
                Assert.assertTrue(app.getHelperContact().isContactedAddedBynumber(contact.getPhone()));
                logger.info("Contact was added");


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
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");

        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        logger.info("Contact was added");
        Assert.assertTrue(app.getHelperContact().isContactedAddedBynumber(contact.getPhone()));
        logger.info("Contact was added");

    }

    @Test
    public void addNewContactWrongName(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("")
                .lastName("Stark")
                .address("NY")
                .phone("323265934562")
                .email("stark@gmail.com")
                .description("empty name")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Contact was not added and page is still displayed");
    }
    @Test
    public void addNewContactWrongAddress(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("")
                .phone("32326593245452")
                .email("stark@gmail.com")
                .description("empty address")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Contact was not added and page is still displayed");

    }

    @Test
    public void addNewContactWrongLastName(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .address("NY")
                .phone("323265934552")
                .email("stark@gmail.com")
                .description("empty last name")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Contact was not added and page is still displayed");

    }

    @Test
    public void addNewContactWrongPhone(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("")
                .email("stark@gmail.com")
                .description("empty phone")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Contact was not added and page is still displayed");
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
        logger.info("Assert check is alert present with error text 'Phone number must contain only digits! And length min 10, max 15!'");

    }

    @Test
    public void addNewContactWrongEmail(){
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("3232659324521")
                .email("starkgmail.com")
                .description("wrong email")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Contact was not added and page is still displayed");
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));
        logger.info("Assert check is alert present with error text 'Email not valid'");


    }
}