package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HeaderMenuItem;

public class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd){
        driver=wd;

    }
    public void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isElementPresent(WebElement element, String text){
       return element.getText().contains(text);

    }

    public static <T extends BasePage> T clickButtonsOnHeader(HeaderMenuItem headerMenuitem){
        WebElement element = driver.findElement(By.xpath(headerMenuitem.getLocator()));
        element.click();
        switch (headerMenuitem){
            case HOME:
                return (T) new HomePage(driver);

            case ABOUT:
                return (T) new AboutPage(driver);

            case LOGIN:
                return (T) new LoginPage(driver);

            default:
                throw new IllegalArgumentException("invalid parameter headerMenuItem");

        }
    }
}
