package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageNavigationBar extends BasePage{

	public HomePageNavigationBar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//strong[normalize-space()='Feedback']")
	WebElement feedBackButton;
	
	@FindBy(xpath="//li[@id='onlineBankingMenu']//div")
	WebElement onlineBankingButton;
	
	@FindBy(xpath="//div[@class='navbar-inner']//div[@class='container']")
	WebElement headerNavbar;
	
	@FindBy(xpath="//div[@id='nav']")
	WebElement navigationBar;
	
	
	public void clickFeedbackButton()
	{
		feedBackButton.click();
	}
	public void clickOnlineBankingButton()
	{
		onlineBankingButton.click();
	}
	
	
	public boolean isHeaderNavbarDisplayed() {
	    try {
	        return headerNavbar.isDisplayed();
	    } catch (Exception e) {
	        return false;  
	    }
	}

	public boolean isNavigationBarDisplayed() {
	    try {
	        return navigationBar.isDisplayed();
	    } catch (Exception e) {
	        return false; 
	    }
	}

	
	
	
	
}
