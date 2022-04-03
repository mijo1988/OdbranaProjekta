package sauce_demo;

import enumeration.Urls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_object.saucelabs.OrdersPage;

import static enumeration.Users.SWAG_STANDAR_USER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOrder {
    String errorMessage;
    OrdersPage order;


    @BeforeEach
    void setup() {
        order = new OrdersPage("chrome", Urls.SAUCEDEMO_LOGIN.getUrls());
    }

    @AfterEach
    void teardown() {
        order.quit();
    }


    @Test
    void testLoginWithoutPass() {
        errorMessage = "Sauce Labs Backpack";
        order.with(SWAG_STANDAR_USER.getUserName(),SWAG_STANDAR_USER.getPassword());
        assertThat(order.getErrorMessage(errorMessage)).isEqualTo(errorMessage);
    }



}
