package pages;

import config.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage openPage() {
        open(ConfigReader.get("base.url"));
        return this;
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    @Step("Enter password: {password}")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Login with username: {user} and password: {pass}")
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    @Step("Get error message text")
    public String getErrorText() {
        return driver.findElement(errorMessage).getText();
    }
}
