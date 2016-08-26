package com.synergix.globalsetup.fixedasset.steps;

import com.synergix.globalsetup.fixedasset.pages.FixedAssetPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FixedAssetSteps extends ScenarioSteps {

	FixedAssetPage onFixedAssetPage;

	public void switchToIFrame() {
		onFixedAssetPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onFixedAssetPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeFixedAssetCode(String fixedAssetCode) {
		onFixedAssetPage.typeFixedAssetCode(fixedAssetCode);
	}

	@Step
	public void typeDescription(String description) {
		onFixedAssetPage.typeDescription(description);
	}

	@Step
	public void typeDetailedSpecification(String detailedSpecification) {
		onFixedAssetPage.typeDetailedSpecification(detailedSpecification);
	}

	@Step
	public void typeFixedAssetClass(String fixedAssetClass) {
		onFixedAssetPage.typeFixedAssetClass(fixedAssetClass);
	}

	@Step
	public void typeFixedAssetCategory(String fixedAssetCategory) {
		onFixedAssetPage.typeFixedAssetCategory(fixedAssetCategory);
	}

	@Step
	public void chooseDepreciationMethod(String depreciationMethod) {
		onFixedAssetPage.chooseDepreciationMethod(depreciationMethod);
	}

	@Step
	public void chooseRateOnDecliningBalance(String rateOnDecliningBalance) {
		onFixedAssetPage.chooseRateOnDecliningBalance(rateOnDecliningBalance);
	}

	@Step
	public void typePercentageofStraightLineRate(String percentageofStraightLineRate) {
		onFixedAssetPage.typePercentageofStraightLineRate(percentageofStraightLineRate);
	}

	@Step
	public void typeUsefulLifeYear(String usefulLifeYear) {
		onFixedAssetPage.typeUsefulLifeYear(usefulLifeYear);
	}

	@Step
	public void typeUsefulLifePeriod(String usefulLifePeriod) {
		onFixedAssetPage.typeUsefulLifePeriod(usefulLifePeriod);
	}

	@Step
	public void typeTotalUsefulLife(String totalUsefulLife) {
		onFixedAssetPage.typeTotalUsefulLife(totalUsefulLife);
	}

	@Step
	public void chooseGlobalStatus(String globalStatus) {
		onFixedAssetPage.chooseGlobalStatus(globalStatus);
	}

	@Step
	public void typeUOM(String uOM) {
		onFixedAssetPage.typeUOM(uOM);
	}

	@Step
	public void typeVolume(String volume) {
		onFixedAssetPage.typeVolume(volume);
	}

	@Step
	public void typeGrossWeight(String grossWeight) {
		onFixedAssetPage.typeGrossWeight(grossWeight);
	}

	@Step
	public void typeLocation(String location) {
		onFixedAssetPage.typeLocation(location);
	}

	@Step
	public void chooseLocalInfoStatus(String localInfoStatus) {
		onFixedAssetPage.chooseLocalInfoStatus(localInfoStatus);
	}

	@Step
	public void clickOnNewBtn() {
		onFixedAssetPage.clickBtn("New");
		onFixedAssetPage.waitForAllJSCompletes();
	}

	@Step
	public void checkAllCompany() {
		onFixedAssetPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onFixedAssetPage.chooseCompany(company);
	}

	@Step
	public void clickOnUpdateBtn() {
		onFixedAssetPage.clickOnUpdateBtn();
	}

	@Step
	public void moveToLocalInfoTab() {
		onFixedAssetPage.switch_to_tab("Company");
	}

	@Step
	public void moveToCompanyTab() {
		onFixedAssetPage.switch_to_tab("Local Info");
	}

	@Step
	public void chooseDelFA(String fixedAssetCode) {
		onFixedAssetPage.deleteValueBySearchBtn("Search", "Asset Code", fixedAssetCode);
	}

}
