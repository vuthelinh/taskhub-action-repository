package com.synergix.definition.common;

import java.io.IOException;
import java.util.Properties;
import com.synergix.utilities.SessionData;
import com.google.common.base.Strings;
import com.synergix.common.steps.HomeSteps;
import com.synergix.common.steps.SessionDataSteps;
import com.synergix.common.steps.LoginSteps;
import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.utilities.LoadObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CommonDefs {

	@Steps
	SessionDataSteps sessionDataStep;

	@Steps
	LoginSteps loginStep;

	@Steps
	HomeSteps homeStep;

	@Steps
	MenuNavigationSteps menuNavigation;

	public static Properties CONFIG = null;

	// Begin Soft Assertion
	@Then("^user previews result of \"([^\"]*)\" Soft Assertion$")
	public void user_previews_result_of_Soft_Assertion(String _assertionKey) throws Throwable {
		sessionDataStep.assertion_result(SessionData.generateSoftAssertion(_assertionKey));
	}

	@Then("^user previews result of Soft Assertion$")
	public void user_previews_result_of_Soft_Assertion() throws Throwable {
		sessionDataStep.assertion_result(SessionData.generateSoftAssertion());
	}

	@Then("^user verifies result of \"([^\"]*)\" Soft Assertion$")
	public void user_verifies_result_of_Soft_Assertion(String _assertionKey) throws Throwable {
		sessionDataStep.assertion_result_then_assert(_assertionKey, SessionData.generateSoftAssertion(_assertionKey));
	}

	@Then("^user verifies result of Soft Assertion$")
	public void user_verifies_result_of_Soft_Assertion() throws Throwable {
		sessionDataStep.assertion_result_then_assert("", SessionData.generateSoftAssertion());
	}

	@Then("^user clears result of \"([^\"]*)\" Soft Assertion$")
	public void user_clears_result_of_Soft_Assertion(String _assertionKey) throws Throwable {
		sessionDataStep.clear_assertion(_assertionKey);
	}

	@Then("^user clears result of Soft Assertion$")
	public void user_clears_result_of_Soft_Assertion() throws Throwable {
		sessionDataStep.clear_assertion("");
	}

	@Then("^user previews failure result of \"([^\"]*)\" Soft Assertion$")
	public void user_previews_failure_result_of_Soft_Assertion(String _assertionKey) throws Throwable {
		sessionDataStep.assertion_result(SessionData.generateSoftAssertionFailureOnly(_assertionKey));
	}

	@Then("^user verifies result of \"([^\"]*)\" Soft Assertion and show failure result$")
	public void user_verifies_result_of_Soft_Assertion_and_show_failure_result(String _assertionKey) throws Throwable {
		sessionDataStep.assertion_result_then_assert(_assertionKey,
				SessionData.generateSoftAssertionFailureOnly(_assertionKey));
	}

	@Then("^user previews failure result of Soft Assertion$")
	public void user_previews_failure_result_of_Soft_Assertion() throws Throwable {
		sessionDataStep.assertion_result(SessionData.generateSoftAssertionFailureOnly());
	}

	@Then("^user verifies failure result of Soft Assertion$")
	public void user_verifies_failure_result_of_Soft_Assertion() throws Throwable {
		sessionDataStep.assertion_result_then_assert("", SessionData.generateSoftAssertionFailureOnly());
	}
	// End Soft Assertion

	@Given("^\"([^\"]*)\" login to \"([^\"]*)\" company with password is \"([^\"]*)\"$")
	public void login_to_company_with_password_is(String username, String company, String pwd) {
		loginStep.goTo();
		loginStep.loginAs(username).selectCompany(company).withPassword(pwd).login();

		// set info to session to access later
		Serenity.setSessionVariable("USER_ID").to(username);
		Serenity.setSessionVariable("USER_PASSWORD").to(pwd);
		Serenity.setSessionVariable("USER_COMPANY").to(company);
	}

	@When("^user is currently logged in to TaskHub System$")
	@Given("^user login the taskhub system$")
	public void loginTaskhub() {

		try {

			String username = System.getProperty("usr");
			String userpwd = System.getProperty("pwd");
			String companyName = System.getProperty("company");

			CONFIG = LoadObject.loading_config_sys("serenity.properties");

			if (Strings.isNullOrEmpty(username))
				username = CONFIG.getProperty("user.name");
			if (Strings.isNullOrEmpty(userpwd))
				userpwd = CONFIG.getProperty("user.pwd");
			if (Strings.isNullOrEmpty(companyName))
				companyName = CONFIG.getProperty("user.company");

			loginStep.goTo();
			loginStep.loginAs(username).selectCompany(companyName).withPassword(userpwd).login();

			// set info to session to access later
			Serenity.setSessionVariable("USER_ID").to(username);
			Serenity.setSessionVariable("USER_PASSWORD").to(userpwd);
			Serenity.setSessionVariable("USER_COMPANY").to(companyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("^user logout$")
	public void he_logout() {
		homeStep.logOut();

	}

	@When("^user navigates to \"([^\"]*)\" screen$")
	public void user_navigates_to_screen(String _screenMenuPath) {
		menuNavigation.user_navigates_to_screen(_screenMenuPath);
	}

	@Then("^page header shouble be \"([^\"]*)\"$")
	public void verify_page_header(String _pageHeader) {
		menuNavigation.verify_page_header(_pageHeader);
	}

	@When("^the page \"([^\"]*)\" is visited$")
	public void the_page_is_visited(String url) {
		String flag = Serenity.sessionVariableCalled("FLAG");
		System.out.println("Defs: " + flag);
		if (flag.equals("continue")) {
			try {
				loginStep.page_is_visited(url);
			} catch (Exception e) {
				flag += "stop";
				Serenity.setSessionVariable("FLAG").to(flag);
				System.out.println("Skips: " + flag);
			}
		} else {
			System.out.println("Skips: This step Skipped");
		}
	}
}
