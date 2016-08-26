package com.synergix.processing.fixedasset.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.fixedasset.pages.FAGenerateDepreciationVchPage;

public class FAGenerateDepreciationVchSteps extends ScenarioSteps {
	FAGenerateDepreciationVchPage onFAGenerateDepreciationVchPage;

	public void switchOutDefaultIFrame() {
		onFAGenerateDepreciationVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onFAGenerateDepreciationVchPage.switchToIFrame();
	}

	@Step
	public void typeFixedAssetClassFrom(String fixedAssetClassFrom) {
		onFAGenerateDepreciationVchPage
				.typeFixedAssetClassFrom(fixedAssetClassFrom);
	}

	@Step
	public void typeFixedAssetClassTo(String fixedAssetClassTo) {
		onFAGenerateDepreciationVchPage
				.typeFixedAssetClassTo(fixedAssetClassTo);
	}

	@Step
	public void clickOnGenerateBtn() {
		onFAGenerateDepreciationVchPage.clickBtn("Generate");
		onFAGenerateDepreciationVchPage.chooseYesOnUpdateConfirmation();
		onFAGenerateDepreciationVchPage.chooseOkOnInforPanel();
		onFAGenerateDepreciationVchPage.waitForAllJSCompletes();
	}

}
