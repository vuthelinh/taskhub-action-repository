package com.synergix.processing.sales.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.synergix.processing.sales.pages.SalesOrderPurgingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160815
 */
public class SalesOrderPurgingSteps extends ScenarioSteps {
	SalesOrderPurgingPage salesOrderPurgingPage;

	@Step
	public void click_btn_purge() {
		salesOrderPurgingPage.click_btn_purge();
	}

	@Step
	public void purging() {
		salesOrderPurgingPage.click_btn_purge();
		salesOrderPurgingPage.click_btn_yes_on_confirm_purging();
		assertThat(salesOrderPurgingPage.getErrorMessagesThenClickOK() == null).isTrue();
	}

	@Step
	public boolean is_btn_clickable_purge() {
		return salesOrderPurgingPage.is_btn_clickable_purge();
	}

	@Step
	public void click_btn_yes_on_confirm_purging() {
		salesOrderPurgingPage.click_btn_yes_on_confirm_purging();
	}

	@Step
	public void click_btn_no_on_confirm_purging() {
		salesOrderPurgingPage.click_btn_no_on_confirm_purging();
	}

	@Step
	public void enter_sales_order_no_from(String salesOrderNoFrom) {
		salesOrderPurgingPage.enter_sales_order_no_from(salesOrderNoFrom);
	}

	@Step
	public String get_text_sales_order_no_from() {
		return salesOrderPurgingPage.get_text_sales_order_no_from();
	}

	@Step
	public void enter_order_date_from(String orderDateFrom) {
		salesOrderPurgingPage.enter_order_date_from(orderDateFrom);
	}

	@Step
	public String get_text_order_date_from() {
		return salesOrderPurgingPage.get_text_order_date_from();
	}

	@Step
	public void enter_customer_code_from(String customerCodeFrom) {
		salesOrderPurgingPage.enter_customer_code_from(customerCodeFrom);
	}

	@Step
	public String get_text_customer_code_from() {
		return salesOrderPurgingPage.get_text_customer_code_from();
	}

	@Step
	public void enter_sales_order_no_to(String salesOrderNoTo) {
		salesOrderPurgingPage.enter_sales_order_no_to(salesOrderNoTo);
	}

	@Step
	public String get_text_sales_order_no_to() {
		return salesOrderPurgingPage.get_text_sales_order_no_to();
	}

	@Step
	public void enter_order_date_to(String orderDateTo) {
		salesOrderPurgingPage.enter_order_date_to(orderDateTo);
	}

	@Step
	public String get_text_order_date_to() {
		return salesOrderPurgingPage.get_text_order_date_to();
	}

	@Step
	public void enter_customer_code_to(String customerCodeTo) {
		salesOrderPurgingPage.enter_customer_code_to(customerCodeTo);
	}

	@Step
	public String get_text_customer_code_to() {
		return salesOrderPurgingPage.get_text_customer_code_to();
	}

}
