package tests;

import dto.ContactDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
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

public class AddContactsTests extends ApplicationManager {
    UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");
    AddPage addPage;
    @BeforeMethod
    public void login(){
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage =
        clickButtonsOnHeader1(HeaderMenuItem.LOGIN);
        ContactPage contactPage = loginPage.typeLoginForm(user).clickBtnLoginPositive();
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
ContactPage contactPage = new ContactPage(getDriver());
        addPage.fillContactForm(contact);
        addPage.clickBtnSaveContactPositive();
        contactPage.isLastPhoneEquals(contact.getPhone());


    }
}
