package com.synergix.mtsetup.financial.accounting.steps;

import com.synergix.mtsetup.financial.accounting.pages.MTGLRevaluationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MTGLRevaluationSteps extends ScenarioSteps {

	MTGLRevaluationPage onMTGLRevaluationPage;

	public void switchToIFrame() {
		onMTGLRevaluationPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onMTGLRevaluationPage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onMTGLRevaluationPage.clickBtn("New");
		onMTGLRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void typeGLAccountCode(String gLAccountCode) {
		onMTGLRevaluationPage.typeGLAccountCode(gLAccountCode);
	}

	@Step
	public void typeDescription(String description) {
		onMTGLRevaluationPage.typeDescription(description);
	}

	@Step
	public void typeUnrealisedGainLossGLAN(String unrealisedGainLossGLAN) {
		onMTGLRevaluationPage.typeUnrealisedGainLossGLAN(unrealisedGainLossGLAN);
	}

	@Step
	public void clickOnCloseBtn() {
		onMTGLRevaluationPage.clickBtn("Close");
		onMTGLRevaluationPage.waitForAllJSCompletes();
	}

	@Step
	public void deleteValueBySearchBtn(String gLAccountCode) {
		onMTGLRevaluationPage.deleteValueBySearchBtn("Search", "GL Account Code", gLAccountCode);
	}

	@Step
	public void clickOnDelGLRevaluation() {
		onMTGLRevaluationPage.clickBtn("Delete");
		onMTGLRevaluationPage.chooseYesOnUpdateConfirmation();
		onMTGLRevaluationPage.waitForAllJSCompletes();
	}

}
