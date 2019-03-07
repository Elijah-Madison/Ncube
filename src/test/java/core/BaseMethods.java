package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import menu.main.CategoriesMenuEnum;

import java.util.List;
import java.util.Map;

import static core.GlobalElements.moreGoods;

public class BaseMethods {

    public WebElement getElementWithWaitForVisibility(WebDriver driver, By xpath, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.withMessage("Element by path " + xpath + " is not visible").until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
    }

    public WebElement waitElementToBeClickable(WebDriver driver, By xpath, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.withMessage("Element by path " + xpath + " is not clickable").until(ExpectedConditions.elementToBeClickable(driver.findElement(xpath)));
    }


    public List<WebElement> getAllElementsWithWaitForVisibility(WebDriver driver, By xpath, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.withMessage("Element by path " + xpath + " is not visible").until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
    }

    public boolean switchPage(WebDriver driver, String currentUrl, final int checkPageNum) {
        try {
            getElementWithWaitForVisibility(driver, moreGoods, 10);
        } catch (NoSuchElementException ignore) {
            return false;
        }
        int index = currentUrl.lastIndexOf("/");
        if (index != -1)
            currentUrl = currentUrl.substring(0, index).toString();
        driver.get(currentUrl + ";page=" + checkPageNum);
        return true;
    }

    public CategoriesMenuEnum selectLeftMenuCategory(final WebDriver driver, final String category, final Map<CategoriesMenuEnum, By> categoriesMap) {
        for(Map.Entry<CategoriesMenuEnum, By> cat : categoriesMap.entrySet()){
            if(cat.getKey().toString().equals(category)){
                getElementWithWaitForVisibility(driver, cat.getValue(), 5);
                waitElementToBeClickable(driver, cat.getValue(), 5).click();
                return cat.getKey();
            }
        }
        throw new java.util.NoSuchElementException("There is no such category in left menu.");
    }

}
