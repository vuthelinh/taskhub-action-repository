package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplEmployeeInfoPage;

public class EmplEmployeeInfoSteps extends ScenarioSteps {

	EmplEmployeeInfoPage onEmployeeInfoPage;

	@Step
	public void sub_company(String sub_company) {
		if (!sub_company.isEmpty())
			onEmployeeInfoPage.sub_company(sub_company);
	}

	@Step
	public void regional_office(String regional_office) {
		if (!regional_office.isEmpty())
			onEmployeeInfoPage.regional_office(regional_office);
	}

	@Step
	public void employee_job_type(String employee_job_type) {
		if (!employee_job_type.isEmpty())
			onEmployeeInfoPage.employee_job_type(employee_job_type);
	}

	@Step
	public void designation(String designation) {
		if (!designation.isEmpty())
			onEmployeeInfoPage.designation(designation);
	}

	@Step
	public void designation_group(String designation_group) {
		if (!designation_group.isEmpty())
			onEmployeeInfoPage.designation_group(designation_group);
	}

	@Step
	public void designation_category(String designation_category) {
		if (!designation_category.isEmpty())
			onEmployeeInfoPage.designation_category(designation_category);
	}

	@Step
	public void working_location(String working_location) {
		if (!working_location.isEmpty())
			onEmployeeInfoPage.working_location(working_location);
	}

	@Step
	public void designated_country(String designated_country) {
		if (!designated_country.isEmpty())
			onEmployeeInfoPage.designated_country(designated_country);
	}

}
