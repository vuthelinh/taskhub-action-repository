package com.synergix.mastersetup.project;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.mastersetup.project.steps.PolicyTypeSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PolicyTypeDefs {
	

	@Steps
	PolicyTypeSteps policyType;

	@When("^user creates new policy type$")
	public void user_creates_new_policy_type(List<List<String>> policyTypeList) throws Throwable {
		policyType.click_btn_add();
		SessionData.addDataTable("policyTypeTbl", policyTypeList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("policyTypeTbl");
		for (int row : testData.keySet()) {
			String sPolicyTypeCode = SessionData.getDataTbVal("policyTypeTbl", row, "Policy Type Code");
			String sDescription = SessionData.getDataTbVal("policyTypeTbl", row, "Description");
			policyType.click_btn_add();
			if (!sPolicyTypeCode.isEmpty()) {
				policyType.enter_policy_type_code(sPolicyTypeCode);
			}
			if (!sDescription.isEmpty()) {
				policyType.enter_description(sPolicyTypeCode,sDescription);
			}
		}

	}

	@When("^user update the policy type infomation$")
	public void user_update_the_policy_type_infomation() throws Throwable {
		policyType.click_btn_update();
		

	}

	@Then("^user found down the policy type in the list$")
	public void user_found_down_the_policy_type_in_the_list(List<List<String>> policyTypeList) throws Throwable {
		SessionData.addDataTable("policyTypeTbl", policyTypeList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("policyTypeTbl");
		for (int row : testData.keySet()) {
			String sPolicyTypeCode = SessionData.getDataTbVal("policyTypeTbl", row, "Policy Type Code");
			String sDescription = SessionData.getDataTbVal("policyTypeTbl", row, "Description");
			String sStatus = SessionData.getDataTbVal("policyTypeTbl", row, "Status");
			policyType.enter_policy_type_code_1(sPolicyTypeCode);
			policyType.select_status(sStatus);
			policyType.click_btn_update();
			policyType.verify_description(sDescription);
			
		}
	}

	@Then("^user delete policy type then policy type is not found in the list$")
	public void user_delete_policy_type_then_policy_type_is_not_found_in_the_list(List<List<String>> policyTypeList) throws Throwable {
		
		SessionData.addDataTable("policyTypeTbl", policyTypeList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("policyTypeTbl");
		for (int row : testData.keySet()) {
			String sPolicyTypeCode = SessionData.getDataTbVal("policyTypeTbl", row, "Policy Type Code");
			
			policyType.click_btn_delete();
			policyType.verify_policy_type_not_found(sPolicyTypeCode);
			
		}
	}

}
