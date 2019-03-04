package page.main.phonestvandelectronic;

import core.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PhonesTVandElectronicLeftMenu extends PhonesTVandElectronicPage {
    private static final By phone = By.xpath(".//a[ @class='m-cat-l-i-title-link' and text()= 'Телефоны']");

    private static Map<Enum<PhonesTVandElectronicMenuCategoryEnum>, By> categoriesMap;

    static {
        categoriesMap = new HashMap<>();
        categoriesMap.put(PhonesTVandElectronicMenuCategoryEnum.PHONES_CAT, phone);
    }

    public <T> T selectMenuCategory(final WebDriver driver, final PhonesTVandElectronicMenuCategoryEnum category) {
        Optional<By> menuCat = categoriesMap.entrySet()
                .stream()
                .filter(e -> e.getKey() == category)
                .map(Map.Entry::getValue)
                .findFirst();
        if (menuCat.isPresent()) {
            BaseMethods.getElementWithWaitForVisibility(driver, menuCat.get(), 5).click();
            return category.getInstance(driver);
        } else {
            throw new NoSuchElementException("There is no such category in left menu.");
        }
    }
}
