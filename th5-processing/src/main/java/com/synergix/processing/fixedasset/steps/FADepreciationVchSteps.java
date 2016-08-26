package com.synergix.processing.fixedasset.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.fixedasset.pages.FADepreciationVchPage;

public class FADepreciationVchSteps extends ScenarioSteps {
	FADepreciationVchPage onFADepreciationVchPage;

	public void switchOutDefaultIFrame() {
		onFADepreciationVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onFADepreciationVchPage.switchToIFrame();
	}

	@Step
	public void chooseAllVch() {
		onFADepreciationVchPage.clickOnAllVch();
	}

	@Step
	public void clickOnSubmitBtn() {
		onFADepreciationVchPage.clickOnSubmitBtn();
		;
	}

	@Step
	public void searchDraftVchAndSubmit(String vchNo) {
		onFADepreciationVchPage.searchDraftVch(vchNo);
	}

	@Step
	public void clickOnSubmitVch(int rowIndex) {
		onFADepreciationVchPage.clickOnSubmitVch(rowIndex);
	}
}
