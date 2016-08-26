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
public class SalesOrderPage extends TH5PageObject {
	public SalesOrderPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Sales Order";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Sales Order Summary
	private String xPathPanelSOSummary = "(//div[text()='Sales Order Summary']//ancestor::div[1]//table)[1]";

	public void click_btn_new_of_so_summany() {
		findBtn(xPathPanelSOSummary, "New").waitUntilClickable().click();
	}

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void switch_to_tab_outstanding() {
		switch_to_tab("Outstanding");
	}

	public void switch_to_tab_completed() {
		switch_to_tab("Completed");
	}

	public void switch_to_tab_cancelled() {
		switch_to_tab("Cancelled");
	}

	public void filter_summary_by_sales_quotation_no(String _salesQuotationNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSOSummary, "Sales Quotation No."), _salesQuotationNo);
	}

	public void filter_summary_by_sales_order_no(String _salesOrderNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSOSummary, "Sales Order No."), _salesOrderNo);
	}

	public void filter_summary_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSOSummary, "Created By"), _createdBy);
	}

	public void filter_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelSOSummary, "Created Date From To"), _createdDateFrom,
				_createdDateTo);
	}

	public void filter_summary_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSOSummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelSOSummary, "Created Date From To"), _lastUpdatedDateFrom,
				_lastUpdatedDateTo);
	}

	public void open_sales_order_no(String _salesOrderNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelSOSummary, "Sales Order No.", 1, _salesOrderNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelSOSummary, "Sales Order No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSOSummary, rowIndex, headerIndex) + "//a");
	}

	public void open_first_sales_order_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelSOSummary, "Sales Order No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSOSummary, 1, headerIndex) + "//a");
	}

	public void open_first_sales_order_variation() {
		int headerIndex = getTbColHeaderIndex(xPathPanelSOSummary, "Variation");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSOSummary, 1, headerIndex) + "//a");
	}
	// END Sales Order Summary

	// BEGIN Create SO
	public void switch_to_tab_header() {
		switch_to_tab("Header");
	}

	public void switch_to_tab_shipment() {
		switch_to_tab("Shipment");
	}

	public void switch_to_tab_detail() {
		switch_to_tab("Details");
	}

	public void switch_to_tab_payment_info() {
		switch_to_tab("Payment Information");
	}

	public void switch_to_tab_remarks() {
		switch_to_tab("Remarks");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
	}

	// Preview Report
	private String xPathPanelReports = "//div[text()='Reports' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

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

	// Header
	private String xPathPanelSODetail = "(//div[text()='Sales Order']//ancestor::div[contains(@class,'rich-panel')])[1]";

	public String get_new_sales_order_no() {
		return getTextWithLabel(xPathPanelSODetail, "Sales Order No.", 2);
	}

	public void click_btn_new_sales_order_detail() {
		clickBtn(xPathPanelSODetail, "New");
	}

	public void click_btn_preview_sales_order_detail() {
		clickBtn(xPathPanelSODetail, "Preview");
	}

	public void submit_sales_order_detail() {
		click_btn_submit_sales_order_detail();
		click_btn_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	public void click_btn_submit_sales_order_detail() {
		clickBtn(xPathPanelSODetail, "Submit");
	}

	private String xPathPanelConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You Are About To Submit This Sales Order")
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
		clickBtn(xPathPanelSODetail, "Back To Summary");
	}

	public void click_btn_abort() {
		clickBtn(xPathPanelSODetail, "Abort");
	}

	public void click_btn_copy() {
		clickBtn(xPathPanelSODetail, "Copy");
	}

	public void select_option_copy_from_option(String _copyFromOption) {
		selectRadioButton(xPathPanelSODetail, "Copy From", _copyFromOption);
	}

	public void enter_copy_from(String _copyFrom) {
		enterInputFieldWithLabel("Copy From", _copyFrom);
	}

	public void enter_customer(String _customer) {
		enterInputFieldWithLabel("Customer", _customer);
	}

	public String get_customer_name() {
		return getTextWithLabel(xPathPanelSODetail, "Customer", 2);
	}

	public void enter_customer_address(String _customerAddress) {
		enterInputFieldWithLabel("Customer Address", _customerAddress);
	}

	public String get_customer_address_code() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSODetail, "Customer Address", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public void enter_customer_contact(String _customerContact) {
		enterInputFieldWithLabel("Customer Contact", _customerContact);
	}

	public String get_customer_contact_code() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSODetail, "Customer Contact", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public void enter_order_date(String _orderDate) {
		enterInputFieldWithLabel("Order Date", _orderDate);
	}

	public void enter_sales_person(String _salesPerson) {
		enterInputFieldWithLabel("Sales Person", _salesPerson);
	}

	public String get_sales_person() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSODetail, "Sales Person", 2) + "/preceding-sibling::input").getTextValue();
	}

	public void enter_order_currency(String _orderCurrency) {
		enterInputFieldWithLabel("Order Currency", _orderCurrency);
	}

	public String get_order_currency() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSODetail, "Order Currency", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public void enter_reporting_date(String _reportingDate) {
		enterInputFieldWithLabel("Reporting Date", _reportingDate);
	}

	public void enter_approving_sbu(String _approvingSbu) {
		enterInputFieldWithLabel("Approving SBU", _approvingSbu);
	}

	public void enter_sales_tax(String _salesTax) {
		enterInputFieldWithLabel("Sales Tax", _salesTax);
	}

	public String get_sales_tax() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelSODetail, "Sales Tax", 2) + "/preceding-sibling::input").getTextValue();
	}

	public void enter_reference_no(String _referenceNo) {
		enterInputFieldWithLabel("Reference No.", _referenceNo);
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

	public void enter_end_user(String _endUser) {
		enterInputFieldWithLabel("End User", _endUser);
	}

	public void enter_sales_category(String _salesCategory) {
		enterInputFieldWithLabel("Sales Category", _salesCategory);
	}

	public void enter_subject(String _subject) {
		enterInputFieldWithLabel("Subject", _subject);
	}

	public void select_allocate_pr_to_so(String _allocatePRToSO) {
		selectRadioButton(xPathPanelSODetail, "Allocate PR to SO", _allocatePRToSO);
	}

	public void select_allocate_po_to_so(String _allocatePOToSO) {
		selectRadioButton(xPathPanelSODetail, "Allocate PO to SO", _allocatePOToSO);
	}

	public void select_downpayment_type(String _downpaymentType) {
		selectRadioButton("Downpayment Type", _downpaymentType);
	}

	public void enter_q_downpayment_percent(String _qDownpaymentPercent) {
		enterInputFieldWithLabel("Q-Downpayment Percent/Amount", _qDownpaymentPercent);
	}

	public void enter_q_downpayment_amount(String _qDownpaymentAmount) {
		enterInputFieldWithLabel("Q-Downpayment Percent/Amount", _qDownpaymentAmount, 2);
	}

	public void enter_q_downpayment_remarks(String _qDownpaymentRemarks) {
		enterTextAreaWithLabel("Q - Downpayment Remarks", _qDownpaymentRemarks);
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

	// Shipment
	public void enter_loading_location(String _loadingLocation) {
		enterInputFieldWithLabel("Loading Location", _loadingLocation);
	}

	public void enter_shipment_mode(String _shipmentMode) {
		enterInputFieldWithLabel("Shipment Mode", _shipmentMode);
	}

	public void enter_shipment_term(String _shipmentTerm) {
		enterInputFieldWithLabel("Shipment Term", _shipmentTerm);
	}

	public void enter_shipment_instruction(String _shipmentInstruction) {
		enterTextAreaWithLabel("Shipment Instruction", _shipmentInstruction);
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
		enterInputFieldWithLabel("No. of Shipment", _noOfShipment);
	}

	// Payment Information
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
	String xPathTbAddDetail = "//table[contains(@id,'soOrderNewDetTable')]";

	public void click_btn_add_detail() {
		clickBtn(xPathPanelDetail, "Add");
	}

	public void click_btn_delete_detail() {
		clickBtn(xPathPanelDetail, "Delete");
	}

	public void click_btn_reorder_line_item_by_brand() {
		clickBtn(xPathPanelDetail, "Reorder Line Item By Brand");
	}

	public void click_btn_browse_pick() {
		clickBtn(xPathPanelDetail, "Browse&Pick");
	}

	public void enter_exchange_rate(String _exchangeRate) {
		enterInputFieldWithLabel("Exchange Rate", _exchangeRate);
	}

	public String get_det_exchange_rate() {
		return getTextValueWithLabel("Exchange Rate");
	}

	public String get_det_total_volume() {
		return getTextValueWithLabel("Total Volume");
	}

	public String get_det_total_weight() {
		return getTextValueWithLabel("Total Weight");
	}

	public String get_det_total_discount_amt() {
		return getTextValueWithLabel("Total Discount Amt");
	}

	public String get_det_total_sales_tax_amt() {
		return getTextValueWithLabel("Total Sales Tax Amt");
	}

	public String get_det_sub_total_after_discount() {
		return getTextValueWithLabel("Sub Total After Discount");
	}

	public String get_det_total_after_tax_amt() {
		return getTextValueWithLabel("Total After Tax Amt");
	}

	public void enter_required_shipment_date(String _requiredShipmentDate) {
		enterInputFieldWithLabel("Required Shipment Date", _requiredShipmentDate);
	}

	public void enter_required_arrival_date(String _requiredArrivalDate) {
		enterInputFieldWithLabel("Required Arrival Date", _requiredArrivalDate);
	}

	public void enter_production_due_date(String _productionDueDate) {
		enterInputFieldWithLabel("Production Due Date", _productionDueDate);
	}

	public void enter_shipment_priority(String _shipmentPriority) {
		enterInputFieldWithLabel("Shipment Priority", _shipmentPriority);
	}

	public void enter_det_overall_discount_code(String _overallDiscountCode) {
		enterInputFieldWithLabel("Overall Discount Code", _overallDiscountCode);
	}

	public void enter_discount_percent(String _discountPercent) {
		enterInputFieldWithLabel("Discount Percent/Amount", _discountPercent);
	}

	public void enter_discount_amount(String _discountAmount) {
		enterInputFieldWithLabel("Discount Percent/Amount", _discountAmount, 2);
	}

	public void enter_det_line_item_no(String _lineItemNo) {
		enterInputFieldWithLabel("Line Item No.", _lineItemNo);
	}

	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbAddDetail, _lineItemNo, 1, "LI No.", 1));
	}

	public void select_det_item_type(int _rowIndex, String _itemType) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Type", 1);
		selectDdlByText(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//select", _itemType);
	}

	public void enter_det_loading_location(int _rowIndex, String _loadingLocation) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Loading Location");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_loadingLocation);
	}

	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code/Remarks Description");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_itemCode);
	}

	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code/Remarks Description");
		enterRemarkByClickIcon(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
				+ "//img[contains(@src,'remarks.gif')]", _itemRemarks);
	}

	public void get_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code/Remarks Description");
		waitElementToBePresent(
				xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//span[@class='description']")
						.getText();
	}

	public void select_det_prd(int _rowIndex, String _prd) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "PRD", 1);
		selectDdlByText(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//select", _prd);
	}

	public void enter_det_qty(int _rowIndex, String _qty) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Qty");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_qty);
	}

	public String get_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public void select_det_pack_size(int _rowIndex, String _pack_size) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Pack Size", 1);
		selectDdlByText(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//select", _pack_size);
	}

	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "No. Of Pack");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_noOfPack);
	}

	public String get_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "UOM");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)).getText();
	}

	public void enter_det_no_of_bags(int _rowIndex, String _noOfBags) {
		// enterInputFieldWithLabel("No. Of Bags", _noOfBags);
	}

	public void enter_det_pack_size(int _rowIndex, String _packSize) {
		// enterInputFieldWithLabel("Pack Size", _packSize);
	}

	public void enter_det_sales_tax(int _rowIndex, String _salesTax) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Sales Tax");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_salesTax);
	}

	public void enter_det_price_type(int _rowIndex, String _priceType) {
		// enterInputFieldWithLabel("Price Type", _priceType);
	}

	public void enter_det_unit(int _rowIndex, String _unit) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Unit");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_unit);
	}

	public void enter_det_discount_percent(int _rowIndex, String _discountPercent) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Disc%/ Amount");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input[1]", _discountPercent);
	}

	public void enter_det_discount_amount(int _rowIndex, String _discountAmount) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Disc%/ Amount");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input[2]", _discountAmount);
	}

	public void select_det_pr(int _rowIndex, String _pr) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "PR");
		setChkbox(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input", _pr);
	}

	public void select_det_po(int _rowIndex, String _po) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "PO");
		setChkbox(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input", _po);
	}

	public void enter_det_draft_ost_po_no(int _rowIndex, String _draftOstPONo) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Draft/Ost PO No");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_draftOstPONo);
	}

	public String get_det_draft_ost_line_item_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Draft/Ost Line Item No");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
				+ "//span[contains(@id,'poLineItemNo')]").getText();
	}

	public void enter_det_supplier(int _rowIndex, String _supplier) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Supplier Ccy");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
				+ "//input[contains(@class,'ten-char')]", _supplier);
	}

	public void enter_det_ccy(int _rowIndex, String _ccy) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Supplier Ccy");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
				+ "//input[contains(@class,'three-char')]", _ccy);
	}

	public void enter_det_po_qty_allocation(int _rowIndex, String _poQtyAllocation) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "PO Qty Allocation");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_poQtyAllocation);
	}

	public void enter_det_unit_cost(int _rowIndex, String _unitCost) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Unit Cost");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				_unitCost);
	}

	public String get_det_discount_percent(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Disc %");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_det_total(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Total");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public void enter_det_supp_quot(int _rowIndex, String _suppQuot) {
		// enterInputFieldWithLabel("Supp Quot", _suppQuot);
	}

	public void enter_det_ccy_exch_rate_option(int _rowIndex, String _ccyExchRateOption) {
		// enterInputFieldWithLabel("Ccy Exch Rate Option", _ccyExchRateOption);
	}

	public void enter_det_qoh(int _rowIndex, String _qoh) {
		// enterInputFieldWithLabel("QOH", _qoh);
	}

	public void enter_det_qoh_avail(int _rowIndex, String qohAvail) {
		// enterInputFieldWithLabel("QOH Avail", qohAvail);
	}

	public void enter_det_qoh_allocation(int _rowIndex, String qohAllocation) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "QOH Allocation");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex) + "//input",
				qohAllocation);
	}

	public void enter_det_rebate_code_description(int _rowIndex, String rebateCodeDescription) {
		// enterInputFieldWithLabel("Rebate Code Description",
		// rebateCodeDescription);
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
	// END Create SO

	// Create PO
	public String get_purchase_order_no_then_click_ok() {
		String mess = getInfoPanelMessagesThenClickOK();
		return mess.replace("The following Purchase Orders was created: ", "")
				.replace(System.getProperty("line.separator"), "");
	}

	// Create PR
	public String get_purchase_requisitions_no_then_click_ok() {
		String mess = getInfoPanelMessagesThenClickOK();
		return mess.replace("The following Purchase Requisitions was created: ", "")
				.replace(System.getProperty("line.separator"), "");
	}
}
