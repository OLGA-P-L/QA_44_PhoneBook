package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);

    }

    @FindBy(xpath = "//a[text()='CONTACTS']")
    WebElement btnContact;

    @FindBy(xpath = "//div[@class='contact-page_leftdiv__yhyke']//div[@class='contact-item_card__2SOIM'][last()]/h3")
    WebElement lastPhoneInList;

    @FindBy(xpath = "//div[@class='contact-page_leftdiv__yhyke']//div[@class='contact-item_card__2SOIM']")
    WebElement firstContactInList;

    @FindBy(xpath = "//button[text()='Remove']")
    WebElement btnRemoveContact;

    public boolean isElementContactPresent(){
        return btnContact.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='login_login__3EHKB']/div")
    WebElement errorMessageRegistration;

    public boolean isTextInElementPresent_errorMessage_reg(){
        return isElementPresent(errorMessageRegistration, "Registration failed with code 400");
    }

    public boolean isLastPhoneEquals(String phone){
        return lastPhoneInList.getText().equals(phone);
    }

    public boolean urlContainsAdd(){
        return urlContains("add",3);
    }

    public boolean isAlertPresent(int time){
        try {
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            alert.accept();
            return true;
        }catch (TimeoutException e){
           e.printStackTrace();
            return false;
        }


    }

    public void clickFirstElementOfContactsList() {
        firstContactInList.click();

    }

    public void clickBtnRemove(){
        btnRemoveContact.click();

    }

    public int getContactsNumber() {
        pause(2);
        return driver.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
    }
}
