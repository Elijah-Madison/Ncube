package test.main.phonestvandelectronic.mobile;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.main.MainPage;
import page.main.phonestvandelectronic.PhonesTVandElectronicPage;
import page.main.phonestvandelectronic.mobile.PhonesPage;

import java.util.List;
import java.util.Optional;

import static page.main.MainLeftMenu.MainMenuCategoryEnum;
import static page.main.phonestvandelectronic.PhonesTVandElectronicLeftMenu.PhonesTVandElectronicMenuCategoryEnum;
import static page.main.phonestvandelectronic.mobile.PhonesLeftMenu.PhonesLeftMenuCategoryEnum;

public class PhonesPageTest extends PhonesPage {

    @AfterMethod
    public void quit() {
        quitDriver();
    }

    @Test
    public void verifyTopSalesProductsNotMoreThenThreePerPageTest() {
        int checkPageNum = 3;
        int topSalesProductMax = 3;

        MainPage mainPage = new MainPage();
        mainPage.openUrl(); // - зайти на сайт rozetka.com.ua
        PhonesTVandElectronicPage phonesTVandElectronicPage = mainPage.leftMenuSwitch(MainMenuCategoryEnum.PHONE_AND_ELECTRONIC_CAT); //- перейти у розділ “смартфониб тв і електроніка”
        PhonesPage phonesPage = phonesTVandElectronicPage.leftMenuSwitch(PhonesTVandElectronicMenuCategoryEnum.PHONES_CAT);   //- перейти у “Телефоны”
        phonesPage.leftMenuSwitch(PhonesLeftMenuCategoryEnum.SMARTPHONE_CAT);//- перейти у “Смартфоны”
        List<Integer> findResultsNumPerPage = phonesPage.getTopSalesProductsNumPerPage(checkPageNum);//- вибрати з перших трьох сторінок пошукової видачі назви і цини всіх девайсів позначених як “Топ продажів”
        Optional<Integer> topSalesMoreThenMaxExpected = findResultsNumPerPage.stream().filter(count -> count > topSalesProductMax).findAny(); //- Перевірити що таких девайсів на кожній сторінці не більше трьох
        Assert.assertTrue(!topSalesMoreThenMaxExpected.isPresent(),
                "Top sales products result. Expected result, not more than: " + topSalesProductMax + " per page.");
    }

}
