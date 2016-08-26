package com.synergix.mastersetup.humanresource.employeeapprovingofficer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

/**
 * Created by Lily Hoang on 08/03/2016.
 */
public class RegionalOfficePage extends TH6PageObject {

	public RegionalOfficePage(WebDriver driver) {
		super(driver);
	}

	// BUTTON
	private String xPathBtnNew = "//span[text()='Back To Summary']/parent::button/following-sibling::button/span[text()='New']";
	private String xPathBtnUpdate = "//span[text()='Update']";
	private String xPathBtnDelete = "//span[text()='Delete']";
	private String xPathBtnSummary = "//span[text()='Back To Summary']";

	private String xPathTxtRegionalOfficeCode = "//div[text()='Regional Office Code']/following-sibling::div[1]/input";
	private String xPathTxtRegionalOfficeName = "//*[text()='Regional Office Name']/following-sibling::div[1]/input";
	private String xPathChboxCompanyNameAll = "//*[text()='Company Name']/parent::th/following-sibling::th//*[contains(@class,'ui-chkbox-box ui-widget ui-corner-all ui-state')]";
	private String xPathTblCompany = "//*[contains(@id,'companyTable_head')]/ancestor::div[@class='ui-datatable-tablewrapper']";

	// button chung
	public void clickon_btn_new_summary() {
		clickBtn("New");
	}

	public void clickon_btn_new() {
		waitElementToBePresent(xPathBtnNew).waitUntilClickable().click();
	}

	public void clickon_btn_update() {
		waitElementToBePresent(xPathBtnUpdate).waitUntilClickable().click();
	}

	public void clickon_btn_delete() {
		waitElementToBePresent(xPathBtnDelete).waitUntilClickable().click();
	}

	public void clickon_btn_back_to_summary() {
		waitElementToBePresent(xPathBtnSummary).waitUntilClickable().click();
	}

	public void enter_regional_office_code(String regionalOfficeCode) {
		waitForAllJSCompletes();
		waitTypeAndTab(xPathTxtRegionalOfficeCode, regionalOfficeCode);

	}

	public boolean is_readonly_regional_office_code() {
		String is_readonly = $(xPathTxtRegionalOfficeCode).getAttribute("readonly");
		if (is_readonly == null) {
			return true;
		}
		return false;
	}

	public void enter_regional_office_name(String regionalOfficeName) {
		waitForAllJSCompletes();
		waitTypeAndTab(xPathTxtRegionalOfficeName, regionalOfficeName);

	}

	public void check_company_all() {
		waitForAllJSCompletes();
		chooseAllCompany();
	}

	public void uncheck_company_all() {
		waitForAllJSCompletes();

		if (waitElementToBePresent(xPathChboxCompanyNameAll).getAttribute("class").contains("active")) {
			highlightElement(xPathChboxCompanyNameAll + "//ancestor-or-self::td[1]");
			clickOnElement(xPathChboxCompanyNameAll);
			waitElementToBePresent(xPathChboxCompanyNameAll).shouldBeVisible();
		} else {
			highlightElement(xPathChboxCompanyNameAll + "//ancestor-or-self::td[1]");
		}
	}

	public void check_company_list(String companyList) {

		if (waitElementToBePresent(xPathChboxCompanyNameAll).getAttribute("class").contains("default")) {
			highlightElement(xPathChboxCompanyNameAll + "//ancestor-or-self::td[1]");
			waitElementToBePresent(xPathChboxCompanyNameAll).waitUntilClickable().click();
			uncheck_company_all();
		} else {
			highlightElement(xPathChboxCompanyNameAll + "//ancestor-or-self::td[1]");
			uncheck_company_all();
		}
		waitForAllJSCompletes();
		chooseCompany(companyList);
	}

	public int count_data_row_table_company() {
		if (isElementVisible(xPathTblCompany, 1)) {
			return getTbCountDataRow(xPathTblCompany);
		}
		return 0;

	}

	public int count_table_row() {
		if (isElementVisible(xPathTblCompany, 1)) {
			return getTbCountDataRow(xPathTblCompany);
		}
		return 0;
	}

	public String xPathTbDataCellByText_RegionalOffice(String _parentXpath, String _givenText, int _cellOrder) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		waitForAllJSCompletes();
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'"
					+ aGivenText[0] + "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i]
						+ "') or contains(text(),'" + aGivenText[i] + "')]";
			}
			return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@role,'cell')][" + sSearchPattern
					+ "])[" + _cellOrder + "]/a";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'"
					+ _givenText + "')]]";
			return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@role,'cell')]" + sSearchPattern
					+ ")[" + _cellOrder + "]/a";
		}
	}

	public String find_xpath_regional_office(String regionalOfficeCode) {
		waitForAllJSCompletes();
		return xPathTbDataCellByText_RegionalOffice("", regionalOfficeCode, 1);

	}

	public boolean is_exist_regional_office_at_list(String regionalOfficeCode) {
		waitForAllJSCompletes();
		return isElementExist(find_xpath_regional_office(regionalOfficeCode), 1);
	}

	public int get_row_index(String regionalOfficeCode) {
		waitForAllJSCompletes();
		if (is_exist_regional_office_at_list(regionalOfficeCode)) {
			return getTbRowIndexOfDataCell(find_xpath_regional_office(regionalOfficeCode));
		}
		return 0;
	}

	public boolean is_value_exist_at_colindex(String _value, int colindex, String regionalOfficeCode) {
		int _rowindex = get_row_index(regionalOfficeCode);
		String xPath = "//tbody[1]//tr[" + _rowindex + "]/td[" + colindex + "]/a[text()='" + _value + "']";
		waitForAllJSCompletes();
		return isElementExist(xPath);

	}

	public void clickon_link_regional_office(String regionalOfficeCode) {
		waitElementToBeClickable(find_xpath_regional_office(regionalOfficeCode)).waitUntilClickable().click();
	}

	public void confirm_yes() {
		chooseYesOnUpdateConfirmation();

	}

	public String get_text_regional_office_code() {

		return waitElementToBePresent(xPathTxtRegionalOfficeCode).getTextValue();

	}

	public String get_text_regional_office_name() {

		return waitElementToBePresent(xPathTxtRegionalOfficeName).getTextValue();

	}

	public String get_text_company_name(int i) {
		int j = i + 1;
		String xPath = "//table[@role='grid']/tbody/tr[" + j + "]/td[1]";
		return waitElementToBePresent(xPath).getTextValue();

	}

	public boolean is_checked_company_name(int i) {

		int j = i + 1;
		String xPath = "//table[@role='grid']/tbody/tr[" + j + "]/td[1]";
		String xpathchb = xPath
				+ "/following-sibling::td[1]//div[contains(@class,'ui-chkbox-box ui-widget ui-corner-all ui-state')]";
		if (waitElementToBePresent(xpathchb).getAttribute("class").contains("default")) {
			return false;
		}
		return true;

	}

	public String get_today() {
		return getToday();

	}

}
