package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
		 @FindBy (id = "input-email")
		    WebElement emailField;

		    @FindBy (id = "input-password")
		    WebElement passwordField;

		    @FindBy (xpath = "//input[@value='Login']")
		    WebElement loginButton;
		    
		    public void setEmail(String email) {
		        emailField.clear();
		        emailField.sendKeys(email);
		    }

		    public void setPassword(String password) {
		        passwordField.clear();
		        passwordField.sendKeys(password);
		    }

		    public void clickLogin() {
		        loginButton.click();
		    }
		
	
	

}
