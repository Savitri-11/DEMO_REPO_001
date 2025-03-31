package qa.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.JsonUtils;

public class Testcase1 extends BaseTest {

//	ElementFetch elementFetch = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();

	
	
	/**
	 * @author Savitri E G TC_001
	 */
	@Test(description = "Validate the Entity Name step", groups = { "Regression", "Low" })

	public void TC_002() throws Exception {
		try {
			Map<String, String> testData = JsonUtils.readJson("LogIInCredentials.json");
			ArrayList<Object> actualData = new ArrayList<Object>();
			ArrayList<Object> expectedData = new ArrayList<Object>();
			homePage.Click_LogIn_Button();
			BaseTest.SwitchToChildWindow();

			actualData.add(loginPage.verifyLoginPageIsLoaded());
			expectedData.add(true);


			loginPage.enterCredentials(testData.get("username"), testData.get("password"));
			loginPage.click_submit_btn();

			actualData.add("test");
			expectedData.add("test");
			System.out.println("**********Test 2 Finished******");

			assertThat(actualData, equalTo(expectedData));

		} catch (Exception e) {
			throw new AssertionError(e.getMessage());

		}
	}
}
