package com.synergix.mastersetup.humanresource.employeeapprovingofficer;

import java.util.List;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.EmployeeJobTypeSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Lily Hoang on 7/29/2016.
 */
public class EmployeeJobTypeDefs {

	@Steps
	EmployeeJobTypeSteps EJobTypeStep;

	@When("^I want to create a Employee Job Type$")
	public void i_want_to_create_a_employee_job_type() throws Throwable {
		EJobTypeStep.clickon_btn_new_summary();
		EJobTypeStep.clickon_btn_new();

	}

	@And("^The Employee Job Type which has code as \"([^\"]*)\" has information as the following$")
	public void the_employee_job_type_which_has_code_as_something_has_information_as_the_following(String key,
			List<List<String>> EJobTypeTbl) throws Throwable {
		SessionData.addDataTable("EJOBTYPETABLE", EJobTypeTbl, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("EJOBTYPETABLE", "Key", key).keySet()) {
			String sKey = SessionData.getDataTbVal("EJOBTYPETABLE", row, "Key");
			String sEmployeeJobTypeCode = SessionData.getDataTbVal("EJOBTYPETABLE", row, "Employee Job Type Code");
			String sDescription = SessionData.getDataTbVal("EJOBTYPETABLE", row, "Description");
			String sUpdateProjectCostBasedOnMarkupRate = SessionData.getDataTbVal("EJOBTYPETABLE", row,
					"Update Project Cost based on Markup Rate");
			String sCompanyNameList = SessionData.getDataTbVal("EJOBTYPETABLE", row, "Company Name List");
			if (!sKey.isEmpty()) {

			}
			if (!sEmployeeJobTypeCode.isEmpty()) {
				if (EJobTypeStep.is_employee_job_type_code_enabled()) {
					EJobTypeStep.enter_employee_job_type_code(sEmployeeJobTypeCode);
				}
			}
			if (!sDescription.isEmpty()) {

				EJobTypeStep.enter_employee_job_type_desc(sDescription);
			}
			if (!sUpdateProjectCostBasedOnMarkupRate.isEmpty()) {
				EJobTypeStep.select_update_project_cost_yes();
			} else {
				EJobTypeStep.select_update_project_cost_no();
			}

			if (!sCompanyNameList.isEmpty()) {

				EJobTypeStep.check_company(sCompanyNameList);

			}
		}
	}

	@And("^The Employee Job Type should be updated as the above information$")
	public void the_employee_job_type_should_be_updated_as_the_above_information() throws Throwable {
		EJobTypeStep.clickon_btn_update();
		EJobTypeStep.confirm_yes();
		EJobTypeStep.clickon_btn_back_to_summary();
	}

	@Then("^The Employee Job Type should be displayed on Employee Job Type List with the \"([^\"]*)\"$")
	public void the_employee_job_type_should_be_displayed_on_employee_job_type_list_with_the_something(String key,
			List<List<String>> EJobTypeList) throws Throwable {
		SessionData.addDataTable("EJobTypeList", EJobTypeList, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("EJobTypeList", "Key", key).keySet()) {
			String sKey = SessionData.getDataTbVal("EJobTypeList", row, "Key");
			String sEmployeeJobTypeCode = SessionData.getDataTbVal("EJobTypeList", row, "Employee Job Type Code");
			String sDescription = SessionData.getDataTbVal("EJobTypeList", row, "Description");
			String sCreatedBy = SessionData.getDataTbVal("EJobTypeList", row, "Created By");
			String sCreatedDate = SessionData.getDataTbVal("EJobTypeList", row, "Created Date");
			String sLastUpdatedBy = SessionData.getDataTbVal("EJobTypeList", row, "Last Updated By");
			String sLastUpdatedDate = SessionData.getDataTbVal("EJobTypeList", row, "Last Updated Date");
			if (!sKey.isEmpty()) {
			}
			if (!sEmployeeJobTypeCode.isEmpty()) {
				assertThat(EJobTypeStep.is_Employee_Job_Type_exist(sEmployeeJobTypeCode)).isEqualTo(true);
			}
			if (!sDescription.isEmpty()) {
				assertThat(EJobTypeStep.is_value_exist_at_colname(sDescription, 2, sEmployeeJobTypeCode))
						.isEqualTo(true);
			}
			if (!sCreatedBy.isEmpty()) {
			}
			if (!sCreatedDate.isEmpty()) {
			}
			if (!sLastUpdatedBy.isEmpty()) {
			}
			if (!sLastUpdatedDate.isEmpty()) {
			}
		}
	}

	@When("^I want to update a Employee Job Type having \"([^\"]*)\"$")
	public void i_want_to_update_a_Employee_Job_Type_having(String key, List<List<String>> EJobTypeTblUpdate)
			throws Throwable {
		SessionData.addDataTable("EJobTypeTblUpdate", EJobTypeTblUpdate, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("EJobTypeTblUpdate", "Key", key).keySet()) {
			String sKey = SessionData.getDataTbVal("EJobTypeTblUpdate", row, "Key");
			String sEmployeeJobTypeCode = SessionData.getDataTbVal("EJobTypeTblUpdate", row, "Employee Job Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sEmployeeJobTypeCode.isEmpty()) {
				EJobTypeStep.clickon_employee_job_type_code(sEmployeeJobTypeCode);
			}
		}
	}

	@When("^I want to delete a Employee Job Type having \"([^\"]*)\"$")
	public void i_want_to_delete_a_Employee_Job_Type_having(String key, List<List<String>> EJobTypeTblDelete)
			throws Throwable {
		SessionData.addDataTable("EJobTypeTblDelete", EJobTypeTblDelete, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("EJobTypeTblDelete", "Key", key).keySet()) {
			String sKey = SessionData.getDataTbVal("EJobTypeTblDelete", row, "Key");
			String sEmployeeJobTypeCode = SessionData.getDataTbVal("EJobTypeTblDelete", row, "Employee Job Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sEmployeeJobTypeCode.isEmpty()) {
				EJobTypeStep.clickon_employee_job_type_code(sEmployeeJobTypeCode);
			}
		}
	}

	@When("^I confirm and delete this Employee Job Type$")
	public void i_confirm_and_delete_this_Employee_Job_Type() throws Throwable {
		EJobTypeStep.clickon_btn_delete();
		EJobTypeStep.confirm_yes();
	}

	@Then("^I shouldnt see it any more with the \"([^\"]*)\"$")
	public void i_shouldnt_see_it_any_more(String key, List<List<String>> EJobTypeTblDelete) throws Throwable {
		SessionData.addDataTable("EJobTypeTblDelete2", EJobTypeTblDelete, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("EJobTypeTblDelete2", "Key", key).keySet()) {
			String sKey = SessionData.getDataTbVal("EJobTypeTblDelete2", row, "Key");
			String sEmployeeJobTypeCode = SessionData.getDataTbVal("EJobTypeTblDelete2", row, "Employee Job Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sEmployeeJobTypeCode.isEmpty()) {
				assertThat(EJobTypeStep.is_Employee_Job_Type_exist(sEmployeeJobTypeCode)).isEqualTo(false);
			}
		}

	}

}
