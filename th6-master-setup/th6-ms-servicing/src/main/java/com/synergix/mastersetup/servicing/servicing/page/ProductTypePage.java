package com.synergix.mastersetup.servicing.servicing.page;

//import net.serenitybdd.screenplay.actions.Enter;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

/**
 * Created by Lily Hoang on 08/03/2016.
 */
public class ProductTypePage extends TH6PageObject {
	// private static final String String = null;

	public ProductTypePage(WebDriver driver) {
		super(driver);
	}

	// Declare variables
	public String xPathIconAddNew = "//*[@class='ui-button-icon-left ui-icon ui-c fa-plus']";
	public String xPathIconDelete = "//*[@class='ui-button-icon-left ui-icon ui-c fa-trash-o']";
	public String xPathIconUpdate = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[5]//span[text()='Update']";

	public String xPathTxtProductTypeCode = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[2]/input";
	public String xPathTxtDescription = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[3]/input";
	public String xPathLabelStatus = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[4]/div";

	public String xPathTxtProductTypeCodeSearch = "//table[@role='grid']//thead[contains(@id,'entityTbl_head')]//label[text()='Filter by Product Type Code']/following-sibling::input";

	public void click_btn_add_new() {
		waitElementToBePresent(xPathIconAddNew).waitUntilClickable().click();
	}

	public void click_btn_delete() {
		waitForAllJSCompletes();
		waitElementToBePresent(xPathIconDelete).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void enter_product_type_code(String productTypeCode) {
		waitForAllJSCompletes();
		enterInputFieldInFirstRowWithColindex(2, productTypeCode);
	}

	public boolean is_readonly_product_type_code() {
		waitForAllJSCompletes();
		String is_readonly = waitElementToBePresent(xPathTxtProductTypeCode).getAttribute("readonly");
		if (!(is_readonly == null)) {
			return true;
		} else {
			return false;
		}

	}

	public void enter_description(String description) {
		waitForAllJSCompletes();
		enterInputFieldInFirstRowWithColindex(3, description);
	}

	public void enter_product_type_code_search(String productTypeCode) {
		waitForAllJSCompletes();
		waitTypeAndEnter(xPathTxtProductTypeCodeSearch, productTypeCode);

	}

	public String get_text_status_before_update() {
		return waitElementToBePresent(xPathLabelStatus).getTextValue();
	}

	public void click_btn_update() {
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

	public void check_product_type(String productTypeCode) {
		checkChboxWithHeader(productTypeCode);
		waitForAllJSCompletes();
	}

	public void uncheck_product_type(String productTypeCode) {
		uncheckChboxWithHeader(productTypeCode);
	}

	public void check_product_type_all() {
		checkChboxWithHeader("Product Type Code");
	}

	public void uncheck_product_type_all() {
		uncheckChboxWithHeader("Product Type Code");
	}

	public void click_btn_collapse_company_name(String productTypeCode) {
		ClickCollapseCompanyNameTbl(productTypeCode);
	}

	public void confirm_yes() {

		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();

	}

	// COMMON
	/*
	 * @Description: Enter input field in first row with column index,
	 * 
	 * @parameter: i =column index, value = input value
	 * 
	 * @author: Lily Hoang
	 */
	public void enterInputFieldInFirstRowWithColindex(int i, String value) {
		String xPath = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[1]/td[" + i + "]/input";
		waitTypeAndEnter(xPath, value);
	}

	/*
	 * @Description: check checkbox with header (Use to check checkbox in
	 * company name table under Value row)
	 * 
	 * @parameter: header = value at "CODE" col
	 * 
	 * @author: Lily Hoang
	 */

	public void checkChboxWithHeader(String header) {

		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xPath = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/td[6]//input[contains(@name,'entityTbl_checkbox')]";
		String classname = waitElementToBePresent(xPath).getAttribute("aria-checked");
		if (!(classname == "true")) {

			highlightElement(xPath + "//ancestor-or-self::td[1]");
			clickOnElement(xPath + "/parent::div/following-sibling::div/span");
			// waitElementToBePresent(xPath +
			// "[@aria-checked='true']").shouldBeVisible();
		} else {
			highlightElement(xPath + "//ancestor-or-self::td[1]");
		}

	}

	/*
	 * @Description: check checkbox with header (Use to check checkbox in
	 * company name table under Value row)
	 * 
	 * @parameter: header = value at "CODE" col
	 * 
	 * @author: Lily Hoang
	 */
	public void uncheckChboxWithHeader(String header) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xPath = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/td[6]//div[contains(@class,'ui-chkbox-box')]";
		String classname = waitElementToBePresent(xPath).getAttribute("class");
		if (classname.contains("active")) {
			uncheckChkbox(xPath);
		} else {
		}
	}

	/*
	 * @Description: Check and expand company name table
	 * 
	 * @parameter: header = value at "CODE" col
	 * 
	 * @author: Lily Hoang
	 */
	public void ClickCollapseCompanyNameTbl(String header) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xPath = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/td[1]//div[contains(@class,'ui-row-toggler ui-icon')]";
		String classname = waitElementToBePresent(xPath).getAttribute("aria-expanded");
		if (classname.contains("false")) {
			clickOnElement(xPath);
		}
	}

	public void checkCompanyNameWithLable(String header, String listCompanyNameSplitByComma) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/following-sibling::tr[1]//table";
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

	public int countDataRowTableCompanyWithHeader(String header) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/following-sibling::tr[1]//table";

		if (isElementVisible(xParentCompanyTb, 1)) {
			return getTbCountDataRow(xParentCompanyTb);
		}
		return 0;
	}

	public void checkAllCompanyWithHeader(String header) {
		waitForAllJSCompletes();
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/following-sibling::tr[1]//table[@role='grid']";
		String xAllCompanyCbx = xParentCompanyTb + "/thead//*[@type='checkbox']";

		if (waitElementToBePresent(xAllCompanyCbx).getAttribute("checked") == null) {
			xAllCompanyCbx += "/parent::div/following-sibling::div";
			$(xAllCompanyCbx).click();
			waitForAllJSCompletes();
		}
	}

	public void uncheckAllCompanyWithHeader(String header) {
		waitForAllJSCompletes();
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/following-sibling::tr[1]//table[@role='grid']";
		String xAllCompanyCbx = xParentCompanyTb + "/thead//*[@type='checkbox']/parent::div/following-sibling::div";
		if (waitElementToBePresent(xAllCompanyCbx).getAttribute("class").contains("active")) {
			highlightElement(xAllCompanyCbx + "//ancestor-or-self::td[1]");
			clickOnElement(xAllCompanyCbx);
			waitElementToBePresent(xAllCompanyCbx).shouldBeVisible();
		} else {
			highlightElement(xAllCompanyCbx + "//ancestor-or-self::td[1]");
		}
	}

	public boolean is_exist_product_type_code(String header) {
		waitForAllJSCompletes();
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		return isElementExist(xPathHeader, 1);

	}

	public boolean is_value_exist_at_colindex(String _value, int colindex, String regionalOfficeCode) {
		int _rowindex = get_row_index(regionalOfficeCode);
		String xPath = "//tbody[1]//tr[" + _rowindex + "]/td[" + colindex + "]/a[text()='" + _value + "']";
		waitForAllJSCompletes();
		return isElementExist(xPath);

	}

	private int get_row_index(String value) {
		waitForAllJSCompletes();
		String xPathValue = xPathTbDataCellProductTypeCode("", value, 1);
		if (is_exist_product_type_code(value)) {
			return getTbRowIndexOfDataCell(xPathValue);
		}
		return 0;
	}

	public String get_text_company_name(int i, String header) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader);
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/following-sibling::tr[1]//table";
		String xPath = xParentCompanyTb + "//tbody/tr[" + i + "]/td[1]";
		return waitElementToBePresent(xPath).getTextValue();

	}

	public boolean is_checked_company_name(int i, String header) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader) + 1;
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/descendant-or-self::table";
		String xPath = xParentCompanyTb + "/tbody/tr[" + i + "]/td[2]//input[@type='checkbox']";

		if (!(waitElementToBePresent(xPath).getAttribute("checked") == null)) {
			return true;
		} else {
			return false;
		}

	}

	public String xPathTbDataCellProductTypeCode(String _parentXpath, String _givenText, int _cellOrder) {
		waitForAllJSCompletes();
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'"
					+ aGivenText[0] + "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i]
						+ "') or contains(text(),'" + aGivenText[i] + "')]";
			}
			return "(" + _parentXpath
					+ "//tbody//descendant-or-self::td[contains(@class,'cell') or contains(@role,'cell')]/"
					+ sSearchPattern + ")[" + _cellOrder + "]";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'"
					+ _givenText + "')]])";
			return "(" + _parentXpath
					+ "//tbody//descendant-or-self::td[contains(@class,'cell') or contains(@role,'cell')]"
					+ sSearchPattern + "[" + _cellOrder + "]";
		}
	}

	public String get_text_checked_status_label(String header) {

		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		String xPathStatus = xPathHeader
				+ "//following-sibling::td[2]//table[contains(@id,'global_status')]//input[@checked='checked']/following-sibling::label";
		return waitElementToBePresent(xPathStatus).getTextValue();
	}

	public boolean is_checked_status_label(String header, String label) {

		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		String xPathStatus = xPathHeader
				+ "//following-sibling::td[2]//table[contains(@id,'global_status')]//label[text()=' " + label
				+ "']/preceding-sibling::input";

		if (!(waitElementToBePresent(xPathStatus).getAttribute("checked") == null)) {
			return true;

		} else {
			return false;
		}
	}

	public void selectRadioStatusWithLabel(String header, String label) {

		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		String xPathStatus = xPathHeader
				+ "//following-sibling::td[2]//table[contains(@id,'global_status')]//descendant-or-self::label[text()=' "
				+ label + "']";
		waitElementToBePresent(xPathStatus).waitUntilClickable().click();
	}

	public void selectRadioLocalInfoStatusWithLabel(String header, String label) {
		String xPathHeader = xPathTbDataCellProductTypeCode("", header, 1);
		int rowindex = getTbRowIndexOfDataCell(xPathHeader) + 1;
		String xParentCompanyTb = "//table[@role='grid']/tbody[contains(@id,'entityTbl_data')]/tr[" + rowindex
				+ "]/descendant-or-self::table";

		String xPathStatus = xParentCompanyTb + "[@role='grid']//table[contains(@id,'companyTable')]//label[text()=' "
				+ label + "']/preceding-sibling::input";

		if ($(xPathStatus).getAttribute("checked") == null) {
			waitElementToBePresent(xPathStatus).waitUntilClickable().click();
		}
	}

}
