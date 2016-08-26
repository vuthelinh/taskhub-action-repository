package com.synergix.processing.accountspayable.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APPaymentSuggestionPage;

public class APPaymentSuggestionSteps extends ScenarioSteps {
	APPaymentSuggestionPage onAPPaymentSuggestionPage;

	@Step
	public void switchOutDefaultIFrame() {
		onAPPaymentSuggestionPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onAPPaymentSuggestionPage.switchToIFrame();
	}

	@Step
	public boolean searchBankAccount(String bankPartyCode, String bankAccountNo) {
		onAPPaymentSuggestionPage.clickSearchIconWithLabel("Bank Account No");
		onAPPaymentSuggestionPage.waitForAllJSCompletes();
		return onAPPaymentSuggestionPage.searchBankAccount(bankPartyCode,
				bankAccountNo);
	}

	@Step
	public void typeSelectSupplier(String selectSupplier) {
		onAPPaymentSuggestionPage.typeSelectSupplier(selectSupplier);
	}

	@Step
	public void typeSupplierClassFrom(String supplierClassFrom) {
		onAPPaymentSuggestionPage.typeSupplierClassFrom(supplierClassFrom);
	}

	@Step
	public void typeCurrencyFrom(String currencyFrom) {
		onAPPaymentSuggestionPage.typeCurrencyFrom(currencyFrom);
	}

	@Step
	public void typeInvoiceDateFrom(String invoiceDateFrom) {
		onAPPaymentSuggestionPage.typeInvoiceDateFrom(invoiceDateFrom);
	}

	@Step
	public void typeDueDateFrom(String dueDateFrom) {
		onAPPaymentSuggestionPage.typeDueDateFrom(dueDateFrom);
	}

	@Step
	public void typeGracePeriod(String gracePeriod) {
		onAPPaymentSuggestionPage.typeGracePeriod(gracePeriod);
	}

	@Step
	public void typeExchRate(String exchRate) {
		onAPPaymentSuggestionPage.typeExchRate(exchRate);
	}

	@Step
	public void typeIncludeNonOverdue(String includeNonOverdue) {
		onAPPaymentSuggestionPage.typeIncludeNonOverdue(includeNonOverdue);
	}

	@Step
	public void chooseSupplierClassTo(String supplierClassTo) {
		onAPPaymentSuggestionPage.chooseSupplierClassTo(supplierClassTo);
	}

	@Step
	public void typeCurrencyTo(String currencyTo) {
		onAPPaymentSuggestionPage.typeCurrencyTo(currencyTo);
	}

	@Step
	public void typeInvoiceDateTo(String invoiceDateTo) {
		onAPPaymentSuggestionPage.typeInvoiceDateTo(invoiceDateTo);
	}

	@Step
	public void typeDueDateTo(String dueDateTo) {
		onAPPaymentSuggestionPage.typeDueDateTo(dueDateTo);
	}

	@Step
	public void clickOnViewBtn() {
		onAPPaymentSuggestionPage.clickBtn("View");
		onAPPaymentSuggestionPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitAllInvoice() {
		onAPPaymentSuggestionPage.clickOnSubmitAllInvoice();
	}
}
