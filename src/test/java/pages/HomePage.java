package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	private String url = "https://www.google.com";
	private By searchBoxLocator = By.name("q");
	private By googleSearchLocator = By.name("btnK");
	private By suggestionsListLocator = By.xpath("//ul[@role='listbox']/li");
	
	public HomePage visit() {
		visit(url);
		return this;
	}
	
	public HomePage inputSearchText(String text) {
		type(text, searchBoxLocator);
		return this;
	}
	
	public HomePage submit() {
		submit(searchBoxLocator);
		return this;
	}
	
	public HomePage clickSuggestion(int index) {
		waitForDisplay(suggestionsListLocator);
		findElements(suggestionsListLocator).get(index).click();
		return this;
	}
	
}
