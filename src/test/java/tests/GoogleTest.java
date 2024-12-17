package tests;

import framework.AllureListener;
import framework.DriverActions;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GooglePage;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

@Epic("Search")
@Feature("Google Search Test")
@Listeners(AllureListener.class)
public class GoogleTest extends BaseTest {

    GooglePage googlePage;

    @BeforeMethod
    public void setUp() {
        DriverActions.open("https://www.google.com/");
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

}
