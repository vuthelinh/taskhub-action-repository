package com.synergix.globalsetup.cylinders.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CylinderInterchangeableGroupPage extends TH5PageObject {
	private static final String PURCHASE_AMOUNT = "Unit Purchase Amount";
	private static final String REFUND_AMOUNT = "Unit Refund Amount";
	private static final String DEPOSIT_AMOUNT = "Unit Deposit Amount";
	private static final String ENABLE_DRP = "Enable Deposit / Refund / Purchase";
	private static final String DESCRIPTION = "Description";
	private static final String INTERCHANGEABLE_GROUP_CODE = "Interchangeable Group Code";

	public CylinderInterchangeableGroupPage(WebDriver driver) {
		super(driver);
	}

	public void enter_interchangeable_group_code(String interchangeableGroupCode) {
		enterInputFieldCodeWithLabel(INTERCHANGEABLE_GROUP_CODE,
				interchangeableGroupCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public void select_enable_deposit_or_refund_or_purchase(
			String enableDepositOrRefundOrPurchase) {
		selectRadioButton(ENABLE_DRP,
				enableDepositOrRefundOrPurchase);
	}

	public void enter_unit_deposit_amount(String unitDepositAmount) {
		enterInputFieldWithLabel(DEPOSIT_AMOUNT, unitDepositAmount);
	}

	public void enter_unit_refund_amount(String unitRefundAmount) {
		enterInputFieldWithLabel(REFUND_AMOUNT, unitRefundAmount);
	}

	public void enter_unit_purchase_amount(String unitPurchaseAmount) {
		enterInputFieldWithLabel(PURCHASE_AMOUNT, unitPurchaseAmount);
	}

	public void searchCylinderInterchangeableGroup(String sInterchangeableGroupCode) {
		search(INTERCHANGEABLE_GROUP_CODE, sInterchangeableGroupCode);
	}

	public void selectCylinderInterchangeableGroup(
			String sInterchangeableGroupCode) {
		clickOnElement("//table[@id='mainForm:summaryTable']//descendant::a[text()='"
				+ sInterchangeableGroupCode + "']");
		waitForAllJSCompletes();

	}

	public String get_interchangeable_group_code() {
		return getTextValueWithLabel(INTERCHANGEABLE_GROUP_CODE);
	}

	public String get_description() {
		return getTextValueWithLabel(DESCRIPTION);
	}

	public String get_enable_deposit_or_refund_or_purchase(String option) {
		return isChecked(ENABLE_DRP, option);
	}

	public String get_unit_deposit_amount() {
		return getTextValueWithLabel(DEPOSIT_AMOUNT);
	}

	public String get_unit_refund_amount() {
		return getTextValueWithLabel(REFUND_AMOUNT);
	}

	public String get_unit_purchase_amount() {
		return getTextValueWithLabel(PURCHASE_AMOUNT);
	}

	public String get_no_record_found() {
		return $("//table[@id='searchResult_Form:searchResult_Table']/following-sibling::span")
											.waitUntilPresent().getText();
	}

	public boolean search_cylinder_interchangeable_group(String cylinderIGCode) {
		return search(INTERCHANGEABLE_GROUP_CODE, cylinderIGCode);
	}

}
