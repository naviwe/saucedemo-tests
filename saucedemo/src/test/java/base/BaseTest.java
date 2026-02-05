package base;

import config.ConfigReader;
import drivers.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    protected static final String BASE_URL = ConfigReader.get("base.url");

    @BeforeEach
    void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }
}
