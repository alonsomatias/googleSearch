package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

	private static DriverManager instance = new DriverManager();
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	private DriverManager() {
		String driverPath;
		if (getProperty().contains("Mac")) {
			driverPath = "./src/test/resources/chromedriver/chromedriver_mac";
		}else {
			driverPath = "./src/test/resources/chromedriver/chromedriver.exe";
		}
		System.setProperty("webdriver.chrome.driver", driverPath);
		DriverManager.driver = new ChromeDriver();
		DriverManager.wait = new WebDriverWait(driver, 7);
	}
	
	private String getProperty() {
		System.out.println(System.getProperty("os.name").toString());
		return System.getProperty("os.name").toString();
	}
	
	private static DriverManager getInstance() {
		return instance;
	}
	
	public static WebDriver getDriver() {
		DriverManager.getInstance();
		return DriverManager.driver;
	}
	
	public static WebDriverWait getWait() {
		DriverManager.getInstance();
		return DriverManager.wait;
	}
}
