package com.synergix.processing.fixedasset.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.fixedasset.pages.FADisposalVchPage;

public class FADisposalVchSteps extends ScenarioSteps {
	FADisposalVchPage onFADisposalVchPage;

	public void switchOutDefaultIFrame() {
		onFADisposalVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onFADisposalVchPage.switchToIFrame();
	}

	@Step
	public void clickOnSubmitBtn() {
		onFADisposalVchPage.clickOnSubmitBtn();
	}

	@Step
	public void clickOnNewBtn() {
		onFADisposalVchPage.clickBtn("New");
		onFADisposalVchPage.waitForAllJSCompletes();
	}

	@Step
	public void chooseFixedAssetCode(String fixedAssetCode) {
		onFADisposalVchPage.chooseFixedAssetCode(fixedAssetCode);
	}

	@Step
	public void typeDisposalDate(String disposalDate) {
		onFADisposalVchPage.typeDisposalDate(disposalDate);
	}

	@Step
	public void typeSubject(String subject) {
		onFADisposalVchPage.typeSubject(subject);
	}

	@Step
	public void typeDescription(String description) {
		onFADisposalVchPage.typeDescription(description);
	}

	@Step
	public void typeSerialNo(String serialNo, int rowIndex) {
		onFADisposalVchPage.typeSerialNo(serialNo, rowIndex);
	}

	@Step
	public void typeRemarksDescription(String remarksDescription, int rowIndex) {
		onFADisposalVchPage
				.typeRemarksDescription(remarksDescription, rowIndex);
	}

	@Step
	public void typeDisposalAmt(String disposalAmt, int rowIndex) {
		onFADisposalVchPage.typeDisposalAmt(disposalAmt, rowIndex);
	}

	@Step
	public void chooseDel(int rowIndex) {
		onFADisposalVchPage.chooseDel(rowIndex);
	}

	@Step
	public void clickOnAddBtn() {
		onFADisposalVchPage.clickBtn("Add");
		onFADisposalVchPage.waitForAllJSCompletes();
	}

	public String getToday() {
		return onFADisposalVchPage.getToday();
	}

}
