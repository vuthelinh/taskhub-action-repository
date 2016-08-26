package com.synergix.globalsetup.fixedasset.steps;

import com.synergix.globalsetup.fixedasset.pages.CategoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CategorySteps extends ScenarioSteps {

	CategoryPage onCategoryPage;

	public void switchToIFrame() {
		onCategoryPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onCategoryPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeFixedAssetCategoryCode(String fixedAssetCategoryCode) {
		onCategoryPage.typeFixedAssetCategoryCode(fixedAssetCategoryCode);
	}

	@Step
	public void typeDescription(String description) {
		onCategoryPage.typeDescription(description);
	}

	@Step
	public void clickOnNewBtn() {
		onCategoryPage.clickBtn("New");
		onCategoryPage.waitForAllJSCompletes();
	}

	@Step
	public void checkAllCompany() {
		onCategoryPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onCategoryPage.chooseCompany(company);
	}

	@Step
	public void clickOnUpdateBtn() {
		onCategoryPage.clickOnUpdateBtn();
	}

	@Step
	public void chooseDelCategory(String fixedAssetCategoryCode) {
		onCategoryPage.deleteValueBySearchBtn("Search", "Asset Category Code", fixedAssetCategoryCode);
	}

}
