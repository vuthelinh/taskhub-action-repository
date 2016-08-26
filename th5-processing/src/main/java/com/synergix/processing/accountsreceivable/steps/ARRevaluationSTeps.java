package com.synergix.processing.accountsreceivable.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountsreceivable.pages.ARRevaluationPage;

public class ARRevaluationSTeps extends ScenarioSteps {
	ARRevaluationPage rPage;

	@Step
	public void switchOutDefaultIFrame() {
		rPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		rPage.switchToIFrame();
	}

	@Step
	public void addNewRevaluation() {
		rPage.clickBtn("New");
		rPage.waitForAllJSCompletes();
	}

	@Step
	public void type_revaluationVoucherDate(String revaluationVoucherDate) {
		rPage.type_revaluationVoucherDate(revaluationVoucherDate);
	}

	@Step
	public void type_description(String description) {
		rPage.type_description(description);

	}

	@Step
	public String getdateToday() {
		return rPage.getToday();
	}

	// add curency
	@Step
	public void addCurrency() {
		rPage.clickBtn("Add");
		rPage.waitForAllJSCompletes();
	}

	@Step
	public int countRowTb() {
		return rPage.countRowTb();
	}

	@Step
	public void type_curency(String currency, int rowIndex) {
		rPage.type_curency(currency, rowIndex);
	}

	@Step
	public void type_exchRate(String exchRate, int rowIndex) {
		rPage.type_exchRate(exchRate, rowIndex);
	}

	@Step
	public void deleteRevaluation() {
		rPage.clickBtn("Delete");
		rPage.waitForAllJSCompletes();
		rPage.chooseYesOnUpdateConfirmation();
		rPage.waitForAllJSCompletes();
	}

	@Step
	public void submitRevaluation() {
		rPage.clickBtn("Submit");
		rPage.waitForAllJSCompletes();
		rPage.chooseYesOnUpdateConfirmation();
		rPage.waitForAllJSCompletes();
	}

	public void deleteAllCurrency() {
		rPage.deleteAllCurrency();
	}

	@Step
	public void clickOnAddBtn() {
		rPage.clickBtn("Add");
		rPage.waitForAllJSCompletes();
	}

	public void deleteCurrency(int rowIndex) {
		rPage.deleteCurrency(rowIndex);
	}
}
