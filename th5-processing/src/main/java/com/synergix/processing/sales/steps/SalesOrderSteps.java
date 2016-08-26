package com.synergix.processing.sales.steps;

import com.synergix.processing.sales.pages.SalesOrderPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160817
 */
public class SalesOrderSteps extends ScenarioSteps {
	SalesOrderPage salesOrderPage;

	// BEGIN Switch tab
	@Step
	public void click_btn_new_of_so_summany() {
		salesOrderPage.click_btn_new_of_so_summany();
	}

	@Step
	public void switch_to_tab_draft() {
		salesOrderPage.switch_to_tab_draft();
	}

	@Step
	public void switch_to_tab_outstanding() {
		salesOrderPage.switch_to_tab_outstanding();
	}

	@Step
	public void switch_to_tab_completed() {
		salesOrderPage.switch_to_tab_completed();
	}

	@Step
	public void switch_to_tab_cancelled() {
		salesOrderPage.switch_to_tab_cancelled();
	}

	@Step
	public void open_sales_order_no(String _salesOrderNo) {
		salesOrderPage.open_sales_order_no(_salesOrderNo);
	}

	@Step
	public void open_first_sales_order_no() {
		salesOrderPage.open_first_sales_order_no();
	}

	@Step
	public void open_first_sales_order_variation() {
		salesOrderPage.open_first_sales_order_variation();
	}
	// END Sales Order Summary

	// BEGIN Create SO
	@Step
	public void switch_to_tab_header() {
		salesOrderPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_shipment() {
		salesOrderPage.switch_to_tab_shipment();
	}

	@Step
	public void switch_to_tab_detail() {
		salesOrderPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_payment_info() {
		salesOrderPage.switch_to_tab_payment_info();
	}

	@Step
	public void switch_to_tab_remarks() {
		salesOrderPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		salesOrderPage.switch_to_tab_attachments();
	}

	@Step
	public void filter_summary_by_sales_quotation_no(String _salesQuotationNo) {
		salesOrderPage.filter_summary_by_sales_quotation_no(_salesQuotationNo);
	}

	@Step
	public void filter_summary_by_sales_order_no(String _salesOrderNo) {
		salesOrderPage.filter_summary_by_sales_order_no(_salesOrderNo);
	}

	@Step
	public void filter_summary_by_created_by(String _createdBy) {
		salesOrderPage.filter_summary_by_created_by(_createdBy);
	}

	@Step
	public void filter_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		salesOrderPage.filter_summary_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_summary_by_last_updated_by(String _lastUpdatedBy) {
		salesOrderPage.filter_summary_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		salesOrderPage.filter_summary_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	// Preview report
	@Step
	public boolean is_display_reports_selection() {
		return salesOrderPage.is_display_reports_selection();
	}

	@Step
	public void open_report_by_report_title(String reportTitle) {
		salesOrderPage.open_report_by_report_title(reportTitle);
	}

	@Step
	public int count_text_sections_in_report() {
		return salesOrderPage.count_text_sections_in_report();
	}

	@Step
	public boolean switch_to_preview_report_window() {
		return salesOrderPage.switch_to_preview_report_window(10);
	}

	@Step
	public boolean verify_preview_report_content(String _givenContent) {
		return salesOrderPage.verify_preview_report_content(_givenContent);
	}

	@Step
	public String getCurrentWindowHandle() {
		return salesOrderPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return salesOrderPage.switchToWindowHandle(_handle);
	}

	// Header
	@Step
	public String get_new_sales_order_no() {
		return salesOrderPage.get_new_sales_order_no();
	}

	@Step
	public void sales_order_no(String _sales_order_no) {
		System.out.println("***** INFO ***** Sales Order No: " + _sales_order_no);
	}

	@Step
	public String get_customer_name() {
		return salesOrderPage.get_customer_name();
	}

	@Step
	public void click_btn_new_sales_order_detail() {
		salesOrderPage.click_btn_new_sales_order_detail();
	}

	@Step
	public void click_btn_preview_sales_order_detail() {
		salesOrderPage.click_btn_preview_sales_order_detail();
	}

	@Step
	public void click_btn_submit_sales_order_detail() {
		salesOrderPage.click_btn_submit_sales_order_detail();
	}

	@Step
	public void submit_sales_order_detail() {
		salesOrderPage.submit_sales_order_detail();
	}

	@Step
	public void click_btn_yes_on_confirm_submit() {
		salesOrderPage.click_btn_yes_on_confirm_submit();
	}

	@Step
	public void click_btn_no_on_confirm_submit() {
		salesOrderPage.click_btn_no_on_confirm_submit();
	}

	@Step
	public void click_btn_back_to_summary() {
		salesOrderPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_abort() {
		salesOrderPage.click_btn_abort();
	}

	@Step
	public void click_btn_copy() {
		salesOrderPage.click_btn_copy();
	}

	@Step
	public void select_option_copy_from_option(String _copyFromOption) {
		salesOrderPage.select_option_copy_from_option(_copyFromOption);
	}

	@Step
	public void enter_copy_from(String _copyFrom) {
		salesOrderPage.enter_copy_from(_copyFrom);
	}

	@Step
	public void enter_customer(String _customer) {
		salesOrderPage.enter_customer(_customer);
	}

	@Step
	public void enter_customer_address(String _customerAddress) {
		salesOrderPage.enter_customer_address(_customerAddress);
	}

	@Step
	public String get_customer_address_code() {
		return salesOrderPage.get_customer_address_code();
	}

	@Step
	public void enter_customer_contact(String _customerContact) {
		salesOrderPage.enter_customer_contact(_customerContact);
	}

	@Step
	public String get_customer_contact_code() {
		return salesOrderPage.get_customer_contact_code();
	}

	@Step
	public void enter_order_date(String _orderDate) {
		salesOrderPage.enter_order_date(_orderDate);
	}

	@Step
	public void enter_sales_person(String _salesPerson) {
		salesOrderPage.enter_sales_person(_salesPerson);
	}

	@Step
	public String get_sales_person() {
		return salesOrderPage.get_sales_person();
	}

	@Step
	public void enter_order_currency(String _orderCurrency) {
		salesOrderPage.enter_order_currency(_orderCurrency);
	}

	@Step
	public void enter_segment_1(String _segment1) {
		salesOrderPage.enter_segment_1(_segment1);
	}

	@Step
	public void enter_segment_2(String _segment2) {
		salesOrderPage.enter_segment_2(_segment2);
	}

	@Step
	public void enter_segment_3(String _segment3) {
		salesOrderPage.enter_segment_3(_segment3);
	}

	@Step
	public void enter_segment_4(String _segment4) {
		salesOrderPage.enter_segment_4(_segment4);
	}

	@Step
	public String get_order_currency() {
		return salesOrderPage.get_order_currency();
	}

	@Step
	public void enter_reporting_date(String _reportingDate) {
		salesOrderPage.enter_reporting_date(_reportingDate);
	}

	@Step
	public void enter_approving_sbu(String _approvingSbu) {
		salesOrderPage.enter_approving_sbu(_approvingSbu);
	}

	@Step
	public void enter_sales_tax(String _salesTax) {
		salesOrderPage.enter_sales_tax(_salesTax);
	}

	@Step
	public String get_sales_tax() {
		return salesOrderPage.get_sales_tax();
	}

	@Step
	public void enter_reference_no(String _referenceNo) {
		salesOrderPage.enter_reference_no(_referenceNo);
	}

	@Step
	public void enter_customer_so_no(String _customerSoNo) {
		salesOrderPage.enter_customer_so_no(_customerSoNo);
	}

	@Step
	public void enter_customer_po_no(String _customerPoNo) {
		salesOrderPage.enter_customer_po_no(_customerPoNo);
	}

	@Step
	public void enter_customer_po_line_item_no(String _customerPoLineItemNo) {
		salesOrderPage.enter_customer_po_line_item_no(_customerPoLineItemNo);
	}

	@Step
	public void enter_end_user(String _endUser) {
		salesOrderPage.enter_end_user(_endUser);
	}

	@Step
	public void enter_sales_category(String _salesCategory) {
		salesOrderPage.enter_sales_category(_salesCategory);
	}

	@Step
	public void enter_subject(String _subject) {
		salesOrderPage.enter_subject(_subject);
	}

	@Step
	public void select_allocate_pr_to_so(String _allocatePRToSO) {
		salesOrderPage.select_allocate_pr_to_so(_allocatePRToSO);
	}

	@Step
	public void select_allocate_po_to_so(String _allocatePOToSO) {
		salesOrderPage.select_allocate_po_to_so(_allocatePOToSO);
	}

	@Step
	public void select_downpayment_type(String _downpaymentType) {
		salesOrderPage.select_downpayment_type(_downpaymentType);
	}

	@Step
	public void enter_q_downpayment_percent(String _qDownpaymentPercent) {
		salesOrderPage.enter_q_downpayment_percent(_qDownpaymentPercent);
	}

	@Step
	public void enter_q_downpayment_amount(String _qDownpaymentAmount) {
		salesOrderPage.enter_q_downpayment_amount(_qDownpaymentAmount);
	}

	@Step
	public void enter_q_downpayment_remarks(String _qDownpaymentRemarks) {
		salesOrderPage.enter_q_downpayment_remarks(_qDownpaymentRemarks);
	}

	// Shipment
	@Step
	public void enter_loading_location(String _loadingLocation) {
		salesOrderPage.enter_loading_location(_loadingLocation);
	}

	@Step
	public void enter_shipment_mode(String _shipmentMode) {
		salesOrderPage.enter_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_shipment_term(String _shipmentTerm) {
		salesOrderPage.enter_shipment_term(_shipmentTerm);
	}

	@Step
	public void enter_shipment_instruction(String _shipmentInstruction) {
		salesOrderPage.enter_shipment_instruction(_shipmentInstruction);
	}

	@Step
	public void enter_ship_to_address(String _shipToAddress) {
		salesOrderPage.enter_ship_to_address(_shipToAddress);
	}

	@Step
	public void enter_ship_to_contact(String _shipToContact) {
		salesOrderPage.enter_ship_to_contact(_shipToContact);
	}

	@Step
	public void enter_bill_to_address(String _billToAddress) {
		salesOrderPage.enter_bill_to_address(_billToAddress);
	}

	@Step
	public void enter_bill_to_contact(String _billToContact) {
		salesOrderPage.enter_bill_to_contact(_billToContact);
	}

	@Step
	public void enter_ship_through(String _shipThrough) {
		salesOrderPage.enter_ship_through(_shipThrough);
	}

	@Step
	public void enter_port_of_loading(String _portOfLoading) {
		salesOrderPage.enter_port_of_loading(_portOfLoading);
	}

	@Step
	public void enter_port_of_discharge(String _portOfDischarge) {
		salesOrderPage.enter_port_of_discharge(_portOfDischarge);
	}

	@Step
	public void enter_port_of_final_destination(String _portOfFinalDestination) {
		salesOrderPage.enter_port_of_final_destination(_portOfFinalDestination);
	}

	@Step
	public String get_country_of_loading(String _countryOfLoading) {
		return salesOrderPage.get_country_of_loading(_countryOfLoading);
	}

	@Step
	public String enter_country_of_discharge(String _countryOfDischarge) {
		return salesOrderPage.enter_country_of_discharge(_countryOfDischarge);
	}

	@Step
	public String enter_country_of_final_destination(String _countryOfFinalDestination) {
		return salesOrderPage.enter_country_of_final_destination(_countryOfFinalDestination);
	}

	@Step
	public void enter_no_of_shipment(String _noOfShipment) {
		salesOrderPage.enter_no_of_shipment(_noOfShipment);
	}

	// Payment Information
	@Step
	public void select_payment_option(String _paymentOption) {
		salesOrderPage.select_payment_option(_paymentOption);
	}

	@Step
	public void select_payment_term(String _paymentTerm) {
		salesOrderPage.select_payment_term(_paymentTerm);
	}

	@Step
	public void enter_payment_term_tenor(String _paymentTermTenor) {
		salesOrderPage.enter_payment_term_tenor(_paymentTermTenor);
	}

	@Step
	public void enter_payment_term_tenor_code(String _paymentTermTenorCode) {
		salesOrderPage.enter_payment_term_tenor_code(_paymentTermTenorCode);
	}

	@Step
	public void select_payment_method(String _paymentMethod) {
		salesOrderPage.select_payment_method(_paymentMethod);
	}

	@Step
	public void enter_billing_party(String _billingParty) {
		salesOrderPage.enter_billing_party(_billingParty);
	}

	@Step
	public void enter_billing_address(String _billingAddress) {
		salesOrderPage.enter_billing_address(_billingAddress);
	}

	@Step
	public void enter_billing_contact(String _billingContact) {
		salesOrderPage.enter_billing_contact(_billingContact);
	}

	@Step
	public void enter_payment_amount(String _paymentAmount) {
		salesOrderPage.enter_payment_amount(_paymentAmount);
	}

	@Step
	public String get_payment_amount() {
		return salesOrderPage.get_payment_amount();
	}

	@Step
	public void enter_own_bank(String _ownBank) {
		salesOrderPage.enter_own_bank(_ownBank);
	}

	@Step
	public String get_own_bank() {
		return salesOrderPage.get_own_bank();
	}

	// Remarks
	@Step
	public void enter_internal_remarks_code(String _internalRemarksCode) {
		salesOrderPage.enter_internal_remarks_code(_internalRemarksCode);
	}

	@Step
	public void enter_external_remarks_code(String _externalRemarksCode) {
		salesOrderPage.enter_external_remarks_code(_externalRemarksCode);
	}

	@Step
	public void enter_warranty_remarks_code(String _warrantyRemarksCode) {
		salesOrderPage.enter_warranty_remarks_code(_warrantyRemarksCode);
	}

	@Step
	public void enter_internal_remarks(String _internalRemarks) {
		salesOrderPage.enter_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_external_remarks(String _externalRemarks) {
		salesOrderPage.enter_external_remarks(_externalRemarks);
	}

	@Step
	public void enter_warranty_remarks(String _warrantyRemarks) {
		salesOrderPage.enter_warranty_remarks(_warrantyRemarks);
	}

	// Detail
	@Step
	public void click_btn_add_detail() {
		salesOrderPage.click_btn_add_detail();
	}

	@Step
	public void click_btn_delete_detail() {
		salesOrderPage.click_btn_delete_detail();
	}

	@Step
	public void click_btn_reorder_line_item_by_brand() {
		salesOrderPage.click_btn_reorder_line_item_by_brand();
	}

	@Step
	public void click_btn_browse_pick() {
		salesOrderPage.click_btn_browse_pick();
	}

	@Step
	public void enter_exchange_rate(String _exchangeRate) {
		salesOrderPage.enter_exchange_rate(_exchangeRate);
	}

	@Step
	public String get_det_exchange_rate() {
		return salesOrderPage.get_det_exchange_rate();
	}

	@Step
	public String get_det_total_volume() {
		return salesOrderPage.get_det_total_volume();
	}

	@Step
	public String get_det_total_weight() {
		return salesOrderPage.get_det_total_weight();
	}

	@Step
	public String get_det_total_discount_amt() {
		return salesOrderPage.get_det_total_discount_amt();
	}

	@Step
	public String get_det_total_sales_tax_amt() {
		return salesOrderPage.get_det_total_sales_tax_amt();
	}

	@Step
	public String get_det_sub_total_after_discount() {
		return salesOrderPage.get_det_sub_total_after_discount();
	}

	@Step
	public String get_det_total_after_tax_amt() {
		return salesOrderPage.get_det_total_after_tax_amt();
	}

	@Step
	public void enter_required_shipment_date(String _requiredShipmentDate) {
		salesOrderPage.enter_required_shipment_date(_requiredShipmentDate);
	}

	@Step
	public void enter_required_arrival_date(String _requiredArrivalDate) {
		salesOrderPage.enter_required_arrival_date(_requiredArrivalDate);
	}

	@Step
	public void enter_production_due_date(String _productionDueDate) {
		salesOrderPage.enter_production_due_date(_productionDueDate);
	}

	@Step
	public void enter_shipment_priority(String _shipmentPriority) {
		salesOrderPage.enter_shipment_priority(_shipmentPriority);
	}

	@Step
	public void enter_det_overall_discount_code(String _overallDiscountCode) {
		salesOrderPage.enter_det_overall_discount_code(_overallDiscountCode);
	}

	@Step
	public void enter_discount_percent(String _discountPercent) {
		salesOrderPage.enter_discount_percent(_discountPercent);
	}

	@Step
	public void enter_discount_amount(String _discountAmount) {
		salesOrderPage.enter_discount_amount(_discountAmount);
	}

	@Step
	public void enter_det_line_item_no(String _lineItemNo) {
		salesOrderPage.enter_det_line_item_no(_lineItemNo);
	}

	@Step
	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return salesOrderPage.get_det_row_by_line_item_no(_lineItemNo);
	}

	@Step
	public void select_det_item_type(int _rowIndex, String _itemType) {
		salesOrderPage.select_det_item_type(_rowIndex, _itemType);
	}

	@Step
	public void enter_det_loading_location(int _rowIndex, String _loadingLocation) {
		salesOrderPage.enter_det_loading_location(_rowIndex, _loadingLocation);
	}

	@Step
	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		salesOrderPage.enter_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		salesOrderPage.enter_det_item_remarks(_rowIndex, _itemRemarks);
	}

	@Step
	public void get_det_item_description(int _rowIndex) {
		salesOrderPage.get_det_item_description(_rowIndex);
	}

	@Step
	public void select_det_prd(int _rowIndex, String _prd) {
		salesOrderPage.select_det_prd(_rowIndex, _prd);
	}

	@Step
	public void enter_det_qty(int _rowIndex, String _qty) {
		salesOrderPage.enter_det_qty(_rowIndex, _qty);
	}

	@Step
	public String get_det_qty(int _rowIndex) {
		return salesOrderPage.get_det_qty(_rowIndex);
	}

	public void select_det_pack_size(int _rowIndex, String _pack_size) {
		salesOrderPage.select_det_pack_size(_rowIndex, _pack_size);
	}

	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		salesOrderPage.enter_det_no_of_pack(_rowIndex, _noOfPack);
	}

	@Step
	public String get_det_uom(int _rowIndex) {
		return salesOrderPage.get_det_uom(_rowIndex);
	}

	// @Step public void enter_det_no_of__bags(int _rowIndex, String _noOfBags)
	// {
	// salesOrderPage.;
	// }

	// @Step public void enter_det_pack_size(int _rowIndex, String _packSize) {
	// salesOrderPage.;
	// }

	// @Step public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
	// salesOrderPage.;
	// }

	@Step
	public void enter_det_sales_tax(int _rowIndex, String _salesTax) {
		salesOrderPage.enter_det_sales_tax(_rowIndex, _salesTax);
	}

	@Step
	public void enter_det_unit(int _rowIndex, String _unit) {
		salesOrderPage.enter_det_unit(_rowIndex, _unit);
	}

	@Step
	public void enter_det_discount_percent(int _rowIndex, String _discountPercent) {
		salesOrderPage.enter_det_discount_percent(_rowIndex, _discountPercent);
	}

	@Step
	public void enter_det_discount_amount(int _rowIndex, String _discountAmount) {
		salesOrderPage.enter_det_discount_amount(_rowIndex, _discountAmount);
	}

	@Step
	public String get_det_discount_percent(int _rowIndex) {
		return salesOrderPage.get_det_discount_percent(_rowIndex);
	}

	@Step
	public String get_det_total(int _rowIndex) {
		return salesOrderPage.get_det_total(_rowIndex);
	}

	@Step
	public void select_det_pr(int _rowIndex, String _pr) {
		salesOrderPage.select_det_pr(_rowIndex, _pr);
	}

	@Step
	public void select_det_po(int _rowIndex, String _po) {
		salesOrderPage.select_det_po(_rowIndex, _po);
	}

	@Step
	public void enter_det_draft_ost_po_no(int _rowIndex, String _draftOstPONo) {
		salesOrderPage.enter_det_draft_ost_po_no(_rowIndex, _draftOstPONo);
	}

	@Step
	public String get_det_draft_ost_line_item_no(int _rowIndex) {
		return salesOrderPage.get_det_draft_ost_line_item_no(_rowIndex);
	}

	@Step
	public void enter_det_supplier(int _rowIndex, String _supplier) {
		salesOrderPage.enter_det_supplier(_rowIndex, _supplier);
	}

	@Step
	public void enter_det_ccy(int _rowIndex, String _ccy) {
		salesOrderPage.enter_det_ccy(_rowIndex, _ccy);
	}

	@Step
	public void enter_det_po_qty_allocation(int _rowIndex, String _poQtyAllocation) {
		salesOrderPage.enter_det_po_qty_allocation(_rowIndex, _poQtyAllocation);
	}

	@Step
	public void enter_det_unit_cost(int _rowIndex, String _unitCost) {
		salesOrderPage.enter_det_unit_cost(_rowIndex, _unitCost);
	}

	// @Step public void enter_det_supp_quot(int _rowIndex, String _suppQuot) {
	//
	// }

	// @Step public void enter_det_ccy_exch_rate_option(int _rowIndex, String
	// _ccyExchRateOption) {
	// salesOrderPage.;
	// }

	// @Step public void enter_det_qoh(int _rowIndex, String _qoh) {
	// salesOrderPage.;
	// }

	// @Step public void enter_det_qoh_avail(int _rowIndex, String qohAvail) {
	// salesOrderPage.;
	// }

	@Step
	public void enter_det_qoh_allocation(int _rowIndex, String qohAllocation) {
		salesOrderPage.enter_det_qoh_allocation(_rowIndex, qohAllocation);
	}

	// @Step public void enter_det_rebate_code_description(int _rowIndex, String
	// rebateCodeDescription) {
	// salesOrderPage.;
	// }

	// Attachment
	@Step
	public void click_btn_add_attachment() {
		salesOrderPage.click_btn_add_attachment();
	}

	@Step
	public void click_btn_delete_attachment() {
		salesOrderPage.click_btn_delete_attachment();
	}

	@Step
	public void click_btn_cancel_attachment() {
		salesOrderPage.click_btn_cancel_attachment();
	}

	@Step
	public void choose_attachment_file(String _filePath) {
		salesOrderPage.choose_attachment_file(_filePath);
	}

	@Step
	public int get_att_row_by_no(String _AttachmentNo) {
		return salesOrderPage.get_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_upload_attachment() {
		salesOrderPage.click_btn_upload_attachment();
	}

	@Step
	public void enter_file_description(int _rowIndex, String _fileDescription) {
		salesOrderPage.enter_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_new_file_mime_type(int _rowIndex) {
		return salesOrderPage.get_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_new_file_file_size(int _rowIndex) {
		return salesOrderPage.get_new_file_file_size(_rowIndex);
	}

	// END Create SO
	@Step
	public String get_purchase_order_no_then_click_ok() {
		return salesOrderPage.get_purchase_order_no_then_click_ok();
	}

	@Step
	public String get_purchase_requisitions_no_then_click_ok() {
		return salesOrderPage.get_purchase_requisitions_no_then_click_ok();
	}

	@Step
	public void purchase_order_no(String _purchase_order_no) {
		System.out.println("***** INFO ***** Purchase Order No: " + _purchase_order_no);
	}

	@Step
	public void purchase_requisitions_no(String _purchase_requisitions_no) {
		System.out.println("***** INFO ***** Purchase Requisitions No: " + _purchase_requisitions_no);
	}
}
