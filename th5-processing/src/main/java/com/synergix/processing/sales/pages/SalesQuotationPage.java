package com.synergix.processing.sales.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160817
 */
public class SalesQuotationPage extends TH5PageObject {
	public SalesQuotationPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Sales Quotation";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Sales Quotation Summary
	private String xPathPanelSQSummary = "(//div[text()='Sales Quotation Summary']//ancestor::div[1]//table)[1]";

	public void click_btn_new_of_sq_summany() {
		findBtn(xPathPanelSQSummary, "New").waitUntilClickable().click();
	}

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void switch_to_tab_pending_approval() {
		switch_to_tab("Pending Approval");
	}

	public void switch_to_tab_outstanding() {
		switch_to_tab("Outstanding");
	}

	public void switch_to_tab_history() {
		switch_to_tab("History");
	}

	public void filter_by_sales_quotation_no(String _salesQuotationNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSQSummary, "Sales Quotation No."), _salesQuotationNo);
	}

	public void open_sales_quotation_no(String _salesQuotationNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelSQSummary, "Sales Quotation No.", 1, _salesQuotationNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelSQSummary, "Sales Quotation No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSQSummary, rowIndex, headerIndex) + "//a");
	}

	public void open_first_sales_quotation_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelSQSummary, "Sales Quotation No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSQSummary, 1, headerIndex) + "//a");
	}
	// END Sales Quotation Summary

	// BEGIN Create SQ in Draft
	public void switch_to_tab_header() {
		switch_to_tab("Header");
	}

	public void switch_to_tab_shipment() {
		switch_to_tab("Shipment");
	}

	public void switch_to_tab_detail() {
		switch_to_tab("Detail");
	}

	public void switch_to_tab_payment_info() {
		switch_to_tab("Payment Info");
	}

	public void switch_to_tab_remarks() {
		switch_to_tab("Remarks");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
	}

	// Header
	private String xPathPanelSQDetail = "(//div[text()='Sales Quotation']//ancestor::div[contains(@class,'rich-panel')])[1]";

	public String get_new_sales_quotation_no() {
		return getTextWithLabel(xPathPanelSQDetail, "Sales Quotation No.", 2);
	}

	public void click_btn_new_sales_quotation_detail() {
		clickBtn(xPathPanelSQDetail, "New");
	}

	public void click_btn_preview_sales_quotation_detail() {
		clickBtn("Preview");
	}

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
		_timeoutInSeconds = _timeoutInSeconds * 1000;

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

	public void click_btn_back_to_summary_sales_quotation_detail() {
		clickBtn(xPathPanelSQDetail, "Back to Summary");
	}

	public void click_btn_submit_sales_quotation_detail() {
		clickBtn(xPathPanelSQDetail, "Submit");
	}

	public void submit_sales_quotation_detail() {
		click_btn_submit_sales_quotation_detail();
		click_btn_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You Are About To Submit This Sales Quotation")
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

	public void click_btn_back_to_summary() {
		clickBtn(xPathPanelSQDetail, "Back To Summary");
	}

	public void click_btn_abort() {
		clickBtn(xPathPanelSQDetail, "Abort");
	}

	public void click_btn_copy() {
		clickBtn(xPathPanelSQDetail, "Copy");
	}

	public void select_option_copy_from(String _copyFrom) {
		selectRadioButton(xPathPanelSQDetail, "Copy From", _copyFrom);
	}

	public void enter_copy_from(String _copyFrom) {
		enterInputFieldWithLabel("Copy From", _copyFrom);
	}

	public void enter_segment_1(String _segment1) {
		enterInputFieldWithLabel("Segment 1", _segment1);
	}

	public void enter_segment_2(String _segment2) {
		enterInputFieldWithLabel("Segment 2", _segment2);
	}

	public void enter_segment_3(String _segment3) {
		enterInputFieldWithLabel("Segment 3", _segment3);
	}

	public void enter_segment_4(String _segment4) {
		enterInputFieldWithLabel("Segment 4", _segment4);
	}

	public void enter_customer(String _customer) {
		enterInputFieldWithLabel("Customer", _customer);
	}

	public String get_customer_name() {
		return getTextWithLabel(xPathPanelSQDetail, "Customer", 2);
	}

	public void enter_customer_address(String _customerAddress) {
		enterInputFieldWithLabel("Customer Address", _customerAddress);
	}

	public String get_customer_address_code() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSQDetail, "Customer Address", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public void enter_customer_contact(String _customerContact) {
		enterInputFieldWithLabel("Customer Contact", _customerContact);
	}

	public String get_customer_contact_code() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSQDetail, "Customer Contact", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public void enter_quotation_date(String _quotationDate) {
		enterInputFieldWithLabel("Quotation Date", _quotationDate);
	}

	public void enter_quotation_time(String _quotationTime) {
		enterInputFieldWithLabel("Quotation Date", _quotationTime, 2);
	}

	public void enter_order_date(String _orderDate) {
		enterInputFieldWithLabel("Order Date", _orderDate);
	}

	public void enter_order_time(String _orderTime) {
		enterInputFieldWithLabel("Order Date", _orderTime, 2);
	}

	public void enter_reporting_date(String _reportingDate) {
		enterInputFieldWithLabel("Reporting Date", _reportingDate);
	}

	public void enter_reporting_time(String _reportingTime) {
		enterInputFieldWithLabel("Reporting Date", _reportingTime);
	}

	public void enter_sbu(String _Sbu) {
		enterInputFieldWithLabel("SBU", _Sbu);
	}

	public void enter_sales_person(String _salesPerson) {
		enterInputFieldWithLabel("Sales Person", _salesPerson);
	}

	public void enter_currency(String _Currency) {
		enterInputFieldWithLabel("Currency", _Currency);
	}

	public String get_currency() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSQDetail, "Currency", 2) + "/preceding-sibling::input").getTextValue();
	}

	public void enter_sales_tax(String _salesTax) {
		enterInputFieldWithLabel("Sales Tax", _salesTax);
	}

	public String get_sales_tax() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSQDetail, "Sales Tax", 2) + "/preceding-sibling::input").getTextValue();
	}

	public String get_sales_person() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSQDetail, "Sales Person", 2) + "/preceding-sibling::input").getTextValue();
	}

	public void enter_validity_term(String _validityTerm) {
		enterInputFieldWithLabel("Validity Term", _validityTerm);
	}

	public String get_validity_due_date(String _validityDueDate) {
		return getTextWithLabel("Validity Due Date", 2);
	}

	public void enter_offer_condition(String _offerCondition) {
		enterInputFieldWithLabel("Offer Condition", _offerCondition);
	}

	public void enter_customer_so_no(String _customerSoNo) {
		enterInputFieldWithLabel("Customer SO No.", _customerSoNo);
	}

	public void enter_customer_po_no(String _customerPoNo) {
		enterInputFieldWithLabel("Customer PO No.", _customerPoNo);
	}

	public void enter_customer_po_line_item_no(String _customerPoLineItemNo) {
		enterInputFieldWithLabel("Customer PO Line Item No.", _customerPoLineItemNo);
	}

	public void enter_d_sales(String _dSales) {
		enterInputFieldWithLabel("D-Sales", _dSales);
	}

	public void enter_end_user(String _endUser) {
		enterInputFieldWithLabel("End User", _endUser);
	}

	public void enter_sales_category(String _salesCategory) {
		enterInputFieldWithLabel("Sales Category", _salesCategory);
	}

	public void enter_subject(String _subject) {
		enterInputFieldWithLabel("Subject", _subject);
	}

	public void enter_reference_no(String _referenceNo) {
		enterInputFieldWithLabel("Reference No.", _referenceNo);
	}

	// Shipment
	public void enter_loading_location(String _loadingLocation) {
		enterInputFieldWithLabel("Loading Location", _loadingLocation);
	}

	public void enter_shipment_mode(String _shipmentMode) {
		enterInputFieldWithLabel("Shm Mode", _shipmentMode);
	}

	public void enter_shipment_term(String _shipmentTerm) {
		enterInputFieldWithLabel("Shm Term", _shipmentTerm);
	}

	public void enter_shipment_instruction(String _shipmentInstruction) {
		enterTextAreaWithLabel("Shm Instruction", _shipmentInstruction);
	}

	public void enter_ship_to_address(String _shipToAddress) {
		enterInputFieldWithLabel("Ship To Address", _shipToAddress);
	}

	public void enter_ship_to_contact(String _shipToContact) {
		enterInputFieldWithLabel("Ship To Contact", _shipToContact);
	}

	public void enter_bill_to_address(String _billToAddress) {
		enterInputFieldWithLabel("Bill To Address", _billToAddress);
	}

	public void enter_bill_to_contact(String _billToContact) {
		enterInputFieldWithLabel("Bill To Contact", _billToContact);
	}

	public void enter_ship_through(String _shipThrough) {
		enterInputFieldWithLabel("Ship Through", _shipThrough);
	}

	public void enter_port_of_loading(String _portOfLoading) {
		enterInputFieldWithLabel("Port of Loading", _portOfLoading);
	}

	public void enter_port_of_discharge(String _portOfDischarge) {
		enterInputFieldWithLabel("Port of Discharge", _portOfDischarge);
	}

	public void enter_port_of_final_destination(String _portOfFinalDestination) {
		enterInputFieldWithLabel("Port of Final Destination", _portOfFinalDestination);
	}

	public String get_country_of_loading(String _countryOfLoading) {
		return getTextWithLabel("Country of Loading");
	}

	public String enter_country_of_discharge(String _countryOfDischarge) {
		return getTextWithLabel("Country of Discharge");
	}

	public String enter_country_of_final_destination(String _countryOfFinalDestination) {
		return getTextWithLabel("Country of Final Destination");
	}

	public void enter_no_of_shipment(String _noOfShipment) {
		enterInputFieldWithLabel("No. of Shm", _noOfShipment);
	}

	// Payment Info
	public void select_payment_option(String _paymentOption) {
		selectDdlWithLabelByText("Payment Option", _paymentOption);
	}

	public void select_payment_term(String _paymentTerm) {
		selectDdlWithLabelByText("Payment Term", _paymentTerm);
	}

	public void enter_payment_term_tenor(String _paymentTermTenor) {
		enterInputFieldWithLabel("Payment Term Tenor", _paymentTermTenor);
	}

	public void enter_payment_term_tenor_code(String _paymentTermTenorCode) {
		enterInputFieldWithLabel("Payment Term Tenor", _paymentTermTenorCode, 2);
	}

	public void select_payment_method(String _paymentMethod) {
		selectDdlWithLabelByText("Payment Method", _paymentMethod);
	}

	public void enter_billing_party(String _billingParty) {
		enterInputFieldWithLabel("Billing Party", _billingParty);
	}

	public void enter_billing_address(String _billingAddress) {
		enterInputFieldWithLabel("Billing Address", _billingAddress);
	}

	public void enter_billing_contact(String _billingContact) {
		enterInputFieldWithLabel("Billing Contact", _billingContact);
	}

	public void enter_payment_amount(String _paymentAmount) {
		enterInputFieldWithLabel("Payment Amount", _paymentAmount);
	}

	public String get_payment_amount() {
		return getTextValueWithLabel("Payment Amount");
	}

	public void enter_own_bank(String _ownBank) {
		enterInputFieldWithLabel("Own Bank", _ownBank);
	}

	public String get_own_bank() {
		return getTextValueWithLabel("Own Bank");
	}

	// Remarks
	public void enter_internal_remarks_code(String _internalRemarksCode) {
		enterInputFieldWithLabel("Internal Remarks Code", _internalRemarksCode);
	}

	public void enter_external_remarks_code(String _externalRemarksCode) {
		enterInputFieldWithLabel("External Remarks Code", _externalRemarksCode);
	}

	public void enter_warranty_remarks_code(String _warrantyRemarksCode) {
		enterInputFieldWithLabel("Warranty Remarks Code", _warrantyRemarksCode);
	}

	public void enter_internal_remarks(String _internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", _internalRemarks);
	}

	public void enter_external_remarks(String _externalRemarks) {
		enterTextAreaWithLabel("External Remarks", _externalRemarks);
	}

	public void enter_warranty_remarks(String _warrantyRemarks) {
		enterTextAreaWithLabel("Warranty Remarks", _warrantyRemarks);
	}

	// Detail
	String xPathPanelDetail = "//td[@id='detail']";
	String xPathTbAddDetail = "//form[contains(@id,'SQDetailForm')]";

	public void click_btn_add_detail() {
		clickBtn(xPathPanelDetail, "Add");
	}

	public void click_btn_delete_detail() {
		clickBtn(xPathPanelDetail, "Delete");
	}

	public void click_btn_reorder_line_item_by_brand() {
		clickBtn(xPathPanelDetail, "Reorder Line Item By Brand");
	}

	public void click_btn_import() {
		clickBtn(xPathPanelDetail, "Import");
	}

	public void enter_det_exchange_rate(String _exchangeRate) {
		enterInputFieldWithLabel("Exchange Rate", _exchangeRate);
	}

	public void enter_det_overall_discount_code(String _overallDiscountCode) {
		enterInputFieldWithLabel("Overall Discount Code", _overallDiscountCode);
	}

	public void enter_det_discount_percent(String _discountPercent) {
		enterInputFieldWithLabel("Discount Percent/Amount", _discountPercent);
	}

	public void enter_det_discount_amount(String _discountAmount) {
		enterInputFieldWithLabel("Discount Percent/Amount", _discountAmount, 2);
	}

	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbAddDetail, _lineItemNo, 1, "LI No.", 1));
	}

	public void select_det_item_type(int _rowIndex, String _itemType) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Type", 1);
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_itemType);
	}

	public void set_det_drawing_received(int _rowIndex, String _drawingReceived) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Drawing Received", 1);
		selectRadioButton(xPathRadioBtnWithLabel(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex), _drawingReceived));
	}

	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_itemCode);
	}

	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code");
		waitTypeAndTabThenUpdateText(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//textarea",
				_itemRemarks);
	}

	public void enter_det_operation_remarks(int _rowIndex, String _operationRemarks) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Operation Remarks");
		waitTypeAndTabThenUpdateText(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//textarea",
				_operationRemarks);
	}

	public void select_det_prd(int _rowIndex, String _prd) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "PRD", 1);
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_prd);
	}

	public void enter_det_qty(int _rowIndex, String _qty) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Qty / UOM");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input", _qty);
	}

	public String get_det_qty_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Qty / UOM");
		return waitElementToBePresent(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex)).getText();
	}

	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "No. of pack / Pack Size");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_noOfPack);
	}

	public void select_det_pack_size(int _rowIndex, String _packSize) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "No. of pack / Pack Size", 1);
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_packSize);
	}

	public void select_det_sales_tax(int _rowIndex, String _salesTax) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Sales Tax");
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_salesTax);
	}

	public void enter_det_unit(int _rowIndex, String _unit) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Unit");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input", _unit);
	}

	public void enter_det_disc_percent(int _rowIndex, String _discPercent) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Disc % / Amt");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_discPercent);
	}

	public void enter_det_supplier(int _rowIndex, String _supplier) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Supplier");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_supplier);
	}

	public void select_det_ccy(int _rowIndex, String _ccy) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Ccy");
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_ccy);
	}

	public void enter_det_unit_cost(int _rowIndex, String _unit) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Unit Cost");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input", _unit);
	}

	// TODO
	/*
	 * public void enter_det_supplier(String _supplier) {
	 * enterInputFieldWithLabel("Supplier", _supplier); }
	 * 
	 * public void enter_det_ccy_exch_rate_option(String _ccyExchRateOption) {
	 * enterInputFieldWithLabel("Ccy Exch Rate Option", _ccyExchRateOption); }
	 * 
	 * public void enter_det_ccy_exch_rate(String _ccyExchRate) {
	 * enterInputFieldWithLabel("Ccy Exch Rate", _ccyExchRate); }
	 * 
	 * public void enter_det_unit_cost(String _unitCost) {
	 * enterInputFieldWithLabel("Unit Cost", _unitCost); }
	 * 
	 * public void enter_det_total_cost(String _totalCost) {
	 * enterInputFieldWithLabel("Total Cost", _totalCost); }
	 * 
	 * public void enter_det_mergin_percent(String _merginPercent) {
	 * enterInputFieldWithLabel("Mergin Percent", _merginPercent); }
	 * 
	 * public void enter_det_mergin_amount(String _merginAmount) {
	 * enterInputFieldWithLabel("Mergin Amount", _merginAmount); }
	 * 
	 * public void enter_det_count_as_sq_back_order(String _countAsSqBackOrder)
	 * { enterInputFieldWithLabel("Count as SQ Back Order",
	 * _countAsSqBackOrder); }
	 * 
	 * public void enter_det_supp_quot(String _suppQuot) {
	 * enterInputFieldWithLabel("Supp Quot", _suppQuot); }
	 * 
	 * public void enter_det_drawing_received(String _drawingReceived) {
	 * enterInputFieldWithLabel("Drawing Received", _drawingReceived); }
	 * 
	 * public void enter_det_rebate_code_description(String
	 * _rebateCodeDescription) { enterInputFieldWithLabel(
	 * "Rebate Code Description", _rebateCodeDescription); }
	 */
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

	// END Create SQ in Draft
	// BEGIN Sales Quotation Outstanding
	// private String xPathPanelSQOutstanding = "(//div[text()='Sales Quotation
	// Outstanding']//ancestor::div[contains(@class,'rich-panel')])[1]";

	public void click_btn_confirm() {
		clickBtn("Confirm");
	}

	private String xPathPanelConfirmConfirm = "//div[text()='You Are About To Confirm This Sales Quotation to Sales Order' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmConfirm() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmConfirm).shouldBeVisible();
		clickBtn(xPathPanelConfirmConfirm, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmConfirm);
	}

	private String xPathInfoPanelConfirm = "//div[text()='Info Panel' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public String get_sales_order_no_outstanding() {
		String sMessage = waitElementToBeVisible(xPathInfoPanelConfirm + "//span[@class='rich-messages-label']")
				.getText();
		System.out.println(sMessage);
		return sMessage.replace("Sales Order No : ", "").replace(" was created.", "");
	}

	public void click_btn_ok_infor_panel_confirm() {
		clickBtn(xPathInfoPanelConfirm, "OK");
	}
	// END Sales Quotation Outstanding

}
