package com.synergix.mastersetup.humanresource.performancemanagement.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import com.synergix.common.TH6PageObject;
import com.synergix.utilities.ReadBean;

public class ReviewGradePage extends TH6PageObject {

	public ReviewGradePage(WebDriver driver) {
		super(driver);
	}

	public String xPathBtnAddNew = "//*[text()='New']";
	public String xPathBtnExpand = "";

	public String xPathTblScoreRange = "//div[contains(@id,'scoreTable')][@class='ui-datatable ui-widget']";
	public String xPathTblReviewType = "//div[contains(@id,'typeTable')][@class='ui-datatable ui-widget']";
	public String xPathBtnNew = "//span[@class='synfaces-float-left']";
	public String xPathBtnDelete = "//span[contains(@class,'delete')]";

	public String xPathTblParent = "//*[contains(@id,'reviewGradeTable_head')]/parent::table";
	public String xPathTblData = "//*[contains(@id,'reviewGradeTable_data')]";
	private Integer[] arrToYears;

	public void click_btn_add_new() {
		waitElementToBePresent(xPathBtnAddNew).waitUntilClickable().click();
	}

	public void click_btn_expand_detail(String fromYear, String toYear, int rowindex) {

		String xPath = "//tbody[contains(@id,'reviewGradeTable_data')]/tr[" + rowindex + "]/td[1]/div";
		if (waitElementToBePresent(xPath).getAttribute("aria-expanded").equals("false")) {
			waitElementToBePresent(xPath).waitUntilClickable().click();
		}

	}

	public void click_btn_collapse_detail(String fromYear, String toYear, int rowindex) {

		String xPath = "//tbody[contains(@id,'reviewGradeTable_data')]/tr[" + rowindex + "]/td[1]/div";
		if (waitElementToBePresent(xPath).getAttribute("aria-expanded").equals("true")) {
			waitElementToBePresent(xPath).waitUntilClickable().click();
		}

	}

	public void enter_from_year(String fromYear) {
		waitForAllJSCompletes();
		String _xPath = xPathTblData + "/tr[1]/td[2]//input";
		waitElementToBePresent(_xPath).typeAndTab(fromYear);
		waitForAllJSCompletes();
		assertThat(waitElementToBePresent(_xPath).getValue()).isEqualTo(fromYear);
	}

	public String get_text_from_year_at_row(int ri) {
		String _xPath = xPathTblData + "/tr[" + ri + "]/td[2]//input";
		return waitElementToBePresent(_xPath).getValue();

	}

	public String is_readonly_from_year(String fromYear) {
		String _xPath = xPathTblData + "/tr[1]/td[2]//input";
		return waitElementToBePresent(_xPath).getAttribute("aria-readonly");

	}

	public void enter_to_year(String toYear) {

		String _xPath = xPathTblData + "/tr[1]/td[3]//input";
		waitTypeAndTab(_xPath, "" + toYear + "");

		waitForAllJSCompletes();
		assertThat(waitElementToBePresent(_xPath).getValue()).isEqualTo(toYear);
	}

	public String get_text_to_year_at_row(int ri) {
		String _xPath = xPathTblData + "/tr[" + ri + "]/td[3]//input";
		return waitElementToBePresent(_xPath).getValue();
	}

	public String is_readonly_to_year(String toYear) {
		String _xPath = xPathTblData + "/tr[1]/td[3]//input";
		return waitElementToBePresent(_xPath).getAttribute("aria-readonly");
	}

	public int count_row_table_review_grade() {

		if (isElementVisible(xPathTblParent, 1)) {

			String xPath = "(" + xPathTblParent
					+ "//descendant-or-self::tbody[tr[@class]][1])/tr[contains(@class,'ui-widget-content')][@role='row']";
			if (isElementVisible(xPath, 1)) {
				int rownumber = waitElementToBePresent(xPath).thenFindAll(xPath).size();

				return rownumber;
			}
		}
		return 0;

	}

	public String find_max_to_year() {
		int rn = count_row_table_review_grade();
		String maxToYear = "";
		Integer[] arrToYears = new Integer[rn];

		Integer max = 0;
		for (int i = 1; i <= arrToYears.length; i++) {
			String _xPath = xPathTblData + "/tr[" + i + "]/td[3]//input";
			String toYear = waitElementToBePresent(_xPath).getValue();
			int intToYear;
			if (toYear.equals("")) {
				intToYear = 0;
			} else {
				intToYear = Integer.parseInt(toYear);
			}
			arrToYears[i - 1] = intToYear;
		}
		for (int i = 1; i < arrToYears.length; i++) {
			if (arrToYears[i] >= max) {
				max = arrToYears[i];
			}

		}
		maxToYear = String.valueOf(max + 1);
		return maxToYear;

	}
	public void click_btn_next_page_review_grade() {
		String xPath = "//*[@aria-label='Next Page']";
		if (isElementExist(xPath) && !$(xPath).getAttribute("class").contains("disabled")) {
			waitElementToBePresent(xPath).waitUntilClickable().click();
		}

	}
	public void click_btn_first_page_review_grade() {
		String xPath = "//*[@aria-label='First Page']";
		if (isElementExist(xPath) && !$(xPath).getAttribute("class").contains("disabled")) {
			waitElementToBePresent(xPath).waitUntilClickable().click();
		}

	}
	public int find_max_to_year1() {

		int maxValue = 0;
		String nextButton = "//a[contains(@class, 'ui-paginator-next')][not(contains(@class, 'disabled'))]/span[@class='ui-icon ui-icon-seek-next']";
		while (true) {
			waitForAllJSCompletes();
			int rowsCount = getTbCountDataRow("//*[contains(@id,'reviewGradeTable')]//table");
			//System.out.println("count row="+rowsCount);
			for (int i = 1; i <= rowsCount; i++) {
				waitForAllJSCompletes();
				String _xPath = "//tbody[contains(@id,'reviewGradeTable_data')]/tr[" + i + "]/td[2]//input";
				String rowValue = waitElementToBePresent(_xPath).getValue();

				int rowValueInt = ReadBean.toInt(rowValue);
				if (rowValueInt > maxValue)
					maxValue = rowValueInt;
			}
			if (isElementExist(nextButton)) {
				click_btn_next_page_review_grade();
			}
			else{
				break;
			}
		}
		maxValue=maxValue+1;
		click_btn_first_page_review_grade();
		return maxValue;

	}
	public int is_exist_review_grade_at_rowindex(String fromYear, String toYear) {
		int rowindex = 0;
		for (int i = 0; i < count_row_table_review_grade(); i++) {
			int j = i + 1;
			String _FromYear = "";
			String _ToYear = "";
			int intFromYear = 0;
			int intToYear = 0;
			int sfromYear = 0;
			int stoYear = 0;
			if (isElementExist(xPathTblData + "/tr[" + j + "]/td[2]//input")) {
				_FromYear = waitElementToBePresent(xPathTblData + "/tr[" + j + "]/td[2]//input").getValue();

				_ToYear = waitElementToBePresent(xPathTblData + "/tr[" + j + "]/td[3]//input").getValue();

			}

			try {

				if (!_FromYear.isEmpty()) {
					intFromYear = Integer.parseInt(_FromYear);
				}

				if (!_ToYear.isEmpty()) {
					intToYear = Integer.parseInt(_ToYear);
				}

				sfromYear = Integer.parseInt(fromYear);
				stoYear = Integer.parseInt(toYear);

			} catch (Exception e) {
				System.out.println(
						" ERROR  Recheck input values for From Year = " + _FromYear + " or To Year = " + _ToYear);
			}

			if ((sfromYear >= intFromYear && sfromYear <= intToYear)
					|| (stoYear >= intFromYear && stoYear <= intToYear)) {
				rowindex = j;

			}

		}
		return rowindex;

	}

	// SCORE TABLE

	public void click_btn_new_score_range(String fromYear, String toYear, int rowindex) {
		String xPath = "//tbody/tr[" + rowindex + "]" + xPathBtnNew + "/button[contains(@id,'scoreTable')]";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public void click_btn_delete_score_range(String fromYear, String toYear, int rowindex) {
		waitForAllJSCompletes();
		String xPath = "//tbody/tr[" + rowindex + "]" + xPathBtnDelete + "/button[contains(@id,'scoreTable')]";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public int count_row_table_score_range(String fromYear, String toYear, int rowindex) {
		String xPath = "//tbody/tr[" + rowindex + "]//table/td[1]/div[contains(@id,'scoreTable')]//table";
		if (isElementVisible(xPath, 1)) {
			return getTbCountDataRow(xPath);
		}
		return 0;

	}

	public int is_exist_score_range_at_rowindex(String fromYear, String toYear, int scoreFrom, int scoreTo) {
		int rowindex = is_exist_review_grade_at_rowindex(fromYear, toYear) + 1;
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table/td[1]/div[contains(@id,'scoreTable')]//table";

		int scoreRowindex = 0;
		for (int i = 1; i < count_row_table_score_range(fromYear, toYear, rowindex); i++) {

			String _scoreFrom = waitElementToBePresent(xPathScoreTable + "/tr[" + i + "]/td[1]//input").getValue();
			String _scoreTo = waitElementToBePresent(xPathScoreTable + "/tr[" + i + "]/td[2]//input").getValue();
			int intScoreFrom = 0;
			int intScoreTo = 0;

			try {
				intScoreFrom = Integer.parseInt(_scoreFrom);
				intScoreTo = Integer.parseInt(_scoreTo);
			} catch (Exception e) {
				System.out.println(
						" ERROR  Recheck input values for From Year = " + _scoreFrom + " or To Year = " + _scoreTo);
			}

			if ((scoreFrom >= intScoreFrom && scoreFrom <= intScoreTo)
					|| (scoreTo >= intScoreFrom && scoreTo <= intScoreTo)) {
				scoreRowindex = i;
			}
		}
		return scoreRowindex;
	}

	public void check_choose_grade(String fromYear, String toYear, int scoreFrom, int scoreTo, int rowindex) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table/td[1]/div[contains(@id,'scoreTable')]//table";

		String xPathChooseGrade = xPathScoreTable + "//td[4]/span";
		checkChkbox(xPathChooseGrade);

	}

	public void uncheck_choose_grade(String fromYear, String toYear, int scoreFrom, int scoreTo, int rowindex) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table/td[1]/div[contains(@id,'scoreTable')]//table";

		String xPathChooseGrade = xPathScoreTable + "//td[4]/span";
		if (!(($(xPathChooseGrade + "/parent::div/preceding-sibling::div/input")
				.getAttribute("aria-checked")) == "true")) {
			uncheckChkbox(xPathChooseGrade);
		}

	}

	public void enter_grade(int rowindex, String value) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[1]/div[contains(@id,'scoreTable')]//table";
		String xPath = xPathScoreTable + "/tbody/tr[last()]/td[3]/input";
		waitElementToBePresent(xPath).typeAndEnter(value);

		waitForAllJSCompletes();
		assertThat(waitElementToBePresent(xPath).getValue()).isEqualTo(value);

	}

	public void enter_score_from(int rowindex, String value) {
		waitForAllJSCompletes();
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[1]/div[contains(@id,'scoreTable')]//table";
		String xPath = xPathScoreTable + "/tbody/tr[last()]/td[1]/input";

		waitElementToBePresent(xPath).typeAndEnter(value);
		waitForAllJSCompletes();
		assertThat(waitElementToBePresent(xPath).getValue()).isEqualTo(value);
	}

	public void enter_score_to(int rowindex, String value) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[1]/div[contains(@id,'scoreTable')]//table";
		String xPath = xPathScoreTable + "/tbody/tr[last()]/td[2]/input";
		waitTypeAndEnter(xPath, value);
		waitForAllJSCompletes();
		assertThat(waitElementToBePresent(xPath).getValue()).isEqualTo(value);
	}

	public void check_score_range_all(String fromYear, String toYear, int rowindex) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[1]/div[contains(@id,'scoreTable')]//table";
		String xPath = xPathScoreTable + "/thead//th[4]//span[contains(@class,'ui-chkbox-icon')]";
		clickOnElement(xPath);

	}

	public boolean is_disabled_score_range_all(String fromYear, String toYear, int rowindex) {

		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[1]/div[contains(@id,'scoreTable')]//table";
		String xPath = xPathScoreTable + "/thead//th[4]//span[contains(@class,'ui-chkbox-icon')]";
		return waitElementToBePresent(xPath + "/parent::div").getAttribute("class").contains("disabled");
	}

	public void uncheck_score_range_all(String fromYear, String toYear, int rowindex) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[1]/div[contains(@id,'scoreTable')]//table";
		String xPath = xPathScoreTable + "/thead//th[4]//span[contains(@class,'ui-chkbox-icon')]";
		if ($(xPath + "/parent::div/preceding-sibling::div/input").getAttribute("aria-checked") == "true") {
			clickOnElement(xPath);
		} else {
			check_score_range_all(fromYear, toYear, rowindex);
			clickOnElement(xPath);
		}

	}

	// REVIEW TYPE

	public void click_btn_new_review_type(int rowindex) {
		String xPath = "//tbody/tr[" + rowindex + "]" + xPathBtnNew + "/button[contains(@id,'typeTable')]";
		waitElementToBePresent(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void click_btn_delete_review_type(String fromYear, String toYear, int rowindex) {
		waitForAllJSCompletes();
		String xPath = "//tbody/tr[" + rowindex + "]" + xPathBtnDelete + "/button[contains(@id,'typeTable')]";
		waitElementToBePresent(xPath).waitUntilClickable().click();
	}

	public void Enter(String _xPath) {
		waitElementToBePresentThenScrollIntoView(
				_xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]")
						.waitUntilEnabled().waitUntilVisible().sendKeys(Keys.ENTER);

		waitForAllJSCompletes();
	}

	public void enter_review_type(String value, int rowindex) {
		String xPathReviewTable = "//tbody/tr[" + rowindex + "]//table//td[2]/div[contains(@id,'typeTable')]//table";
		String xPath = xPathReviewTable + "/tbody/tr[last()]/td[1]//input";
		waitElementToBePresent(xPath).type(value);
		waitForAllJSCompletes();
		Enter(xPath);
		waitABit(2000);
		waitForAllJSCompletes();
		System.out.println("value2" + waitElementToBePresent(xPath).getValue());
		assertThat(waitElementToBePresent(xPath).getValue()).isEqualTo(value);
	}

	public void check_choose_review_type(String fromYear, String toYear, int rowindex) {
		String xPathReviewTable = "//tbody/tr[" + rowindex + "]//table//td[2]/div[contains(@id,'typeTable')]//table";
		String xPath = xPathReviewTable + "/tbody/tr[last()]/td[2]/span[contains(@class,'ui-chkbox-icon')]";
		checkChkbox(xPath);
	}

	public void uncheck_choose_review_type(String fromYear, String toYear, int rowindex) {
		String xPathReviewTable = "//tbody/tr[" + rowindex + "]//table//td[2]/div[contains(@id,'typeTable')]//table";
		String xPath = xPathReviewTable + "/tbody/tr[last()]/td[2]/span[contains(@class,'ui-chkbox-icon')]";
		clickOnElement(xPath);
	}

	public void check_review_type_all(String fromYear, String toYear, int rowindex) {
		String xPathReviewTable = "//tbody/tr[" + rowindex + "]//table//td[2]/div[contains(@id,'typeTable')]//table";
		String xPath = xPathReviewTable + "/thead//th[2]//span[contains(@class,'ui-chkbox-icon')]";
		clickOnElement(xPath);
	}

	public void uncheck_review_type_all(String fromYear, String toYear, int rowindex) {
		String xPathReviewTable = "//tbody/tr[" + rowindex + "]//table//td[2]/div[contains(@id,'typeTable')]//table";
		String xPath = xPathReviewTable + "/thead//th[2]//span[contains(@class,'ui-chkbox-icon')]";
		clickOnElement(xPath);
	}

	public boolean is_disabled_review_type_all(String fromYear, String toYear, int rowindex) {
		String xPathScoreTable = "//tbody/tr[" + rowindex + "]//table//td[2]/div[contains(@id,'typeTable')]//table";
		String xPath = xPathScoreTable + "/thead//th[2]//span[contains(@class,'ui-chkbox-icon')]";
		return waitElementToBePresent(xPath + "/parent::div").getAttribute("class").contains("disabled");
	}

	public void confirm_yes() {
		waitForAllJSCompletes();
		chooseYesOnUpdateConfirmation();

	}

}
