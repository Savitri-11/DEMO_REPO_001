package pageEvents;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch ele = new ElementFetch();

	String loginText = "div.ui.fluid.large.blue.submit.button"; // CSS
	String emailAdrdess = "//input[@placeholder='Email']"; // XPATH
	String passwordField = "//input[@placeholder='Password']"; // XPATH

//	String difc_UserName = "//input[data-id='userName']"; // XPATH
//	String difc_PassWord = "//input[data-id='password']"; // XPATH
//	String welCome_msg = "//div[class='welcome-message']"; // XPATH
//	String logIn_Btn = "//button[class='login-btn']";  // XPATH
//	String errorMsg = "//p[class='errorMessage']"; // XPATH
	
	String difc_UserName = "/html/body/div[3]/div[2]/c-ob-login-lwc/div[1]/div[2]/section[2]/div[3]/div[1]/input"; // XPATH
	String difc_PassWord = "/html/body/div[3]/div[2]/c-ob-login-lwc/div[1]/div[2]/section[2]/div[3]/div[2]/input"; // XPATH
	String welCome_msg = "/html/body/div[3]/div[2]/c-ob-login-lwc/div[1]/div[2]/section[1]/div[1]"; // XPATH
	String logIn_Btn = "/html/body/div[3]/div[2]/c-ob-login-lwc/div[1]/div[2]/section[2]/div[3]/button";  // XPATH
	String errorMsg = "/html/body/div[3]/div[2]/c-ob-login-lwc/div[1]/div[2]/section[2]/div[3]/p"; // XPATH
	String serach_Box = "/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/c-ob-license-activity-lwc/div/div/lightning-layout/slot/lightning-layout-item[1]/slot/div/div/div/div[2]/lightning-input/lightning-primitive-input-simple/div[1]/div/input";
       //	String dd_value = "/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/c-ob-license-activity-lwc/div/div/lightning-layout/slot/lightning-layout-item[1]/slot/div/ul/div/c-ob-license-activity-search-results-lwc[1]/li/span/span[2]/span";
    String dd_value = "//*/div/c-ob-license-activity-search-results-lwc";
	String lst_dd_valueString ="//div[@class=\"difc-truncate-search-list\"/]//span[@class=\"slds-media__body\"]//span";
	
	String start_now_btn = "/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/c-ob-sr-header-component-lwc/div/div[2]/div/div/c-sr-header-component-page-flow-lwc/div/div/div/div/div[2]/div[3]/a";	
	String vaildation_msg = "//span[text()='Is this Entity']/parent::label/following-sibling::lightning-input-field/child::lightning-picklist/lightning-combobox/div/div[2]";
	String save_And_Continue_Btn = "/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/c-ob-register-difc-pages-lwc/div/div/lightning-record-edit-form/lightning-record-edit-form-create/form/slot/slot/div[2]/div/lightning-button/button";
	
	
	/**
	 * Method to verify login page loaded successfully or not 
	 * 
	 * @return boolean
	 */

	public boolean verifyLoginPageIsLoaded() {

		WebElement elemnt = ele.getWebElement("CSS", loginText);
		return elemnt.isDisplayed();

	}

	/**
	 * Method to enter credentials of login page
	 * @param emailID
	 * @param passWord
	 */

	public void enterCredentials(String emailID, String passWord)

	{
		ele.getWebElement("XPATH", emailAdrdess).sendKeys(emailID);
		ele.getWebElement("XPATH", passwordField).sendKeys(passWord);

	}
	
	/**
	 * Method to click on start now button
	 */
	public void click_Start_Now_btn() {
		ele.getWebElement("XPATH", start_now_btn).click();
		
	}

	public void click_saveAndContinue_Btn() {
		ele.getWebElement("XPATH", save_And_Continue_Btn).click();
		
	}

	 public void dd_search_Box(String value) {
		 ele.getWebElement("XPATH", serach_Box).sendKeys(value);
		
	}
	
	/**
	 * Method to get difc welcome message text.
	 * @return String
	 * @throws InterruptedException 
	 */

	public String getWelcomeMessageTxt() {

		WebElement elemnt = ele.getWebElement("XPATH", welCome_msg);
		return elemnt.getText();

	}

	public String getValidation_Msg_Txt() {
		
		WebElement elemnt = ele.getWebElement("XPATH", vaildation_msg);
				return elemnt.getText();
	}
	
	/**
	 * Method to enter credentials of difc login page
	 * @param emailID
	 * @param passWord
	 */
	public void enterDifcCredentials(String emailID, String passWord)

	{
		ele.getWebElement("XPATH", difc_UserName).sendKeys(emailID);
		ele.getWebElement("XPATH", difc_PassWord).sendKeys(passWord);

	}

	/**
	 * Method to click on login button
	 */
	public void click_Login_Btn() {
		ele.getWebElement("XPATH", logIn_Btn).click();
		
	}
	
	
	public String get_dd_values() {
	return ele.getWebElement("XPATH", dd_value).getText();
//		return ele.getWebElement("XPATH", lst_dd_valueString).getText();
		
	}
	
	
	
	/**
	 * Method to click on submit button
	 */
	public void click_submit_btn() {
		ele.getWebElement("CSS", loginText).click();
		
	}

}
