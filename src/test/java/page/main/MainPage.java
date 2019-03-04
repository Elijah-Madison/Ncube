package page.main;

import core.DriverConfig;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage() {
        driver = DriverConfig.getDriver();
    }

    private WebDriver driver;

    public void openUrl() {
        DriverConfig.openPage();
    }

    protected void quitDriver() {
        driver.quit();
    }

    public <T> T leftMenuSwitch(final MainMenuCategoryEnum category) {
        return new MainLeftMenu().selectMainLeftMenuCategory(driver, category);
    }


}
