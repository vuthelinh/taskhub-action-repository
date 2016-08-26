package com.synergix.processing.project.costing.pages;

import com.synergix.common.TH5PageObject;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vincent
 * @version 20160415
 */
public class CostItemEnquiryRequestPage extends TH5PageObject {
	public CostItemEnquiryRequestPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Cost Item Enquiry & Request";
	// #Region#Page Action
	// Cost Item Enquiry & Request
	private String xPathPanelProject = "//form/table[contains(@id,'ostProjectsTable')]";

	public void filter_by_project_no(String _projectNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelProject, "Project No."), _projectNo);
	}

	public void filter_by_customer_name(String _customerName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelProject, "Customer Name"), _customerName);
	}

	public void filter_by_customer_job_no(String _customerJobNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelProject, "Customer Job No."), _customerJobNo);
	}

	public void filter_by_sales_person(String _salesPerson) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelProject, "Sales Person"), _salesPerson);
	}

	public void filter_by_sales_manager(String _salesManager) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelProject, "Sales Manager"), _salesManager);
	}

	public void filter_by_subject(String _subject) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelProject, "Subject"), _subject);
	}

	public void filter_by_start_date(String _startDateFrom, String _startDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelProject, "Start Date From To"), _startDateFrom,
				_startDateTo);
	}

	public void filter_by_end_date(String _endDateFrom, String _endDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelProject, "End Date From To"), _endDateFrom, _endDateTo);
	}

	public void open_project_no(String _projectNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelProject, "Project No.", 1, _projectNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelProject, "Project No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelProject, rowIndex, headerIndex) + "//a");
	}

	public void open_first_project_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelProject, "Project No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelProject, 1, headerIndex) + "//a");
	}

	public void click_btn_back_to_summary() {
		clickBtn("Back To Summary");
	}

	// BEGIN Cost Item Enquiry
	private String xPathPanelCostItemEnquuiry = "(//div[text()='Cost Item Enquiry']//ancestor::div[contains(@class,'rich-panel')][1])[1]";

	public void click_btn_request_balance_budgeted_qty() {
		clickBtn("Request Balance Budgeted Qty");
	}

	public void click_btn_add_items_to_request() {
		clickBtn("Add Items to Request");
		click_btn_yes_on_confirm_add_items_to_request();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmAddSelectItemToCurrentRequestVoucher = "//div["
			+ sSpecialTextPredicates("Add Select Items to Current Request Voucher")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_yes_on_confirm_add_items_to_request() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmAddSelectItemToCurrentRequestVoucher)
				.shouldBeVisible();
		clickBtn(xPathPanelConfirmAddSelectItemToCurrentRequestVoucher, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmAddSelectItemToCurrentRequestVoucher);
	}

	public void click_btn_no_on_confirm_add_items_to_request() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmAddSelectItemToCurrentRequestVoucher)
				.shouldBeVisible();
		clickBtn(xPathPanelConfirmAddSelectItemToCurrentRequestVoucher, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmAddSelectItemToCurrentRequestVoucher);
	}

	private String xPathTbCostItemEnquiry = "//table[contains(@id,'pjCostItemEnquiry')]";

	public int get_cie_row_index_by_no(String _No) {
		return searchInTbMultiPage(xPathTbCostItemEnquiry, "No.", 1, _No, true);
	}

	public String get_cie_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbCostItemEnquiry, "Type");
		return waitElementToBePresentThenScrollIntoView(
				xPathTbDataCellByPosition(xPathTbCostItemEnquiry, _rowIndex, headerIndex)).getText();
	}

	public String get_cie_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbCostItemEnquiry, "Item Code");
		return waitElementToBePresentThenScrollIntoView(
				xPathTbDataCellByPosition(xPathTbCostItemEnquiry, _rowIndex, headerIndex)).getText();
	}

	public void click_on_cie_qty_to_request(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathTbCostItemEnquiry, "Qty To Request");
		clickOnElement(xPathTbDataCellByPosition(xPathTbCostItemEnquiry, _rowIndex, colIndex) + "//a");
	}

	public void set_checkbox_cie_sel(int _rowIndex, String _value) {
		int colIndex = getTbColHeaderIndex(xPathTbCostItemEnquiry, "Sel");

		if (_value.toLowerCase().equals("true") || _value.toLowerCase().equals("yes")
				|| _value.toLowerCase().equals("y")) {
			setCheckbox(waitElementToBeClickable(xPathTbDataCellByPosition(xPathTbCostItemEnquiry, _rowIndex, colIndex)
					+ "//input[@type='checkbox']"), true);
		} else {
			setCheckbox(waitElementToBeClickable(xPathTbDataCellByPosition(xPathTbCostItemEnquiry, _rowIndex, colIndex)
					+ "//input[@type='checkbox']"), false);
		}

	}

	private String xPathTbCIEQtyToRequestBreakDownByPhase = xPathPanelCostItemEnquuiry
			+ "//*[text()='Qty To Request Break Down By Phase']//ancestor::fieldset[1]";

	public int get_cie_qtrbdbp_row_index_by_phase_no(String _phaseNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextInCol(xPathTbCIEQtyToRequestBreakDownByPhase, _phaseNo, 1,
				getTbColHeaderIndex(xPathTbCIEQtyToRequestBreakDownByPhase, "Phase No.")));
	}

	public void enter_cie_qtrbdbp_qty_to_request(int _rowIndex, String _qtyToRequest) {
		int headerIndex = getTbColHeaderIndex(xPathTbCIEQtyToRequestBreakDownByPhase, "Qty To Request");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbCIEQtyToRequestBreakDownByPhase, _rowIndex, headerIndex) + "//input",
				_qtyToRequest);
	}

	// END Cost Item Enquiry

	// BEGIN Cost Item Request Summary
	private String xPathPanelCostItemRequestSummary = "(//div[text()='Cost Item Request Summary']//ancestor::div[contains(@class,'rich-panel')][1])[1]";

	public void click_btn_create_blank_new_request() {
		clickBtn(xPathPanelCostItemRequestSummary, "Create Blank New Request");
		waitForAllJSCompletes();
	}

	public void switch_to_tab_request_draft() {
		switch_to_tab("Request Draft");
	}

	public void switch_to_tab_request_history() {
		switch_to_tab("Request History");
	}

	// END Cost Item Request Summary
	// BEGIN Cost Item Request Draft
	private String xPathPanelCostItemRequestDraft = "(//div[text()='Cost Item Request Draft']//ancestor::div[contains(@class,'rich-panel')][1])[1]";

	public void click_btn_cird_submit() {
		clickBtn(xPathPanelCostItemRequestDraft, "Submit");
		click_btn_cird_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	public String get_cird_request_voucher_no() {
		return getTextWithLabel(xPathPanelCostItemRequestDraft, "Request Voucher No.", 1);
	}

	private String xPathInfoPanelCIRDSubmitMessage = "//div[text()='Info Panel' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public String get_cird_purchase_requisition_voucher_no() {
		String sMessage = waitElementToBeVisible(
				xPathInfoPanelCIRDSubmitMessage + "//span[@class='rich-messages-label']").getText();
		System.out.println(sMessage);
		// Eg: Purchase Requisition Voucher PR00000154 is generated.
		return sMessage.replace("Purchase Requisition Voucher ", "").replace(" is generated.", "");
	}

	public void click_cird_btn_ok_infor_panel_message() {
		clickBtn(xPathInfoPanelCIRDSubmitMessage, "OK");
	}

	private String xPathPanelCIRDConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You're about to submit this request voucher.")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_cird_yes_on_confirm_submit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelCIRDConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelCIRDConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelCIRDConfirmSubmit);
	}

	public void click_btn_cird_no_on_confirm_submit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelCIRDConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelCIRDConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelCIRDConfirmSubmit);
	}

	public void switch_to_tab_cird_detail() {
		switch_to_tab(xPathPanelCostItemRequestDraft, "Detail");
	}

	public void switch_to_tab_remarks() {
		switch_to_tab(xPathPanelCostItemRequestDraft, "Remarks");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab(xPathPanelCostItemRequestDraft, "Attachments");
	}

	public void enter_cird_request_shipment_date(String _requestShipmentDate) {
		enterInputFieldWithLabel(xPathPanelCostItemRequestDraft, "Required Shipment Date", _requestShipmentDate);
	}

	public void enter_cird_requested_by(String _requestedBy) {
		enterInputFieldWithLabel(xPathPanelCostItemRequestDraft, "Requested By", _requestedBy);
	}

	public void enter_cird_sbu(String _sbu) {
		enterInputFieldWithLabel(xPathPanelCostItemRequestDraft, "SBU", _sbu);
	}

	public void enter_cird_contact_person(String _contactPerson) {
		enterInputFieldWithLabel(xPathPanelCostItemRequestDraft, "Contact Person", _contactPerson);
	}

	// Detail
	public void click_btn_cird_add() {
		clickBtn(xPathPanelCostItemRequestDraft, "Add");
		waitForAllJSCompletes();
	}

	private String xPathTbCostItemRequestDraftDetail = xPathPanelCostItemRequestDraft
			+ "//table[contains(@id,'pjCstItmRequestTbl')]";

	public int get_cird_det_row_index_by_no(String _No) {
		return searchInTbMultiPage(xPathTbCostItemRequestDraftDetail, "No.", 1, _No, true);
		// return
		// getTbRowIndexOfDataCell(xPathTbDataCellByTextInCol(xPathTbCostItemRequestDraftDetail,
		// _No, 1,
		// getTbColHeaderIndex(xPathTbCostItemRequestDraftDetail, "No.")));
	}

	public void select_cird_det_type(int _rowIndex, String _type) {
		int headerIndex = getTbColHeaderIndex(xPathTbCostItemRequestDraftDetail, "Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xPathTbCostItemRequestDraftDetail, _rowIndex, headerIndex) + "//select",
				_type);
	}

	public void enter_cird_det_item_code(int _rowIndex, String _itemCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbCostItemRequestDraftDetail, "Item Description/Remarks");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbCostItemRequestDraftDetail, _rowIndex, headerIndex) + "//input",
				_itemCode);
	}

	public void click_on_cird_det_qty_to_request(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathTbCostItemRequestDraftDetail, "Qty To Request");
		clickOnElement(xPathTbDataCellByPosition(xPathTbCostItemRequestDraftDetail, _rowIndex, colIndex) + "//a");
	}

	// Qty To Request Break Down By Phase
	private String xPathPanelCURDQtyToRequestBreakDownByPhase = xPathPanelCostItemRequestDraft
			+ "//*[text()='Qty To Request Break Down By Phase']//ancestor::fieldset[1]";

	public void click_btn_cird_qtrbdbp_add() {
		clickBtn(xPathPanelCURDQtyToRequestBreakDownByPhase, "Add");
	}

	public int get_cird_qtrbdbp_row_index_by_phase_no(String _phaseNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextInCol(xPathPanelCURDQtyToRequestBreakDownByPhase, _phaseNo,
				1, getTbColHeaderIndex(xPathPanelCURDQtyToRequestBreakDownByPhase, "Phase No.")));
	}

	public void enter_cird_qtrbdbp_new_phase_no(String _phaseNo) {
		int headerIndex = getTbColHeaderIndex(xPathPanelCURDQtyToRequestBreakDownByPhase, "Phase No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelCURDQtyToRequestBreakDownByPhase, headerIndex)
						+ "//input",
				_phaseNo);
	}

	public void enter_cird_qtrbdbp_qty_to_request(int _rowIndex, String _qtyToRequest) {
		int headerIndex = getTbColHeaderIndex(xPathPanelCURDQtyToRequestBreakDownByPhase, "Qty To Request");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelCURDQtyToRequestBreakDownByPhase, _rowIndex, headerIndex)
						+ "//input",
				_qtyToRequest);
	}
	// END Cost Item Request Draft

	// #EndRegion#Page Action
}
