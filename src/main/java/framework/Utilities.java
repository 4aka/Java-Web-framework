package framework;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static framework.PlatformFactory.getDriver;

@Log4j2
public class Utilities {

    public static WebElement find(By locator) {
        return getDriver().findElement(locator);
    }
}
