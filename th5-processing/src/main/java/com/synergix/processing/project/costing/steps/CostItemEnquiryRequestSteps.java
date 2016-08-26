package com.synergix.processing.project.costing.steps;

import com.synergix.processing.project.costing.pages.CostItemEnquiryRequestPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160415
 */
public class CostItemEnquiryRequestSteps extends ScenarioSteps {
	CostItemEnquiryRequestPage CIERPage;

	// Cost Item Enquiry & Request
	@Step
	public void filter_by_project_no(String _projectNo) {
		CIERPage.filter_by_project_no(_projectNo);
	}

	@Step
	public void filter_by_customer_name(String _customerName) {
		CIERPage.filter_by_customer_name(_customerName);
	}

	@Step
	public void filter_by_customer_job_no(String _customerJobNo) {
		CIERPage.filter_by_customer_job_no(_customerJobNo);
	}

	@Step
	public void filter_by_sales_person(String _salesPerson) {
		CIERPage.filter_by_sales_person(_salesPerson);
	}

	@Step
	public void filter_by_sales_manager(String _salesManager) {
		CIERPage.filter_by_sales_manager(_salesManager);
	}

	@Step
	public void filter_by_subject(String _subject) {
		CIERPage.filter_by_subject(_subject);
	}

	@Step
	public void filter_by_start_date(String _startDateFrom, String _startDateTo) {
		CIERPage.filter_by_start_date(_startDateFrom, _startDateTo);
	}

	@Step
	public void filter_by_end_date(String _endDateFrom, String _endDateTo) {
		CIERPage.filter_by_end_date(_endDateFrom, _endDateTo);
	}

	@Step
	public void open_project_no(String _projectNo) {
		CIERPage.open_project_no(_projectNo);
	}

	@Step
	public void open_first_project_no() {
		CIERPage.open_first_project_no();
	}

	@Step
	public void click_btn_back_to_summary() {
		CIERPage.click_btn_back_to_summary();
	}

	// BEGIN Cost Item Enquiry
	@Step
	public void click_btn_request_balance_budgeted_qty() {
		CIERPage.click_btn_request_balance_budgeted_qty();
	}

	@Step
	public void click_btn_add_items_to_request() {
		CIERPage.click_btn_add_items_to_request();
	}

	@Step
	public void click_btn_yes_on_confirm_add_items_to_request() {
		CIERPage.click_btn_yes_on_confirm_add_items_to_request();
	}

	@Step
	public void click_btn_no_on_confirm_add_items_to_request() {
		CIERPage.click_btn_no_on_confirm_add_items_to_request();
	}

	@Step
	public int get_cie_row_index_by_no(String _No) {
		return CIERPage.get_cie_row_index_by_no(_No);
	}

	@Step
	public String get_cie_type(int _rowIndex) {
		return CIERPage.get_cie_type(_rowIndex);
	}

	@Step
	public String get_cie_item_code(int _rowIndex) {
		return CIERPage.get_cie_item_code(_rowIndex);
	}

	@Step
	public void click_on_cie_qty_to_request(int _rowIndex) {
		CIERPage.click_on_cie_qty_to_request(_rowIndex);
	}

	@Step
	public void set_checkbox_cie_sel(int _rowIndex, String _value) {
		CIERPage.set_checkbox_cie_sel(_rowIndex, _value);
	}

	@Step
	public int get_cie_qtrbdbp_row_index_by_phase_no(String _phaseNo) {
		return CIERPage.get_cie_qtrbdbp_row_index_by_phase_no(_phaseNo);
	}

	@Step
	public void enter_cie_qtrbdbp_qty_to_request(int _rowIndex, String _qtyToRequest) {
		CIERPage.enter_cie_qtrbdbp_qty_to_request(_rowIndex, _qtyToRequest);
	}
	// END Cost Item Enquiry

	// BEGIN Cost Item Request Summary
	@Step
	public void click_btn_create_blank_new_request() {
		CIERPage.click_btn_create_blank_new_request();
	}

	@Step
	public void switch_to_tab_request_draft() {
		CIERPage.switch_to_tab_request_draft();
	}

	@Step
	public void switch_to_tab_request_history() {
		CIERPage.switch_to_tab_request_history();
	}

	// END Cost Item Request Summary
	// BEGIN Cost Item Request Draft
	@Step
	public void click_btn_cird_submit() {
		CIERPage.click_btn_cird_submit();
	}

	@Step
	public String get_cird_request_voucher_no() {
		return CIERPage.get_cird_request_voucher_no();
	}

	@Step
	public void request_voucher_no(String _requestVoucherNo) {
		System.out.println("***** INFO ***** Request Voucher No.: " + _requestVoucherNo);
	}

	@Step
	public String get_cird_purchase_requisition_voucher_no() {
		return CIERPage.get_cird_purchase_requisition_voucher_no();
	}

	@Step
	public void purchase_requisition_voucher_no(String _shipmentNo) {
		System.out.println("***** INFO ***** Purchase Requisition Voucher: " + _shipmentNo);
	}

	@Step
	public void click_cird_btn_ok_infor_panel_message() {
		CIERPage.click_cird_btn_ok_infor_panel_message();
	}

	@Step
	public void click_btn_cird_yes_on_confirm_submit() {
		CIERPage.click_btn_cird_yes_on_confirm_submit();
	}

	@Step
	public void click_btn_cird_no_on_confirm_submit() {
		CIERPage.click_btn_cird_no_on_confirm_submit();
	}

	@Step
	public void switch_to_tab_cird_detail() {
		CIERPage.switch_to_tab_cird_detail();
	}

	@Step
	public void switch_to_tab_remarks() {
		CIERPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		CIERPage.switch_to_tab_attachments();
	}

	@Step
	public void enter_cird_request_shipment_date(String _requestShipmentDate) {
		CIERPage.enter_cird_request_shipment_date(_requestShipmentDate);
	}

	@Step
	public void enter_cird_requested_by(String _requestedBy) {
		CIERPage.enter_cird_requested_by(_requestedBy);
	}

	@Step
	public void enter_cird_sbu(String _sbu) {
		CIERPage.enter_cird_sbu(_sbu);
	}

	@Step
	public void enter_cird_contact_person(String _contactPerson) {
		CIERPage.enter_cird_contact_person(_contactPerson);
	}

	// Detail
	@Step
	public void click_btn_cird_add() {
		CIERPage.click_btn_cird_add();
	}

	@Step
	public int get_cird_det_row_index_by_no(String _No) {
		return CIERPage.get_cird_det_row_index_by_no(_No);
	}

	@Step
	public void select_cird_det_type(int _rowIndex, String _type) {
		CIERPage.select_cird_det_type(_rowIndex, _type);
	}

	@Step
	public void enter_cird_det_item_code(int _rowIndex, String _itemCode) {
		CIERPage.enter_cird_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void click_on_cird_det_qty_to_request(int _rowIndex) {
		CIERPage.click_on_cird_det_qty_to_request(_rowIndex);
	}

	// Qty To Request Break Down By Phase
	@Step
	public void click_btn_cird_qtrbdbp_add() {
		CIERPage.click_btn_cird_qtrbdbp_add();
	}

	@Step
	public int get_cird_qtrbdbp_row_index_by_phase_no(String _phaseNo) {
		return CIERPage.get_cird_qtrbdbp_row_index_by_phase_no(_phaseNo);
	}

	@Step
	public void enter_cird_qtrbdbp_new_phase_no(String _phaseNo) {
		CIERPage.enter_cird_qtrbdbp_new_phase_no(_phaseNo);
	}

	@Step
	public void enter_cird_qtrbdbp_qty_to_request(int _rowIndex, String _qtyToRequest) {
		CIERPage.enter_cird_qtrbdbp_qty_to_request(_rowIndex, _qtyToRequest);
	}
	// END Cost Item Request Draft
	// Cost Item Enquiry & Request

}
