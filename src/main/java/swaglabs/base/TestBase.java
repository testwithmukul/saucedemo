package swaglabs.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import swaglabs.util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

//Initialize all my properties, waits, browser, window.manage()
//TestBase is parent so will use Inheritance for all other child classes
public class TestBase {

    //Declared driver and prop here to use globally
    static WebDriver driver;
    static Properties prop;

    public TestBase(){

        //Reading Properties file:
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("/Users/mukul/Downloads/saucedemo/src/main/java/swaglabs/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/mukul/Documents/Testing/Automation/drivers/chrome/chromedriver");
            driver = new ChromeDriver();
        }else {
            System.out.println("Driver not found!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }
}
