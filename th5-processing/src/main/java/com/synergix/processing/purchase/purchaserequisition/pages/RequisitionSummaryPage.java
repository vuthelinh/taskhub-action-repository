package com.synergix.processing.purchase.purchaserequisition.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160817
 */
public class RequisitionSummaryPage extends TH5PageObject {
	public RequisitionSummaryPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Requisition Summary";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Purchase Requisition Summary
	private String xPathPanelPRSummary = "(//div[text()='Purchase Requisition Summary']//ancestor::div[1]//table)[1]";

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void switch_to_tab_pending_draft() {
		switch_to_tab("Pending Draft");
	}

	public void switch_to_tab_cost_confirmation() {
		switch_to_tab("Cost Confirmation");
	}

	public void switch_to_tab_pending_approval() {
		switch_to_tab("Pending Approval");
	}

	public void switch_to_tab_history() {
		switch_to_tab("History");
	}

	// Draft tab
	public void click_btn_new_of_pr_summany() {
		clickBtn(xPathPanelPRSummary, "New");
	}

	public void filter_by_pr_no(String _PRNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "PR No."), _PRNo);
	}

	public void filter_by_pr_date(String _PRDate) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "PR Date"), _PRDate);
	}

	public void filter_by_requestor(String _requestor) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Requestor"), _requestor);
	}

	public void filter_by_type(String _type) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Type"), _type);
	}

	public void filter_by_source_voucher_no(String _sourceVoucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Source Voucher No."), _sourceVoucherNo);
	}

	public void filter_by_customer(String _customer) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Customer"), _customer);
	}

	public void filter_by_source_pr_no(String _sourcePRNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Source PR No."), _sourcePRNo);
	}

	public void filter_by_reference_no(String _referenceNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Reference No."), _referenceNo);
	}

	public void filter_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Created By"), _createdBy);
	}

	public void filter_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelPRSummary, "Created Date From To"), _createdDateFrom,
				_createdDateTo);
	}

	public void filter_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelPRSummary, "Created Date From To"), _lastUpdatedDateFrom,
				_lastUpdatedDateTo);
	}

	public void filter_by_posted_by(String _postedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelPRSummary, "Posted By"), _postedBy);
	}

	public void filter_by_posted_date(String _postedDateFrom, String _postedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelPRSummary, "Posted Date From To"), _postedDateFrom,
				_postedDateTo);
	}

	public void open_purchase_requisition_no(String _purchaseRequisitionNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelPRSummary, "PR No.", 1, _purchaseRequisitionNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelPRSummary, "PR No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelPRSummary, rowIndex, headerIndex) + "//a");
	}

	public void open_first_purchase_requisition_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelPRSummary, "PR No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelPRSummary, 1, headerIndex) + "//a");
	}
	// END Purchase Requisition Summary

	// BEGIN Create Purchase Requisition Draft
	public void switch_to_tab_header() {
		switch_to_tab("Header");
	}

	public void switch_to_tab_shipment() {
		switch_to_tab("Shipment");
	}

	public void switch_to_tab_detail() {
		switch_to_tab("Detail");
	}

	public void switch_to_tab_remarks() {
		switch_to_tab("Remarks");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
	}

	// Header
	private String xPathPanelPRDraft = "(//div[text()='Purchase Requisition Draft']//ancestor::div[contains(@class,'rich-panel')])[1]";

	public String get_prd_new_purchase_requisition_no() {
		return getTextWithLabel(xPathPanelPRDraft, "Purchase Requisition No.", 2);
	}

	public void click_btn_prd_new_purchase_requisition_detail() {
		clickBtn(xPathPanelPRDraft, "New");
	}

	public void click_btn_prd_preview() {
		clickBtn(xPathPanelPRDraft, "Preview");
	}

	// Preview Report
	private String xPathPanelReports = "//div[text()='Reports' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
	private String xPathReportTitles = xPathPanelReports + "//a";

	/**
	 * Check Reports Selection Panel display or not
	 * 
	 * @author Vincent
	 * @return
	 */
	public boolean is_display_reports_selection() {
		return isElementVisible(xPathPanelReports, 1);
	}

	public void open_report_by_report_title(String reportTitle) {
		clickOnElement(xPathPanelReports + "//a[text()='" + reportTitle + "']");
		clickBtn(xPathPanelReports, "Done");
	}

	/**
	 * Get all name of report titles
	 * 
	 * @author Vincent
	 * @return
	 */
	public String get_reports_title_list_then_done() {
		if (waitElementToBePresent(xPathPanelReports).isVisible()) {
			String sReportTitle = "";
			for (WebElementFacade el : findAll(xPathReportTitles)) {
				sReportTitle += el.getText() + System.getProperty("line.separator");
			}
			clickBtn(xPathPanelReports, "Done");
			System.out.print(sReportTitle);
			return sReportTitle;
		} else {
			return null;
		}
	}

	/**
	 * Count number of text section in report
	 * 
	 * @author Vincent
	 * @return
	 */
	public int count_text_sections_in_report() {
		int count = 0;
		String xPath = "//body//div[@class='textLayer']//*[string-length()>=1]";
		count = findAll(xPath).size();
		System.out.println("***** INFO ***** Number of text sections in report is : " + count);
		return count;
	}

	public boolean switch_to_preview_report_window(int _timeoutInSeconds) {
		int polling = 0;
		_timeoutInSeconds = _timeoutInSeconds * 1000; // Convert from second to
														// millisecond
		boolean ret = false;
		do {
			waitABit(500);
			polling += 500;
			for (String sHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(sHandle);
				if (getDriver().getTitle().contains("reportOutput.seam")) {
					ret = true;
					waitABit(1000);
					break;
				}
			}
		} while (polling < _timeoutInSeconds && ret == false);
		return ret;
	}

	public boolean verify_preview_report_content(String _givenContent) {
		String[] tokens = _givenContent.split(" ");
		int numText = tokens.length;
		String xPathSearchPattern = "";
		if (numText > 1) {
			xPathSearchPattern = "contains(*,'" + tokens[0] + "')";
			for (int i = 1; i < numText; i++) {
				xPathSearchPattern += " and contains(*,'" + tokens[i] + "')";
			}
			xPathSearchPattern = "//body[" + xPathSearchPattern + "]";
		} else {
			xPathSearchPattern = "//body[contains(*,'" + _givenContent + "')]";
		}
		if (isElementVisibleNoA4J(xPathSearchPattern, 5)) {
			return true;
		}
		return false;
	}

	// End report
	public void click_btn_prd_submit_purchase_requisition_detail() {
		clickBtn(xPathPanelPRDraft, "Submit");
		click_btn_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You are about to submit this Purchase Requisition")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_yes_on_confirm_submit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void click_btn_no_on_confirm_submit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void click_btn_prd_back_to_summary() {
		clickBtn(xPathPanelPRDraft, "Back To Summary");
	}

	public void click_btn_prd_abort() {
		clickBtn(xPathPanelPRDraft, "Abort");
	}

	public void click_btn_prd_copy() {
		clickBtn(xPathPanelPRDraft, "Copy");
	}

	public void enter_prd_copy_from(String _copyFrom) {
		enterInputFieldWithLabel("Copy From", _copyFrom);
	}

	public void enter_prd_requestor(String _requestor) {
		if (_requestor.equals("@LOGINUSERNAME@")) {
			clickSearchIconWithLabel("Requestor");
			search("Employee Name", getLoginUserName());
		} else {
			enterInputFieldWithLabel("Requestor", _requestor);
		}
	}

	public String get_prd_requestor_name() {
		return getTextWithLabel("Requestor", 2);
	}

	public void enter_prd_header_purchase_requisition_date(String _purchaseRequisitionDate) {
		enterInputFieldWithLabel("Purchase Requisition Date", _purchaseRequisitionDate);
	}

	public String get_prd_header_source_voucher_no() {
		return getTextWithLabel(xPathPanelPRDraft, "Source Voucher No.", 1);
	}

	public String get_prd_header_customer() {
		return getTextWithLabel(xPathPanelPRDraft, "Customer", 1);
	}

	public String get_prd_header_source_pr_no() {
		return getTextWithLabel(xPathPanelPRDraft, "Source PR No.", 1);
	}

	public void enter_prd_header_reference_no(String _referenceNo) {
		enterInputFieldWithLabel("Reference No.", _referenceNo);
	}

	public void enter_prd_header_subject(String _subject) {
		enterInputFieldWithLabel("Subject", _subject);
	}

	public void enter_prd_header_segment_1(String _segment1) {
		enterInputFieldWithLabel("Segment 1", _segment1);
	}

	public void enter_prd_header_segment_2(String _segment2) {
		enterInputFieldWithLabel("Segment 2", _segment2);
	}

	public void enter_prd_header_segment_3(String _segment3) {
		enterInputFieldWithLabel("Segment 3", _segment3);
	}

	public void enter_prd_header_segment_4(String _segment4) {
		enterInputFieldWithLabel("Segment 4", _segment4);
	}

	// Shipment
	public void enter_prd_shi_ship_to_location(String _shipToLocation) {
		enterInputFieldWithLabel("Ship to Location", _shipToLocation);
	}

	public void enter_prd_shi_shipment_mode(String _shipmentMode) {
		enterInputFieldWithLabel("Shipment Mode", _shipmentMode);
	}

	public void enter_prd_shi_shipment_term(String _shipmentTerm) {
		enterInputFieldWithLabel("Shipment Term", _shipmentTerm);
	}

	public void enter_prd_shi_port_of_loading(String _portOfLoading) {
		enterInputFieldWithLabel("Port of Loading", _portOfLoading);
	}

	public void enter_prd_shi_port_of_discharge(String _portOfDischarge) {
		enterInputFieldWithLabel("Port of Discharge", _portOfDischarge);
	}

	public void enter_prd_shi_port_of_final_destination(String _portOfFinalDestination) {
		enterInputFieldWithLabel("Port of Final Destination", _portOfFinalDestination);
	}

	public String get_prd_shi_country_of_loading() {
		return getTextValueWithLabel("Country of Loading", 2);
	}

	public String enter_prd_shi_country_of_discharge() {
		return getTextValueWithLabel("Country of Discharge", 2);
	}

	public String enter_prd_shi_country_of_final_destination() {
		return getTextValueWithLabel("Country of Final Destination", 2);
	}

	public void enter_prd_shi_ship_through(String _shipThrough) {
		enterInputFieldWithLabel("Ship Through", _shipThrough);
	}

	public void enter_prd_shi_no_of_shipment(String _noOfShipment) {
		enterInputFieldWithLabel("No. of Shipment", _noOfShipment);
	}

	public void enter_prd_shi_no(String _no) {
		enterInputFieldWithLabel("No.", _no);
	}

	private String xPathTbReqDate = xPathPanelPRSummary
			+ "//table[contains(@id,'tbReqDate') and contains(@class,'rich-table')]";

	public void enter_prd_shi_required_arrival_date(int _rowIndex, String _requiredArrivalDate) {
		int headerIndex = getTbColHeaderIndex(xPathTbReqDate, "Required Arrival Date");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbReqDate, _rowIndex, headerIndex) + "//input[1]", _requiredArrivalDate);
	}

	public void select_prd_shi_shipment_priority(int _rowIndex, String _shipmentPriority) {
		int headerIndex = getTbColHeaderIndex(xPathTbReqDate, "Shipment Priority");
		selectDdlByText(xPathTbDataCellByPosition(xPathTbReqDate, _rowIndex, headerIndex) + "//select",
				_shipmentPriority);
	}

	// Remarks
	public void enter_prd_rem_internal_remarks_code(String _internalRemarksCode) {
		enterInputFieldWithLabel("Internal Remarks Code", _internalRemarksCode);
	}

	public void enter_prd_rem_external_remarks_code(String _externalRemarksCode) {
		enterInputFieldWithLabel("External Remarks Code", _externalRemarksCode);
	}

	public void enter_prd_rem_internal_remarks(String _internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", _internalRemarks);
	}

	public void enter_prd_rem_external_remarks(String _externalRemarks) {
		enterTextAreaWithLabel("External Remarks", _externalRemarks);
	}

	// Detail
	String xPathPanelPRDDetail = "//form[contains(@id,'prDetailForm')]";
	String xPathTbPRDDetail = xPathPanelPRDDetail + "//table[contains(@id,'tblPrDetail')]";

	public void click_btn_prd_detail_add() {
		clickBtn(xPathPanelPRDDetail, "Add");
	}

	public void click_btn_prd_detail_delete_detail() {
		clickBtn(xPathPanelPRDDetail, "Delete");
	}

	public void click_btn_prd_detail_browse_pick_detail() {
		clickBtn(xPathPanelPRDDetail, "Browse&Pick");
	}

	public int get_prd_detail_row_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbPRDDetail, _no, 1, "No.", 1));
	}

	public void select_prd_detail_type(int _rowIndex, String _type) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "Type", 1);
		selectDdlByText(xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex) + "//select", _type);
	}

	public void enter_prd_detail_item_code(int _rowIndex, String _itemCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "Item Code");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex) + "//input",
				_itemCode);
	}

	public void enter_prd_detail_item_remarks_by_icon(int _rowIndex, String _itemRemarks) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "Item Code Remarks Description");
		enterRemarkByClickIcon(xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex)
				+ "//img[contains(@src,'remarks.gif')]", _itemRemarks);
	}

	public void enter_prd_detail_item_remarks_by_text_area(int _rowIndex, String _itemRemarks) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "Item Remarks");
		waitTypeAndTab(xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex) + "//textarea",
				_itemRemarks);
	}

	public void enter_prd_detail_qty(int _rowIndex, String _qty) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "Qty UOM");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex) + "//input",
				_qty);
	}

	public String get_prd_detail_UOM(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "Qty UOM");
		return waitElementToBeVisible(
				(xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex) + "//span[@class='display-uom']"))
						.getText();
	}

	public void open_prd_detail_pr_supplier_alloc_segments_by_icon(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbPRDDetail, "PR Supplier Alloc Segments");
		clickOnElement(
				xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, headerIndex) + "//span[@class='text-icon']");
	}

	// Supplier For All Line Items
	private String xPathPanelPRDDetailSupplierForAllLineItems = xPathPanelPRDDetail
			+ "//span[contains(@id,'supplierForAllLines')]//form[1]";

	public void enter_prd_detail_supplier_all_line(String _supplierForAllLine) {
		enterInputFieldWithLabel("Supplier", _supplierForAllLine);
	}

	public void enter_prd_detail_currency_all_line(String _currencyForAllLine) {
		enterInputFieldWithLabel("Currency", _currencyForAllLine);
	}

	public void click_btn_prd_detail_add_supplier_all_line(String _currencyForAllLine) {
		clickBtn(xPathPanelPRDDetailSupplierForAllLineItems, "Add");
	}

	// Project For Service Line Items
	private String xPathPanelPRDDetailProjectForServiceLineItems = xPathPanelPRDDetail
			+ "//span[contains(@id,'projectAllocForAllLines')]//form[1]";

	public void enter_prd_detail_project_no_all_line(String _projectNoForAllLine) {
		enterInputFieldWithLabel("Project No.", _projectNoForAllLine);
	}

	public void click_btn_prd_detail_auto_allocate_project_all_line(String _currencyForAllLine) {
		clickBtn(xPathPanelPRDDetailProjectForServiceLineItems, "Auto Allocate");
	}

	// Line Item Information
	String xPathFormLineItemInformation = "(//*[contains(text(),'Line Item Information')]//ancestor-or-self::form[1])";
	// Supplier
	String xPathFormSupplierDetail = xPathFormLineItemInformation + "//span[contains(@id,'allocationDetail')]";

	public void open_prd_detail_panel_line_item_information(int _rowIndex) {
		// Click on green arrow
		clickOnElement(
				xPathTbDataCellByPosition(xPathTbPRDDetail, _rowIndex, 1) + "//img[contains(@src,'greenarrow')]");
		waitForAllJSCompletes();
	}

	public void switch_to_tab_prd_detail_supplier() {
		switch_to_tab(xPathFormLineItemInformation, "Supplier");
	}

	public void switch_to_tab_prd_detail_allocation() {
		switch_to_tab(xPathFormLineItemInformation, "Allocation");
	}

	public void click_btn_prd_detail_lii_supplier_add() {
		clickBtn(xPathFormLineItemInformation, "Add");
	}

	public void enter_prd_detail_lii_supplier_new_supplier(String _supplier) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Supplier");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex) + "//input[@type='text']",
				_supplier);
	}

	public String get_prd_detail_lii_supplier_new_type() {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Type");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex)).getText();
	}

	public String get_prd_detail_lii_supplier_new_voucher_no() {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Voucher No.");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex)).getText();
	}

	public String get_prd_detail_lii_supplier_new_voucher_date() {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Voucher Date");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex)).getText();
	}

	public void select_prd_detail_lii_supplier_new_ccy(String _ccy) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Ccy");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex) + "//select", _ccy);
	}

	public void select_prd_detail_lii_supplier_new_cost_type(String _costType) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Cost Type");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex) + "//select", _costType);
	}

	public void enter_prd_detail_lii_supplier_new_unit_cost_ref(String _unitCostRef) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Unit Cost Ref / New");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex) + "//input[@type='text'][1]",
				_unitCostRef);
	}

	public void enter_prd_detail_lii_supplier_new_unit_cost_new(String _unitCostNew) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Unit Cost Ref / New");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex)
				+ "//input[@type='text'][last()]", _unitCostNew);
	}

	public void enter_prd_detail_lii_supplier_new_disc_percent(String _discountPercent) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Disc %/ Amt");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex) + "//input[@type='text'][1]",
				_discountPercent);
	}

	public void enter_prd_detail_lii_supplier_new_disc_amt(String _discountAmount) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Disc %/ Amt");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex)
				+ "//input[@type='text'][last()]", _discountAmount);
	}

	public void select_prd_detail_lii_supplier_new_tax(String _Tax) {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Tax/ Tax Amt");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex) + "//select", _Tax);
	}

	public String get_prd_detail_lii_supplier_new_tax_amount() {
		int colIndex = getTbColHeaderIndex(xPathFormSupplierDetail, "Tax/ Tax Amt");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathFormSupplierDetail, colIndex)
				+ "//span[contains(@id,'salesTaxAmt')]//span]").getText();
	}

	// Allocation
	String xPathFormAllocationDetail = xPathFormLineItemInformation + "//span[contains(@id,'allocationDetail')]";

	public void open_prd_detail_lii_allocation(int _rowIndex) {
		// Click on green arrow
		clickOnElement(xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, 1)
				+ "//img[contains(@src,'greenarrow')]");
		waitForAllJSCompletes();
	}

	public void click_btn_prd_detail_lii_allocation_add() {
		clickBtn(xPathFormAllocationDetail, "Add");
	}

	public int get_prd_detail_lii_allocation_allocation_no(String _allocationNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathFormAllocationDetail, _allocationNo, 1, "Allocation No.", 1));
	}

	public String get_prd_detail_lii_allocation_type(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Type");
		return waitElementToBeVisible((xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, colIndex)))
				.getText();
	}

	public String get_prd_detail_lii_allocation_customer_job_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Customer Job No.");
		return waitElementToBeVisible((xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, colIndex)))
				.getText();
	}

	public String get_prd_detail_lii_allocation_schedule_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Schedule No.");
		return waitElementToBeVisible((xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, colIndex)))
				.getText();
	}

	public void enter_prd_detail_lii_allocation_voucher_no(int _rowIndex, String _voucherNo) {
		int headerIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Voucher No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]",
				_voucherNo);
	}

	public void enter_prd_detail_lii_allocation_phase_no(int _rowIndex, String _phaseNo) {
		int headerIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Phase No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]", _phaseNo);
	}

	public void enter_prd_detail_lii_allocation_line_item_no(int _rowIndex, String _lineItemNo) {
		int headerIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Line Item No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]",
				_lineItemNo);
	}

	public void enter_prd_detail_lii_allocation_alloc_qty(int _rowIndex, String _allocQty) {
		int headerIndex = getTbColHeaderIndex(xPathFormAllocationDetail, "Alloc Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]", _allocQty);
	}

	// Payment Request
	private String xPathPanelPRDDetailPaymentRequest = "//form[@id='paymentRequestForm']";

	public void select_prd_payreq_is_payment_request(String _isPaymentRequest) {
		selectRadioButton(xPathPanelPRDDetailPaymentRequest, "Is Payment Request (PO Not Required)", _isPaymentRequest);
	}

	public void enter_prd_payreq_supplier_invoice_no(String _supplierInvoiceNo) {
		enterInputFieldWithLabel(xPathPanelPRDDetailPaymentRequest, "Supplier Invoice No.", _supplierInvoiceNo);
	}

	public void select_prd_payreq_charge_party(String _chargeParty) {
		selectDdlWithLabelByText(xPathPanelPRDDetailPaymentRequest, "Charge Party", _chargeParty);
	}

	public void enter_prd_payreq_remarks(String _remarks) {
		enterInputFieldWithLabel(xPathPanelPRDDetailPaymentRequest, "Remarks", _remarks);
	}

	// Attachment
	private String xPathPanelAttachment = "//span[contains(@id,'draftAttachmentPanel')]";

	public void click_btn_add_attachment() {
		clickBtn(xPathPanelAttachment, "Add");
	}

	public void click_btn_delete_attachment() {
		clickBtn(xPathPanelAttachment, "Delete");
	}

	public void click_btn_cancel_attachment() {
		clickBtn(xPathPanelAttachment, "Cancel");
	}

	public void choose_attachment_file(String _filePath) {
		waitElementToBePresent(xPathPanelAttachment + "//input[@type='file']").sendKeys(_filePath);
	}

	public int get_att_row_by_no(String _AttachmentNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _AttachmentNo, 1, "No.", 1));
	}

	public void click_btn_upload_attachment() {
		clickBtn(xPathPanelAttachment, "Upload");
		waitForAllJSCompletes();
		withTimeoutOf(60, TimeUnit.SECONDS).waitForAbsenceOf(xPathBtn(xPathPanelAttachment, "Upload"));
	}

	public void enter_file_description(int _rowIndex, String _fileDescription) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex,
						headerIndex) + "//input[1]",
				_fileDescription);
	}

	public String get_new_file_mime_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"MIME Type");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	public String get_new_file_file_size(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Size");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	// END Purchase Requisition Draft
	// BEGIN Purchase Requisition Cost Confirmation
	private String xPathPanelPRCostConfirm = "//div[text()='Purchase Requisition Cost Confirmation']/ancestor::div[1]";
	String xPathTbPRCCDetail = xPathPanelPRCostConfirm + "//table[contains(@id,'tblPrCcfDetail')]";

	public void click_btn_prcc_preview() {
		clickBtn(xPathPanelPRCostConfirm, "Preview");
	}

	private String xPathPanelPRCCReports = "//div[text()='Reports' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public int get_prcc_detail_row_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbPRCCDetail, _no, 1, "No.", 1));
	}

	public String get_prcc_list_report_title_file_then_click_done() {
		waitElementToBeVisible(xPathPanelPRCCReports);
		List<WebElementFacade> reportTitles = findAll(xPathPanelPRCCReports + "//a");
		String sReportTitles = "";
		for (WebElementFacade el : reportTitles) {
			sReportTitles += el.getText() + System.getProperty("line.separator");
		}
		clickBtn(xPathPanelPRCCReports, "Done");
		System.out.print(sReportTitles);
		return sReportTitles;
	}

	public void click_btn_prcc_submit() {
		clickBtn(xPathPanelPRCostConfirm, "Submit");
		click_btn_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelPRCCConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You are about to submit this Purchase Requisition")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnPRCCConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelPRCCConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelPRCCConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelPRCCConfirmSubmit);
	}

	public void clickBtnNoOnPRCCConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelPRCCConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelPRCCConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelPRCCConfirmSubmit);
	}

	// Line Item Information
	String xPathPRCCFormLineItemInformation = "(//*[contains(text(),'Line Item Information')]//ancestor-or-self::form[1])";
	// Supplier
	String xPathPRCCFormSupplierDetail = xPathFormLineItemInformation + "//span[contains(@id,'ccfAllocationDetail')]";

	public void open_prcc_detail_panel_line_item_information(int _rowIndex) {
		// Click on green arrow
		clickOnElement(
				xPathTbDataCellByPosition(xPathTbPRCCDetail, _rowIndex, 1) + "//img[contains(@src,'greenarrow')]");
		waitForAllJSCompletes();
	}

	public void switch_to_tab_prcc_detail_supplier() {
		switch_to_tab(xPathPRCCFormLineItemInformation, "Supplier");
	}

	public void switch_to_tab_prcc_detail_allocation() {
		switch_to_tab(xPathPRCCFormLineItemInformation, "Allocation");
	}

	public void click_btn_prcc_detail_lii_supplier_add() {
		clickBtn(xPathPRCCFormSupplierDetail, "Add");
	}

	public void enter_prcc_detail_lii_supplier_new_supplier(String _supplier) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Supplier");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex) + "//input[@type='text']",
				_supplier);
	}

	public String get_prcc_detail_lii_supplier_new_type() {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Type");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex))
				.getText();
	}

	public String get_prcc_detail_lii_supplier_new_voucher_no() {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Voucher No.");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex))
				.getText();
	}

	public String get_prcc_detail_lii_supplier_new_voucher_date() {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Voucher Date");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex))
				.getText();
	}

	public void select_prcc_detail_lii_supplier_new_ccy(String _ccy) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Ccy");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex) + "//select", _ccy);
	}

	public void select_prcc_detail_lii_supplier_new_cost_type(String _costType) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Cost Type");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex) + "//select",
				_costType);
	}

	public void enter_prcc_detail_lii_supplier_new_unit_cost_ref(String _unitCostRef) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Unit Cost Ref / New");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex) + "//input[@type='text'][1]",
				_unitCostRef);
	}

	public void enter_prcc_detail_lii_supplier_new_unit_cost_new(String _unitCostNew) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Unit Cost Ref / New");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex)
				+ "//input[@type='text'][last()]", _unitCostNew);
	}

	public void enter_prcc_detail_lii_supplier_new_disc_percent(String _discountPercent) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Disc%/ Amount");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex) + "//input[@type='text'][1]",
				_discountPercent);
	}

	public void enter_prcc_detail_lii_supplier_new_disc_amt(String _discountAmount) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Disc%/ Amount");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex)
				+ "//input[@type='text'][last()]", _discountAmount);
	}

	public void select_prcc_detail_lii_supplier_new_tax(String _Tax) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Tax/ Tax Amt");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex) + "//select", _Tax);
	}

	public String get_prcc_detail_lii_supplier_new_tax_amount() {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Tax/ Tax Amt");
		return waitElementToBeVisible(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex)
				+ "//span[contains(@id,'salesTaxAmt')]//span]").getText();
	}

	public void set_prcc_detail_lii_supplier_pref_sup(String _prefSup) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormSupplierDetail, "Pref Sup");
		setChkbox(xPathTbGetLastDataCellByHeaderIndex(xPathPRCCFormSupplierDetail, colIndex)
				+ "//input[@type='checkbox']", _prefSup);
	}

	// Allocation
	String xPathPRCCFormAllocationDetail = xPathPRCCFormLineItemInformation
			+ "//span[contains(@id,'ccfAllocationDetail')]";

	public void open_prcc_detail_lii_allocation(int _rowIndex) {
		// Click on green arrow
		clickOnElement(xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, 1)
				+ "//img[contains(@src,'greenarrow')]");
	}

	public void click_btn_prcc_detail_lii_allocation_add() {
		clickBtn(xPathPRCCFormAllocationDetail, "Add");
	}

	public int get_prcc_detail_lii_allocation_allocation_no(String _allocationNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathPRCCFormAllocationDetail, _allocationNo, 1, "Allocation No.", 1));
	}

	public String get_prcc_detail_lii_allocation_type(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Type");
		return waitElementToBeVisible((xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex)))
				.getText();
	}

	public String get_prcc_detail_lii_allocation_customer_job_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Customer Job No.");
		return waitElementToBeVisible((xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex)))
				.getText();
	}

	public String get_prcc_detail_lii_allocation_schedule_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Schedule No.");
		return waitElementToBeVisible((xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex)))
				.getText();
	}

	public String get_prcc_detail_lii_allocation_voucher_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Voucher No.");
		return waitElementToBeVisible(
				(xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex) + "//input"))
						.getTextValue();
	}

	public void enter_prcc_detail_lii_allocation_voucher_no(int _rowIndex, String _voucherNo) {
		int headerIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Voucher No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]",
				_voucherNo);
	}

	public String get_prcc_detail_lii_allocation_phase_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Phase No.");
		return waitElementToBeVisible(
				(xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex) + "//input"))
						.getTextValue();
	}

	public void enter_prcc_detail_lii_allocation_phase_no(int _rowIndex, String _phaseNo) {
		int headerIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Phase No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]",
				_phaseNo);
	}

	public String get_prcc_detail_lii_allocation_line_item_no(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Line Item No.");
		return waitElementToBeVisible(
				(xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex) + "//input"))
						.getTextValue();
	}

	public void enter_prcc_detail_lii_allocation_line_item_no(int _rowIndex, String _lineItemNo) {
		int headerIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Line Item No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]",
				_lineItemNo);
	}

	public String get_prcc_detail_lii_allocation_alloc_qty(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Alloc Qty");
		return waitElementToBeVisible(
				(xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, colIndex) + "//input"))
						.getTextValue();
	}

	public void enter_prcc_detail_lii_allocation_alloc_qty(int _rowIndex, String _allocQty) {
		int headerIndex = getTbColHeaderIndex(xPathPRCCFormAllocationDetail, "Alloc Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPRCCFormAllocationDetail, _rowIndex, headerIndex) + "//input[1]",
				_allocQty);
	}
	// END Purchase Requisition Cost Confirmation
}
