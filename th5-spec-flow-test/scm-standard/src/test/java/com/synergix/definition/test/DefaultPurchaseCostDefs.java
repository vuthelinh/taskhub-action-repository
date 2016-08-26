package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.mtsetup.pricing.defaults.steps.DefaultPurchaseCostSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * @author Vincent
 * @version 20160329
 */
public class DefaultPurchaseCostDefs {
	@Steps
	DefaultPurchaseCostSteps defaultPurchaseCostSteps;

	@Then("^user input data in Inventory Pricing of Default Purchase Cost as \"([^\"]*)\"$")
	public void user_input_data_in_Inventory_Pricing_of_Default_Purchase_Cost(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		boolean isUpdate = false;
		SessionData.addDataTable("MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", "KEY",
				dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", row, "KEY");
			String sDescription = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", row,
					"Description");
			String sDefaultCostPriority = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", row,
					"Default Cost Priority");
			String sDefaultCostNewPriority = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", row,
					"Default Cost New Priority");
			String sDefaultSupplierInfoToPrCcfPriority = SessionData.getDataTbVal(
					"MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", row, "Default Supplier Info to PR CCF Priority");
			String sDefaultSupplierInfoToPrCcfNewPriority = SessionData.getDataTbVal(
					"MT_PRICING_DEFAULT_PURCHASE_COST_INVENTORY", row, "Default Supplier Info to PR CCF New Priority");
			if (!sKey.isEmpty() && !sDescription.isEmpty()) {
				if (!sDefaultCostPriority.isEmpty()) {
					assertThat(defaultPurchaseCostSteps.get_inventory_pricing_default_cost_priority(sDescription)
							.equals(sDefaultCostPriority)).isTrue();
				}
				if (!sDefaultCostNewPriority.isEmpty()) {
					defaultPurchaseCostSteps.enter_inventory_pricing_default_cost_new_priority(sDescription,
							sDefaultCostNewPriority);
				}
				if (!sDefaultSupplierInfoToPrCcfPriority.isEmpty()) {
					assertThat(defaultPurchaseCostSteps
							.get_inventory_pricing_default_supplier_info_to_or_ccf_priority(sDescription)
							.equals(sDefaultSupplierInfoToPrCcfPriority)).isTrue();
				}
				if (!sDefaultSupplierInfoToPrCcfNewPriority.isEmpty()) {
					defaultPurchaseCostSteps.enter_inventory_pricing_default_supplier_info_to_or_ccf_new_priority(
							sDescription, sDefaultSupplierInfoToPrCcfNewPriority);
				}
			} else {
				continue;
			}
			isUpdate = true;
		}
		if (isUpdate) {
			defaultPurchaseCostSteps.click_btn_update();
		}
	}

	@Then("^user input data in Service Pricing of Default Purchase Cost as \"([^\"]*)\"$")
	public void user_input_data_in_Service_Pricing_of_Default_Purchase_Cost(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		boolean isUpdate = false;
		testData = SessionData.getDataTbRowsByValEqualInCol("MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", row, "KEY");
			String sDescription = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", row,
					"Description");
			String sDefaultCostPriority = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", row,
					"Default Cost Priority");
			String sDefaultCostNewPriority = SessionData.getDataTbVal("MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", row,
					"Default Cost New Priority");
			String sDefaultSupplierInfoToPrCcfPriority = SessionData.getDataTbVal(
					"MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", row, "Default Supplier Info to PR CCF Priority");
			String sDefaultSupplierInfoToPrCcfNewPriority = SessionData.getDataTbVal(
					"MT_PRICING_DEFAULT_PURCHASE_COST_SERVICE", row, "Default Supplier Info to PR CCF New Priority");
			if (!sKey.isEmpty() && !sDescription.isEmpty()) {
				if (!sDefaultCostPriority.isEmpty()) {
					assertThat(defaultPurchaseCostSteps.get_service_pricing_default_cost_priority(sDescription)
							.equals(sDefaultCostPriority)).isTrue();
				}
				if (!sDefaultCostNewPriority.isEmpty()) {
					defaultPurchaseCostSteps.enter_service_pricing_default_cost_new_priority(sDescription,
							sDefaultCostNewPriority);
				}
				if (!sDefaultSupplierInfoToPrCcfPriority.isEmpty()) {
					assertThat(defaultPurchaseCostSteps
							.get_service_pricing_default_supplier_info_to_or_ccf_priority(sDescription)
							.equals(sDefaultSupplierInfoToPrCcfPriority)).isTrue();
				}
				if (!sDefaultSupplierInfoToPrCcfNewPriority.isEmpty()) {
					defaultPurchaseCostSteps.enter_service_pricing_default_supplier_info_to_or_ccf_new_priority(
							sDescription, sDefaultSupplierInfoToPrCcfNewPriority);
				}
			} else {
				continue;
			}
			isUpdate = true;
		}
		if (isUpdate) {
			defaultPurchaseCostSteps.click_btn_update();
		}
	}
}
