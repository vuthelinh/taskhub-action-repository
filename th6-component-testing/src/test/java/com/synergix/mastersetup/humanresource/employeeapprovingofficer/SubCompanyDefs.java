package com.synergix.mastersetup.humanresource.employeeapprovingofficer;

import java.util.List;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.SubCompanySteps;
import com.synergix.utilities.SessionData;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class SubCompanyDefs {
	@Steps
	SubCompanySteps subCompanyStep;

	@When("^subcompany")
	public void subcompany(){
		String _RegionalOfficeName="Test";
		String _CompanyNameList="AUTO1";
		String _RegionalOfficeCode="111";
		
		subCompanyStep.creat_new_regional_office(_RegionalOfficeCode, _RegionalOfficeName, _CompanyNameList);
	}
	
	
	@When("^I want to create a new Sub Company$")
	public void i_want_to_create_a_sub_company() throws Throwable {
		subCompanyStep.clickon_btn_new_summary();
	}

	@When("^I want to update a Sub Company with Key as \"([^\"]*)\"$")
	public void i_want_to_update_a_sub_company_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sSubCompanyCode = SessionData.getDataTbVal("SEARCHTBL", row, "Sub Company Code");
			if (!sKey.isEmpty()) {
			}
			if (!sSubCompanyCode.isEmpty()) {
				subCompanyStep.clickon_link_sub_company(sSubCompanyCode);
			}
		}

	}

	@When("^I want to delete a Sub Company as follow with Key as \"([^\"]*)\"$")
	public void i_want_to_delete_a_sub_company_as_follow_with_key_as_something(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sSubCompanyCode = SessionData.getDataTbVal("SEARCHTBL", row, "Sub Company Code");
			if (!sKey.isEmpty()) {
			}
			if (!sSubCompanyCode.isEmpty()) {
				subCompanyStep.clickon_link_sub_company(sSubCompanyCode);
			}
		}
	}

	@Then("^The Sub Company should be displayed on Sub Company List as the followng with Key as \"([^\"]*)\"$")
	public void the_sub_company_should_be_displayed_on_sub_company_list_as_the_followng_with_key_as_something(
			String dataKey, List<List<String>> subcompanylist) throws Throwable {
		SessionData.addDataTable("SUBCOMPANYLIST", subcompanylist, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SUBCOMPANYLIST", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Key");
			String sSubCompanyCode = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Sub Company Code");
			String sSubCompanyName = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Sub Company Name");
			String sCreatedBy = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Created By");
			String sCreatedDate = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Created Date");
			String sLastUpdatedBy = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Last Updated By");
			String sLastUpdatedDate = SessionData.getDataTbVal("SUBCOMPANYLIST", row, "Last Updated Date");
			if (!sKey.isEmpty()) {
			}
			if (!sSubCompanyCode.isEmpty()) {
				assertThat(subCompanyStep.is_sub_company_exist(sSubCompanyCode)).isEqualTo(true);
			}
			if (!sSubCompanyName.isEmpty()) {
				assertThat(subCompanyStep.is_value_exist_at_colindex(sSubCompanyName, 2, sSubCompanyCode))
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

	@Then("^I shouldnt see Sub Company any more with Key as \"([^\"]*)\"$")
	public void i_shouldnt_see_sub_company_any_more_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sSubCompanyCode = SessionData.getDataTbVal("SEARCHTBL", row, "Sub Company Code");
			if (!sKey.isEmpty()) {
			}
			if (!sSubCompanyCode.isEmpty()) {
				assertThat(subCompanyStep.is_sub_company_exist(sSubCompanyCode)).isEqualTo(false);
			}
		}

	}

	@And("^The Sub Company has new information as the following with Key as \"([^\"]*)\"$")
	public void the_sub_company_has_new_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> subCompany) throws Throwable {
		SessionData.addDataTable("SUBCOMPANY", subCompany, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SUBCOMPANY", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SUBCOMPANY", row, "Key");
			String sSubCompanyCode = SessionData.getDataTbVal("SUBCOMPANY", row, "Sub Company Code");
			String sSubCompanyName = SessionData.getDataTbVal("SUBCOMPANY", row, "Sub Company Name");
			String sCompanyNameList = SessionData.getDataTbVal("SUBCOMPANY", row, "Company Name List");
			if (!sKey.isEmpty()) {
			}
			if (!sSubCompanyCode.isEmpty()) {
				if (subCompanyStep.is_sub_company_code_enabled() == true) {
					subCompanyStep.enter_sub_company_code(sSubCompanyCode);
				}

			}
			if (!sSubCompanyName.isEmpty()) {
				subCompanyStep.enter_sub_company_name(sSubCompanyName);
			}
			if (!sCompanyNameList.isEmpty()) {
				subCompanyStep.check_company_list(sCompanyNameList);

			}
		}

	}

	@And("^The Sub Company should be updated as the above information$")
	public void the_sub_company_should_be_updated_as_the_above_information() throws Throwable {
		subCompanyStep.clickon_btn_update();
		subCompanyStep.confirm_yes();
		subCompanyStep.clickon_btn_back_to_summary();
	}

	@And("^Before update, the Sub Company has information as the following with Key as \"([^\"]*)\"$")
	public void before_update_the_sub_company_has_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> subCompany) throws Throwable {
		SessionData.addDataTable("SUBCOMPANY", subCompany, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SUBCOMPANY", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SUBCOMPANY", row, "Key");
			String sSubCompanyCode = SessionData.getDataTbVal("SUBCOMPANY", row, "Sub Company Code");
			String sSubCompanyName = SessionData.getDataTbVal("SUBCOMPANY", row, "Sub Company Name");
			String sCompanyNameList = SessionData.getDataTbVal("SUBCOMPANY", row, "Company Name List");
			if (!sKey.isEmpty()) {
			}
			if (!sSubCompanyCode.isEmpty()) {
				assertThat(subCompanyStep.get_text_sub_company_code()).isEqualTo(sSubCompanyCode);

			}
			if (!sSubCompanyName.isEmpty()) {
				assertThat(subCompanyStep.get_text_sub_company_name()).isEqualTo(sSubCompanyName);

			}
			if (!sCompanyNameList.isEmpty()) {
				String[] arrcompName = sCompanyNameList.split(",");
				if (subCompanyStep.count_table_company() > 0) {
					for (int i = 0; i < arrcompName.length; i++) {

						for (int i1 = 0; i1 < subCompanyStep.count_table_company(); i1++) {
							
							if (subCompanyStep.get_text_company_name(i1) == arrcompName[i]) {
								assertThat(subCompanyStep.is_checked_company_name(i1)).isEqualTo(true);
							} else {
								assertThat(subCompanyStep.is_checked_company_name(i1)).isEqualTo(false);
							}

						}
					}

				}

			}
		}
	}

	@And("^Before delete,I want to make sure I will delete Sub Company")
	public void before_deletei_want_to_make_sure_i_will_delete_sub_company_with_key_as_something() throws Throwable {
		subCompanyStep.clickon_btn_delete();
		subCompanyStep.confirm_yes();
	}
}
