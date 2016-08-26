package com.synergix.globalsetup.cylinders.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.globalsetup.cylinders.pages.CylinderCapacityPage;

public class CylinderCapacitySteps extends ScenarioSteps {

	CylinderCapacityPage cylinderCapacityPage;

	@Step
	public void addCylinderCapacity() {
		cylinderCapacityPage.clickBtn("New");
		cylinderCapacityPage.waitForAllJSCompletes();
	}

	@Step
	public void enter_cylinder_capacity_code(String cylinderCapacityCode) {
		cylinderCapacityPage.enter_cylinder_capacity_code(cylinderCapacityCode);
	}

	@Step
	public void enter_description(String description) {
		cylinderCapacityPage.enter_description(description);
	}

	@Step
	public void enter_cylinder_capacity(String cylinderCapacity) {
		cylinderCapacityPage.enter_cylinder_capacity(cylinderCapacity);
	}

	@Step
	public void enter_interchangeable_group_code(String interchangeableGroupCode) {
		cylinderCapacityPage.enter_interchangeable_group_code(interchangeableGroupCode);
	}

	
	@Step
	public void clickUpdatebtn() {
		cylinderCapacityPage.clickBtn("Update");
		cylinderCapacityPage.waitForAllJSCompletes();
		cylinderCapacityPage.chooseYesOnUpdateConfirmation();
		cylinderCapacityPage.waitForAllJSCompletes();
		cylinderCapacityPage.chooseOKOnInfoPanel();
		cylinderCapacityPage.waitForAllJSCompletes();
	}

	@Step
	public void selectCylinderCapacity(String cylinderCapacityCode) {

	}

	@Step
	public void deleteCylinderCapacity() {
		cylinderCapacityPage.clickBtn("Delete");
		cylinderCapacityPage.waitForAllJSCompletes();
		cylinderCapacityPage.chooseYesOnUpdateConfirmation();

	}

	@Step
	public void searchCylinderCapacity(String cylinderCapacityCode) {
		cylinderCapacityPage.click_search_button_on_functional_panel();
		cylinderCapacityPage.searchCylinderCapacity(cylinderCapacityCode);
	}

	@Step
	public void verify_cylinder_capacity(String sCylinderCapacityCode, String sDescription, String sCylinderCapacity,
			String sInterchangeableGroupCode) {

		assertThat(cylinderCapacityPage.get_code(), equalTo(sCylinderCapacityCode));
		assertThat(cylinderCapacityPage.get_description(), equalTo(sDescription));
		assertThat(cylinderCapacityPage.get_cylinder_capacity(), equalTo(sCylinderCapacity));
		assertThat(cylinderCapacityPage.get_interchangeable_group_code(), equalTo(sInterchangeableGroupCode));

	}

	@Step
	public void verify_cylinder_capacity_is_deleted(String sCylinderCapacityCode) {
		addCylinderCapacity();
		cylinderCapacityPage.click_search_button_on_functional_panel();
		boolean found = cylinderCapacityPage.search(sCylinderCapacityCode);
		assertThat(found, equalTo(false));
	}

	@Step
	public String isAlreadyExistsInDatabase(String sCylinderCapacityCode) {
		return cylinderCapacityPage.check_database_exist("MT_CYL_CAPACITY", "CAPACITY_CODE", sCylinderCapacityCode);
	}

}
