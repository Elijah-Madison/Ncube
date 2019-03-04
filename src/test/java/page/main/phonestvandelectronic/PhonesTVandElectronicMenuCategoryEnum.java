package page.main.phonestvandelectronic;

import org.openqa.selenium.WebDriver;
import page.main.phonestvandelectronic.mobile.PhonesPage;

public enum PhonesTVandElectronicMenuCategoryEnum {
    PHONES_CAT {
        @Override
        PhonesPage getInstance(WebDriver driver) {
            return new PhonesPage(driver);
        }
    };

    abstract <T> T getInstance(WebDriver driver);
}
