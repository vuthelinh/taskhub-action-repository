package com.synergix.globalsetup.financial.accounting.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SalesTaxPage extends TH5PageObject {

	public SalesTaxPage(WebDriver driver) {
		super(driver);
	}

	public void typeSalesTaxCode(String salesTaxCode) {
		enterInputFieldCodeWithLabel("Sales Tax Code", salesTaxCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeSalesTax(String salesTax) {
		enterInputFieldWithLabel("Sales Tax %", salesTax);
	}

	public void typeInputTaxGLAN(String inputTaxGLAN) {
		enterInputFieldWithLabel("Input Tax GLAN", inputTaxGLAN);
	}

	public void typeOutputTaxGLAN(String outputTaxGLAN) {
		enterInputFieldWithLabel("Output Tax GLAN", outputTaxGLAN);
	}

	public void selectIRASTaxTypeofPurchase(String iRASTaxTypeofPurchase) {
		selectDdlWithLabelByText("(IRAS) Tax Type of Purchase", iRASTaxTypeofPurchase);
	}

	public void selectIRASTaxTypeofSupply(String iRASTaxTypeofSupply) {
		selectDdlWithLabelByText("(IRAS) Tax Type of Supply", iRASTaxTypeofSupply);
	}

	public void clickOnNewButton() {
		findBtn("New").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

}
