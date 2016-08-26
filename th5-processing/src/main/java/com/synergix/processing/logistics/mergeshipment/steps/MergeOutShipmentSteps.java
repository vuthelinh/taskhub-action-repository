package com.synergix.processing.logistics.mergeshipment.steps;

import com.synergix.processing.logistics.mergeshipment.pages.MergeOutShipmentPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160405
 */
public class MergeOutShipmentSteps extends ScenarioSteps {
	MergeOutShipmentPage mergeOutShipmentPage;

	// BEGIN LG Outgoing Merge Shipment
	@Step
	public void click_btn_merge() {
		mergeOutShipmentPage.click_btn_merge();
	}

	@Step
	public void click_btn_go() {
		mergeOutShipmentPage.click_btn_go();
	}

	@Step
	public void enter_customer_code(String _customerCode) {
		mergeOutShipmentPage.enter_customer_code(_customerCode);
	}

	@Step
	public void enter_new_shipment_date(String _newShipmentDate) {
		mergeOutShipmentPage.enter_new_shipment_date(_newShipmentDate);
	}

	@Step
	public boolean search_by_supplier_code(String _supplierCode) {
		return mergeOutShipmentPage.search_by_supplier_code(_supplierCode);
	}

	@Step
	public String get_svc_currency() {
		return mergeOutShipmentPage.get_svc_currency();
	}

	@Step
	public String get_svc_customer_address() {
		return mergeOutShipmentPage.get_svc_customer_address();
	}

	@Step
	public String get_svc_customer_contact() {
		return mergeOutShipmentPage.get_svc_customer_contact();
	}

	@Step
	public String get_svc_shipment_mode() {
		return mergeOutShipmentPage.get_svc_shipment_mode();
	}

	@Step
	public String get_svc_shipment_term() {
		return mergeOutShipmentPage.get_svc_shipment_term();
	}

	@Step
	public String get_svc_loading_location() {
		return mergeOutShipmentPage.get_svc_loading_location();
	}

	@Step
	public String get_svc_port_of_loading() {
		return mergeOutShipmentPage.get_svc_port_of_loading();
	}

	@Step
	public String get_svc_port_of_discharge() {
		return mergeOutShipmentPage.get_svc_port_of_discharge();
	}

	@Step
	public String get_svc_port_of_final_destination() {
		return mergeOutShipmentPage.get_svc_port_of_final_destination();
	}

	@Step
	public String get_svc_ship_to_address() {
		return mergeOutShipmentPage.get_svc_ship_to_address();
	}

	@Step
	public String get_svc_ship_to_contact() {
		return mergeOutShipmentPage.get_svc_ship_to_contact();
	}

	@Step
	public String get_svc_ship_through() {
		return mergeOutShipmentPage.get_svc_ship_through();
	}

	@Step
	public String get_svc_payment_option() {
		return mergeOutShipmentPage.get_svc_payment_option();
	}

	@Step
	public String get_svc_payment_term() {
		return mergeOutShipmentPage.get_svc_payment_term();
	}

	@Step
	public String get_svc_payment_method() {
		return mergeOutShipmentPage.get_svc_payment_method();
	}

	@Step
	public String get_svc_payment_tenor() {
		return mergeOutShipmentPage.get_svc_payment_tenor();
	}

	@Step
	public String get_svc_billing_party() {
		return mergeOutShipmentPage.get_svc_billing_party();
	}

	@Step
	public String get_svc_segment_1() {
		return mergeOutShipmentPage.get_svc_segment_1();
	}

	@Step
	public String get_svc_segment_2() {
		return mergeOutShipmentPage.get_svc_segment_2();
	}

	@Step
	public String get_svc_segment_3() {
		return mergeOutShipmentPage.get_svc_segment_3();
	}

	@Step
	public String get_svc_segment_4() {
		return mergeOutShipmentPage.get_svc_segment_4();
	}

	@Step
	public void select_svc_voucher_by_shipment_voucher_no(String _shipmentVoucherNo) {
		mergeOutShipmentPage.select_svc_voucher_by_shipment_voucher_no(_shipmentVoucherNo);
	}

	@Step
	public void select_svc_voucher_by_source_voucher_no(String _sourceVoucherNo) {
		mergeOutShipmentPage.select_svc_voucher_by_source_voucher_no(_sourceVoucherNo);
	}

	@Step
	public void open_svc_shipment_voucher_by_shipment_voucher_no(String _shipmentVoucherNo) {
		mergeOutShipmentPage.open_svc_shipment_voucher_by_shipment_voucher_no(_shipmentVoucherNo);
	}

	@Step
	public void open_svc_shipment_voucher_by_source_voucher_no(String _sourceVoucherNo) {
		mergeOutShipmentPage.open_svc_shipment_voucher_by_source_voucher_no(_sourceVoucherNo);
	}
	// END LG Outgoing Merge Shipment

	// BEGIN Logistic Outgoing Details
	@Step
	public void click_btn_lod_done() {
		mergeOutShipmentPage.click_btn_lod_done();
	}

	@Step
	public void switch_to_tab_header() {
		mergeOutShipmentPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_detail() {
		mergeOutShipmentPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_shipping_info() {
		mergeOutShipmentPage.switch_to_tab_shipping_info();
	}

	@Step
	public void switch_to_tab_attachments() {
		mergeOutShipmentPage.switch_to_tab_attachments();
	}

	@Step
	public String get_lod_shipment_no() {
		return mergeOutShipmentPage.get_lod_shipment_no();
	}

	@Step
	public String get_lod_priority() {
		return mergeOutShipmentPage.get_lod_priority();
	}

	@Step
	public String get_lod_customer() {
		return mergeOutShipmentPage.get_lod_customer();
	}

	@Step
	public String get_lod_customer_name() {
		return mergeOutShipmentPage.get_lod_customer_name();
	}

	@Step
	public String get_lod_sales_person() {
		return mergeOutShipmentPage.get_lod_sales_person();
	}

	@Step
	public String get_lod_sales_person_name() {
		return mergeOutShipmentPage.get_lod_sales_person_name();
	}

	@Step
	public String get_lod_customer_po_no() {
		return mergeOutShipmentPage.get_lod_customer_po_no();
	}

	@Step
	public String get_lod_reference_no() {
		return mergeOutShipmentPage.get_lod_reference_no();
	}

	@Step
	public String get_lod_subject() {
		return mergeOutShipmentPage.get_lod_subject();
	}

	@Step
	public String get_lod_do_no() {
		return mergeOutShipmentPage.get_lod_do_no();
	}

	// BEGIN Header tab
	@Step
	public String get_lod_order_currency() {
		return mergeOutShipmentPage.get_lod_order_currency();
	}

	@Step
	public String get_lod_actual_shipment_date() {
		return mergeOutShipmentPage.get_lod_actual_shipment_date();
	}

	@Step
	public String get_lod_requested_shipment_date() {
		return mergeOutShipmentPage.get_lod_requested_shipment_date();
	}

	@Step
	public String get_lod_actual_arrival_date() {
		return mergeOutShipmentPage.get_lod_actual_arrival_date();
	}

	@Step
	public String get_lod_requested_arrival_date() {
		return mergeOutShipmentPage.get_lod_requested_arrival_date();
	}

	@Step
	public String get_lod_original_shipment_date() {
		return mergeOutShipmentPage.get_lod_original_shipment_date();
	}

	@Step
	public String get_lod_shipment_mode() {
		return mergeOutShipmentPage.get_lod_shipment_mode();
	}

	@Step
	public String get_lod_shipment_mode_des() {
		return mergeOutShipmentPage.get_lod_shipment_mode_des();
	}

	@Step
	public String get_lod_shipment_term() {
		return mergeOutShipmentPage.get_lod_shipment_term();
	}

	@Step
	public String get_lod_shipment_term_des() {
		return mergeOutShipmentPage.get_lod_shipment_term_des();
	}

	@Step
	public String get_lod_loading_location() {
		return mergeOutShipmentPage.get_lod_loading_location();
	}

	@Step
	public String get_lod_loading_location_des() {
		return mergeOutShipmentPage.get_lod_loading_location_des();
	}

	@Step
	public String get_lod_shipping_coordinator() {
		return mergeOutShipmentPage.get_lod_shipping_coordinator();
	}

	@Step
	public String get_lod_shipping_coordinator_des() {
		return mergeOutShipmentPage.get_lod_shipping_coordinator_des();
	}

	@Step
	public String get_lod_ship_to_address() {
		return mergeOutShipmentPage.get_lod_ship_to_address();
	}

	@Step
	public String get_lod_ship_to_address_des() {
		return mergeOutShipmentPage.get_lod_ship_to_address_des();
	}

	@Step
	public String get_lod_ship_to_contact() {
		return mergeOutShipmentPage.get_lod_ship_to_contact();
	}

	@Step
	public String get_lod_ship_to_contact_des() {
		return mergeOutShipmentPage.get_lod_ship_to_contact_des();
	}

	@Step
	public String get_lod_forwarder() {
		return mergeOutShipmentPage.get_lod_forwarder();
	}

	@Step
	public String get_lod_forwarder_des() {
		return mergeOutShipmentPage.get_lod_forwarder_des();
	}

	@Step
	public String get_lod_trucker() {
		return mergeOutShipmentPage.get_lod_trucker();
	}

	@Step
	public String get_lod_trucker_des() {
		return mergeOutShipmentPage.get_lod_trucker_des();
	}

	@Step
	public String get_lod_purchase_category() {
		return mergeOutShipmentPage.get_lod_purchase_category();
	}

	@Step
	public String get_lod_purchase_category_des() {
		return mergeOutShipmentPage.get_lod_purchase_category_des();
	}

	@Step
	public String get_lod_haulier() {
		return mergeOutShipmentPage.get_lod_haulier();
	}

	@Step
	public String get_lod_haulier_des() {
		return mergeOutShipmentPage.get_lod_haulier_des();
	}

	@Step
	public String get_lod_container_no() {
		return mergeOutShipmentPage.get_lod_container_no();
	}

	@Step
	public String get_lod_seal_no() {
		return mergeOutShipmentPage.get_lod_seal_no();
	}

	@Step
	public String get_lod_sales_category() {
		return mergeOutShipmentPage.get_lod_sales_category();
	}

	@Step
	public String get_lod_internal_remarks() {
		return mergeOutShipmentPage.get_lod_internal_remarks();
	}

	@Step
	public String get_lod_external_remarks() {
		return mergeOutShipmentPage.get_lod_external_remarks();
	}

	@Step
	public String get_lod_shipment_instruction() {
		return mergeOutShipmentPage.get_lod_shipment_instruction();
	}

	// END Header tab
	// BEGIN Detail tab
	@Step
	public int get_lod_det_row_index_by_no(String _no) {
		return mergeOutShipmentPage.get_lod_det_row_index_by_no(_no);
	}

	@Step
	public int get_lod_det_allocation_row_index_by_allocation_no(String _allocationNo) {
		return mergeOutShipmentPage.get_lod_det_allocation_row_index_by_allocation_no(_allocationNo);
	}

	@Step
	public void select_lod_detail_item(int _rowIndex) {
		mergeOutShipmentPage.select_lod_detail_item(_rowIndex);
	}

	@Step
	public void select_lod_detail_allocation(int _rowIndex) {
		mergeOutShipmentPage.select_lod_detail_allocation(_rowIndex);
	}

	@Step
	public String get_lod_det_type(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_type(_rowIndex);
	}

	@Step
	public String get_lod_det_item_code(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_item_code(_rowIndex);
	}

	@Step
	public String get_lod_det_item_description(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_item_description(_rowIndex);
	}

	@Step
	public String get_lod_det_uom(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_uom(_rowIndex);
	}

	@Step
	public String get_lod_det_qoh(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_qoh(_rowIndex);
	}

	@Step
	public String get_lod_det_qty(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_qty(_rowIndex);
	}

	@Step
	public String get_lod_det_price_type(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_price_type(_rowIndex);
	}

	@Step
	public String get_lod_det_qty_req(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_qty_req(_rowIndex);
	}

	@Step
	public String get_lod_det_unit_price(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_unit_price(_rowIndex);
	}

	@Step
	public String get_lod_det_total(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_total(_rowIndex);
	}

	@Step
	public String get_lod_det_vol_wt(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_vol_wt(_rowIndex);
	}

	@Step
	public String get_lod_det_weight(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_weight(_rowIndex);
	}

	@Step
	public String get_lod_det_volume(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_det_volume(_rowIndex);
	}

	@Step
	public String get_lod_allocation_type(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_type(_rowIndex);
	}

	@Step
	public String get_lod_allocation_voucher_no(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_voucher_no(_rowIndex);
	}

	@Step
	public String get_lod_allocation_phase_sequence_no(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_phase_sequence_no(_rowIndex);
	}

	@Step
	public String get_lod_allocation_schedule_no(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_schedule_no(_rowIndex);
	}

	@Step
	public String get_lod_allocation_line_no(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_line_no(_rowIndex);
	}

	@Step
	public String get_lod_allocation_requested_alloc_qty(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_requested_alloc_qty(_rowIndex);
	}

	@Step
	public String get_lod_allocation_ost_qty(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_ost_qty(_rowIndex);
	}

	@Step
	public String get_lod_allocation_requested_alloc_no_of_pack(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_requested_alloc_no_of_pack(_rowIndex);
	}

	@Step
	public String get_lod_allocation_alloc_qty(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_allocation_alloc_qty(_rowIndex);
	}
	// END Detail tab

	// BEGIN Shipping Info tab
	@Step
	public String get_lod_booking_date() {
		return mergeOutShipmentPage.get_lod_booking_date();
	}

	@Step
	public String get_lod_booking_reference_no() {
		return mergeOutShipmentPage.get_lod_booking_reference_no();
	}

	@Step
	public String get_lod_country_of_load() {
		return mergeOutShipmentPage.get_lod_country_of_load();
	}

	@Step
	public String get_lod_port_of_load() {
		return mergeOutShipmentPage.get_lod_port_of_load();
	}

	@Step
	public String get_lod_country_of_dischg() {
		return mergeOutShipmentPage.get_lod_country_of_dischg();
	}

	@Step
	public String get_lod_port_of_dischg() {
		return mergeOutShipmentPage.get_lod_port_of_dischg();
	}

	@Step
	public String get_lod_country_of_fd() {
		return mergeOutShipmentPage.get_lod_country_of_fd();
	}

	@Step
	public String get_lod_port_of_fd() {
		return mergeOutShipmentPage.get_lod_port_of_fd();
	}

	@Step
	public String get_lod_carrier() {
		return mergeOutShipmentPage.get_lod_carrier();
	}

	@Step
	public String get_lod_carrier_des() {
		return mergeOutShipmentPage.get_lod_carrier_des();
	}

	@Step
	public String get_lod_flight_no() {
		return mergeOutShipmentPage.get_lod_flight_no();
	}

	@Step
	public String get_lod_date_of_manufacture() {
		return mergeOutShipmentPage.get_lod_date_of_manufacture();
	}

	@Step
	public String get_lod_eta_etd_pol() {
		return mergeOutShipmentPage.get_lod_eta_etd_pol();
	}

	@Step
	public String get_lod_eta_time_pol() {
		return mergeOutShipmentPage.get_lod_eta_time_pol();
	}

	@Step
	public String get_lod_eta_fd() {
		return mergeOutShipmentPage.get_lod_eta_fd();
	}

	@Step
	public String get_lod_eta_time_fd() {
		return mergeOutShipmentPage.get_lod_eta_time_fd();
	}

	@Step
	public String get_lod_mawb() {
		return mergeOutShipmentPage.get_lod_mawb();
	}

	@Step
	public String get_lod_hawb() {
		return mergeOutShipmentPage.get_lod_hawb();
	}

	@Step
	public String get_lod_products_description() {
		return mergeOutShipmentPage.get_lod_products_description();
	}

	@Step
	public String get_lod_remarks_to_trucker_haulier() {
		return mergeOutShipmentPage.get_lod_remarks_to_trucker_haulier();
	}

	@Step
	public String get_lod_shipping_marks() {
		return mergeOutShipmentPage.get_lod_shipping_marks();
	}

	// END Shipping Info tab
	// BEGIN Attachment tab
	@Step
	public void click_btn_lod_add_attachment() {
		mergeOutShipmentPage.click_btn_lod_add_attachment();
	}

	@Step
	public void click_btn_lod_delete_attachment() {
		mergeOutShipmentPage.click_btn_lod_delete_attachment();
	}

	@Step
	public void click_btn_lod_cancel_attachment() {
		mergeOutShipmentPage.click_btn_lod_cancel_attachment();
	}

	@Step
	public void choose_lod_attachment_file(String _filePath) {
		mergeOutShipmentPage.choose_lod_attachment_file(_filePath);
	}

	@Step
	public int get_lod_att_row_by_no(String _AttachmentNo) {
		return mergeOutShipmentPage.get_lod_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_lod_upload_attachment() {
		mergeOutShipmentPage.click_btn_lod_upload_attachment();
	}

	@Step
	public void enter_lod_file_description(int _rowIndex, String _fileDescription) {
		mergeOutShipmentPage.enter_lod_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_lod_new_file_mime_type(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_lod_new_file_file_size(int _rowIndex) {
		return mergeOutShipmentPage.get_lod_new_file_file_size(_rowIndex);
	}
	// END Attachment tab

	// END Logistic Outgoing Details
	@Step
	public void clickBtnYesOnConfirmMerge() {
		mergeOutShipmentPage.clickBtnYesOnConfirmMerge();
	}

	@Step
	public void clickBtnNoOnConfirmMerge() {
		mergeOutShipmentPage.clickBtnNoOnConfirmMerge();
	}

	@Step
	public String getInfoMessagesThenClickOK() {
		return mergeOutShipmentPage.getInfoMessagesThenClickOK();
	}

}
