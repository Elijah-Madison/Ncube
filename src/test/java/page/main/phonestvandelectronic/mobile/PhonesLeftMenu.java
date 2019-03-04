package page.main.phonestvandelectronic.mobile;

import core.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PhonesLeftMenu extends PhonesPage{
    private final static By smartPhone = By.xpath(".//a[ @class='m-cat-l-i-title-link' and text()= 'Смартфоны']");

    private static Map<Enum<PhonesLeftMenuCategoryEnum>, By> categoriesMap;
    static {
        categoriesMap = new HashMap<>();
        categoriesMap.put(PhonesLeftMenuCategoryEnum.SMARTPHONE_CAT, smartPhone);
    }

    public void selectMenuCategory(final WebDriver driver, final PhonesLeftMenuCategoryEnum category) {
        Optional<By> menuCat = categoriesMap.entrySet()
                .stream()
                .filter(e -> e.getKey() == category)
                .map(Map.Entry::getValue)
                .findFirst();
        if (menuCat.isPresent()) {
            BaseMethods.getElementWithWaitForVisibility(driver, menuCat.get(), 5).click();
        } else {
            throw new NoSuchElementException("There is no such category in left menu.");
        }
    }
}
