package com.synergix.globalsetup.fixedasset.steps;

import com.synergix.globalsetup.fixedasset.pages.LocationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LocationStep extends ScenarioSteps {

	LocationPage onLocationPage;

	public void switchToIFrame() {
		onLocationPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onLocationPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeFixedAssetLocationCode(String fixedAssetLocationCode) {
		onLocationPage.typeFixedAssetLocationCode(fixedAssetLocationCode);
	}

	@Step
	public void typeFixedAssetLocationName(String fixedAssetLocationName) {
		onLocationPage.typeFixedAssetLocationName(fixedAssetLocationName);
	}

	@Step
	public void checkAllCompany() {
		onLocationPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onLocationPage.chooseCompany(company);
	}

	@Step
	public void clickOnNewBtn() {
		onLocationPage.clickBtn("New");
		onLocationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnUpdateBtn() {
		onLocationPage.clickOnUpdateBtn();
	}

	@Step
	public void chooseDelFALocation(String fixedAssetLocationCode) {
		onLocationPage.deleteValueBySearchBtn("Search", "Fixed Asset Location Code", fixedAssetLocationCode);
	}
}
