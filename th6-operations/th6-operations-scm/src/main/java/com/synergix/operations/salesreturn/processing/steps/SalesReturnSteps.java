package com.synergix.operations.salesreturn.processing.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.operations.salesreturn.processing.pages.SalesReturnPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * 
 * @author Zoe
 *
 */

public class SalesReturnSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SalesReturnPage salesReturnPage;

	@Step
	public void enter_return_request_date(String returnRequestDate) {
		salesReturnPage.enter_return_request_date(returnRequestDate);
	}

	@Step
	public String get_return_request_date(String returnRequestDate) {
		return salesReturnPage.get_return_request_date();
	}

	@Step
	public void enter_customer_support(String customerSupport) {
		salesReturnPage.enter_customer_support(customerSupport);
	}

	@Step
	public String get_text_customer_support(String customerSupport) {
		return salesReturnPage.get_text_customer_support();
	}

	@Step
	public void enter_source_shipment_no(String sourceShipmentNo) {
		salesReturnPage.enter_source_shipment_no(sourceShipmentNo);
	}

	@Step
	public void enter_collection_date(String colDate) {
		salesReturnPage.enter_collection_date(colDate);
	}

	@Step
	public String get_text_source_shipment_no(String sourceShipmentNo) {
		return salesReturnPage.get_text_source_shipment_no();
	}

	@Step
	public void click_btn_new() {
		salesReturnPage.clickBtn("New");
	}

	@Step
	public void click_btn_submit() {
		salesReturnPage.click_btn_submit();
	}

	@Step
	public void click_btn_back_to_summary() {
		salesReturnPage.back_to_summary();
	}

	@Step
	public void click_btn_returnAll() {
		salesReturnPage.click_btn_ReturnAll();
	}

	@Step
	public void click_btn_abort() {
		salesReturnPage.click_btn_abort();
	}

	@Step
	public void verify_returnRequestDate(String returnRQD) {
		assertThat(salesReturnPage.get_return_request_date(), equalTo(returnRQD));
	}

	@Step
	public void verify_customer_support(String customersp) {
		assertThat(salesReturnPage.get_text_customer_support(), equalTo(customersp));
	}

	@Step
	public void verify_source_shipment(String sourceSN) {
		assertThat(salesReturnPage.get_text_source_shipment_no(), equalTo(sourceSN));
	}

	@Step
	public void verify_customer(String customer) {
		assertThat(salesReturnPage.get_text_customer(), equalTo(customer));
	}

	@Step
	public void verify_sourceDO(String sourceDO) {
		assertThat(salesReturnPage.get_text_source_do_no(), equalTo(sourceDO));
	}

	@Step
	public void verify_sourceSO(String sourceSO) {
		assertThat(salesReturnPage.get_text_source_so_no(), equalTo(sourceSO));
	}

	@Step
	public void verify_customerPO(String customerPO) {
		assertThat(salesReturnPage.get_text_customer_po_no(), equalTo(customerPO));
	}

	@Step
	public void verify_salesperson(String salesperson) {
		assertThat(salesReturnPage.get_text_salesperson(), equalTo(salesperson));
	}

	@Step
	public void verify_shipToAddress(String shipToAddress) {
		assertThat(salesReturnPage.get_text_ship_to_address(), equalTo(shipToAddress));
	}

	@Step
	public void verify_shipToContact(String shipToContact) {
		assertThat(salesReturnPage.get_text_ship_to_contact(), equalTo(shipToContact));
	}

	@Step
	public void verify_actualDate(String actualDate) {
		assertThat(salesReturnPage.get_actual_shipment_date(), equalTo(actualDate));
	}

	@Step
	public void verify_loadingLocation(String loadingL) {
		assertThat(salesReturnPage.get_text_loading_location(), equalTo(loadingL));
	}

	@Step
	public void verify_collectionAdd(String collectionAdd) {
		assertThat(salesReturnPage.get_text_collection_address(), equalTo(collectionAdd));
	}

	@Step
	public void verify_collectionCon(String collectionCon) {
		assertThat(salesReturnPage.get_text_collection_contact(), equalTo(collectionCon));
	}

	@Step
	public void verify_collectionDate(String collectionDate) {
		assertThat(salesReturnPage.get_collection_date(), equalTo(collectionDate));
	}

	@Step
	public void verify_returnQty(String returnQty) {
		assertThat(salesReturnPage.get_text_return_qty(returnQty), equalTo(returnQty));
	}

	@Step
	public void verify_internalRM(String internalRM) {
		assertThat(salesReturnPage.get_text_internalRM(), equalTo(internalRM));
	}

	@Step
	public void verify_externalRM(String externalRM) {
		assertThat(salesReturnPage.get_text_externalRM(), equalTo(externalRM));
	}

	@Step
	public String get_text_code(String sCode) {
		return salesReturnPage.get_code();
	}

	@Step
	public void filter_data(String sCode) {
		salesReturnPage.enter_code_mainPanel(sCode);
	}

	@Step
	public void verify_drawing_object_not_found(String sCode) {
		salesReturnPage.enter_code_without_click(sCode);
		assertThat(salesReturnPage.get_result_code(), equalTo("No records found."));
	}
}
