package framework;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static framework.PlatformFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Log4j2
public class Wait {

    public static boolean waitUntilVisible(WebElement element) {
        try {
            new FluentWait<>(getDriver())
                    .withTimeout(Duration.ofSeconds(Config.timeout))
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class)
                    .until(visibilityOf(element));
        } catch (TimeoutException e) {
            log.error("Element is not displayed");
            return false;
        }
        log.info("Element is displayed");
        return true;
    }

    public static boolean waitUntilListIsNotEmpty(String xpath) {
        try {
            new FluentWait<>(getDriver())
                    .withTimeout(Duration.ofSeconds(Config.timeout))
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class)
                    .until(numberOfElementsToBeMoreThan(By.xpath(xpath), 1));
        } catch (TimeoutException e) {
            log.error("List is empty");
            return false;
        }
        log.info("List contains elements");
        return true;
    }
}
