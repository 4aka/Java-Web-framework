package tests;

import enums.Tabs;
import framework.AllureListener;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GooglePage;

import java.util.List;

import static framework.Config.baseUrl;
import static framework.DriverActions.open;
import static org.testng.AssertJUnit.assertTrue;

@Epic("Search")
@Feature("Google Search Test")
@Listeners(AllureListener.class)
public class GoogleTest extends BaseTest {

    GooglePage googlePage;
    final private String booksUrl = "books.google.com.ua";

    @BeforeMethod
    public void setUp() {
        open(baseUrl);
        googlePage = new GooglePage();
    }

    @Test
    @Story("STORY-1")
    @Description("Test for search")
    @Issue("JIRA-111")
    public void searchTest() {
        googlePage.inputSearchParameters("fff");
        googlePage.executeSearch();

        assertTrue(googlePage.getSearchResult().size() > 1);
    }

    @Test
    @Story("STORY-1")
    @Description("Open link from results")
    public void openFirstLinkInResult() {
        googlePage.inputSearchParameters("Sun wiki");
        googlePage.executeSearch();
        List<WebElement> results = googlePage.getSearchResult();

        assertTrue(results.get(0).getText().contains("Sun"));
    }

    @Test
    @Story("STORY-1")
    @Description("Check tabs")
    public void checkTabs() {
        googlePage.inputSearchParameters("Sun wiki");
        googlePage.executeSearch();

        assertTrue(googlePage.getTab(Tabs.ALL).isDisplayed());
        assertTrue(googlePage.getTab(Tabs.IMAGES).isDisplayed());
        assertTrue(googlePage.getTab(Tabs.MORE).isDisplayed());
    }

    @Test
    @Story("STORY-1")
    @Description("Open video tab")
    public void openVideoTab() {
        googlePage.inputSearchParameters("Sun wiki");
        googlePage.executeSearch();
        googlePage.getTab(Tabs.VIDEOS).click();

        assertTrue(googlePage.getTab(Tabs.VIDEOS).isDisplayed());
        assertTrue(googlePage.getTab(Tabs.VIDEOS).isEnabled());
    }

    @Test
    @Story("STORY-1")
    @Description("Open more tab and select ")
    public void openMoreTab() {
        googlePage.inputSearchParameters("Sun wiki");
        googlePage.executeSearch();
        googlePage.getTab(Tabs.MORE).click();
        googlePage.getTab(Tabs.BOOKS).click();

        assertTrue(googlePage.assertThatSearchContainsUrl(booksUrl));
    }




}
