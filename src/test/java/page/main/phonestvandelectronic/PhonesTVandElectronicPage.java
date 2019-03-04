package page.main.phonestvandelectronic;

import core.DriverConfig;
import org.openqa.selenium.WebDriver;
import page.main.Category;

import static page.main.phonestvandelectronic.PhonesTVandElectronicLeftMenu.PhonesTVandElectronicMenuCategoryEnum;

public class PhonesTVandElectronicPage implements Category {
    public PhonesTVandElectronicPage() {
        if (driver == null) {
            driver = DriverConfig.getDriver();
        }
    }

    public PhonesTVandElectronicPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {
        DriverConfig.openPage();
    }

    private WebDriver driver;

    protected void quitDriver() {
        driver.quit();
    }

    public <T> T leftMenuSwitch(final PhonesTVandElectronicMenuCategoryEnum category) {
        return new PhonesTVandElectronicLeftMenu(driver).selectMenuCategory(driver, category);
    }

}
