package page_object.saucelabs;

import org.openqa.selenium.By;
import page_object.BasePage;

public class LoginPage extends BasePage {
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By submitButton = By.id("login-button");
    By headerLogo = By.cssSelector(".app_logo");



    public LoginPage(String browser, String urls) {
        super(browser);
        visit(urls);
    }

    public void with(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);

    }
    public void withJustUserName(String username) {
        type(usernameInput, username);
        click(submitButton);
    }

    public boolean successBoxPresent() {
        return isDisplayed(headerLogo);
    }

    public String getErrorMessage(String errorMessage) {
        By tes = By.xpath("//h3[.='"+errorMessage+"']");
        return getText(tes);

    }
}
