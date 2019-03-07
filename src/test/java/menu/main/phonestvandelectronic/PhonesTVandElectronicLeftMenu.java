package menu.main.phonestvandelectronic;

import core.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import menu.main.CategoriesMenuEnum;

import java.util.HashMap;
import java.util.Map;

public class PhonesTVandElectronicLeftMenu {
    private static final By phone = By.xpath(".//a[ @class='m-cat-l-i-title-link' and text()= 'Телефоны']");
    private static Map<CategoriesMenuEnum, By> categoriesMap;

    static {
        categoriesMap = new HashMap<>();
        categoriesMap.put(PhonesTVandElectronicMenuCategoryEnum.PHONES_CAT, phone);
    }

    public <T> T leftMenuSwitch(final WebDriver driver, final PhonesTVandElectronicMenuCategoryEnum category) {
        PhonesTVandElectronicMenuCategoryEnum getCategoryEnum = (PhonesTVandElectronicMenuCategoryEnum) new BaseMethods().selectLeftMenuCategory(driver, category.name(), categoriesMap);
        return getCategoryEnum.getInstance(driver);
    }
}
