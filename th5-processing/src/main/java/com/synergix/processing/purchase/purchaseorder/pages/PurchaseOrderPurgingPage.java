package com.synergix.processing.purchase.purchaseorder.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160815
 */
public class PurchaseOrderPurgingPage extends TH5PageObject {
	public PurchaseOrderPurgingPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Purchase Order Purging";
	public void click_btn_purge() {
		clickBtn("Purge");
	}

	public boolean is_btn_clickable_purge() {
		return isElementClickable(xPathBtn("Purge"), 1);
	}

	private String xPathPanelConfirmPurger = "//div[" + sSpecialTextPredicates("Purchase Order Purging")
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

	public void enter_purchase_order_no_from(String purchaseOrderNoFrom) {
		enterInputFieldWithLabel("Purchase Order No. From", purchaseOrderNoFrom);
	}

	public String get_text_purchase_order_no_from() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Purchase Order No. From", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
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

	public void enter_supplier_code_from(String supplierCodeFrom) {
		enterInputFieldWithLabel("Supplier Code From", supplierCodeFrom);
	}

	public String get_text_supplier_code_from() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Supplier Code From", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}

	public void enter_purchase_order_no_to(String purchaseOrderNoTo) {
		enterInputFieldWithLabel("Purchase Order No. To", purchaseOrderNoTo);
	}

	public String get_text_purchase_order_no_to() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Purchase Order No. To", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
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

	public void enter_supplier_code_to(String supplierCodeTo) {
		enterInputFieldWithLabel("Supplier Code To", supplierCodeTo);
	}

	public String get_text_supplier_code_to() {
		return waitElementToBePresent(
				xPathTextWithLabel("", "Supplier Code To", 2) + "/ancestor-or-self::td[1]//input[@type='text']")
						.getTextValue();
	}
}
