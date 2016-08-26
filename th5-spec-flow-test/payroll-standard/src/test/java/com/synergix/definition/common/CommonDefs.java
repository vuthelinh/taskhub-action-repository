package com.synergix.definition.common;

import com.google.common.base.Strings;
import com.synergix.common.steps.HomeSteps;
import com.synergix.common.steps.LoginSteps;
import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.utilities.LoadObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.util.Properties;

public class CommonDefs {

	@Steps
	LoginSteps loginStep;

	@Steps
	HomeSteps homeStep;

	@Steps
	MenuNavigationSteps menuNavigation;

	public static Properties CONFIG = null;

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
			System.out.println("This step Skipped");
		}
	}
}
