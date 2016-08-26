package com.synergix.processing.purchase.purchaserequisition.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160121
 */
public class CombinePRPage extends TH5PageObject {
	public CombinePRPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Combine PR";
	// #Region#Page Action
	// Combine PR
	private String xPathPanelSupplier = "//form//table[contains(@id,'supplierTable')]";

	public void filter_by_supplier_code(String _supplierCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSupplier, "Supplier Code"), _supplierCode);
	}

	public void filter_by_supplier_name(String _supplierName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSupplier, "Supplier Name"), _supplierName);
	}

	public void filter_by_currency(String _currency) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelSupplier, "Currency"), _currency);
	}

	public void click_on_no_of_pr_pending_to_generate_po(int _rowIndex) {
		int colIndex = getTbColHeaderIndex(xPathPanelSupplier, "No of PR Pending To Generate PO");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelSupplier, _rowIndex, colIndex) + "//a");
	}

	public void click_btn_back_to_summary() {
		clickBtn("Back To Summary");
	}

	public void click_btn_submit() {
		clickBtn("Submit");
		clickBtnYesOnConfirmSubmit();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	private String xPathInfoPanelConfirm = "//div[text()='Info Panel' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public String get_purchase_order_no() {
		List<String> lPOs = new ArrayList<String>();
		lPOs = get_list_purchase_order_no();
		if (lPOs.size() == 1) {
			return lPOs.get(0).replace("Purchase order '", "").replace("' has been generated successfully", "")
					.replace("Outstanding Purchase Order(s) have been generated: ", "")
					.replace("Draft Purchase Order(s) have been generated: ", "");
		} else {
			System.out.println("***** WARNING *****: There are more than one Purchase Order were created.");
			return lPOs.get(0).replace("Purchase order '", "").replace("' has been generated successfully", "")
					.replace("Outstanding Purchase Order(s) have been generated: ", "")
					.replace("Draft Purchase Order(s) have been generated: ", "");
		}
	}

	public String get_purchase_order_no_backup() {
		String sMessage = waitElementToBeVisible(xPathInfoPanelConfirm + "//span[@class='rich-messages-label']")
				.getText();
		System.out.println(sMessage);
		return sMessage.replace("Purchase order '", "").replace("' has been generated successfully", "")
				.replace("Outstanding Purchase Order(s) have been generated: ", "")
				.replace("Draft Purchase Order(s) have been generated: ", "");
	}

	public List<String> get_list_purchase_order_no() {
		List<String> lPOs = new ArrayList<String>();
		waitElementToBeVisible(xPathInfoPanelConfirm + "//span[@class='rich-messages-label']");
		List<WebElementFacade> elements = withTimeoutOf(1, TimeUnit.SECONDS)
				.findAll(xPathInfoPanelConfirm + "//span[@class='rich-messages-label']");
		for (int j = 0; j < elements.size(); j++) {
			try {
				lPOs.add(elements.get(j).getText());
			} catch (Exception e) {
				// Do nothing
			}
		}
		return lPOs;
	}

	public void click_btn_ok_infor_panel_confirm() {
		clickBtn(xPathInfoPanelConfirm, "OK");
	}

	private String xPathPanelConfirmSubmit = "//div[" + sSpecialTextPredicates("Generate PO from selected PRs?")
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

	// Group PRs to generate PO
	// private String xPathPanelGroupPRs =
	// "//form[contains(@id,'frmPrComSup')]";
	private String xPathTbGroupPRs = "//table[contains(@id,'tblCombinationGroup')]";

	public int get_group_prs_row_index_by_any_text(String _givenText) {
		return getTbRowIndexOfDataCell("(" + xPathTbDataRowsByAnyText(xPathTbGroupPRs, _givenText) + ")[1]");
	}

	public void select_group_prs_row_index_by_any_text(String _givenText) {
		int rowIndex = get_group_prs_row_index_by_any_text(_givenText);
		clickOnElement(xPathTbDataCellByPosition(xPathTbGroupPRs, rowIndex, 1));
	}

	// Purchase Requisition
	private String xPathPanelPurchaseRequisition = "//table[contains(@id,'tblCombinationPr')]";

	public int get_pr_row_index_by_pr_no(String _prNo) {
		return searchInTbMultiPage(xPathPanelPurchaseRequisition, "PR No.", 1, _prNo, true);
	}

	public void check_checkbox_pr_by_pr_no(String _prNo) {
		int checkboxColIndex = getTbColHeaderIndex(xPathTbHeaderChkbox(xPathPanelPurchaseRequisition));
		int checkboxRowIndex = get_pr_row_index_by_pr_no(_prNo);
		checkChkbox(xPathTbDataCellByPosition(xPathPanelPurchaseRequisition, checkboxRowIndex, checkboxColIndex)
				+ "//input[@type='checkbox']");
	}
	// #EndRegion#Page Action
}
