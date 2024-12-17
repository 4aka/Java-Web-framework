package framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Keywords {

    public static void sendEnter(WebElement e) {
        e.sendKeys(Keys.ENTER);
    }

    public static void sendSpace(WebElement e) {
        e.sendKeys(Keys.SPACE);
    }

    public static void sendEscape(WebElement e) {
        e.sendKeys(Keys.ESCAPE);
    }

    public static void sendTab(WebElement e) {
        e.sendKeys(Keys.TAB);
    }


}
