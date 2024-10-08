package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {
    @Test
    public void loginPositiveTest() {
        boolean result = new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm("qa_mail@mail.com", "Qwerty123!")
                .clickBtnLoginPositive().isElementContactPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void loginNegativeTest_wrongPassword() {
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm("qa_mail@mail.com", "Qwerty123!!!")
                .clickBtnLoginNegative().closeAlert().isTextInElementPresent_errorMessage());
    }

    //@Test
    //public void loginNegativeTest_wrongEmail() {
    //new HomePage(getDriver()).clickBtnLoginHeader()
    //            .typeLoginForm("qa_mail1@mail.com", "Qwerty123!")
    //            .clickBtnLoginNegative().closeAlert().isTextInElementPresent_errorMessage();
    //}

    @Test
    public void loginNegativeTest_wrongEmailUnregUser() {
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm("qa_mail1@mail.com", "Qwerty123!")
                .clickBtnLoginNegative().closeAlert().isTextInElementPresent_errorMessage());
    }

    @Test
    public void loginNegativeTest_wrongEmailWOAt() {
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm("qa_mail@mailcom", "Qwerty123!")
                .clickBtnLoginNegative().closeAlert().isTextInElementPresent_errorMessage());

        //Assert.assertEquals(100,200);
        //Assert.assertTrue(true);
        //Assert.assertFalse(false);
        //Assert.assertNotEquals(100,100);

    }
}
