package com.synergix.mastersetup.humanresource.employeeapprovingofficer;

import java.util.List;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.RegionalOfficeSteps;
import com.synergix.utilities.SessionData;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class RegionalOfficeDefs {
	@Steps
	RegionalOfficeSteps regionalOfficeStep;
	@When("^test")
	public void test(){
		String _RegionalOfficeName="Test";
		String _CompanyNameList="AUTO1";
		String _RegionalOfficeCode="111";
		
		regionalOfficeStep.creat_new_regional_office(_RegionalOfficeCode, _RegionalOfficeName, _CompanyNameList);
	}
	
	@When("^I want to create a new Regional Office$")
	public void i_want_to_create_a_regional_office() throws Throwable {
		regionalOfficeStep.clickon_btn_new_summary();
	}

	@When("^I want to update a Regional Office with Key as \"([^\"]*)\"$")
	public void i_want_to_update_a_regional_office_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sRegionalOfficeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Regional Office Code");
			if (!sKey.isEmpty()) {
			}
			if (!sRegionalOfficeCode.isEmpty()) {
				regionalOfficeStep.clickon_link_regional_office(sRegionalOfficeCode);
			}
		}

	}

	@When("^I want to delete a Regional Office as follow with Key as \"([^\"]*)\"$")
	public void i_want_to_delete_a_regional_office_as_follow_with_key_as_something(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sRegionalOfficeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Regional Office Code");
			if (!sKey.isEmpty()) {
			}
			if (!sRegionalOfficeCode.isEmpty()) {
				regionalOfficeStep.clickon_link_regional_office(sRegionalOfficeCode);
			}
		}
	}

	@Then("^The Regional Office should be displayed on Regional Office List as the followng with Key as \"([^\"]*)\"$")
	public void the_regional_office_should_be_displayed_on_regional_office_list_as_the_followng_with_key_as_something(
			String dataKey, List<List<String>> RegionalOfficelist) throws Throwable {
		SessionData.addDataTable("RegionalOfficeLIST", RegionalOfficelist, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("RegionalOfficeLIST", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Key");
			String sRegionalOfficeCode = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Regional Office Code");
			String sRegionalOfficeName = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Regional Office Name");
			String sCreatedBy = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Created By");
			String sCreatedDate = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Created Date");
			String sLastUpdatedBy = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Last Updated By");
			String sLastUpdatedDate = SessionData.getDataTbVal("RegionalOfficeLIST", row, "Last Updated Date");
			if (!sKey.isEmpty()) {
			}
			if (!sRegionalOfficeCode.isEmpty()) {
				assertThat(regionalOfficeStep.is_exist_regional_office_at_list(sRegionalOfficeCode)).isEqualTo(true);
			}
			if (!sRegionalOfficeName.isEmpty()) {
				assertThat(regionalOfficeStep.is_value_exist_at_colindex(sRegionalOfficeName, 2, sRegionalOfficeCode))
						.isEqualTo(true);

			}
			if (!sCreatedBy.isEmpty()) {
			}
			if (!sCreatedDate.isEmpty()) {
				assertThat(regionalOfficeStep.is_value_exist_at_colindex( regionalOfficeStep.get_today(), 4, sRegionalOfficeCode));
			}
			if (!sLastUpdatedBy.isEmpty()) {
			}
			if (!sLastUpdatedDate.isEmpty()) {
			}
		}

	}

	@Then("^I shouldnt see Regional Office any more with Key as \"([^\"]*)\"$")
	public void i_shouldnt_see_regional_office_any_more_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sRegionalOfficeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Regional Office Code");
			if (!sKey.isEmpty()) {
			}
			if (!sRegionalOfficeCode.isEmpty()) {
				assertThat(regionalOfficeStep.is_exist_regional_office_at_list(sRegionalOfficeCode)).isEqualTo(false);
			}
		}

	}

	@And("^The Regional Office has new information as the following with Key as \"([^\"]*)\"$")
	public void the_regional_office_has_new_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> RegionalOffice) throws Throwable {
		SessionData.addDataTable("RegionalOffice", RegionalOffice, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("RegionalOffice", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("RegionalOffice", row, "Key");
			String sRegionalOfficeCode = SessionData.getDataTbVal("RegionalOffice", row, "Regional Office Code");
			String sRegionalOfficeName = SessionData.getDataTbVal("RegionalOffice", row, "Regional Office Name");
			String sCompanyNameList = SessionData.getDataTbVal("RegionalOffice", row, "Company Name List");
			if (!sKey.isEmpty()) {
			}
			if (!sRegionalOfficeCode.isEmpty()) {
				if (regionalOfficeStep.is_readonly_regional_office_code() == true) {
					regionalOfficeStep.enter_regional_office_code(sRegionalOfficeCode);
				}

			}
			if (!sRegionalOfficeName.isEmpty()) {
				regionalOfficeStep.enter_regional_office_name(sRegionalOfficeName);
			}
			if (!sCompanyNameList.isEmpty()) {
				regionalOfficeStep.check_company_list(sCompanyNameList);

			}
		}

	}

	@And("^The Regional Office should be updated as the above information$")
	public void the_regional_office_should_be_updated_as_the_above_information() throws Throwable {
		regionalOfficeStep.clickon_btn_update();
		regionalOfficeStep.confirm_yes();
		regionalOfficeStep.clickon_btn_back_to_summary();
	}

	@And("^Before update, the Regional Office has information as the following with Key as \"([^\"]*)\"$")
	public void before_update_the_regional_office_has_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> RegionalOffice) throws Throwable {
		SessionData.addDataTable("REGIONALOFFICE", RegionalOffice, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("REGIONALOFFICE", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("REGIONALOFFICE", row, "Key");
			String sRegionalOfficeCode = SessionData.getDataTbVal("REGIONALOFFICE", row, "Regional Office Code");
			String sRegionalOfficeName = SessionData.getDataTbVal("REGIONALOFFICE", row, "Regional Office Name");
			String sCompanyNameList = SessionData.getDataTbVal("REGIONALOFFICE", row, "Company Name List");
			if (!sKey.isEmpty()) {
			}
			if (!sRegionalOfficeCode.isEmpty()) {
				assertThat(regionalOfficeStep.get_text_regional_office_code()).isEqualTo(sRegionalOfficeCode);

			}
			if (!sRegionalOfficeName.isEmpty()) {
				assertThat(regionalOfficeStep.get_text_regional_office_name()).isEqualTo(sRegionalOfficeName);

			}
			if (!sCompanyNameList.isEmpty()) {
				String[] arrcompName = sCompanyNameList.split(",");
				if (regionalOfficeStep.count_table_company() > 0) {
					for (int i = 0; i < arrcompName.length; i++) {

						for (int i1 = 0; i1 < regionalOfficeStep.count_table_company(); i1++) {
							
							if (regionalOfficeStep.get_text_company_name(i1) == arrcompName[i]) {
								assertThat(regionalOfficeStep.is_checked_company_name(i1)).isEqualTo(true);
							} else {
								assertThat(regionalOfficeStep.is_checked_company_name(i1)).isEqualTo(false);
							}

						}
					}

				}

			}
		}
	}

	@And("^Before delete,I want to make sure I will delete Regional Office")
	public void before_deletei_want_to_make_sure_i_will_delete_regional_office_with_key_as_something() throws Throwable {
		regionalOfficeStep.clickon_btn_delete();
		regionalOfficeStep.confirm_yes();
	}
}
