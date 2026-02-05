package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage {

    private final By title = By.className("title");

    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public boolean waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
