package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {
    @Test
    public void loginPositiveTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader().typeLoginForm("qa_mail@mail.com", "Qwerty123!").clickBtnLoginPositive().isElementContactPresent());




        //Assert.assertEquals(100,200);
        //Assert.assertTrue(true);
        //Assert.assertFalse(false);
        //Assert.assertNotEquals(100,100);
    }
}