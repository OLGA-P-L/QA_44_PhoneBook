package tests;

import dto.ContactDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;
import utils.RetryAnalyzer;

import static pages.BasePage.clickButtonsOnHeader1;
import static utils.RundomUtils.*;
import static utils.RundomUtils.generateString;
import static utils.PropertiesReader.getProperty;

public class EditContactsTests extends ApplicationManager {
    //UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");

    UserDto user = new UserDto(getProperty("data.properties","email"),getProperty("data.properties","password"));
    ContactPage contactPage;

    @BeforeMethod
    public void login(){
        logger.info("Start method ---> login" + "user: qa_mail@mail.com");
        new HomePage(getDriver());
        LoginPage loginPage =
                clickButtonsOnHeader1(HeaderMenuItem.LOGIN);
        contactPage = loginPage.typeLoginForm(user).clickBtnLoginPositive();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void editContactPositiveTest(){
        ContactDtoLombok newContact = ContactDtoLombok.builder()
                .name("new - "+generateString(5))
                .lastName("new - "+generateString(10))
                .phone("000"+generatePhone(7))
                .email("new - "+generateEmail(12))
                .address("new - "+generateString(20))
                .description("new - "+generateString(10))
                .build();
        contactPage.clickFirstElementOfContactsList();
        contactPage.fillEditeForm(newContact);
        contactPage.clickBtnSaveContact();
        ContactDtoLombok contact = contactPage.getContactFromDetailedCard();
        Assert.assertEquals(newContact, contact);
    }
}
