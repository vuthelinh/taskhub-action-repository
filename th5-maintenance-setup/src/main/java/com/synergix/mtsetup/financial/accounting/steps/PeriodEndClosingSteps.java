package com.synergix.mtsetup.financial.accounting.steps;

import com.synergix.mtsetup.financial.accounting.pages.PeriodEndClosingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PeriodEndClosingSteps extends ScenarioSteps {

	PeriodEndClosingPage periodEndClosingPage;

	public void switchToIFrame() {
		periodEndClosingPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		periodEndClosingPage.switchOutDefaultIFrame();
	}

	@Step
	public void click_btn_close() {
		periodEndClosingPage.click_btn_close();
	}

	@Step
	public void click_btn_submit() {
		periodEndClosingPage.click_btn_submit();
	}

	@Step
	public void submit_period_end_closing() {
		periodEndClosingPage.submit_period_end_closing();
	}

	@Step
	public int get_row_by_module_code(String _lineItemNo) {
		return periodEndClosingPage.get_row_by_module_code(_lineItemNo);
	}

	@Step
	public void select_module_code(int _rowIndex, String _value) {
		periodEndClosingPage.select_module_code(_rowIndex, _value);
	}

	@Step
	public void click_btn_yes_on_confirm_submit() {
		periodEndClosingPage.click_btn_yes_on_confirm_submit();
	}

	@Step
	public void click_btn_no_on_confirm_submit() {
		periodEndClosingPage.click_btn_no_on_confirm_submit();
	}

}
