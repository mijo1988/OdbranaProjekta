package sauce_demo;

import enumeration.Urls;
import enumeration.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_object.saucelabs.LoginPage;

import static enumeration.Users.SWAG_LOCKED_USER;
import static enumeration.Users.SWAG_STANDAR_USER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSwLogin {
    String errorMessage;
    LoginPage login;


    @BeforeEach
    void setup() {
        login = new LoginPage("chrome", Urls.SAUCEDEMO_LOGIN.getUrls());
    }

    @AfterEach
    void teardown() {
        login.quit();
    }

    @Test
    void testLoginSuccess() {
        login.with(SWAG_STANDAR_USER.getUserName(), SWAG_LOCKED_USER.getPassword());
        assertThat(login.successBoxPresent()).isTrue();
    }

    @Test
    void testLoginWithoutPass() {
        errorMessage = "Epic sadface: Password is required";
        login.withJustUserName(SWAG_LOCKED_USER.getUserName());
        assertThat(login.getErrorMessage(errorMessage)).isEqualTo(errorMessage);
    }

    @Test
    void testLoginWithoutUser() {
        errorMessage = "Epic sadface: Username is required";
        login.withJustUserName("");
        assertThat(login.getErrorMessage(errorMessage)).isEqualTo(errorMessage);
    }

    @Test
    void testLoginWithLockedUser() {
        errorMessage = "Epic sadface: Sorry, this user has been locked out.";
        login.with(SWAG_LOCKED_USER.getUserName(), SWAG_LOCKED_USER.getPassword());
        assertThat(login.getErrorMessage(errorMessage)).isEqualTo(errorMessage);
    }

}
