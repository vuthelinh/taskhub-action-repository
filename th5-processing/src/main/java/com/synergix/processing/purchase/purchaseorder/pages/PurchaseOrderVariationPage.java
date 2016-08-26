package com.synergix.processing.purchase.purchaseorder.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160608
 */
public class PurchaseOrderVariationPage extends TH5PageObject {
	public PurchaseOrderVariationPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Purchase Order";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Create PO Variation
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
	private String xPathPanelPODetail = "(//div[text()='Purchase Order Detail']//ancestor::div[contains(@class,'rich-panel')])[1]";

	public String get_new_purchase_order_no() {
		return getTextWithLabel(xPathPanelPODetail, "Purchase Order No.", 2);
	}

	public void click_btn_new_purchase_order_detail() {
		clickBtn(xPathPanelPODetail, "New");
	}

	public void click_btn_submit_purchase_order_detail() {
		clickBtn(xPathPanelPODetail, "Submit");
		clickBtnYesOnConfirmSubmit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You're about to submit this purchase order.")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void clickBtnNoOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void click_btn_back_to_summary() {
		clickBtn(xPathPanelPODetail, "Back To Summary");
	}

	public void click_btn_abort() {
		clickBtn(xPathPanelPODetail, "Abort");
	}

	public void click_btn_copy() {
		clickBtn(xPathPanelPODetail, "Copy");
	}

	public void select_option_copy_from(String _copyFrom) {
		selectRadioButton(xPathPanelPODetail, "Copy From", _copyFrom);
	}

	public void enter_copy_from_po(String _copyFromPo) {
		enterInputFieldWithLabel("Copy From", _copyFromPo);
	}

	public void enter_supplier(String _supplier) {
		enterInputFieldWithLabel("Supplier", _supplier);
	}

	public String get_supplier_name() {
		return waitElementToBeVisible(xPathTextWithLabel("Supplier", 2) + "/ancestor::span[1]").getText();
	}

	public void enter_copy_from(String _copyFrom) {
		enterInputFieldWithLabel("Copy From", _copyFrom);
	}

	public void enter_supplier_contact(String _supplierContact) {
		enterInputFieldWithLabel("Supplier Contact", _supplierContact);
	}

	public void enter_purchase_order_date(String _purchaseOrderDate) {
		enterInputFieldWithLabel("Purchase Order Date", _purchaseOrderDate);
	}

	public void enter_order_currency(String _orderCurrency) {
		enterInputFieldWithLabel("Order Currency", _orderCurrency);
	}

	public String get_order_currency() {
		return getTextValueWithLabel("Order Currency", 2);
	}

	public String get_sales_tax() {
		return getTextValueWithLabel("Sales Tax", 2);
	}

	public String get_supplier_contact() {
		return getTextValueWithLabel("Supplier Contact", 2);
	}

	public String get_purchaser() {
		return waitElementToBeVisible(xPathTextWithLabel("Purchaser", 2) + "/preceding-sibling::input").getTextValue();
	}

	public void enter_sales_tax(String _salesTax) {
		enterInputFieldWithLabel("Sales Tax", _salesTax);
	}

	public void enter_purchaser(String _purchaser) {
		enterInputFieldWithLabel("Purchaser", _purchaser);
	}

	public void enter_sbu(String _sbu) {
		enterInputFieldWithLabel("SBU", _sbu);
	}

	public void select_option_production_purchase(String _productionPurchase) {
		selectRadioButton(xPathPanelPODetail, "Production Purchase", _productionPurchase);
	}

	public void enter_purchase_category(String _purchaseCategory) {
		enterInputFieldWithLabel("Purchase Category", _purchaseCategory);
	}

	public void enter_reference_no(String _referenceNo) {
		enterInputFieldWithLabel("Reference No.", _referenceNo);
	}

	public void enter_subject(String _subject) {
		enterInputFieldWithLabel("Subject", _subject);
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

	private String xPathPanelReports = "//div[text()='Reports' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
	private String xPathReportTitles = xPathPanelReports + "//a";

	public void click_btn_preview_purchase_order_detail() {
		clickBtn(xPathPanelPODetail, "Preview");
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

	// Shipment
	public void enter_purchase_order_no(String _purchaseOrderNo) {
		enterInputFieldWithLabel("Purchase Order No.", _purchaseOrderNo);
	}

	public void enter_shipment_mode(String _shipmentMode) {
		enterInputFieldWithLabel("Shipment Mode", _shipmentMode);
	}

	public void enter_shipment_term(String _ShipmentTerm) {
		enterInputFieldWithLabel("Shipment Term", _ShipmentTerm);
	}

	public void enter_ship_to_location(String _shipToLocation) {
		enterInputFieldWithLabel("Ship to Location", _shipToLocation);
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

	public void enter_ship_through(String _shipThrough) {
		enterInputFieldWithLabel("Ship Through", _shipThrough);
	}

	public void enter_ship_to_party(String _shipToParty) {
		enterInputFieldWithLabel("Ship to Party", _shipToParty);
	}

	public void enter_ship_to_party_address(String _shipToPartyAddress) {
		enterInputFieldWithLabel("Ship to Party Address", _shipToPartyAddress);
	}

	public void enter_ship_to_party_contact(String _shipToPartyContact) {
		enterInputFieldWithLabel("Ship to Party Contact", _shipToPartyContact);
	}

	public void enter_country_of_loading(String _countryOfLoading) {
		enterInputFieldWithLabel("Country of Loading", _countryOfLoading);
	}

	public void enter_country_of_discharge(String _countryOfDischarge) {
		enterInputFieldWithLabel("Country of Discharge", _countryOfDischarge);
	}

	public void enter_country_of_final_destination(String _countryOfFinalDestination) {
		enterInputFieldWithLabel("Country of Final Destination", _countryOfFinalDestination);
	}

	public void enter_project_ship_to_address(String _projectShipToAdd) {
		enterTextAreaWithLabel("Project Ship To Address", _projectShipToAdd);
	}

	public void enter_no_of_shipment(String _noOfShipment) {
		enterInputFieldWithLabel("No. of Shipment", _noOfShipment);
	}

	// Payment Info
	public String get_selected_payment_option() {
		return waitElementToBeVisible(xPathDdlWithLabel("Payment Option")).getSelectedVisibleTextValue();
	}

	public void select_payment_option(String _paymentOption) {
		selectDdlWithLabelByText("Payment Option", _paymentOption);
	}

	public String get_selected_payment_term() {
		return waitElementToBeVisible(xPathDdlWithLabel("Payment Term")).getSelectedVisibleTextValue();
	}

	public void select_payment_term(String _paymentTerm) {
		selectDdlWithLabelByText("Payment Term", _paymentTerm);
	}

	public void enter_payment_term_tenor(String _paymentTermTenor) {
		enterInputFieldWithLabel("Payment Term Tenor", _paymentTermTenor);
	}

	public String get_payment_term_tenor_days() {
		return waitElementToBeVisible(xPathInputFieldWithLabel("Payment Term Tenor", 1)).getValue();
	}

	public String get_payment_term_tenor_code() {
		return waitElementToBeVisible(xPathInputFieldWithLabel("Payment Term Tenor", 2)).getValue();
	}

	public void enter_payment_term_tenor_code(String _paymentTermTenorCode) {
		enterInputFieldWithLabel("Payment Term Tenor", _paymentTermTenorCode, 2);
	}

	public String get_selected_payment_method() {
		return waitElementToBeVisible(xPathDdlWithLabel("Payment Method")).getSelectedVisibleTextValue();
	}

	public void select_payment_method(String _paymentMethod) {
		selectDdlWithLabelByText("Payment Method", _paymentMethod);
	}

	public void enter_payment_party(String _paymentParty) {
		enterInputFieldWithLabel("Payment Party", _paymentParty);
	}

	public void enter_payment_address(String _paymentAddress) {
		enterInputFieldWithLabel("Payment Address", _paymentAddress);
	}

	public void enter_payment_contact(String _paymentContact) {
		enterInputFieldWithLabel("Payment Contact", _paymentContact);
	}

	public void enter_payment_amount(String _paymentAmount) {
		enterInputFieldWithLabel("Payment Amount", _paymentAmount);
	}

	public String get_payment_amount() {
		return waitElementToBeVisible(xPathInputFieldWithLabel("Payment Amount", 1)).getValue();
	}

	public String get_payment_party() {
		return waitElementToBeVisible(xPathInputFieldWithLabel("Payment Party", 1)).getValue();
	}

	public String get_payment_address() {
		return waitElementToBeVisible(xPathInputFieldWithLabel("Payment Address", 1)).getValue();
	}

	public String get_payment_contact() {
		return waitElementToBeVisible(xPathInputFieldWithLabel("Payment Contact", 1)).getValue();
	}

	// Remarks
	public void enter_internal_remarks_code(String _internalRemarksCode) {
		enterInputFieldWithLabel("Internal Remarks Code", _internalRemarksCode);
	}

	public void enter_external_remarks_code(String _externalRemarksCode) {
		enterInputFieldWithLabel("External Remarks Code", _externalRemarksCode);
	}

	public void enter_internal_remarks(String _internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", _internalRemarks);
	}

	public void enter_external_remarks(String _externalRemarks) {
		enterTextAreaWithLabel("External Remarks", _externalRemarks);
	}

	// Detail
	String xPathTbAddDetail = "//form[contains(@id,'poOrderVarDetsForm')]";

	public void click_btn_add_detail() {
		clickBtn("Add");
	}

	public void click_btn_delete_detail() {
		clickBtn("Delete");
	}

	public void click_btn_browse_pick_detail() {
		clickBtn("Browse&Pick");
	}

	public void enter_det_exchange_rate(String _exchangeRate) {
		enterInputFieldWithLabel("Exchange Rate", _exchangeRate);
	}

	public void enter_det_estimated_shipment_date(String _estimatedShipmentDate) {
		enterInputFieldWithLabel("Estimated Shipment Date", _estimatedShipmentDate);
	}

	public void enter_det_estimated_arrival_date(String _estimatedArrivalDate) {
		enterInputFieldWithLabel("Estimated Arrival Date", _estimatedArrivalDate);
	}

	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbAddDetail, _lineItemNo, 1, "No.", 1));
	}

	public void select_det_type(int _rowIndex, String _type) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Type", 1);
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_type);
	}

	public void set_det_direct_issue_to_project(int _rowIndex, String _directIssueToProject) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Direct Issue to Project", 1);
		setChkbox(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex)
				+ "//input[@type='checkbox']", _directIssueToProject);
	}

	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_itemCode);
	}

	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Remarks");
		enterRemarkByClickIcon(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex)
				+ "//img[contains(@src,'remarks.gif')]", _itemRemarks);
	}

	public void enter_det_qty(int _rowIndex, String _qty) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input", _qty);
	}

	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "No. of Pack");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_noOfPack);
	}

	public void select_det_pack_size(int _rowIndex, String _packSize) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Pack Size", 1);
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_packSize);
	}

	public void enter_det_sales_tax(int _rowIndex, String _salesTax) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Sales Tax");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_salesTax);
	}

	public void select_det_cost_type(int _rowIndex, String _costType) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Cost Type", 1);
		selectDdlByText(xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select",
				_costType);
	}

	public void enter_det_unit_cost(int _rowIndex, String _unitCost) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Unit Cost");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input",
				_unitCost);
	}

	public void enter_det_discount_percent(int _rowIndex, String _discountPercent) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Discount % / Amount");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input[1]",
				_discountPercent);
	}

	public void enter_det_discount_amount(int _rowIndex, String _discountAmount) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Discount % / Amount");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input[2]",
				_discountAmount);
	}

	public void enter_det_sgmts(String _sgmts) {
	}

	public void open_det_popup_allocation_details(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Allocation");
		waitElementToBeClickable(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
				+ "//span[@class='text-icon' and text()='i']").click();
	}

	public String get_det_total(int _rowIndex, String _total) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Total");
		return waitElementToBePresent(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//span")
						.getText();
	}

	public String get_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Type");
		return waitElementToBePresentThenScrollIntoView(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//select")
						.getSelectedValue();
	}

	public String get_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Item Code");
		return waitElementToBePresentThenScrollIntoView(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input")
						.getTextValue();
	}

	public String get_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Qty");
		return waitElementToBePresentThenScrollIntoView(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input")
						.getTextValue();
	}

	public String get_det_unit_cost(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Unit Cost");
		return waitElementToBePresentThenScrollIntoView(
				xPathTbDataCellByPositionAndBodyIndex(xPathTbAddDetail, 3, _rowIndex, headerIndex) + "//input")
						.getTextValue();
	}

	public void open_panel_allocation_details(boolean isPopup, int _rowIndex) {
		if (isPopup) {
			// Open pop up allocation details
			int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Allocation");
			waitElementToBeClickable(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
					+ "//span[@class='text-icon' and text()='i']").click();
			waitElementToBePresent(xPathPopupAllocationDetail).shouldBeVisible();

		} else {
			// Click on green arrow
			waitElementToBeClickable(
					xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, 1) + "//img[contains(@src,'greenarrow')]")
							.click();
		}
	}

	public boolean is_enable_viewing_source_voucher_detail_for_allocation() {
		if (waitElementToBePresent("(" + xPathTbAddDetail + "//img[contains(@src,'greenarrow')])| "
				+ xPathTbHeaderCell(xPathTbAddDetail, "Allocation")).containsText("Allocation")) {
			return false;
		} else {
			return true;
		}
	}

	public void open_panel_contents(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAddDetail, "Contents");
		waitElementToBeClickable(xPathTbDataCellByPosition(xPathTbAddDetail, _rowIndex, headerIndex)
				+ "//span[@class='text-icon' and text()='i']").click();
		waitElementToBePresent(xPathPanelContents).shouldBeVisible();

	}

	// Contents
	private String xPathPanelContents = "//div[contains(text(),'Contents') and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
	private String xPathTbContent = xPathPanelContents + "//table[contains(@id,'contentTable')]";

	public String get_content_line_item_no() {
		return getTextWithLabel(xPathPanelContents, "Line Item No.");
	}

	public String get_content_item_unit_cost() {
		return getTextWithLabel(xPathPanelContents, "Item Unit Cost");
	}

	public String get_content_currency() {
		return getTextWithLabel(xPathPanelContents, "Currency");
	}

	public int get_content_row_by_content_code(String _contentCode) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathTbContent, _contentCode, 1, "Content Code", 1));
	}

	public String get_content_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Description");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_content_percentage(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Percentage (%)");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_content_recovery_rate(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Recovery Rate (%)");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_content_content_unit_cost(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Content Unit Cost");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public void click_btn_content_add() {
		clickBtn(xPathPanelContents, "Add");
		waitForAllJSCompletes();
	}

	public void click_btn_content_delete() {
		clickBtn(xPathPanelContents, "Delete");
	}

	public void click_btn_content_confirm() {
		clickBtn(xPathPanelContents, "Confirm");
	}

	public void enter_content_content_code(int _rowIndex, String _contentCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Content Code");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input",
				_contentCode);
	}

	public void enter_content_percentage(int _rowIndex, String _percentage) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Percentage (%)");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input",
				_percentage);
	}

	public void enter_content_recovery_rate(int _rowIndex, String _recoveryRate) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Recovery Rate (%)");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input",
				_recoveryRate);
	}

	public void enter_content_content_unit_cost(int _rowIndex, String _contentUnitCost) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Content Unit Cost");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathTbContent, _rowIndex, headerIndex) + "//input",
				_contentUnitCost);
	}

	public void enter_content_new_content_code(String _contentCode) {
		int headerIndex = getTbColHeaderIndex(xPathTbContent, "Content Code");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbContent, headerIndex) + "//input",
				_contentCode);
		waitForAllJSCompletes();
	}

	// Allocation Detail
	String xPathPopupAllocationDetail = "(//div[contains(text(),'Allocation Details') and contains(@id,'popupModalPanelHeader')]//ancestor-or-self::table[1])";
	String xPathFormAllocationDetail = "(//*[contains(text(),'Allocation Details')]//ancestor-or-self::form[1])";
	String xPathPanelAllocationDetail = "(" + xPathPopupAllocationDetail + "|" + xPathFormAllocationDetail + ")";

	public void switch_to_tab_ad_allocation_details() {
		switch_to_tab(xPathPanelAllocationDetail, "Allocation");
	}

	public void click_btn_add_alloc() {
		clickBtn(xPathPanelAllocationDetail, "Add");
	}

	public void click_btn_delete_alloc() {
		clickBtn(xPathPanelAllocationDetail, "Delete");
	}

	public void click_btn_done_alloc() {
		clickBtn(xPathPanelAllocationDetail, "Done");
	}

	public int get_alloc_row_by_allocation_no(String _allocationNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", _allocationNo, 1,
				"Allocation No.", 1));
	}

	public boolean check_alloc_row_existed_by_allocation_no(String _allocationNo) {
		return isElementExist(xPathTbDataCellByTextEqualInCol(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", _allocationNo, 1,
				"Allocation No.", 1), 1);
	}

	public void update_alloc_purchase_order_no(String _purchaseOrderNo) {
		// TODO
	}

	public void select_alloc_line_item_no(String _lineItemNo) {
		enterInputFieldWithLabel("Line Item No.", _lineItemNo);
	}

	public void select_alloc_alloc_type(int _rowIndex, String _allocType) {
		int headerIndex = getTbColHeaderIndex(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", "Alloc Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]",
						_rowIndex, headerIndex) + "//select",
				_allocType);
	}

	public void enter_alloc_voucher_no(int _rowIndex, String _voucherNo) {
		int headerIndex = getTbColHeaderIndex(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", "Voucher No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]",
						_rowIndex, headerIndex) + "//input[1]",
				_voucherNo);
	}

	public void enter_alloc_phase_sequence_no(int _rowIndex, String _phaseSequenceNo) {
		int headerIndex = getTbColHeaderIndex(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", "Phase Sequence No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]",
						_rowIndex, headerIndex) + "//input[1]",
				_phaseSequenceNo);
	}

	public void enter_alloc_line_no(int _rowIndex, String _lineNo) {
		int headerIndex = getTbColHeaderIndex(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", "Line No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]",
						_rowIndex, headerIndex) + "//input[1]",
				_lineNo);
	}

	public void enter_alloc_alloc_qty(int _rowIndex, String _allocQty) {
		int headerIndex = getTbColHeaderIndex(
				xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]", "Alloc Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAllocationDetail + "//table[contains(@id,'poNewDetAllocTable')]",
						_rowIndex, headerIndex) + "//input[1]",
				_allocQty);
	}

	// Attachment
	private String xPathPanelAttachment = "//span[contains(@id,'varAttachmentPanel')]//form[1]";

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
	// END PO Variation
}
