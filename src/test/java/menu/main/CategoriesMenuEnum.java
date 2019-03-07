package menu.main;

import org.openqa.selenium.WebDriver;

public interface CategoriesMenuEnum {
    abstract <T> T getInstance(WebDriver driver);
}
