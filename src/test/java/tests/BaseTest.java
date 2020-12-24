package tests;

import driver.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseTest {

  @BeforeTest
  public void beforeTest() {
	  DriverManager.getDriver().manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  DriverManager.getDriver().quit();
  }

}
