package com.synergix.processing.approval.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160810
 */
public class ApprovalSummaryPage extends TH5PageObject {
	public ApprovalSummaryPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Approval Summary";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	private String xPathTbApprovalSummary = "//table[contains(@id,'approvalSummaryTable')]";

	// #Region Page Action
	public int get_approval_summary_row_index(String _givenText) {
		return getTbRowIndexOfDataCell(
				"(" + xPathTbDataRowsByAnyText(xPathTbApprovalSummary, _givenText) + ")[1]//td[1]");
	}

	public void click_on_in_queue_number_by_anytext(String _givenText) {
		int rowIndex = get_approval_summary_row_index(_givenText);
		int colIndex = getTbColHeaderIndex(xPathTbApprovalSummary, "In Queue");
		clickOnElement(xPathTbDataCellByPosition(xPathTbApprovalSummary, rowIndex, colIndex) + "//a");
	}

	// In Queue
	private String xPathPanelInqueue = "(//td[contains(@id,'inQueue')])[last()]";

	public void click_btn_submit() {
		clickBtn("Submit");
		click_btn_confirm_submit_yes();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div[contains(text(),'Submit Confirmation') and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_confirm_submit_yes() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void click_btn_confirm_submit_no() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	// BEGIN Payroll - Additional Payment(By Recipient)
	public void filter_in_queue_by_add_payment_voucher_no(String additioanlPaymentVoucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInqueue, "Additional Payment Voucher No."),
				additioanlPaymentVoucherNo);
	}

	public void filter_in_queue_by_recipient_code(String recipientCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInqueue, "Recipient Code"), recipientCode);
	}

	public void filter_in_queue_by_recipient_name(String recipientName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInqueue, "Recipient Name"), recipientName);
	}

	public void enter_in_queue_payroll_date_first_row(String payrollDate) {
		int colIndex = getTbColHeaderIndex(xPathPanelInqueue, "Payroll Date");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelInqueue, 1, colIndex) + "//input[@type='text']", payrollDate);
	}

	public void enter_in_queue_remarks_first_row(String remarks) {
		int colIndex = getTbColHeaderIndex(xPathPanelInqueue, "Remarks");
		waitTypeAndTabThenUpdateText(xPathTbDataCellByPosition(xPathPanelInqueue, 1, colIndex) + "//textarea", remarks);
	}

	// END Payroll
	public void filter_in_queue_by_pr_no(String _PRNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInqueue, "PR No."), _PRNo);
	}

	public void filter_in_queue_by_so_no(String _SONo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInqueue, "Sales Order No."), _SONo);
	}

	public void select_in_queue_action_first_row(String _action) {
		int colIndex = getTbColHeaderIndex(xPathPanelInqueue, "Action");
		selectRadioButton(xPathRadioBtnWithLabel(xPathTbDataCellByPosition(xPathPanelInqueue, 1, colIndex), _action));
	}

	public void enter_in_queue_approved_supplier_first_row(String _approvedSupplier) {
		int colIndex = getTbColHeaderIndex(xPathPanelInqueue, "Approved Supplier");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathPanelInqueue, 1, colIndex) + "//input",
				_approvedSupplier);
	}

	public void open_first_pr_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelInqueue, "PR No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelInqueue, 1, headerIndex) + "//a");
	}

	// PR Pending Approval Details
	private String xPathPanelPRPendingApprovalDetails = "//div[contains(text(),'PR Pending Approval Details') and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
	private String xPathTbPrPendingDetail = xPathPanelPRPendingApprovalDetails
			+ "//table[contains(@id,'tblPrPenDetail')]";

	public void switch_to_tab_prpad_header() {
		switch_to_tab(xPathPanelPRPendingApprovalDetails, "Header");
	}

	public void switch_to_tab_prpad_detail() {
		switch_to_tab(xPathPanelPRPendingApprovalDetails, "Detail");
	}

	public int get_prpad_row_index_by_no(String _No) {
		return searchInTbMultiPage(xPathTbPrPendingDetail, "No.", 1, _No, true);
	}

	public void open_prpad_panel_line_item_information(int _rowIndex) {
		// Click on green arrow
		clickOnElement(
				xPathTbDataCellByPosition(xPathTbPrPendingDetail, _rowIndex, 1) + "//img[contains(@src,'greenarrow')]");
	}

	// Line Item Information
	String xPathFormLineItemInformation = "(//*[contains(text(),'Line Item Information')]//ancestor-or-self::form[1])";
	// Supplier
	String xPathTbPendingSupplierDetail = xPathFormLineItemInformation
			+ "//table[contains(@id,'tblPenSupplierDetail')]";

	public void switch_to_tab_prpad_supplier() {
		switch_to_tab(xPathFormLineItemInformation, "Supplier");
	}

	public void switch_to_tab_prpad_detail_allocation() {
		switch_to_tab(xPathFormLineItemInformation, "Allocation");
	}

	public int get_prpad_supplier_row_index_by_supplier(String _supplier) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextInCol(xPathTbPendingSupplierDetail, _supplier, 1,
				getTbColHeaderIndex(xPathTbPendingSupplierDetail, "Supplier")));
	}

	public void set_prpad_supplier_approved_supplier(int rowIndex, String _approvedSupplier) {
		int colIndex = getTbColHeaderIndex(xPathTbPendingSupplierDetail, "Approved Supplier");
		setChkbox(xPathTbGetLastDataCellByHeaderIndex(xPathTbPendingSupplierDetail, colIndex)
				+ "//input[@type='checkbox']", _approvedSupplier);
	}

	public void click_btn_prpad_done() {
		clickBtn(xPathPanelPRPendingApprovalDetails, "Done");
	}
	// #EndRegion Page Action
}
