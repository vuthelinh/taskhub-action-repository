package com.synergix.processing.logistics.mergeshipment.steps;

import com.synergix.processing.logistics.mergeshipment.pages.MergeInShipmentPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class MergeInShipmentSteps extends ScenarioSteps {
	MergeInShipmentPage mergeInShipmentPage;

	// BEGIN LG Incoming Merge Shipment
	@Step
	public void click_btn_merge() {
		mergeInShipmentPage.click_btn_merge();
	}

	@Step
	public void click_btn_go() {
		mergeInShipmentPage.click_btn_go();
	}

	@Step
	public void enter_supplier_code(String _supplierCode) {
		mergeInShipmentPage.enter_supplier_code(_supplierCode);
	}

	@Step
	public void enter_new_shipment_date(String _newShipmentDate) {
		mergeInShipmentPage.enter_new_shipment_date(_newShipmentDate);
	}

	@Step
	public boolean search_by_supplier_code(String _supplierCode) {
		return mergeInShipmentPage.search_by_supplier_code(_supplierCode);
	}

	@Step
	public String get_svc_currency() {
		return mergeInShipmentPage.get_svc_currency();
	}

	@Step
	public String get_svc_supplier_contact() {
		return mergeInShipmentPage.get_svc_supplier_contact();
	}

	@Step
	public String get_svc_shipment_mode() {
		return mergeInShipmentPage.get_svc_shipment_mode();
	}

	@Step
	public String get_svc_shipment_term() {
		return mergeInShipmentPage.get_svc_shipment_term();
	}

	@Step
	public String get_svc_receiving_location() {
		return mergeInShipmentPage.get_svc_receiving_location();
	}

	@Step
	public String get_svc_port_of_loading() {
		return mergeInShipmentPage.get_svc_port_of_loading();
	}

	@Step
	public String get_svc_port_of_discharge() {
		return mergeInShipmentPage.get_svc_port_of_discharge();
	}

	@Step
	public String get_svc_port_of_final_destination() {
		return mergeInShipmentPage.get_svc_port_of_final_destination();
	}

	@Step
	public String get_svc_ship_to_address() {
		return mergeInShipmentPage.get_svc_ship_to_address();
	}

	@Step
	public String get_svc_ship_to_contact() {
		return mergeInShipmentPage.get_svc_ship_to_contact();
	}

	@Step
	public String get_svc_ship_through() {
		return mergeInShipmentPage.get_svc_ship_through();
	}

	@Step
	public String get_svc_segment_1() {
		return mergeInShipmentPage.get_svc_segment_1();
	}

	@Step
	public String get_svc_segment_2() {
		return mergeInShipmentPage.get_svc_segment_2();
	}

	@Step
	public String get_svc_segment_3() {
		return mergeInShipmentPage.get_svc_segment_3();
	}

	@Step
	public String get_svc_segment_4() {
		return mergeInShipmentPage.get_svc_segment_4();
	}

	@Step
	public void select_svc_voucher_by_shipment_voucher_no(String _shipmentVoucherNo) {
		mergeInShipmentPage.select_svc_voucher_by_shipment_voucher_no(_shipmentVoucherNo);
	}

	@Step
	public void select_svc_voucher_by_source_voucher_no(String _sourceVoucherNo) {
		mergeInShipmentPage.select_svc_voucher_by_source_voucher_no(_sourceVoucherNo);
	}

	@Step
	public void open_svc_shipment_voucher_by_shipment_voucher_no(String _shipmentVoucherNo) {
		mergeInShipmentPage.open_svc_shipment_voucher_by_shipment_voucher_no(_shipmentVoucherNo);
	}

	@Step
	public void open_svc_shipment_voucher_by_source_voucher_no(String _sourceVoucherNo) {
		mergeInShipmentPage.open_svc_shipment_voucher_by_source_voucher_no(_sourceVoucherNo);
	}
	// END LG Incoming Merge Shipment

	// BEGIN Logistic Incoming Details
	@Step
	public void click_btn_lid_revert() {
		mergeInShipmentPage.click_btn_lid_revert();
	}

	@Step
	public void click_btn_lid_done() {
		mergeInShipmentPage.click_btn_lid_done();
	}

	@Step
	public void switch_to_tab_header() {
		mergeInShipmentPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_detail() {
		mergeInShipmentPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_shipping_info() {
		mergeInShipmentPage.switch_to_tab_shipping_info();
	}

	@Step
	public void switch_to_tab_attachments() {
		mergeInShipmentPage.switch_to_tab_attachments();
	}

	@Step
	public String get_lid_shipment_no() {
		return mergeInShipmentPage.get_lid_shipment_no();
	}

	@Step
	public String get_lid_priority() {
		return mergeInShipmentPage.get_lid_priority();
	}

	@Step
	public String get_lid_supplier() {
		return mergeInShipmentPage.get_lid_supplier();
	}

	@Step
	public String get_lid_supplier_name() {
		return mergeInShipmentPage.get_lid_supplier_name();
	}

	@Step
	public String get_lid_contact_person() {
		return mergeInShipmentPage.get_lid_contact_person();
	}

	@Step
	public String get_lid_contact_person_name() {
		return mergeInShipmentPage.get_lid_contact_person_name();
	}

	@Step
	public String get_lid_source_voucher_no() {
		return mergeInShipmentPage.get_lid_source_voucher_no();
	}

	@Step
	public String get_lid_supplier_do_no() {
		return mergeInShipmentPage.get_lid_supplier_do_no();
	}

	@Step
	public String get_lid_supplier_do_date() {
		return mergeInShipmentPage.get_lid_supplier_do_date();
	}

	@Step
	public String get_lid_supplier_invoice_no() {
		return mergeInShipmentPage.get_lid_supplier_invoice_no();
	}

	@Step
	public String get_lid_supplier_invoice_date() {
		return mergeInShipmentPage.get_lid_supplier_invoice_date();
	}

	@Step
	public String get_lid_exchange_rate() {
		return mergeInShipmentPage.get_lid_exchange_rate();
	}

	@Step
	public String get_lid_currency() {
		return mergeInShipmentPage.get_lid_currency();
	}

	@Step
	public String get_lid_currency_name() {
		return mergeInShipmentPage.get_lid_currency_name();
	}

	@Step
	public String get_lid_subject() {
		return mergeInShipmentPage.get_lid_subject();
	}

	@Step
	public String get_lid_gnr_no() {
		return mergeInShipmentPage.get_lid_gnr_no();
	}

	@Step
	public String get_lid_is_replacement() {
		return mergeInShipmentPage.get_lid_is_replacement();
	}

	@Step
	public String get_lid_source_shipment_no() {
		return mergeInShipmentPage.get_lid_source_shipment_no();
	}

	// BEGIN Header tab
	@Step
	public String get_lid_actual_shipment_date() {
		return mergeInShipmentPage.get_lid_actual_shipment_date();
	}

	@Step
	public String get_lid_estimated_shipment_date() {
		return mergeInShipmentPage.get_lid_estimated_shipment_date();
	}

	@Step
	public String get_lid_actual_arrival_date() {
		return mergeInShipmentPage.get_lid_actual_arrival_date();
	}

	@Step
	public String get_lid_estimated_arrival_date() {
		return mergeInShipmentPage.get_lid_estimated_arrival_date();
	}

	@Step
	public String get_lid_goods_receipt_date() {
		return mergeInShipmentPage.get_lid_goods_receipt_date();
	}

	@Step
	public String get_lid_reference_no() {
		return mergeInShipmentPage.get_lid_reference_no();
	}

	@Step
	public String get_lid_shipment_mode() {
		return mergeInShipmentPage.get_lid_shipment_mode();
	}

	@Step
	public String get_lid_shipment_term() {
		return mergeInShipmentPage.get_lid_shipment_term();
	}

	@Step
	public String get_lid_receiving_location() {
		return mergeInShipmentPage.get_lid_receiving_location();
	}

	@Step
	public String get_lid_receiving_location_des() {
		return mergeInShipmentPage.get_lid_receiving_location_des();
	}

	@Step
	public String get_lid_shipping_coordinator() {
		return mergeInShipmentPage.get_lid_shipping_coordinator();
	}

	@Step
	public String get_lid_shipping_coordinator_des() {
		return mergeInShipmentPage.get_lid_shipping_coordinator_des();
	}

	@Step
	public String get_lid_forwarder() {
		return mergeInShipmentPage.get_lid_forwarder();
	}

	@Step
	public String get_lid_forwarder_des() {
		return mergeInShipmentPage.get_lid_forwarder_des();
	}

	@Step
	public String get_lid_trucker() {
		return mergeInShipmentPage.get_lid_trucker();
	}

	@Step
	public String get_lid_trucker_des() {
		return mergeInShipmentPage.get_lid_trucker_des();
	}

	@Step
	public String get_lid_purchase_category() {
		return mergeInShipmentPage.get_lid_purchase_category();
	}

	@Step
	public String get_lid_purchase_category_des() {
		return mergeInShipmentPage.get_lid_purchase_category_des();
	}

	@Step
	public String get_lid_haulier() {
		return mergeInShipmentPage.get_lid_haulier();
	}

	@Step
	public String get_lid_haulier_des() {
		return mergeInShipmentPage.get_lid_haulier_des();
	}

	@Step
	public String get_lid_internal_remarks() {
		return mergeInShipmentPage.get_lid_internal_remarks();
	}

	@Step
	public String get_lid_external_remarks() {
		return mergeInShipmentPage.get_lid_external_remarks();
	}

	// END Header tab
	// BEGIN Detail tab
	@Step
	public int get_lid_det_row_index_by_no(String _no) {
		return mergeInShipmentPage.get_lid_det_row_index_by_no(_no);
	}

	@Step
	public int get_lid_det_allocation_row_index_by_allocation_no(String _allocationNo) {
		return mergeInShipmentPage.get_lid_det_allocation_row_index_by_allocation_no(_allocationNo);
	}

	@Step
	public void select_lid_detail_item(int _rowIndex) {
		mergeInShipmentPage.select_lid_detail_item(_rowIndex);
	}

	@Step
	public void select_lid_detail_allocation(int _rowIndex) {
		mergeInShipmentPage.select_lid_detail_allocation(_rowIndex);
	}

	@Step
	public String get_lid_det_type(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_type(_rowIndex);
	}

	@Step
	public String get_lid_det_item_code(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_item_code(_rowIndex);
	}

	@Step
	public String get_lid_det_item_description(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_item_description(_rowIndex);
	}

	@Step
	public String get_lid_det_uom(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_uom(_rowIndex);
	}

	@Step
	public String get_lid_det_qty(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_qty(_rowIndex);
	}

	@Step
	public String get_lid_det_pack_size(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_pack_size(_rowIndex);
	}

	@Step
	public String get_lid_det_no_of_pack(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_no_of_pack(_rowIndex);
	}

	@Step
	public String get_lid_det_qty_req(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_qty_req(_rowIndex);
	}

	@Step
	public String get_lid_det_no_of_pack_req(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_no_of_pack_req(_rowIndex);
	}

	@Step
	public String get_lid_det_cost_type(int _rowIndex) {
		return mergeInShipmentPage.get_lid_det_cost_type(_rowIndex);
	}

	@Step
	public String get_lid_allocation_type(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_type(_rowIndex);
	}

	@Step
	public String get_lid_allocation_voucher_no(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_voucher_no(_rowIndex);
	}

	@Step
	public String get_lid_allocation_phase_sequence_no(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_phase_sequence_no(_rowIndex);
	}

	@Step
	public String get_lid_allocation_schedule_no(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_schedule_no(_rowIndex);
	}

	@Step
	public String get_lid_allocation_line_no(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_line_no(_rowIndex);
	}

	@Step
	public String get_lid_allocation_requested_alloc_qty(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_requested_alloc_qty(_rowIndex);
	}

	@Step
	public String get_lid_allocation_ost_qty(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_ost_qty(_rowIndex);
	}

	@Step
	public String get_lid_allocation_requested_alloc_no_of_pack(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_requested_alloc_no_of_pack(_rowIndex);
	}

	@Step
	public String get_lid_allocation_alloc_qty(int _rowIndex) {
		return mergeInShipmentPage.get_lid_allocation_alloc_qty(_rowIndex);
	}
	// END Detail tab

	// BEGIN Shipping Info tab
	@Step
	public String get_lid_booking_date() {
		return mergeInShipmentPage.get_lid_booking_date();
	}

	@Step
	public String get_lid_booking_reference_no() {
		return mergeInShipmentPage.get_lid_booking_reference_no();
	}

	@Step
	public String get_lid_country_of_load() {
		return mergeInShipmentPage.get_lid_country_of_load();
	}

	@Step
	public String get_lid_port_of_load() {
		return mergeInShipmentPage.get_lid_port_of_load();
	}

	@Step
	public String get_lid_country_of_dischg() {
		return mergeInShipmentPage.get_lid_country_of_dischg();
	}

	@Step
	public String get_lid_port_of_dischg() {
		return mergeInShipmentPage.get_lid_port_of_dischg();
	}

	@Step
	public String get_lid_country_of_fd() {
		return mergeInShipmentPage.get_lid_country_of_fd();
	}

	@Step
	public String get_lid_port_of_fd() {
		return mergeInShipmentPage.get_lid_port_of_fd();
	}

	@Step
	public String get_lid_carrier() {
		return mergeInShipmentPage.get_lid_carrier();
	}

	@Step
	public String get_lid_carrier_des() {
		return mergeInShipmentPage.get_lid_carrier_des();
	}

	@Step
	public String get_lid_flight_no() {
		return mergeInShipmentPage.get_lid_flight_no();
	}

	@Step
	public String get_lid_date_of_manufacture() {
		return mergeInShipmentPage.get_lid_date_of_manufacture();
	}

	@Step
	public String get_lid_eta_etd_pol() {
		return mergeInShipmentPage.get_lid_eta_etd_pol();
	}

	@Step
	public String get_lid_eta_time_pol() {
		return mergeInShipmentPage.get_lid_eta_time_pol();
	}

	@Step
	public String get_lid_eta_fd() {
		return mergeInShipmentPage.get_lid_eta_fd();
	}

	@Step
	public String get_lid_eta_time_fd() {
		return mergeInShipmentPage.get_lid_eta_time_fd();
	}

	@Step
	public String get_lid_mawb() {
		return mergeInShipmentPage.get_lid_mawb();
	}

	@Step
	public String get_lid_hawb() {
		return mergeInShipmentPage.get_lid_hawb();
	}

	@Step
	public String get_lid_remarks_to_trucker_haulier() {
		return mergeInShipmentPage.get_lid_remarks_to_trucker_haulier();
	}

	@Step
	public String get_lid_shipping_marks() {
		return mergeInShipmentPage.get_lid_shipping_marks();
	}

	// END Shipping Info tab
	// BEGIN Attachment tab
	@Step
	public void click_btn_lid_add_attachment() {
		mergeInShipmentPage.click_btn_lid_add_attachment();
	}

	@Step
	public void click_btn_lid_delete_attachment() {
		mergeInShipmentPage.click_btn_lid_delete_attachment();
	}

	@Step
	public void click_btn_lid_cancel_attachment() {
		mergeInShipmentPage.click_btn_lid_cancel_attachment();
	}

	@Step
	public void choose_lid_attachment_file(String _filePath) {
		mergeInShipmentPage.choose_lid_attachment_file(_filePath);
	}

	@Step
	public int get_lid_att_row_by_no(String _AttachmentNo) {
		return mergeInShipmentPage.get_lid_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_lid_upload_attachment() {
		mergeInShipmentPage.click_btn_lid_upload_attachment();
	}

	@Step
	public void enter_lid_file_description(int _rowIndex, String _fileDescription) {
		mergeInShipmentPage.enter_lid_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_lid_new_file_mime_type(int _rowIndex) {
		return mergeInShipmentPage.get_lid_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_lid_new_file_file_size(int _rowIndex) {
		return mergeInShipmentPage.get_lid_new_file_file_size(_rowIndex);
	}
	// END Attachment tab

	// END Logistic Incoming Details
	@Step
	public void clickBtnYesOnConfirmMerge() {
		mergeInShipmentPage.clickBtnYesOnConfirmMerge();
	}

	@Step
	public void clickBtnNoOnConfirmMerge() {
		mergeInShipmentPage.clickBtnNoOnConfirmMerge();
	}

	@Step
	public String getInfoMessagesThenClickOK() {
		return mergeInShipmentPage.getInfoMessagesThenClickOK();
	}
	// END LG Incoming Merge Shipment

}
