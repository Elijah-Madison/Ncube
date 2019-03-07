package menu.main;

import org.openqa.selenium.WebDriver;
import page.main.phonestvandelectronic.PhonesTVandElectronicPage;

public enum MainMenuCategoryEnum implements CategoriesMenuEnum {
    PHONE_AND_ELECTRONIC_CAT {
        @Override
        public PhonesTVandElectronicPage getInstance(WebDriver driver) {
            return new PhonesTVandElectronicPage(driver);
        }
    };
}
