package com.synergix.processing.sales.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160815
 */
public class SalesOrderPurgingPage extends TH5PageObject {
	public SalesOrderPurgingPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Sales Order Purging";
	public void click_btn_purge() {
		clickBtn("Purge");
	}

	public boolean is_btn_clickable_purge() {
		return isElementClickable(xPathBtn("Purge"), 1);
	}

	private String xPathPanelConfirmPurger = "//div[" + sSpecialTextPredicates("Sales Order Purging")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_yes_on_confirm_purging() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmPurger).shouldBeVisible();
		clickBtn(xPathPanelConfirmPurger, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmPurger);
	}

	public void click_btn_no_on_confirm_purging() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmPurger).shouldBeVisible();
		clickBtn(xPathPanelConfirmPurger, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmPurger);
	}

	public void enter_sales_order_no_from(String salesOrderNoFrom) {
		enterInputFieldWithLabel("Sales Order No From", salesOrderNoFrom);
	}

	public String get_text_sales_order_no_from() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Sales Order No From", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}

	public void enter_order_date_from(String orderDateFrom) {
		if (orderDateFrom.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Order Date From");
		} else {
			enterInputFieldWithLabel("Order Date From", orderDateFrom);
		}
	}

	public String get_text_order_date_from() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Order Date From", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}

	public void enter_customer_code_from(String customerCodeFrom) {
		enterInputFieldWithLabel("Customer Code From", customerCodeFrom);
	}

	public String get_text_customer_code_from() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Customer Code From", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}

	public void enter_sales_order_no_to(String salesOrderNoTo) {
		enterInputFieldWithLabel("Sales Order No To", salesOrderNoTo);
	}

	public String get_text_sales_order_no_to() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Sales Order No To", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}

	public void enter_order_date_to(String orderDateTo) {
		if (orderDateTo.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Order Date To");
		} else {
			enterInputFieldWithLabel("Order Date To", orderDateTo);
		}
	}

	public String get_text_order_date_to() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Order Date To", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}

	public void enter_customer_code_to(String customerCodeTo) {
		enterInputFieldWithLabel("Customer Code To", customerCodeTo);
	}

	public String get_text_customer_code_to() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Customer Code To", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}
}
