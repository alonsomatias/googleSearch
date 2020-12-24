package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driver.DriverManager;

public abstract class BasePage {
	
	public WebElement findElement(By locator) {
		return DriverManager.getDriver().findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) {
		return DriverManager.getDriver().findElements(locator);
	}
	
	public WebElement findElementByText(String text, By locator) {
		List<WebElement> list = DriverManager.getDriver().findElements(locator);
		for (WebElement element: list) {
			String elText = element.getText();
			if(element.getText().equals(text)) {
				return element;
			}
		}
		return null;
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return DriverManager.getDriver().findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		DriverManager.getDriver().findElement(locator).sendKeys(inputText);
	}
	
	public void type(String inputText, WebElement element) {
		element.sendKeys(inputText);
	}
	
	public void submit(By locator) {
		DriverManager.getDriver().findElement(locator).submit();
	}
	
	public void submit(WebElement element) {
		element.submit();
	}
	
	public void click(By locator) {
		DriverManager.getDriver().findElement(locator).click();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void visit(String url) {
		DriverManager.getDriver().get(url);
	}
	
	public boolean isDisplayed(By locator) {
		try {
			return DriverManager.getDriver().findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public String getUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}
	
	public void waitForDisplay(By locator) {
		DriverManager.getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
