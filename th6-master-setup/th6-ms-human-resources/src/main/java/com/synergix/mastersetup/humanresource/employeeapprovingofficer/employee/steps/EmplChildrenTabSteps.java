package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplChildrenTabPage;

public class EmplChildrenTabSteps extends ScenarioSteps {

	EmplChildrenTabPage onChildrenTabPage;

	@Step
	public void moveToChildrenTab() {
		onChildrenTabPage.moveToTab("Children");
	}

	@Step
	public void employee_code(String employee_code) {
		if (!employee_code.isEmpty())
			onChildrenTabPage.employee_code(employee_code);
	}

	@Step
	public void name(String name) {
		if (!name.isEmpty())
			onChildrenTabPage.name(name);
	}

	@Step
	public void age_as_at2015(String age_as_at2015) {
		assertThat(onChildrenTabPage.age_as_at2015(), equalTo(age_as_at2015));
	}

	@Step
	public void date_of_birth(String date_of_birth) {
		if (!date_of_birth.isEmpty())
			onChildrenTabPage.date_of_birth(date_of_birth);
	}

	@Step
	public void nationality(String nationality) {
		if (!nationality.isEmpty())
			onChildrenTabPage.nationality(nationality);
	}

	@Step
	public void add_children() {
		onChildrenTabPage.addChildren();
	}

}
