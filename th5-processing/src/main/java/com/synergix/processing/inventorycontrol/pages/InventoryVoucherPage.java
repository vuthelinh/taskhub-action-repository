package com.synergix.processing.inventorycontrol.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160121
 */
public class InventoryVoucherPage extends TH5PageObject {
	public InventoryVoucherPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Sales Order";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	// BEGIN Inventory Voucher Summary
	private String xPathPanelInventoryVoucherSummary = "(//div[text()='Inventory Voucher Summary' or text()='Inventory Voucher Entry']//ancestor::div[1]//table)[1]";

	public void click_btn_new_of_inventory_voucher_summany() {
		clickBtn(xPathPanelInventoryVoucherSummary, "New");
	}

	public void switch_to_tab_draft() {
		switch_to_tab("Draft");
	}

	public void switch_to_tab_outstanding() {
		switch_to_tab("History");
	}

	public void filter_summary_by_voucher_no(String _voucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Voucher No."), _voucherNo);
	}

	public void filter_summary_by_date(String _date) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Date"), _date);
	}

	public void filter_summary_by_transaction_type(String _transactionType) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Transaction Type"), _transactionType);
	}

	public void filter_summary_by_reference_no(String _referenceNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Reference No."), _referenceNo);
	}

	public void filter_summary_by_subject(String _subject) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Subject"), _subject);
	}

	public void filter_summary_by_source_location_description(String _sourceLocationDescription) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Source Location Description"),
				_sourceLocationDescription);
	}

	public void filter_summary_by_created_by(String _createdBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Created By"), _createdBy);
	}

	public void filter_summary_by_created_date(String _createdDateFrom, String _createdDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Created Date From To"),
				_createdDateFrom, _createdDateTo);
	}

	public void filter_summary_by_last_updated_by(String _lastUpdatedBy) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Last Updated By"), _lastUpdatedBy);
	}

	public void filter_summary_by_last_updated_date(String _lastUpdatedDateFrom, String _lastUpdatedDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelInventoryVoucherSummary, "Created Date From To"),
				_lastUpdatedDateFrom, _lastUpdatedDateTo);
	}

	public void open_voucher_no(String _voucherNo) {
		int rowIndex = searchInTbMultiPage(xPathPanelInventoryVoucherSummary, "Voucher No.", 1, _voucherNo, true);
		int headerIndex = getTbColHeaderIndex(xPathPanelInventoryVoucherSummary, "Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelInventoryVoucherSummary, rowIndex, headerIndex) + "//a");
	}

	public void open_first_voucher_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelInventoryVoucherSummary, "Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelInventoryVoucherSummary, 1, headerIndex) + "//a");
	}

	public void open_and_verify_first_voucher(String _voucherNo) {
		int headerIndex = getTbColHeaderIndex(xPathPanelInventoryVoucherSummary, "Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelInventoryVoucherSummary, 1, headerIndex)
				+ "//a[contains(text(),'" + _voucherNo + "')]");
	}
	// END Inventory Voucher Summary

	// BEGIN Inventory Voucher Entry
	// Header
	private String xPathPanelInventoryVoucherEntry = "(//div[text()='Inventory Voucher Entry']//ancestor::div[contains(@class,'rich-panel')])[1]";

	public String get_inventory_voucher_no() {
		return getTextValueWithLabel(xPathPanelInventoryVoucherEntry, "Inventory Voucher No.", 2);
	}

	public void submit_inventory_voucher() {
		click_btn_submit_inventory_voucher();
		clickBtnYesOnConfirmSubmit();
		waitForAllJSCompletes();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	public void click_btn_submit_inventory_voucher() {
		clickBtn(xPathPanelInventoryVoucherEntry, "Submit");
	}

	private String xPathPanelConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You Are About To Submit This Inventory Voucher")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void clickBtnNoOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}
}
