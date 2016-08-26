package com.synergix.mastersetup.servicing.servicing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.synergix.mastersetup.servicing.servicing.steps.ServiceTypeSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class ServiceTypeDefs {
	@Steps
	ServiceTypeSteps serviceTypeStep;

	@When("^I want to create a new Service Type$")
	public void i_want_to_create_a_service_type() throws Throwable {
		serviceTypeStep.click_btn_add_new();
	}

	@When("^I want to update a Service Type with Key as \"([^\"]*)\"$")
	public void i_want_to_update_a_service_type_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Service Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {
				serviceTypeStep.enter_service_type_code_search(sServiceTypeCode);
			}
		}

	}

	@When("^I want to delete a Service Type as follow with Key as \"([^\"]*)\"$")
	public void i_want_to_delete_a_service_type_as_follow_with_key_as_something(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Service Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {
				if (serviceTypeStep.is_exist_service_type_code(sServiceTypeCode)) {
					serviceTypeStep.check_service_type();
				}
			}
		}
	}

	@Then("^The Service Type should be displayed on Service Type List as the followng with Key as \"([^\"]*)\"$")
	public void the_service_type_should_be_displayed_on_service_type_list_as_the_followng_with_key_as_something(
			String dataKey, List<List<String>> serviceTypelist) throws Throwable {
		SessionData.addDataTable("SERVICETYPELIST", serviceTypelist, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SERVICETYPELIST", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SERVICETYPELIST", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SERVICETYPELIST", row, "Service Type Code");
			String sDescription = SessionData.getDataTbVal("SERVICETYPELIST", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("SERVICETYPELIST", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("SERVICETYPELIST", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("SERVICETYPELIST", row, "Local Status");

			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {
				assertThat(serviceTypeStep.is_exist_service_type_code(sServiceTypeCode)).isEqualTo(true);
			}
			if (!sDescription.isEmpty()) {

			}
			if (!sStatus.isEmpty()) {
				assertThat(serviceTypeStep.is_checked_status_label(sStatus)).isEqualTo(true);
				if (sStatus.equals("Local Info")) {
					assertThat(serviceTypeStep.get_text_checked_local_status_label()).isEqualTo(sLocalStatus);
				}
				
				
			}
			if (!sCompanyNameList.isEmpty()) {

				serviceTypeStep.click_btn_expand_company_name();

				if (serviceTypeStep.count_table_company() > 0) {
					for (int i1 = 0; i1 < serviceTypeStep.count_table_company(); i1++) {
						int j = i1 + 1;
						if (sCompanyNameList.contains(serviceTypeStep.get_text_company_name(j))) {
							assertThat(serviceTypeStep.is_checked_company_name(j)).isEqualTo(true);
						} else {
							assertThat(serviceTypeStep.is_checked_company_name(j)).isEqualTo(false);
						}

					}

				}

			}

		}

	}

	@Then("^I shouldnt see Service Type any more with Key as \"([^\"]*)\"$")
	public void i_shouldnt_see_service_type_any_more_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Service Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {
				assertThat(serviceTypeStep.is_exist_service_type_code(sServiceTypeCode)).isEqualTo(false);
			}
		}

	}

	@And("^The Service Type has new information as the following with Key as \"([^\"]*)\"$")
	public void the_service_type_has_new_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> serviceType) throws Throwable {
		SessionData.addDataTable("SERVICETYPE", serviceType, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SERVICETYPE", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SERVICETYPE", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SERVICETYPE", row, "Service Type Code");
			String sDescription = SessionData.getDataTbVal("SERVICETYPE", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("SERVICETYPE", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("SERVICETYPE", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("SERVICETYPE", row, "Local Status");
			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {
				if (serviceTypeStep.is_readonly_service_type_code() == true) {

				} else {
					serviceTypeStep.enter_service_type_code(sServiceTypeCode);
				}

			}
			if (!sDescription.isEmpty()) {
				serviceTypeStep.enter_description(sDescription);
			}
			if (!sCompanyNameList.isEmpty()) {
				serviceTypeStep.click_btn_expand_company_name();
				serviceTypeStep.check_company_list(sCompanyNameList);

			}
			if (!sStatus.isEmpty()) {
				String is_update = serviceTypeStep.get_text_status_before_update();
				if (!(is_update.equals("Draft"))) {
					serviceTypeStep.selectRadioStatusWithLabel(sStatus);

					if (sStatus.equals("Local Info")) {
						serviceTypeStep.selectRadioLocalInfoStatusWithLabel(sLocalStatus);
					}
				}
				// assertThat(serviceTypeStep.get_text_status_before_update()).isEqualTo(sStatus);
			}
		}

	}

	@And("^The Service Type should be updated as the above information$")
	public void the_service_type_should_be_updated_as_the_above_information() throws Throwable {
		serviceTypeStep.click_btn_update();
	}

	@And("^Before update, the Service Type has information as the following with Key as \"([^\"]*)\"$")
	public void before_update_the_service_type_has_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> serviceType) throws Throwable {
		SessionData.addDataTable("SERVICETYPEB", serviceType, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SERVICETYPEB", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SERVICETYPEB", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SERVICETYPEB", row, "Service Type Code");
			String sDescription = SessionData.getDataTbVal("SERVICETYPEB", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("SERVICETYPEB", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("SERVICETYPEB", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("SERVICETYPEB", row, "Local Status");
			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {
				assertThat(serviceTypeStep.is_exist_service_type_code(sServiceTypeCode)).isEqualTo(true);

			}
			if (!sDescription.isEmpty()) {

			}
			if (!sCompanyNameList.isEmpty()) {

				serviceTypeStep.click_btn_expand_company_name();

				if (serviceTypeStep.count_table_company() > 0) {
					for (int i1 = 0; i1 < serviceTypeStep.count_table_company(); i1++) {
						// for (int i = 0; i < arrcompName.length; i++) {
						int j = i1 + 1;
						if (sCompanyNameList.contains(serviceTypeStep.get_text_company_name(j))) {
							assertThat(serviceTypeStep.is_checked_company_name(j)).isEqualTo(true);
						} else {
							assertThat(serviceTypeStep.is_checked_company_name(j)).isEqualTo(false);
						}

					}

				}

			}
			if (!sStatus.isEmpty()) {

				assertThat(serviceTypeStep.get_text_checked_status_label(sServiceTypeCode)).isEqualTo(sStatus);
			}

		}
	}

	@And("^Before delete,I want to make sure I will delete Service Type")
	public void before_deletei_want_to_make_sure_i_will_delete_service_type_with_key_as_something() throws Throwable {
		serviceTypeStep.click_btn_delete();
		serviceTypeStep.confirm_yes();
	}

	@And("^I search Service Type with Key as \"([^\"]*)\"$")
	public void i_search_service_type_with_key_as_something(String dataKey, List<List<String>> serviceType)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", serviceType, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sServiceTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Service Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sServiceTypeCode.isEmpty()) {

				serviceTypeStep.enter_service_type_code_search(sServiceTypeCode);
			}

		}
	}
}
