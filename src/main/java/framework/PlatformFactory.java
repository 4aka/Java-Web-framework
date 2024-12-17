package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PlatformFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        switch(Config.platform) {

            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (driver != null)
            driver.get().quit();
    }
}
