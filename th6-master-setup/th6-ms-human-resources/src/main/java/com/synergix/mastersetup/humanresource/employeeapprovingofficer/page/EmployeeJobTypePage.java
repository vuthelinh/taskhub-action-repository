package com.synergix.mastersetup.humanresource.employeeapprovingofficer.page;

import com.synergix.common.TH6PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by Synergix57 on 7/29/2016.
 */
public class EmployeeJobTypePage extends TH6PageObject {

	public EmployeeJobTypePage(WebDriver driver) {
		super(driver);
	}

	// BUTTON
	private String xPathBtnNewSummary = "//span[text()='New']";
	private String xPathBtnNew = "//span[text()='Back To Summary']/parent::button/following-sibling::button/span[text()='New']";
	private String xPathBtnUpdate = "//span[text()='Update']";
	private String xPathBtnDelete = "//span[text()='Delete']";
	private String xPathBtnSummary = "//span[text()='Back To Summary']";
	private String xPathTblEJobType = "//table[@role='grid']";

	private String xPathTxtEJobTypeCode = "//div[text()='Employee Job Type Code']/following-sibling::div[1]/input";
	private String xPathTxtEJobTypeDesc = "//*[text()='Description']/following-sibling::div[1]/input";
	private String xPathGroupRadioBox = "//*[text()='Update Project Cost based on Markup Rate']/following-sibling::div[1]//table";
	private String xPathRboxEUpdateProjectCostYes = "//label[text()=' Yes']/preceding-sibling::input[@type='radio']";
	private String xPathRboxEUpdateProjectCostNo = "//label[text()=' No']/preceding-sibling::input[@type='radio']";
	String xPathChboxCompanyNameAll = "//*[text()='Company Name']/parent::th/following-sibling::th//*[contains(@class,'ui-chkbox-box ui-widget ui-corner-all ui-state')]";
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

	public void enter_employee_job_type_code(String EJobTypeCode) {
		waitForAllJSCompletes();
		waitTypeAndTab(xPathTxtEJobTypeCode, EJobTypeCode);

	}

	public boolean is_employee_job_type_code_enabled() {
		String is_enabled = $(xPathTxtEJobTypeCode).getAttribute("readonly");
		if (is_enabled == null) {
			return true;
		}
		return false;
	}

	public void enter_employee_job_type_desc(String EJobTypeDesc) {
		waitForAllJSCompletes();
		waitTypeAndTab(xPathTxtEJobTypeDesc, EJobTypeDesc);

	}

	public void select_update_project_cost_yes() {
		String ischecked = $(xPathRboxEUpdateProjectCostYes).getAttribute("value");
		if (!(ischecked == "true")) {
			selectRadioButton(xPathRboxEUpdateProjectCostYes);
		}

	}

	public void select_update_project_cost_no() {
		waitForAllJSCompletes();
		String ischecked = $(xPathRboxEUpdateProjectCostNo).getAttribute("value");
		if (!(ischecked == "true")) {
			selectRadioButton(xPathRboxEUpdateProjectCostNo);
		}
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

	public void check_company(String companyList) {

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

	public int count_table_company() {
		if (isElementVisible(xPathTblCompany, 1)) {
			return getTbCountDataRow(xPathTblCompany);
		}
		return 0;

	}

	public int count_table_row() {
		if (isElementVisible(xPathTblEJobType, 1)) {
			return getTbCountDataRow(xPathTblEJobType);
		}
		return 0;
	}

	public String xPathTbDataCellByText_EJobType(String _parentXpath, String _givenText, int _cellOrder) {
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

	public String find_xpath_Employee_Job_Type(String _EJobTypeCode) {
		waitForAllJSCompletes();
		return xPathTbDataCellByText_EJobType("", _EJobTypeCode, 1);

	}

	public boolean is_Employee_Job_Type_exist(String _EJobTypeCode) {
		waitForAllJSCompletes();
		return isElementExist(find_xpath_Employee_Job_Type(_EJobTypeCode), 1);
	}

	public int get_row_index(String _EJobTypeCode) {
		waitForAllJSCompletes();
		if (is_Employee_Job_Type_exist(_EJobTypeCode)) {
			return getTbRowIndexOfDataCell(find_xpath_Employee_Job_Type(_EJobTypeCode));
		}
		return 0;
	}

	public boolean is_value_exist_at_colname(String _value, int colindex, String _EJobTypeCode) {
		int _rowindex = get_row_index(_EJobTypeCode);
		String xPath = "//tbody[1]//tr[" + _rowindex + "]/td[" + colindex + "][text()='" + _value + "']";
		waitForAllJSCompletes();
		return isElementExist(xPath);

	}

	public void clickon_employee_job_type_code(String _EJobTypeCode) {
		waitElementToBeClickable(find_xpath_Employee_Job_Type(_EJobTypeCode)).waitUntilClickable().click();
	}

	public void confirm_yes() {
		chooseYesOnUpdateConfirmation();

	}

}
