package com.synergix.common.pages;

import com.synergix.common.TH6PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("http://172.18.0.10:9080/TH6/index.xhtml")
public class LoginPage extends TH6PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Use -Duser.name=xxx to pass parameter to here
	public void FillUserName(String _username) {
		String xUserName = "//input[contains(@id, 'username')]";
		waitTypeAndTab(xUserName, _username);
	}

	public void FillPassword(String _pwd) {
		String xPassword = "//input[contains(@id, 'password')]";
		waitTypeAndTab(xPassword, _pwd);
	}

	// Use -Duser.company=xxx to pass parameter to here
	public void selectCompany(String _company) {
		String xCompanyLabel = "//label[contains(@id, 'companyCode_label')]";
		String xDDL = "//ul[contains(@id, 'companyCode_items')]//li[contains(text(),'"
				+ _company + "')]";
		clickOnElement(xCompanyLabel);
		$(xDDL).waitUntilPresent().waitUntilClickable().click();
	}
//Nancy 20160818
	public void selectCompany(int _indexCompany) {
		String xCompanyLabel = "//label[contains(@id, 'companyCode_label')]";
		String xDDL = "//ul[contains(@id, 'companyCode_items')]//li[2]";
		clickOnElement(xCompanyLabel);
		$(xDDL).waitUntilPresent().waitUntilClickable().click();
	}

	public void clickLoginBtn() {
		String xLoginBtn = "//button[contains(@id, 'loginButton')]/span";
		$(xLoginBtn).waitUntilClickable().click();
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

	public String getConfirmMessages() {
		String confirmMessage = null;
		for (WebElementFacade ele : confirmMessages) {
			// TBD
			confirmMessage += ele.getText();
			System.out.println(ele.getText());
		}
		return confirmMessage;
	}

	public String getErrorMessages() {
		String errMessage = null;
		for (WebElementFacade ele : errorMessages) {
			errMessage += ele.getText();
			System.out.println(ele.getText());
		}
		return errMessage;
	}

	public boolean checkConfirmMessageBox() {
		waitForAllJSCompletes();
		if (confirmMessageBox.isPresent()) {
			return true;
		}
		return false;
	}

	public boolean checkConfirmMessageBoxThenYes() {
		if (confirmMessageBox.isPresent()) {
			getConfirmMessages();
			confrimYesBtn.waitUntilClickable().click();
			waitForAllJSCompletes();
			waitForTextToAppear("Logout");
			return true;
		}
		return false;
	}

	public void clickYesBtnConfirmMessage() {
		confrimYesBtn.waitUntilClickable().click();
	}

	public boolean checkErrorMessageBox() {
		if (errorMessageBox.isPresent()) {
			return true;
		}
		return false;
	}

	public void clickOkBtnErrorMessage() {
		errorOKBtn.waitUntilClickable().click();
	}

	public void clearCache() {
		getDriver().manage().deleteAllCookies();
		Actions actionObject = new Actions(getDriver());
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5)
				.keyUp(Keys.CONTROL).perform();
	}
}
