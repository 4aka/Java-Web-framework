package pages;

import framework.PlatformFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(PlatformFactory.getDriver(), this);
    }

}
