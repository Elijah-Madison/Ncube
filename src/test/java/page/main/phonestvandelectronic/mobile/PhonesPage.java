package page.main.phonestvandelectronic.mobile;

import core.BaseMethods;
import core.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static page.main.GlobalElements.*;

public class PhonesPage {

    public PhonesPage() {
        if (driver == null) {
            driver = DriverConfig.getDriver();
            currentUrl = driver.getCurrentUrl();
        }
    }

    public PhonesPage(WebDriver driver) {
        this.driver = driver;
        currentUrl = driver.getCurrentUrl();
    }

    private WebDriver driver;
    private String currentUrl;

    public void openUrl() {
        DriverConfig.openPage();
    }

    protected void quitDriver() {
        driver.quit();
    }

    public void leftMenuSwitch(final PhonesLeftMenu.PhonesLeftMenuCategoryEnum category) {
        new PhonesLeftMenu(driver).selectMenuCategory(driver, category);
        currentUrl = driver.getCurrentUrl();
    }

    public List<Integer> getTopSalesProductsNumPerPage(int setNumOfPageForCheck) {
        int switchPageNum = 2;
        List<String> productInfo = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        List<String> productTitles = new ArrayList<>();
        List<Integer> topSalesProductsPerPage = new ArrayList<>();
        while (switchPageNum <= setNumOfPageForCheck) {
            //find all top sales products price and title and add them to lists
            List<String> pricesAsList = textValues(price);
            prices.addAll(pricesAsList);
            List<String> productTitlesAsList = textValues(productTitle);
            productTitles.addAll(productTitlesAsList);
            //check that product info such as price and title are paired
            if(pricesAsList.size() != productTitlesAsList.size()) throw new NullPointerException("Not all products have title or price");
            //add top sales product per one page
            topSalesProductsPerPage.add(pricesAsList.size());
            //switch to the next page
            BaseMethods.switchPage(driver, currentUrl, switchPageNum);
            switchPageNum++;
        }
        //find all top sales products and add them to overall productInfo list
        for (int num = 0; num < productTitles.size(); num++) {
            productInfo.add("Наименование продукта: \"" + productTitles.get(num) + "\" | Цена: " + prices.get(num) + "\n");
        }
        System.out.println(productInfo);
        return topSalesProductsPerPage;
    }

    //take text value from tags and convert webElement to string in List
    private List<String> textValues(By recordInfo) {
        //wait for results products table load
        BaseMethods.getElementWithWaitForVisibility(driver, productsTable, 5);
        return getValues(e -> e.getText(), recordInfo);
    }

    private List<String> getValues(Function<WebElement, String> pred, By recordInfo) {
        List<WebElement> elements = driver.findElements(recordInfo);
        List<String> topSalesProductsInfo = elements.stream()
                .map(pred)
                .collect(Collectors.toList());
        return topSalesProductsInfo;
    }

}
