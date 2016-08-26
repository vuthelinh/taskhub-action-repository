package com.synergix.globalsetup.inventory.steps;

import com.synergix.globalsetup.inventory.page.InventoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class InventorySteps extends ScenarioSteps {
	InventoryPage inventoryPage;

	public void switchToIFrame() {
		inventoryPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		inventoryPage.switchOutDefaultIFrame();
	}

	// BEGIN Switch tab
	@Step
	public void click_btn_New_of_summary() {
		inventoryPage.click_btn_new_of_summary();
	}

	@Step
	public void test(String text) {
		System.out.println(text);
	}

	@Step
	public void click_btn_New_of_global_inv() {
		inventoryPage.click_btn_new_of_global_inv();
	}

	@Step
	public void switch_to_tab_general() {
		inventoryPage.switch_to_tab_general();
	}

	@Step
	public void switch_to_tab_specification() {
		inventoryPage.switch_to_tab_specification();
	}

	@Step
	public void switch_to_tab_healthcare() {
		inventoryPage.switch_to_tab_healthcare();
	}

	@Step
	public void switch_to_tab_pack_size() {
		inventoryPage.switch_to_tab_pack_size();
	}

	@Step
	public void switch_to_tab_supplier() {
		inventoryPage.switch_to_tab_supplier();
	}

	@Step
	public void switch_to_tab_content() {
		inventoryPage.switch_to_tab_content();
	}

	@Step
	public void switch_to_tab_attachments() {
		inventoryPage.switch_to_tab_attachments();
	}

	@Step
	public void switch_to_tab_company() {
		inventoryPage.switch_to_tab_company();
	}

	@Step
	public void switch_to_tab_local_info() {
		inventoryPage.switch_to_tab_local_info();
	}

	@Step
	public void switch_to_tab_locinfo_general() {
		inventoryPage.switch_to_tab_locinfo_general();
	}

	@Step
	public void switch_to_tab_locinfo_specification() {
		inventoryPage.switch_to_tab_locinfo_specification();
	}

	@Step
	public void switch_to_tab_locinfo_location() {
		inventoryPage.switch_to_tab_locinfo_location();
	}

	@Step
	public void switch_to_tab_locinfo_drawing() {
		inventoryPage.switch_to_tab_locinfo_drawing();
	}

	@Step
	public void switch_to_tab_locinfo_customer() {
		inventoryPage.switch_to_tab_locinfo_customer();
	}

	@Step
	public void switch_to_tab_locinfo_customer_doc() {
		inventoryPage.switch_to_tab_locinfo_customer_doc();
	}

	@Step
	public void switch_to_tab_locinfo_list_price_by_type() {
		inventoryPage.switch_to_tab_locinfo_list_price_by_type();
	}

	// END Switch tab
	// General
	@Step
	public String enter_inventory_code(String _inventoryCode) {
		inventoryPage.click_add_new_button_on_functional_panel();
		String ret = inventoryPage.enter_inventory_code(_inventoryCode);
		if (!ret.isEmpty()) {
			ret = inventoryPage.getErrorMessagesThenClickOK();
		}
		return ret;
	}

	@Step
	public boolean search_inventory_code(String _supplierRankCode) {
		return inventoryPage.search_inventory_code(_supplierRankCode);
	}

	@Step
	public void enter_description(String _description) {
		inventoryPage.enter_description(_description);
	}

	@Step
	public void enter_copy_from_inv(String _copyFromInventory) {
		inventoryPage.enter_copy_from_inv(_copyFromInventory);
	}

	@Step
	public void enter_short_description(String _shortDescription) {
		inventoryPage.enter_short_description(_shortDescription);
	}

	@Step
	public void enter_detailed_description(String _detailedDescription) {
		inventoryPage.enter_detailed_description(_detailedDescription);
	}

	@Step
	public void enter_base_uom(String _baseUom) {
		inventoryPage.enter_base_uom(_baseUom);
	}

	@Step
	public void enter_inventory_class(String _inventoryClass) {
		inventoryPage.enter_inventory_class(_inventoryClass);
	}

	@Step
	public void enter_inventory_category(String _inventoryCategory) {
		inventoryPage.enter_inventory_category(_inventoryCategory);
	}

	@Step
	public void enter_budget_category_code(String _budgetCategoryCode) {
		inventoryPage.enter_budget_category_code(_budgetCategoryCode);
	}

	@Step
	public void enter_inventory_brand(String _inventoryBrand) {
		inventoryPage.enter_inventory_brand(_inventoryBrand);
	}

	@Step
	public void enter_series_1(String _series1) {
		inventoryPage.enter_series_1(_series1);
	}

	@Step
	public void enter_series_2(String _series2) {
		inventoryPage.enter_series_2(_series2);
	}

	@Step
	public void enter_series_3(String _series3) {
		inventoryPage.enter_series_3(_series3);
	}

	@Step
	public void enter_series_4(String _series4) {
		inventoryPage.enter_series_4(_series4);
	}

	@Step
	public void enter_report_grouping_code(String _reportGroupingCode) {
		inventoryPage.enter_report_grouping_code(_reportGroupingCode);
	}

	@Step
	public void enter_country_of_origin(String _countryOfOrigin) {
		inventoryPage.enter_country_of_origin(_countryOfOrigin);
	}

	@Step
	public void enter_receipt_minimum_shelf_life(String _receiptMinimumShelfLife) {
		inventoryPage.enter_receipt_minimum_shelf_life(_receiptMinimumShelfLife);
	}

	@Step
	public void enter_issue_minimum_expiry(String _issueMinimumExpiry) {
		inventoryPage.enter_issue_minimum_expiry(_issueMinimumExpiry);
	}

	@Step
	public void select_option_auto_break_pack_to_base_uom(String _radioBtnLabel) {
		inventoryPage.select_option_auto_break_pack_to_base_uom(_radioBtnLabel);
	}

	@Step
	public void select_option_inventory_type(String _radioBtnLabel) {
		inventoryPage.select_option_inventory_type(_radioBtnLabel);
	}

	@Step
	public void select_option_lot_no_tracking(String _radioBtnLabel) {
		inventoryPage.select_option_lot_no_tracking(_radioBtnLabel);
	}

	@Step
	public void select_option_serial_no_tracking(String _radioBtnLabel) {
		inventoryPage.select_option_serial_no_tracking(_radioBtnLabel);
	}

	@Step
	public void select_option_warranty_tracking(String _radioBtnLabel) {
		inventoryPage.select_option_warranty_tracking(_radioBtnLabel);
	}

	@Step
	public void select_option_exchange_of_expired_lot(String _exchangeOfExpiredLot) {
		inventoryPage.select_option_exchange_of_expired_lot(_exchangeOfExpiredLot);
	}

	@Step
	public void enter_exchange_allowable_within(String _exchangeAllowableWithin) {
		inventoryPage.enter_exchange_allowable_within(_exchangeAllowableWithin);
	}

	@Step
	public void update() {
		inventoryPage.click_btn_update();
	}

	@Step
	public void tag_company_name(String _companyName) {
		inventoryPage.chooseCompany(_companyName);
	}

	// Specification
	@Step
	public void enter_length_inch(String _lengthInch) {
		inventoryPage.enter_length_inch(_lengthInch);
	}

	@Step
	public void enter_breadth_inch(String _breadthInch) {
		inventoryPage.enter_breadth_inch(_breadthInch);
	}

	@Step
	public void enter_height_inch(String _heightInch) {
		inventoryPage.enter_height_inch(_heightInch);
	}

	@Step
	public void enter_length_mm(String _lengthMm) {
		inventoryPage.enter_length_mm(_lengthMm);
	}

	@Step
	public void enter_breadth_mm(String _breadthMm) {
		inventoryPage.enter_breadth_mm(_breadthMm);
	}

	@Step
	public void enter_height_mm(String _heightMm) {
		inventoryPage.enter_height_mm(_heightMm);
	}

	@Step
	public void enter_volume(String _volume) {
		inventoryPage.enter_volume(_volume);
	}

	@Step
	public void enter_outer_diameter_inch(String _outerDiameterInch) {
		inventoryPage.enter_outer_diameter_inch(_outerDiameterInch);
	}

	@Step
	public void enter_inner_diameter_inch(String _innerDiameterInch) {
		inventoryPage.enter_inner_diameter_inch(_innerDiameterInch);
	}

	@Step
	public void enter_outer_length_inch(String _outerLengthInch) {
		inventoryPage.enter_outer_length_inch(_outerLengthInch);
	}

	@Step
	public void enter_outer_diameter_mm(String _outerDiameterMm) {
		inventoryPage.enter_outer_diameter_mm(_outerDiameterMm);
	}

	@Step
	public void enter_inner_diameter_mm(String _innerDiameterMm) {
		inventoryPage.enter_inner_diameter_mm(_innerDiameterMm);
	}

	@Step
	public void enter_outer_length_mm(String _outerLengthMm) {
		inventoryPage.enter_outer_length_mm(_outerLengthMm);
	}

	@Step
	public void enter_gross_weight(String _grossWeight) {
		inventoryPage.enter_gross_weight(_grossWeight);
	}

	@Step
	public void enter_nett_weight(String _nettWeight) {
		inventoryPage.enter_nett_weight(_nettWeight);
	}

	@Step
	public void enter_weight_uom(String _weightUom) {
		inventoryPage.enter_weight_uom(_weightUom);
	}

	@Step
	public void enter_density(String _density) {
		inventoryPage.enter_density(_density);
	}

	@Step
	public void enter_measure_type(String _measureType) {
		inventoryPage.enter_measure_type(_measureType);
	}

	// Healthcare
	@Step
	public void click_btn_add_drug_detail() {
		inventoryPage.click_btn_add_drug_detail();
	}

	@Step
	public void click_btn_add_drug_use() {
		inventoryPage.click_btn_add_drug_use();
	}

	@Step
	public void click_btn_add_drug_add_info() {
		inventoryPage.click_btn_add_drug_add_info();
	}

	@Step
	public void enter_drug_name(String _drugName) {
		inventoryPage.enter_drug_name(_drugName);
	}

	@Step
	public void enter_trade_name(String _tradeName) {
		inventoryPage.enter_trade_name(_tradeName);
	}

	@Step
	public void enter_strength(String _strength) {
		inventoryPage.enter_strength(_strength);
	}

	@Step
	public void enter_route(String _route) {
		inventoryPage.enter_route(_route);
	}

	@Step
	public void select_option_controlled_drug_moh_reporting_req(String _controlledDrugMohReportingReq) {
		inventoryPage.select_option_controlled_drug_moh_reporting_req(_controlledDrugMohReportingReq);
	}

	@Step
	public void select_option_generate_product_label(String _generateProductLabel) {
		inventoryPage.select_option_generate_product_label(_generateProductLabel);
	}

	@Step
	public void enter_prescription_desc(String _prescriptionDesc) {
		inventoryPage.enter_prescription_desc(_prescriptionDesc);
	}

	@Step
	public void enter_qty(String _qty) {
		inventoryPage.enter_qty(_qty);
	}

	@Step
	public void enter_uom(String _uom) {
		inventoryPage.enter_uom(_uom);
	}

	@Step
	public void enter_frequency(String _frequency) {
		inventoryPage.enter_frequency(_frequency);
	}

	@Step
	public void enter_frequency_desc(String _frequencyDesc) {
		inventoryPage.enter_frequency_desc(_frequencyDesc);
	}

	@Step
	public void enter_duration(String _duration) {
		inventoryPage.enter_duration(_duration);
	}

	@Step
	public void enter_new_drug_use_code(String _drugUseCode) {
		inventoryPage.enter_new_drug_use_code(_drugUseCode);
	}

	@Step
	public void enter_new_drug_add_info(String _drugAddInfo) {
		inventoryPage.enter_new_drug_add_info(_drugAddInfo);
	}

	// PackSize
	@Step
	public void click_btn_add_pack_size_cd() {
		inventoryPage.click_btn_add_pack_size_cd();
	}

	@Step
	public void set_chkbox_enable_base_uom_in_Mobile_Pre_Sales(String _value) {
		inventoryPage.set_chkbox_enable_base_uom_in_Mobile_Pre_Sales(_value);
	}

	@Step
	public void enter_new_pack_size_code(String _packSizeCode) {
		inventoryPage.enter_new_pack_size_code(_packSizeCode);
	}

	@Step
	public void enter_new_pack_size_cd_description(String _description) {
		inventoryPage.enter_new_pack_size_cd_description(_description);
	}

	@Step
	public void select_new_convert_from_pack_size(String _convertFromPackSize) {
		inventoryPage.select_new_convert_from_pack_size(_convertFromPackSize);
	}

	@Step
	public void enter_new_qty_in_other_pack_size(String _qtyInOtherPackSize) {
		inventoryPage.enter_new_qty_in_other_pack_size(_qtyInOtherPackSize);
	}

	@Step
	public void enter_new_qty_in_base_uom(String _qtyInBaseUom) {
		inventoryPage.enter_new_qty_in_base_uom(_qtyInBaseUom);
	}

	@Step
	public void set_enable_in_mobile_pre_sales(String _value) {
		inventoryPage.set_enable_in_mobile_pre_sales(_value);
	}

	// Supplier
	@Step
	public void click_btn_add_supplier() {
		inventoryPage.click_btn_add_supplier();
	}

	@Step
	public void enter_new_supplier(String _supplier) {
		inventoryPage.enter_new_supplier(_supplier);
	}

	@Step
	public void enter_new_party_inventory_code(String _partyInventoryCode) {
		inventoryPage.enter_new_party_inventory_code(_partyInventoryCode);
	}

	@Step
	public void enter_new_default_description(String _defaultDescription) {
		inventoryPage.enter_new_default_description(_defaultDescription);
	}

	@Step
	public void enter_new_billing_description(String _billingDescription) {
		inventoryPage.enter_new_billing_description(_billingDescription);
	}

	@Step
	public void enter_new_remarks(String _remarks) {
		inventoryPage.enter_new_remarks(_remarks);
	}

	@Step
	public void enter_new_min_order_qty(String _minOrderQty) {
		inventoryPage.enter_new_min_order_qty(_minOrderQty);
	}

	@Step
	public void enter_new_lead_time_in_days(String _leadTimeInDays) {
		inventoryPage.enter_new_lead_time_in_days(_leadTimeInDays);
	}

	@Step
	public void enter_new_std_pack_size(String _stdPackSize) {
		inventoryPage.enter_new_std_pack_size(_stdPackSize);
	}

	@Step
	public void enter_new_home_unit_cost(String _homeUnitCost) {
		inventoryPage.enter_new_home_unit_cost(_homeUnitCost);
	}

	@Step
	public void set_default_supplier(String _value) {
		inventoryPage.set_default_supplier(_value);
	}

	// Content
	@Step
	public void click_btn_add_new_content() {
		inventoryPage.click_btn_add_new_content();
	}

	@Step
	public void enter_new_content_code(String _contentCode) {
		inventoryPage.enter_new_content_code(_contentCode);
	}

	@Step
	public void verify_new_content_description(String _description) {
		inventoryPage.verify_new_content_description(_description);
	}

	@Step
	public void enter_content_new_default_percentage(String _defaultPercentage) {
		inventoryPage.enter_content_new_default_percentage(_defaultPercentage);
	}

	@Step
	public void enter_content_new_default_recovery_rate(String _defaultRecoveryRate) {
		inventoryPage.enter_content_new_default_recovery_rate(_defaultRecoveryRate);
	}

	// Attachment
	@Step
	public void click_btn_add_new_attachment() {
		inventoryPage.click_btn_add_new_attachment();
	}

	@Step
	public void choose_attachment_file(String _filePath) {
		inventoryPage.choose_attachment_file(_filePath);
	}

	@Step
	public void click_btn_upload_attachment() {
		inventoryPage.click_btn_upload_attachment();
	}

	@Step
	public void enter_new_file_description(String _fileDescription) {
		inventoryPage.enter_new_file_description(_fileDescription);
	}

	// Local Info
	@Step
	public void enter_home_base_cost(String _homeBaseCost) {
		inventoryPage.enter_home_base_cost(_homeBaseCost);
	}

	@Step
	public void enter_procurement_lead_time(String _procurementLeadTime) {
		inventoryPage.enter_procurement_lead_time(_procurementLeadTime);
	}

	@Step
	public void select_option_allow_issue_more_than_alloc_qty(String _allowIssueMoreThanAllocQty) {
		inventoryPage.select_option_allow_issue_more_than_alloc_qty(_allowIssueMoreThanAllocQty);
	}

	@Step
	public void verify_inventory_category_loc_info(String _inventoryCategory) {
		// TODOLATER
	}

	@Step
	public void enter_inventory_model(String _inventoryModel) {
		inventoryPage.enter_inventory_model(_inventoryModel);
	}

	// Location information
	@Step
	public void click_btn_add_location_information() {
		inventoryPage.click_btn_add_location_information();
	}

	@Step
	public void enter_new_location_code(String _locationCode) {
		inventoryPage.enter_new_location_code(_locationCode);
	}

	@Step
	/**
	 * Created by Steve on 15/08/2016
	 * Check if location code is added or not
	 * @param locationCode
	 * @return
	 */
	public boolean is_added_location_code(String locationCode) {
		return inventoryPage.is_added_location_code(locationCode);
	}

	@Step
	public void verify_location_name(String _locationName) {
		// TODOLATER
	}

	@Step
	public void enter_new_min_holding_qty(String _minHoldingQty) {
		inventoryPage.enter_new_min_holding_qty(_minHoldingQty);
	}

	@Step
	public void enter_new_max_holding_qty(String _maxHoldingQty) {
		inventoryPage.enter_new_max_holding_qty(_maxHoldingQty);
	}

	@Step
	public void enter_new_local_information_remarks(String _remarks) {
		inventoryPage.enter_new_local_information_remarks(_remarks);
	}

	// Bin information
	@Step
	public void click_btn_add_bin_information() {
		inventoryPage.click_btn_add_bin_information();
	}

	@Step
	public void enter_new_bin_row(String _row) {
		inventoryPage.enter_new_bin_row(_row);
	}

	@Step
	public void enter_new_bin_column(String _column) {
		inventoryPage.enter_new_bincolumn(_column);
	}

	@Step
	public void enter_new_bin_level(String _level) {
		inventoryPage.enter_new_binlevel(_level);
	}

	@Step
	public void enter_new_bin_description(String _description) {
		inventoryPage.enter_new_bin_description(_description);
	}

	// Customer Information
	@Step
	public void click_btn_add_cus_information() {
		inventoryPage.click_btn_add_cus_information();
	}

	@Step
	public void enter_moq_in_loose(String _moqInLoose) {
		inventoryPage.enter_moq_in_loose(_moqInLoose);
	}

	@Step
	public void enter_new_cus_customer(String _customer) {
		inventoryPage.enter_new_cus_customer(_customer);
	}

	@Step
	public void verify_new_cus_customer_name(String _customerName) {
		// TODOLATER
	}

	@Step
	public void enter_new_cus_party_inventory_code(String _partyInventoryCode) {
		inventoryPage.enter_new_cus_party_inventory_code(_partyInventoryCode);
	}

	@Step
	public void enter_new_cus_default_description(String _defaultDescription) {
		inventoryPage.enter_new_cus_default_description(_defaultDescription);
	}

	@Step
	public void enter_new_cus_billing_description(String _billingDescription) {
		inventoryPage.enter_new_cus_billing_description(_billingDescription);
	}

	@Step
	public void enter_new_cus_d_sales_(String _dSales) {
		inventoryPage.enter_new_cus_d_sales_(_dSales);
	}

	@Step
	public void enter_new_cus_o_sales(String _oSales) {
		inventoryPage.enter_new_cus_o_sales(_oSales);
	}

	@Step
	public void enter_new_cus_remarks(String _remarks) {
		inventoryPage.enter_new_cus_remarks(_remarks);
	}

	// Customer Doc
	@Step
	public void click_btn_add_document() {
		inventoryPage.click_btn_add_document();
	}

	@Step
	public void enter_doc_new_document_code(String _documentCode) {
		inventoryPage.enter_doc_new_document_code(_documentCode);
	}

	@Step
	public void verify_doc_new_description(String _description) {
		inventoryPage.verify_doc_new_description(_description);
	}

	@Step
	public void verify_doc_new_document_type(String _documentType) {
		inventoryPage.verify_doc_new_document_type(_documentType);
	}

	@Step
	public void verify_doc_new_current_revision(String _currentRevision) {
		inventoryPage.verify_doc_new_current_revision(_currentRevision);
	}

	@Step
	public void verify_doc_new_attachment(String _attachment) {
		inventoryPage.verify_doc_new_attachment(_attachment);
	}

	// List Price By Test
	@Step
	public void click_btn_add_list_price_by_type() {
		inventoryPage.click_btn_add_list_price_by_type();
	}

	@Step
	public void enter_lpbt_new_currency_code(String _currencyCode) {
		inventoryPage.enter_lpbt_new_currency_code(_currencyCode);
	}

	@Step
	public void enter_lpbt_new_list_price_type_code(String _listPriceTypeCode) {
		inventoryPage.enter_lpbt_new_list_price_type_code(_listPriceTypeCode);
	}

	@Step
	public void verify_lpbt_new_list_price_type_desc(String _listPriceTypeDesc) {
		inventoryPage.verify_lpbt_new_list_price_type_desc(_listPriceTypeDesc);
	}

	@Step
	public void enter_lpbt_new_list_price(String _listPrice) {
		inventoryPage.enter_lpbt_new_list_price(_listPrice);
	}

	@Step
	public void set_lpbt_new_is_default(String _isDefault) {
		inventoryPage.set_lpbt_new_is_default(_isDefault);
	}

	@Step
	public void set_lpbt_new_for_set_price_distribution(String _forSetPriceDistribution) {
		inventoryPage.set_lpbt_new_for_set_price_distribution(_forSetPriceDistribution);
	}

	@Step
	public void create_new_inventory_item(String inventoryCode, String description, String baseUOM,
			String inventoryClass, String inventoryBrand) {
		inventoryPage.switchToIFrame("th5frame");
		inventoryPage.click_btn_new_of_summary();

		if (!search_inventory_code(inventoryCode)) {
			inventoryPage.click_on_inventory_code_link();
			click_btn_New_of_global_inv();
			inventoryPage.waitForAllJSCompletes();

			enter_inventory_code(inventoryCode);
			inventoryPage.waitForAllJSCompletes();

			enter_description(description);
			enter_base_uom(baseUOM);
			inventoryPage.waitForAllJSCompletes();

			enter_inventory_class(inventoryClass);
			inventoryPage.waitForAllJSCompletes();

			enter_inventory_brand(inventoryBrand);
			inventoryPage.waitForAllJSCompletes();

			update();
		}
		
		
		
		
		
		inventoryPage.switchOutDefaultIFrame();

	}

	@Step
	public String isAlreadyExistsInDatabase(String sInventoryCode) {
		return inventoryPage.check_database_exist("MT_INVENTORY", "INVENTORY_CODE", sInventoryCode);
	}
}
