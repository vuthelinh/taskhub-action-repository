package com.synergix.globalsetup.inventory.classification.steps;

import com.synergix.globalsetup.inventory.classification.pages.BrandPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BrandSteps extends ScenarioSteps {

	BrandPage BrandPage;

	/* START- ĐỊNH NGHĨA CÁC BUTTON */
	public void click_btn_close() {
		BrandPage.click_btn_close();
	}

	@Step
	public void click_btn_new() {
		BrandPage.click_btn_new();
	}

	@Step
	public void click_btn_delete() {
		BrandPage.click_btn_delete();
	}

	@Step
	public void click_btn_search() {
		BrandPage.click_btn_search();
	}

	@Step
	public void click_btn_update() {
		BrandPage.click_btn_update();
	}

	//
	@Step
	public void enter_inventory_brand_code(String _inventoryBrandCode) {
		BrandPage.enter_inventory_brand_code(_inventoryBrandCode);
	}

	@Step
	public void click_txt_inventory_brand_code() {
		BrandPage.click_txt_inventory_brand_code();
	}

	@Step
	public void enter_inventory_brand_description(String _description) {
		BrandPage.enter_description(_description);
	}

	@Step

	public boolean is_readonly_inventory_brand_code() {
		return BrandPage.is_readonly_inventory_brand_code();

	}

	// Button inside TAB
	@Step
	public void click_btn_service_level_add() {
		BrandPage.click_btn_service_level_add();
	}

	@Step
	public void click_btn_service_level_delete() {
		BrandPage.click_btn_service_level_delete();
	}

	@Step
	public void click_btn_eoq_add() {
		BrandPage.click_btn_eoq_add();
	}

	@Step
	public void click_btn_eoq_delete() {
		BrandPage.click_btn_eoq_delete();
	}

	@Step
	public void click_btn_supplier_add() {
		BrandPage.click_btn_supplier_add();
	}

	@Step
	public void click_btn_supplier_delete() {
		BrandPage.click_btn_supplier_delete();
	}

	// swich tab
	@Step
	public void switch_tab_forecast() {
		BrandPage.switch_tab_forecast();
	}

	@Step
	public void switch_tab_service_level() {
		BrandPage.switch_tab_service_level();
	}

	@Step
	public void switch_tab_eoq_calculation() {
		BrandPage.switch_tab_eoq_calculation();
	}

	@Step
	public void switch_tab_supplier() {
		BrandPage.switch_tab_supplier();
	}

	@Step
	public void switch_tab_company() {
		BrandPage.switch_tab_company();
	}

	// Tab: Forecast
	@Step
	public void enter_target_month_supply_qty(String _targetMonthSupplyQty) {
		BrandPage.enter_target_month_supply_qty(_targetMonthSupplyQty);
	}

	@Step
	public void enter_target_value(String _targetValue) {
		BrandPage.enter_target_value(_targetValue);
	}

	// Tab: Service level
	@Step
	public void enter_service_level_code(String _serviceLevelCode) {
		BrandPage.enter_service_level_code(_serviceLevelCode);

	}

	@Step
	public void enter_service_level_description(String _serviceLevelDescription) {

		BrandPage.enter_service_level_description(_serviceLevelDescription);
	}

	@Step
	public void enter_service_level_value(String _serviceLevelValue) {

		BrandPage.enter_service_level_value(_serviceLevelValue);
	}

	@Step
	public void enter_z_value(String _zValue) {

		BrandPage.enter_z_value(_zValue);
	}

	@Step
	public void check_service_level_del() {

		BrandPage.check_service_level_del();
	}

	@Step
	public void uncheck_service_level_del() {

		BrandPage.uncheck_service_level_del();
	}

	// TAB: EOQ Calculation
	@Step
	public void enter_eoq_code(String _eoqCode) {
		BrandPage.enter_eoq_code(_eoqCode);
	}

	@Step
	public void enter_eoq_description(String _eoqDescription) {
		BrandPage.enter_eoq_description(_eoqDescription);
	}

	@Step
	public void enter_eoq_value(String _eoqValue) {
		BrandPage.enter_eoq_value(_eoqValue);
	}

	@Step
	public void check_eoq_del() {
		BrandPage.check_eoq_del();
	}

	@Step
	public void uncheck_eoq_del() {
		BrandPage.uncheck_eoq_del();
	}

	@Step
	// TAB: Supplier
	public void enter_supplier_code(String _supplierCode) {
		BrandPage.enter_supplier_code(_supplierCode);

	}

	@Step
	public void enter_min_order_qty(String _minOrderQty) {
		BrandPage.enter_min_order_qty(_minOrderQty);
	}

	@Step
	public void click_on_lead_time() {
		BrandPage.click_on_lead_time();

	}

	@Step
	public void select_supplier_default() {
		BrandPage.select_supplier_default();
	}

	@Step
	public void check_supplier_del() {
		BrandPage.check_supplier_del();
	}

	@Step
	public void uncheck_supplier_del() {
		BrandPage.uncheck_supplier_del();
	}

	@Step
	public void click_btn_leadtime_add() {
		BrandPage.click_btn_leadtime_add();

	}

	@Step
	public void click_btn_leadtime_delete() {
		BrandPage.click_btn_leadtime_delete();

	}

	@Step
	public void click_btn_leadtime_done() {
		BrandPage.click_btn_leadtime_done();

	}

	@Step
	public void enter_leadtime_code(String _leadtimeCode) {
		BrandPage.enter_leadtime_code(_leadtimeCode);

	}

	@Step
	public void enter_leadtime_desc(String _leadtimeDesc) {
		BrandPage.enter_leadtime_desc(_leadtimeDesc);

	}

	@Step
	public void enter_leadtime_value(String _leadtimevalue) {
		BrandPage.enter_leadtime_value(_leadtimevalue);

	}

	@Step
	public void check_leadtime_del() {
		check_leadtime_del();
	}

	@Step
	public void uncheck_leadtime_del() {
		uncheck_leadtime_del();
	}

	// TAB: COMPANY
	@Step
	public void enter_company_name(String _companyName) {
		BrandPage.enter_company_name(_companyName);
	}

	@Step
	public void check_tag() {
		BrandPage.check_tag();
	}

	@Step
	public void uncheck_tag() {
		BrandPage.uncheck_tag();
	}

	public boolean is_checked_tag() {
		return BrandPage.is_checked_tag();
	}

	@Step
	public void check_tag_all() {
		BrandPage.check_tag_all();
	}

	@Step
	public void uncheck_tag_all() {
		BrandPage.uncheck_tag_all();
	}

	@Step
	public boolean is_checked_tag_all() {
		return BrandPage.is_checked_tag_all();
	}

	// search form
	@Step
	public void enter_brand_code_search(String brandCodeSearch) {
		BrandPage.enter_brand_code_search(brandCodeSearch);
	}

	@Step
	public void click_on_brand_code_link() {
		BrandPage.click_on_brand_code_link();

	}

	@Step
	public String get_text_brand_code_link() {
		return BrandPage.get_text_brand_code_link();
	}

	@Step
	public void click_btn_brand_code_search() {
		BrandPage.click_btn_brand_code_search();
	}

	// Other
	@Step
	public void click_btn_confirm_yes() {
		BrandPage.click_btn_confirm_yes();
	}

	@Step
	public void click_btn_status_popup() {

		BrandPage.click_btn_status_popup();
	}

	@Step
	public int count_table_row_service_level() {
		return BrandPage.count_table_row_service_level();

	}

	@Step
	public int count_table_row_eoq_calculation() {
		return BrandPage.count_table_row_eoq_calculation();

	}

	@Step
	public int count_table_row_supplier() {
		return BrandPage.count_table_row_supplier();

	}

	@Step
	public void find_and_check_checkbox_service_level(int i) {
		BrandPage.find_and_check_checkbox_service_level(i);

	}

	@Step
	public void find_and_check_checkbox_eoq_calculation(int i) {
		BrandPage.find_and_check_checkbox_eoq_calculation(i);

	}

	@Step
	public void find_and_check_checkbox_supplier(int i) {
		BrandPage.find_and_check_checkbox_supplier(i);

	}

	@Step
	public String get_text_inventory_brand_code() {
		return BrandPage.get_text_inventory_brand_code();
	}

	@Step
	public String get_text_target_month_supply_qty(String targetMonthSupplyQty) {
		return BrandPage.get_text_target_month_supply_qty();
	}

	@Step
	public String get_text_target_value(String targetValue) {
		return BrandPage.get_text_target_value();
	}

	@Step
	public String get_text_target_month_supply_qty() {
		return BrandPage.get_text_target_month_supply_qty();
	}

	@Step
	public String get_text_target_value() {
		return BrandPage.get_text_target_value();
	}

	@Step
	public String get_text_service_level_code() {
		return BrandPage.get_text_service_level_code();
	}

	@Step
	public String get_text_service_level_description() {
		return BrandPage.get_text_service_level_description();
	}

	@Step
	public String get_text_service_level_value() {
		return BrandPage.get_text_service_level_value();
	}

	@Step
	public String get_text_z_value() {
		return BrandPage.get_text_z_value();
	}

	@Step
	public String get_text_eoq_code() {
		return BrandPage.get_text_eoq_code();
	}

	@Step
	public String get_text_eoq_description() {
		return BrandPage.get_text_eoq_description();
	}

	@Step
	public String get_text_eoq_value() {
		return BrandPage.get_text_eoq_value();
	}

	@Step
	public String get_text_supplier_code() {
		return BrandPage.get_text_supplier_code();
	}

	@Step
	public String get_text_min_order_qty() {
		return BrandPage.get_text_min_order_qty();
	}

	@Step
	public String get_text_company_name() {
		return BrandPage.get_text_company_name();
	}

	@Step
	public void create_new_brand(String inventoryBrandCode, String description) {

		BrandPage.switchToIFrame("th5frame");
		click_btn_search();
		
		if (!BrandPage.search_result(inventoryBrandCode)) {
			BrandPage.click_on_brand_code_link();
			BrandPage.click_btn_new();
			BrandPage.waitForAllJSCompletes();
			BrandPage.enter_inventory_brand_code(inventoryBrandCode);
			BrandPage.waitForAllJSCompletes();
			BrandPage.enter_description(description);
			BrandPage.waitForAllJSCompletes();
			BrandPage.click_btn_update();
			BrandPage.waitForAllJSCompletes();
			BrandPage.clickBtnYesOnConfirmUpdate();
			BrandPage.waitForAllJSCompletes();
			BrandPage.click_btn_status_popup();
		}

		BrandPage.switchOutDefaultIFrame();
	}
}
