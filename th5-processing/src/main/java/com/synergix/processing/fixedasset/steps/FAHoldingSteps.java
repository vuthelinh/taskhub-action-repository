package com.synergix.processing.fixedasset.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.fixedasset.pages.FAHoldingPage;

public class FAHoldingSteps extends ScenarioSteps {
	FAHoldingPage onFAHoldingPage;

	public void switchOutDefaultIFrame() {
		onFAHoldingPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onFAHoldingPage.switchToIFrame();
	}

	@Step
	public void searchDraftAssetVoucherNo(String assetVoucherNo) {
		onFAHoldingPage.searchDraftAssetVoucherNo(assetVoucherNo);
	}

	@Step
	public void chooseCreateAPCN() {
		onFAHoldingPage.clickBtn("Create AP CN");
		onFAHoldingPage.chooseYesOnUpdateConfirmation();
		onFAHoldingPage.chooseOkOnInforPanel();
		onFAHoldingPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onFAHoldingPage.clickBtn("Submit");
		onFAHoldingPage.chooseYesOnUpdateConfirmation();
		onFAHoldingPage.chooseOkOnInforPanel();
		onFAHoldingPage.waitForAllJSCompletes();
	}

	@Step
	public void typeAssetSerialNo(String assetSerialNo, int rowIndex) {
		onFAHoldingPage.typeAssetSerialNo(assetSerialNo, rowIndex);
	}

	@Step
	public void typeLocation(String location, int rowIndex) {
		onFAHoldingPage.typeLocation(location, rowIndex);
	}

}
