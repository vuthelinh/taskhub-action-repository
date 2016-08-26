package com.synergix.processing.logistics.activeshipment.steps;

import com.synergix.processing.logistics.activeshipment.pages.LogisticOutgoingActiveShipmentPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160817
 */
public class LogisticOutgoingActiveShipmentSteps extends ScenarioSteps {
	LogisticOutgoingActiveShipmentPage LOASPage;

	@Step
	public void click_btn_submit_summany() {
		LOASPage.click_btn_submit_summany();
	}

	@Step
	public void click_btn_do_no_summany() {
		LOASPage.click_btn_do_no_summany();
	}

	@Step
	public void switch_to_tab_outstanding() {
		LOASPage.switch_to_tab_outstanding();
	}

	@Step
	public void switch_to_tab_combine() {
		LOASPage.switch_to_tab_combine();
	}

	@Step
	public void switch_to_tab_history() {
		LOASPage.switch_to_tab_history();
	}

	@Step
	public void switch_to_tab_cancelled() {
		LOASPage.switch_to_tab_cancelled();
	}

	@Step
	public void filter_by_shipment_voucher_no(String _shipmentVoucherNo) {
		LOASPage.filter_by_shipment_voucher_no(_shipmentVoucherNo);
	}

	@Step
	public void get_outstanding_state(int _rowIndex) {
		LOASPage.get_outstanding_state(_rowIndex);
	}

	@Step
	public void filter_by_shipment_date(String _shipmentDate) {
		LOASPage.filter_by_shipment_date(_shipmentDate);
	}

	@Step
	public void filter_by_rsd(String _RSD) {
		LOASPage.filter_by_rsd(_RSD);
	}

	@Step
	public void filter_by_source_voucher_no(String _sourceVoucherNo) {
		LOASPage.filter_by_source_voucher_no(_sourceVoucherNo);
	}

	@Step
	public void filter_by_ccy(String _CCY) {
		LOASPage.filter_by_ccy(_CCY);
	}

	@Step
	public void filter_by_do_no(String _dONo) {
		LOASPage.filter_by_do_no(_dONo);
	}

	@Step
	public void filter_by_customer_code(String _customerCode) {
		LOASPage.filter_by_customer_code(_customerCode);
	}

	@Step
	public void filter_by_customer_name(String _customerName) {
		LOASPage.filter_by_customer_name(_customerName);
	}

	@Step
	public void filter_by_customer_po_no(String _customerPONo) {
		LOASPage.filter_by_customer_po_no(_customerPONo);
	}

	@Step
	public void filter_by_created_by(String _createdBy) {
		LOASPage.filter_by_created_by(_createdBy);
	}

	@Step
	public void filter_by_created_date(String _createdDateFrom, String _createdDateTo) {
		LOASPage.filter_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_by_last_updated_by(String _lastUpdatedBy) {
		LOASPage.filter_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		LOASPage.filter_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	@Step
	public void get_outstanding_priority(int _rowIndex) {
		LOASPage.get_outstanding_priority(_rowIndex);
	}

	@Step
	public void get_outstanding_mode(int _rowIndex) {
		LOASPage.get_outstanding_mode(_rowIndex);
	}

	@Step
	public void get_outstanding_port_of_loading(int _rowIndex) {
		LOASPage.get_outstanding_port_of_loading(_rowIndex);
	}

	@Step
	public void get_outstanding_port_of_discharge(int _rowIndex) {
		LOASPage.get_outstanding_port_of_discharge(_rowIndex);
	}

	@Step
	public void get_outstanding_credit_limit_approval_remarks(int _rowIndex) {
		LOASPage.get_outstanding_credit_limit_approval_remarks(_rowIndex);
	}

	@Step
	public void open_shipment_voucher_no(String _shipmentVouvherNo) {
		LOASPage.open_shipment_voucher_no(_shipmentVouvherNo);
	}

	@Step
	public void open_first_shipment_voucher_no() {
		LOASPage.open_first_shipment_voucher_no();
	}

	// END Logistic Outgoing Active Shipment Summary - Outstanding tab

	// BEGIN Logistic Active Outstanding Shipment - Outgoing Shipment Details
	@Step
	public void switch_to_tab_header() {
		LOASPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_detail() {
		LOASPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_shipping_info() {
		LOASPage.switch_to_tab_shipping_info();
	}

	@Step
	public void switch_to_tab_attachments() {
		LOASPage.switch_to_tab_attachments();
	}

	// Preview report
	@Step
	public boolean is_display_reports_selection() {
		return LOASPage.is_display_reports_selection();
	}

	@Step
	public void open_report_by_report_title(String reportTitle) {
		LOASPage.open_report_by_report_title(reportTitle);
	}

	@Step
	public int count_text_sections_in_report() {
		return LOASPage.count_text_sections_in_report();
	}

	@Step
	public boolean switch_to_preview_report_window() {
		return LOASPage.switch_to_preview_report_window(10);
	}

	@Step
	public boolean verify_preview_report_content(String _givenContent) {
		return LOASPage.verify_preview_report_content(_givenContent);
	}

	@Step
	public String getCurrentWindowHandle() {
		return LOASPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return LOASPage.switchToWindowHandle(_handle);
	}

	// Header
	@Step
	public String get_laos_shipment_no() {
		return LOASPage.get_laos_shipment_no();
	}

	@Step
	public void shipment_no(String _shipmentNo) {
		System.out.println("***** INFO ***** Shipment No: " + _shipmentNo);
	}

	@Step
	public String get_laos_shipment_priority() {
		return LOASPage.get_laos_shipment_priority();
	}

	@Step
	public String get_laos_customer_name() {
		return LOASPage.get_laos_customer_name();
	}

	@Step
	public String get_laos_customer_desc() {
		return LOASPage.get_laos_customer_desc();
	}

	@Step
	public String get_laos_sales_person_name() {
		return LOASPage.get_laos_sales_person_name();
	}

	@Step
	public String get_laos_sales_person_desc() {
		return LOASPage.get_laos_sales_person_desc();
	}

	@Step
	public String get_laos_source_voucher_no() {
		return LOASPage.get_laos_source_voucher_no();
	}

	@Step
	public String get_laos_source_customer_po_no() {
		return LOASPage.get_laos_source_customer_po_no();
	}

	@Step
	public String get_laos_reference_no() {
		return LOASPage.get_laos_reference_no();
	}

	@Step
	public String get_laos_subject() {
		return LOASPage.get_laos_subject();
	}

	@Step
	public String get_laos_do_no() {
		return LOASPage.get_laos_do_no();
	}

	@Step
	public void do_no(String _DONo) {
		System.out.println("***** INFO ***** DO No: " + _DONo);
	}

	@Step
	public void enter_laos_consignee(String _consignee) {
		LOASPage.enter_laos_consignee(_consignee);
	}

	@Step
	public void click_btn_laos_do_no() {
		LOASPage.click_btn_laos_do_no();
	}

	@Step
	public void click_btn_preview() {
		LOASPage.click_btn_preview();
	}

	@Step
	public void click_btn_submit_shipment_no_detail() {
		LOASPage.click_btn_submit_shipment_no_detail();
	}

	@Step
	public void click_btn_deliver_all_ost_qty() {
		LOASPage.click_btn_deliver_all_ost_qty();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		LOASPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		LOASPage.clickBtnNoOnConfirmSubmit();
	}

	@Step
	public void click_btn_back_to_summary() {
		LOASPage.click_btn_back_to_summary();
	}

	@Step
	public void enter_laos_order_currency(String _orderCurrency) {
		LOASPage.enter_laos_order_currency(_orderCurrency);
	}

	@Step
	public void enter_laos_requested_shipment_date(String _requestedShipmentDate) {
		LOASPage.enter_laos_requested_shipment_date(_requestedShipmentDate);
	}

	@Step
	public void enter_laos_requested_arrival_date(String _requestedArrivalDate) {
		LOASPage.enter_laos_requested_arrival_date(_requestedArrivalDate);
	}

	@Step
	public void enter_laos_original_shipment_date(String _originalShipmentDate) {
		LOASPage.enter_laos_original_shipment_date(_originalShipmentDate);
	}

	@Step
	public void enter_laos_shipment_mode(String _shipmentMode) {
		LOASPage.enter_laos_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_laos_shipment_term(String _shipmentTerm) {
		LOASPage.enter_laos_shipment_term(_shipmentTerm);
	}

	@Step
	public String get_laos_order_currency() {
		return LOASPage.get_laos_order_currency();
	}

	@Step
	public void enter_laos_actual_shipment_date(String _actualShipmentDate) {
		LOASPage.enter_laos_actual_shipment_date(_actualShipmentDate);
	}

	@Step
	public void enter_laos_actual_arrival_date(String _actualArrivalDate) {
		LOASPage.enter_laos_actual_arrival_date(_actualArrivalDate);
	}

	@Step
	public String get_laos_requested_shipment_date() {
		return LOASPage.get_laos_requested_shipment_date();
	}

	@Step
	public String get_laos_requested_arrival_date() {
		return LOASPage.get_laos_requested_arrival_date();
	}

	@Step
	public String get_laos_original_shipment_date() {
		return LOASPage.get_laos_original_shipment_date();
	}

	@Step
	public String get_laos_shipment_mode() {
		return LOASPage.get_laos_shipment_mode();
	}

	@Step
	public String get_laos_shipment_mode_desc() {
		return LOASPage.get_laos_shipment_mode_desc();
	}

	@Step
	public String get_laos_shipment_term() {
		return LOASPage.get_laos_shipment_term();
	}

	@Step
	public String get_laos_shipment_mode_term() {
		return LOASPage.get_laos_shipment_mode_term();
	}

	@Step
	public String get_laos_loading_location() {
		return LOASPage.get_laos_loading_location();
	}

	@Step
	public String get_laos_loading_location_desc() {
		return LOASPage.get_laos_loading_location_desc();
	}

	@Step
	public void enter_laos_loading_location(String _loadingLocation) {
		LOASPage.enter_laos_loading_location(_loadingLocation);
	}

	@Step
	public void enter_laos_shipping_coordinator(String _shippingCoordinator) {
		LOASPage.enter_laos_shipping_coordinator(_shippingCoordinator);
	}

	@Step
	public void enter_laos_ship_to_address(String _shipToAddress) {
		LOASPage.enter_laos_ship_to_address(_shipToAddress);
	}

	@Step
	public String get_laos_ship_to_address() {
		return LOASPage.get_laos_ship_to_address();
	}

	@Step
	public String get_laos_ship_to_address_desc() {
		return LOASPage.get_laos_ship_to_address_desc();
	}

	@Step
	public void select_laos_ship_to_contact(String _shipToContact) {
		LOASPage.select_laos_ship_to_contact(_shipToContact);
	}

	@Step
	public String get_laos_ship_to_contact_desc() {
		return LOASPage.get_laos_ship_to_contact_desc();
	}

	@Step
	public void enter_laos_trucker(String _trucker) {
		LOASPage.enter_laos_trucker(_trucker);
	}

	@Step
	public void enter_laos_forwarder(String _forwarder) {
		LOASPage.enter_laos_forwarder(_forwarder);
	}

	@Step
	public void enter_laos__haulier(String _Haulier) {
		LOASPage.enter_laos__haulier(_Haulier);
	}

	@Step
	public void enter_laos_container_no(String _containerNo) {
		LOASPage.enter_laos_container_no(_containerNo);
	}

	@Step
	public void enter_laos_seal_no(String _sealNo) {
		LOASPage.enter_laos_seal_no(_sealNo);
	}

	@Step
	public void enter_laos_seal_no_sales_category(String _sealNoSalesCategory) {
		LOASPage.enter_laos_seal_no_sales_category(_sealNoSalesCategory);
	}

	@Step
	public void enter_laos_internal_remarks(String _internalRemarks) {
		LOASPage.enter_laos_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_laos_external_remarks(String _externalRemarks) {
		LOASPage.enter_laos_external_remarks(_externalRemarks);
	}

	@Step
	public void enter_laos_shipment_instruction(String _shipmentInstruction) {
		LOASPage.enter_laos_shipment_instruction(_shipmentInstruction);
	}

	// Shipping Info
	@Step
	public void enter_laos_booking_date(String _bookingDate) {
		LOASPage.enter_laos_booking_date(_bookingDate);
	}

	@Step
	public void enter_laos_booking_reference_no(String _bookingReferenceNo) {
		LOASPage.enter_laos_booking_reference_no(_bookingReferenceNo);
	}

	@Step
	public void enter_laos_country_of_load(String _countryOfLoad) {
		LOASPage.enter_laos_country_of_load(_countryOfLoad);
	}

	@Step
	public void enter_laos_port_of_load(String _portOfLoad) {
		LOASPage.enter_laos_port_of_load(_portOfLoad);
	}

	@Step
	public String get_laos_country_of_load() {
		return LOASPage.get_laos_country_of_load();
	}

	@Step
	public String get_laos_port_of_load() {
		return LOASPage.get_laos_port_of_load();
	}

	@Step
	public String get_laos_port_of_load_desc() {
		return LOASPage.get_laos_port_of_load_desc();
	}

	@Step
	public void enter_laos_country_of_dischg(String _countryOfDischg) {
		LOASPage.enter_laos_country_of_dischg(_countryOfDischg);
	}

	@Step
	public void enter_laos_port_of_dischg(String _portOfDischg) {
		LOASPage.enter_laos_port_of_dischg(_portOfDischg);
	}

	@Step
	public String get_laos_country_of_dischg() {
		return LOASPage.get_laos_country_of_dischg();
	}

	@Step
	public String get_laos_port_of_dischg() {
		return LOASPage.get_laos_port_of_dischg();
	}

	@Step
	public String get_laos_port_of_dischg_desc() {
		return LOASPage.get_laos_port_of_dischg_desc();
	}

	@Step
	public void enter_laos_country_of_fd(String _countryOfFd) {
		LOASPage.enter_laos_country_of_fd(_countryOfFd);
	}

	@Step
	public void enter_laos_port_of_fd(String _portOfFd) {
		LOASPage.enter_laos_port_of_fd(_portOfFd);
	}

	@Step
	public String get_country_of_fd() {
		return LOASPage.get_country_of_fd();
	}

	@Step
	public String get_laos_port_of_fd() {
		return LOASPage.get_laos_port_of_fd();
	}

	@Step
	public String get_laos_port_of_fd_desc() {
		return LOASPage.get_laos_port_of_fd_desc();
	}

	@Step
	public void enter_laos_carrier(String _carrier) {
		LOASPage.enter_laos_carrier(_carrier);
	}

	@Step
	public void enter_laos_flight_no(String _flightNo) {
		LOASPage.enter_laos_flight_no(_flightNo);
	}

	@Step
	public void enter_laos_date_of_manufacture(String _dateOfManufacture) {
		LOASPage.enter_laos_date_of_manufacture(_dateOfManufacture);
	}

	@Step
	public void enter_laos_eta_etd_pol(String _etaEtdPol) {
		LOASPage.enter_laos_eta_etd_pol(_etaEtdPol);
	}

	@Step
	public void enter_laos_eta_time_pol_hhmm(String _etaTimePolHhMm) {
		LOASPage.enter_laos_eta_time_pol_hhmm(_etaTimePolHhMm);
	}

	@Step
	public void enter_laos_eta_fd(String _etaFd) {
		LOASPage.enter_laos_eta_fd(_etaFd);
	}

	@Step
	public void enter_laos_eta_time_fd_hhmm(String _etaTimeFdHhMm) {
		LOASPage.enter_laos_eta_time_fd_hhmm(_etaTimeFdHhMm);
	}

	@Step
	public void enter_laos_mawb(String _mawb) {
		LOASPage.enter_laos_mawb(_mawb);
	}

	@Step
	public void enter_laos_hawb(String _hawb) {
		LOASPage.enter_laos_hawb(_hawb);
	}

	@Step
	public void enter_laos_products_description(String _productsDescription) {
		LOASPage.enter_laos_products_description(_productsDescription);
	}

	@Step
	public void enter_laos_remarks_to_trucker_haulier(String _remarksToTruckerHaulier) {
		LOASPage.enter_laos_remarks_to_trucker_haulier(_remarksToTruckerHaulier);
	}

	@Step
	public void enter_laos_shipping_marks(String _shippingMarks) {
		LOASPage.enter_laos_shipping_marks(_shippingMarks);
	}

	// Attachment

	@Step
	public void click_btn_laos_add_attachment() {
		LOASPage.click_btn_laos_add_attachment();
	}

	@Step
	public void click_btn_laos_delete_attachment() {
		LOASPage.click_btn_laos_delete_attachment();
	}

	@Step
	public void click_btn_laos_cancel_attachment() {
		LOASPage.click_btn_laos_cancel_attachment();
	}

	@Step
	public void choose_laos_attachment_file(String _filePath) {
		LOASPage.choose_laos_attachment_file(_filePath);
	}

	@Step
	public int get_laos_att_row_by_no(String _AttachmentNo) {
		return LOASPage.get_laos_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_laos_upload_attachment() {
		LOASPage.click_btn_laos_upload_attachment();
	}

	@Step
	public void enter_laos_file_description(int _rowIndex, String _fileDescription) {
		LOASPage.enter_laos_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_laos_new_file_mime_type(int _rowIndex) {
		return LOASPage.get_laos_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_laos_new_file_file_size(int _rowIndex) {
		return LOASPage.get_laos_new_file_file_size(_rowIndex);
	}

	// Lots Information
	@Step
	public void click_btn_li_pick_earliest_lot_first() {
		LOASPage.click_btn_li_pick_earliest_lot_first();
	}

	@Step
	public void click_btn_li_done() {
		LOASPage.click_btn_li_done();
	}

	@Step
	public void enter_li_nett_ưeight_selected(String _nettWeightSelected) {
		LOASPage.enter_li_nett_ưeight_selected(_nettWeightSelected);
	}

	@Step
	public void enter_li_quantity(String _quantity) {
		LOASPage.enter_li_quantity(_quantity);
	}

	// Issuing Serial Number
	@Step
	public void click_btn_isn_done() {
		LOASPage.click_btn_isn_done();
	}

	@Step
	public void click_btn_isn_add() {
		LOASPage.click_btn_isn_add();
	}

	@Step
	public void click_btn_isn_delete() {
		LOASPage.click_btn_isn_delete();
	}

	@Step
	public void click_btn_isn_browse_pick() {
		LOASPage.click_btn_isn_browse_pick();
	}

	@Step
	public int get_isn_row_by_no(String _no) {
		return LOASPage.get_isn_row_by_no(_no);
	}

	@Step
	public void enter_isn_serial_no(int _rowIndex, String _serialNo) {
		LOASPage.enter_isn_serial_no(_rowIndex, _serialNo);
	}

	@Step
	public void select_isn_possible_serial_no(int _rowIndex) {
		LOASPage.select_isn_possible_serial_no(_rowIndex);
	}

	@Step
	public void enter_isn_reference_no(int _rowIndex, String _referenceNo) {
		LOASPage.enter_isn_reference_no(_rowIndex, _referenceNo);
	}

	// Detail
	@Step
	public void click_btn_laosos_deliver_all_ost_qty() {
		LOASPage.click_btn_laosos_deliver_all_ost_qty();
	}

	@Step
	public void click_btn_laosos_reset_shm_qty_to_0_for_all() {
		LOASPage.click_btn_laosos_reset_shm_qty_to_0_for_all();
	}

	@Step
	public void click_laosos_det_receive_all_ost_qty() {
		LOASPage.click_laosos_det_receive_all_ost_qty();
	}

	@Step
	public int get_laosos_det_row_index_by_no(String _no) {
		return LOASPage.get_laosos_det_row_index_by_no(_no);
	}

	@Step
	public String get_laosos_det_type(int _rowIndex) {
		return LOASPage.get_laosos_det_type(_rowIndex);
	}

	@Step
	public String get_laosos_det_item_code(int _rowIndex) {
		return LOASPage.get_laosos_det_item_code(_rowIndex);
	}

	@Step
	public String get_laosos_det_item_description(int _rowIndex) {
		return LOASPage.get_laosos_det_item_description(_rowIndex);
	}

	@Step
	public String get_laosos_det_uom(int _rowIndex) {
		return LOASPage.get_laosos_det_uom(_rowIndex);
	}

	@Step
	public String get_laosos_det_qty(int _rowIndex) {
		return LOASPage.get_laosos_det_qty(_rowIndex);
	}

	@Step
	public String get_laosos_det_qty_req(int _rowIndex) {
		return LOASPage.get_laosos_det_qty_req(_rowIndex);
	}

	@Step
	public String get_laosos_det_no_of_pack_req(int _rowIndex) {
		return LOASPage.get_laosos_det_no_of_pack_req(_rowIndex);
	}

	@Step
	public String get_laosos_det_ost_qty(int _rowIndex) {
		return LOASPage.get_laosos_det_ost_qty(_rowIndex);
	}

	@Step
	public String get_laosos_det_unit_cost(int _rowIndex) {
		return LOASPage.get_laosos_det_unit_cost(_rowIndex);
	}

	@Step
	public String get_laosos_det_discount(int _rowIndex) {
		return LOASPage.get_laosos_det_discount(_rowIndex);
	}

	@Step
	public String get_laosos_det_total(int _rowIndex) {
		return LOASPage.get_laosos_det_total(_rowIndex);
	}

	@Step
	public String get_laosos_det_add_cost_amt(int _rowIndex) {
		return LOASPage.get_laosos_det_add_cost_amt(_rowIndex);
	}

	@Step
	public String get_laosos_det_add_cost_home_amt(int _rowIndex) {
		return LOASPage.get_laosos_det_add_cost_home_amt(_rowIndex);
	}

	@Step
	public String get_laosos_det_fl_total_amt(int _rowIndex) {
		return LOASPage.get_laosos_det_fl_total_amt(_rowIndex);
	}

	@Step
	public String get_laosos_det_fl_total_home_amt(int _rowIndex) {
		return LOASPage.get_laosos_det_fl_total_home_amt(_rowIndex);
	}

	@Step
	public String get_laosos_det_serial_no(int _rowIndex) {
		return LOASPage.get_laosos_det_serial_no(_rowIndex);
	}

	@Step
	public void enter_laosos_det_qty(int _rowIndex, String _qty) {
		LOASPage.enter_laosos_det_qty(_rowIndex, _qty);
	}

	@Step
	public void enter_laosos_det_no_of_packs(int _rowIndex, String _noOfPacks) {
		LOASPage.enter_laosos_det_no_of_packs(_rowIndex, _noOfPacks);
	}

	@Step
	public void open_laosos_det_lots_information(int _rowIndex) {
		LOASPage.open_laosos_det_lots_information(_rowIndex);
	}

	@Step
	public void open_laosos_det_issuing_serial_number(int _rowIndex) {
		LOASPage.open_laosos_det_issuing_serial_number(_rowIndex);
	}

	// END Logistic Active Outstanding Shipment - Outgoing Shipment Details
	// BEGIN Logistic Active History Shipment - Outgoing Shipment Details
	// Detail
	@Step
	public int get_lahsos_det_row_index_by_no(String _no) {
		return LOASPage.get_lahsos_det_row_index_by_no(_no);
	}

	@Step
	public String get_lahsos_det_type(int _rowIndex) {
		return LOASPage.get_lahsos_det_type(_rowIndex);
	}

	@Step
	public String get_lahsos_det_item_code(int _rowIndex) {
		return LOASPage.get_lahsos_det_item_code(_rowIndex);
	}

	@Step
	public String get_lahsos_det_item_description(int _rowIndex) {
		return LOASPage.get_lahsos_det_item_description(_rowIndex);
	}

	@Step
	public String get_lahsos_det_uom(int _rowIndex) {
		return LOASPage.get_lahsos_det_uom(_rowIndex);
	}

	@Step
	public String get_lahsos_det_qty(int _rowIndex) {
		return LOASPage.get_lahsos_det_qty(_rowIndex);
	}

	@Step
	public String get_lahsos_det_qty_req(int _rowIndex) {
		return LOASPage.get_lahsos_det_qty_req(_rowIndex);
	}

	// END Logistic Active History Shipment - Outgoing Shipment Details
}
