package com.synergix.definition.common;

import com.google.common.base.Strings;
import com.synergix.common.actions.PageSteps;
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
	PageSteps pageSteps;

	@Steps
	MenuNavigationSteps menuNavigation;

	public static Properties CONFIG = null;

	@Given("^\"([^\"]*)\" login to \"([^\"]*)\" company with password is \"([^\"]*)\"$")
	public void login_to_company_with_password_is(String username,
			String company, String pwd) {
		loginStep.goTo();
		pageSteps.login(username, pwd, company, 3); // more efficient
		// loginStep.loginAs(username).selectCompany(company).withPassword(pwd).login();
		// // currently error: cannot input password

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
			loginStep.loginAs(username).selectCompany(companyName)
					.withPassword(userpwd).login();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Given("^user login the TH6 system$")
	public void loginTH6() {
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
			loginStep.loginAs(username).selectCompany(companyName)
					.withPassword(userpwd).login();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("^user logout$")
	public void he_logout() {
		homeStep.logOut();
	}

	/**
	 * @Description: If it's not on the home screen, It come back there. Then
	 *               perform Navigate
	 */
	@When("^user navigates to \"([^\"]*)\" screen$")
	public void user_navigates_to_screen(String _screenMenuPath) {
		menuNavigation.switchToParentFrame();
		menuNavigation.clickOnHomeIcon();
		menuNavigation.user_navigates_to_screen(_screenMenuPath);
	}

	/**
	 * If it's not on the home screen, It come back there.
	 */
	@When("^user come back to home screen$")
	public void user_come_back_to_home_screen() {
		menuNavigation.clickOnHomeIcon();
	}

	@Then("^page header shouble be \"([^\"]*)\"$")
	public void verify_page_header(String _pageHeader) {
		menuNavigation.verify_page_header(_pageHeader);
	}

	@When("^the page \"([^\"]*)\" is visited$")
	public void the_page_is_visited(String url) {
		loginStep.page_is_visited(url);
	}

	/**
	 * @Desctiption: use to switch between many databases If it's not on the
	 *               home screen, It come back there.
	 */
	@Given("^user switch to database \"([^\"]*)\"$")
	public void user_switch_to_database(String database) {
		menuNavigation.clickOnHomeIcon();
		homeStep.switchDatabase(database);
	}
}
