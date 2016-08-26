package com.synergix.mtsetup.administration.company.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SetHomeCurrencyPage extends TH5PageObject {

	public SetHomeCurrencyPage(WebDriver driver) {
		super(driver);
	}

	public void typeHomeCurrency(String homeCurrency) {
		enterInputFieldCodeWithLabel("Home Currency", homeCurrency);
	}

	public void typeOperationCurrency(String operationCurrency) {
		enterInputFieldCodeWithLabel("Operation Currency", operationCurrency);
	}

	public void chooseCompanyCode(String company) {
		String xRowSelected = "//table/tbody//td[1]//*[text()='" + company.toUpperCase() + "' and @href]";
		if (isElementExist(xRowSelected)) {
			clickOnElement(xRowSelected);
			waitForAllJSCompletes();
		}
	}

	public void chooseAndUpdateAllCompany() {
		String xCompanyTb = "//table[child::thead[descendant-or-self::*[text()='Company Code']]]/tbody/tr";
		if (findAll(xCompanyTb).size() > 0) {
			int rowTb = getTbCountDataRow(xCompanyTb);
			for (int i = 1; i <= rowTb; i++) {
				String xRowSelected = xCompanyTb + "[" + i + "]/td[1]//*[@href]";
				clickOnElement(xRowSelected);
				waitForAllJSCompletes();
				clickBtn("Update");
				chooseYesOnUpdateConfirmation();
				chooseOKOnInfoPanel();
				waitForAllJSCompletes();
				clickBtn("Close");
				waitForAllJSCompletes();
			}
		}
	}
}
