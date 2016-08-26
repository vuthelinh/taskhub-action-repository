package com.synergix.mastersetup.humanresource.employeeapprovingofficer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmployeeGradePage extends TH6PageObject {

	private static final String DESCRIPTION = "Description";
	private static final String GRADE_CODE = "Grade Code";

	public EmployeeGradePage(WebDriver driver) {
		super(driver);
	}

	public void click_on_button_new() {
		clickBtn("New");
	}

	public void click_on_button_back_to_summary() {
		waitForAllJSCompletes();
		clickBtn("Back To Summary");
	}

	public void enterEmployeeGradeCode(String EmplGradeCode) {
		enterInputFieldCodeWithLabel(GRADE_CODE, EmplGradeCode);
	}

	public String getValueEmployeeGradeCode() {
		return getTextValueWithLabel(GRADE_CODE);
	}

	public void enterDesEmployeeGrade(String des) {
		waitForAllJSCompletes();
		enterInputFieldWithLabel(DESCRIPTION, des);
		waitForAllJSCompletes();
	}

	public String xPathTbDataCellByText_EmpGrade(String _parentXpath, String _givenText, int _cellOrder) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		waitForAllJSCompletes();
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'"
					+ aGivenText[0] + "')]";
			for (int i = 1; i < numText; i++)
				sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i]
						+ "') or contains(text(),'" + aGivenText[i] + "')]";
			return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@role,'cell')][" + sSearchPattern
					+ "])[" + _cellOrder + "]/a";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'"
					+ _givenText + "')]]";
			return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@role,'cell')]" + sSearchPattern
					+ ")[" + _cellOrder + "]/a";
		}
	}

	public String find_xpath_emp_grade(String gradeCode) {
		waitForAllJSCompletes();
		return xPathTbDataCellByText_EmpGrade("", gradeCode, 1);
	}

	public boolean is_emp_grade_exist(String gradeCode) {
		waitForAllJSCompletes();
		return isElementExist(find_xpath_emp_grade(gradeCode), 1);
	}

	public int get_row_index(String gradeCode) {
		waitForAllJSCompletes();
		if (is_emp_grade_exist(gradeCode))
			return getTbRowIndexOfDataCell(find_xpath_emp_grade(gradeCode));
		return 0;
	}

	public boolean is_value_exist_at_index(String _value, String gradeCode) {
		int _rowindex = get_row_index(gradeCode);
		String xPath = "//tbody[1]//tr[" + _rowindex + "]/td[text()='" + _value + "']";
		System.out.println(xPath);
		waitForAllJSCompletes();
		return isElementExist(xPath);
	}

	public void click_on_grade_code(String gradeCode) {
		waitElementToBeClickable(find_xpath_emp_grade(gradeCode)).waitUntilClickable().click();
	}

	public void click_on_button_update() {
		clickBtn("Update");
		chooseYesOnUpdateConfirmation();
	}

	public void click_on_button_delete() {
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
	}

}
