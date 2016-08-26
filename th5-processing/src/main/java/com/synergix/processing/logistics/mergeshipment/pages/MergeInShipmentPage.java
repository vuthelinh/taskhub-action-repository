package com.synergix.processing.logistics.mergeshipment.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160322
 */
public class MergeInShipmentPage extends TH5PageObject {
	public MergeInShipmentPage(WebDriver driver) {
		super(driver);
	}

	// BEGIN LG Incoming Merge Shipment
	private String xPathPanelLGIncomingMergeShipment = "(//*[@id='mainPanel']//div[text()='LG Incoming Merge Shipment']//ancestor::div)[1]";
	private String xPathPanelShipmentVoucherCombination = xPathPanelLGIncomingMergeShipment
			+ "//div[contains(text(),'Shipment Voucher Combination')]//ancestor::tbody[1]";
	private String xPathTbShipmentVoucherCombination = xPathPanelShipmentVoucherCombination
			+ "//table[contains(@id,'lgInShipmentListTable')]";

	public void click_btn_merge() {
		clickBtn(xPathPanelLGIncomingMergeShipment, "Merge");
	}

	public void click_btn_go() {
		clickBtn(xPathPanelLGIncomingMergeShipment, "Go");
	}

	public void enter_supplier_code(String _supplierCode) {
		enterInputFieldWithLabel(xPathPanelLGIncomingMergeShipment, "Supplier Code", _supplierCode);
	}

	public void enter_new_shipment_date(String _newShipmentDate) {
		enterInputFieldWithLabel(xPathPanelLGIncomingMergeShipment, "New Shipment Date", _newShipmentDate);
	}

	public boolean search_by_supplier_code(String _supplierCode) {
		clickSearchIconWithLabel(xPathPanelLGIncomingMergeShipment, "Supplier Code");
		return search("Supplier Code", _supplierCode);
	}

	public String get_svc_currency() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Currency", 1);
	}

	public String get_svc_supplier_contact() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Supplier Contact", 1);
	}

	public String get_svc_shipment_mode() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Shipment Mode", 1);
	}

	public String get_svc_shipment_term() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Shipment Term", 1);
	}

	public String get_svc_receiving_location() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Receiving Location", 1);
	}

	public String get_svc_port_of_loading() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Port of Loading", 1);
	}

	public String get_svc_port_of_discharge() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Port of Discharge", 1);
	}

	public String get_svc_port_of_final_destination() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Port of Final Destination", 1);
	}

	public String get_svc_ship_to_address() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Ship To Address", 1);
	}

	public String get_svc_ship_to_contact() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Ship To Contact", 1);
	}

	public String get_svc_ship_through() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Ship Through", 1);
	}

	public String get_svc_segment_1() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Segment 1", 1);
	}

	public String get_svc_segment_2() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Segment 2", 1);
	}

	public String get_svc_segment_3() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Segment 3", 1);
	}

	public String get_svc_segment_4() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Segment 4", 1);
	}

	public void select_svc_voucher_by_shipment_voucher_no(String _shipmentVoucherNo) {
		int rowIndex = searchInTbMultiPage(xPathTbShipmentVoucherCombination, "Shipment Voucher No.", 1,
				_shipmentVoucherNo, true);
		setChkbox(
				xPathTbDataCellByPosition(xPathTbShipmentVoucherCombination, rowIndex, 1) + "//input[@type='checkbox']",
				"true");
	}

	public void select_svc_voucher_by_source_voucher_no(String _sourceVoucherNo) {
		int rowIndex = searchInTbMultiPage(xPathTbShipmentVoucherCombination, "Source Voucher No.", 1, _sourceVoucherNo,
				true);
		setChkbox(
				xPathTbDataCellByPosition(xPathTbShipmentVoucherCombination, rowIndex, 1) + "//input[@type='checkbox']",
				"true");
	}

	public void open_svc_shipment_voucher_by_shipment_voucher_no(String _shipmentVoucherNo) {
		int rowIndex = searchInTbMultiPage(xPathTbShipmentVoucherCombination, "Shipment Voucher No.", 1,
				_shipmentVoucherNo, true);
		clickOnElement(xPathTbDataCellByPosition(xPathTbShipmentVoucherCombination, rowIndex, 2) + "//a");
	}

	public void open_svc_shipment_voucher_by_source_voucher_no(String _sourceVoucherNo) {
		int rowIndex = searchInTbMultiPage(xPathTbShipmentVoucherCombination, "Source Voucher No.", 1, _sourceVoucherNo,
				true);
		clickOnElement(xPathTbDataCellByPosition(xPathTbShipmentVoucherCombination, rowIndex, 2) + "//a");
	}
	// END LG Incoming Merge Shipment

	// BEGIN Logistic Incoming Details
	private String xPathPanelLogisticIncomingDetails = "//div[contains(text(),'Logistic Incoming Details')]//ancestor::table[1]";

	public void click_btn_lid_revert() {
		clickBtn(xPathPanelLogisticIncomingDetails, "Revert");
	}

	public void click_btn_lid_done() {
		clickBtn(xPathPanelLogisticIncomingDetails, "Done");
	}

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

	public String get_lid_shipment_no() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Shipment No. / Priority", 1)
						+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lid_priority() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Shipment No. / Priority", 1);
	}

	public String get_lid_supplier() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lid_supplier_name() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier", 1);
	}

	public String get_lid_contact_person() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Contact Person", 1)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lid_contact_person_name() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Contact Person", 1);
	}

	public String get_lid_source_voucher_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Source Voucher No.", 1);
	}

	public String get_lid_supplier_do_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier DO No.", 1);
	}

	public String get_lid_supplier_do_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier DO Date", 1);
	}

	public String get_lid_supplier_invoice_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier Invoice No.", 1);
	}

	public String get_lid_supplier_invoice_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier Invoice Date", 1);
	}

	public String get_lid_exchange_rate() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Exchange Rate", 1);
	}

	public String get_lid_currency() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Supplier", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lid_currency_name() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Currency", 1);
	}

	public String get_lid_subject() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Subject", 1);
	}

	public String get_lid_gnr_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "GRN No.", 1);
	}

	public String get_lid_is_replacement() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Is Replacement", 1);
	}

	public String get_lid_source_shipment_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Source Shipment No.", 1);
	}

	// BEGIN Header tab
	public String get_lid_actual_shipment_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Actual Shipment Date", 1);
	}

	public String get_lid_estimated_shipment_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Estimated Shipment Date", 1);
	}

	public String get_lid_actual_arrival_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Actual Arrival Date", 1);
	}

	public String get_lid_estimated_arrival_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Estimated Arrival Date", 1);
	}

	public String get_lid_goods_receipt_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Goods Receipt Date", 1);
	}

	public String get_lid_reference_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Reference No.", 1);
	}

	public String get_lid_shipment_mode() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Shipment Mode / Term", 1)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lid_shipment_term() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Shipment Mode / Term", 1);
	}

	public String get_lid_receiving_location() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Receiving Location", 1)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lid_receiving_location_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Receiving Location", 1);
	}

	public String get_lid_shipping_coordinator() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Shipping Coordinator", 2)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lid_shipping_coordinator_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Shipping Coordinator", 2);
	}

	public String get_lid_forwarder() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Forwarder", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lid_forwarder_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Forwarder", 2);
	}

	public String get_lid_trucker() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Trucker", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lid_trucker_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Trucker", 2);
	}

	public String get_lid_purchase_category() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Purchase Category", 2)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lid_purchase_category_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Purchase Category", 2);
	}

	public String get_lid_haulier() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Haulier", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lid_haulier_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Haulier", 2);
	}

	public String get_lid_internal_remarks() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Internal Remarks", 1);
	}

	public String get_lid_external_remarks() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "External Remarks", 1);
	}

	// END Header tab
	// BEGIN Detail tab
	private String xPathTbOstDetails = xPathPanelLogisticIncomingDetails
			+ "//table[contains(@id,'lgInActiveShmOstDetTable')]";
	private String xPathTbAllocationDetails = xPathPanelLogisticIncomingDetails
			+ "//table[contains(@id,'detAllocTable')]";

	public int get_lid_det_row_index_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbOstDetails, _no, 1, "No.", 1));
	}

	public int get_lid_det_allocation_row_index_by_allocation_no(String _allocationNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathTbAllocationDetails, _allocationNo, 1, "Allocation No.", 1));
	}

	public void select_lid_detail_item(int _rowIndex) {
		clickGreenArrow(xPathTbOstDetails, _rowIndex);
	}

	public void select_lid_detail_allocation(int _rowIndex) {
		clickGreenArrow(xPathTbAllocationDetails, _rowIndex);
	}

	public String get_lid_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Type");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_lid_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Item Code/Remarks Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	public String get_lid_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Item Code/Remarks Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//span[@class='description']")
						.getTextValue();
	}

	public String get_lid_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "UOM");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lid_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_lid_det_pack_size(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Pack Size");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_lid_det_no_of_pack(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "No. of pack");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_lid_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Qty Req");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lid_det_no_of_pack_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "No. Of Pack Req");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lid_det_cost_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "No. Of Pack Req");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_lid_allocation_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Type");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_voucher_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Voucher No.");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_phase_sequence_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Phase Sequence No.");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_schedule_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Schedule No");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_line_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Line No.");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_requested_alloc_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Requested Alloc Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_ost_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Ost Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_requested_alloc_no_of_pack(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Requested Alloc No. of pack");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lid_allocation_alloc_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Alloc Qty");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex) + "//input").getTextValue();
	}
	// END Detail tab

	// BEGIN Shipping Info tab
	public String get_lid_booking_date() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Booking Date", 1);
	}

	public String get_lid_booking_reference_no() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Booking Reference No.", 1);
	}

	public String get_lid_country_of_load() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Country / Port of Load", 1)
				+ "/preceding-sibling::input[contains(@class,'two-char')]").getTextValue();
	}

	public String get_lid_port_of_load() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Country / Port of Load", 1)
				+ "/preceding-sibling::input[contains(@class,'three-char')]").getTextValue();
	}

	public String get_lid_country_of_dischg() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Country / Port of Dischg", 1)
						+ "/preceding-sibling::input[contains(@class,'two-char')]").getTextValue();
	}

	public String get_lid_port_of_dischg() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Country / Port of Dischg", 1)
						+ "/preceding-sibling::input[contains(@class,'three-char')]").getTextValue();
	}

	public String get_lid_country_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Country / Port of FD", 1)
				+ "/preceding-sibling::input[contains(@class,'two-char')]").getTextValue();
	}

	public String get_lid_port_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Country / Port of FD", 1)
				+ "/preceding-sibling::input[contains(@class,'three-char')]").getTextValue();
	}

	public String get_lid_carrier() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticIncomingDetails, "Carrier", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lid_carrier_des() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Carrier", 2);
	}

	public String get_lid_flight_no() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "Flight No", 2);
	}

	public String get_lid_date_of_manufacture() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "Date of Manufacture", 1);
	}

	public String get_lid_eta_etd_pol() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "ETA/ETD (POL)", 1);
	}

	public String get_lid_eta_time_pol() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "ETA - Time (POL) hh:mm", 1);
	}

	public String get_lid_eta_fd() {
		return getTextWithLabel(xPathPanelLogisticIncomingDetails, "ETA (FD)", 1);
	}

	public String get_lid_eta_time_fd() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "ETA - Time (FD) hh:mm", 1);
	}

	public String get_lid_mawb() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "MAWB", 1);
	}

	public String get_lid_hawb() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "HAWB", 1);
	}

	public String get_lid_remarks_to_trucker_haulier() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "Remarks to Trucker / Haulier", 1);
	}

	public String get_lid_shipping_marks() {
		return getTextValueWithLabel(xPathPanelLogisticIncomingDetails, "Shipping Marks", 1);
	}

	// END Shipping Info tab
	// BEGIN Attachment tab
	private String xPathPanelAttachment = xPathPanelLogisticIncomingDetails
			+ "//span[contains(@id,'draftAttachmentPanel')]";

	public void click_btn_lid_add_attachment() {
		clickBtn(xPathPanelAttachment, "Add");
	}

	public void click_btn_lid_delete_attachment() {
		clickBtn(xPathPanelAttachment, "Delete");
	}

	public void click_btn_lid_cancel_attachment() {
		clickBtn(xPathPanelAttachment, "Cancel");
	}

	public void choose_lid_attachment_file(String _filePath) {
		waitElementToBePresent(xPathPanelAttachment + "//input[@type='file']").sendKeys(_filePath);
	}

	public int get_lid_att_row_by_no(String _AttachmentNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _AttachmentNo, 1, "No.", 1));
	}

	public void click_btn_lid_upload_attachment() {
		clickBtn(xPathPanelAttachment, "Upload");
		waitForAllJSCompletes();
		withTimeoutOf(60, TimeUnit.SECONDS).waitForAbsenceOf(xPathBtn(xPathPanelAttachment, "Upload"));
	}

	public void enter_lid_file_description(int _rowIndex, String _fileDescription) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex,
						headerIndex) + "//input[1]",
				_fileDescription);
	}

	public String get_lid_new_file_mime_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"MIME Type");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	public String get_lid_new_file_file_size(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Size");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}
	// END Attachment tab

	// END Logistic Incoming Details

	private String xPathPanelConfirmMerge = "//div[" + sSpecialTextPredicates("You Are about to Merge Shipments")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmMerge() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmMerge).shouldBeVisible();
		clickBtn(xPathPanelConfirmMerge, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmMerge);
	}

	public void clickBtnNoOnConfirmMerge() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmMerge).shouldBeVisible();
		clickBtn(xPathPanelConfirmMerge, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmMerge);
	}

	private String xPathPanelInfoMessages = "//div[" + sSpecialTextPredicates("Info Message")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public String getInfoMessagesThenClickOK() {
		if (isElementVisible(xPathPanelInfoMessages, 2)) {
			String message = "";
			for (WebElementFacade el : findAll(xPathPanelInfoMessages + "//li")) {
				message += el.getText() + System.getProperty("line.separator");
			}
			clickBtn(xPathPanelInfoMessages, "OK");
			System.out.print(message);
			return message;
		} else {
			return null;
		}
	}

	// END LG Incoming Merge Shipment
}
