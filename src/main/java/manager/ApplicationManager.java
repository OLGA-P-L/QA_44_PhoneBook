package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

import java.lang.reflect.Method;

public class ApplicationManager {
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public WebDriver getDriver() {
        return driver;
    }
        @BeforeMethod
        public void setup(){
        //logger.info("Start method ---> setup");
        driver=new ChromeDriver();
            //new realisation WDListener in Selenium 4
            WebDriverListener webDriverListener = new WDListener();
            driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);

        driver.manage().window().maximize();
        }
        @AfterMethod
    public void tearDown(){
           // logger.info("Start method ---> tearDown");
       // if(driver != null){
       //     driver.quit();
       // }
        }

}
