package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;

import static utils.RundomUtils.generateEmail;
import static utils.RundomUtils.generateString;
import static pages.BasePage.clickButtonsOnHeader;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader().typeLoginForm("plutplutplut1@gmail.com", "Beauty19812023!")
                .clickBtnRegistrationPositive().isElementContactPresent());
    }

    @Test
    public void registrationNegativeTest() {
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader().typeLoginForm("plutplutplut1gmail.com", "Beauty19812023!")
                .clickBtnRegistrationNegative().closeAlert_wrongRegistration().isTextInElementPresent_errorMessage_reg());
    }

    @Test
    public void registrationNegativeTest_wrongEmail() {

        String email = generateString(10);
        UserDto user = new UserDto(email, "Qwerty123!");

        new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnRegistrationNegative().closeAlert().isTextInElementPresent_errorMessage("Registration failed with code 400");
    }

    public void registrationNegativeTest_wrongEmailWOAt_Enum() {

        String email = generateString(10);
        UserDto user = new UserDto(email, "Qwerty123!");

        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);

                loginPage.typeLoginForm(user)
                .clickBtnRegistrationNegative().closeAlert().isTextInElementPresent_errorMessage("Registration failed with code 400");
    }
}