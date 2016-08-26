package com.synergix.mastersetup.customerrelationmanagement;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.mastersetup.customerrelationmanagement.steps.GlobalMarketingContactGroupSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GlobalMarketingContactGroupDefs {

	@Steps
	GlobalMarketingContactGroupSteps globalMCGS;

	@When("^user creates new marketing contact group$")
	public void user_creates_new_marketing_contact_group(List<List<String>> globalList) throws Throwable {
		globalMCGS.click_btn_new();
		SessionData.addDataTable("globalMarketingContactGroupTbl", globalList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("globalMarketingContactGroupTbl");
		for (int row : testData.keySet()) {
			String sMarketingContactGroupCode = SessionData.getDataTbVal("globalMarketingContactGroupTbl", row,
					"Marketing Contact Group Code");
			String sDescription = SessionData.getDataTbVal("globalMarketingContactGroupTbl", row, "Description");
			if (!sMarketingContactGroupCode.isEmpty()) {
				globalMCGS.enter_global_marketing_contact_group_code(sMarketingContactGroupCode);

			}
			if (!sDescription.isEmpty()) {
				globalMCGS.enter_description(sDescription);
			}
		}
	}

	@When("^user update information$")
	public void user_update_information() throws Throwable {
		globalMCGS.click_btn_update();

	}

	@Then("^user found down the new marketing contact group in the list$")
	public void user_found_down_the_new_marketing_contact_group_in_the_list(List<List<String>> globalList)
			throws Throwable {
		globalMCGS.click_btn_back_to_summary();
		SessionData.addDataTable("globalMarketingContactGroupTbl", globalList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("globalMarketingContactGroupTbl");
		for (int row : testData.keySet()) {
			String sMarketingContactGroupCode = SessionData.getDataTbVal("globalMarketingContactGroupTbl", row,
					"Marketing Contact Group Code");
			String sDescription = SessionData.getDataTbVal("globalMarketingContactGroupTbl", row, "Description");

			globalMCGS.enter_global_marketing_contact_group_code_1(sMarketingContactGroupCode);
			globalMCGS.verify_global_marketing_contact_group_code(sMarketingContactGroupCode);
			globalMCGS.verify_global_description(sDescription);

		}
	}

	@When("^user delete a marketing contact group then the marketing contact group not found in the list$")
	public void user_delete_a_marketing_contact_group_then_the_marketing_contact_group_not_found_in_the_list(
			List<List<String>> globalList) throws Throwable {

		SessionData.addDataTable("globalMarketingContactGroupTbl", globalList);

		for (int row : SessionData.getDataTbRowsNoHeader("globalMarketingContactGroupTbl").keySet()) {
			String sMarketingContactGroupCode = SessionData.getDataTbVal("globalMarketingContactGroupTbl", row,
					"Marketing Contact Group Code");

			globalMCGS.click_btn_delete();
			globalMCGS.verify_mCode_not_found(sMarketingContactGroupCode);

		}
	}

}
