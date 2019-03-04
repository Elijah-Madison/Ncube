package page.main;

import core.BaseMethods;
import core.DriverConfig;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public MainPage() {
        if(driver == null) {
            driverConfig = new DriverConfig();
            driver = driverConfig.getDriver();
            currentUrl = driver.getCurrentUrl();
        }
    }

    private DriverConfig driverConfig;
    private BaseMethods baseMethods = new BaseMethods();
    private WebDriver driver;
    private String currentUrl;

    public void openUrl() {
        driverConfig.openPage();
    }

    public void quitDriver() {
        driver.quit();
    }

    public <T> T leftMenuSwitch(final MainMenuCategoryEnum category) {
        return new MainLeftMenu().selectMainLeftMenuCategory(driver, category);
    }


}
