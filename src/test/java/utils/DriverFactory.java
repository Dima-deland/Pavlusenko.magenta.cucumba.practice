package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class DriverFactory {
    public static WebDriver get(Scenario scenario) throws URISyntaxException, MalformedURLException {
        WebDriver driver;
        String browser = ConfigurationReader.get("browser");

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                if (ConfigurationReader.get("headless").toLowerCase().contains("true")) {
                    options.addArguments("--headless");
                }

                if (ConfigurationReader.get("remote_server").toLowerCase().contains("true")) {
                    options.setCapability("platformName", ConfigurationReader.get("remote_server_platform"));
                    options.setCapability("se:name", scenario.getName());
                    driver = new RemoteWebDriver(new URI(ConfigurationReader.get("remote_server_url")).toURL(), options);
                } else {
                    driver = new ChromeDriver(options);
                }


                if (ConfigurationReader.get("maximize").toLowerCase().contains("true")) {
                    driver.manage().window().maximize();
                }
                return driver;
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
        }
        throw new WebDriverException("Browser parameter isn't chosen in configuration.properties");
    }
}


