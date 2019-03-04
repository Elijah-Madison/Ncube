package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class DriverConfig implements DriverType {

    private final static String DOMAIN_URL = "https://rozetka.com.ua/";

    private DriverConfig() {
    }

    private static WebDriver driver;


    private static String defaultBrowser = "Chrome";

    public static WebDriver getDriver() {
        if (driver == null) {
            switchBrowser(defaultBrowser);
            driverSetup(driver);
        }
        return driver;
    }

    public static void openPage(final String urlPathAndParams) {
        driver.get(DOMAIN_URL + urlPathAndParams);
    }

    public static void openPage() {
        driver.get(DOMAIN_URL);
    }

    private static void driverSetup(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //default use for cross browser test - Selenium Grid
    @Parameters("browser")
    private static void switchBrowser(String browser) {
        if (browser.equals(DRIVER_TYPE.IE.name())) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

}

