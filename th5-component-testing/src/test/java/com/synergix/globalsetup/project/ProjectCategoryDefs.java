package com.synergix.globalsetup.project;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.globalsetup.project.steps.ProjectCategorySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProjectCategoryDefs {
	@Steps
	ProjectCategorySteps projectCategorySteps;
	
	@Given("^user creates project category as \"([^\"]*)\"$")
	public void user_creates_project_category_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("projectCategoryTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("projectCategoryTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("projectCategoryTable", row, "KEY");
			String sProjectCategoryCode = SessionData.getDataTbVal("projectCategoryTable", row,
					"Project Category Code");
			String sDescription = SessionData.getDataTbVal("projectCategoryTable", row, "Description");
			String sCompany = SessionData.getDataTbVal("projectCategoryTable", row, "Company");
			String sStatus = SessionData.getDataTbVal("projectCategoryTable", row, "Status");
			if (!sKey.isEmpty()) {
				projectCategorySteps.click_add_new_button_on_functional_panel();
			}
			if (!sProjectCategoryCode.isEmpty()) {
				projectCategorySteps.enter_project_category_code(sProjectCategoryCode);
			}
			if (!sDescription.isEmpty()) {
				projectCategorySteps.enter_description(sDescription);
			}
			projectCategorySteps.click_update();
			if (!sStatus.isEmpty()) {
				projectCategorySteps.switch_to_tab_local_info();
				projectCategorySteps.select_status(sStatus);
			}
		}
		projectCategorySteps.click_update();
	}

	@When("^user searches for the project category with \"([^\"]*)\"$")
	public void user_searches_for_the_project_category_with(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("searchTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>(); 
		testData = SessionData.getDataTbRowsByValEqualInCol("searchTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
		String sKey = SessionData.getDataTbVal("searchTable", row, "KEY");
		String sProjectCategoryCode = SessionData.getDataTbVal("searchTable", row, "Project Category Code");
		if (!sKey.isEmpty()) {}
		if (!sProjectCategoryCode.isEmpty()) {
			projectCategorySteps.search_project_category(sProjectCategoryCode);
		}
		}
	}

	@Then("^user should see the project category with \"([^\"]*)\" having correct information$")
	public void user_should_see_the_project_category_with_having_correct_information(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("projectCategoryTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sProjectCategoryCode = SessionData.getDataTbVal("projectCategoryTable", row,
					"Project Category Code");
			String sDescription = SessionData.getDataTbVal("projectCategoryTable", row, "Description");
			String sStatus = SessionData.getDataTbVal("projectCategoryTable", row, "Status");
			
			if (!sProjectCategoryCode.isEmpty()) {
				projectCategorySteps.verify_project_category_code(sProjectCategoryCode);
			}
			if (!sDescription.isEmpty()) {
				projectCategorySteps.verify_description(sDescription);
			}
			
			if (!sStatus.isEmpty()) {
				projectCategorySteps.switch_to_tab_local_info();
				projectCategorySteps.verify_status(sStatus);
			}
		}	   
	}

	@When("^user deletes the project category with \"([^\"]*)\"$")
	public void user_deletes_the_project_category_with(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("deleteTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("deleteTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("deleteTable", row, "KEY");
			String sProjectCategoryCode = SessionData.getDataTbVal("deleteTable", row, "Project Category Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProjectCategoryCode.isEmpty()) {
				projectCategorySteps.click_delete();
			}
		}
	}

	@Then("^user should not see the project category with \"([^\"]*)\"$")
	public void user_should_not_see_the_project_category_with(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("deleteTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("deleteTable", row, "KEY");
			String sProjectCategoryCode = SessionData.getDataTbVal("deleteTable", row, "Project Category Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProjectCategoryCode.isEmpty()) {
				projectCategorySteps.verify_project_category_not_found(sProjectCategoryCode);;
			}
		}
	}
}
