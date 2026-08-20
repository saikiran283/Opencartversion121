package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

    

    @Test(groups={"regression","Master"})
    public void verify_account_registration()
    {
    	logger.info("************ Starting  TC001_AccountRegistrationTest ****");
    	try {
    		
    	
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("************ Clicked on My account ****");

        hp.clickRegister();
        logger.info("************ Clicked on Register ****");


        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
        logger.info("************ Providing Customer Details  ****");


        regpage.setFirstName(randomString().toUpperCase());
        regpage.setLastName(randomString().toUpperCase());
        regpage.setEmail(randomString()+"@gmail.com"); // randomly generated the email
        regpage.setTelephone(randomNumber());

        String password=randomAlpha();

        regpage.setPassword(password);
        regpage.setConfirmPassword(password);

        regpage.setPrivacyPolicy();
        regpage.clickContinue();
        logger.info("************ Validating Message ****");


        String confmsg = regpage.getConfirmationMsg();

        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    }
    	catch(Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            logger.debug("Debug Logs");
    		Assert.fail();
    	}
    	logger.info("************ Completed  TC001_AccountRegistrationTest ****");
    }
   
    
    
}