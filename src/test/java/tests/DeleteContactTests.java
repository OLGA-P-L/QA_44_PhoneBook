package tests;

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

import static pages.BasePage.clickButtonsOnHeader1;

public class DeleteContactTests extends ApplicationManager {
    UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");
    ContactPage contactPage;

    @BeforeMethod
    public void login(){
        logger.info("Start method ---> login" + "user: qa_mail@mail.com");
        new HomePage(getDriver());
        LoginPage loginPage =
                clickButtonsOnHeader1(HeaderMenuItem.LOGIN);
        contactPage = loginPage.typeLoginForm(user).clickBtnLoginPositive();
    }

    @Test
    public void deletePositiveTest(){
        int quantityBeforeDelete = contactPage.getContactsNumber();
        System.out.println("---> "+quantityBeforeDelete);
        contactPage.clickFirstElementOfContactsList();
        contactPage.clickBtnRemove();
        int quantityAfterDelete = contactPage.getContactsNumber();
        System.out.println("---> "+quantityAfterDelete);


        Assert.assertEquals(quantityBeforeDelete-1,quantityAfterDelete);


    }
}
