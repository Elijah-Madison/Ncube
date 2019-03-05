package page.main.phonestvandelectronic.mobile;

import core.BaseMethods;
import core.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static page.main.GlobalElements.*;

public class PhonesPage {

    public PhonesPage(WebDriver driver) {
        this.driver = driver;
        currentUrl = driver.getCurrentUrl();
    }

    private DriverConfig driverConfig = new DriverConfig();
    private BaseMethods baseMethods = new BaseMethods();
    private WebDriver driver;
    private String currentUrl;

    public void openUrl() {
        driverConfig.openPage();
    }

    protected void quitDriver() {
        driver.quit();
    }

    public void leftMenuSwitch(final PhonesLeftMenuCategoryEnum category) {
        new PhonesLeftMenu().leftMenuSwitch(driver, category);
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
            List<String> pricesPerPage = getTextValues(price);
            prices.addAll(pricesPerPage);
            List<String> productTitlesPerPage = getTextValues(productTitle);
            productTitles.addAll(productTitlesPerPage);
            //add top sales product per one page
            topSalesProductsPerPage.add(pricesPerPage.size());
            //switch to the next page
            baseMethods.switchPage(driver, currentUrl, switchPageNum);
            switchPageNum++;
        }

        //find all top sales products and add them to overall productInfo list
        for (int num = 0; num < productTitles.size(); num++) {
            productInfo.add("Наименование продукта: \"" + productTitles.get(num) + "\" | Цена: " + prices.get(num) + "\n");
        }
        System.out.println(productInfo);

        //check that product info such as price and title are paired
        if (prices.size() != productTitles.size())
            throw new NullPointerException("Not all products have title or price");
        return topSalesProductsPerPage;
    }

    //take text value from tags and convert webElement to string in List
    private List<String> getTextValues(By recordInfo) {
        //wait for results products table load
        baseMethods.getElementWithWaitForVisibility(driver, productsTable, 5);

        List<WebElement> elements = driver.findElements(recordInfo);
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
