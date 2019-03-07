package menu.main.phonestvandelectronic.mobile;

import core.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import menu.main.CategoriesMenuEnum;
import page.main.phonestvandelectronic.mobile.PhonesPage;

import java.util.HashMap;
import java.util.Map;

public class PhonesLeftMenu {
    private final static By smartPhone = By.xpath(".//a[ @class='m-cat-l-i-title-link' and text()= 'Смартфоны']");
    private static Map<CategoriesMenuEnum, By> categoriesMap;
    static {
        categoriesMap = new HashMap<>();
        categoriesMap.put(PhonesLeftMenuCategoryEnum.SMARTPHONE_CAT, smartPhone);
    }

    public PhonesPage leftMenuSwitch(final WebDriver driver, final PhonesLeftMenuCategoryEnum category) {
        PhonesLeftMenuCategoryEnum getCategoryEnum = (PhonesLeftMenuCategoryEnum) new BaseMethods().selectLeftMenuCategory(driver, category.name(), categoriesMap);
        return getCategoryEnum.getInstance(driver);
    }
}
