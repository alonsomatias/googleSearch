package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage{

	private String resultsXpath = "//span[@id=\"fld\"]//following-sibling::div";
			
	private By searchResultsLocators = By.xpath(resultsXpath);
	private By searchResultsTextsLocators  = By.xpath(resultsXpath + "//h3/span");
	
	public SearchResultsPage clickSearchResultByIndex(int index) {
		findElements(searchResultsLocators).get(index).click();
		return this;
	}
	
	public SearchResultsPage clickSearchResultByText(String text) {
		findElementByText(text, searchResultsTextsLocators).click();;
		return this;
	}
	
	public String getResultText(int index) {
		return findElements(searchResultsLocators).get(index).getText();
	}
}
