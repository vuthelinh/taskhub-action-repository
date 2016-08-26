package com.synergix.processing.logistics.activeshipment.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160121
 */
public class LogisticOutgoingActiveShipmentPage extends TH5PageObject {
	public LogisticOutgoingActiveShipmentPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Outgoing Shipment";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Logistic Outgoing Active Shipment Summary - Outstanding tab
	private String xPathPanelLOASSummary = "//*[text()='Logistic Outgoing Active Shipment Summary']//ancestor::div[2]";
	// private String xPathTbLOASSummary =
	// "(//table[contains(@id,'lgOutActiveShmOstTable')])[1]";

	public void click_btn_submit_summany() {
		clickBtn("Submit");
	}

	public void click_btn_do_no_summany() {
		clickBtn("DO No.");
	}

	public void switch_to_tab_outstanding() {
		switch_to_tab("Outstanding");
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
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Shipment Voucher No."), _shipmentVoucherNo);
	}

	public void get_outstanding_state(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "State");
		waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLOASSummary, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public void filter_by_shipment_date(String _shipmentDate) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Shipment Date"), _shipmentDate);
	}

	public void filter_by_rsd(String _RSD) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "RSD"), _RSD);
	}

	public void filter_by_source_voucher_no(String _sourceVoucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Source Voucher No."), _sourceVoucherNo);
	}

	public void filter_by_ccy(String _CCY) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "CCY"), _CCY);
	}

	public void filter_by_do_no(String _dONo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "DO No."), _dONo);
	}

	public void filter_by_customer_code(String _customerCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Customer Code"), _customerCode);
	}

	public void filter_by_customer_name(String _customerName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Customer Name"), _customerName);
	}

	public void filter_by_customer_po_no(String _customerPONo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Customer Po No."), _customerPONo);
	}

	public void filter_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Created By"), _createdBy);
	}

	public void filter_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLOASSummary, "Created Date From To"), _createdDateFrom,
				_createdDateTo);
	}

	public void filter_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelLOASSummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelLOASSummary, "Created Date From To"), _lastUpdatedDateFrom,
				_lastUpdatedDateTo);
	}

	public void get_outstanding_priority(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Priority");
		waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLOASSummary, _rowIndex, headerIndex)).getText();
	}

	public void get_outstanding_mode(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Mode");
		waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLOASSummary, _rowIndex, headerIndex)).getText();
	}

	public void get_outstanding_port_of_loading(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Port of Loading");
		waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLOASSummary, _rowIndex, headerIndex)).getText();
	}

	public void get_outstanding_port_of_discharge(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Port of Discharge");
		waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLOASSummary, _rowIndex, headerIndex)).getText();
	}

	public void get_outstanding_credit_limit_approval_remarks(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Credit Limit Approval Remarks");
		waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLOASSummary, _rowIndex, headerIndex)).getText();
	}

	public void open_shipment_voucher_no(String _shipmentVouvherNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelLOASSummary, "Shipment Voucher No.", 1, _shipmentVouvherNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Shipment Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLOASSummary, rowIndex, headerIndex) + "//a");
	}

	public void open_first_shipment_voucher_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelLOASSummary, "Shipment Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLOASSummary, 1, headerIndex) + "//a");
	}
	// END Logistic Outgoing Active Shipment Summary - Outstanding tab

	// BEGIN Logistic Active Outstanding Shipment - Outgoing Shipment Details
	public void switch_to_tab_header() {
		switch_to_tab("Header");
	}

	public void switch_to_tab_detail() {
		switch_to_tab("Detail");
	}

	public void switch_to_tab_shipping_info() {
		switch_to_tab("Shipping Info");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
	}

	public void click_btn_deliver_all_ost_qty() {
		clickBtn("Deliver All Ost Qty");
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
	private String xPathPanelLAOSDetail = "//*[text()='Logistic Active Outstanding Shipment - Outgoing Shipment Details']//ancestor::div[@id='mainPanel']";

	public String get_laos_shipment_no() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSDetail, "Shipment No. / Priority", 1) + "/ancestor::td[1]").getText();
	}

	public String get_laos_shipment_priority() {
		return getTextValueWithLabel(xPathPanelLAOSDetail, "Shipment No. / Priority", 1);
	}

	public String get_laos_customer_name() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Customer", 1) + "/ancestor::td[1]")
				.getText();
	}

	public String get_laos_customer_desc() {
		return getTextValueWithLabel(xPathPanelLAOSDetail, "Customer", 1);
	}

	public String get_laos_sales_person_name() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Sales Person", 1) + "/ancestor::td[1]")
				.getText();
	}

	public String get_laos_sales_person_desc() {
		return getTextValueWithLabel(xPathPanelLAOSDetail, "Sales Person", 1);
	}

	public String get_laos_source_voucher_no() {
		return getTextWithLabel("Source Voucher No.");
	}

	public String get_laos_source_customer_po_no() {
		return getTextWithLabel("Customer PO No.");
	}

	public String get_laos_reference_no() {
		return getTextWithLabel("Reference No.");
	}

	public String get_laos_subject() {
		return getTextWithLabel("Subject");
	}

	public String get_laos_do_no() {
		return getTextWithLabel("DO No.");
	}

	public void enter_laos_consignee(String _consignee) {
		enterInputFieldWithLabel("Consignee", _consignee);
	}

	public void click_btn_laos_do_no() {
		clickBtn(xPathPanelLAOSDetail, "DO No.");
	}

	public void click_btn_preview() {
		clickBtn("Preview");
	}

	public void click_btn_submit_shipment_no_detail() {
		clickBtn(xPathPanelLAOSDetail, "Submit");
		clickBtnYesOnConfirmSubmit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathPanelConfirmSubmit = "//div[" + sSpecialTextPredicates("You are about to submit this shipment")
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
		clickBtn(xPathPanelLAOSDetail, "Back To Summary");
	}

	public void enter_laos_order_currency(String _orderCurrency) {
		enterInputFieldWithLabel("Order Currency", _orderCurrency);
	}

	public void enter_laos_requested_shipment_date(String _requestedShipmentDate) {
		enterInputFieldWithLabel("Requested Shipment Date", _requestedShipmentDate);
	}

	public void enter_laos_requested_arrival_date(String _requestedArrivalDate) {
		enterInputFieldWithLabel("Requested Arrival Date", _requestedArrivalDate);
	}

	public void enter_laos_original_shipment_date(String _originalShipmentDate) {
		enterInputFieldWithLabel("Original Shipment Date", _originalShipmentDate);
	}

	public void enter_laos_shipment_mode(String _shipmentMode) {
		enterInputFieldWithLabel("Shipment Mode", _shipmentMode);
	}

	public void enter_laos_shipment_term(String _shipmentTerm) {
		enterInputFieldWithLabel("Shipment Term", _shipmentTerm);
	}

	public String get_laos_order_currency() {
		return getTextWithLabel("Order Currency");
	}

	public void enter_laos_actual_shipment_date(String _actualShipmentDate) {
		enterInputFieldWithLabel("Actual Shipment Date", _actualShipmentDate);
	}

	public void enter_laos_actual_arrival_date(String _actualArrivalDate) {
		enterInputFieldWithLabel("Actual Arrival Date", _actualArrivalDate);
	}

	public String get_laos_requested_shipment_date() {
		return getTextWithLabel("Requested Shipment Date");
	}

	public String get_laos_requested_arrival_date() {
		return getTextWithLabel("Requested Arrival Date");
	}

	public String get_laos_original_shipment_date() {
		return getTextWithLabel("Original Shipment Date");
	}

	public String get_laos_shipment_mode() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Shipment Mode", 1) + "/ancestor::td[1]")
				.getText();
	}

	public String get_laos_shipment_mode_desc() {
		return getTextValueWithLabel(xPathPanelLAOSDetail, "Shipment Mode", 1);
	}

	public String get_laos_shipment_term() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Shipment Term", 1) + "/ancestor::td[1]")
				.getText();
	}

	public String get_laos_shipment_mode_term() {
		return getTextValueWithLabel(xPathPanelLAOSDetail, "Shipment Term", 1);
	}

	public String get_laos_loading_location() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSDetail, "Loading Location", 1) + "/ancestor::td[1]").getText();
	}

	public String get_laos_loading_location_desc() {
		return getTextValueWithLabel(xPathPanelLAOSDetail, "Loading Location", 1);
	}

	public void enter_laos_loading_location(String _loadingLocation) {
		enterInputFieldWithLabel("Loading Location", _loadingLocation);
	}

	public void enter_laos_shipping_coordinator(String _shippingCoordinator) {
		enterInputFieldWithLabel("Shipping Coordinator", _shippingCoordinator);
	}

	public void enter_laos_ship_to_address(String _shipToAddress) {
		enterInputFieldWithLabel("Ship To Address", _shipToAddress);
	}

	public String get_laos_ship_to_address() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSDetail, "Ship To Address", 2) + "/ancestor::td[1]").getText();
	}

	public String get_laos_ship_to_address_desc() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLAOSDetail, "Ship To Address", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public void select_laos_ship_to_contact(String _shipToContact) {
		selectDdlWithLabelByText("Ship To Contact", _shipToContact);
	}

	public String get_laos_ship_to_contact_desc() {
		return getTextWithLabel(xPathPanelLAOSDetail, "Ship To Address", 1);
	}

	public void enter_laos_trucker(String _trucker) {
		enterInputFieldWithLabel("Trucker", _trucker);
	}

	public void enter_laos_forwarder(String _forwarder) {
		enterInputFieldWithLabel("Forwarder", _forwarder);
	}

	public void enter_laos__haulier(String _Haulier) {
		enterInputFieldWithLabel(" Haulier", _Haulier);
	}

	public void enter_laos_container_no(String _containerNo) {
		enterInputFieldWithLabel("Container No", _containerNo);
	}

	public void enter_laos_seal_no(String _sealNo) {
		enterInputFieldWithLabel("Seal No", _sealNo);
	}

	public void enter_laos_seal_no_sales_category(String _sealNoSalesCategory) {
		enterInputFieldWithLabel("Seal No Sales Category", _sealNoSalesCategory);
	}

	public void enter_laos_internal_remarks(String _internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", _internalRemarks);
	}

	public void enter_laos_external_remarks(String _externalRemarks) {
		enterTextAreaWithLabel("External Remarks", _externalRemarks);
	}

	public void enter_laos_shipment_instruction(String _shipmentInstruction) {
		enterTextAreaWithLabel("Shipment Instruction", _shipmentInstruction);
	}

	// Shipping Info
	public void enter_laos_booking_date(String _bookingDate) {
		enterInputFieldWithLabel("Booking Date", _bookingDate);
	}

	public void enter_laos_booking_reference_no(String _bookingReferenceNo) {
		enterInputFieldWithLabel("Booking Reference No.", _bookingReferenceNo);
	}

	public void enter_laos_country_of_load(String _countryOfLoad) {
		enterInputFieldWithLabel("Country / Port of Load", _countryOfLoad);
	}

	public void enter_laos_port_of_load(String _portOfLoad) {
		enterInputFieldWithLabel("Country / Port of Load", _portOfLoad, 2);
	}

	public String get_laos_country_of_load() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Country / Port of Load", 1)
				+ "/preceding-sibling::span[@class='two-char']").getText();
	}

	public String get_laos_port_of_load() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Country / Port of Load", 1)
				+ "/preceding-sibling::span[@class='three-char']").getText();
	}

	public String get_laos_port_of_load_desc() {
		return getTextWithLabel(xPathPanelLAOSDetail, "Country / Port of Load", 1);
	}

	public void enter_laos_country_of_dischg(String _countryOfDischg) {
		enterInputFieldWithLabel("Country / Port of Dischg", _countryOfDischg);
	}

	public void enter_laos_port_of_dischg(String _portOfDischg) {
		enterInputFieldWithLabel("Country / Port of Dischg", _portOfDischg, 2);
	}

	public String get_laos_country_of_dischg() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Country / Port of Dischg", 1)
				+ "/preceding-sibling::span[@class='two-char']").getText();
	}

	public String get_laos_port_of_dischg() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Country / Port of Dischg", 1)
				+ "/preceding-sibling::span[@class='three-char']").getText();
	}

	public String get_laos_port_of_dischg_desc() {
		return getTextWithLabel(xPathPanelLAOSDetail, "Country / Port of Dischg", 1);
	}

	public void enter_laos_country_of_fd(String _countryOfFd) {
		enterInputFieldWithLabel("Country / Port of FD", _countryOfFd);
	}

	public void enter_laos_port_of_fd(String _portOfFd) {
		enterInputFieldWithLabel("Country / Port of FD", _portOfFd, 2);
	}

	public String get_country_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Country / Port of FD", 1)
				+ "/preceding-sibling::span[@class='two-char']").getText();
	}

	public String get_laos_port_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLAOSDetail, "Country / Port of FD", 1)
				+ "/preceding-sibling::span[@class='three-char']").getText();
	}

	public String get_laos_port_of_fd_desc() {
		return getTextWithLabel(xPathPanelLAOSDetail, "Country / Port of FD", 1);
	}

	public void enter_laos_carrier(String _carrier) {
		enterInputFieldWithLabel("Carrier", _carrier);
	}

	public void enter_laos_flight_no(String _flightNo) {
		enterInputFieldWithLabel("Flight No", _flightNo);
	}

	public void enter_laos_date_of_manufacture(String _dateOfManufacture) {
		enterInputFieldWithLabel("Date of Manufacture", _dateOfManufacture);
	}

	public void enter_laos_eta_etd_pol(String _etaEtdPol) {
		enterInputFieldWithLabel("ETA/ETD (POL)", _etaEtdPol);
	}

	public void enter_laos_eta_time_pol_hhmm(String _etaTimePolHhMm) {
		enterInputFieldWithLabel("ETA - Time (POL) hh:mm", _etaTimePolHhMm);
	}

	public void enter_laos_eta_fd(String _etaFd) {
		enterInputFieldWithLabel("ETA (FD)", _etaFd);
	}

	public void enter_laos_eta_time_fd_hhmm(String _etaTimeFdHhMm) {
		enterInputFieldWithLabel("ETA - Time (FD) hh:mm", _etaTimeFdHhMm);
	}

	public void enter_laos_mawb(String _mawb) {
		enterInputFieldWithLabel("MAWB", _mawb);
	}

	public void enter_laos_hawb(String _hawb) {
		enterInputFieldWithLabel("HAWB", _hawb);
	}

	public void enter_laos_products_description(String _productsDescription) {
		enterInputFieldWithLabel("Products Description", _productsDescription);
	}

	public void enter_laos_remarks_to_trucker_haulier(String _remarksToTruckerHaulier) {
		enterTextAreaWithLabel("Remarks to Trucker / Haulier", _remarksToTruckerHaulier);
	}

	public void enter_laos_shipping_marks(String _shippingMarks) {
		enterTextAreaWithLabel("Shipping Marks", _shippingMarks);
	}

	// Attachment
	private String xPathPanelAttachment = "//span[contains(@id,'draftAttachmentPanel')]";

	public void click_btn_laos_add_attachment() {
		clickBtn(xPathPanelAttachment, "Add");
	}

	public void click_btn_laos_delete_attachment() {
		clickBtn(xPathPanelAttachment, "Delete");
	}

	public void click_btn_laos_cancel_attachment() {
		clickBtn(xPathPanelAttachment, "Cancel");
	}

	public void choose_laos_attachment_file(String _filePath) {
		waitElementToBePresent(xPathPanelAttachment + "//input[@type='file']").sendKeys(_filePath);
	}

	public int get_laos_att_row_by_no(String _AttachmentNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _AttachmentNo, 1, "No.", 1));
	}

	public void click_btn_laos_upload_attachment() {
		clickBtn(xPathPanelAttachment, "Upload");
		waitForAllJSCompletes();
		withTimeoutOf(60, TimeUnit.SECONDS).waitForAbsenceOf(xPathBtn(xPathPanelAttachment, "Upload"));
	}

	public void enter_laos_file_description(int _rowIndex, String _fileDescription) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex,
						headerIndex) + "//input[1]",
				_fileDescription);
	}

	public String get_laos_new_file_mime_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"MIME Type");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	public String get_laos_new_file_file_size(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Size");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	// Detail
	// Lots Information
	private String xPathPanelLotsInformation = "//div[contains(text(),'Lots Information')]//ancestor::table[1]";
	private String xPathTbLots = xPathPanelLotsInformation
			+ "//table[contains(@id,'itemLotTable') and @class='rich-table']";

	public void click_btn_li_pick_earliest_lot_first() {
		clickBtn(xPathPanelLotsInformation, "Pick Earliest Lot First");
		waitForAllJSCompletes();
	}

	public void click_btn_li_done() {
		clickBtn(xPathPanelLotsInformation, "Done");
	}

	public void enter_li_nett_ưeight_selected(String _nettWeightSelected) {
		int headerIndex = getTbColHeaderIndex(xPathTbLots, "Nett Weight Selected");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbLots, headerIndex) + "//input",
				_nettWeightSelected);
	}

	public void enter_li_quantity(String _quantity) {
		enterInputFieldWithLabel(xPathPanelLotsInformation, "Quantity", _quantity);
	}

	// Issuing Serial Number
	private String xPathPanelIssuingSerialNumber = "//div[contains(text(),'Issuing Serial Number')]//ancestor::table[1]";
	private String xPathTbOutgoingSerialNo = "(//table[contains(@id,'outgoingSerialNoTable')])[1]";

	public void click_btn_isn_done() {
		clickBtn(xPathPanelIssuingSerialNumber, "Done");
	}

	public void click_btn_isn_add() {
		clickBtn(xPathPanelIssuingSerialNumber, "Add");
	}

	public void click_btn_isn_delete() {
		clickBtn(xPathPanelIssuingSerialNumber, "Delete");
	}

	public void click_btn_isn_browse_pick() {
		clickBtn(xPathPanelIssuingSerialNumber, "Browse&Pick");
	}

	public int get_isn_row_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbOutgoingSerialNo, _no, 1, "No.", 1));
	}

	public void enter_isn_serial_no(int _rowIndex, String _serialNo) {
		int headerIndex = getTbColHeaderIndex(xPathTbOutgoingSerialNo, "Serial No");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbOutgoingSerialNo, _rowIndex, headerIndex) + "//input", _serialNo);
	}

	String xPathPanelSerialNoSearch = "//div[contains(text(),'Serial No Search')]//ancestor::table[1]";

	public void select_isn_possible_serial_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOutgoingSerialNo, "Serial No");
		clickOnElement(xPathTbDataCellByPosition(xPathTbOutgoingSerialNo, _rowIndex, headerIndex)
				+ "//img[contains(@src, 'lookup')]");
		clickBtn(xPathPanelSerialNoSearch, "Search", 1);
		int row = searchInTbMultiPage(xPathPanelSerialNoSearch, "Selected Voucher No", 1, "", true);
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSerialNoSearch, row, 1) + "//a");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelSerialNoSearch);
	}

	public void enter_isn_reference_no(int _rowIndex, String _referenceNo) {
		int headerIndex = getTbColHeaderIndex(xPathTbOutgoingSerialNo, "Reference No.");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbOutgoingSerialNo, _rowIndex, headerIndex) + "//input", _referenceNo);
	}

	// Detail tab
	private String xPathPanelLAOSOSDetail = "//table[contains(@id,'lgOutActiveShmOstDetTable')]/ancestor::tbody[1]";

	public void click_btn_laosos_deliver_all_ost_qty() {
		clickBtn(xPathPanelLAOSOSDetail, "Deliver All Ost Qty");
	}

	public void click_btn_laosos_reset_shm_qty_to_0_for_all() {
		clickBtn(xPathPanelLAOSOSDetail, "Reset Shm Qty to 0 for All");
		waitForAllJSCompletes();
		waitForAllJSCompletes();
	}

	public void click_laosos_det_receive_all_ost_qty() {
		clickBtn(xPathPanelLAOSOSDetail, "Receive All Ost Qty (Exclude Lot & Serial Inventory)");
	}

	public int get_laosos_det_row_index_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelLAOSOSDetail, _no, 1, "No.", 1));
	}

	public String get_laosos_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Type");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex) + "//span").getText();
	}

	public String get_laosos_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex) + "//input").getTextValue();
	}

	public String get_laosos_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex)
				+ "//span[@class='description']").getText();
	}

	public String get_laosos_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "UOM");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Qty");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex) + "//input").getTextValue();
	}

	public String get_laosos_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Qty Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_no_of_pack_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "No. Of Pack Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_ost_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Ost Qty");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_unit_cost(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Unit Cost");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_discount(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Discount");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_total(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Total");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_add_cost_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Add cost Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_add_cost_home_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Add Cost Home Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_fl_total_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "FL Total Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_fl_total_home_amt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "FL Total Home Amt");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_laosos_det_serial_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Serial No");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public void enter_laosos_det_qty(int _rowIndex, String _qty) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, colIndex) + "//input[@type='text']", _qty);
	}

	public void enter_laosos_det_no_of_packs(int _rowIndex, String _noOfPacks) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "No. Of Packs");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, colIndex) + "//input[@type='text']",
				_noOfPacks);
	}

	public void open_laosos_det_lots_information(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Qty");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, colIndex) + "//a");
	}

	public void open_laosos_det_issuing_serial_number(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelLAOSOSDetail, "Serial No");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelLAOSOSDetail, _rowIndex, colIndex) + "//a");
	}

	// END Logistic Active Outstanding Shipment - Outgoing Shipment Details
	// BEGIN Logistic Active History Shipment - Outgoing Shipment Details
	// Detail
	private String xPathPanelLAHSOSDetail = "//table[contains(@id,'lgOutActiveShmHstDetTable')]/ancestor::tbody[1]";

	public int get_lahsos_det_row_index_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelLAHSOSDetail, _no, 1, "No.", 1));
	}

	public String get_lahsos_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAHSOSDetail, "Type");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAHSOSDetail, _rowIndex, headerIndex) + "//span").getText();
	}

	public String get_lahsos_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAHSOSDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAHSOSDetail, _rowIndex, headerIndex) + "//input").getTextValue();
	}

	public String get_lahsos_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAHSOSDetail, "Item Code/Remarks Description");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAHSOSDetail, _rowIndex, headerIndex)
				+ "//span[@class='description']").getText();
	}

	public String get_lahsos_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAHSOSDetail, "UOM");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAHSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lahsos_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAHSOSDetail, "Qty");
		return waitElementToBePresent(
				xPathTbDataCellByPosition(xPathPanelLAHSOSDetail, _rowIndex, headerIndex) + "//span").getTextValue();
	}

	public String get_lahsos_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelLAHSOSDetail, "Qty Req");
		return waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelLAHSOSDetail, _rowIndex, headerIndex))
				.getText();
	}

	// END Logistic Active History Shipment - Outgoing Shipment Details
}
