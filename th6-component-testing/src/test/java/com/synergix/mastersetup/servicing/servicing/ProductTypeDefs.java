package com.synergix.mastersetup.servicing.servicing;

import java.util.List;

import com.synergix.mastersetup.servicing.servicing.steps.ProductTypeSteps;
import com.synergix.utilities.SessionData;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by Lily Hoang on 8/02/2016.
 */
public class ProductTypeDefs {
	@Steps
	ProductTypeSteps productTypeStep;
	
	@When("^I want to create a new Product Type$")
	public void i_want_to_create_a_product_type() throws Throwable {
		productTypeStep.click_btn_add_new();
	}

	@When("^I want to update a Product Type with Key as \"([^\"]*)\"$")
	public void i_want_to_update_a_product_type_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Product Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {
			}
		}

	}

	@When("^I want to delete a Product Type as follow with Key as \"([^\"]*)\"$")
	public void i_want_to_delete_a_product_type_as_follow_with_key_as_something(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Product Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {
				if (productTypeStep.is_exist_product_type_code(sProductTypeCode)) {
					productTypeStep.check_product_type(sProductTypeCode);
				}
			}
		}
	}

	@Then("^The Product Type should be displayed on Product Type List as the followng with Key as \"([^\"]*)\"$")
	public void the_product_type_should_be_displayed_on_product_type_list_as_the_followng_with_key_as_something(
			String dataKey, List<List<String>> ProductTypelist) throws Throwable {
		SessionData.addDataTable("PRODUCTTYPELIST", ProductTypelist, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PRODUCTTYPELIST", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("PRODUCTTYPELIST", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("PRODUCTTYPELIST", row, "Product Type Code");
			String sDescription = SessionData.getDataTbVal("PRODUCTTYPELIST", row, "Description");
			String sStatus = SessionData.getDataTbVal("PRODUCTTYPELIST", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("PRODUCTTYPELIST", row, "Local Status");

			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {
				assertThat(productTypeStep.is_exist_product_type_code(sProductTypeCode)).isEqualTo(true);
			}
			if (!sDescription.isEmpty()) {

			}
			if (!sStatus.isEmpty()) {
				assertThat(productTypeStep.is_checked_status_label(sProductTypeCode, sStatus)).isEqualTo(true);
			}

		}

	}

	@Then("^I shouldnt see Product Type any more with Key as \"([^\"]*)\"$")
	public void i_shouldnt_see_product_type_any_more_with_key_as_something(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Product Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {
				assertThat(productTypeStep.is_exist_product_type_code(sProductTypeCode)).isEqualTo(false);
			}
		}

	}

	@And("^The Product Type has new information as the following with Key as \"([^\"]*)\"$")
	public void the_product_type_has_new_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> ProductType) throws Throwable {
		SessionData.addDataTable("PRODUCTTYPE", ProductType, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PRODUCTTYPE", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("PRODUCTTYPE", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("PRODUCTTYPE", row, "Product Type Code");
			String sDescription = SessionData.getDataTbVal("PRODUCTTYPE", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("PRODUCTTYPE", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("PRODUCTTYPE", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("PRODUCTTYPE", row, "Local Status");
			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {
				if (productTypeStep.is_readonly_product_type_code() == true) {

				} else {
					productTypeStep.enter_product_type_code(sProductTypeCode);
				}

			}
			if (!sDescription.isEmpty()) {
				productTypeStep.enter_description(sDescription);
			}
			if (!sCompanyNameList.isEmpty()) {
				productTypeStep.click_btn_collapse_company_name(sProductTypeCode);
				productTypeStep.check_company_list(sProductTypeCode, sCompanyNameList);

			}
			if (!sStatus.isEmpty()) {
				String is_update = productTypeStep.get_text_status_before_update();
				if (!(is_update.equals("Draft"))) {
					productTypeStep.selectRadioStatusWithLabel(sProductTypeCode, sStatus);

					if (sStatus.equals("Local Info")) {
						productTypeStep.selectRadioLocalInfoStatusWithLabel(sProductTypeCode, sLocalStatus);
					}
				}
				// assertThat(productTypeStep.get_text_status_before_update()).isEqualTo(sStatus);
			}
		}

	}

	@And("^The Product Type should be updated as the above information$")
	public void the_product_type_should_be_updated_as_the_above_information() throws Throwable {
		productTypeStep.click_btn_update();
	}

	@And("^Before update, the Product Type has information as the following with Key as \"([^\"]*)\"$")
	public void before_update_the_product_type_has_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> ProductType) throws Throwable {
		SessionData.addDataTable("PRODUCTTYPEB", ProductType, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PRODUCTTYPEB", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("PRODUCTTYPEB", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("PRODUCTTYPEB", row, "Product Type Code");
			String sDescription = SessionData.getDataTbVal("PRODUCTTYPEB", row, "Description");
			String sCompanyNameList = SessionData.getDataTbVal("PRODUCTTYPEB", row, "Company Name List");
			String sStatus = SessionData.getDataTbVal("PRODUCTTYPEB", row, "Status");
			String sLocalStatus = SessionData.getDataTbVal("PRODUCTTYPEB", row, "Local Status");
			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {
				assertThat(productTypeStep.is_exist_product_type_code(sProductTypeCode)).isEqualTo(true);

			}
			if (!sDescription.isEmpty()) {

			}
			if (!sCompanyNameList.isEmpty()) {

				productTypeStep.click_btn_collapse_company_name(sProductTypeCode);
				String[] arrcompName = sCompanyNameList.split(",");

				if (productTypeStep.count_table_company(sProductTypeCode) > 0) {
					for (int i1 = 0; i1 < productTypeStep.count_table_company(sProductTypeCode); i1++) {
						int j=i1+1;
							if (sCompanyNameList.contains(productTypeStep.get_text_company_name(j, sProductTypeCode))) {
								assertThat(productTypeStep.is_checked_company_name(j, sProductTypeCode))
										.isEqualTo(true);
							} else {
								assertThat(productTypeStep.is_checked_company_name(j, sProductTypeCode))
										.isEqualTo(false);
							}

						
					}

				}

			}
			if (!sStatus.isEmpty()) {

				assertThat(productTypeStep.get_text_checked_status_label(sProductTypeCode)).isEqualTo(sStatus);
			}

		}
	}

	@And("^Before delete,I want to make sure I will delete Product Type")
	public void before_deletei_want_to_make_sure_i_will_delete_product_type_with_key_as_something() throws Throwable {
		productTypeStep.click_btn_delete();
		productTypeStep.confirm_yes();
	}

	@And("^I search Product Type with Key as \"([^\"]*)\"$")
	public void i_search_product_type_with_key_as_something(String dataKey, List<List<String>> ProductType)
			throws Throwable {
		SessionData.addDataTable("SEARCHTBL", ProductType, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHTBL", "Key", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SEARCHTBL", row, "Key");
			String sProductTypeCode = SessionData.getDataTbVal("SEARCHTBL", row, "Product Type Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProductTypeCode.isEmpty()) {

				productTypeStep.enter_product_type_code_search(sProductTypeCode);
			}

		}
	}
}
