package framework;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

public class SoftAssert extends Assertion {

    public static boolean isElementDisplayedSoft(WebElement element) {
        boolean result = true;

        try {
            element.isDisplayed();
        } catch (NoSuchElementException ignored) {
            result = false;
        }
        return result;
    }

}

