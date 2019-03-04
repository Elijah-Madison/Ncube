package page.main;

import core.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MainLeftMenu extends MainPage {

    private static WebDriver driver;
    private static final By phonesTvAndElectronic = By.xpath(".//a[contains(@href, 'telefony-tv-i-ehlektronika') and @class='menu-categories__link']");
    private static Map<Enum<MainMenuCategoryEnum>, By> categoriesMap;

    MainLeftMenu(WebDriver driver) {
        this.driver = driver;
    }

    static {
        categoriesMap = new HashMap<>();
        categoriesMap.put(MainMenuCategoryEnum.PHONE_AND_ELECTRONIC_CAT, phonesTvAndElectronic);
    }

    public <T> T selectMainLeftMenuCategory(final WebDriver driver, final MainMenuCategoryEnum category) {
        Optional<By> menuCat = categoriesMap.entrySet()
                .stream()
                .filter(e -> e.getKey() == category)
                .map(Map.Entry::getValue)
                .findFirst();
        if (menuCat.isPresent()) {
            BaseMethods.getElementWithWaitForVisibility(driver, menuCat.get(), 5).click();
            return category.getInstance(driver);
        } else {
            throw new NoSuchElementException("There is no such category in left main menu.");
        }
    }
}
