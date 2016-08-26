package com.synergix.globalsetup.fixedasset.steps;

import com.synergix.globalsetup.fixedasset.pages.ClassPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ClassSteps extends ScenarioSteps {

	ClassPage onClassPage;

	public void switchToIFrame() {
		onClassPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onClassPage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onClassPage.clickBtn("New");
		onClassPage.waitForAllJSCompletes();
	}

	@Step
	public void typeFixedAssetClassCode(String fixedAssetClassCode) {
		onClassPage.typeFixedAssetClassCode(fixedAssetClassCode);
	}

	@Step
	public void typeDescription(String description) {
		onClassPage.typeDescription(description);
	}

	@Step
	public void typeFixedAssetGLAN(String fixedAssetGLAN) {
		onClassPage.typeFixedAssetGLAN(fixedAssetGLAN);
	}

	@Step
	public void typeDepreciationGLAN(String depreciationGLAN) {
		onClassPage.typeDepreciationGLAN(depreciationGLAN);
	}

	@Step
	public void typeCumulativeDepreciationGLAN(String cumulativeDepreciationGLAN) {
		onClassPage.typeCumulativeDepreciationGLAN(cumulativeDepreciationGLAN);
	}

	@Step
	public void typeGainLossDisposalGLAN(String gainLossDisposalGLAN) {
		onClassPage.typeGainLossDisposalGLAN(gainLossDisposalGLAN);
	}

	@Step
	public void typeDisposalClearingGLAN(String disposalClearingGLAN) {
		onClassPage.typeDisposalClearingGLAN(disposalClearingGLAN);
	}

	@Step
	public void typeFixedAssetClearingGLAN(String fixedAssetClearingGLAN) {
		onClassPage.typeFixedAssetClearingGLAN(fixedAssetClearingGLAN);
	}

	@Step
	public void typeProjectUtilizationGlan(String projectUtilizationGlan) {
		onClassPage.typeProjectUtilizationGlan(projectUtilizationGlan);
	}

	@Step
	public void checkAllCompany() {
		onClassPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onClassPage.chooseCompany(company);
	}

	@Step
	public void moveToCompanyTab() {
		onClassPage.switch_to_tab("Company");
	}

	@Step
	public void clickOnUpdateButton() {
		onClassPage.onClickUpdateButton();
	}

	@Step
	public void chooseDelFAClass(String fixedAssetClassCode) {
		onClassPage.deleteValueBySearchBtn("Search", "Fixed Asset Class Code", fixedAssetClassCode);
	}
}
