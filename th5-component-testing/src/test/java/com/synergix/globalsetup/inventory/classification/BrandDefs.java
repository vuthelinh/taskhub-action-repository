package com.synergix.globalsetup.inventory.classification;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import com.synergix.common.LogWork;
import com.synergix.globalsetup.inventory.classification.steps.BrandSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BrandDefs {
	@Steps
	BrandSteps BrandSteps;

	@When("^I want to create a new Brand$")
	public void i_want_to_create_a_new_Brand() throws Throwable {
		BrandSteps.click_btn_new();

	}

	@And("^Precisely,The \"([^\"]*)\" Brand has general infomation as the following$")
	public void precisely_The_Brand_has_general_infomation_as_the_following(String brandCode,
			List<List<String>> generalInfo) throws Throwable {
		SessionData.addDataTable("GENERALINFO", generalInfo,false);
		System.out.println("trước khi thêm mới");
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GENERALINFO", "Inventory Brand Code", brandCode)
				.keySet()) {
		
			String sInventoryBrandCode = SessionData.getDataTbVal("GENERALINFO", row, "Inventory Brand Code");
			LogWork.log_debug("sInventoryBrandCode" + sInventoryBrandCode);
			
			String sDescription = SessionData.getDataTbVal("GENERALINFO", row, "Description");
			System.out.println("sau khi vào vòng for");
			//if (!sInventoryBrandCode.isEmpty() && (!BrandSteps.is_readonly_inventory_brand_code())) {
			if (!sInventoryBrandCode.isEmpty()) {
				BrandSteps.click_txt_inventory_brand_code();
				BrandSteps.enter_inventory_brand_code(sInventoryBrandCode);
			}
			if (!sDescription.isEmpty()) {
				BrandSteps.enter_inventory_brand_description(sDescription);
			}
			assertThat(BrandSteps.get_text_inventory_brand_code()).isEqualTo(sInventoryBrandCode);
		}
		

	}

	@And("^The \"([^\"]*)\" brand has the infomation of Forecast as the following$")
	public void the_brand_has_the_infomation_of_Forecast_as_the_following(String brandCode,
			List<List<String>> forecasttable) throws Throwable {
		SessionData.addDataTable("FORECASTTABLE", forecasttable,false);
		BrandSteps.switch_tab_forecast();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("FORECASTTABLE", "Inventory Brand Code", brandCode)
				.keySet()) {
			String sInventoryBrandCode = SessionData.getDataTbVal("FORECASTTABLE", row, "Inventory Brand Code");
			String sTargetMonthSupplyQty = SessionData.getDataTbVal("FORECASTTABLE", row, "Target Month Supply Qty");
			String sTargetValue = SessionData.getDataTbVal("FORECASTTABLE", row, "Target Value");
			if (!sInventoryBrandCode.isEmpty()) {
			}

			if (!sTargetMonthSupplyQty.isEmpty()) {
				BrandSteps.enter_target_month_supply_qty(sTargetMonthSupplyQty);
			}
			
			if (!sTargetValue.isEmpty()) {
				BrandSteps.enter_target_value(sTargetValue);
			}
			
			assertThat(BrandSteps.get_text_target_month_supply_qty()).isEqualTo(sTargetMonthSupplyQty);
			assertThat(BrandSteps.get_text_target_value()).isEqualTo(sTargetValue);
		}
		

	}

	@And("^The \"([^\"]*)\" brand has the infomation of Service Level as the following$")
	public void the_brand_has_the_infomation_of_Service_Level_as_the_following(String brandCode,
			List<List<String>> serviceLeveTbl) throws Throwable {
		SessionData.addDataTable("SLTABLE", serviceLeveTbl,false);
		BrandSteps.switch_tab_service_level();
		
		if (BrandSteps.count_table_row_service_level()>0) {
			for (int i = 0; i < BrandSteps.count_table_row_service_level(); i++) {
				BrandSteps.find_and_check_checkbox_service_level(i);
			}
			BrandSteps.click_btn_service_level_delete();
			BrandSteps.click_btn_confirm_yes();
		}
		
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SLTABLE", "Inventory Brand Code", brandCode)
				.keySet()) {
			String sInventoryBrandCode = SessionData.getDataTbVal("SLTABLE", row, "Inventory Brand Code");
			String sCode = SessionData.getDataTbVal("SLTABLE", row, "Code");
			String sDescription = SessionData.getDataTbVal("SLTABLE", row, "Description");
			String sServiceLevelValue = SessionData.getDataTbVal("SLTABLE", row, "Service Level Value");
			String sZValue = SessionData.getDataTbVal("SLTABLE", row, "Z Value");
			String sDel = SessionData.getDataTbVal("SLTABLE", row, "Del");
			if (!sInventoryBrandCode.isEmpty()) {}
			
			
			
			BrandSteps.click_btn_service_level_add();

			if (!sCode.isEmpty()) {
				BrandSteps.enter_service_level_code(sCode);

			}
			if (!sDescription.isEmpty()) {
				BrandSteps.enter_service_level_description(sDescription);
			}
			if (!sServiceLevelValue.isEmpty()) {
				BrandSteps.enter_service_level_value(sServiceLevelValue);
			}
			if (!sZValue.isEmpty()) {
				BrandSteps.enter_z_value(sZValue);
			}
			if (!sDel.isEmpty()) {
				// BrandSteps.check_service_level_del();
			}

			
		}

	}

	@When("^The \"([^\"]*)\" brand has the infomation of EOQ Calculation as the following$")
	public void the_brand_has_the_infomation_of_EOQ_Calculation_as_the_following(String brandCode,
			List<List<String>> eoqTable) throws Throwable {
		SessionData.addDataTable("EOQTABLE", eoqTable,false);
		BrandSteps.switch_tab_eoq_calculation();
		if(BrandSteps.count_table_row_eoq_calculation()>0){
			for (int i = 0; i < BrandSteps.count_table_row_eoq_calculation(); i++) {
				BrandSteps.find_and_check_checkbox_eoq_calculation(i);
			}
			BrandSteps.click_btn_eoq_delete();;
			
			BrandSteps.click_btn_confirm_yes();
			}
		
		for (int row : SessionData.getDataTbRowsByValEqualInCol("EOQTABLE", "Inventory Brand Code", brandCode)
				.keySet()) {
			String sInventoryBrandCode = SessionData.getDataTbVal("EOQTABLE", row, "Inventory Brand Code");
			String sCode = SessionData.getDataTbVal("EOQTABLE", row, "Code");
			String sDescription = SessionData.getDataTbVal("EOQTABLE", row, "Description");
			String sValue = SessionData.getDataTbVal("EOQTABLE", row, "Value");
			String sDel = SessionData.getDataTbVal("EOQTABLE", row, "Del");
			
			
			if (!sInventoryBrandCode.isEmpty()) {
				BrandSteps.click_btn_eoq_add();
			}
			if (!sCode.isEmpty()) {
				BrandSteps.enter_eoq_code(sCode);
			}
			if (!sDescription.isEmpty()) {
				BrandSteps.enter_eoq_description(sDescription);
			}
			if (!sValue.isEmpty()) {
				BrandSteps.enter_eoq_value(sValue);
			}
			if (!sDel.isEmpty()) {
				// BrandSteps.check_eoq_del();
			}
			
			
			
		}
	}

	@When("^The \"([^\"]*)\" brand has the infomation of Supplier as the following$")
	public void the_brand_has_the_infomation_of_Supplier_as_the_following(String brandCode,
			List<List<String>> supplierTable) throws Throwable {
		SessionData.addDataTable("SUPPLIERTABLE", supplierTable,false);
		BrandSteps.switch_tab_supplier();
		
		
		if (BrandSteps.count_table_row_supplier()>0) {
			for (int i = 0; i < BrandSteps.count_table_row_supplier(); i++) {
				BrandSteps.find_and_check_checkbox_supplier(i);
			}
			BrandSteps.click_btn_supplier_delete();
			BrandSteps.click_btn_confirm_yes();
		}
		
		// String preSupplierCode = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SUPPLIERTABLE", "Inventory Brand Code", brandCode)
				.keySet()) {
			String sInventoryBrandCode = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Inventory Brand Code");
			String sSupplierCode = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Supplier Code");
			String sMinOrderQty = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Min Order Qty");
			String sLeadTimeLink = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Lead Time Link");
			String sDefault = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Default");
			String sSupplierDel = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Supplier Del");
			String sLeadTimeCode = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Lead Time Code");
			String sLeadTimeDescription = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Lead Time Description");
			String sLeadTime = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Lead Time");
			String sLeadTimeDel = SessionData.getDataTbVal("SUPPLIERTABLE", row, "Lead Time Del");
			
			if (!sInventoryBrandCode.isEmpty()) {

				if (!sSupplierCode.isEmpty() && !sLeadTimeLink.isEmpty()) {
					BrandSteps.click_btn_supplier_add();
					BrandSteps.enter_supplier_code(sSupplierCode);
					if (!sMinOrderQty.isEmpty()) {
						BrandSteps.enter_min_order_qty(sMinOrderQty);
					}
					if (!sDefault.isEmpty()) {
						BrandSteps.select_supplier_default();
					}
					if (!sSupplierDel.isEmpty()) {
						// BrandSteps.check_supplier_del();
					}
				}
			}

			// if (sLeadTimeLink.isEmpty()) {
			BrandSteps.click_on_lead_time();

			if (!sLeadTimeCode.isEmpty()) {
				BrandSteps.click_btn_leadtime_add();
				BrandSteps.enter_leadtime_code(sLeadTimeCode);
			}
			if (!sLeadTimeDescription.isEmpty()) {
				BrandSteps.enter_leadtime_desc(sLeadTimeDescription);
			}
			if (!sLeadTime.isEmpty()) {
				BrandSteps.enter_leadtime_value(sLeadTime);
				;
			}
			if (!sLeadTimeDel.isEmpty()) {
				// BrandSteps.check_leadtime_del();
			}
			BrandSteps.click_btn_leadtime_done();
			// }

			// preSupplierCode = sSupplierCode;

		}
	}

	@When("^The \"([^\"]*)\" brand has the infomation of Company as the following$")
	public void the_brand_has_the_infomation_of_Company_as_the_following(String brandCode,
			List<List<String>> companyTable) throws Throwable {
		SessionData.addDataTable("COMPANYTABLE", companyTable,false);
		BrandSteps.switch_tab_company();
		if (BrandSteps.is_checked_tag_all()) {
			BrandSteps.uncheck_tag_all();
		}else{
			BrandSteps.check_tag_all();
			BrandSteps.uncheck_tag_all();
		}
		for (int row : SessionData.getDataTbRowsByValEqualInCol("COMPANYTABLE", "Inventory Brand Code", brandCode)
				.keySet()) {
			String sInventoryBrandCode = SessionData.getDataTbVal("COMPANYTABLE", row, "Inventory Brand Code");
			String sCompanyName = SessionData.getDataTbVal("COMPANYTABLE", row, "Company Name");
			String sTag = SessionData.getDataTbVal("COMPANYTABLE", row, "Tag");
			
			
			
			if (!sInventoryBrandCode.isEmpty()) {
			}
			BrandSteps.is_checked_tag();
			
			if (!sCompanyName.isEmpty()) {
				BrandSteps.enter_company_name(sCompanyName);
			}
			if (!sTag.isEmpty()) {
				if (BrandSteps.is_checked_tag()) {

				} else {
					BrandSteps.check_tag();
				}
			} else {
				if (!BrandSteps.is_checked_tag()) {

				} else {
					BrandSteps.uncheck_tag();
				}

			}
		}

	}

	@And("^The \"([^\"]*)\" should be updated as the above infomation$")
	public void the_should_be_updated_as_the_above_infomation(String arg1) throws Throwable {
		BrandSteps.click_btn_update();
		BrandSteps.click_btn_confirm_yes();
		BrandSteps.click_btn_status_popup();
	}

	@Then("^I search the \"([^\"]*)\", it should be founded as the following$")
	public void i_search_the_again_it_should_be_founded_as_the_following(String brandCode,
			List<List<String>> searchResult) throws Throwable {
		SessionData.addDataTable("SEARCHRESULT", searchResult,false);
		BrandSteps.click_btn_search();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SEARCHRESULT", "Inventory Brand Code", brandCode)
				.keySet()) {
			String sBrandCode = SessionData.getDataTbVal("SEARCHRESULT", row, "Inventory Brand Code");
			String sInventoryBrandDesc = SessionData.getDataTbVal("SEARCHRESULT", row, "Inventory Brand Desc");

			if (!sBrandCode.isEmpty()) {
				BrandSteps.enter_brand_code_search(sBrandCode);
			}
			if (!sInventoryBrandDesc.isEmpty()) {

			}
			BrandSteps.click_btn_brand_code_search();
			BrandSteps.click_on_brand_code_link();

		}
	}

	@When("^I want to update a Inventory Brand$")
	public void i_want_to_update_a_Inventory_Brand() throws Throwable {

	}

	@When("^I want to delete a Inventory Brand$")
	public void i_want_to_delete_a_inventory_brand() throws Throwable {

	}

	@And("^I confirm and delete this brand code certainty$")
	public void i_confirm_and_delete_this_brand_code_certainty() throws Throwable {
		BrandSteps.click_btn_delete();
		BrandSteps.click_btn_confirm_yes();
		BrandSteps.click_btn_status_popup();
	}

}
