package base;

import drivers.DriverFactory;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    @Step("Setup WebDriver and open base URL")
    void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    @Step("Quit WebDriver")
    void tearDown() {
        DriverFactory.quitDriver();
    }
}
