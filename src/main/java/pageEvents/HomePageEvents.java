package pageEvents;

import org.openqa.selenium.WebElement;

import base.BaseTest;

import utils.ElementFetch;

public class HomePageEvents {
	

	ElementFetch ele = new ElementFetch();
	BaseTest basetest = new BaseTest();
	
	// Locators
	String signInButtonText = "//a[text()='Login']";
	
	

	
    /* Method to click on Login button 
     * 
     */
	public void Click_LogIn_Button() {
		WebElement srtgString = ele.getWebElement("XPATH", signInButtonText);
        srtgString.click();
	}
}
