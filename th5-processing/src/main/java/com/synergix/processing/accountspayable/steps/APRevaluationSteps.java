package com.synergix.processing.accountspayable.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APRevaluationPage;

public class APRevaluationSteps extends ScenarioSteps {
	APRevaluationPage onAPRevaluationPage;

	@Step
	public void switchOutDefaultIFrame() {
		onAPRevaluationPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onAPRevaluationPage.switchToIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onAPRevaluationPage.clickBtn("New");
		onAPRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnUpdateBtn() {
		onAPRevaluationPage.clickBtn("Submit");
		onAPRevaluationPage.chooseYesOnUpdateConfirmation();
		onAPRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBtn() {
		onAPRevaluationPage.clickBtn("Add");
		onAPRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void typeRevaluationVoucherNo(String revaluationVoucherNo) {
		onAPRevaluationPage.typeRevaluationVoucherNo(revaluationVoucherNo);
	}

	@Step
	public void typeRevaluationVoucherDate(String revaluationVoucherDate) {
		onAPRevaluationPage.typeRevaluationVoucherDate(revaluationVoucherDate);
	}

	@Step
	public void typeDescription(String description) {
		onAPRevaluationPage.typeDescription(description);
	}

	@Step
	public void typeCurrency(String currency, int rowIndex) {
		onAPRevaluationPage.typeCurrency(currency, rowIndex);
	}

	@Step
	public void typeExchRate(String exchRate, int rowIndex) {
		onAPRevaluationPage.typeExchRate(exchRate, rowIndex);
	}

	@Step
	public void chooseDel(String del, int rowIndex) {
		onAPRevaluationPage.chooseDel(del, rowIndex);
	}

	@Step
	public int getRowCcyTb() {
		return onAPRevaluationPage.getRowCcyTb();
	}

	@Step
	public void chooseDelAllCurrency() {
		onAPRevaluationPage.chooseDelAllCurrency();
	}

	@Step
	public boolean searchDrafVoucherNo(String revaluationVoucherNo) {
		return onAPRevaluationPage.searchDrafVoucherNo(revaluationVoucherNo);
	}

	public String getToday() {
		return onAPRevaluationPage.getToday();
	}

}
