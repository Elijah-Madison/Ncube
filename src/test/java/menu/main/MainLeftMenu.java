package menu.main;

import core.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class MainLeftMenu {

    private static final By phonesTvAndElectronic = By.xpath(".//a[contains(@href, 'telefony-tv-i-ehlektronika') and @class='menu-categories__link']");
    private static Map<CategoriesMenuEnum, By> categoriesMap;

    static {
        categoriesMap = new HashMap<>();
        categoriesMap.put(MainMenuCategoryEnum.PHONE_AND_ELECTRONIC_CAT, phonesTvAndElectronic);
    }

    public <T> T leftMenuSwitch(final WebDriver driver, final MainMenuCategoryEnum category) {
        MainMenuCategoryEnum getCategoryEnum = (MainMenuCategoryEnum) new BaseMethods().selectLeftMenuCategory(driver, category.name(), categoriesMap);
        return getCategoryEnum.getInstance(driver);
    }
}
