package com.synergix.processing.accountspayable.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APPaymentSuggestionPage extends TH5PageObject {

	public APPaymentSuggestionPage(WebDriver driver) {
		super(driver);
	}

	private String xPaymentSuggestionTb = "//table[contains(@id, 'detailTable')]";

	public void typeSelectSupplier(String selectSupplier) {
		enterInputFieldWithLabel("Select Supplier", selectSupplier);
	}

	public void typeSupplierClassFrom(String supplierClassFrom) {
		enterInputFieldWithLabel("Supplier Class From", supplierClassFrom);
	}

	public void typeCurrencyFrom(String currencyFrom) {
		enterInputFieldWithLabel("Currency From", currencyFrom);
	}

	public void typeInvoiceDateFrom(String invoiceDateFrom) {
		enterInputFieldWithLabel("Invoice Date From", invoiceDateFrom);
	}

	public void typeDueDateFrom(String dueDateFrom) {
		enterInputFieldWithLabel("Due Date From", dueDateFrom);
	}

	public void typeGracePeriod(String gracePeriod) {
		enterInputFieldWithLabel("Grace Period", gracePeriod);
	}

	public void typeExchRate(String exchRate) {
		enterInputFieldWithLabel("Exch Rate", exchRate);
	}

	public void typeIncludeNonOverdue(String includeNonOverdue) {
		selectRadioButton("Include Non Overdue", includeNonOverdue);
	}

	public void chooseSupplierClassTo(String supplierClassTo) {
		enterInputFieldWithLabel("Supplier Class To", supplierClassTo);
	}

	public void typeCurrencyTo(String currencyTo) {
		enterInputFieldWithLabel("Currency To", currencyTo);
	}

	public void typeInvoiceDateTo(String invoiceDateTo) {
		enterInputFieldWithLabel("Invoice Date To", invoiceDateTo);
	}

	public void typeDueDateTo(String dueDateTo) {
		enterInputFieldWithLabel("Due Date To", dueDateTo);
	}

	public void clickOnSubmitAllInvoice() {
		String xCheckAllInvoice = xPaymentSuggestionTb + "/thead//th[1]//input";
		clickOnElement(xCheckAllInvoice);
		waitForAllJSCompletes();
		clickBtn("Submit");
		chooseYesOnUpdateConfirmation();
		chooseOkInErrorMessage();
	}

}
