package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader().typeLoginForm("plutplutplut1@gmail.com", "Beauty19812023!").clickBtnRegistrationPositive().isElementContactPresent());
    }
}
