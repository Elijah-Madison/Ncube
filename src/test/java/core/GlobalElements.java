package core;

import org.openqa.selenium.By;

public interface GlobalElements {

    By moreGoods = By.xpath(".//div[@name='more_goods']");
    String topSalesProduct = ".//i[@class='g-tag-icon-small-popularity g-tag-i sprite']/ancestor::div[@class='g-i-tile-i-box-desc']";
    By productTitle = By.xpath(topSalesProduct+"/div[@class='g-i-tile-i-title clearfix']");
    By price = By.xpath(topSalesProduct+"//div[@class='g-price-uah']");
    By productsTable = By.xpath(".//div[@class='pos-fix col-main-wrap-reverse']/div[@class='clearfix']");
}
