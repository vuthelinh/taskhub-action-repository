package com.synergix.processing.logistics.mergeshipment.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160405
 */
public class MergeOutShipmentPage extends TH5PageObject {
	public MergeOutShipmentPage(WebDriver driver) {
		super(driver);
	}

	// BEGIN LG Outgoing Merge Shipment
	private String xPathPanelLGIncomingMergeShipment = "(//*[@id='mainPanel']//div[text()='LG Outgoing Merge Shipment']//ancestor::div)[1]";
	private String xPathPanelShipmentVoucherCombination = xPathPanelLGIncomingMergeShipment
			+ "//div[contains(text(),'Shipment Voucher Combination')]//ancestor::tbody[1]";
	private String xPathTbShipmentVoucherCombination = xPathPanelShipmentVoucherCombination
			+ "//table[contains(@id,'lgOutShipmentListTable')]";

	public void click_btn_merge() {
		clickBtn(xPathPanelLGIncomingMergeShipment, "Merge");
	}

	public void click_btn_go() {
		clickBtn(xPathPanelLGIncomingMergeShipment, "Go");
	}

	public void enter_customer_code(String _customerCode) {
		enterInputFieldWithLabel(xPathPanelLGIncomingMergeShipment, "Customer Code", _customerCode);
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

	public String get_svc_customer_address() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Customer Address", 1);
	}

	public String get_svc_customer_contact() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Customer Contact", 1);
	}

	public String get_svc_shipment_mode() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Shipment Mode", 1);
	}

	public String get_svc_shipment_term() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Shipment Term", 1);
	}

	public String get_svc_loading_location() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Loading Location", 1);
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

	public String get_svc_payment_option() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Payment Option", 1);
	}

	public String get_svc_payment_term() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Payment Term", 1);
	}

	public String get_svc_payment_method() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Payment Method", 1);
	}

	public String get_svc_payment_tenor() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Payment Tenor", 1);
	}

	public String get_svc_billing_party() {
		return getTextWithLabel(xPathPanelShipmentVoucherCombination, "Billing Party", 1);
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
	// END LG Outgoing Merge Shipment

	// BEGIN Logistic Outgoing Details
	private String xPathPanelLogisticOutgoingDetails = "//div[contains(text(),'Logistic Outgoing Details')]//ancestor::table[1]";

	public void click_btn_lod_done() {
		clickBtn(xPathPanelLogisticOutgoingDetails, "Done");
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

	public String get_lod_shipment_no() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment No. / Priority", 1)
						+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lod_priority() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment No. / Priority", 1);
	}

	public String get_lod_customer() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Customer", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_customer_name() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Customer", 1);
	}

	public String get_lod_sales_person() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Sales Person", 1) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_sales_person_name() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Sales Person", 1);
	}

	public String get_lod_customer_po_no() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Customer PO No.", 1);
	}

	public String get_lod_reference_no() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Reference No.", 1);
	}

	public String get_lod_subject() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Subject", 1);
	}

	public String get_lod_do_no() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "DO No.", 1);
	}

	// BEGIN Header tab
	public String get_lod_order_currency() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Order Currency", 1);
	}

	public String get_lod_actual_shipment_date() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Actual Shipment Date", 1);
	}

	public String get_lod_requested_shipment_date() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Requested Shipment Date", 1);
	}

	public String get_lod_actual_arrival_date() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Actual Arrival Date", 1);
	}

	public String get_lod_requested_arrival_date() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Requested Arrival Date", 1);
	}

	public String get_lod_original_shipment_date() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Original Shipment Date", 1);
	}

	public String get_lod_shipment_mode() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment Mode", 1) + "//ancestor::td[1]")
						.getText();
	}

	public String get_lod_shipment_mode_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment Mode", 1);
	}

	public String get_lod_shipment_term() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment Mode", 1) + "//ancestor::td[1]")
						.getText();
	}

	public String get_lod_shipment_term_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment Term", 1);
	}

	public String get_lod_loading_location() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Loading Location", 1) + "//ancestor::td[1]")
						.getText();
	}

	public String get_lod_loading_location_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Loading Location", 1);
	}

	public String get_lod_shipping_coordinator() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipping Coordinator", 2)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lod_shipping_coordinator_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipping Coordinator", 2);
	}

	public String get_lod_ship_to_address() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Ship To Address", 2)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lod_ship_to_address_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Ship To Address", 2);
	}

	public String get_lod_ship_to_contact() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Ship To Contact", 2)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lod_ship_to_contact_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Ship To Contact", 2);
	}

	public String get_lod_forwarder() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Forwarder", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_forwarder_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Forwarder", 2);
	}

	public String get_lod_trucker() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Trucker", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_trucker_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Trucker", 2);
	}

	public String get_lod_purchase_category() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Purchase Category", 2)
				+ "/preceding-sibling::input").getTextValue();
	}

	public String get_lod_purchase_category_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Purchase Category", 2);
	}

	public String get_lod_haulier() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Haulier", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_haulier_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Haulier", 2);
	}

	public String get_lod_container_no() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Container No", 1);
	}

	public String get_lod_seal_no() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Seal No", 1);
	}

	public String get_lod_sales_category() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Sales Category", 2);
	}

	public String get_lod_internal_remarks() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Internal Remarks", 1);
	}

	public String get_lod_external_remarks() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "External Remarks", 1);
	}

	public String get_lod_shipment_instruction() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Shipment Instruction", 1);
	}

	// END Header tab
	// BEGIN Detail tab
	private String xPathTbOstDetails = xPathPanelLogisticOutgoingDetails
			+ "//table[contains(@id,'lgOutActiveShmOstDetTable')]";
	private String xPathTbAllocationDetails = xPathPanelLogisticOutgoingDetails
			+ "//table[contains(@id,'detAllocTable')]";

	public int get_lod_det_row_index_by_no(String _no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbOstDetails, _no, 1, "No.", 1));
	}

	public int get_lod_det_allocation_row_index_by_allocation_no(String _allocationNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathTbAllocationDetails, _allocationNo, 1, "Allocation No.", 1));
	}

	public void select_lod_detail_item(int _rowIndex) {
		clickGreenArrow(xPathTbOstDetails, _rowIndex);
	}

	public void select_lod_detail_allocation(int _rowIndex) {
		clickGreenArrow(xPathTbAllocationDetails, _rowIndex);
	}

	public String get_lod_det_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Type");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//span")
				.getText();
	}

	public String get_lod_det_item_code(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Item Code/Remarks Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	public String get_lod_det_item_description(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Item Code/Remarks Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//span[@class='description']")
						.getTextValue();
	}

	public String get_lod_det_uom(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "UOM");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_qoh(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "QOH");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_lod_det_price_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Price Type");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_qty_req(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Qty Req");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_unit_price(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Unit Price");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_total(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Total");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_vol_wt(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Vol.Wt");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_det_weight(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Weight");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex) + "//input")
				.getTextValue();
	}

	public String get_lod_det_volume(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbOstDetails, "Volume");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbOstDetails, _rowIndex, headerIndex)).getText();
	}

	public String get_lod_allocation_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Type");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_voucher_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Voucher No.");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_phase_sequence_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Phase Sequence No.");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_schedule_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Schedule No");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_line_no(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Line No.");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_requested_alloc_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Requested Alloc Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_ost_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Ost Qty");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_requested_alloc_no_of_pack(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Requested Alloc No. of pack");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex))
				.getText();
	}

	public String get_lod_allocation_alloc_qty(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathTbAllocationDetails, "Alloc Qty");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathTbAllocationDetails, _rowIndex, headerIndex) + "//input").getTextValue();
	}
	// END Detail tab

	// BEGIN Shipping Info tab
	public String get_lod_booking_date() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Booking Date", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_booking_reference_no() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Booking Reference No.", 1);
	}

	public String get_lod_country_of_load() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Country / Port of Load", 1)
						+ "/preceding-sibling::input[contains(@class,'two-char')]").getTextValue();
	}

	public String get_lod_port_of_load() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Country / Port of Load", 1)
						+ "/preceding-sibling::input[contains(@class,'three-char')]").getTextValue();
	}

	public String get_lod_country_of_dischg() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Country / Port of Dischg", 1)
						+ "/preceding-sibling::input[contains(@class,'two-char')]").getTextValue();
	}

	public String get_lod_port_of_dischg() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Country / Port of Dischg", 1)
						+ "/preceding-sibling::input[contains(@class,'three-char')]").getTextValue();
	}

	public String get_lod_country_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Country / Port of FD", 1)
				+ "/preceding-sibling::input[contains(@class,'two-char')]").getTextValue();
	}

	public String get_lod_port_of_fd() {
		return waitElementToBeVisible(xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Country / Port of FD", 1)
				+ "/preceding-sibling::input[contains(@class,'three-char')]").getTextValue();
	}

	public String get_lod_carrier() {
		return waitElementToBeVisible(
				xPathTextWithLabel(xPathPanelLogisticOutgoingDetails, "Carrier", 2) + "/preceding-sibling::input")
						.getTextValue();
	}

	public String get_lod_carrier_des() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Carrier", 2);
	}

	public String get_lod_flight_no() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Flight No", 2);
	}

	public String get_lod_date_of_manufacture() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "Date of Manufacture", 1);
	}

	public String get_lod_eta_etd_pol() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "ETA/ETD (POL)", 1);
	}

	public String get_lod_eta_time_pol() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "ETA - Time (POL) hh:mm", 1);
	}

	public String get_lod_eta_fd() {
		return getTextWithLabel(xPathPanelLogisticOutgoingDetails, "ETA (FD)", 1);
	}

	public String get_lod_eta_time_fd() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "ETA - Time (FD) hh:mm", 1);
	}

	public String get_lod_mawb() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "MAWB", 1);
	}

	public String get_lod_hawb() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "HAWB", 1);
	}

	public String get_lod_products_description() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Products Description", 1);
	}

	public String get_lod_remarks_to_trucker_haulier() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Remarks to Trucker / Haulier", 1);
	}

	public String get_lod_shipping_marks() {
		return getTextValueWithLabel(xPathPanelLogisticOutgoingDetails, "Shipping Marks", 1);
	}

	// END Shipping Info tab
	// BEGIN Attachment tab
	private String xPathPanelAttachment = xPathPanelLogisticOutgoingDetails
			+ "//span[contains(@id,'draftAttachmentPanel')]";

	public void click_btn_lod_add_attachment() {
		clickBtn(xPathPanelAttachment, "Add");
	}

	public void click_btn_lod_delete_attachment() {
		clickBtn(xPathPanelAttachment, "Delete");
	}

	public void click_btn_lod_cancel_attachment() {
		clickBtn(xPathPanelAttachment, "Cancel");
	}

	public void choose_lod_attachment_file(String _filePath) {
		waitElementToBePresent(xPathPanelAttachment + "//input[@type='file']").sendKeys(_filePath);
	}

	public int get_lod_att_row_by_no(String _AttachmentNo) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _AttachmentNo, 1, "No.", 1));
	}

	public void click_btn_lod_upload_attachment() {
		clickBtn(xPathPanelAttachment, "Upload");
		waitForAllJSCompletes();
		withTimeoutOf(60, TimeUnit.SECONDS).waitForAbsenceOf(xPathBtn(xPathPanelAttachment, "Upload"));
	}

	public void enter_lod_file_description(int _rowIndex, String _fileDescription) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex,
						headerIndex) + "//input[1]",
				_fileDescription);
	}

	public String get_lod_new_file_mime_type(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"MIME Type");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}

	public String get_lod_new_file_file_size(int _rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]",
				"File Size");
		return waitElementToBePresent(xPathTbDataCellByPosition(
				xPathPanelAttachment + "//table[contains(@id,'tblAttachment')]", _rowIndex, headerIndex)).getText();
	}
	// END Attachment tab

	// END Logistic Outgoing Details

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

	// END LG Outgoing Merge Shipment

}
