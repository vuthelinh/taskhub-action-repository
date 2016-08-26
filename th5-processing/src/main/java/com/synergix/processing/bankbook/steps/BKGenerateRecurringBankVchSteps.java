package com.synergix.processing.bankbook.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.bankbook.pages.BKGenerateRecurringBankVchPage;

public class BKGenerateRecurringBankVchSteps extends ScenarioSteps {
	BKGenerateRecurringBankVchPage onBKGenerateRecurringBankVchPage;

	public void switchOutDefaultIFrame() {
		onBKGenerateRecurringBankVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onBKGenerateRecurringBankVchPage.switchToIFrame();
	}

	@Step
	public void clickOnSubmitBtn() {
		onBKGenerateRecurringBankVchPage.clickBtn("Submit");
		onBKGenerateRecurringBankVchPage.chooseYesOnUpdateConfirmation();
		onBKGenerateRecurringBankVchPage.waitForAllJSCompletes();
	}

	@Step
	public void typeGenerationDateFrom(String generationDateFrom) {
		onBKGenerateRecurringBankVchPage
				.typeGenerationDateFrom(generationDateFrom);
	}

	@Step
	public void typeGenerationDateTo(String generationDateTo) {
		onBKGenerateRecurringBankVchPage.typeGenerationDateTo(generationDateTo);
	}

	@Step
	public void typeRecurringTemplateNoFrom(String recurringTemplateNoFrom) {
		onBKGenerateRecurringBankVchPage
				.typeRecurringTemplateNoFrom(recurringTemplateNoFrom);
	}

	@Step
	public void typeRecurringTemplateNoTo(String recurringTemplateNoTo) {
		onBKGenerateRecurringBankVchPage
				.typeRecurringTemplateNoTo(recurringTemplateNoTo);
	}

	public int getAmtVch() {
		return onBKGenerateRecurringBankVchPage.getAmtVch();
	}

	public String getFirstVch() {
		return onBKGenerateRecurringBankVchPage.getFirstVch();
	}

}
