package com.synergix.mtsetup.financial.accounting.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class PeriodEndClosingPage extends TH5PageObject {

	public PeriodEndClosingPage(WebDriver driver) {
		super(driver);
	}

	private String xPathTbPeriodEndClosing = "//table[contains(@id,'periodEndCloseTable')]";

	public void click_btn_close() {
		clickBtn("Close");
	}

	public void click_btn_submit() {
		clickBtn("Submit");
	}

	public void submit_period_end_closing() {
		click_btn_submit();
		click_btn_no_on_confirm_submit();
		waitForAllJSCompletes();
		assertThat(getErrorMessagesThenClickOK() == null).isTrue();
	}

	public int get_row_by_module_code(String _lineItemNo) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathTbPeriodEndClosing, _lineItemNo, 1, "Module Code", 1));
	}

	public void select_module_code(int _rowIndex, String _value) {
		setChkbox(xPathTbDataCellByPosition(xPathTbPeriodEndClosing, _rowIndex, 1) + "//input[@type='checkbox']",
				_value);
	}

	private String xPathPanelConfirmSubmit = "//div[" + sSpecialTextPredicates("Submit Period End Closing")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_yes_on_confirm_submit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void click_btn_no_on_confirm_submit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}
}
