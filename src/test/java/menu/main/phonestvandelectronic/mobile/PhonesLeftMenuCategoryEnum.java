package menu.main.phonestvandelectronic.mobile;

import org.openqa.selenium.WebDriver;
import menu.main.CategoriesMenuEnum;
import page.main.phonestvandelectronic.mobile.PhonesPage;

public enum PhonesLeftMenuCategoryEnum implements CategoriesMenuEnum {
    SMARTPHONE_CAT;
    @Override
    public PhonesPage getInstance(WebDriver driver) {
        return new PhonesPage(driver);
    }
}
