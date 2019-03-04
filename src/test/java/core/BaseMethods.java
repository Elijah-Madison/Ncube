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

    public WebElement getElementWithWaitForVisibility(WebDriver driver, By xpath, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.withMessage("Element by path " + xpath + " is not visible").until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
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

}
