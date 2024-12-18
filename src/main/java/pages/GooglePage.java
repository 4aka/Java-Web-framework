package pages;

import enums.Tabs;
import framework.Keywords;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static framework.PlatformFactory.getDriver;
import static framework.Wait.waitUntilListIsNotEmpty;
import static framework.Wait.waitUntilVisible;

@Log4j2
public class GooglePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"rso\"]/div")
    private List<WebElement> search_result;

    @FindBy(xpath = "//*[@id=\"rso\"]/div")
    private List<WebElement> firstResult;

    @FindBy(xpath = "//*[@id=\"hdtb-sc\"]//*[text()=\"All\"]")
    private WebElement all_tab;


    @Step("Input search parameters: {0}")
    public void inputSearchParameters(String searchParams) {
        waitUntilVisible(searchField);
        searchField.click();
        searchField.sendKeys(searchParams);
        log.info("Search parameters was entered");
    }

    public void executeSearch() {
        Keywords.sendEnter(searchField);
    }

    public List<WebElement> getSearchResult() {
        String xpath = "//*[@id=\"rso\"]/div";
        waitUntilListIsNotEmpty(xpath);
        return search_result;
    }

    public WebElement getTab(Tabs tab) {
        String xpath = "//*[@id=\"hdtb-sc\"]//*[text()=\"" + tab.getTab() + "\"]";

        waitUntilVisible(all_tab);
        return getDriver().findElement(By.xpath(xpath));
    }

    public Boolean assertThatSearchContainsUrl(String url) {
        String xpath = "//*[@id=\"search\"]//*[text()=\"" + url + "\"]";
        return getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }


}
