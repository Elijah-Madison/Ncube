package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static page.main.GlobalElements.moreGoods;

public class BaseMethods {

    public static WebElement getElementWithWaitForVisibility(WebDriver driver, By xpath, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.withMessage("Element by path " + xpath + " is not visible").until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
    }


    public static List<WebElement> getAllElementsWithWaitForVisibility(WebDriver driver, By xpath, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.withMessage("Element by path " + xpath + " is not visible").until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
    }

    public static boolean switchPage(WebDriver driver, String currentUrl, final int checkPageNum) {
        try {
            getElementWithWaitForVisibility(driver, moreGoods, 10);
        } catch (NoSuchElementException ignore) {
            return false;
        }
        int index = currentUrl.lastIndexOf("/");
        if (index != -1)
            currentUrl = new StringBuilder(currentUrl).substring(0, index).toString();
        driver.get(currentUrl + ";page=" + checkPageNum);
        return true;
    }

}
