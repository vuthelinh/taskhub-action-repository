package com.synergix.mastersetup.project.project.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.synergix.mastersetup.project.project.project.steps.CostItemGroupSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class CostItemGroupDefs {
	@Steps
	CostItemGroupSteps costItemGroupStep;

	@When("^Test")
	public void test(){
		String _Description="AUTO1";
		String _CompanyNameList="111";
		String _ServiceTypeCode="111";
		String _Status="Active";
		String _LocalStatus="Active";
		costItemGroupStep.create_new_cost_item_group(_ServiceTypeCode, _Description, _CompanyNameList, _Status, _LocalStatus);
	}
	
	@When("^I want to create a new Cost Item Group$")
	public void i_want_to_create_a_cost_item_group() throws Throwable {
		
		costItemGroupStep.click_btn_add_new();
		
	}

	@When("^I want to update a Cost Item Group with Key as \"([^\"]*)\"$")
	public void i_want_to_update_a_cost_item_group_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("SEARCHTBL", row, "Cost Item Group Code");
			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {
				costItemGroupStep.enter_cost_item_group_code_search(sCostItemGroupCode);
			}
		}

	}

	@When("^I want to delete a Cost Item Group as follow with Key as \"([^\"]*)\"$")
	public void i_want_to_delete_a_cost_item_group_as_follow_with_key_as_something(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("SEARCHTBL", row, "Cost Item Group Code");
			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {
				if (costItemGroupStep.is_exist_cost_item_group_code(sCostItemGroupCode)) {
					costItemGroupStep.check_cost_item_group();
				}
			}
		}
	}

	@Then("^The Cost Item Group should be displayed on Cost Item Group List as the followng with Key as \"([^\"]*)\"$")
	public void the_cost_item_group_should_be_displayed_on_cost_item_group_list_as_the_followng_with_key_as_something(
			String dataKey, List<List<String>> costItemGrouplist) throws Throwable {
		SessionData.addDataTable("COSTITEMGROUPLIST", costItemGrouplist, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("COSTITEMGROUPLIST", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("COSTITEMGROUPLIST", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("COSTITEMGROUPLIST", row, "Cost Item Group Code");
			String sDescription = SessionData.getDataTbVal("COSTITEMGROUPLIST", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("COSTITEMGROUPLIST", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("COSTITEMGROUPLIST", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("COSTITEMGROUPLIST", row, "Local Status");

			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {
				assertThat(costItemGroupStep.is_exist_cost_item_group_code(sCostItemGroupCode)).isEqualTo(true);
			}
			if (!sDescription.isEmpty()) {

			}
			if (!sStatus.isEmpty()) {
				assertThat(costItemGroupStep.is_checked_status_label(sStatus)).isEqualTo(true);
				if (sStatus.equals("Local Info")) {
					assertThat(costItemGroupStep.get_text_checked_local_status_label()).isEqualTo(sLocalStatus);
				}
				
				
			}
			if (!sCompanyNameList.isEmpty()) {

				costItemGroupStep.click_btn_expand_company_name();

				if (costItemGroupStep.count_table_company() > 0) {
					for (int i1 = 0; i1 < costItemGroupStep.count_table_company(); i1++) {
						int j = i1 + 1;
						if (sCompanyNameList.contains(costItemGroupStep.get_text_company_name(j))) {
							assertThat(costItemGroupStep.is_checked_company_name(j)).isEqualTo(true);
						} else {
							assertThat(costItemGroupStep.is_checked_company_name(j)).isEqualTo(false);
						}

					}

				}

			}

		}

	}

	@Then("^I shouldnt see Cost Item Group any more with Key as \"([^\"]*)\"$")
	public void i_shouldnt_see_cost_item_group_any_more_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("SEARCHTBL", row, "Cost Item Group Code");
			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {
				assertThat(costItemGroupStep.is_exist_cost_item_group_code(sCostItemGroupCode)).isEqualTo(false);
			}
		}

	}

	@And("^The Cost Item Group has new information as the following with Key as \"([^\"]*)\"$")
	public void the_cost_item_group_has_new_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> costItemGroup) throws Throwable {
		SessionData.addDataTable("COSTITEMGROUP", costItemGroup, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("COSTITEMGROUP", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("COSTITEMGROUP", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("COSTITEMGROUP", row, "Cost Item Group Code");
			String sDescription = SessionData.getDataTbVal("COSTITEMGROUP", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("COSTITEMGROUP", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("COSTITEMGROUP", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("COSTITEMGROUP", row, "Local Status");
			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {
				if (costItemGroupStep.is_readonly_cost_item_group_code() == true) {

				} else {
					costItemGroupStep.enter_cost_item_group_code(sCostItemGroupCode);
				}

			}
			if (!sDescription.isEmpty()) {
				costItemGroupStep.enter_description(sDescription);
			}
			if (!sCompanyNameList.isEmpty()) {
				costItemGroupStep.click_btn_expand_company_name();
				costItemGroupStep.check_company_list(sCompanyNameList);

			}
			if (!sStatus.isEmpty()) {
				String is_update = costItemGroupStep.get_text_status_before_update();
				if (!(is_update.equals("Draft"))) {
					costItemGroupStep.selectRadioStatusWithLabel(sStatus);

					if (sStatus.equals("Local Info")) {
						costItemGroupStep.selectRadioLocalInfoStatusWithLabel(sLocalStatus);
					}
				}
				// assertThat(costItemGroupStep.get_text_status_before_update()).isEqualTo(sStatus);
			}
		}

	}

	@And("^The Cost Item Group should be updated as the above information$")
	public void the_cost_item_group_should_be_updated_as_the_above_information() throws Throwable {
		costItemGroupStep.click_btn_update();
		costItemGroupStep.confirm_yes();
	}

	@And("^Before update, the Cost Item Group has information as the following with Key as \"([^\"]*)\"$")
	public void before_update_the_cost_item_group_has_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> costItemGroup) throws Throwable {
		SessionData.addDataTable("COSTITEMGROUPB", costItemGroup, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("COSTITEMGROUPB", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("COSTITEMGROUPB", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("COSTITEMGROUPB", row, "Cost Item Group Code");
			String sDescription = SessionData.getDataTbVal("COSTITEMGROUPB", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("COSTITEMGROUPB", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("COSTITEMGROUPB", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("COSTITEMGROUPB", row, "Local Status");
			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {
				assertThat(costItemGroupStep.is_exist_cost_item_group_code(sCostItemGroupCode)).isEqualTo(true);

			}
			if (!sDescription.isEmpty()) {

			}
			if (!sCompanyNameList.isEmpty()) {

				costItemGroupStep.click_btn_expand_company_name();

				if (costItemGroupStep.count_table_company() > 0) {
					for (int i1 = 0; i1 < costItemGroupStep.count_table_company(); i1++) {
						// for (int i = 0; i < arrcompName.length; i++) {
						int j = i1 + 1;
						if (sCompanyNameList.contains(costItemGroupStep.get_text_company_name(j))) {
							assertThat(costItemGroupStep.is_checked_company_name(j)).isEqualTo(true);
						} else {
							assertThat(costItemGroupStep.is_checked_company_name(j)).isEqualTo(false);
						}

					}

				}

			}
			if (!sStatus.isEmpty()) {

				assertThat(costItemGroupStep.get_text_checked_status_label(sCostItemGroupCode)).isEqualTo(sStatus);
			}

		}
	}

	@And("^Before delete,I want to make sure I will delete Cost Item Group")
	public void before_deletei_want_to_make_sure_i_will_delete_cost_item_group_with_key_as_something() throws Throwable {
		costItemGroupStep.click_btn_delete();
		costItemGroupStep.confirm_yes();
	}

	@And("^I search Cost Item Group with Key as \"([^\"]*)\"$")
	public void i_search_cost_item_group_with_key_as_something(String dataKey, List<List<String>> costItemGroup)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", costItemGroup, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sCostItemGroupCode = SessionData.getDataTbVal("SEARCHTBL", row, "Cost Item Group Code");
			if (!sKey.isEmpty()) {
			}
			if (!sCostItemGroupCode.isEmpty()) {

				costItemGroupStep.enter_cost_item_group_code_search(sCostItemGroupCode);
			}

		}
	}
}
