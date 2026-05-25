package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage()
              .timeouts()
              .implicitlyWait(
                      Duration.ofSeconds(10));

        // IMPORTANT
        driver.get(
        "https://tutorialsninja.com/demo/");

        return driver;
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static void quitDriver() {

        if(driver != null) {

            driver.quit();

            driver = null;
        }
    }
}