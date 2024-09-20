package pages;

import dto.ContactDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HeaderMenuItem;

import java.time.Duration;

public class AddPage extends BasePage{
    public AddPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

   @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement inputName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    WebElement inputPhone;

    @FindBy(xpath = "//input[@placeholder='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Address']")
    WebElement inputAddress;

    @FindBy(xpath = "//input[@placeholder='description']")
    WebElement inputDescription;

    @FindBy(xpath = "//button/b")
    static WebElement btnSaveContact;


    public void fillContactForm(ContactDtoLombok contact) {
        inputName.sendKeys(contact.getName());
        inputLastName.sendKeys(contact.getLastName());
        inputPhone.sendKeys(contact.getPhone());
      inputEmail.sendKeys(contact.getEmail());
      inputAddress.sendKeys(contact.getAddress());
      inputDescription.sendKeys(contact.getDescription());
    }

    public void clickBtnSaveContactPositive(){
        btnSaveContact.click();
    }

    public void clickBtnSaveContactNegative(HeaderMenuItem headerMenuItem){
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button/b")));
            btnSaveContact.click();
        } catch (TimeoutException exception) {
            exception.printStackTrace();
            System.out.println("created exception");
        }

    }

}
