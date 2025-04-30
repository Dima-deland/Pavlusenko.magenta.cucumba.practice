package tests;

import context.TestContext;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {
    protected static TestContext context;

    @BeforeAll
    public static void before() throws InterruptedException {
        context =new TestContext();
        context.driver = DriverFactory.get();
        long duration = Long.parseLong(ConfigurationReader.get("timeout"));
        context.wait =new WebDriverWait(context.driver, Duration.ofSeconds(duration));
        context.action =new Actions(context.driver);
    }

    @AfterAll
    public static void after() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }

}
