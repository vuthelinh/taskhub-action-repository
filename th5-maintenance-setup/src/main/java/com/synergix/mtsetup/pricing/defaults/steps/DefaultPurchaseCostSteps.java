package com.synergix.mtsetup.pricing.defaults.steps;

import com.synergix.mtsetup.pricing.defaults.pages.DefaultPurchaseCostPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160812
 */
public class DefaultPurchaseCostSteps extends ScenarioSteps {

	DefaultPurchaseCostPage defaultPurchaseCostPage;

	@Step
	public void click_btn_close() {
		defaultPurchaseCostPage.click_btn_close();
	}

	@Step
	public void click_btn_update() {
		defaultPurchaseCostPage.click_btn_update();
	}

	// Inventory Pricing
	@Step
	public void enter_inventory_pricing_default_cost_new_priority(String _description, String _newPriority) {
		defaultPurchaseCostPage.enter_inventory_pricing_default_cost_new_priority(_description, _newPriority);
	}

	@Step
	public String get_inventory_pricing_default_cost_priority(String _description) {
		return defaultPurchaseCostPage.get_inventory_pricing_default_cost_priority(_description);
	}

	@Step
	public void enter_inventory_pricing_default_supplier_info_to_or_ccf_new_priority(String _description,
			String _newPriority) {
		defaultPurchaseCostPage.enter_inventory_pricing_default_supplier_info_to_or_ccf_new_priority(_description,
				_newPriority);
	}

	@Step
	public String get_inventory_pricing_default_supplier_info_to_or_ccf_priority(String _description) {
		return defaultPurchaseCostPage.get_inventory_pricing_default_supplier_info_to_or_ccf_priority(_description);
	}

	// Service Pricing
	@Step
	public void enter_service_pricing_default_cost_new_priority(String _description, String _newPriority) {
		defaultPurchaseCostPage.enter_service_pricing_default_cost_new_priority(_description, _newPriority);
	}

	@Step
	public String get_service_pricing_default_cost_priority(String _description) {
		return defaultPurchaseCostPage.get_service_pricing_default_cost_priority(_description);
	}

	@Step
	public void enter_service_pricing_default_supplier_info_to_or_ccf_new_priority(String _description,
			String _newPriority) {
		defaultPurchaseCostPage.enter_service_pricing_default_supplier_info_to_or_ccf_new_priority(_description,
				_newPriority);
	}

	@Step
	public String get_service_pricing_default_supplier_info_to_or_ccf_priority(String _description) {
		return defaultPurchaseCostPage.get_service_pricing_default_supplier_info_to_or_ccf_priority(_description);
	}

}
