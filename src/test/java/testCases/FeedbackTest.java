package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.FeedbackPage;
import pageObjectModel.HomePageNavigationBar;
import utilities.ExcelUtils;

public class FeedbackTest {
	     WebDriver driver;
	    
         @BeforeClass
         public void setup()
         {
             driver = new ChromeDriver();
             driver.manage().deleteAllCookies();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

             driver.get("http://zero.webappsecurity.com/index.html");
             driver.manage().window().maximize();
         }

//         @AfterClass
//         public void tearDown()
//         {
//             driver.quit();
//         }
         
         @Test(dataProvider = "FeedbackData")
         public void verify_account_registration(String name, String email, String subject, String question) {
             
             driver.get("http://zero.webappsecurity.com/index.html"); 
        	 
        	 HomePageNavigationBar hp = new HomePageNavigationBar(driver);
             
             
             hp.clickFeedbackButton();

             FeedbackPage fdp = new FeedbackPage(driver);
             fdp.enterName(name);
             fdp.enterEmail(email);
             fdp.enterSubject(subject);
             fdp.enterQuestions(question);
             fdp.clickSubmit();

             String confmsg = fdp.getConfirmationMsg();
             System.out.println("Confirmation Message: " + confmsg);
             
         }
         
         @DataProvider(name = "FeedbackData")
         public Object[][] getFeedbackData() throws Exception {
             String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/FeedbackData.xlsx";
             return ExcelUtils.getSheetData(filePath, "Sheet1");
         }
}
