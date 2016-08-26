package com.synergix.common.steps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.synergix.common.pages.HomePage;
import com.synergix.common.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

	LoginPage loginPage;
	HomePage homePage;

	@Step
	public void goTo() {
		loginPage.open();
		getDriver().manage().window().maximize();
	}

	@Step
	public LoginFromCommand loginAs(String username) {
		return new LoginFromCommand(username);
	}

	public class LoginFromCommand {

		private String _username;
		private String _company;
		private String _pwd;

		public LoginFromCommand(String username) {
			this._username = username;
		}

		public LoginFromCommand selectCompany(String company) {
			this._company = company;
			return this;
		}

		public LoginFromCommand withPassword(String pwd) {
			this._pwd = pwd;
			return this;
		}

		public void login() {
			loginPage.clearCache();
            loginPage.FillUserName(_username);
            loginPage.selectCompany(_company);
            loginPage.FillPassword(_pwd);
            loginPage.clickLoginBtn();
        }
	}

	@Step
	public void page_is_visited(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}
	

	/**
	 * 
	 * @author Nancy 20160818
	 * */
	@Step
	public void login(String _userName, String _password, String _company) {
		loginPage.FillUserName(_userName);
		loginPage.selectCompany(_company);
		loginPage.FillPassword(_password);
		loginPage.clickLoginBtn();
	}
	
	/**
	 * Using when not sure about company Name. We will replace by index number.
	 * 
	 * @param _indexCompany
	 *            is index of company inDropdowlist.
	 * @author Nancy 20160818
	 * */
	@Step
	public void login(String _userName, String _password, int _indexCompany) {
		loginPage.FillUserName(_userName);
		loginPage.selectCompany(_indexCompany);
		loginPage.FillPassword(_password);
		loginPage.clickLoginBtn();
	}

	/**
	 * 
	 * @author Nancy 20160818
	 * */
	@Step
	public void loginWithDefaultCompany(String _userName, String _password) {
		loginPage.FillUserName(_userName);
		loginPage.FillPassword(_password);
		loginPage.clickLoginBtn();
	}
}
