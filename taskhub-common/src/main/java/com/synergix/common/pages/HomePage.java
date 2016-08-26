package com.synergix.common.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends TH5PageObject {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	String xPathLoginFlag = "//*[text()='Logout'] | //*[text()='Confirm']";

	public void logout() {
		waitElementToBeClickable(xPathLoginFlag).click();
	}

	public String getLoginFlagDisplay() {
		if (waitElementToBePresent(xPathLoginFlag).isVisible()) {
			String s = waitElementToBePresent(xPathLoginFlag).getText();
			return s;
		}
		return "";
	}

	public boolean checkLogoutBtnDisplay() {
		if (waitElementToBePresent(xPathLoginFlag).isVisible()) {
			return true;
		}
		return false;
	}
	
	@FindBy(linkText="Logout")
	private WebElementFacade logouBtn;
	public void log_out(){
		logouBtn.waitUntilClickable().click();
	}
	
}
