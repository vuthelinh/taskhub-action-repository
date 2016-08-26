package com.synergix.processing.sales.steps;

import com.synergix.processing.sales.pages.SalesQuotationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160817
 */
public class SalesQuotationSteps extends ScenarioSteps {
	SalesQuotationPage salesQuotationPage;

	// BEGIN Switch tab
	@Step
	public void click_btn_new_of_sq_summany() {
		salesQuotationPage.click_btn_new_of_sq_summany();
	}

	@Step
	public void switch_to_tab_draft() {
		salesQuotationPage.switch_to_tab_draft();
	}

	@Step
	public void switch_to_tab_pending_approval() {
		salesQuotationPage.switch_to_tab_pending_approval();
	}

	@Step
	public void switch_to_tab_outstanding() {
		salesQuotationPage.switch_to_tab_outstanding();
	}

	@Step
	public void switch_to_tab_history() {
		salesQuotationPage.switch_to_tab_history();
	}

	@Step
	public void filter_by_sales_quotation_no(String _salesQuotationNo) {
		salesQuotationPage.filter_by_sales_quotation_no(_salesQuotationNo);
	}

	@Step
	public void open_sales_quotation_no(String _salesQuotationNo) {
		salesQuotationPage.open_sales_quotation_no(_salesQuotationNo);
	}

	@Step
	public void open_first_sales_quotation_no() {
		salesQuotationPage.open_first_sales_quotation_no();
	}

	// END Sales Quotation Summary

	// BEGIN Create SQ in Draft
	@Step
	public void switch_to_tab_header() {
		salesQuotationPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_shipment() {
		salesQuotationPage.switch_to_tab_shipment();
	}

	@Step
	public void switch_to_tab_detail() {
		salesQuotationPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_payment_info() {
		salesQuotationPage.switch_to_tab_payment_info();
	}

	@Step
	public void switch_to_tab_remarks() {
		salesQuotationPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		salesQuotationPage.switch_to_tab_attachments();
	}

	// Header

	@Step
	public String get_new_sales_quotation_no() {
		return salesQuotationPage.get_new_sales_quotation_no();
	}

	@Step
	public void sales_quotation_no(String _sales_quotation_no) {
		System.out.println("***** INFO ***** Sales Quotation No: " + _sales_quotation_no);
	}

	@Step
	public void click_btn_new_sales_quotation_detail() {
		salesQuotationPage.click_btn_new_sales_quotation_detail();
	}

	// Preview report
	@Step
	public void click_btn_preview_sales_quotation_detail() {
		salesQuotationPage.click_btn_preview_sales_quotation_detail();
	}

	@Step
	public boolean is_display_reports_selection() {
		return salesQuotationPage.is_display_reports_selection();
	}

	@Step
	public void open_report_by_report_title(String reportTitle) {
		salesQuotationPage.open_report_by_report_title(reportTitle);
	}

	@Step
	public int count_text_sections_in_report() {
		return salesQuotationPage.count_text_sections_in_report();
	}

	@Step
	public String getCurrentWindowHandle() {
		return salesQuotationPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switch_to_preview_report_window() {
		return salesQuotationPage.switch_to_preview_report_window(10);
	}

	@Step
	public boolean verify_preview_report_content(String _givenContent) {
		return salesQuotationPage.verify_preview_report_content(_givenContent);
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return salesQuotationPage.switchToWindowHandle(_handle);
	}

	@Step
	public void click_btn_back_to_summary_sales_quotation_detail() {
		salesQuotationPage.click_btn_back_to_summary_sales_quotation_detail();
	}

	@Step
	public void click_btn_submit_sales_quotation_detail() {
		salesQuotationPage.click_btn_submit_sales_quotation_detail();
	}

	@Step
	public void submit_sales_quotation_detail() {
		salesQuotationPage.submit_sales_quotation_detail();
	}

	@Step
	public void click_btn_yes_on_confirm_submit() {
		salesQuotationPage.click_btn_yes_on_confirm_submit();
	}

	@Step
	public void click_btn_no_on_confirm_submit() {
		salesQuotationPage.click_btn_no_on_confirm_submit();
	}

	@Step
	public void click_btn_back_to_summary() {
		salesQuotationPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_abort() {
		salesQuotationPage.click_btn_abort();
	}

	@Step
	public void click_btn_copy() {
		salesQuotationPage.click_btn_copy();
	}

	@Step
	public void select_option_copy_from(String _copyFrom) {
		salesQuotationPage.select_option_copy_from(_copyFrom);
	}

	@Step
	public void enter_copy_from(String _copyFrom) {
		salesQuotationPage.enter_copy_from(_copyFrom);
	}

	@Step
	public void enter_segment_1(String _segment1) {
		salesQuotationPage.enter_segment_1(_segment1);
	}

	@Step
	public void enter_segment_2(String _segment2) {
		salesQuotationPage.enter_segment_2(_segment2);
	}

	@Step
	public void enter_segment_3(String _segment3) {
		salesQuotationPage.enter_segment_3(_segment3);
	}

	@Step
	public void enter_segment_4(String _segment4) {
		salesQuotationPage.enter_segment_4(_segment4);
	}

	@Step
	public void enter_customer(String _customer) {
		salesQuotationPage.enter_customer(_customer);
	}

	@Step
	public String get_customer_name() {
		return salesQuotationPage.get_customer_name();
	}

	@Step
	public void enter_customer_address(String _customerAddress) {
		salesQuotationPage.enter_customer_address(_customerAddress);
	}

	@Step
	public String get_customer_address_code() {
		return salesQuotationPage.get_customer_address_code();
	}

	@Step
	public void enter_customer_contact(String _customerContact) {
		salesQuotationPage.enter_customer_contact(_customerContact);
	}

	@Step
	public String get_customer_contact_code() {
		return salesQuotationPage.get_customer_contact_code();
	}

	@Step
	public void enter_quotation_date(String _quotationDate) {
		salesQuotationPage.enter_quotation_date(_quotationDate);
	}

	@Step
	public void enter_quotation_time(String _quotationTime) {
		salesQuotationPage.enter_quotation_time(_quotationTime);
	}

	@Step
	public void enter_order_date(String _orderDate) {
		salesQuotationPage.enter_order_date(_orderDate);
	}

	@Step
	public void enter_order_time(String _orderTime) {
		salesQuotationPage.enter_order_time(_orderTime);
	}

	@Step
	public void enter_reporting_date(String _reportingDate) {
		salesQuotationPage.enter_reporting_date(_reportingDate);
	}

	@Step
	public void enter_reporting_time(String _reportingTime) {
		salesQuotationPage.enter_reporting_time(_reportingTime);
	}

	@Step
	public void enter_sbu(String _Sbu) {
		salesQuotationPage.enter_sbu(_Sbu);
	}

	@Step
	public void enter_sales_person(String _salesPerson) {
		salesQuotationPage.enter_sales_person(_salesPerson);
	}

	@Step
	public void enter_currency(String _currency) {
		salesQuotationPage.enter_currency(_currency);
	}

	@Step
	public String get_currency() {
		return salesQuotationPage.get_currency();
	}

	@Step
	public void enter_sales_tax(String _salesTax) {
		salesQuotationPage.enter_sales_tax(_salesTax);
	}

	@Step
	public String get_sales_tax() {
		return salesQuotationPage.get_sales_tax();
	}

	@Step
	public String get_sales_person() {
		return salesQuotationPage.get_sales_person();
	}

	@Step
	public void enter_validity_term(String _validityTerm) {
		salesQuotationPage.enter_validity_term(_validityTerm);
	}

	@Step
	public String get_validity_due_date(String _validityDueDate) {
		return salesQuotationPage.get_validity_due_date(_validityDueDate);
	}

	@Step
	public void enter_offer_condition(String _offerCondition) {
		salesQuotationPage.enter_offer_condition(_offerCondition);
	}

	@Step
	public void enter_customer_so_no(String _customerSoNo) {
		salesQuotationPage.enter_customer_so_no(_customerSoNo);
	}

	@Step
	public void enter_customer_po_no(String _customerPoNo) {
		salesQuotationPage.enter_customer_po_no(_customerPoNo);
	}

	@Step
	public void enter_customer_po_line_item_no(String _customerPoLineItemNo) {
		salesQuotationPage.enter_customer_po_line_item_no(_customerPoLineItemNo);
	}

	@Step
	public void enter_d_sales(String _dSales) {
		salesQuotationPage.enter_d_sales(_dSales);
	}

	@Step
	public void enter_end_user(String _endUser) {
		salesQuotationPage.enter_end_user(_endUser);
	}

	@Step
	public void enter_sales_category(String _salesCategory) {
		salesQuotationPage.enter_sales_category(_salesCategory);
	}

	@Step
	public void enter_subject(String _subject) {
		salesQuotationPage.enter_subject(_subject);
	}

	@Step
	public void enter_reference_no(String _referenceNo) {
		salesQuotationPage.enter_reference_no(_referenceNo);
	}

	// Shipment
	@Step
	public void enter_loading_location(String _loadingLocation) {
		salesQuotationPage.enter_loading_location(_loadingLocation);
	}

	@Step
	public void enter_shipment_mode(String _shipmentMode) {
		salesQuotationPage.enter_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_shipment_term(String _shipmentTerm) {
		salesQuotationPage.enter_shipment_term(_shipmentTerm);
	}

	@Step
	public void enter_shipment_instruction(String _shipmentInstruction) {
		salesQuotationPage.enter_shipment_instruction(_shipmentInstruction);
	}

	@Step
	public void enter_ship_to_address(String _shipToAddress) {
		salesQuotationPage.enter_ship_to_address(_shipToAddress);
	}

	@Step
	public void enter_ship_to_contact(String _shipToContact) {
		salesQuotationPage.enter_ship_to_contact(_shipToContact);
	}

	@Step
	public void enter_bill_to_address(String _billToAddress) {
		salesQuotationPage.enter_bill_to_address(_billToAddress);
	}

	@Step
	public void enter_bill_to_contact(String _billToContact) {
		salesQuotationPage.enter_bill_to_contact(_billToContact);
	}

	@Step
	public void enter_ship_through(String _shipThrough) {
		salesQuotationPage.enter_ship_through(_shipThrough);
	}

	@Step
	public void enter_port_of_loading(String _portOfLoading) {
		salesQuotationPage.enter_port_of_loading(_portOfLoading);
	}

	@Step
	public void enter_port_of_discharge(String _portOfDischarge) {
		salesQuotationPage.enter_port_of_discharge(_portOfDischarge);
	}

	@Step
	public void enter_port_of_final_destination(String _portOfFinalDestination) {
		salesQuotationPage.enter_port_of_final_destination(_portOfFinalDestination);
	}

	@Step
	public String get_country_of_loading(String _countryOfLoading) {
		return salesQuotationPage.get_country_of_loading(_countryOfLoading);
	}

	@Step
	public String enter_country_of_discharge(String _countryOfDischarge) {
		return salesQuotationPage.enter_country_of_discharge(_countryOfDischarge);
	}

	@Step
	public String enter_country_of_final_destination(String _countryOfFinalDestination) {
		return salesQuotationPage.enter_country_of_final_destination(_countryOfFinalDestination);
	}

	@Step
	public void enter_no_of_shipment(String _noOfShipment) {
		salesQuotationPage.enter_no_of_shipment(_noOfShipment);
	}

	// Payment Info
	@Step
	public void select_payment_option(String _paymentOption) {
		salesQuotationPage.select_payment_option(_paymentOption);
	}

	@Step
	public void select_payment_term(String _paymentTerm) {
		salesQuotationPage.select_payment_term(_paymentTerm);
	}

	@Step
	public void enter_payment_term_tenor(String _paymentTermTenor) {
		salesQuotationPage.enter_payment_term_tenor(_paymentTermTenor);
	}

	@Step
	public void enter_payment_term_tenor_code(String _paymentTermTenorCode) {
		salesQuotationPage.enter_payment_term_tenor_code(_paymentTermTenorCode);
	}

	@Step
	public void select_payment_method(String _paymentMethod) {
		salesQuotationPage.select_payment_method(_paymentMethod);
	}

	@Step
	public void enter_billing_party(String _billingParty) {
		salesQuotationPage.enter_billing_party(_billingParty);
	}

	@Step
	public void enter_billing_address(String _billingAddress) {
		salesQuotationPage.enter_billing_address(_billingAddress);
	}

	@Step
	public void enter_billing_contact(String _billingContact) {
		salesQuotationPage.enter_billing_contact(_billingContact);
	}

	@Step
	public void enter_payment_amount(String _paymentAmount) {
		salesQuotationPage.enter_payment_amount(_paymentAmount);
	}

	@Step
	public String get_payment_amount() {
		return salesQuotationPage.get_payment_amount();
	}

	@Step
	public void enter_own_bank(String _ownBank) {
		salesQuotationPage.enter_own_bank(_ownBank);
	}

	@Step
	public String get_own_bank() {
		return salesQuotationPage.get_own_bank();
	}

	// Remarks
	@Step
	public void enter_internal_remarks_code(String _internalRemarksCode) {
		salesQuotationPage.enter_internal_remarks_code(_internalRemarksCode);
	}

	@Step
	public void enter_external_remarks_code(String _externalRemarksCode) {
		salesQuotationPage.enter_external_remarks_code(_externalRemarksCode);
	}

	@Step
	public void enter_warranty_remarks_code(String _warrantyRemarksCode) {
		salesQuotationPage.enter_warranty_remarks_code(_warrantyRemarksCode);
	}

	@Step
	public void enter_internal_remarks(String _internalRemarks) {
		salesQuotationPage.enter_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_external_remarks(String _externalRemarks) {
		salesQuotationPage.enter_external_remarks(_externalRemarks);
	}

	@Step
	public void enter_warranty_remarks(String _warrantyRemarks) {
		salesQuotationPage.enter_warranty_remarks(_warrantyRemarks);
	}

	// Detail
	@Step
	public void click_btn_add_detail() {
		salesQuotationPage.click_btn_add_detail();
	}

	@Step
	public void click_btn_delete_detail() {
		salesQuotationPage.click_btn_delete_detail();
	}

	@Step
	public void click_btn_reorder_line_item_by_brand() {
		salesQuotationPage.click_btn_reorder_line_item_by_brand();
	}

	@Step
	public String get_reports_title_list_then_done() {
		return salesQuotationPage.get_reports_title_list_then_done();
	}

	@Step
	public void click_btn_import() {
		salesQuotationPage.click_btn_import();
	}

	@Step
	public void enter_det_exchange_rate(String _exchangeRate) {
		salesQuotationPage.enter_det_exchange_rate(_exchangeRate);
	}

	@Step
	public void enter_det_overall_discount_code(String _overallDiscountCode) {
		salesQuotationPage.enter_det_overall_discount_code(_overallDiscountCode);
	}

	@Step
	public void enter_det_discount_percent(String _discountPercent) {
		salesQuotationPage.enter_det_discount_percent(_discountPercent);
	}

	@Step
	public void enter_det_discount_amount(String _discountAmount) {
		salesQuotationPage.enter_det_discount_amount(_discountAmount);
	}

	@Step
	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return salesQuotationPage.get_det_row_by_line_item_no(_lineItemNo);
	}

	@Step
	public void select_det_item_type(int _rowIndex, String _itemType) {
		salesQuotationPage.select_det_item_type(_rowIndex, _itemType);
	}

	@Step
	public void set_det_drawing_received(int _rowIndex, String _drawingReceived) {
		salesQuotationPage.set_det_drawing_received(_rowIndex, _drawingReceived);
	}

	@Step
	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		salesQuotationPage.enter_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		salesQuotationPage.enter_det_item_remarks(_rowIndex, _itemRemarks);
	}

	@Step
	public void enter_det_operation_remarks(int _rowIndex, String _operationRemarks) {
		salesQuotationPage.enter_det_operation_remarks(_rowIndex, _operationRemarks);
	}

	@Step
	public void select_det_prd(int _rowIndex, String _prd) {
		salesQuotationPage.select_det_prd(_rowIndex, _prd);
	}

	@Step
	public void enter_det_qty(int _rowIndex, String _qty) {
		salesQuotationPage.enter_det_qty(_rowIndex, _qty);
	}

	@Step
	public String get_det_qty_uom(int _rowIndex) {
		return salesQuotationPage.get_det_qty_uom(_rowIndex);
	}

	@Step
	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		salesQuotationPage.enter_det_no_of_pack(_rowIndex, _noOfPack);
	}

	@Step
	public void select_det_pack_size(int _rowIndex, String _packSize) {
		salesQuotationPage.select_det_pack_size(_rowIndex, _packSize);
	}

	@Step
	public void select_det_sales_tax(int _rowIndex, String _salesTax) {
		salesQuotationPage.select_det_sales_tax(_rowIndex, _salesTax);
	}

	@Step
	public void enter_det_unit(int _rowIndex, String _unit) {
		salesQuotationPage.enter_det_unit(_rowIndex, _unit);
	}

	@Step
	public void enter_det_disc_percent(int _rowIndex, String _discPercent) {
		salesQuotationPage.enter_det_disc_percent(_rowIndex, _discPercent);
	}

	@Step
	public void enter_det_supplier(int _rowIndex, String _supplier) {
		salesQuotationPage.enter_det_supplier(_rowIndex, _supplier);
	}

	@Step
	public void select_det_ccy(int _rowIndex, String _ccy) {
		salesQuotationPage.select_det_ccy(_rowIndex, _ccy);
	}

	@Step
	public void enter_det_unit_cost(int _rowIndex, String _unit) {
		salesQuotationPage.enter_det_unit_cost(_rowIndex, _unit);
	}

	// TODO
	/*
	 * @Step public void enter_det_supplier(String _supplier) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_ccy_exch_rate_option(String
	 * _ccyExchRateOption) { salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_ccy_exch_rate(String _ccyExchRate) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_unit_cost(String _unitCost) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_total_cost(String _totalCost) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_mergin_percent(String _merginPercent) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_mergin_amount(String _merginAmount) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_count_as_sq_back_order(String
	 * _countAsSqBackOrder) { salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_supp_quot(String _suppQuot) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_drawing_received(String _drawingReceived) {
	 * salesQuotationPage.; }
	 * 
	 * @Step public void enter_det_rebate_code_description(String
	 * _rebateCodeDescription) { salesQuotationPage.; }
	 */
	// Attachment
	@Step
	public void click_btn_add_attachment() {
		salesQuotationPage.click_btn_add_attachment();
	}

	@Step
	public void click_btn_delete_attachment() {
		salesQuotationPage.click_btn_delete_attachment();
	}

	@Step
	public void click_btn_cancel_attachment() {
		salesQuotationPage.click_btn_cancel_attachment();
	}

	@Step
	public void choose_attachment_file(String _filePath) {
		salesQuotationPage.choose_attachment_file(_filePath);
	}

	@Step
	public int get_att_row_by_no(String _AttachmentNo) {
		return salesQuotationPage.get_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_upload_attachment() {
		salesQuotationPage.click_btn_upload_attachment();
	}

	@Step
	public void enter_file_description(int _rowIndex, String _fileDescription) {
		salesQuotationPage.enter_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_new_file_mime_type(int _rowIndex) {
		return salesQuotationPage.get_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_new_file_file_size(int _rowIndex) {
		return salesQuotationPage.get_new_file_file_size(_rowIndex);
	}

	// END Create SQ in Draft
	// BEGIN Sales Quotation Outstanding
	@Step
	public void click_btn_confirm() {
		salesQuotationPage.click_btn_confirm();
	}

	@Step
	public void clickBtnYesOnConfirmConfirm() {
		salesQuotationPage.clickBtnYesOnConfirmConfirm();
	}

	@Step
	public String get_sales_order_no_info_panel() {
		return salesQuotationPage.get_sales_order_no_outstanding();
	}

	@Step
	public void click_btn_ok_confirm_infor_panel() {
		salesQuotationPage.click_btn_ok_infor_panel_confirm();
	}

	@Step
	public void sales_order_no(String _sales_order_no) {
		System.out.println("***** INFO ***** Sales Order No: " + _sales_order_no);
	}
	// END Sales Quotation Outstanding
}
