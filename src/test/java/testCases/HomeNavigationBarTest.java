package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.HomePageNavigationBar;

public class HomeNavigationBarTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void navivation_bar_verification() {
		HomePageNavigationBar hp = new HomePageNavigationBar(driver);

	    // --- Home Page ---
	    boolean headerDisplayed = hp.isHeaderNavbarDisplayed();
	    boolean navigationBarDisplayed = hp.isNavigationBarDisplayed();

	    System.out.println("----- Home Page -----");
	    System.out.println("Header Displayed: " + headerDisplayed);
	    System.out.println("Navigation Bar Displayed: " + navigationBarDisplayed);

	    Assert.assertTrue(headerDisplayed, "Header not displayed on Home Page");
	    Assert.assertTrue(navigationBarDisplayed, "Navigation bar not displayed on Home Page");

	    // --- Online Banking Page ---
	    hp.clickOnlineBankingButton();
	    headerDisplayed = hp.isHeaderNavbarDisplayed();
	    navigationBarDisplayed = hp.isNavigationBarDisplayed();

	    System.out.println("----- Online Banking Page -----");
	    System.out.println("Header Displayed: " + headerDisplayed);
	    System.out.println("Navigation Bar Displayed: " + navigationBarDisplayed);

	    Assert.assertTrue(headerDisplayed, "Header not displayed on Online Banking Page");
	    Assert.assertTrue(navigationBarDisplayed, "Navigation bar not displayed on Online Banking Page");

	    // --- Feedback Page ---
	    hp.clickFeedbackButton();
	    headerDisplayed = hp.isHeaderNavbarDisplayed();
	    navigationBarDisplayed = hp.isNavigationBarDisplayed();

	    System.out.println("----- Feedback Page -----");
	    System.out.println("Header Displayed: " + headerDisplayed);
	    System.out.println("Navigation Bar Displayed: " + navigationBarDisplayed);

	    Assert.assertTrue(headerDisplayed, "Header not displayed on Feedback Page");
	    Assert.assertTrue(navigationBarDisplayed, "Navigation bar not displayed on Feedback Page");

	    System.out.println("All pages verified successfully.");
	} 

}
