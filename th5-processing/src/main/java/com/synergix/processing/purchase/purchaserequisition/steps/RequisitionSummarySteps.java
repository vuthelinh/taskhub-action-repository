package com.synergix.processing.purchase.purchaserequisition.steps;

import com.synergix.processing.purchase.purchaserequisition.pages.RequisitionSummaryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160817
 */
public class RequisitionSummarySteps extends ScenarioSteps {
	RequisitionSummaryPage RSPage;

	// BEGIN Purchase Requisition Summary
	@Step
	public void switch_to_tab_draft() {
		RSPage.switch_to_tab_draft();
	}

	@Step
	public void switch_to_tab_pending_draft() {
		RSPage.switch_to_tab_pending_draft();
	}

	@Step
	public void switch_to_tab_cost_confirmation() {
		RSPage.switch_to_tab_cost_confirmation();
	}

	@Step
	public void switch_to_tab_pending_approval() {
		RSPage.switch_to_tab_pending_approval();
	}

	@Step
	public void switch_to_tab_history() {
		RSPage.switch_to_tab_history();
	}

	// Draft tab
	@Step
	public void click_btn_new_of_pr_summany() {
		RSPage.click_btn_new_of_pr_summany();
	}

	@Step
	public void filter_by_pr_no(String _PRNo) {
		RSPage.filter_by_pr_no(_PRNo);
	}

	@Step
	public void filter_by_pr_date(String _PRDate) {
		RSPage.filter_by_pr_date(_PRDate);
	}

	@Step
	public void filter_by_requestor(String _requestor) {
		RSPage.filter_by_requestor(_requestor);
	}

	@Step
	public void filter_by_type(String _type) {
		RSPage.filter_by_type(_type);
	}

	@Step
	public void filter_by_source_voucher_no(String _sourceVoucherNo) {
		RSPage.filter_by_source_voucher_no(_sourceVoucherNo);
	}

	@Step
	public void filter_by_customer(String _customer) {
		RSPage.filter_by_customer(_customer);
	}

	@Step
	public void filter_by_source_pr_no(String _sourcePRNo) {
		RSPage.filter_by_source_pr_no(_sourcePRNo);
	}

	@Step
	public void filter_by_reference_no(String _referenceNo) {
		RSPage.filter_by_reference_no(_referenceNo);
	}

	@Step
	public void filter_by_created_by(String _createdBy) {
		RSPage.filter_by_created_by(_createdBy);
	}

	@Step
	public void filter_by_created_date(String _createdDateFrom, String _createdDateTo) {
		RSPage.filter_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_by_last_updated_by(String _lastUpdatedBy) {
		RSPage.filter_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		RSPage.filter_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	@Step
	public void filter_by_posted_by(String _postedBy) {
		RSPage.filter_by_posted_by(_postedBy);
	}

	@Step
	public void filter_by_posted_date(String _postedDateFrom, String _postedDateTo) {
		RSPage.filter_by_posted_date(_postedDateFrom, _postedDateTo);
	}

	@Step
	public void open_purchase_requisition_no(String _purchaseRequisitionNo) {
		RSPage.open_purchase_requisition_no(_purchaseRequisitionNo);
	}

	@Step
	public void open_first_purchase_requisition_no() {
		RSPage.open_first_purchase_requisition_no();
	}

	// END Purchase Requisition Summary

	// BEGIN Create Purchase Requisition Draft
	@Step
	public void switch_to_tab_header() {
		RSPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_shipment() {
		RSPage.switch_to_tab_shipment();
	}

	@Step
	public void switch_to_tab_detail() {
		RSPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_remarks() {
		RSPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		RSPage.switch_to_tab_attachments();
	}

	@Step
	public void purchase_requisition_no(String _purchaseRequisitionNo) {
		System.out.println("***** INFO ***** Purchase Requisition No: " + _purchaseRequisitionNo);
	}

	// Header
	@Step
	public String get_prd_new_purchase_requisition_no() {
		return RSPage.get_prd_new_purchase_requisition_no();
	}

	@Step
	public void click_btn_prd_new_purchase_requisition_detail() {
		RSPage.click_btn_prd_new_purchase_requisition_detail();
	}

	@Step
	public void click_btn_prd_submit_purchase_requisition_detail() {
		RSPage.click_btn_prd_submit_purchase_requisition_detail();
	}

	@Step
	public void click_btn_yes_on_confirm_submit() {
		RSPage.click_btn_yes_on_confirm_submit();
	}

	// Preview report
	@Step
	public void click_btn_prd_preview() {
		RSPage.click_btn_prd_preview();
	}

	@Step
	public boolean is_display_reports_selection() {
		return RSPage.is_display_reports_selection();
	}

	@Step
	public void open_report_by_report_title(String reportTitle) {
		RSPage.open_report_by_report_title(reportTitle);
	}

	@Step
	public int count_text_sections_in_report() {
		return RSPage.count_text_sections_in_report();
	}

	@Step
	public boolean switch_to_preview_report_window() {
		return RSPage.switch_to_preview_report_window(10);
	}

	@Step
	public boolean verify_preview_report_content(String _givenContent) {
		return RSPage.verify_preview_report_content(_givenContent);
	}

	@Step
	public String getCurrentWindowHandle() {
		return RSPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return RSPage.switchToWindowHandle(_handle);
	}

	@Step
	public String get_reports_title_list_then_done() {
		return RSPage.get_reports_title_list_then_done();
	}

	@Step
	public void click_btn_no_on_confirm_submit() {
		RSPage.click_btn_no_on_confirm_submit();
	}

	@Step
	public void click_btn_prd_back_to_summary() {
		RSPage.click_btn_prd_back_to_summary();
	}

	@Step
	public void click_btn_prd_abort() {
		RSPage.click_btn_prd_abort();
	}

	@Step
	public void click_btn_prd_copy() {
		RSPage.click_btn_prd_copy();
	}

	@Step
	public void enter_prd_copy_from(String _copyFrom) {
		RSPage.enter_prd_copy_from(_copyFrom);
	}

	@Step
	public void enter_prd_requestor(String _requestor) {
		RSPage.enter_prd_requestor(_requestor);
	}

	@Step
	public String get_prd_requestor_name() {
		return RSPage.get_prd_requestor_name();
	}

	@Step
	public String get_user_login_name() {
		return RSPage.getLoginUserName();
	}

	@Step
	public void enter_prd_header_purchase_requisition_date(String _purchaseRequisitionDate) {
		RSPage.enter_prd_header_purchase_requisition_date(_purchaseRequisitionDate);
	}

	@Step
	public String get_prd_header_source_voucher_no() {
		return RSPage.get_prd_header_source_voucher_no();
	}

	@Step
	public String get_prd_header_customer() {
		return RSPage.get_prd_header_customer();
	}

	@Step
	public String get_prd_header_source_pr_no() {
		return RSPage.get_prd_header_source_pr_no();
	}

	@Step
	public void enter_prd_header_reference_no(String _referenceNo) {
		RSPage.enter_prd_header_reference_no(_referenceNo);
	}

	@Step
	public void enter_prd_header_subject(String _subject) {
		RSPage.enter_prd_header_subject(_subject);
	}

	@Step
	public void enter_prd_header_segment_1(String _segment1) {
		RSPage.enter_prd_header_segment_1(_segment1);
	}

	@Step
	public void enter_prd_header_segment_2(String _segment2) {
		RSPage.enter_prd_header_segment_2(_segment2);
	}

	@Step
	public void enter_prd_header_segment_3(String _segment3) {
		RSPage.enter_prd_header_segment_3(_segment3);
	}

	@Step
	public void enter_prd_header_segment_4(String _segment4) {
		RSPage.enter_prd_header_segment_4(_segment4);
	}

	// Shipment
	@Step
	public void enter_prd_shi_ship_to_location(String _shipToLocation) {
		RSPage.enter_prd_shi_ship_to_location(_shipToLocation);
	}

	@Step
	public void enter_prd_shi_shipment_mode(String _shipmentMode) {
		RSPage.enter_prd_shi_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_prd_shi_shipment_term(String _shipmentTerm) {
		RSPage.enter_prd_shi_shipment_term(_shipmentTerm);
	}

	@Step
	public void enter_prd_shi_port_of_loading(String _portOfLoading) {
		RSPage.enter_prd_shi_port_of_loading(_portOfLoading);
	}

	@Step
	public void enter_prd_shi_port_of_discharge(String _portOfDischarge) {
		RSPage.enter_prd_shi_port_of_discharge(_portOfDischarge);
	}

	@Step
	public void enter_prd_shi_port_of_final_destination(String _portOfFinalDestination) {
		RSPage.enter_prd_shi_port_of_final_destination(_portOfFinalDestination);
	}

	@Step
	public String get_prd_shi_country_of_loading() {
		return RSPage.get_prd_shi_country_of_loading();
	}

	@Step
	public String enter_prd_shi_country_of_discharge() {
		return RSPage.enter_prd_shi_country_of_discharge();
	}

	@Step
	public String enter_prd_shi_country_of_final_destination() {
		return RSPage.enter_prd_shi_country_of_final_destination();
	}

	@Step
	public void enter_prd_shi_ship_through(String _shipThrough) {
		RSPage.enter_prd_shi_ship_through(_shipThrough);
	}

	@Step
	public void enter_prd_shi_no_of_shipment(String _noOfShipment) {
		RSPage.enter_prd_shi_no_of_shipment(_noOfShipment);
	}

	@Step
	public void enter_prd_shi_no(String _no) {
		RSPage.enter_prd_shi_no(_no);
	}

	@Step
	public void enter_prd_shi_required_arrival_date(int _rowIndex, String _requiredArrivalDate) {
		RSPage.enter_prd_shi_required_arrival_date(_rowIndex, _requiredArrivalDate);
	}

	@Step
	public void select_prd_shi_shipment_priority(int _rowIndex, String _shipmentPriority) {
		RSPage.select_prd_shi_shipment_priority(_rowIndex, _shipmentPriority);
	}

	// Remarks
	@Step
	public void enter_prd_rem_internal_remarks_code(String _internalRemarksCode) {
		RSPage.enter_prd_rem_internal_remarks_code(_internalRemarksCode);
	}

	@Step
	public void enter_prd_rem_external_remarks_code(String _externalRemarksCode) {
		RSPage.enter_prd_rem_external_remarks_code(_externalRemarksCode);
	}

	@Step
	public void enter_prd_rem_internal_remarks(String _internalRemarks) {
		RSPage.enter_prd_rem_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_prd_rem_external_remarks(String _externalRemarks) {
		RSPage.enter_prd_rem_external_remarks(_externalRemarks);
	}

	// Detail
	@Step
	public void click_btn_prd_detail_add() {
		RSPage.click_btn_prd_detail_add();
	}

	@Step
	public void click_btn_prd_detail_delete_detail() {
		RSPage.click_btn_prd_detail_delete_detail();
	}

	@Step
	public void click_btn_prd_detail_browse_pick_detail() {
		RSPage.click_btn_prd_detail_browse_pick_detail();
	}

	@Step
	public int get_prd_detail_row_by_no(String _no) {
		return RSPage.get_prd_detail_row_by_no(_no);
	}

	@Step
	public void select_prd_detail_type(int _rowIndex, String _type) {
		RSPage.select_prd_detail_type(_rowIndex, _type);
	}

	@Step
	public void enter_prd_detail_item_code(int _rowIndex, String _itemCode) {
		RSPage.enter_prd_detail_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void enter_prd_detail_item_remarks_by_icon(int _rowIndex, String _itemRemarks) {
		RSPage.enter_prd_detail_item_remarks_by_icon(_rowIndex, _itemRemarks);
	}

	@Step
	public void enter_prd_detail_item_remarks_by_text_area(int _rowIndex, String _itemRemarks) {
		RSPage.enter_prd_detail_item_remarks_by_text_area(_rowIndex, _itemRemarks);
	}

	@Step
	public void enter_prd_detail_qty(int _rowIndex, String _qty) {
		RSPage.enter_prd_detail_qty(_rowIndex, _qty);
	}

	@Step
	public String get_prd_detail_UOM(int _rowIndex) {
		return RSPage.get_prd_detail_UOM(_rowIndex);
	}

	@Step
	public void open_prd_detail_pr_supplier_alloc_segments_by_icon(int _rowIndex) {
		RSPage.open_prd_detail_pr_supplier_alloc_segments_by_icon(_rowIndex);
	}

	// Supplier For All Line Items
	@Step
	public void enter_prd_detail_supplier_all_line(String _supplierForAllLine) {
		RSPage.enter_prd_detail_supplier_all_line(_supplierForAllLine);
	}

	@Step
	public void enter_prd_detail_currency_all_line(String _currencyForAllLine) {
		RSPage.enter_prd_detail_currency_all_line(_currencyForAllLine);
	}

	@Step
	public void click_btn_prd_detail_add_supplier_all_line(String _currencyForAllLine) {
		RSPage.click_btn_prd_detail_add_supplier_all_line(_currencyForAllLine);
	}

	// Project For Service Line Items
	@Step
	public void enter_prd_detail_project_no_all_line(String _projectNoForAllLine) {
		RSPage.enter_prd_detail_project_no_all_line(_projectNoForAllLine);
	}

	@Step
	public void click_btn_prd_detail_auto_allocate_project_all_line(String _currencyForAllLine) {
		RSPage.click_btn_prd_detail_auto_allocate_project_all_line(_currencyForAllLine);
	}

	// Line Item Information
	@Step
	public void open_prd_detail_panel_line_item_information(int _rowIndex) {
		RSPage.open_prd_detail_panel_line_item_information(_rowIndex);
	}

	@Step
	public void switch_to_tab_prd_detail_supplier() {
		RSPage.switch_to_tab_prd_detail_supplier();
	}

	@Step
	public void switch_to_tab_prd_detail_allocation() {
		RSPage.switch_to_tab_prd_detail_allocation();
	}

	@Step
	public void click_btn_prd_detail_lii_supplier_add() {
		RSPage.click_btn_prd_detail_lii_supplier_add();
	}

	@Step
	public void enter_prd_detail_lii_supplier_new_supplier(String _supplier) {
		RSPage.enter_prd_detail_lii_supplier_new_supplier(_supplier);
	}

	@Step
	public String get_prd_detail_lii_supplier_new_type() {
		return RSPage.get_prd_detail_lii_supplier_new_type();
	}

	@Step
	public String get_prd_detail_lii_supplier_new_voucher_no() {
		return RSPage.get_prd_detail_lii_supplier_new_voucher_no();
	}

	@Step
	public String get_prd_detail_lii_supplier_new_voucher_date() {
		return RSPage.get_prd_detail_lii_supplier_new_voucher_date();
	}

	@Step
	public void select_prd_detail_lii_supplier_new_ccy(String _ccy) {
		RSPage.select_prd_detail_lii_supplier_new_ccy(_ccy);
	}

	@Step
	public void select_prd_detail_lii_supplier_new_cost_type(String _costType) {
		RSPage.select_prd_detail_lii_supplier_new_cost_type(_costType);
	}

	@Step
	public void enter_prd_detail_lii_supplier_new_unit_cost_ref(String _unitCostRef) {
		RSPage.enter_prd_detail_lii_supplier_new_unit_cost_ref(_unitCostRef);
	}

	@Step
	public void enter_prd_detail_lii_supplier_new_unit_cost_new(String _unitCostNew) {
		RSPage.enter_prd_detail_lii_supplier_new_unit_cost_new(_unitCostNew);
	}

	@Step
	public void enter_prd_detail_lii_supplier_new_disc_percent(String _discountPercent) {
		RSPage.enter_prd_detail_lii_supplier_new_disc_percent(_discountPercent);
	}

	@Step
	public void enter_prd_detail_lii_supplier_new_disc_amt(String _discountAmount) {
		RSPage.enter_prd_detail_lii_supplier_new_disc_amt(_discountAmount);
	}

	@Step
	public void select_prd_detail_lii_supplier_new_tax(String _Tax) {
		RSPage.select_prd_detail_lii_supplier_new_tax(_Tax);
	}

	@Step
	public String get_prd_detail_lii_supplier_new_tax_amount() {
		return RSPage.get_prd_detail_lii_supplier_new_tax_amount();
	}

	// Allocation
	@Step
	public void open_prd_detail_lii_allocation(int _rowIndex) {
		RSPage.open_prd_detail_lii_allocation(_rowIndex);
	}

	@Step
	public void click_btn_prd_detail_lii_allocation_add() {
		RSPage.click_btn_prd_detail_lii_allocation_add();
	}

	@Step
	public int get_prd_detail_lii_allocation_allocation_no(String _allocationNo) {
		return RSPage.get_prd_detail_lii_allocation_allocation_no(_allocationNo);
	}

	@Step
	public String get_prd_detail_lii_allocation_type(int _rowIndex) {
		return RSPage.get_prd_detail_lii_allocation_type(_rowIndex);
	}

	@Step
	public String get_prd_detail_lii_allocation_customer_job_no(int _rowIndex) {
		return RSPage.get_prd_detail_lii_allocation_customer_job_no(_rowIndex);
	}

	@Step
	public String get_prd_detail_lii_allocation_schedule_no(int _rowIndex) {
		return RSPage.get_prd_detail_lii_allocation_schedule_no(_rowIndex);
	}

	@Step
	public void enter_prd_detail_lii_allocation_voucher_no(int _rowIndex, String _voucherNo) {
		RSPage.enter_prd_detail_lii_allocation_voucher_no(_rowIndex, _voucherNo);
	}

	@Step
	public void enter_prd_detail_lii_allocation_phase_no(int _rowIndex, String _phaseNo) {
		RSPage.enter_prd_detail_lii_allocation_phase_no(_rowIndex, _phaseNo);
	}

	@Step
	public void enter_prd_detail_lii_allocation_line_item_no(int _rowIndex, String _lineItemNo) {
		RSPage.enter_prd_detail_lii_allocation_line_item_no(_rowIndex, _lineItemNo);
	}

	@Step
	public void enter_prd_detail_lii_allocation_alloc_qty(int _rowIndex, String _allocQty) {
		RSPage.enter_prd_detail_lii_allocation_alloc_qty(_rowIndex, _allocQty);
	}

	// Payment Request
	@Step
	public void select_prd_payreq_is_payment_request(String _isPaymentRequest) {
		RSPage.select_prd_payreq_is_payment_request(_isPaymentRequest);
	}

	@Step
	public void enter_prd_payreq_supplier_invoice_no(String _supplierInvoiceNo) {
		RSPage.enter_prd_payreq_supplier_invoice_no(_supplierInvoiceNo);
	}

	@Step
	public void select_prd_payreq_charge_party(String _chargeParty) {
		RSPage.select_prd_payreq_charge_party(_chargeParty);
	}

	@Step
	public void enter_prd_payreq_remarks(String _remarks) {
		RSPage.enter_prd_payreq_remarks(_remarks);
	}

	// Allocation Detail
	// TODO
	// Attachment
	@Step
	public void click_btn_add_attachment() {
		RSPage.click_btn_add_attachment();
	}

	@Step
	public void click_btn_delete_attachment() {
		RSPage.click_btn_delete_attachment();
	}

	@Step
	public void click_btn_cancel_attachment() {
		RSPage.click_btn_cancel_attachment();
	}

	@Step
	public void choose_attachment_file(String _filePath) {
		RSPage.choose_attachment_file(_filePath);
	}

	@Step
	public int get_att_row_by_no(String _AttachmentNo) {
		return RSPage.get_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_upload_attachment() {
		RSPage.click_btn_upload_attachment();
	}

	@Step
	public void enter_file_description(int _rowIndex, String _fileDescription) {
		RSPage.enter_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_new_file_mime_type(int _rowIndex) {
		return RSPage.get_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_new_file_file_size(int _rowIndex) {
		return RSPage.get_new_file_file_size(_rowIndex);
	}

	// END Purchase Requisition Draft
	// BEGIN Purchase Requisition Cost Confirmation
	@Step
	public void click_btn_prcc_preview() {
		RSPage.click_btn_prcc_preview();
	}

	@Step
	public String get_prcc_list_report_title_file_then_click_done() {
		return RSPage.get_prcc_list_report_title_file_then_click_done();
	}

	@Step
	public void click_btn_prcc_submit() {
		RSPage.click_btn_prcc_submit();
	}

	@Step
	public void clickBtnYesOnPRCCConfirmSubmit() {
		RSPage.clickBtnYesOnPRCCConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnPRCCConfirmSubmit() {
		RSPage.clickBtnNoOnPRCCConfirmSubmit();
	}

	@Step
	public int get_prcc_detail_row_by_no(String _no) {
		return RSPage.get_prcc_detail_row_by_no(_no);
	}

	// Line Item Information
	@Step
	public void open_prcc_detail_panel_line_item_information(int _rowIndex) {
		RSPage.open_prcc_detail_panel_line_item_information(_rowIndex);
	}

	@Step
	public void switch_to_tab_prcc_detail_supplier() {
		RSPage.switch_to_tab_prcc_detail_supplier();
	}

	@Step
	public void switch_to_tab_prcc_detail_allocation() {
		RSPage.switch_to_tab_prcc_detail_allocation();
	}

	@Step
	public void click_btn_prcc_detail_lii_supplier_add() {
		RSPage.click_btn_prcc_detail_lii_supplier_add();
	}

	@Step
	public void enter_prcc_detail_lii_supplier_new_supplier(String _supplier) {
		RSPage.enter_prcc_detail_lii_supplier_new_supplier(_supplier);
	}

	@Step
	public String get_prcc_detail_lii_supplier_new_type() {
		return RSPage.get_prcc_detail_lii_supplier_new_type();
	}

	@Step
	public String get_prcc_detail_lii_supplier_new_voucher_no() {
		return RSPage.get_prcc_detail_lii_supplier_new_voucher_no();
	}

	@Step
	public String get_prcc_detail_lii_supplier_new_voucher_date() {
		return RSPage.get_prcc_detail_lii_supplier_new_voucher_date();
	}

	@Step
	public void select_prcc_detail_lii_supplier_new_ccy(String _ccy) {
		RSPage.select_prcc_detail_lii_supplier_new_ccy(_ccy);
	}

	@Step
	public void select_prcc_detail_lii_supplier_new_cost_type(String _costType) {
		RSPage.select_prcc_detail_lii_supplier_new_cost_type(_costType);
	}

	@Step
	public void enter_prcc_detail_lii_supplier_new_unit_cost_ref(String _unitCostRef) {
		RSPage.enter_prcc_detail_lii_supplier_new_unit_cost_ref(_unitCostRef);
	}

	@Step
	public void enter_prcc_detail_lii_supplier_new_unit_cost_new(String _unitCostNew) {
		RSPage.enter_prcc_detail_lii_supplier_new_unit_cost_new(_unitCostNew);
	}

	@Step
	public void enter_prcc_detail_lii_supplier_new_disc_percent(String _discountPercent) {
		RSPage.enter_prcc_detail_lii_supplier_new_disc_percent(_discountPercent);
	}

	@Step
	public void enter_prcc_detail_lii_supplier_new_disc_amt(String _discountAmount) {
		RSPage.enter_prcc_detail_lii_supplier_new_disc_amt(_discountAmount);
	}

	@Step
	public void select_prcc_detail_lii_supplier_new_tax(String _Tax) {
		RSPage.select_prcc_detail_lii_supplier_new_tax(_Tax);
	}

	@Step
	public String get_prcc_detail_lii_supplier_new_tax_amount() {
		return RSPage.get_prcc_detail_lii_supplier_new_tax_amount();
	}

	@Step
	public void set_prcc_detail_lii_supplier_pref_sup(String _prefSup) {
		RSPage.set_prcc_detail_lii_supplier_pref_sup(_prefSup);
	}

	@Step
	public void open_prcc_detail_lii_allocation(int _rowIndex) {
		RSPage.open_prcc_detail_lii_allocation(_rowIndex);
	}

	@Step
	public void click_btn_prcc_detail_lii_allocation_add() {
		RSPage.click_btn_prcc_detail_lii_allocation_add();
	}

	@Step
	public int get_prcc_detail_lii_allocation_allocation_no(String _allocationNo) {
		return RSPage.get_prcc_detail_lii_allocation_allocation_no(_allocationNo);
	}

	@Step
	public String get_prcc_detail_lii_allocation_type(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_type(_rowIndex);
	}

	@Step
	public String get_prcc_detail_lii_allocation_customer_job_no(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_customer_job_no(_rowIndex);
	}

	@Step
	public String get_prcc_detail_lii_allocation_schedule_no(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_schedule_no(_rowIndex);
	}

	@Step
	public String get_prcc_detail_lii_allocation_voucher_no(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_voucher_no(_rowIndex);
	}

	@Step
	public void enter_prcc_detail_lii_allocation_voucher_no(int _rowIndex, String _voucherNo) {
		RSPage.enter_prcc_detail_lii_allocation_voucher_no(_rowIndex, _voucherNo);
	}

	@Step
	public String get_prcc_detail_lii_allocation_phase_no(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_phase_no(_rowIndex);
	}

	@Step
	public void enter_prcc_detail_lii_allocation_phase_no(int _rowIndex, String _phaseNo) {
		RSPage.enter_prcc_detail_lii_allocation_phase_no(_rowIndex, _phaseNo);
	}

	@Step
	public String get_prcc_detail_lii_allocation_line_item_no(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_line_item_no(_rowIndex);
	}

	@Step
	public void enter_prcc_detail_lii_allocation_line_item_no(int _rowIndex, String _lineItemNo) {
		RSPage.enter_prcc_detail_lii_allocation_line_item_no(_rowIndex, _lineItemNo);
	}

	@Step
	public String get_prcc_detail_lii_allocation_alloc_qty(int _rowIndex) {
		return RSPage.get_prcc_detail_lii_allocation_alloc_qty(_rowIndex);
	}

	@Step
	public void enter_prcc_detail_lii_allocation_alloc_qty(int _rowIndex, String _allocQty) {
		RSPage.enter_prcc_detail_lii_allocation_alloc_qty(_rowIndex, _allocQty);
	}
	// Line Item Information
	// END Purchase Requisition Cost Confirmation
}
