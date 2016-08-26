package com.synergix.processing.purchase.purchaseorder.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.synergix.processing.purchase.purchaseorder.pages.PurchaseOrderPurgingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160815
 */
public class PurchaseOrderPurgingSteps extends ScenarioSteps {
	PurchaseOrderPurgingPage purchaseOrderPurgingPage;

	@Step
	public void click_btn_purge() {
		purchaseOrderPurgingPage.click_btn_purge();
	}

	@Step
	public void purging() {
		purchaseOrderPurgingPage.click_btn_purge();
		purchaseOrderPurgingPage.click_btn_yes_on_confirm_purging();
		assertThat(purchaseOrderPurgingPage.getErrorMessagesThenClickOK() == null).isTrue();
	}

	@Step
	public boolean is_btn_clickable_purge() {
		return purchaseOrderPurgingPage.is_btn_clickable_purge();
	}

	@Step
	public void click_btn_yes_on_confirm_purging() {
		purchaseOrderPurgingPage.click_btn_yes_on_confirm_purging();
	}

	@Step
	public void click_btn_no_on_confirm_purging() {
		purchaseOrderPurgingPage.click_btn_no_on_confirm_purging();
	}

	@Step
	public void enter_purchase_order_no_from(String purchaseOrderNoFrom) {
		purchaseOrderPurgingPage.enter_purchase_order_no_from(purchaseOrderNoFrom);
	}

	@Step
	public String get_text_purchase_order_no_from() {
		return purchaseOrderPurgingPage.get_text_purchase_order_no_from();
	}

	@Step
	public void enter_order_date_from(String orderDateFrom) {
		purchaseOrderPurgingPage.enter_order_date_from(orderDateFrom);
	}

	@Step
	public String get_text_order_date_from() {
		return purchaseOrderPurgingPage.get_text_order_date_from();
	}

	@Step
	public void enter_supplier_code_from(String supplierCodeFrom) {
		purchaseOrderPurgingPage.enter_supplier_code_from(supplierCodeFrom);
	}

	@Step
	public String get_text_supplier_code_from() {
		return purchaseOrderPurgingPage.get_text_supplier_code_from();
	}

	@Step
	public void enter_purchase_order_no_to(String purchaseOrderNoTo) {
		purchaseOrderPurgingPage.enter_purchase_order_no_to(purchaseOrderNoTo);
	}

	@Step
	public String get_text_purchase_order_no_to() {
		return purchaseOrderPurgingPage.get_text_purchase_order_no_to();
	}

	@Step
	public void enter_order_date_to(String orderDateTo) {
		purchaseOrderPurgingPage.enter_order_date_to(orderDateTo);
	}

	@Step
	public String get_text_order_date_to() {
		return purchaseOrderPurgingPage.get_text_order_date_to();
	}

	@Step
	public void enter_supplier_code_to(String supplierCodeTo) {
		purchaseOrderPurgingPage.enter_supplier_code_to(supplierCodeTo);
	}

	@Step
	public String get_text_supplier_code_to() {
		return purchaseOrderPurgingPage.get_text_supplier_code_to();
	}

}
