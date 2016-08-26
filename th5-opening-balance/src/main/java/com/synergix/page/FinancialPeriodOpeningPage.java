package com.synergix.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FinancialPeriodOpeningPage extends TH5PageObject {

	public FinancialPeriodOpeningPage(WebDriver driver) {
		super(driver);
	}

	private String _xPath;

	public void typeYearAndPeriod(String module, String year, String period) {
		_xPath = "//*[text()='" + module + "']/following-sibling::td/input";
		typeYear(year);
		typePeriod(period);
		clickOnSaveButton();
	}

	public void typeYear(String year) {
		String xPathYear = "(" + _xPath + ")[1]";
		$(xPathYear).typeAndTab(year);
		waitForAllJSCompletes();
	}

	public void typePeriod(String period) {
		String xPathPeriod = "(" + _xPath + ")[2]";
		$(xPathPeriod).typeAndTab(period);
		waitForAllJSCompletes();
	}

	public void clickOnSaveButton() {
		String xPathSaveButton = "(" + _xPath + ")[3]";
		$(xPathSaveButton).click();
		waitForAllJSCompletes();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
		waitABit(500);
	}
}
