package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;


public class TC002_LoginTest extends BaseClass{
	@Test(groups={"sanity","Master"})
	public void verify_login(){
		logger.info("***Start TC002_LoginTest***");
		try {
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		LoginPage lp=new LoginPage(driver); 
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		//my account page 
		MyAccountPage map=new MyAccountPage(driver);
		map.myAccountPageExists();
		boolean targetpage=map.myAccountPageExists();
		
		Assert.assertEquals(targetpage, true,"loginfailed");
		//Assert.assertTrue(targetpage)
		}catch(Exception e) {
			Assert.fail();
		}

		logger.info("***Completed TC002_LoginTest***");


		
		
		
		
		
	}

}
