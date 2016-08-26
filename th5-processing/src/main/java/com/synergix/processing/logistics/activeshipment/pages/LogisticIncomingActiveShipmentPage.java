package com.synergix.processing.logistics.activeshipment.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160121
 */
public class LogisticIncomingActiveShipmentPage extends TH5PageObject {
	public LogisticIncomingActiveShipmentPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Incoming Shipment";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Logistic Incoming Active Shipment Summary - Outstanding tab
	private String xPathPanelLIASSummary = "//*[text()='Logistic Incoming Active Shipment Summary']//ancestor::div[2]";
	// private String xPathTbLIASSummary =
	// "(//table[contains(@id,'lgInActiveShmOstTable')])[1]";

	public void switch_to_tab_outstanding() {
		switch_to_tab("Outstanding");
	}

	public void switch_to_tab_costing() {
		switch_to_tab("Costing");
	}

	public void switch_to_tab_combine() {
		switch_to_tab("Combine");
	}

	public void switch_to_tab_history() {
		switch_to_tab("History");
	}

	public void switch_to_tab_cancelled() {
		switch_to_tab("Cancelled");
	}

	public void filter_by_shipment_voucher_no(String _shipmentVoucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "Shipment Voucher No."), _shipmentVoucherNo);
	}

	public void filter_EAD(String _EAD) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "EAD"), _EAD);
	}

	public String get_EAD(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLIASSummary, "EAD");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLIASSummary, _rowIndex, headerIndex) + "//span").getText();
	}

	public void filter_by_source_voucher_no(String _sourceVoucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "Source Vch No."), _sourceVoucherNo);
	}

	public void filter_by_receiving_location(String _receivingLocation) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "Receiving Location"), _receivingLocation);
	}

	public void filter_by_supplier_name(String _supplierName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "Supplier Name"), _supplierName);
	}

	public String get_total_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLIASSummary, "Total Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLIASSummary, _rowIndex, headerIndex))
				.getText();
	}

	public void filter_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "Created By"), _createdBy);
	}

	public void filter_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLIASSummary, "Created Date From To"), _createdDateFrom,
				_createdDateTo);
	}

	public void filter_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLIASSummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLIASSummary, "Created Date From To"), _lastUpdatedDateFrom,
				_lastUpdatedDateTo);
	}

	public void open_shipment_voucher_no(String _shipmentVouvherNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelLIASSummary, "Shipment Voucher No.", 1, _shipmentVouvherNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelLIASSummary, "Shipment Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLIASSummary, rowIndex, headerIndex) + "//a");
	}

	public void open_first_shipment_voucher_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelLIASSummary, "Shipment Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLIASSummary, 1, headerIndex) + "//a");
	}
	// END Logistic Incoming Active Shipment Summary - Outstanding tab

	// BEGIN Logistic Active Outstanding Shipment - Incoming Shipment Details
	public void switch_to_tab_header() {
		switch_to_tab("Header");
	}

	public void switch_to_tab_detail() {
		switch_to_tab("Detail");
	}

	public void switch_to_tab_additional_cost() {
		switch_to_tab("Additional Cost");
	}

	public void switch_to_tab_shipping_info() {
		switch_to_tab("Shipping Info");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
	}

	private String xPathInfoPanelConfirm = "//div[text()='Info Panel' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public String get_infor_messeage_shipment_voucher_no() {
		String sMessage = waitElementToBeVisible(xPathInfoPanelConfirm + "//span[@class='rich-messages-label']")
				.getText();
		System.out.println(sMessage);
		return sMessage.replace("ShipmentVoucher No '", "").replace("' is created", "");
	}

	public void click_btn_ok_infor_messeage() {
		clickBtn(xPathInfoPanelConfirm, "OK");
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
	private String xPathPanelLAOSISDetails = "//*[text()='Logistic Active Outstanding Shipment - Incoming Shipment Details']//ancestor::div[@id='mainPanel']";

	public String get_laosis_shipment_no() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Shipment No. / Priority", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_shipment_priority() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "Shipment No. / Priority", 1);
	}

	public String get_laosis_source_voucher_no() {
		return getTextWithLabel("Source Voucher No.");
	}

	public String get_laosis_supplier_name() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Supplier", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_supplier_desc() {
		return getTextValueWithLabel(xPathPanelLAOSISDetails, "Supplier", 1);
	}

	public String get_laosis_contact_person_name() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Contact Person", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_contact_person_desc() {
		return getTextValueWithLabel(xPathPanelLAOSISDetails, "Contact Person", 1);
	}

	public void enter_laosis_supplier_do_no(String _supplierDONo) {
		enterInputFieldWithLabel("Supplier DO No.", _supplierDONo);
	}

	public void enter_laosis_supplier_do_date(String _supplierDODate) {
		enterInputFieldWithLabel("Supplier DO Date", _supplierDODate);
	}

	public void enter_laosis_supplier_invoice_no(String _supplierInvoiceNo) {
		enterInputFieldWithLabel("Supplier Invoice No.", _supplierInvoiceNo);
	}

	public void enter_laosis_supplier_invoice_date(String _supplierInvoiceDate) {
		enterInputFieldWithLabel("Supplier Invoice Date", _supplierInvoiceDate);
	}

	public String get_laosis_exchange_rate() {
		return getTextValueWithLabel(xPathPanelLAOSISDetails, "Exchange Rate", 1);
	}

	public String get_laosis_currency() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Currency", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_currency_desc() {
		return getTextValueWithLabel(xPathPanelLAOSISDetails, "Currency", 1);
	}

	public String get_laosis_grn_no() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "GRN No.", 1);
	}

	public String get_laosis_customer_name() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "Customer", 1);
	}

	public String get_laosis_customer_code() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Customer", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_source_customer_po_no() {
		return getTextWithLabel("Customer PO No.");
	}

	public void enter_laosis_consignee(String _consignee) {
		enterInputFieldWithLabel("Consignee", _consignee);
	}

	public void click_btn_laosis_grn_no() {
		clickBtn(xPathPanelLAOSISDetails, "GRN No.");
	}

	public void click_btn_preview() {
		clickBtn("Preview");
	}

	public void click_btn_submit_incoming_shipment_detail() {
		clickBtn(xPathPanelLAOSISDetails, "Submit");
		click_btn_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div[" + sSpecialTextPredicates("You are about to submit this shipment")
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
		clickBtn(xPathPanelLAOSISDetails, "Back To Summary");
	}

	public void enter_laosis_actual_shipment_date(String _actualShipmentDate) {
		if (_actualShipmentDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Actual Shipment Date");
		} else {
			enterInputFieldWithLabel("Actual Shipment Date", _actualShipmentDate);
		}
	}

	public void enter_laosis_actual_arrival_date(String _actualArrivalDate) {
		if (_actualArrivalDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Actual Arrival Date");
		} else {
			enterInputFieldWithLabel("Actual Arrival Date", _actualArrivalDate);
		}
	}

	public void enter_laosis_goods_receipt_date(String _goodsReceiptDate) {
		if (_goodsReceiptDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Goods Receipt Date");
		} else {
			enterInputFieldWithLabel("Goods Receipt Date", _goodsReceiptDate);
		}
	}

	public void enter_laosis_forwarder(String _forwarder) {
		enterInputFieldWithLabel("Forwarder", _forwarder);
	}

	public String get_laosis_estimated_shipment_date() {
		return getTextWithLabel("Estimated Shipment Date");
	}

	public String get_laosis_estimated_arrival_date() {
		return getTextWithLabel("Estimated Arrival Date");
	}

	public String get_laosis_reference_no() {
		return getTextWithLabel("Reference No.");
	}

	public String get_laosis_shipment_term() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "Shipment Mode / Term", 1);
	}

	public String get_laosis_shipment_mode() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Shipment Mode / Term", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_receiving_location() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSISDetails, "Receiving Location", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_laosis_receiving_location_desc() {

		return getTextWithLabel(xPathPanelLAOSISDetails, "Receiving Location", 1);
	}

	public void enter_laosis_internal_remarks(String _internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", _internalRemarks);
	}

	public void enter_laosis_external_remarks(String _externalRemarks) {
		enterTextAreaWithLabel("External Remarks", _externalRemarks);
	}

	// Shipping Info
	public void enter_laosis_booking_date(String _bookingDate) {
		enterInputFieldWithLabel("Booking Date", _bookingDate);
	}

	public void enter_laosis_booking_reference_no(String _bookingReferenceNo) {
		enterInputFieldWithLabel("Booking Reference No.", _bookingReferenceNo);
	}

	public void enter_laosis_country_of_load(String _countryOfLoad) {
		enterInputFieldWithLabel("Country / Port of Load", _countryOfLoad);
	}

	public void enter_laosis_port_of_load(String _portOfLoad) {
		enterInputFieldWithLabel("Country / Port of Load", _portOfLoad, 2);
	}

	public String get_laosis_country_of_load() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of Load", 1)
				+ "/preceding-sibling::input[contains(@class,'two-char')]").getText();
	}

	public String get_laosis_port_of_load() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of Load", 1)
				+ "/preceding-sibling::input[contains(@class,'three-char')]").getText();
	}

	public String get_laosis_port_of_load_desc() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of Load", 1);
	}

	public void enter_laosis_country_of_dischg(String _countryOfDischg) {
		enterInputFieldWithLabel("Country / Port of Dischg", _countryOfDischg);
	}

	public void enter_laosis_port_of_dischg(String _portOfDischg) {
		enterInputFieldWithLabel("Country / Port of Dischg", _portOfDischg, 2);
	}

	public String get_laosis_country_of_dischg() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of Dischg", 1)
				+ "/preceding-sibling::input[contains(@class,'two-char')]").getText();
	}

	public String get_laosis_port_of_dischg() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of Dischg", 1)
				+ "/preceding-sibling::input[contains(@class,'three-char')]").getText();
	}

	public String get_laosis_port_of_dischg_desc() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of Dischg", 1);
	}

	public void enter_laosis_country_of_fd(String _countryOfFd) {
		enterInputFieldWithLabel("Country / Port of FD", _countryOfFd);
	}

	public void enter_laosis_port_of_fd(String _portOfFd) {
		enterInputFieldWithLabel("Country / Port of FD", _portOfFd, 2);
	}

	public String get_country_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of FD", 1)
				+ "/preceding-sibling::input[contains(@class,'two-char')]").getText();
	}

	public String get_laosis_port_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of FD", 1)
				+ "/preceding-sibling::input[contains(@class,'three-char')]").getText();
	}

	public String get_laosis_port_of_fd_desc() {
		return getTextWithLabel(xPathPanelLAOSISDetails, "Country / Port of FD", 1);
	}

	public void enter_laosis_flight_no(String _flightNo) {
		enterInputFieldWithLabel("Flight No", _flightNo);
	}

	public void enter_laosis_date_of_manufacture(String _dateOfManufacture) {
		enterInputFieldWithLabel("Date of Manufacture", _dateOfManufacture);
	}

	public void enter_laosis_eta_etd_pol(String _etaEtdPol) {
		enterInputFieldWithLabel("ETA/ETD (POL)", _etaEtdPol);
	}

	public void enter_laosis_eta_time_pol_hhmm(String _etaTimePolHhMm) {
		enterInputFieldWithLabel("ETA - Time (POL) hh:mm", _etaTimePolHhMm);
	}

	public void enter_laosis_eta_fd(String _etaFd) {
		enterInputFieldWithLabel("ETA (FD)", _etaFd);
	}

	public void enter_laosis_eta_time_fd_hhmm(String _etaTimeFdHhMm) {
		enterInputFieldWithLabel("ETA - Time (FD) hh:mm", _etaTimeFdHhMm);
	}

	public void enter_laosis_mawb(String _mawb) {
		enterInputFieldWithLabel("MAWB", _mawb);
	}

	public void enter_laosis_hawb(String _hawb) {
		enterInputFieldWithLabel("HAWB", _hawb);
	}

	public void enter_laosis_products_description(String _productsDescription) {
		enterInputFieldWithLabel("Products Description", _productsDescription);
	}

	public void enter_laosis_remarks_to_trucker_haulier(String _remarksToTruckerHaulier) {
		enterTextAreaWithLabel("Remarks to Trucker / Haulier", _remarksToTruckerHaulier);
	}

	public void enter_laosis_shipping_marks(String _shippingMarks) {
		enterTextAreaWithLabel("Shipping Marks", _shippingMarks);
	}

	// Attachment
	private String xPathPanelAttachment = "//span[contains(@id,'draftAttachmentPanel')]";

	public void click_btn_laosis_add_attachment() {
		clickBtn(xPathPanelAttachment, "Add");
	}

	public void click_btn_laosis_delete_attachment() {
		clickBtn(xPathPanelAttachment, "Delete");
	}

	public void click_btn_laosis_cancel_attachment() {
		clickBtn(xPathPanelAttachment, "Cancel");
	}

	public void choose_laosis_attachment_file(String _filePath) {
		waitElementToBePresent(xPathPanelAttachment + "//input[@type='file']").sendKeys(_filePath);
	}

	public int get_laosis_att_row_by_no(String _AttachmentNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _AttachmentNo, 1, "No.", 1));
	}

	public void click_btn_laosis_upload_attachment() {
		clickBtn(xPathPanelAttachment, "Upload");
		waitForAllJSCompletes();
		withTimeoutOf(60, TimeUnit.SECONDS).waitForAbsenceOf(xPathBtn(xPathPanelAttachment, "Upload"));
	}

	public void enter_laosis_file_description(int _rowIndex, String _fileDescription) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex,
						headerIndex) + "//input[1]",
				_fileDescription);
	}

	public String get_laosis_new_file_mime_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"MIME Type");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	public String get_laosis_new_file_file_size(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Size");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	// Additional Cost
	private String xPathPanelAdditionalCost = "//td[contains(@id,'additionalCostTab')]//form";

	public String get_loasis_as_total_charge_amt() {
		return waitElementToBeVisible(xPathPanelAdditionalCost + "//td[contains(@id,'totalPreTaxAmt')//input]")
				.getTextValue();
	}

	public String get_loasis_as_total_charge_home_amt() {
		return waitElementToBeVisible(xPathPanelAdditionalCost + "//td[contains(@id,'totalPreTaxHomeAmt')//input]")
				.getTextValue();
	}

	public void click_btn_loasis_as_add() {
		clickBtn(xPathPanelAdditionalCost, "Add");
	}

	public void click_btn_loasis_as_delete() {
		clickBtn(xPathPanelAdditionalCost, "Delete");
	}

	public void enter_loasis_as_new_supplier(String _supplier) {
		int colIndexSupplier = getTbColHeaderIndex(xPathPanelAdditionalCost, "Supplier");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexSupplier)
						+ "//input[@type='text']",
				_supplier);
	}

	public void enter_loasis_as_new_service(String _service) {
		int colIndexService = getTbColHeaderIndex(xPathPanelAdditionalCost, "Service");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexService)
						+ "//input[@type='text']",
				_service);
	}

	public void enter_loasis_as_new_ccy(String _ccy) {
		int colIndexCcy = getTbColHeaderIndex(xPathPanelAdditionalCost, "Ccy");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexCcy) + "//input[@type='text']",
				_ccy);
	}

	public void enter_loasis_as_new_exch_rate(String _exchRate) {
		int colIndexExchRate = getTbColHeaderIndex(xPathPanelAdditionalCost, "Exch Rate");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexExchRate)
						+ "//input[@type='text']",
				_exchRate);
	}

	public void enter_loasis_as_new_charge_amt(String chargeAmt) {
		int colIndexChargeAmt = getTbColHeaderIndex(xPathPanelAdditionalCost, "Charge Amt");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexChargeAmt)
						+ "//input[@type='text']",
				chargeAmt);
	}

	public void enter_loasis_as_new_charge_home_amt(String _chargeHomeAmt) {
		int colIndexChargeHomeAmt = getTbColHeaderIndex(xPathPanelAdditionalCost, "Charge Home Amt");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexChargeHomeAmt)
						+ "//input[@type='text']",
				_chargeHomeAmt);
	}

	public void select_loasis_as_new_cost_dist_mtd(String _costDistMtd) {
		int colIndexCostDistMtd = getTbColHeaderIndex(xPathPanelAdditionalCost, "Cost Dist Mtd");
		selectDdlByText(xPathTbGetLastDataCellByHeaderIndex(xPathPanelAdditionalCost, colIndexCostDistMtd) + "//select",
				_costDistMtd);
	}

	// Detail tab
	private String xPathPanelLAOSISDetail = "//table[contains(@id,'lgInActiveShmOstDetTable')]/ancestor::tbody[1]";

	public void enter_laosis_det_total_cost_for_insurance(String _totalCostForInsurance) {
		enterInputFieldWithLabel("Total Cost For Insurance", _totalCostForInsurance);
	}

	public void click_laosis_det_add() {
		clickBtn(xPathPanelLAOSISDetail, "Add");
	}

	public void click_laosis_det_delete() {
		clickBtn(xPathPanelLAOSISDetail, "Delete");
	}

	public void click_laosis_det_receive_all_ost_qty() {
		clickBtn(xPathPanelLAOSISDetail, "Receive All Ost Qty (Exclude Lot & Serial Inventory)");
	}

	public String get_laosis_det_total_discount() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Discount") - 2;
		return getTextValueWithLabel(xPathPanelLAOSISDetail, "Total", colIndexDiscount);
	}

	public String get_laosis_det_total_total() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Total") - 2;
		return getTextValueWithLabel(xPathPanelLAOSISDetail, "Total", colIndexDiscount);
	}

	public String get_laosis_det_total_add_cost_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Add cost Amt") - 2;
		return getTextValueWithLabel(xPathPanelLAOSISDetail, "Total", colIndexDiscount);
	}

	public String get_laosis_det_total_add_cost_home_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Add Cost Home Amt") - 2;
		return getTextValueWithLabel(xPathPanelLAOSISDetail, "Total", colIndexDiscount);
	}

	public String get_laosis_det_total_fl_total_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLAOSISDetail, "FL Total Amt") - 2;
		return getTextValueWithLabel(xPathPanelLAOSISDetail, "Total", colIndexDiscount);
	}

	public String get_laosis_det_total_fl_total_home_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLAOSISDetail, "FL Total Home Amt") - 2;
		return getTextValueWithLabel(xPathPanelLAOSISDetail, "Total", colIndexDiscount);
	}

	public String get_laosis_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Type");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex) + "//span").getText();
	}

	public String get_laosis_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex) + "//input").getTextValue();
	}

	public String get_laosis_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex)
				+ "//span[@class='description']").getText();
	}

	public String get_laosis_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "UOM");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Qty");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex) + "//input").getTextValue();
	}

	public String get_laosis_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Qty Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_no_of_pack_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "No. Of Pack Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_ost_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Ost Qty");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_unit_cost(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Unit Cost");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_discount(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Discount");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_total(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Total");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_add_cost_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Add cost Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_add_cost_home_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Add Cost Home Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_fl_total_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "FL Total Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_fl_total_home_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "FL Total Home Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosis_det_serial_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Serial No");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, headerIndex))
				.getText();
	}

	public int get_laosis_det_row_index_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelLAOSISDetail, _no, 1, "No.", 1));
	}

	public void enter_laosis_det_qty(int _rowIndex, String _qty) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, colIndex) + "//input[@type='text']", _qty);
	}

	public void enter_laosis_det_item_code(int _rowIndex, String _itemCode) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Item Code");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, colIndex) + "//input[@type='text']",
				_itemCode);
	}

	public void enter_laosis_det_source_po_line_item_no(int _rowIndex, String _sourcePOLineItemNo) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Source PO Line Item No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, colIndex) + "//input[@type='text']",
				_sourcePOLineItemNo);
	}

	public void open_laosis_det_lots_information(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Qty");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, colIndex) + "//a");
	}

	public void open_laosis_det_receving_serial_number(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSISDetail, "Serial No");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLAOSISDetail, _rowIndex, colIndex) + "//a");
	}

	// Lots Information
	private String xPathPanelLotsInformation = "//div[contains(text(),'Lots Information')]//ancestor::table[1]";
	private String xPathTbLots = xPathPanelLotsInformation
			+ "//table[contains(@id,'lotsTable') and @class='rich-table']";

	public void click_btn_li_add() {
		clickBtn(xPathPanelLotsInformation, "Add");
		waitForAllJSCompletes();
	}

	public void click_btn_li_delete() {
		clickBtn(xPathPanelLotsInformation, "Delete");
	}

	public void click_btn_li_done() {
		clickBtn(xPathPanelLotsInformation, "Done");
	}

	public void enter_li_new_ref_no(String _refNo) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Ref No.");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_refNo);
	}

	public void enter_li_new_expiry_date(String _expiryDate) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Expiry Date");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_expiryDate);
	}

	public void enter_li_new_country_of_origin(String _countryOfOrigin) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Country of Origin");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_countryOfOrigin);
	}

	public void enter_li_new_quantity(String _quantity) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Quantity");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_quantity);
	}

	public void enter_li_new_gross_weight(String _grossWeight) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Gross Weight");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_grossWeight);
	}

	public void enter_li_new_tare_weight(String _tareWeight) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Tare Weight");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_tareWeight);
	}

	// Receiving Serial Number
	private String xPathPanelRecevingSerialNumber = "//div[contains(text(),'Receving Serial Number')]//ancestor::table[1]";

	public void switch_to_tab_rsn_batch_input() {
		switch_to_tab(xPathPanelRecevingSerialNumber, "Batch Input");
	}

	public void switch_to_tab_rsn_serial_no_generating() {
		switch_to_tab(xPathPanelRecevingSerialNumber, "Serial No Generating");
	}

	public void enter_rsn_prefix(String _prefix) {
		if (_prefix.equals("@DATETIMENOW@")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
			_prefix = sdf.format(new Date()).toString();
		}
		enterInputFieldWithLabel(xPathPanelRecevingSerialNumber, "Prefix", _prefix);
	}

	public void enter_rsn_suffix(String _suffix) {
		if (_suffix.equals("@DATETIMENOW@")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
			_suffix = sdf.format(new Date()).toString();
		}
		enterInputFieldWithLabel(xPathPanelRecevingSerialNumber, "Suffix", _suffix);
	}

	public void enter_rsn_first_no(String _firstNo) {
		enterInputFieldWithLabel(xPathPanelRecevingSerialNumber, "First No", _firstNo);
	}

	public void enter_rsn_last_no(String _lastNo) {
		enterInputFieldWithLabel(xPathPanelRecevingSerialNumber, "Last No", _lastNo);
	}

	public void click_btn_rsn_generate() {
		clickBtn(xPathPanelRecevingSerialNumber, "Generate");
		waitForAllJSCompletes();
	}

	public void click_btn_rsn_done() {
		clickBtn(xPathPanelRecevingSerialNumber, "Done");
		waitForAllJSCompletes();
	}

	// END Logistic Active Outstanding Shipment - Incoming Shipment Details
	// BEGIN Logistic Costing Shipment - Incoming Shipment Details
	private String xPathPanelLCSISDetails = "//*[text()='Logistic Costing Shipment - Incoming Shipment Details']//ancestor::div[@id='mainPanel']";

	public void click_btn_submit_lcsis_incoming_shipment_detail() {
		clickBtn(xPathPanelLCSISDetails, "Submit");
		click_btn_yes_on_confirm_submit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	// Header
	public void click_btn_lcsis_submit_incoming_shipment_detail_no_assert() {
		clickBtn(xPathPanelLCSISDetails, "Submit");
		click_btn_yes_on_confirm_submit();
	}

	public String get_lcsis_shipment_no() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLCSISDetails, "Shipment No. / Priority", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	// Detail
	private String xPathPanelLCSISDetail = "//table[contains(@id,'lgInActiveShmOstDetTable')]/ancestor::tbody[1]";
	private String xPathTbLCSISDetail = "//table[contains(@id,'lgInActiveShmOstDetTable')]";

	public void enter_lcsis_det_total_cost_for_insurance(String _totalCostForInsurance) {
		enterInputFieldWithLabel("Total Cost For Insurance", _totalCostForInsurance);
	}

	public void click_lcsis_det_add() {
		clickBtn(xPathPanelLCSISDetail, "Add");
	}

	public void click_lcsis_det_delete() {
		clickBtn(xPathPanelLCSISDetail, "Delete");
	}

	public String get_lcsis_det_total_discount() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLCSISDetail, "Discount") - 2;
		return getTextValueWithLabel(xPathPanelLCSISDetail, "Total", colIndexDiscount);
	}

	public String get_lcsis_det_total_total() {
		int colIndexDiscount = getTbColHeaderIndex(xPathPanelLCSISDetail, "Total") - 2;
		return getTextValueWithLabel(xPathTbLCSISDetail, "Total", colIndexDiscount);
	}

	public String get_lcsis_det_total_add_cost_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathTbLCSISDetail, "Add cost Amt") - 2;
		return getTextValueWithLabel(xPathTbLCSISDetail, "Total", colIndexDiscount);
	}

	public String get_lcsis_det_total_add_cost_home_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathTbLCSISDetail, "Add Cost Home Amt") - 2;
		return getTextValueWithLabel(xPathTbLCSISDetail, "Total", colIndexDiscount);
	}

	public String get_lcsis_det_total_fl_total_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathTbLCSISDetail, "FL Total Amt") - 2;
		return getTextValueWithLabel(xPathTbLCSISDetail, "Total", colIndexDiscount);
	}

	public String get_lcsis_det_total_fl_total_home_amt() {
		int colIndexDiscount = getTbColHeaderIndex(xPathTbLCSISDetail, "FL Total Home Amt") - 2;
		return getTextValueWithLabel(xPathTbLCSISDetail, "Total", colIndexDiscount);
	}

	public String get_lcsis_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Type");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_lcsis_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_lcsis_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex) + "//span[@class='description']")
						.getText();
	}

	public String get_lcsis_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "UOM");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Qty");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_lcsis_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Qty Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_no_of_pack_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "No. Of Pack Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_ost_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Ost Qty");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_unit_cost(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Unit Cost");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_discount(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Discount");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_total(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Total");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_add_cost_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Add cost Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_add_cost_home_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Add Cost Home Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_fl_total_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "FL Total Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_fl_total_home_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "FL Total Home Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public String get_lcsis_det_serial_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Serial No");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, headerIndex)).getText();
	}

	public int get_lcsis_det_row_index_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbLCSISDetail, _no, 1, "No.", 1));
	}

	public void enter_lcsis_det_qty(int _rowIndex, String _qty) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//input[@type='text']", _qty);
	}

	public void enter_lcsis_det_item_code(int _rowIndex, String _itemCode) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Item Code");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//input[@type='text']",
				_itemCode);
	}

	public void enter_lcsis_det_unit_cost(int _rowIndex, String _unitCost) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Unit Cost");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//input[@type='text']",
				_unitCost);
	}

	public void select_lcsis_det_cost_variance(int _rowIndex, String _costVariance) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Cost Variance");
		selectDdlByText(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//select", _costVariance);
	}

	public void enter_lcsis_det_source_po_line_item_no(int _rowIndex, String _sourcePOLineItemNo) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Source PO Line Item No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//input[@type='text']",
				_sourcePOLineItemNo);
	}

	public void open_lcsis_det_lots_information(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Qty");
		clickOnElement(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//a");
	}

	public void open_lcsis_det_receving_serial_number(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathTbLCSISDetail, "Serial No");
		clickOnElement(xPathTbDataCellByPosition(xPathTbLCSISDetail, _rowIndex, colIndex) + "//a");
	}

	// END Logistic Costing Shipment - Incoming Shipment Details
	// BEGIN Logistic Active History Shipment - Incoming Shipment Details
	// Detail tab
	private String xPathPanelLAHSISDetail = "//table[contains(@id,'lgInActiveShmHstDetTable')]/ancestor::tbody[1]";
	private String xPathTbLAHSISDetail = "//table[contains(@id,'lgInActiveShmHstDetTable')]";

	public int get_lahsis_det_row_index_by_li_no(String _lINo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbLAHSISDetail, _lINo, 1, "LI No.", 1));
	}

	public String get_lahsis_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLAHSISDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathTbLAHSISDetail, _rowIndex, headerIndex) + "//input").getTextValue();
	}

	public String get_lahsis_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLAHSISDetail, "Type");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathTbLAHSISDetail, _rowIndex, headerIndex) + "//*[last()]").getText();
	}

	public String get_lahsis_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLAHSISDetail, "Qty");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathTbLAHSISDetail, _rowIndex, headerIndex) + "//*[last()]").getText();
	}

	public String get_lahsis_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbLAHSISDetail, "Qty Req");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathTbLAHSISDetail, _rowIndex, headerIndex)).getText();
	}
	// END Logistic Active History Shipment - Incoming Shipment Details
}
