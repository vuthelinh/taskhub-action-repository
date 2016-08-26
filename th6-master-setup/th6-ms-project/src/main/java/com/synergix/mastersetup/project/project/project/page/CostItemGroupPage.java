package com.synergix.mastersetup.project.project.project.page;

//import net.serenitybdd.screenplay.actions.Enter;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

/**
 * Created by Lily Hoang on 08/03/2016.
 */
public class CostItemGroupPage extends TH6PageObject {

	public CostItemGroupPage(WebDriver driver) {
		super(driver);
	}

	// Declare variables
	public String xPathIconAddNew = "//*[@class='ui-button-icon-left ui-icon ui-c fa-plus']";
	public String xPathIconDelete = "//*[@class='ui-button-icon-left ui-icon ui-c fa-trash-o']";
	public String xPathIconUpdate = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[5]//span[text()='Update']";
	public String xPathIconExpand = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[1]//div[contains(@class,'ui-row-toggler ui-icon')]";

	public String xPathTxtCostItemGroupCode = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[2]/input";
	public String xPathTxtDescription = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[3]/input";
	public String xPathLabelStatus = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[4]/div";
	public String xPathTxtCostItemGroupCodeSearch = "//table[@role='grid']//thead[contains(@id,'entityTbl_head')]//label[text()='Filter by Cost Item Group Code']/following-sibling::input";
	public String xPathTxtDescriptionSearch = "//table[@role='grid']//thead[contains(@id,'entityTbl_head')]//label[text()='Filter by Description']/following-sibling::input";

	public String xPathChbChoseCostItemGroup = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[6]/descendant-or-self::div[contains(@class,'ui-chkbox-box')]";
	public String xPathChbChoseCostItemGroupAll = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[6]/descendant-or-self::div[contains(@class,'ui-chkbox-box')]";
	public String xPathTblCompanyName = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[2]//table";

	// BUTTON
	public void click_btn_add_new() {
		waitElementToBePresent(xPathIconAddNew).waitUntilClickable().click();
	}

	public void click_btn_delete() {
		waitElementToBePresent(xPathIconDelete).waitUntilClickable().click();
	}

	public void click_btn_update() {
		waitForAllJSCompletes();
		clickOnElement(xPathIconUpdate);
	}

	public boolean is_btn_clickable_update() {
		String is_disable = waitElementToBePresent(xPathIconUpdate).getAttribute("aria-disabled");
		if (is_disable == "false") {
			return true;
		} else {
			return false;
		}

	}

	// Input field
	public void enter_cost_item_group_code(String CostItemGroupCode) {
		waitForAllJSCompletes();
		waitElementToBePresent(xPathTxtCostItemGroupCode).typeAndTab(CostItemGroupCode);

	}

	public boolean is_readonly_cost_item_group_code() {
		waitForAllJSCompletes();
		String is_readonly = waitElementToBePresent(xPathTxtCostItemGroupCode).getAttribute("readonly");
		if (!(is_readonly == null)) {
			return true;
		} else {
			return false;
		}

	}

	public void enter_description(String description) {
		waitForAllJSCompletes();
		waitElementToBePresent(xPathTxtDescription).typeAndTab(description);
	}

	public void enter_cost_item_group_code_search(String CostItemGroupCode) {
		waitForAllJSCompletes();
		waitTypeAndEnter(xPathTxtCostItemGroupCodeSearch, CostItemGroupCode);

	}

	public String get_text_status_before_update() {
		return waitElementToBePresent(xPathLabelStatus).getTextValue();
	}

	public void check_cost_item_group() {

		if (waitElementToBePresent(xPathChbChoseCostItemGroup).getAttribute("checked") == null) {
			highlightElement(xPathChbChoseCostItemGroup + "//ancestor-or-self::td[1]");
			clickOnElement(xPathChbChoseCostItemGroup);
			// waitElementToBePresent(xPathChbChoseCostItemGroup +
			// "/preceding-sibling::div/input[@aria-checked='true']").shouldBeVisible();
		} else {
			highlightElement(xPathChbChoseCostItemGroup + "//ancestor-or-self::td[1]");
		}
	}

	public void uncheck_cost_item_group() {
		uncheckChkbox(xPathChbChoseCostItemGroup);
	}

	public void check_cost_item_group_all() {
		checkChkbox(xPathChbChoseCostItemGroupAll);
	}

	public void uncheck_cost_item_group_all() {
		uncheckChkbox(xPathChbChoseCostItemGroupAll);
	}

	public void click_btn_expand_company_name_table() {

		String classname = waitElementToBePresent(xPathIconExpand).getAttribute("aria-expanded");
		if (classname.contains("false")) {
			clickOnElement(xPathIconExpand);
		}
	}

	public void check_company_name_all() {
		chooseAllCompany();
	}

	public void uncheck_company_name_all() {

	}

	public void confirm_yes() {
		chooseYesOnUpdateConfirmation();

	}

	// Verify
	public boolean is_exist_cost_item_group_code(String CostItemGroupCode) {
		waitForAllJSCompletes();
		String xPathHeader = xPathTxtCostItemGroupCode + "[@value='" + CostItemGroupCode + "']";
		return isElementExist(xPathHeader, 1);

	}

	public int countDataRowTableCompany() {

		if (isElementVisible(xPathTblCompanyName, 1)) {
			return getTbCountDataRow(xPathTblCompanyName);
		}
		return 0;
	}

	public boolean is_value_exist_at_colindex(String _value, int colindex, String regionalOfficeCode) {
		String xPath = "//tbody[1]//tr[1]/td[" + colindex + "]/a[text()='" + _value + "']";
		waitForAllJSCompletes();
		return isElementExist(xPath);

	}

	public boolean is_checked_company_name(int i) {

		String xPath = xPathTblCompanyName + "/tbody/tr[" + i + "]/td[2]//input[@type='checkbox']";
		if (!(waitElementToBePresent(xPath).getAttribute("checked") == null)) {
			return true;
		} else {
			return false;
		}

	}

	public String get_text_company_name(int i) {
		// i = line number
		String xPath = xPathTblCompanyName + "//tbody/tr[" + i + "]/td[1]";
		return waitElementToBePresent(xPath).getTextValue();

	}

	public String get_text_checked_status_label(String header) {
		String xPathStatus = xPathTxtCostItemGroupCode
				+ "/parent::td//following-sibling::td[2]//table[contains(@id,'global_status')]//input[@checked='checked']/following-sibling::label";
		return waitElementToBePresent(xPathStatus).getTextValue();
	}

	public boolean is_checked_status_label(String label) {
		
		String xPathStatus = xPathTxtCostItemGroupCode
				+ "/parent::td//following-sibling::td[2]//table[contains(@id,'global_status')]//label[text()=' " + label
				+ "']/preceding-sibling::input";

		if (!(waitElementToBePresent(xPathStatus).getAttribute("checked") == null)) {
			return true;

		} else {
			return false;
		}
	}

	public String get_text_checked_local_status_label() {
		String xPathStatus = xPathTblCompanyName
				+ "//input[@type='radio'][@checked='checked']/following-sibling::label";
		return waitElementToBePresent(xPathStatus).getTextValue();

	}

	public void selectRadioStatusWithLabel(String statusName) {
		waitForAllJSCompletes();
		String xPathStatus = xPathTxtCostItemGroupCode
				+ "/parent::td//following-sibling::td[2]//table[contains(@id,'global_status')]//descendant-or-self::label[text()=' "
				+ statusName + "']";
		waitElementToBePresent(xPathStatus).waitUntilClickable().click();
	}

	public void selectRadioLocalInfoStatusWithLabel(String localStatusName) {
		waitForAllJSCompletes();
		String xPathStatus = xPathTblCompanyName
				+ "[@role='grid']//table[contains(@id,'companyTable')]//label[text()=' " + localStatusName
				+ "']/preceding-sibling::input";

		if ($(xPathStatus).getAttribute("checked") == null) {
			waitElementToBePresent(xPathStatus).waitUntilClickable().click();
		}
	}

	public void checkCompanyNameWithLabel(String listCompanyNameSplitByComma) {

		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/following-sibling::tr[1]//table";
		try {
			if (listCompanyNameSplitByComma.contains(",")) { // a List Company
																// Name
				String[] companyName = listCompanyNameSplitByComma.split(",");
				for (int i = 0; i < companyName.length; i++) {
					String xPathCbx = xParentCompanyTb + "/tbody/tr[child::td[descendant-or-self::*[text()='"
							+ companyName[i].trim() + "']]]/td[2]//div[contains(@class,'ui-chkbox')]";
					if (isElementExist(xPathCbx)) {
						$(xPathCbx).waitUntilClickable().click();
					}
				}
			} else {
				String xPathCbx = xParentCompanyTb + "/tbody/tr[child::td[descendant-or-self::*[text()='"
						+ listCompanyNameSplitByComma.trim() + "']]]/td[2]//div[contains(@class,'ui-chkbox')]";
				if (isElementExist(xPathCbx))
					$(xPathCbx).click();
			}
			waitForAllJSCompletes();
		} catch (Exception ex) {
			System.out.println("Exception occurs: " + ex);
		}
	}

}
