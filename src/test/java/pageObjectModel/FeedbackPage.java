package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedbackPage extends BasePage{

	public FeedbackPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='name']")
	WebElement txtNameBox;
	
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmailBox;
	
	@FindBy(xpath="//input[@id='subject']")
	WebElement txtSubjectBox;
	
	@FindBy(xpath="//textarea[@id='comment']")
	WebElement txtQuestionsBox;
	
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//input[@name='clear']")
	WebElement btnClear;

	
	@FindBy(xpath = "//div[@class='offset3 span6']")
	WebElement msgConfirmation;

	public void enterName(String name) {
 
        txtNameBox.sendKeys(name);
    }

    public void enterEmail(String email) {
 
        txtEmailBox.sendKeys(email);
    }

    public void enterSubject(String subject) {
   
        txtSubjectBox.sendKeys(subject);
    }

    public void enterQuestions(String questions) {
       
        txtQuestionsBox.sendKeys(questions);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public void clickClear() {
        btnClear.click();
    }
    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
	
	
	
}
