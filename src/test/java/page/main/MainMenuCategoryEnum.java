package page.main;

import org.openqa.selenium.WebDriver;
import page.main.phonestvandelectronic.PhonesTVandElectronicPage;

public enum MainMenuCategoryEnum {
    PHONE_AND_ELECTRONIC_CAT {
        @Override
        PhonesTVandElectronicPage getInstance(WebDriver driver) {
            return new PhonesTVandElectronicPage(driver);
        }
    };

    abstract <T> T getInstance(WebDriver driver);
}
