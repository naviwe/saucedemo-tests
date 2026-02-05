package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void successfulLogin() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage
                .openPage()
                .login("standard_user", "secret_sauce");

        assertTrue(inventoryPage.isOpened());
    }

    @Test
    void notCorrectPassword() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login("standard_user", "invalid_sauce");

        assertTrue(loginPage.getErrorText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    void blockedUser() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.getErrorText().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    void emptyFields() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login("", "");

        assertTrue(loginPage.getErrorText().contains("Epic sadface: Username is required"));
    }

    @Test
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
