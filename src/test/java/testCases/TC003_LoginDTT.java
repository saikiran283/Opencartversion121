package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.Logger;

import utilities.DataProviders;

public class TC003_LoginDTT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")//getting data provider from different class
	public void verify_login(String email,String pwd,String exp){
		logger.info("***Start TC003_LoginDTT***");
		try {
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		LoginPage lp=new LoginPage(driver); 
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		//my account page 
		MyAccountPage map=new MyAccountPage(driver);
		map.myAccountPageExists();
		boolean targetpage=map.myAccountPageExists();
		/*Data is valid -login suucess-Test Pass -logout
		 * Data is valid -login failure-Test fail
		 
		 */
		if(exp.equalsIgnoreCase("valid")){
			if(targetpage==true){
				map.clickLogout();
				Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				
			}
		}
			/* Data is invalid -login suucess-Test fail -logout
			 * Data is invalid -login failure-Test Pass */
			else if(exp.equalsIgnoreCase("invalid")){
				if(targetpage==true){
					 map.clickLogout();
				    Assert.assertTrue(false);
					}else {
						Assert.assertTrue(true);
					
				}
			}
		}
			catch(Exception e) {
				Assert.fail();
				}
			
			
				logger.info("***COMPLETED TC003_LoginDTT***");
		}	
	}


