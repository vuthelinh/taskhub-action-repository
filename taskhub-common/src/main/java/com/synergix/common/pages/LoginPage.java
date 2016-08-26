package com.synergix.common.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.18.0.21:9080/TH5Web/faces/login.seam")
public class LoginPage extends TH5PageObject
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "loginForm:username")
    private static WebElementFacade usernameInput;

    // Use -Duser.name=xxx to pass parameter to here
    public void FillUserName(String _username)
    {
        // _username = System.getProperty("usr.name");
        usernameInput.sendKeys(_username);
    }

    @FindBy(xpath = "//*[text()='Company']/following-sibling::td/select")
    private static WebElementFacade company;

    // Use -Duser.company=xxx to pass parameter to here
    public void selectCompany(String _company)
    {
        // _company = System.getProperty("usr.company");
        // company.selectByVisibleText(_company);
        List<String> sCompanyName = company.getSelectOptions();
        for (String element : sCompanyName)
        {
            if (element.contains(_company))
            {
                company.selectByIndex(sCompanyName.indexOf(element));
                break;
            }
        }
    }

    @FindBy(id = "loginForm:password")
    private static WebElementFacade pwdInput;

    // Use -Duser.pwd=xxx to pass parameter to here
    public void FillPassword(String _pwd)
    {
        // _pwd = System.getProperty("usr.pwd");
        pwdInput.sendKeys(_pwd);
    }

    @FindBy(id = "loginForm:actionLogin")
    private static WebElementFacade loginBtn;

    public void clickLoginBtn()
    {
        loginBtn.click();
        waitForAllJSCompletes();
    }

    @FindBy(xpath = "//div[@class = 'rich-mpnl-text rich-mpnl-header' and text()='Confirm']")
    private static WebElementFacade confirmMessageBox;

    @FindBy(xpath = "//form[@id='confirmationPanel_Form']//span")
    private static List<WebElementFacade> confirmMessages;

    @FindBy(xpath = "//div[@class = 'rich-mpnl-text rich-mpnl-header' and text()='Error Message(s)']")
    private static WebElementFacade errorMessageBox;

    @FindBy(xpath = "//div[@id='errorModalPanelCDiv']//span[@class='error-message']")
    private static List<WebElementFacade> errorMessages;

    @FindBy(xpath = "//input[@id='ErrorForm:OKButton']")
    private static WebElementFacade errorOKBtn;

    @FindBy(xpath = "//input[contains(@id,'confirmationPanel_Form:confirmationPanel_YesButton')]")
    private static WebElementFacade confrimYesBtn;

    @FindBy(xpath = "//input[@id='changePswdForm:loginId_1']")
    private static WebElementFacade enterNewUserName;
    @FindBy(xpath = "//input[@id='changePswdForm:loginId_2']")
    private static WebElementFacade confirmNewUserName;
    @FindBy(xpath = "//input[@id='changePswdForm:password_1']")
    private static WebElementFacade enterNewPassword;
    @FindBy(xpath = "//input[@id='changePswdForm:password_2']")
    private static WebElementFacade confirmNewPassword;
    @FindBy(xpath = "//input[@value='Submit']")
    private static WebElementFacade submitBtn;

    public void enterNewUser(String newUserName, String newPassword)
    {
        enterNewUserName.sendKeys(newUserName);
        confirmNewUserName.sendKeys(newUserName);
        enterNewPassword.sendKeys(newPassword);
        confirmNewPassword.sendKeys(newPassword);
        submitBtn.click();
    }

    public String getConfirmMessages()
    {
        String confirmMessage = null;
        for (WebElementFacade ele : confirmMessages)
        {
            // TBD
            confirmMessage += ele.getText();
            System.out.println(ele.getText());
        }
        return confirmMessage;
    }

    public String getErrorMessages()
    {
        String errMessage = null;
        for (WebElementFacade ele : errorMessages)
        {
            errMessage += ele.getText();
            System.out.println(ele.getText());
        }
        return errMessage;
    }

    public boolean checkConfirmMessageBox()
    {
        waitForAllJSCompletes();
        if (confirmMessageBox.isPresent())
        {
            return true;
        }
        return false;
    }

    public boolean checkConfirmMessageBoxThenYes()
    {
        if (confirmMessageBox.isPresent())
        {
            getConfirmMessages();
            confrimYesBtn.waitUntilClickable().click();
            waitForAllJSCompletes();
            waitForTextToAppear("Logout");
            return true;
        }
        return false;
    }

    public void clickYesBtnConfirmMessage()
    {
        confrimYesBtn.waitUntilClickable().click();
    }

    public boolean checkErrorMessageBox()
    {
        if (errorMessageBox.isPresent())
        {
            return true;
        }
        return false;
    }

    public void clickOkBtnErrorMessage()
    {
        errorOKBtn.waitUntilClickable().click();
    }

    public void clearCache()
    {
        getDriver().manage().deleteAllCookies();
        Actions actionObject = new Actions(getDriver());
        actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
    }
}
