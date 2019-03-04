package page.main;

import core.DriverConfig;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public MainPage() {
        if (driver == null) {
            driver = DriverConfig.getDriver();
        }
    }

    public void openUrl() {
        DriverConfig.openPage();
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    protected void quitDriver() {
        driver.quit();
    }

    public <T> T leftMenuSwitch(final MainMenuCategoryEnum category) {
        return new MainLeftMenu(driver).selectMainLeftMenuCategory(driver, category);
    }


}
