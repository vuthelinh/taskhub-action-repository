package com.synergix.processing.fixedasset.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.fixedasset.pages.FAChangeLocationPage;

public class FAChangeLocationSteps extends ScenarioSteps {
	FAChangeLocationPage onFAChangeLocationPage;

	public void switchOutDefaultIFrame() {
		onFAChangeLocationPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onFAChangeLocationPage.switchToIFrame();
	}

	@Step
	public void clickOnSubmitBtn() {
		onFAChangeLocationPage.clickOnSubmitBtn();
	}

	@Step
	public void clickOnNewBtn() {
		onFAChangeLocationPage.clickBtn("New");
		onFAChangeLocationPage.waitForAllJSCompletes();
	}

	@Step
	public void typeFixedAssetCode(String fixedAssetCode) {
		onFAChangeLocationPage.typeFixedAssetCode(fixedAssetCode);
	}

	@Step
	public void typeTransactionDate(String transactionDate) {
		onFAChangeLocationPage.typeTransactionDate(transactionDate);
	}

	@Step
	public void typeSubject(String subject) {
		onFAChangeLocationPage.typeSubject(subject);
	}

	@Step
	public void typeDescription(String description) {
		onFAChangeLocationPage.typeDescription(description);
	}

	@Step
	public void typeSerialNo(String serialNo, int rowIndex) {
		onFAChangeLocationPage.typeSerialNo(serialNo, rowIndex);
	}

	@Step
	public void typeRemarksDescription(String remarksDescription, int rowIndex) {
		onFAChangeLocationPage.typeRemarksDescription(remarksDescription,
				rowIndex);
	}

	@Step
	public void typeNewLocation(String newLocation, int rowIndex) {
		onFAChangeLocationPage.typeNewLocation(newLocation, rowIndex);
	}

	@Step
	public void chooseDel(int rowIndex) {
		onFAChangeLocationPage.chooseDel(rowIndex);
	}

	@Step
	public void clickOnAddBtn() {
		onFAChangeLocationPage.clickBtn("Add");
		onFAChangeLocationPage.waitForAllJSCompletes();
	}

	public String getToday() {
		return onFAChangeLocationPage.getToday();
	}

}
