package com.synergix.mastersetup.humanresource.employeeapprovingofficer;

import java.util.LinkedHashMap;
import java.util.List;

import org.assertj.core.api.Assertions;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employeegrade.steps.EmployeeGradeSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EmployeeGradeDefs {

	@Steps
	EmployeeGradeSteps employeeGradeSteps;

	@When("^user want to create a new Employee Grade with Key as \"([^\"]*)\"$")
	public void i_want_to_create_a_new_Employee_Grade_with_Key_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("EMPLOYEEGRADETBL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("EMPLOYEEGRADETBL", "KEY", dataKey);
		for (int row : testData.keySet()) {
			employeeGradeSteps.click_on_button_new();
			String sGradeCode = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Grade Code");
			String sDescription = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Description");
			if (!sGradeCode.isEmpty())
				employeeGradeSteps.enter_employee_grade_code(sGradeCode);
			if (!sDescription.isEmpty())
				employeeGradeSteps.enter_des_employee_grade(sDescription);
		}
		employeeGradeSteps.click_on_button_back_to_summary();
	}

	@Then("^the Employee Grade table should be displayed as the following with Key as \"([^\"]*)\"$")
	public void the_Employee_Grade_table_should_be_displayed_as_the_following_with_Key_as(String dataKey,
			List<List<String>> dataTable) {
		SessionData.addDataTable("EMPLOYEEGRADETBL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("EMPLOYEEGRADETBL", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sGradeCode = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Grade Code");
			String sDescription = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Description");
			String sCreatedBy = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Created By");
			String sCreatedDate = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Created Date");
			String sLastUpdatedBy = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Last Updated By");
			String sLastUpdatedDate = SessionData.getDataTbVal("EMPLOYEEGRADETBL", row, "Last Updated Date");
			if (!sGradeCode.isEmpty())
				System.out.println(employeeGradeSteps.is_emp_grade_exist(sGradeCode));
			Assertions.assertThat(employeeGradeSteps.is_emp_grade_exist(sGradeCode)).isEqualTo(true);
			if (!sDescription.isEmpty())
				System.out.println(employeeGradeSteps.is_value_exist_at_colindex(sDescription, sGradeCode));
			Assertions.assertThat(employeeGradeSteps.is_value_exist_at_colindex(sDescription, sGradeCode))
					.isEqualTo(true);
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

	@When("^user want to update an Employee Grade with Key as \"([^\"]*)\"$")
	public void user_want_to_update_an_Employee_Grade_with_Key_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("EMPLOYEEGRADETBL1", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("EMPLOYEEGRADETBL1", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sGradeCode = SessionData.getDataTbVal("EMPLOYEEGRADETBL1", row, "Grade Code");
			String sDescription = SessionData.getDataTbVal("EMPLOYEEGRADETBL1", row, "Description");
			if (!sGradeCode.isEmpty()) {
				employeeGradeSteps.click_on_grade_code(sGradeCode);
				employeeGradeSteps.enter_des_employee_grade(sDescription);
				employeeGradeSteps.click_on_button_update();
				employeeGradeSteps.click_on_button_back_to_summary();
			}
		}
	}

	@Then("^the Employee Grade table should be updated as the following with Key as \"([^\"]*)\"$")
	public void the_Employee_Grade_table_should_be_updated_as_the_following_with_Key_as(String dataKey,
			List<List<String>> dataTable) {
		SessionData.addDataTable("EMPLOYEEGRADETBL2", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("EMPLOYEEGRADETBL2", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sGradeCode = SessionData.getDataTbVal("EMPLOYEEGRADETBL2", row, "Grade Code");
			String sDescription = SessionData.getDataTbVal("EMPLOYEEGRADETBL2", row, "Description");
			String sCreatedBy = SessionData.getDataTbVal("EMPLOYEEGRADETBL2", row, "Created By");
			String sCreatedDate = SessionData.getDataTbVal("EMPLOYEEGRADETBL2", row, "Created Date");
			String sLastUpdatedBy = SessionData.getDataTbVal("EMPLOYEEGRADETBL2", row, "Last Updated By");
			String sLastUpdatedDate = SessionData.getDataTbVal("EMPLOYEEGRADETBL2", row, "Last Updated Date");
			if (!sGradeCode.isEmpty())
				System.out.println(employeeGradeSteps.is_emp_grade_exist(sGradeCode));
			Assertions.assertThat(employeeGradeSteps.is_emp_grade_exist(sGradeCode)).isEqualTo(true);
			if (!sDescription.isEmpty())
				System.out.println(employeeGradeSteps.is_value_exist_at_colindex(sDescription, sGradeCode));
			Assertions.assertThat(employeeGradeSteps.is_value_exist_at_colindex(sDescription, sGradeCode))
					.isEqualTo(true);
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

	@When("^user want to delete an Employee Grade with Key as \"([^\"]*)\"$")
	public void user_want_to_delete_an_Employee_Grade_with_Key_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("EMPGRADETBLB4DEL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("EMPGRADETBLB4DEL", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sGradeCode = SessionData.getDataTbVal("EMPGRADETBLB4DEL", row, "Grade Code");
			if (!sGradeCode.isEmpty()) {
				employeeGradeSteps.click_on_grade_code(sGradeCode);
				employeeGradeSteps.click_on_button_delete();
			}
		}
	}

	@Then("^user should not see an Employee Grade with Key as \"([^\"]*)\"$")
	public void user_should_not_see_an_Employee_Grade_with_Key_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("EMPGRADETBLAFTERDEL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("EMPGRADETBLAFTERDEL", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sGradeCode = SessionData.getDataTbVal("EMPGRADETBLAFTERDEL", row, "Grade Code");
			if (!sGradeCode.isEmpty())
				System.out.println(employeeGradeSteps.is_emp_grade_exist(sGradeCode));
			Assertions.assertThat(employeeGradeSteps.is_emp_grade_exist(sGradeCode)).isEqualTo(false);
		}
	}
}
