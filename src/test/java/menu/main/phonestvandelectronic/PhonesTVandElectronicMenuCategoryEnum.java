package menu.main.phonestvandelectronic;

import org.openqa.selenium.WebDriver;
import menu.main.CategoriesMenuEnum;
import page.main.phonestvandelectronic.mobile.PhonesPage;

public enum PhonesTVandElectronicMenuCategoryEnum implements CategoriesMenuEnum {
    PHONES_CAT {
        @Override
        public PhonesPage getInstance(WebDriver driver) {
            return new PhonesPage(driver);
        }
    };

}
