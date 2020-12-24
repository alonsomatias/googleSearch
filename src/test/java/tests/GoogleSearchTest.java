package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.BookPage;
import pages.HomePage;
import pages.SearchResultsPage;

public class GoogleSearchTest extends BaseTest{
	
	private String pageName = "The Books - Patrick Rothfuss";

  HomePage homePage = new HomePage();
  SearchResultsPage searchResultsPage = new SearchResultsPage();
  BookPage bookPage = new BookPage();

  @Test
  public void SearchByNameTest() {
	  String search = "The name of the wind";
	  homePage.visit()
	  	.inputSearchText(search)
	  	.submit();
	  String resultText = searchResultsPage.getResultText(1);
	  
	  assertTrue(pageName.equals(resultText),
			  "The result should be " + pageName + " and was " + resultText);
	  
	  searchResultsPage.clickSearchResultByIndex(0);
	  assertTrue(bookPage.isActualUrl(), "Book page is not displayed");
  }
  
  @Test
  public void SearchBySuggestionTest() {
	  String search = "The name of the w";
	  homePage.visit()
	  	.inputSearchText(search)
	  	.clickSuggestion(0);
	  String resultText = searchResultsPage.getResultText(1);
	  
	  assertTrue(pageName.equals(resultText),
			  "The result should be " + pageName + " and was " + resultText);
	  
	  searchResultsPage.clickSearchResultByIndex(0);
	  assertTrue(bookPage.isActualUrl(), "Book page is not displayed");
  }
  
  @Test
  public void SearchByNameFixedTest() {
	  String search = "The name of the wind";
	  homePage.visit()
	  	.inputSearchText(search)
	  	.submit();
	  searchResultsPage.clickSearchResultByText(pageName);

	  assertTrue(bookPage.isActualUrl(), "Book page is not displayed");
  }
  
  @Test
  public void SearchBySuggestionTestFixed() {
	  String search = "The name of the w";
	  homePage.visit()
	  	.inputSearchText(search)
	  	.clickSuggestion(0);
	  searchResultsPage.clickSearchResultByText(pageName);

	  assertTrue(bookPage.isActualUrl(), "Book page is not displayed");
  }
}
