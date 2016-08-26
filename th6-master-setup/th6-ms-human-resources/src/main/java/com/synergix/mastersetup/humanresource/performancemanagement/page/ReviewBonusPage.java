package com.synergix.mastersetup.humanresource.performancemanagement.page;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;
import com.synergix.utilities.ReadBean;

public class ReviewBonusPage extends TH6PageObject {

	public ReviewBonusPage(WebDriver driver) {
		super(driver);
	}

	public boolean is_exist_review_grade(String yearFrom) {
		findBy("//button[contains(@id,'detailForm')]//*[text()='ui-button']").click();
		return searchAndSelectByInputCode("Year From", yearFrom);

	}

	/*
	 * public void enter_year_from(String yearFrom) {
	 * enterInputFieldCodeWithLabel("Year From", yearFrom);
	 * waitForAllJSCompletes();
	 * assertThat(findBy(".//*[text()='Year From']/following-sibling::div/input"
	 * ).getValue()).isEqualTo(yearFrom); }
	 * 
	 * public void enter_year_to(String yearTo) {
	 * enterInputFieldCodeWithLabel("Year To", yearTo); waitForAllJSCompletes();
	 * assertThat(findBy(".//*[text()='Year To']/following-sibling::div/input").
	 * getValue()).isEqualTo(yearTo); }
	 */

	public void select_in_employment_type(String employmentType) {
		waitForAllJSCompletes();
		waitElementToBePresent(
				"//*[contains(@id,'syn:bonusSalaryDetailInclude:detailForm')]//div[@class='synfaces-grid-value ']//span")
						.waitUntilClickable().click();
		selectDdlByTextTH6(employmentType);
	}

	public void switch_tab_salary_increment() {
		switch_to_tab("Salary Increment");
	}

	public void switch_tab_bonus_gratuity() {
		waitForAllJSCompletes();
		switch_to_tab("Bonus/Gratuity");
	}

	public void click_btn_add_salary() {
		String xPath = "//*[text()='Add']";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public void click_btn_last_page_salary() {
		String xPath = "//*[@aria-label='Last Page']";
		if (isElementExist(xPath) && !$(xPath).getAttribute("class").contains("disabled")) {
			waitForAllJSCompletes();
			waitElementToBePresent(xPath).waitUntilClickable().click();
		}

	}

	public void click_btn_next_page_salary() {
		String xPath = "//*[@aria-label='Next Page']";
		if (isElementExist(xPath) && !$(xPath).getAttribute("class").contains("disabled")) {
			waitElementToBePresent(xPath).waitUntilClickable().click();
		}

	}

	public void click_btn_back_to_summary() {
		String xPath = "//*[text()='Back To Summary']";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public void click_btn_new() {
		String xPath = "//*[text()='New']";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public void click_btn_new_sumary() {
		String xPath = "//*[text()='New']";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	
	public void click_btn_delete_salary() {
		String xPath = "//*[contains(@id,'salIncrTab')]/*[text()='Delete']";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public void enter_salary_from(String salaryFrom) {
		waitForAllJSCompletes();
		String xPath = "(//tbody[contains(@id,'salaryRangeTbl_data')]//tr)[last()]/td[1]/input";
		waitTypeAndEnterThenUpdateValue(xPath, salaryFrom);
		salaryFrom = salaryFrom + "0";
		assertThat($(xPath).getValue()).isEqualTo(salaryFrom);
	}

	public void enter_salary_to(String salaryTo) {
		String xPath = "(//tbody[contains(@id,'salaryRangeTbl_data')]//tr)[last()]/td[2]/input";
		waitTypeAndEnterThenUpdateValue(xPath, salaryTo);
		salaryTo = salaryTo + "0";
		assertThat($(xPath).getValue()).isEqualTo(salaryTo);
	}

	public void check_del_salary_with_salary_from(String salaryFrom, String salaryTo) {

		String xPath = "//tbody[contains(@id,'salaryRangeTbl_data')]//input[@value='" + salaryFrom
				+ "']/parent::td/following-sibling::td/input[@type='checkbox']";
		if (!$(xPath).isSelected()) {
			clickOnElement(xPath);
		}

	}

	public void uncheck_del_salary_with_salary_from(String salaryFrom) {
		String xPath = "//tbody[contains(@id,'salaryRangeTbl_data')]//input[@value='" + salaryFrom
				+ "']/parent::td/following-sibling::td/input[@type='checkbox']";
		if ($(xPath).isSelected()) {
			clickOnElement(xPath);
		}
	}

	public void enter_increment_with_grade(String grade, String value) {
		String xPath = "//tbody[contains(@id,'salaryRangeGradeTbl')]//td[text()='" + grade
				+ "']/following-sibling::td/input";
		waitTypeAndEnterThenUpdateDate(xPath, value);
		assertThat($(xPath).getValue()).isEqualTo(value);
	}

	public void enter_bonus_gratuity(String grade, String value) {
		String xPath = "//tbody[contains(@id,'bonusTab')]//td[text()='" + grade + "']/following-sibling::td/input";
		waitTypeAndEnterThenUpdateDate(xPath, value);
		assertThat($(xPath).getValue()).isEqualTo(value);
	}

	public void confirm_yes() {
		waitForAllJSCompletes();
		chooseYesOnUpdateConfirmation();

	}

	public int count_row_table_sumary() {
		String xPath = "//*[contains(@id,'bonusSalarySummaryInclude')]//table";
		if (isElementVisible(xPath, 1)) {
			return getTbCountDataRow(xPath);
		} else {
			return 0;
		}

	}

	

	public double find_max_salary() {

		double maxValue = 0;
		String nextButton = "//a[contains(@class, 'ui-paginator-next')][not(contains(@class, 'disabled'))]/span[@class='ui-icon ui-icon-seek-next']";
		while (true) {
			waitForAllJSCompletes();
			int rowsCount = getTbCountDataRow("//*[contains(@id,'salaryRangeTbl')]//table");
			System.out.println("count row="+rowsCount);
			for (int i = 1; i <= rowsCount; i++) {
				waitForAllJSCompletes();
				String _xPath = "//tbody[contains(@id,'salaryRangeTbl_data')]/tr[" + i + "]/td[2]//input";
				if (!isElementExist(_xPath)) {
					maxValue=0;
					break;
				}else{
					String rowValue = waitElementToBePresent(_xPath).getValue();

					double rowValueInt = ReadBean.toDouble(rowValue);
					if (rowValueInt > maxValue)
						maxValue = rowValueInt;
				}
				
				
			}
			if (isElementExist(nextButton)) {
				click_btn_next_page_salary();
			}
			else{
				break;
			}
		}

		return maxValue;

	}

	public int get_ri_salary_range_exist(String salaryFrom, String salaryTo) {

		int ri = 0;
		String nextButton = "//a[contains(@class, 'ui-paginator-next')][not(contains(@class, 'disabled'))]/span[@class='ui-icon ui-icon-seek-next']";
		while (true) {
			waitForAllJSCompletes();
			int rowsCount = getTbCountDataRow("//*[contains(@id,'salaryRangeTbl')]//table");
			System.out.println("count row="+rowsCount);
			for (int i = 1; i <= rowsCount; i++) {
				waitForAllJSCompletes();
				String _xPath = "//tbody[contains(@id,'salaryRangeTbl_data')]/tr[" + i + "]/td[2]//input";
				String salaryToValue = waitElementToBePresent(_xPath).getValue();
				String _xPath2 = "//tbody[contains(@id,'salaryRangeTbl_data')]/tr[" + i + "]/td[1]//input";
				String salaryFromValue = waitElementToBePresent(_xPath2).getValue();

				//double rowValueInt = ReadBean.toDouble(rowValue);
				if (salaryToValue .equals(salaryTo) && salaryFromValue.equals(salaryFrom))
					ri=i;
				break;
			}
			if (isElementExist(nextButton)) {
				click_btn_next_page_salary();
			}
			else{
				break;
			}
		}

		return ri;

	}
	

	public int get_ri_review_bonus_exist(String yearFrom, String yearTo, String emType) {
		int rn = count_row_table_sumary();
		int ri = 0;
		for (int i = 0; i < rn; i++) {

			String xPathYearFrom = "//*[contains(@id,'bonusSalarySummaryInclude')]//table//tr[" + i + "]//a[text()='"
					+ yearFrom + "']";
			String xPathYearto = "//*[contains(@id,'bonusSalarySummaryInclude')]//table//tr[" + i + "]//td[text()='"
					+ yearTo + "']";
			String xPathEmployeeType = "//*[contains(@id,'bonusSalarySummaryInclude')]//table//tr[" + i
					+ "]//td[text()='" + emType + "']";
			if (isElementExist(xPathYearFrom) && isElementExist(xPathYearto) && isElementExist(xPathEmployeeType)) {
				ri = i;
				$(xPathYearFrom).waitUntilClickable().click();
			}
		}
		System.out.println("review bonus row=" + ri);
		return ri;
	}

	/*public String find_max_salary_to() {
		waitUntilAjaxCompletes(1);
		waitUntilHTMLReady(1);
		// waitABit(1000);
		int rn = getTbCountDataRow("//*[contains(@id,'salaryRangeTbl')]//table");
		String maxSalary = "";
		Integer[] arrSalary = new Integer[rn];
		Integer max = 0;

		for (int i = 1; i <= arrSalary.length; i++) {
			String _xPath = "//tbody[contains(@id,'salaryRangeTbl_data')]/tr[" + i + "]/td[2]//input";
			String salaryTo = "";
			if (isElementExist("//tbody[contains(@id,'salaryRangeTbl_data')]/tr[1]/td[text()='No records found.']")) {
			} else {
				salaryTo = waitElementToBePresent(_xPath).getValue();
			}

			int intSalary;
			if (salaryTo.equals("")) {
				intSalary = 0;
			} else {
				salaryTo = salaryTo.substring(0, salaryTo.indexOf("."));
				System.out.println("salaryto=" + salaryTo);
				intSalary = Integer.parseInt(salaryTo);

			}
			arrSalary[i - 1] = intSalary;
		}
		for (int i = 0; i < arrSalary.length; i++) {
			if (arrSalary[i] >= max) {
				max = arrSalary[i];
			}

		}
		maxSalary = String.valueOf(max + 1);
		System.out.println("Max=" + maxSalary);
		return maxSalary;

	}*/

	// Common
	public void selectDdlByTextTH6(String _value) {

		String xpath = "//div[contains(@class,'ui-selectonemenu-panel') and contains(@style,'block')]";
		clickOnElement(xpath + "//ul/li[.='" + _value + "']");
	}

}
