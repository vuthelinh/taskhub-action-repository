package com.synergix.processing.sales.steps;

import com.synergix.processing.sales.pages.SalesOrderVariationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class SalesOrderVariationSteps extends ScenarioSteps {
	SalesOrderVariationPage salesOrderVariationPage;

	// BEGIN Create SO Variation
	@Step
	public void switch_to_tab_header() {
		salesOrderVariationPage.switch_to_tab_header();
	}

	@Step
	public void switch_to_tab_shipment() {
		salesOrderVariationPage.switch_to_tab_shipment();
	}

	@Step
	public void switch_to_tab_detail() {
		salesOrderVariationPage.switch_to_tab_detail();
	}

	@Step
	public void switch_to_tab_payment_info() {
		salesOrderVariationPage.switch_to_tab_payment_info();
	}

	@Step
	public void switch_to_tab_remarks() {
		salesOrderVariationPage.switch_to_tab_remarks();
	}

	@Step
	public void switch_to_tab_attachments() {
		salesOrderVariationPage.switch_to_tab_attachments();
	}

	// Header
	@Step
	public String get_new_sales_order_no() {
		return salesOrderVariationPage.get_new_sales_order_no();
	}

	@Step
	public void sales_order_no(String _sales_order_no) {
		System.out.println("***** INFO ***** Sales Order No: " + _sales_order_no);
	}

	@Step
	public String get_customer_name() {
		return salesOrderVariationPage.get_customer_name();
	}

	@Step
	public void click_btn_preview_sales_order_detail() {
		salesOrderVariationPage.click_btn_preview_sales_order_detail();
	}

	@Step
	public void click_btn_submit_sales_order_detail() {
		salesOrderVariationPage.click_btn_submit_sales_order_detail();
	}

	@Step
	public void submit_sales_order_detail() {
		salesOrderVariationPage.submit_sales_order_detail();
	}

	@Step
	public void clickBtnYesOnConfirmSubmit() {
		salesOrderVariationPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void clickBtnNoOnConfirmSubmit() {
		salesOrderVariationPage.clickBtnNoOnConfirmSubmit();
	}

	@Step
	public void click_btn_back_to_summary() {
		salesOrderVariationPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_abort() {
		salesOrderVariationPage.click_btn_abort();
	}

	@Step
	public void click_btn_copy() {
		salesOrderVariationPage.click_btn_copy();
	}

	@Step
	public void select_option_copy_from_option(String _copyFromOption) {
		salesOrderVariationPage.select_option_copy_from_option(_copyFromOption);
	}

	@Step
	public void enter_copy_from(String _copyFrom) {
		salesOrderVariationPage.enter_copy_from(_copyFrom);
	}

	@Step
	public void enter_customer(String _customer) {
		salesOrderVariationPage.enter_customer(_customer);
	}

	@Step
	public void enter_customer_address(String _customerAddress) {
		salesOrderVariationPage.enter_customer_address(_customerAddress);
	}

	@Step
	public String get_customer_address_code() {
		return salesOrderVariationPage.get_customer_address_code();
	}

	@Step
	public void enter_customer_contact(String _customerContact) {
		salesOrderVariationPage.enter_customer_contact(_customerContact);
	}

	@Step
	public String get_customer_contact_code() {
		return salesOrderVariationPage.get_customer_contact_code();
	}

	@Step
	public void enter_order_date(String _orderDate) {
		salesOrderVariationPage.enter_order_date(_orderDate);
	}

	@Step
	public void enter_sales_person(String _salesPerson) {
		salesOrderVariationPage.enter_sales_person(_salesPerson);
	}

	@Step
	public String get_sales_person() {
		return salesOrderVariationPage.get_sales_person();
	}

	@Step
	public void enter_order_currency(String _orderCurrency) {
		salesOrderVariationPage.enter_order_currency(_orderCurrency);
	}

	@Step
	public String get_order_currency() {
		return salesOrderVariationPage.get_order_currency();
	}

	@Step
	public void enter_reporting_date(String _reportingDate) {
		salesOrderVariationPage.enter_reporting_date(_reportingDate);
	}

	@Step
	public void enter_approving_sbu(String _approvingSbu) {
		salesOrderVariationPage.enter_approving_sbu(_approvingSbu);
	}

	@Step
	public void enter_sales_tax(String _salesTax) {
		salesOrderVariationPage.enter_sales_tax(_salesTax);
	}

	@Step
	public String get_sales_tax() {
		return salesOrderVariationPage.get_sales_tax();
	}

	@Step
	public void enter_reference_no(String _referenceNo) {
		salesOrderVariationPage.enter_reference_no(_referenceNo);
	}

	@Step
	public void enter_customer_so_no(String _customerSoNo) {
		salesOrderVariationPage.enter_customer_so_no(_customerSoNo);
	}

	@Step
	public void enter_customer_po_no(String _customerPoNo) {
		salesOrderVariationPage.enter_customer_po_no(_customerPoNo);
	}

	@Step
	public void enter_customer_po_line_item_no(String _customerPoLineItemNo) {
		salesOrderVariationPage.enter_customer_po_line_item_no(_customerPoLineItemNo);
	}

	@Step
	public void enter_end_user(String _endUser) {
		salesOrderVariationPage.enter_end_user(_endUser);
	}

	@Step
	public void enter_sales_category(String _salesCategory) {
		salesOrderVariationPage.enter_sales_category(_salesCategory);
	}

	@Step
	public void enter_subject(String _subject) {
		salesOrderVariationPage.enter_subject(_subject);
	}

	@Step
	public void select_allocate_pr_to_so(String _allocatePRToSO) {
		salesOrderVariationPage.select_allocate_pr_to_so(_allocatePRToSO);
	}

	@Step
	public void select_allocate_po_to_so(String _allocatePOToSO) {
		salesOrderVariationPage.select_allocate_po_to_so(_allocatePOToSO);
	}

	@Step
	public void select_downpayment_type(String _downpaymentType) {
		salesOrderVariationPage.select_downpayment_type(_downpaymentType);
	}

	@Step
	public void enter_q_downpayment_percent(String _qDownpaymentPercent) {
		salesOrderVariationPage.enter_q_downpayment_percent(_qDownpaymentPercent);
	}

	@Step
	public void enter_q_downpayment_amount(String _qDownpaymentAmount) {
		salesOrderVariationPage.enter_q_downpayment_amount(_qDownpaymentAmount);
	}

	@Step
	public void enter_q_downpayment_remarks(String _qDownpaymentRemarks) {
		salesOrderVariationPage.enter_q_downpayment_remarks(_qDownpaymentRemarks);
	}

	// Shipment
	@Step
	public void enter_loading_location(String _loadingLocation) {
		salesOrderVariationPage.enter_loading_location(_loadingLocation);
	}

	@Step
	public void enter_shipment_mode(String _shipmentMode) {
		salesOrderVariationPage.enter_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_shipment_term(String _shipmentTerm) {
		salesOrderVariationPage.enter_shipment_term(_shipmentTerm);
	}

	@Step
	public void enter_shipment_instruction(String _shipmentInstruction) {
		salesOrderVariationPage.enter_shipment_instruction(_shipmentInstruction);
	}

	@Step
	public void enter_ship_to_address(String _shipToAddress) {
		salesOrderVariationPage.enter_ship_to_address(_shipToAddress);
	}

	@Step
	public void enter_ship_to_contact(String _shipToContact) {
		salesOrderVariationPage.enter_ship_to_contact(_shipToContact);
	}

	@Step
	public void enter_bill_to_address(String _billToAddress) {
		salesOrderVariationPage.enter_bill_to_address(_billToAddress);
	}

	@Step
	public void enter_bill_to_contact(String _billToContact) {
		salesOrderVariationPage.enter_bill_to_contact(_billToContact);
	}

	@Step
	public void enter_ship_through(String _shipThrough) {
		salesOrderVariationPage.enter_ship_through(_shipThrough);
	}

	@Step
	public void enter_port_of_loading(String _portOfLoading) {
		salesOrderVariationPage.enter_port_of_loading(_portOfLoading);
	}

	@Step
	public void enter_port_of_discharge(String _portOfDischarge) {
		salesOrderVariationPage.enter_port_of_discharge(_portOfDischarge);
	}

	@Step
	public void enter_port_of_final_destination(String _portOfFinalDestination) {
		salesOrderVariationPage.enter_port_of_final_destination(_portOfFinalDestination);
	}

	@Step
	public String get_country_of_loading(String _countryOfLoading) {
		return salesOrderVariationPage.get_country_of_loading(_countryOfLoading);
	}

	@Step
	public String enter_country_of_discharge(String _countryOfDischarge) {
		return salesOrderVariationPage.enter_country_of_discharge(_countryOfDischarge);
	}

	@Step
	public String enter_country_of_final_destination(String _countryOfFinalDestination) {
		return salesOrderVariationPage.enter_country_of_final_destination(_countryOfFinalDestination);
	}

	@Step
	public void enter_no_of_shipment(String _noOfShipment) {
		salesOrderVariationPage.enter_no_of_shipment(_noOfShipment);
	}

	// Payment Information
	@Step
	public void select_payment_option(String _paymentOption) {
		salesOrderVariationPage.select_payment_option(_paymentOption);
	}

	@Step
	public void select_payment_term(String _paymentTerm) {
		salesOrderVariationPage.select_payment_term(_paymentTerm);
	}

	@Step
	public void enter_payment_term_tenor(String _paymentTermTenor) {
		salesOrderVariationPage.enter_payment_term_tenor(_paymentTermTenor);
	}

	@Step
	public void enter_payment_term_tenor_code(String _paymentTermTenorCode) {
		salesOrderVariationPage.enter_payment_term_tenor_code(_paymentTermTenorCode);
	}

	@Step
	public void select_payment_method(String _paymentMethod) {
		salesOrderVariationPage.select_payment_method(_paymentMethod);
	}

	@Step
	public void enter_billing_party(String _billingParty) {
		salesOrderVariationPage.enter_billing_party(_billingParty);
	}

	@Step
	public void enter_billing_address(String _billingAddress) {
		salesOrderVariationPage.enter_billing_address(_billingAddress);
	}

	@Step
	public void enter_billing_contact(String _billingContact) {
		salesOrderVariationPage.enter_billing_contact(_billingContact);
	}

	@Step
	public void enter_payment_amount(String _paymentAmount) {
		salesOrderVariationPage.enter_payment_amount(_paymentAmount);
	}

	@Step
	public String get_payment_amount() {
		return salesOrderVariationPage.get_payment_amount();
	}

	@Step
	public void enter_own_bank(String _ownBank) {
		salesOrderVariationPage.enter_own_bank(_ownBank);
	}

	@Step
	public String get_own_bank() {
		return salesOrderVariationPage.get_own_bank();
	}

	// Remarks
	@Step
	public void enter_internal_remarks_code(String _internalRemarksCode) {
		salesOrderVariationPage.enter_internal_remarks_code(_internalRemarksCode);
	}

	@Step
	public void enter_external_remarks_code(String _externalRemarksCode) {
		salesOrderVariationPage.enter_external_remarks_code(_externalRemarksCode);
	}

	@Step
	public void enter_warranty_remarks_code(String _warrantyRemarksCode) {
		salesOrderVariationPage.enter_warranty_remarks_code(_warrantyRemarksCode);
	}

	@Step
	public void enter_internal_remarks(String _internalRemarks) {
		salesOrderVariationPage.enter_internal_remarks(_internalRemarks);
	}

	@Step
	public void enter_external_remarks(String _externalRemarks) {
		salesOrderVariationPage.enter_external_remarks(_externalRemarks);
	}

	@Step
	public void enter_warranty_remarks(String _warrantyRemarks) {
		salesOrderVariationPage.enter_warranty_remarks(_warrantyRemarks);
	}

	// Detail
	@Step
	public void click_btn_add_detail() {
		salesOrderVariationPage.click_btn_add_detail();
	}

	@Step
	public void click_btn_delete_detail() {
		salesOrderVariationPage.click_btn_delete_detail();
	}

	@Step
	public void click_btn_reorder_line_item_by_brand() {
		salesOrderVariationPage.click_btn_reorder_line_item_by_brand();
	}

	@Step
	public void click_btn_browse_pick() {
		salesOrderVariationPage.click_btn_browse_pick();
	}

	@Step
	public void enter_exchange_rate(String _exchangeRate) {
		salesOrderVariationPage.enter_exchange_rate(_exchangeRate);
	}

	@Step
	public String det_exchange_rate(String _exchangeRate) {
		return salesOrderVariationPage.det_exchange_rate(_exchangeRate);
	}

	@Step
	public void enter_required_shipment_date(String _requiredShipmentDate) {
		salesOrderVariationPage.enter_required_shipment_date(_requiredShipmentDate);
	}

	@Step
	public void enter_required_arrival_date(String _requiredArrivalDate) {
		salesOrderVariationPage.enter_required_arrival_date(_requiredArrivalDate);
	}

	@Step
	public void enter_production_due_date(String _productionDueDate) {
		salesOrderVariationPage.enter_production_due_date(_productionDueDate);
	}

	@Step
	public void enter_shipment_priority(String _shipmentPriority) {
		salesOrderVariationPage.enter_shipment_priority(_shipmentPriority);
	}

	@Step
	public void enter_det_overall_discount_code(String _overallDiscountCode) {
		salesOrderVariationPage.enter_det_overall_discount_code(_overallDiscountCode);
	}

	@Step
	public void enter_discount_percent(String _discountPercent) {
		salesOrderVariationPage.enter_discount_percent(_discountPercent);
	}

	@Step
	public void enter_discount_amount(String _discountAmount) {
		salesOrderVariationPage.enter_discount_amount(_discountAmount);
	}

	@Step
	public void enter_det_line_item_no(String _lineItemNo) {
		salesOrderVariationPage.enter_det_line_item_no(_lineItemNo);
	}

	@Step
	public int get_det_row_by_line_item_no(String _lineItemNo) {
		return salesOrderVariationPage.get_det_row_by_line_item_no(_lineItemNo);
	}

	@Step
	public void select_det_item_type(int _rowIndex, String _itemType) {
		salesOrderVariationPage.select_det_item_type(_rowIndex, _itemType);
	}

	@Step
	public void enter_det_loading_location(int _rowIndex, String _loadingLocation) {
		salesOrderVariationPage.enter_det_loading_location(_rowIndex, _loadingLocation);
	}

	@Step
	public void enter_det_item_code(int _rowIndex, String _itemCode) {
		salesOrderVariationPage.enter_det_item_code(_rowIndex, _itemCode);
	}

	@Step
	public String get_det_qty(int _rowIndex) {
		return salesOrderVariationPage.get_det_qty(_rowIndex);
	}
	@Step
	public void select_det_pack_size(int _rowIndex, String _pack_size) {
		salesOrderVariationPage.select_det_pack_size(_rowIndex, _pack_size);
	}
	@Step
	public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
		salesOrderVariationPage.enter_det_no_of_pack(_rowIndex, _noOfPack);
	}

	@Step
	public void enter_det_item_remarks(int _rowIndex, String _itemRemarks) {
		salesOrderVariationPage.enter_det_item_remarks(_rowIndex, _itemRemarks);
	}

	@Step
	public void get_det_item_description(int _rowIndex) {
		salesOrderVariationPage.get_det_item_description(_rowIndex);
	}

	@Step
	public void select_det_prd(int _rowIndex, String _prd) {
		salesOrderVariationPage.select_det_prd(_rowIndex, _prd);
	}

	@Step
	public void enter_det_qty(int _rowIndex, String _qty) {
		salesOrderVariationPage.enter_det_qty(_rowIndex, _qty);
	}

	@Step
	public String get_det_uom(int _rowIndex) {
		return salesOrderVariationPage.get_det_uom(_rowIndex);
	}

	// @Step public void enter_det_no_of__bags(int _rowIndex, String _noOfBags)
	// {
	// salesOrderVariationPage.;
	// }

	// @Step public void enter_det_pack_size(int _rowIndex, String _packSize) {
	// salesOrderVariationPage.;
	// }

	// @Step public void enter_det_no_of_pack(int _rowIndex, String _noOfPack) {
	// salesOrderVariationPage.;
	// }

	@Step
	public void enter_det_sales_tax(int _rowIndex, String _salesTax) {
		salesOrderVariationPage.enter_det_sales_tax(_rowIndex, _salesTax);
	}

	@Step
	public void enter_det_unit(int _rowIndex, String _unit) {
		salesOrderVariationPage.enter_det_unit(_rowIndex, _unit);
	}

	@Step
	public void enter_det_discount_percent(int _rowIndex, String _discountPercent) {
		salesOrderVariationPage.enter_det_discount_percent(_rowIndex, _discountPercent);
	}

	@Step
	public String get_det_discount_percent(int _rowIndex) {
		return salesOrderVariationPage.get_det_discount_percent(_rowIndex);
	}

	@Step
	public String get_det_total(int _rowIndex) {
		return salesOrderVariationPage.get_det_total(_rowIndex);
	}

	@Step
	public void select_det_pr(int _rowIndex, String _pr) {
		salesOrderVariationPage.select_det_pr(_rowIndex, _pr);
	}

	@Step
	public void select_det_po(int _rowIndex, String _po) {
		salesOrderVariationPage.select_det_po(_rowIndex, _po);
	}

	@Step
	public void enter_det_draft_ost_po_no(int _rowIndex, String _draftOstPONo) {
		salesOrderVariationPage.enter_det_draft_ost_po_no(_rowIndex, _draftOstPONo);
	}

	@Step
	public String get_det_draft_ost_line_item_no(int _rowIndex) {
		return salesOrderVariationPage.get_det_draft_ost_line_item_no(_rowIndex);
	}

	@Step
	public void enter_det_supplier(int _rowIndex, String _supplier) {
		salesOrderVariationPage.enter_det_supplier(_rowIndex, _supplier);
	}

	@Step
	public void enter_det_ccy(int _rowIndex, String _ccy) {
		salesOrderVariationPage.enter_det_ccy(_rowIndex, _ccy);
	}

	@Step
	public void enter_det_po_qty_allocation(int _rowIndex, String _poQtyAllocation) {
		salesOrderVariationPage.enter_det_po_qty_allocation(_rowIndex, _poQtyAllocation);
	}

	@Step
	public void enter_det_unit_cost(int _rowIndex, String _unitCost) {
		salesOrderVariationPage.enter_det_unit_cost(_rowIndex, _unitCost);
	}
	// @Step public void enter_det_supp_quot(int _rowIndex, String _suppQuot) {
	//
	// }

	// @Step public void enter_det_ccy_exch_rate_option(int _rowIndex, String
	// _ccyExchRateOption) {
	// salesOrderVariationPage.;
	// }

	// @Step public void enter_det_qoh(int _rowIndex, String _qoh) {
	// salesOrderVariationPage.;
	// }

	// @Step public void enter_det_qoh_avail(int _rowIndex, String qohAvail) {
	// salesOrderVariationPage.;
	// }

	@Step
	public void enter_det_qoh_allocation(int _rowIndex, String qohAllocation) {
		salesOrderVariationPage.enter_det_qoh_allocation(_rowIndex, qohAllocation);
	}

	// @Step public void enter_det_rebate_code_description(int _rowIndex, String
	// rebateCodeDescription) {
	// salesOrderVariationPage.;
	// }

	// Attachment
	@Step
	public void click_btn_add_attachment() {
		salesOrderVariationPage.click_btn_add_attachment();
	}

	@Step
	public void click_btn_delete_attachment() {
		salesOrderVariationPage.click_btn_delete_attachment();
	}

	@Step
	public void click_btn_cancel_attachment() {
		salesOrderVariationPage.click_btn_cancel_attachment();
	}

	@Step
	public void choose_attachment_file(String _filePath) {
		salesOrderVariationPage.choose_attachment_file(_filePath);
	}

	@Step
	public int get_att_row_by_no(String _AttachmentNo) {
		return salesOrderVariationPage.get_att_row_by_no(_AttachmentNo);
	}

	@Step
	public void click_btn_upload_attachment() {
		salesOrderVariationPage.click_btn_upload_attachment();
	}

	@Step
	public void enter_file_description(int _rowIndex, String _fileDescription) {
		salesOrderVariationPage.enter_file_description(_rowIndex, _fileDescription);
	}

	@Step
	public String get_new_file_mime_type(int _rowIndex) {
		return salesOrderVariationPage.get_new_file_mime_type(_rowIndex);
	}

	@Step
	public String get_new_file_file_size(int _rowIndex) {
		return salesOrderVariationPage.get_new_file_file_size(_rowIndex);
	}

	// END Create SO Variation
	@Step
	public String get_purchase_order_no_then_click_ok() {
		return salesOrderVariationPage.get_purchase_order_no_then_click_ok();
	}

	@Step
	public void purchase_order_no(String _purchase_order_no) {
		System.out.println("***** INFO ***** Purchase Order No: " + _purchase_order_no);
	}

	@Step
	public String get_purchase_requisitions_no_then_click_ok() {
		return salesOrderVariationPage.get_purchase_requisitions_no_then_click_ok();
	}

	@Step
	public void purchase_requisitions_no(String _purchase_requisitions_no) {
		System.out.println("***** INFO ***** Purchase Requisitions No: " + _purchase_requisitions_no);
	}
}
