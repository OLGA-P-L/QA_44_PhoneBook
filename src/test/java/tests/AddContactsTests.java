package tests;

import data_provider.DPAddContact;
import dto.ContactDtoLombok;
import dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;


import static pages.BasePage.clickButtonsOnHeader1;
import static java.util.Random.*;
import static utils.RundomUtils.*;

@Slf4j
public class AddContactsTests extends ApplicationManager {
    UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");
    AddPage addPage;
    @BeforeMethod
    public void login(){
        new HomePage(getDriver());
        LoginPage loginPage =
        clickButtonsOnHeader1(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(user).clickBtnLoginPositive();
        addPage = clickButtonsOnHeader1(HeaderMenuItem.ADD);

    }
    @Test
    public void addNewContactPositiveTest(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .phone(generatePhone(10))
                .email(generateEmail(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();

        Assert.assertTrue(addPage.fillContactForm(contact).clickBtnSaveContactPositive()
                .isLastPhoneEquals(contact.getPhone()));


    }
    /*@Test
    public void addNewContactNegativeTest_nameIsNull(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(0))
                .lastName(generateString(10))
                .phone(generatePhone(10))
                .email(generateEmail(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();
        ContactPage contactPage = new ContactPage(getDriver());
        addPage.fillContactForm(contact);
        addPage.clickBtnSaveContactNegative(HeaderMenuItem.SAVE);
        Assert.assertTrue(addPage.isTextInTheElementPresent_nameIsNull());

    }*/

    @Test
    public void addNewContactNegativeTest_nameIsEmpty(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name("")
                .lastName(generateString(10))
                .phone(generatePhone(10))
                .email(generateEmail(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();

        Assert.assertTrue(addPage.fillContactForm(contact).clickBtnSaveContactPositive()
                .urlContainsAdd());



    }

    @Test
    public void addNewContactNegativeTest_wrongEmail() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(4))
                .lastName(generateString(10))
                .phone(generatePhone(10))
                .email(generateString(12))
                .address(generateString(20))
                .description(generateString(10))
                .build();

        Assert.assertTrue(addPage.fillContactForm(contact).clickBtnSaveContactPositive()
                .isAlertPresent(5));
    }

    @Test(dataProvider = "DPAddContact", dataProviderClass = DPAddContact.class)
    public void addNewContactNegativeTest_wrongEmailDP(ContactDtoLombok contact) {
        System.out.println("--->" + contact);
        Assert.assertTrue(addPage.fillContactForm(contact)
                .clickBtnSaveContactPositive()
                .isAlertPresent(5))
        ;


    }

}
