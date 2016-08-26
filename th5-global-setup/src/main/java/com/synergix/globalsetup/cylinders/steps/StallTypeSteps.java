package com.synergix.globalsetup.cylinders.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.globalsetup.cylinders.pages.StallTypePages;

public class StallTypeSteps extends ScenarioSteps{
	StallTypePages stallTypePages;

	@Step
	public void enter_stall_type_code(String stallTypeCode) {
		stallTypePages.enter_stall_type_code(stallTypeCode);
	}

	@Step
	public void enter_description(String description) {
		stallTypePages.enter_description(description);
	}

	@Step
	public void click_add_new_stall_type() {
		stallTypePages.clickBtn("New");
		stallTypePages.waitForAllJSCompletes();
	}
	
	@Step
	public void click_on_update() {
		stallTypePages.click_update_button_on_functional_panel();
	}

	@Step
	public void search_stall_type(String sStallTypeCode) {
		stallTypePages.click_search_button_on_functional_panel();
		stallTypePages.search_stall_type( sStallTypeCode);
	}

	@Step
	public void delete_stall_type() {
		stallTypePages.click_delete_button_on_functional_panel();
		
	}

	@Step
	public void verify_stall_type(String sStallTypeCode, String sDescription) {
		assertThat(stallTypePages.get_code(), equalTo(sStallTypeCode));
		assertThat(stallTypePages.get_des(), equalTo(sDescription));
		
	}

	@Step
	public void verify_deleted(String sStallTypeCode) {
		click_add_new_stall_type();
		stallTypePages.click_search_button_on_functional_panel();
		boolean found = stallTypePages.search(sStallTypeCode);
		assertThat(found, equalTo(false));
	}

}
