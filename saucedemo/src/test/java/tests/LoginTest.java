package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Authentication")
@Feature("Login")
public class LoginTest extends BaseTest {

    @Test
    @Story("Successful login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that user can log in with standard_user credentials and access the inventory page")
    void successfulLogin() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage
                .openPage()
                .login("standard_user", "secret_sauce");

        assertTrue(inventoryPage.isOpened());
    }

    @Test
    @Story("Login attempt with incorrect password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user sees correct error message when entering wrong password")
    void notCorrectPassword() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login("standard_user", "invalid_sauce");

        assertTrue(loginPage.getErrorText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    @Story("Login attempt with blocked user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that locked_out_user cannot log in and sees the proper error message")
    void blockedUser() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.getErrorText().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    @Story("Login attempt with empty username and password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user sees an error message when leaving username and password empty")
    void emptyFields() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login("", "");

        assertTrue(loginPage.getErrorText().contains("Epic sadface: Username is required"));
    }

    @Test
    @Story("Login with performance glitch user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that performance_glitch_user can log in and inventory page loads correctly despite potential delays")
    void performanceGlitchUserLogin() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage
                .openPage()
                .login("performance_glitch_user", "secret_sauce");

        assertTrue(inventoryPage.waitForPageToLoad(),
                "Inventory page did not load correctly for performance_glitch_user");
    }

}
