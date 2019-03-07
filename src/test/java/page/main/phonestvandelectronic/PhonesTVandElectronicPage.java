package page.main.phonestvandelectronic;

import core.DriverConfig;
import menu.main.phonestvandelectronic.PhonesTVandElectronicLeftMenu;
import menu.main.phonestvandelectronic.PhonesTVandElectronicMenuCategoryEnum;
import org.openqa.selenium.WebDriver;

public class PhonesTVandElectronicPage {

    public PhonesTVandElectronicPage(WebDriver driver) {
        this.driver = driver;
        currentUrl = driver.getCurrentUrl();
    }

    private DriverConfig driverConfig = new DriverConfig();
    private String currentUrl;

    public void openUrl() {
        driverConfig.openPage();
    }

    private WebDriver driver;

    protected void quitDriver() {
        driver.quit();
    }

    public <T> T leftMenuSwitch(final PhonesTVandElectronicMenuCategoryEnum category) {
        return new PhonesTVandElectronicLeftMenu().leftMenuSwitch(driver, category);
    }

}
