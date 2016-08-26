package com.synergix.processing.generalledger.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.generalledger.pages.GLGenerateVchPage;

public class GLGenerateVchSteps extends ScenarioSteps {
	GLGenerateVchPage onGLGenerateVchPage;

	public void switchOutDefaultIFrame() {
		onGLGenerateVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onGLGenerateVchPage.switchToIFrame();
	}

	@Step
	public void typeGenerationDateFrom(String generationDateFrom) {
		onGLGenerateVchPage.typeGenerationDateFrom(generationDateFrom);
	}

	@Step
	public void typeGenerationDateTo(String generationDateTo) {
		onGLGenerateVchPage.typeGenerationDateTo(generationDateTo);
	}

	@Step
	public void typeRecurringVchCodeFrom(String recurringVchCodeFrom) {
		onGLGenerateVchPage.typeRecurringVchCodeFrom(recurringVchCodeFrom);
	}

	@Step
	public void typeRecurringVchCodeTo(String recurringVchCodeTo) {
		onGLGenerateVchPage.typeRecurringVchCodeTo(recurringVchCodeTo);
	}

	@Step
	public void clickOnGenerateBtn() {
		onGLGenerateVchPage.clickBtn("Generate");
		onGLGenerateVchPage.chooseYesOnUpdateConfirmation();
		onGLGenerateVchPage.chooseOkOnInforPanel();
		onGLGenerateVchPage.waitForAllJSCompletes();
	}

	@Step
	public void clickAndSubmitVchNo() {
		onGLGenerateVchPage.clickAndSubmitVchNo();
	}

}
