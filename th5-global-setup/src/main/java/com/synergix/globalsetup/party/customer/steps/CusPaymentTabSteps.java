package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusPaymentTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusPaymentTabSteps extends ScenarioSteps {

	CusPaymentTabPage onCusPaymentTabPage;

	@Step
	public void selectOperationalCurrency(String operationalCurrency) {
		onCusPaymentTabPage.selectOperationalCurrency(operationalCurrency);
	}

	@Step
	public void typeReviewDate(String reviewDate) {
		onCusPaymentTabPage.typeReviewDate(reviewDate);
	}

	@Step
	public void selectDefault(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onCusPaymentTabPage.selectDefault(tableName, description);
	}

	@Step
	public void clickDescription(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onCusPaymentTabPage.clickDescription(tableName, description);
	}

	@Step
	public void chooseIsActive(String tableName, String description) {
		tableName = tableName.replace(" ", "");
		onCusPaymentTabPage.chooseIsActive(tableName, description);
	}

	public String getToday() {
		return onCusPaymentTabPage.getToday();
	}
}
