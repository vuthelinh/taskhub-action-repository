package com.synergix.common.pages;

import com.synergix.common.TH6PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.WebDriver;

public class HomePage extends TH6PageObject {
	public HomePage(WebDriver driver) {
		super(driver);
	}


	// String xPathLoginFlag = "//button[@id='headerForm:j_idt218_button']"; --Jacob
	String xPathLoginFlag = "//form[@id='headerForm']//span[contains(@id,'headerForm') and child::button]"; //Nancy edit 15.08
	
	@FindBy(linkText="Logout")
	private WebElementFacade logoutBtn;

	public void logout() {
		waitElementToBeClickable(xPathLoginFlag).click();
		logoutBtn.waitUntilVisible().waitUntilClickable().click();
	}
	
	public boolean isLoginFlagDisplay() {
		if (waitElementToBePresent(xPathLoginFlag).isVisible()) {
			return true;
		} else
			return false;
	}

	public boolean checkLogoutBtnDisplay() {
		if (waitElementToBePresent(xPathLoginFlag).isVisible()) {
			return true;
		}
		return false;
	}

	// Nancy
	public void switchDatabase(String database) {
		String xLabelDatabase="//div[@id='headerForm:companyCode']";
		String xDatabase="//li[parent::ul[@id='headerForm:companyCode_items'] and text()='"+database+"']";
		$(xLabelDatabase).click();
		waitABit(120);
		$(xDatabase).click();
		waitForAllJSCompletes();
	}
}
