package pages;

public class BookPage extends BasePage{

	private String url = "https://www.patrickrothfuss.com/content/books.asp";
	
	public boolean isActualUrl() {
		if(getUrl().equals(url)) {
			return true;
		}
		return false;
	}
}
