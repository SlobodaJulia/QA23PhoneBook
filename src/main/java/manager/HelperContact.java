package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void openAddForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2>button"));
    }

    public boolean isContactAddedByName(String name)
    {
        java.util.List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list)
        {
            if(el.getText().equals(name))
            {
                return true;
            }
        }
        return false;
    }


    public boolean isContactedAddedBynumber(String phone) {
        java.util.List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list)
        {
            if(el.getText().equals(phone))
            {
                return true;
            }
        }
        return false;
    }


    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }


    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of Contacts before remove is --->" +before);
        removeContact();


        int after = countOfContacts();
        logger.info("Number of Contacts after remove is --->" +after);

        return before-after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while(countOfContacts()!=0){
            removeContact();
        }
    }

    public void provideContacts() {
        if(countOfContacts()<3){
            for (int i = 0; i < 3; i++) {
                addOneContact();

            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Harri"+i)
                .lastName("Potter")
                .address("Hogwards")
                .email("harry"+i+"@gmail.com")
                .phone("555666777"+i)
                .description("Friend")
                .build();

        openAddForm();
        fillContactForm(contact);
        saveContact();
        pause(500);
    }
    }


