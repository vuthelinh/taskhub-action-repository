package com.synergix.globalsetup.cylinders.steps;

import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.common.LogWork;
import com.synergix.globalsetup.cylinders.pages.CylinderBrandPages;

public class CylinderBrandSteps {
	CylinderBrandPages cylinderBrandPage;

	@Step
	public void enter_cylinder_brand_code(String cylinderBrandCode) {
		cylinderBrandPage.enter_cylinder_brand_code(cylinderBrandCode);
	}

	@Step
	public void enter_description(String description) {
		cylinderBrandPage.enter_description(description);
	}

	@Step
	public void addCylinderBrand() {
		cylinderBrandPage.clickBtn("New");
		cylinderBrandPage.waitForAllJSCompletes();
	}

	@Step
	public void update() {
		cylinderBrandPage.clickBtn("Update");
		cylinderBrandPage.waitForAllJSCompletes();
		cylinderBrandPage.chooseYesOnUpdateConfirmation();
		cylinderBrandPage.waitForAllJSCompletes();
		cylinderBrandPage.chooseOKOnInfoPanel();
		cylinderBrandPage.waitForAllJSCompletes();
	}

	@Step
	public void searchCylinderBrand(String sCylinderBrandCode) {
		cylinderBrandPage.click_search_button_on_functional_panel();
		cylinderBrandPage.search(sCylinderBrandCode);
	}

	@Step
	public void delete() {
		cylinderBrandPage.clickBtn("Delete");
		cylinderBrandPage.waitForAllJSCompletes();
		cylinderBrandPage.chooseYesOnUpdateConfirmation();
		cylinderBrandPage.waitForAllJSCompletes();
	}

	@Step
	public void verify_clyinder_branch_is_created(String sCylinderBrandCode, String sDescription) {
		cylinderBrandPage.click_search_button_on_functional_panel();
		cylinderBrandPage.search(sCylinderBrandCode);
		LogWork.log_debug("get code: " + cylinderBrandPage.get_code());
		assertThat(cylinderBrandPage.get_code(), equalTo(sCylinderBrandCode));
		assertThat(cylinderBrandPage.get_description(), equalTo(sDescription));
	}

	@Step
	public void verify_cylinder_brand_is_deleted(String sCylinderBrandCode) {
		addCylinderBrand();
		cylinderBrandPage.click_search_button_on_functional_panel();
		boolean found = cylinderBrandPage.search(sCylinderBrandCode);
		assertThat(found, equalTo(false));
	}

	@Step
	public String isAlreadyExistsInDatabase(String sCylinderCode) {
		return cylinderBrandPage.check_database_exist(sCylinderCode);
	}

}
