package com.synergix.common.steps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.synergix.common.pages.HomePage;
import com.synergix.common.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps
{

    LoginPage loginPage;
    HomePage  homePage;

    @Step
    public void goTo()
    {
        loginPage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void goTo(String url)
    {
        loginPage.openAt(url);
        getDriver().manage().window().maximize();
    }

    @Step
    public LoginFromCommand loginAs(String username)
    {
        return new LoginFromCommand(username);
    }

    public class LoginFromCommand
    {

        private String _username;
        private String _company;
        private String _pwd;

        public LoginFromCommand(String username)
        {
            this._username = username;
        }

        public LoginFromCommand selectCompany(String company)
        {
            this._company = company;
            return this;
        }

        public LoginFromCommand withPassword(String pwd)
        {
            this._pwd = pwd;
            return this;
        }

        public void login()
        {
            loginPage.clearCache();
            loginPage.FillUserName(_username);
            loginPage.selectCompany(_company);
            loginPage.FillPassword(_pwd);
            loginPage.clickLoginBtn();

            String checkText = homePage.getLoginFlagDisplay();

            boolean check;
            if (checkText.equalsIgnoreCase("Confirm"))
            {
                loginPage.checkConfirmMessageBoxThenYes();
            }

            else if (checkText.equalsIgnoreCase("Logout"))
            {
                // pass
            }

            else
            {
                check = loginPage.checkErrorMessageBox();
                assertThat(loginPage.getErrorMessages(), check, is(false));
            }
        }
    }

    @Step
    public void page_is_visited(String url)
    {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

}
