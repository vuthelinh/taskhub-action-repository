package com.synergix.processing.purchase.purchaseorder.steps;

import com.synergix.processing.purchase.purchaseorder.pages.PurchaseOrderVariationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160608
 */
public class PurchaseOrderVariationSteps extends ScenarioSteps {
	PurchaseOrderVariationPage purchaseOrderPage;

	// BEGIN Switch tab

	@Step
	public void switch_to_tab_header() {
		purchaseOrderPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_shipment() {
		purchaseOrderPage.switch_to_tab_shipment();
	}

	@Step
	public void switch_to_tab_detail() {
		purchaseOrderPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_payment_info() {
		purchaseOrderPage.switch_to_tab_payment_info();
	}

	@Step
	public void switch_to_tab_remarks() {
		purchaseOrderPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		purchaseOrderPage.switch_to_tab_attachments();
	}

	// END Switch tab

	// BEGIN Header
	@Step
	public void click_btn_preview_purchase_order_detail() {
		purchaseOrderPage.click_btn_preview_purchase_order_detail();
	}

	@Step
	public boolean switch_to_preview_report_window() {
		return purchaseOrderPage.switch_to_preview_report_window(10);
	}

	@Step
	public boolean verify_preview_report_content(String _givenContent) {
		return purchaseOrderPage.verify_preview_report_content(_givenContent);
	}

	@Step
	public String getCurrentWindowHandle() {
		return purchaseOrderPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return purchaseOrderPage.switchToWindowHandle(_handle);
	}

	@Step
	public String get_reports_title_list_then_done() {
		return purchaseOrderPage.get_reports_title_list_then_done();
	}

	@Step
	public String get_new_purchase_order_no() {
		return purchaseOrderPage.get_new_purchase_order_no();
	}

	@Step
	public String get_order_currency() {
		return purchaseOrderPage.get_order_currency();
	}

	@Step
	public String get_sales_tax() {
		return purchaseOrderPage.get_sales_tax();
	}

	@Step
	public String get_supplier_contact() {
		return purchaseOrderPage.get_supplier_contact();
	}

	@Step
	public String get_purchaser() {
		return purchaseOrderPage.get_purchaser();
	}

	@Step
	public void click_btn_new_purchase_order_detail() {
		purchaseOrderPage.click_btn_new_purchase_order_detail();
	}

	@Step
	public void purchase_order_no(String _purchaseOrderNo) {
		System.out.println("***** INFO ***** Purchase Order No: " + _purchaseOrderNo);
	}

	@Step
	public void click_btn_submit_purchase_order_detail() {
		purchaseOrderPage.click_btn_submit_purchase_order_detail();
	}

	@Step
	public void click_btn_back_to_summary() {
		purchaseOrderPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_abort() {
		purchaseOrderPage.click_btn_abort();
	}

	@Step
	public void enter_supplier(String _supplier) {
		purchaseOrderPage.enter_supplier(_supplier);
	}

	@Step
	public String get_supplier_name() {
		return purchaseOrderPage.get_supplier_name();
	}

	@Step
	public void select_option_copy_from(String _copyFrom) {
		purchaseOrderPage.select_option_copy_from(_copyFrom);
	}

	@Step
	public void enter_copy_from_po(String _copyFromPo) {
		purchaseOrderPage.enter_copy_from_po(_copyFromPo);
	}

	@Step
	public void enter_supplier_contact(String _supplierContact) {
		purchaseOrderPage.enter_supplier_contact(_supplierContact);
	}

	@Step
	public void enter_purchase_order_date(String _purchaseOrderDate) {
		purchaseOrderPage.enter_purchase_order_date(_purchaseOrderDate);
	}

	@Step
	public void enter_order_currency(String _orderCurrency) {
		purchaseOrderPage.enter_order_currency(_orderCurrency);
	}

	@Step
	public void enter_sales_tax(String _salesTax) {
		purchaseOrderPage.enter_sales_tax(_salesTax);
	}

	@Step
	public void enter_purchaser(String _purchaser) {
		purchaseOrderPage.enter_purchaser(_purchaser);
	}

	@Step
	public void enter_sbu(String _sbu) {
		purchaseOrderPage.enter_sbu(_sbu);
	}

	@Step
	public void select_option_production_purchase(String _productionPurchase) {
		purchaseOrderPage.select_option_production_purchase(_productionPurchase);
	}

	@Step
	public void enter_purchase_category(String _purchaseCategory) {
		purchaseOrderPage.enter_purchase_category(_purchaseCategory);
	}

	@Step
	public void enter_reference_no(String _referenceNo) {
		purchaseOrderPage.enter_reference_no(_referenceNo);
	}

	@Step
	public void enter_subject(String _subject) {
		purchaseOrderPage.enter_subject(_subject);
	}

	@Step
	public void enter_segment_1(String _segment1) {
		purchaseOrderPage.enter_segment_1(_segment1);
	}

	@Step
	public void enter_segment_2(String _segment2) {
		purchaseOrderPage.enter_segment_2(_segment2);
	}

	@Step
	public void enter_segment_3(String _segment3) {
		purchaseOrderPage.enter_segment_3(_segment3);
	}

	@Step
	public void enter_segment_4(String _segment4) {
		purchaseOrderPage.enter_segment_4(_segment4);
	}

	// END Header
	// BEGIN Shipment
	@Step
	public void enter_purchase_order_no(String _purchaseOrderNo) {
		purchaseOrderPage.enter_purchase_order_no(_purchaseOrderNo);
	}

	@Step
	public void enter_shipment_mode(String _shipmentMode) {
		purchaseOrderPage.enter_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_shipment_term(String _ShipmentTerm) {
		purchaseOrderPage.enter_shipment_term(_ShipmentTerm);
	}

	@Step
	public void enter_ship_to_location(String _shipToLocation) {
		purchaseOrderPage.enter_ship_to_location(_shipToLocation);
	}

	@Step
	public void enter_port_of_loading(String _portOfLoading) {
		purchaseOrderPage.enter_port_of_loading(_portOfLoading);
	}

	@Step
	public void enter_port_of_discharge(String _portOfDischarge) {
		purchaseOrderPage.enter_port_of_discharge(_portOfDischarge);
	}

	@Step
	public void enter_port_of_final_destination(String _portOfFinalDestination) {
		purchaseOrderPage.enter_port_of_final_destination(_portOfFinalDestination);
	}

	@Step
	public void enter_ship_through(String _shipThrough) {
		purchaseOrderPage.enter_ship_through(_shipThrough);
	}

	@Step
	public void enter_ship_to_party(String _shipToParty) {
		purchaseOrderPage.enter_ship_to_party(_shipToParty);
	}

	@Step
	public void enter_ship_to_party_address(String _shipToPartyAddress) {
		purchaseOrderPage.enter_ship_to_party_address(_shipToPartyAddress);
	}

	@Step
	public void enter_ship_to_party_contact(String _shipToPartyContact) {
		purchaseOrderPage.enter_ship_to_party_contact(_shipToPartyContact);
	}

	@Step
	public void enter_country_of_loading(String _countryOfLoading) {
		purchaseOrderPage.enter_country_of_loading(_countryOfLoading);
	}

	@Step
	public void enter_country_of_discharge(String _countryOfDischarge) {
		purchaseOrderPage.enter_country_of_discharge(_countryOfDischarge);
	}

	@Step
	public void enter_country_of_final_destination(String _countryOfFinalDestination) {
		purchaseOrderPage.enter_country_of_final_destination(_countryOfFinalDestination);
	}

	@Step
	public void enter_project_ship_to_address(String _projectShipToAdd) {
		purchaseOrderPage.enter_project_ship_to_address(_projectShipToAdd);
	}

	@Step
	public void enter_no_of_shipment(String _noOfShipment) {
		purchaseOrderPage.enter_no_of_shipment(_noOfShipment);
	}

	// Payment Info
	@Step
	public String get_payment_amount() {
		return purchaseOrderPage.get_payment_amount();
	}

	@Step
	public String get_payment_party() {
		return purchaseOrderPage.get_payment_party();
	}

	@Step
	public String get_payment_address() {
		return purchaseOrderPage.get_payment_address();
	}

	@Step
	public String get_payment_contact() {
		return purchaseOrderPage.get_payment_contact();
	}

	@Step
	public String get_selected_payment_option() {
		return purchaseOrderPage.get_selected_payment_option();
	}

	@Step
	public String get_selected_payment_term() {
		return purchaseOrderPage.get_selected_payment_term();
	}

	@Step
	public String get_payment_term_tenor_days() {
		return purchaseOrderPage.get_payment_term_tenor_days();
	}

	@Step
	public String get_payment_term_tenor_code() {
		return purchaseOrderPage.get_payment_term_tenor_code();
	}

	@Step
	public String get_selected_payment_method() {
		return purchaseOrderPage.get_selected_payment_method();
	}

	@Step
	public void select_payment_option(String _paymentOption) {
		purchaseOrderPage.select_payment_option(_paymentOption);
	}

	@Step
	public void select_payment_term(String _paymentTerm) {
		purchaseOrderPage.select_payment_term(_paymentTerm);
	}

	@Step
	public void enter_payment_term_tenor(String _paymentTermTenor) {
		purchaseOrderPage.enter_payment_term_tenor(_paymentTermTenor);
	}

	@Step
	public void enter_payment_term_tenor_code(String _paymentTermTenorCode) {
		purchaseOrderPage.enter_payment_term_tenor_code(_paymentTermTenorCode);
	}

	@Step
	public void select_payment_method(String _paymentMethod) {
		purchaseOrderPage.select_payment_method(_paymentMethod);
	}

	@Step
	public void enter_payment_party(String _paymentParty) {
		purchaseOrderPage.enter_payment_party(_paymentParty);
	}

	@Step
	public void enter_payment_address(String _paymentAddress) {
		purchaseOrderPage.enter_payment_address(_paymentAddress);
	}

	@Step
	public void enter_payment_contact(String _paymentContact) {
		purchaseOrderPage.enter_payment_contact(_paymentContact);
	}

	@Step
	public void enter_payment_amount(String _paymentAmount) {
		purchaseOrderPage.enter_payment_amount(_paymentAmount);
	}

	// Remarks
	@Step
	public void enter_internal_remarks_code(String _internalRemarksCode) {
		purchaseOrderPage.enter_internal_remarks_code(_internalRemarksCode);
	}

	@Step
	public void enter_external_remarks_code(String _externalRemarksCode) {
		purchaseOrderPage.enter_external_remarks_code(_externalRemarksCode);
	}

	@Step
	public void enter_internal_remarks(String _internalRemarks) {
		purchaseOrderPage.enter_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_external_remarks(String _externalRemarks) {
		purchaseOrderPage.enter_external_remarks(_externalRemarks);
	}

	// Detail
	@Step
	public void click_btn_add_detail() {
		purchaseOrderPage.click_btn_add_detail();
	}

	@Step
	public void click_btn_delete_detail() {
		purchaseOrderPage.click_btn_delete_detail();
	}

	@Step
	public void click_btn_browse_pick_detail() {
		purchaseOrderPage.click_btn_browse_pick_detail();
	}

	@Step
	public void enter_det_exchange_rate(String _exchangeRate) {
		purchaseOrderPage.enter_det_exchange_rate(_exchangeRate);
	}

	@Step
	public void enter_det_estimated_shipment_date(String _estimatedShipmentDate) {
		purchaseOrderPage.enter_det_estimated_shipment_date(_estimatedShipmentDate);
	}

	@Step
	public void enter_det_estimated_arrival_date(String _estimatedArrivalDate) {
		purchaseOrderPage.enter_det_estimated_arrival_date(_estimatedArrivalDate);
	}

	@Step
	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return purchaseOrderPage.get_det_row_by_line_item_no(_lineItemNo);
	}

	@Step
	public String get_det_type(int _rowIndex) {
		return purchaseOrderPage.get_det_type(_rowIndex);
	}

	@Step
	public String get_det_item_code(int _rowIndex) {
		return purchaseOrderPage.get_det_item_code(_rowIndex);
	}

	@Step
	public String get_det_qty(int _rowIndex) {
		return purchaseOrderPage.get_det_qty(_rowIndex);
	}

	@Step
	public String get_det_unit_cost(int _rowIndex) {
		return purchaseOrderPage.get_det_unit_cost(_rowIndex);
	}

	@Step
	public void select_det_type(int _rowIndex, String _type) {
		purchaseOrderPage.select_det_type(_rowIndex, _type);
	}

	@Step
	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		purchaseOrderPage.enter_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		purchaseOrderPage.enter_det_item_remarks(_rowIndex, _itemRemarks);
	}

	@Step
	public void enter_det_qty(int _rowIndex, String _qty) {
		purchaseOrderPage.enter_det_qty(_rowIndex, _qty);
	}

	@Step
	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		purchaseOrderPage.enter_det_no_of_pack(_rowIndex, _noOfPack);
	}

	@Step
	public void select_det_pack_size(int _rowIndex, String _packSize) {
		purchaseOrderPage.select_det_pack_size(_rowIndex, _packSize);
	}

	@Step
	public void enter_det_sales_tax(int _rowIndex, String _salesTax) {
		purchaseOrderPage.enter_det_sales_tax(_rowIndex, _salesTax);
	}

	@Step
	public void select_det_cost_type(int _rowIndex, String _costType) {
		purchaseOrderPage.select_det_cost_type(_rowIndex, _costType);
	}

	@Step
	public void enter_det_unit_cost(int _rowIndex, String _unitCost) {
		purchaseOrderPage.enter_det_unit_cost(_rowIndex, _unitCost);
	}

	@Step
	public void enter_det_discount_percent(int _rowIndex, String _discountPercent) {
		purchaseOrderPage.enter_det_discount_percent(_rowIndex, _discountPercent);
	}

	@Step
	public void enter_det_discount_amount(int _rowIndex, String _discountAmount) {
		purchaseOrderPage.enter_det_discount_amount(_rowIndex, _discountAmount);
	}

	@Step
	public String get_det_total(int _rowIndex, String _total) {
		return purchaseOrderPage.get_det_total(_rowIndex, _total);
	}

	@Step
	public void set_det_direct_issue_to_project(int _rowIndex, String _directIssueToProject) {
		purchaseOrderPage.set_det_direct_issue_to_project(_rowIndex, _directIssueToProject);
	}

	@Step
	public void open_panel_allocation_details(boolean isPopup, int _rowIndex) {
		purchaseOrderPage.open_panel_allocation_details(isPopup, _rowIndex);
	}

	@Step
	public boolean is_enable_viewing_source_voucher_detail_for_allocation() {
		return purchaseOrderPage.is_enable_viewing_source_voucher_detail_for_allocation();
	}

	@Step
	public void open_panel_contents(int _rowIndex) {
		purchaseOrderPage.open_panel_contents(_rowIndex);
	}

	// Contents
	@Step
	public String get_content_line_item_no() {
		return purchaseOrderPage.get_content_line_item_no();
	}

	@Step
	public String get_content_item_unit_cost() {
		return purchaseOrderPage.get_content_item_unit_cost();
	}

	@Step
	public String get_content_currency() {
		return purchaseOrderPage.get_content_currency();
	}

	@Step
	public int get_content_row_by_content_code(String _contentCode) {
		return purchaseOrderPage.get_content_row_by_content_code(_contentCode);
	}

	@Step
	public String get_content_description(int _rowIndex) {
		return purchaseOrderPage.get_content_description(_rowIndex);
	}

	@Step
	public String get_content_percentage(int _rowIndex) {
		return purchaseOrderPage.get_content_percentage(_rowIndex);
	}

	@Step
	public String get_content_recovery_rate(int _rowIndex) {
		return purchaseOrderPage.get_content_recovery_rate(_rowIndex);
	}

	@Step
	public String get_content_content_unit_cost(int _rowIndex) {
		return purchaseOrderPage.get_content_content_unit_cost(_rowIndex);
	}

	@Step
	public void click_btn_content_add() {
		purchaseOrderPage.click_btn_content_add();
	}

	@Step
	public void click_btn_content_delete() {
		purchaseOrderPage.click_btn_content_delete();
	}

	@Step
	public void click_btn_content_confirm() {
		purchaseOrderPage.click_btn_content_confirm();
	}

	@Step
	public void enter_content_content_code(int _rowIndex, String _contentCode) {
		purchaseOrderPage.enter_content_content_code(_rowIndex, _contentCode);
	}

	@Step
	public void enter_content_percentage(int _rowIndex, String _percentage) {
		purchaseOrderPage.enter_content_percentage(_rowIndex, _percentage);
	}

	@Step
	public void enter_content_recovery_rate(int _rowIndex, String _recoveryRate) {
		purchaseOrderPage.enter_content_recovery_rate(_rowIndex, _recoveryRate);
	}

	@Step
	public void enter_content_content_unit_cost(int _rowIndex, String _contentUnitCost) {
		purchaseOrderPage.enter_content_content_unit_cost(_rowIndex, _contentUnitCost);
	}

	@Step
	public void enter_content_new_content_code(String _contentCode) {
		purchaseOrderPage.enter_content_new_content_code(_contentCode);
	}

	// Allocation Detail
	public void switch_to_tab_ad_allocation_details() {
		purchaseOrderPage.switch_to_tab_ad_allocation_details();
	}

	@Step
	public void click_btn_add_alloc() {
		purchaseOrderPage.click_btn_add_alloc();
	}

	@Step
	public void click_btn_delete_alloc() {
		purchaseOrderPage.click_btn_delete_alloc();
	}

	@Step
	public void click_btn_done_alloc() {
		purchaseOrderPage.click_btn_done_alloc();
	}

	@Step
	public int get_alloc_row_by_allocation_no(String _allocationNo) {
		return purchaseOrderPage.get_alloc_row_by_allocation_no(_allocationNo);
	}

	@Step
	public boolean check_alloc_row_existed_by_allocation_no(String _allocationNo) {
		return purchaseOrderPage.check_alloc_row_existed_by_allocation_no(_allocationNo);
	}

	@Step
	public void update_data_alloc_purchase_order_no(String _purchaseOrderNo) {
		// TODO
	}

	@Step
	public void select_alloc_line_item_no(String _lineItemNo) {
		purchaseOrderPage.select_alloc_line_item_no(_lineItemNo);
	}

	@Step
	public void select_alloc_alloc_type(int _rowIndex, String _allocType) {
		purchaseOrderPage.select_alloc_alloc_type(_rowIndex, _allocType);
	}

	@Step
	public void enter_alloc_voucher_no(int _rowIndex, String _voucherNo) {
		purchaseOrderPage.enter_alloc_voucher_no(_rowIndex, _voucherNo);
	}

	@Step
	public void enter_alloc_phase_sequence_no(int _rowIndex, String _phaseSequenceNo) {
		purchaseOrderPage.enter_alloc_phase_sequence_no(_rowIndex, _phaseSequenceNo);
	}

	@Step
	public void enter_alloc_line_no(int _rowIndex, String _lineNo) {
		purchaseOrderPage.enter_alloc_line_no(_rowIndex, _lineNo);
	}

	@Step
	public void enter_alloc_alloc_qty(int _rowIndex, String _allocQty) {
		purchaseOrderPage.enter_alloc_alloc_qty(_rowIndex, _allocQty);
	}

	// Attachment
	public void click_btn_add_attachment() {
		purchaseOrderPage.click_btn_add_attachment();
	}

	@Step
	public void click_btn_delete_attachment() {
		purchaseOrderPage.click_btn_delete_attachment();
	}

	@Step
	public void click_btn_cancel_attachment() {
		purchaseOrderPage.click_btn_cancel_attachment();
	}

	@Step
	public void choose_attachment_file(String _filePath) {
		purchaseOrderPage.choose_attachment_file(_filePath);
	}

	@Step
	public void click_btn_upload_attachment() {
		purchaseOrderPage.click_btn_upload_attachment();
	}

	@Step
	public int get_att_row_by_no(String _AttachmentNo) {
		return purchaseOrderPage.get_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void enter_file_description(int _rowIndex, String _fileDescription) {
		purchaseOrderPage.enter_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_new_file_mime_type(int _rowIndex) {
		return purchaseOrderPage.get_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_new_file_file_size(int _rowIndex) {
		return purchaseOrderPage.get_new_file_file_size(_rowIndex);
	}
}
