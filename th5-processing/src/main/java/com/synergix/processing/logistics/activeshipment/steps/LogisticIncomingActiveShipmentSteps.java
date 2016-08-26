package com.synergix.processing.logistics.activeshipment.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.synergix.processing.logistics.activeshipment.pages.LogisticIncomingActiveShipmentPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class LogisticIncomingActiveShipmentSteps extends ScenarioSteps {
	LogisticIncomingActiveShipmentPage LIASPage;

	// BEGIN Logistic Incoming Active Shipment Summary - Outstanding tab
	@Step
	public void switch_to_tab_outstanding() {
		LIASPage.switch_to_tab_outstanding();
	}

	@Step
	public void switch_to_tab_costing() {
		LIASPage.switch_to_tab_costing();
	}

	@Step
	public void switch_to_tab_combine() {
		LIASPage.switch_to_tab_combine();
	}

	@Step
	public void switch_to_tab_history() {
		LIASPage.switch_to_tab_history();
	}

	@Step
	public void switch_to_tab_cancelled() {
		LIASPage.switch_to_tab_cancelled();
	}

	@Step
	public void filter_by_shipment_voucher_no(String _shipmentVoucherNo) {
		LIASPage.filter_by_shipment_voucher_no(_shipmentVoucherNo);
	}

	@Step
	public void filter_EAD(String _EAD) {
		LIASPage.filter_EAD(_EAD);
	}

	@Step
	public String get_EAD(int _rowIndex) {
		return LIASPage.get_EAD(_rowIndex);
	}

	@Step
	public void filter_by_source_voucher_no(String _sourceVoucherNo) {
		LIASPage.filter_by_source_voucher_no(_sourceVoucherNo);
	}

	@Step
	public void filter_by_receiving_location(String _receivingLocation) {
		LIASPage.filter_by_receiving_location(_receivingLocation);
	}

	@Step
	public void filter_by_supplier_name(String _supplierName) {
		LIASPage.filter_by_supplier_name(_supplierName);
	}

	@Step
	public void get_total_amt(int _rowIndex) {
		LIASPage.get_total_amt(_rowIndex);
	}

	@Step
	public void filter_by_created_by(String _createdBy) {
		LIASPage.filter_by_created_by(_createdBy);
	}

	@Step
	public void filter_by_created_date(String _createdDateFrom, String _createdDateTo) {
		LIASPage.filter_by_created_date(_createdDateFrom, _createdDateTo);
	}

	@Step
	public void filter_by_last_updated_by(String _lastUpdatedBy) {
		LIASPage.filter_by_last_updated_by(_lastUpdatedBy);
	}

	@Step
	public void filter_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		LIASPage.filter_by_last_updated_date(_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	@Step
	public void open_shipment_voucher_no(String _shipmentVouvherNo) {
		LIASPage.open_shipment_voucher_no(_shipmentVouvherNo);
	}

	@Step
	public void open_first_shipment_voucher_no() {
		LIASPage.open_first_shipment_voucher_no();
	}

	@Step
	public String get_infor_messeage_shipment_voucher_no() {
		return LIASPage.get_infor_messeage_shipment_voucher_no();
	}

	@Step
	public void click_btn_ok_infor_messeage() {
		LIASPage.click_btn_ok_infor_messeage();
	}
	// END Logistic Incoming Active Shipment Summary - Outstanding tab

	// BEGIN Logistic Active Outstanding Shipment - Incoming Shipment Details
	@Step
	public void switch_to_tab_header() {
		LIASPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_detail() {
		LIASPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_additional_cost() {
		LIASPage.switch_to_tab_additional_cost();
	}

	@Step
	public void switch_to_tab_shipping_info() {
		LIASPage.switch_to_tab_shipping_info();
	}

	@Step
	public void switch_to_tab_attachments() {
		LIASPage.switch_to_tab_attachments();
	}

	// Preview report
	@Step
	public boolean is_display_reports_selection() {
		return LIASPage.is_display_reports_selection();
	}

	@Step
	public void open_report_by_report_title(String reportTitle) {
		LIASPage.open_report_by_report_title(reportTitle);
	}

	@Step
	public int count_text_sections_in_report() {
		return LIASPage.count_text_sections_in_report();
	}

	@Step
	public boolean switch_to_preview_report_window() {
		return LIASPage.switch_to_preview_report_window(10);
	}

	@Step
	public boolean verify_preview_report_content(String _givenContent) {
		return LIASPage.verify_preview_report_content(_givenContent);
	}

	@Step
	public String getCurrentWindowHandle() {
		return LIASPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return LIASPage.switchToWindowHandle(_handle);
	}

	// Header
	@Step
	public String get_laosis_shipment_no() {
		return LIASPage.get_laosis_shipment_no();
	}

	@Step
	public void shipment_voucher_no(String _shipmentVoucherNo) {
		System.out.println("***** INFO ***** Shipment Voucher No: " + _shipmentVoucherNo);
	}

	@Step
	public String get_laosis_shipment_priority() {
		return LIASPage.get_laosis_shipment_priority();
	}

	@Step
	public String get_laosis_source_voucher_no() {
		return LIASPage.get_laosis_source_voucher_no();
	}

	@Step
	public String get_laosis_supplier_name() {
		return LIASPage.get_laosis_supplier_name();
	}

	@Step
	public String get_laosis_supplier_desc() {
		return LIASPage.get_laosis_supplier_desc();
	}

	@Step
	public String get_laosis_contact_person_name() {
		return LIASPage.get_laosis_contact_person_name();
	}

	@Step
	public String get_laosis_contact_person_desc() {
		return LIASPage.get_laosis_contact_person_desc();
	}

	@Step
	public void enter_laosis_supplier_do_no(String _supplierDONo) {
		LIASPage.enter_laosis_supplier_do_no(_supplierDONo);
	}

	@Step
	public void enter_laosis_supplier_do_date(String _supplierDODate) {
		LIASPage.enter_laosis_supplier_do_date(_supplierDODate);
	}

	@Step
	public void enter_laosis_supplier_invoice_no(String _supplierInvoiceNo) {
		LIASPage.enter_laosis_supplier_invoice_no(_supplierInvoiceNo);
	}

	@Step
	public void enter_laosis_supplier_invoice_date(String _supplierInvoiceDate) {
		LIASPage.enter_laosis_supplier_invoice_date(_supplierInvoiceDate);
	}

	@Step
	public String get_laosis_exchange_rate() {
		return LIASPage.get_laosis_exchange_rate();
	}

	@Step
	public String get_laosis_currency() {
		return LIASPage.get_laosis_currency();
	}

	@Step
	public String get_laosis_currency_desc() {
		return LIASPage.get_laosis_currency_desc();
	}

	@Step
	public String get_laosis_grn_no() {
		return LIASPage.get_laosis_grn_no();
	}

	@Step
	public String get_laosis_customer_name() {
		return LIASPage.get_laosis_customer_name();
	}

	@Step
	public String get_laosis_customer_code() {
		return LIASPage.get_laosis_customer_code();
	}

	@Step
	public String get_laosis_source_customer_po_no() {
		return LIASPage.get_laosis_source_customer_po_no();
	}

	@Step
	public void enter_laosis_consignee(String _consignee) {
		LIASPage.enter_laosis_consignee(_consignee);
	}

	@Step
	public void click_btn_laosis_grn_no() {
		LIASPage.click_btn_laosis_grn_no();
	}

	@Step
	public void click_btn_preview() {
		LIASPage.click_btn_preview();
	}

	@Step
	public void click_btn_submit_incoming_shipment_detail() {
		LIASPage.click_btn_submit_incoming_shipment_detail();
	}

	@Step
	public void click_btn_lcsis_submit_incoming_shipment_detail_no_assert() {
		LIASPage.click_btn_lcsis_submit_incoming_shipment_detail_no_assert();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		LIASPage.click_btn_yes_on_confirm_submit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		LIASPage.click_btn_no_on_confirm_submit();
	}

	@Step
	public void click_btn_back_to_summary() {
		LIASPage.click_btn_back_to_summary();
	}

	@Step
	public void enter_laosis_actual_shipment_date(String _actualShipmentDate) {
		LIASPage.enter_laosis_actual_shipment_date(_actualShipmentDate);
	}

	@Step
	public void enter_laosis_actual_arrival_date(String _actualArrivalDate) {
		LIASPage.enter_laosis_actual_arrival_date(_actualArrivalDate);
	}

	@Step
	public void enter_laosis_goods_receipt_date(String _goodsReceiptDate) {
		LIASPage.enter_laosis_goods_receipt_date(_goodsReceiptDate);
	}

	@Step
	public void enter_laosis_forwarder(String _forwarder) {
		LIASPage.enter_laosis_forwarder(_forwarder);
	}

	@Step
	public String get_laosis_estimated_shipment_date() {
		return LIASPage.get_laosis_estimated_shipment_date();
	}

	@Step
	public String get_laosis_estimated_arrival_date() {
		return LIASPage.get_laosis_estimated_arrival_date();
	}

	@Step
	public String get_laosis_reference_no() {
		return LIASPage.get_laosis_reference_no();
	}

	@Step
	public String get_laosis_shipment_term() {
		return LIASPage.get_laosis_shipment_term();
	}

	@Step
	public String get_laosis_shipment_mode() {
		return LIASPage.get_laosis_shipment_mode();
	}

	@Step
	public String get_laosis_receiving_location() {
		return LIASPage.get_laosis_receiving_location();
	}

	@Step
	public String get_laosis_receiving_location_desc() {

		return LIASPage.get_laosis_receiving_location_desc();
	}

	@Step
	public void enter_laosis_internal_remarks(String _internalRemarks) {
		LIASPage.enter_laosis_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_laosis_external_remarks(String _externalRemarks) {
		LIASPage.enter_laosis_external_remarks(_externalRemarks);
	}

	// Shipping Info
	@Step
	public void enter_laosis_booking_date(String _bookingDate) {
		LIASPage.enter_laosis_booking_date(_bookingDate);
	}

	@Step
	public void enter_laosis_booking_reference_no(String _bookingReferenceNo) {
		LIASPage.enter_laosis_booking_reference_no(_bookingReferenceNo);
	}

	@Step
	public void enter_laosis_country_of_load(String _countryOfLoad) {
		LIASPage.enter_laosis_country_of_load(_countryOfLoad);
	}

	@Step
	public void enter_laosis_port_of_load(String _portOfLoad) {
		LIASPage.enter_laosis_port_of_load(_portOfLoad);
	}

	@Step
	public String get_laosis_country_of_load() {
		return LIASPage.get_laosis_country_of_load();
	}

	@Step
	public String get_laosis_port_of_load() {
		return LIASPage.get_laosis_port_of_load();
	}

	@Step
	public String get_laosis_port_of_load_desc() {
		return LIASPage.get_laosis_port_of_load_desc();
	}

	@Step
	public void enter_laosis_country_of_dischg(String _countryOfDischg) {
		LIASPage.enter_laosis_country_of_dischg(_countryOfDischg);
	}

	@Step
	public void enter_laosis_port_of_dischg(String _portOfDischg) {
		LIASPage.enter_laosis_port_of_dischg(_portOfDischg);
	}

	@Step
	public String get_laosis_country_of_dischg() {
		return LIASPage.get_laosis_country_of_dischg();
	}

	@Step
	public String get_laosis_port_of_dischg() {
		return LIASPage.get_laosis_port_of_dischg();
	}

	@Step
	public String get_laosis_port_of_dischg_desc() {
		return LIASPage.get_laosis_port_of_dischg_desc();
	}

	@Step
	public void enter_laosis_country_of_fd(String _countryOfFd) {
		LIASPage.enter_laosis_country_of_fd(_countryOfFd);
	}

	@Step
	public void enter_laosis_port_of_fd(String _portOfFd) {
		LIASPage.enter_laosis_port_of_fd(_portOfFd);
	}

	@Step
	public String get_country_of_fd() {
		return LIASPage.get_country_of_fd();
	}

	@Step
	public String get_laosis_port_of_fd() {
		return LIASPage.get_laosis_port_of_fd();
	}

	@Step
	public String get_laosis_port_of_fd_desc() {
		return LIASPage.get_laosis_port_of_fd_desc();
	}

	@Step
	public void enter_laosis_flight_no(String _flightNo) {
		LIASPage.enter_laosis_flight_no(_flightNo);
	}

	@Step
	public void enter_laosis_date_of_manufacture(String _dateOfManufacture) {
		LIASPage.enter_laosis_date_of_manufacture(_dateOfManufacture);
	}

	@Step
	public void enter_laosis_eta_etd_pol(String _etaEtdPol) {
		LIASPage.enter_laosis_eta_etd_pol(_etaEtdPol);
	}

	@Step
	public void enter_laosis_eta_time_pol_hhmm(String _etaTimePolHhMm) {
		LIASPage.enter_laosis_eta_time_pol_hhmm(_etaTimePolHhMm);
	}

	@Step
	public void enter_laosis_eta_fd(String _etaFd) {
		LIASPage.enter_laosis_eta_fd(_etaFd);
	}

	@Step
	public void enter_laosis_eta_time_fd_hhmm(String _etaTimeFdHhMm) {
		LIASPage.enter_laosis_eta_time_fd_hhmm(_etaTimeFdHhMm);
	}

	@Step
	public void enter_laosis_mawb(String _mawb) {
		LIASPage.enter_laosis_mawb(_mawb);
	}

	@Step
	public void enter_laosis_hawb(String _hawb) {
		LIASPage.enter_laosis_hawb(_hawb);
	}

	@Step
	public void enter_laosis_products_description(String _productsDescription) {
		LIASPage.enter_laosis_products_description(_productsDescription);
	}

	@Step
	public void enter_laosis_remarks_to_trucker_haulier(String _remarksToTruckerHaulier) {
		LIASPage.enter_laosis_remarks_to_trucker_haulier(_remarksToTruckerHaulier);
	}

	@Step
	public void enter_laosis_shipping_marks(String _shippingMarks) {
		LIASPage.enter_laosis_shipping_marks(_shippingMarks);
	}

	// Attachment
	@Step
	public void click_btn_laosis_add_attachment() {
		LIASPage.click_btn_laosis_add_attachment();
	}

	@Step
	public void click_btn_laosis_delete_attachment() {
		LIASPage.click_btn_laosis_delete_attachment();
	}

	@Step
	public void click_btn_laosis_cancel_attachment() {
		LIASPage.click_btn_laosis_cancel_attachment();
	}

	@Step
	public void choose_laosis_attachment_file(String _filePath) {
		LIASPage.choose_laosis_attachment_file(_filePath);
	}

	@Step
	public int get_laosis_att_row_by_no(String _AttachmentNo) {
		return LIASPage.get_laosis_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_laosis_upload_attachment() {
		LIASPage.click_btn_laosis_upload_attachment();
	}

	@Step
	public void enter_laosis_file_description(int _rowIndex, String _fileDescription) {
		LIASPage.enter_laosis_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_laosis_new_file_mime_type(int _rowIndex) {
		return LIASPage.get_laosis_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_laosis_new_file_file_size(int _rowIndex) {
		return LIASPage.get_laosis_new_file_file_size(_rowIndex);
	}

	// Additional Cost
	@Step
	public String get_loasis_as_total_charge_amt() {
		return LIASPage.get_loasis_as_total_charge_amt();
	}

	@Step
	public String get_loasis_as_total_charge_home_amt() {
		return LIASPage.get_loasis_as_total_charge_home_amt();
	}

	@Step
	public void click_btn_loasis_as_add() {
		LIASPage.click_btn_loasis_as_add();
	}

	@Step
	public void click_btn_loasis_as_delete() {
		LIASPage.click_btn_loasis_as_delete();
	}

	@Step
	public void enter_loasis_as_new_supplier(String _supplier) {
		LIASPage.enter_loasis_as_new_supplier(_supplier);
	}

	@Step
	public void enter_loasis_as_new_service(String _service) {
		LIASPage.enter_loasis_as_new_service(_service);
	}

	@Step
	public void enter_loasis_as_new_ccy(String _ccy) {
		LIASPage.enter_loasis_as_new_ccy(_ccy);
	}

	@Step
	public void enter_loasis_as_new_exch_rate(String _exchRate) {
		LIASPage.enter_loasis_as_new_exch_rate(_exchRate);
	}

	@Step
	public void enter_loasis_as_new_charge_amt(String chargeAmt) {
		LIASPage.enter_loasis_as_new_charge_amt(chargeAmt);
	}

	@Step
	public void enter_loasis_as_new_charge_home_amt(String _chargeHomeAmt) {
		LIASPage.enter_loasis_as_new_charge_home_amt(_chargeHomeAmt);
	}

	@Step
	public void select_loasis_as_new_cost_dist_mtd(String _costDistMtd) {
		LIASPage.select_loasis_as_new_cost_dist_mtd(_costDistMtd);
	}

	// Detail tab
	public void click_laosis_det_receive_all_ost_qty() {
		LIASPage.click_laosis_det_receive_all_ost_qty();
	}

	@Step
	public void enter_laosis_det_total_cost_for_insurance(String _totalCostForInsurance) {
		LIASPage.enter_laosis_det_total_cost_for_insurance(_totalCostForInsurance);
	}

	@Step
	public void click_laosis_det_add() {
		LIASPage.click_laosis_det_add();
	}

	@Step
	public void click_laosis_det_delete() {
		LIASPage.click_laosis_det_delete();
	}

	@Step
	public String get_laosis_det_total_discount() {
		return LIASPage.get_laosis_det_total_discount();
	}

	@Step
	public String get_laosis_det_total_total() {
		return LIASPage.get_laosis_det_total_total();
	}

	@Step
	public String get_laosis_det_total_add_cost_amt() {
		return LIASPage.get_laosis_det_total_add_cost_amt();
	}

	@Step
	public String get_laosis_det_total_add_cost_home_amt() {
		return LIASPage.get_laosis_det_total_add_cost_home_amt();
	}

	@Step
	public String get_laosis_det_total_fl_total_amt() {
		return LIASPage.get_laosis_det_total_fl_total_amt();
	}

	@Step
	public String get_laosis_det_total_fl_total_home_amt() {
		return LIASPage.get_laosis_det_total_fl_total_home_amt();
	}

	@Step
	public String get_laosis_det_type(int _rowIndex) {
		return LIASPage.get_laosis_det_type(_rowIndex);
	}

	@Step
	public String get_laosis_det_item_code(int _rowIndex) {
		return LIASPage.get_laosis_det_item_code(_rowIndex);
	}

	@Step
	public String get_laosis_det_item_description(int _rowIndex) {
		return LIASPage.get_laosis_det_item_description(_rowIndex);
	}

	@Step
	public String get_laosis_det_uom(int _rowIndex) {
		return LIASPage.get_laosis_det_uom(_rowIndex);
	}

	@Step
	public String get_laosis_det_qty(int _rowIndex) {
		return LIASPage.get_laosis_det_qty(_rowIndex);
	}

	@Step
	public String get_laosis_det_qty_req(int _rowIndex) {
		return LIASPage.get_laosis_det_qty_req(_rowIndex);
	}

	@Step
	public String get_laosis_det_no_of_pack_req(int _rowIndex) {
		return LIASPage.get_laosis_det_no_of_pack_req(_rowIndex);
	}

	@Step
	public String get_laosis_det_ost_qty(int _rowIndex) {
		return LIASPage.get_laosis_det_ost_qty(_rowIndex);
	}

	@Step
	public String get_laosis_det_unit_cost(int _rowIndex) {
		return LIASPage.get_laosis_det_unit_cost(_rowIndex);
	}

	@Step
	public String get_laosis_det_discount(int _rowIndex) {
		return LIASPage.get_laosis_det_discount(_rowIndex);
	}

	@Step
	public String get_laosis_det_total(int _rowIndex) {
		return LIASPage.get_laosis_det_total(_rowIndex);
	}

	@Step
	public String get_laosis_det_add_cost_amt(int _rowIndex) {
		return LIASPage.get_laosis_det_add_cost_amt(_rowIndex);
	}

	@Step
	public String get_laosis_det_add_cost_home_amt(int _rowIndex) {
		return LIASPage.get_laosis_det_add_cost_home_amt(_rowIndex);
	}

	@Step
	public String get_laosis_det_fl_total_amt(int _rowIndex) {
		return LIASPage.get_laosis_det_fl_total_amt(_rowIndex);
	}

	@Step
	public String get_laosis_det_fl_total_home_amt(int _rowIndex) {
		return LIASPage.get_laosis_det_fl_total_home_amt(_rowIndex);
	}

	@Step
	public String get_laosis_det_serial_no(int _rowIndex) {
		return LIASPage.get_laosis_det_serial_no(_rowIndex);
	}

	@Step
	public int get_laosis_det_row_index_by_no(String _no) {
		return LIASPage.get_laosis_det_row_index_by_no(_no);
	}

	@Step
	public void enter_laosis_det_qty(int _rowIndex, String _qty) {
		LIASPage.enter_laosis_det_qty(_rowIndex, _qty);
	}

	@Step
	public void enter_laosis_det_item_code(int _rowIndex, String _itemCode) {
		LIASPage.enter_laosis_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void enter_laosis_det_source_po_line_item_no(int _rowIndex, String _sourcePOLineItemNo) {
		LIASPage.enter_laosis_det_source_po_line_item_no(_rowIndex, _sourcePOLineItemNo);
	}

	@Step
	public void open_laosis_det_lots_information(int _rowIndex) {
		LIASPage.open_laosis_det_lots_information(_rowIndex);
	}

	@Step
	public void open_laosis_det_receving_serial_number(int _rowIndex) {
		LIASPage.open_laosis_det_receving_serial_number(_rowIndex);
	}

	// Lots Information
	@Step
	public void click_btn_li_add() {
		LIASPage.click_btn_li_add();
	}

	@Step
	public void click_btn_li_delete() {
		LIASPage.click_btn_li_delete();
	}

	@Step
	public void click_btn_li_done() {
		LIASPage.click_btn_li_done();
	}

	@Step
	public void enter_li_new_ref_no(String _refNo) {
		LIASPage.enter_li_new_ref_no(_refNo);
	}

	@Step
	public void enter_li_new_expiry_date(String _expiryDate) {
		LIASPage.enter_li_new_expiry_date(_expiryDate);
	}

	@Step
	public void enter_li_new_country_of_origin(String _countryOfOrigin) {
		LIASPage.enter_li_new_country_of_origin(_countryOfOrigin);
	}

	@Step
	public void enter_li_new_quantity(String _quantity) {
		LIASPage.enter_li_new_quantity(_quantity);
	}

	@Step
	public void enter_li_new_gross_weight(String _grossWeight) {
		LIASPage.enter_li_new_gross_weight(_grossWeight);
	}

	@Step
	public void enter_li_new_tare_weight(String _tareWeight) {
		LIASPage.enter_li_new_tare_weight(_tareWeight);
	}

	// Receiving Serial Number
	@Step
	public void switch_to_tab_rsn_batch_input() {
		LIASPage.switch_to_tab_rsn_batch_input();
	}

	@Step
	public void switch_to_tab_rsn_serial_no_generating() {
		LIASPage.switch_to_tab_rsn_serial_no_generating();
	}

	@Step
	public void enter_rsn_prefix(String _prefix) {
		LIASPage.enter_rsn_prefix(_prefix);
	}

	@Step
	public void enter_rsn_suffix(String _suffix) {
		LIASPage.enter_rsn_suffix(_suffix);
	}

	@Step
	public void enter_rsn_first_no(String _firstNo) {
		LIASPage.enter_rsn_first_no(_firstNo);
	}

	@Step
	public void enter_rsn_last_no(String _lastNo) {
		LIASPage.enter_rsn_last_no(_lastNo);
	}

	@Step
	public void click_btn_rsn_generate() {
		LIASPage.click_btn_rsn_generate();
	}

	@Step
	public void click_btn_rsn_done() {
		LIASPage.click_btn_rsn_done();
	}

	// END Logistic Active Outstanding Shipment - Incoming Shipment Details
	// BEGIN Logistic Costing Shipment - Incoming Shipment Details
	@Step
	public void click_btn_submit_lcsis_incoming_shipment_detail() {
		LIASPage.click_btn_submit_lcsis_incoming_shipment_detail();
	}

	@Step
	public String get_lcsis_shipment_no() {
		return LIASPage.get_lcsis_shipment_no();
	}

	@Step
	public void enter_lcsis_det_total_cost_for_insurance(String _totalCostForInsurance) {
		LIASPage.enter_lcsis_det_total_cost_for_insurance(_totalCostForInsurance);
	}

	@Step
	public void click_lcsis_det_add() {
		LIASPage.click_lcsis_det_add();
	}

	@Step
	public void click_lcsis_det_delete() {
		LIASPage.click_lcsis_det_delete();
	}

	@Step
	public String get_lcsis_det_total_discount() {
		return LIASPage.get_lcsis_det_total_discount();
	}

	@Step
	public String get_lcsis_det_total_total() {
		return LIASPage.get_lcsis_det_total_total();
	}

	@Step
	public String get_lcsis_det_total_add_cost_amt() {
		return LIASPage.get_lcsis_det_total_add_cost_amt();
	}

	@Step
	public String get_lcsis_det_total_add_cost_home_amt() {
		return LIASPage.get_lcsis_det_total_add_cost_home_amt();
	}

	@Step
	public String get_lcsis_det_total_fl_total_amt() {
		return LIASPage.get_lcsis_det_total_fl_total_amt();
	}

	@Step
	public String get_lcsis_det_total_fl_total_home_amt() {
		return LIASPage.get_lcsis_det_total_fl_total_home_amt();
	}

	@Step
	public String get_lcsis_det_type(int _rowIndex) {
		return LIASPage.get_lcsis_det_type(_rowIndex);
	}

	@Step
	public String get_lcsis_det_item_code(int _rowIndex) {
		return LIASPage.get_lcsis_det_item_code(_rowIndex);
	}

	@Step
	public String get_lcsis_det_item_description(int _rowIndex) {
		return LIASPage.get_lcsis_det_item_description(_rowIndex);
	}

	@Step
	public String get_lcsis_det_uom(int _rowIndex) {
		return LIASPage.get_lcsis_det_uom(_rowIndex);
	}

	@Step
	public String get_lcsis_det_qty(int _rowIndex) {
		return LIASPage.get_lcsis_det_qty(_rowIndex);
	}

	@Step
	public String get_lcsis_det_qty_req(int _rowIndex) {
		return LIASPage.get_lcsis_det_qty_req(_rowIndex);
	}

	@Step
	public String get_lcsis_det_no_of_pack_req(int _rowIndex) {
		return LIASPage.get_lcsis_det_no_of_pack_req(_rowIndex);
	}

	@Step
	public String get_lcsis_det_ost_qty(int _rowIndex) {
		return LIASPage.get_lcsis_det_ost_qty(_rowIndex);
	}

	@Step
	public String get_lcsis_det_unit_cost(int _rowIndex) {
		return LIASPage.get_lcsis_det_unit_cost(_rowIndex);
	}

	@Step
	public String get_lcsis_det_discount(int _rowIndex) {
		return LIASPage.get_lcsis_det_discount(_rowIndex);
	}

	@Step
	public String get_lcsis_det_total(int _rowIndex) {
		return LIASPage.get_lcsis_det_total(_rowIndex);
	}

	@Step
	public String get_lcsis_det_add_cost_amt(int _rowIndex) {
		return LIASPage.get_lcsis_det_add_cost_amt(_rowIndex);
	}

	@Step
	public String get_lcsis_det_add_cost_home_amt(int _rowIndex) {
		return LIASPage.get_lcsis_det_add_cost_home_amt(_rowIndex);
	}

	@Step
	public String get_lcsis_det_fl_total_amt(int _rowIndex) {
		return LIASPage.get_lcsis_det_fl_total_amt(_rowIndex);
	}

	@Step
	public String get_lcsis_det_fl_total_home_amt(int _rowIndex) {
		return LIASPage.get_lcsis_det_fl_total_home_amt(_rowIndex);
	}

	@Step
	public String get_lcsis_det_serial_no(int _rowIndex) {
		return LIASPage.get_lcsis_det_serial_no(_rowIndex);
	}

	@Step
	public int get_lcsis_det_row_index_by_no(String _no) {
		return LIASPage.get_lcsis_det_row_index_by_no(_no);
	}

	@Step
	public void enter_lcsis_det_qty(int _rowIndex, String _qty) {
		LIASPage.enter_lcsis_det_qty(_rowIndex, _qty);
	}

	@Step
	public void enter_lcsis_det_item_code(int _rowIndex, String _itemCode) {
		LIASPage.enter_lcsis_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public void enter_lcsis_det_unit_cost(int _rowIndex, String _unitCost) {
		LIASPage.enter_lcsis_det_unit_cost(_rowIndex, _unitCost);
	}

	@Step
	public void select_lcsis_det_cost_variance(int _rowIndex, String _costVariance) {
		LIASPage.select_lcsis_det_cost_variance(_rowIndex, _costVariance);
	}

	@Step
	public void enter_lcsis_det_source_po_line_item_no(int _rowIndex, String _sourcePOLineItemNo) {
		LIASPage.enter_lcsis_det_source_po_line_item_no(_rowIndex, _sourcePOLineItemNo);
	}

	@Step
	public void open_lcsis_det_lots_information(int _rowIndex) {
		LIASPage.open_lcsis_det_lots_information(_rowIndex);
	}

	@Step
	public void open_lcsis_det_receving_serial_number(int _rowIndex) {
		LIASPage.open_lcsis_det_receving_serial_number(_rowIndex);
	}

	// END Logistic Costing Shipment - Incoming Shipment Details
	// BEGIN Logistic Active History Shipment - Incoming Shipment Details
	// Detail tab
	@Step
	public int get_lahsis_det_row_index_by_li_no(String _lINo) {
		return LIASPage.get_lahsis_det_row_index_by_li_no(_lINo);
	}

	@Step
	public String get_lahsis_det_item_code(int _rowIndex) {
		return LIASPage.get_lahsis_det_item_code(_rowIndex);
	}

	@Step
	public String get_lahsis_det_type(int _rowIndex) {
		return LIASPage.get_lahsis_det_type(_rowIndex);
	}

	@Step
	public String get_lahsis_det_qty(int _rowIndex) {
		return LIASPage.get_lahsis_det_qty(_rowIndex);
	}

	@Step
	public String get_lahsis_det_qty_req(int _rowIndex) {
		return LIASPage.get_lahsis_det_qty_req(_rowIndex);
	}

	// END Logistic Active History Shipment - Incoming Shipment Details
	@Step
	public String get_submit_error_messages() {
		return LIASPage.getErrorMessagesThenClickOK();
	}

}
