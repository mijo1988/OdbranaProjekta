package gigatron;

import enumeration.Urls;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_object.gigatron.IndexPage;

import static enumeration.DataSet.VERTICAL_MENU_PRODUCTS;
import static enumeration.Urls.GIGATRON_INDEX_PAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestIndexPage {
    IndexPage indexPage;


    @BeforeEach
    void setup() {
        indexPage = new IndexPage("chrome", GIGATRON_INDEX_PAGE.getUrls());
    }

    @AfterEach
    void teardown() {
        indexPage.quit();
    }


    @Test
    void gigatronPageIsDisplayed() {
        assertThat(indexPage.logoIsDisplayed()).isTrue();
    }

    @Test
    void iCanSeeCookiesInfo() {
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(indexPage.getMainTextFromCookies()).isEqualTo("Obaveštenje o kolačićima");
        softAssert.assertThat(indexPage.acceptCookiesButtonIsDisplayed()).isTrue();
        softAssert.assertThat(indexPage.getTextFromAcceptCookiesButton()).isEqualTo("Prihvatam");
        softAssert.assertAll();
    }

    @Test
    void iCanAcceptCookies() {
        indexPage.userAcceptsCookies();
        assertThat(indexPage.acceptCookiesButtonIsDisplayed()).isFalse();

    }

    @Test
    void iCanSeeListOfProducts() {
        indexPage.userAcceptsCookies();
        indexPage.openProductsMenu();
        assertThat(indexPage.getListOfProducts()).isEqualTo(VERTICAL_MENU_PRODUCTS.getDataset());



    }


}
