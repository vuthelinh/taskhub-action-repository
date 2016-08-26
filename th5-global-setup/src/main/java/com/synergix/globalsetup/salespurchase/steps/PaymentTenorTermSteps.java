package com.synergix.globalsetup.salespurchase.steps;

import com.synergix.globalsetup.salespurchase.page.PaymentTenorTermPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class PaymentTenorTermSteps extends ScenarioSteps {
	PaymentTenorTermPage glPaymentTenorTermPage;

	@Step
	public void click_btn_new() {
		glPaymentTenorTermPage.click_btn_new();
	}

	@Step
	public void click_btn_delete() {
		glPaymentTenorTermPage.click_btn_delete();
	}

	@Step
	public void click_btn_close() {
		glPaymentTenorTermPage.click_btn_close();
	}

	@Step
	public void click_btn_update() {
		glPaymentTenorTermPage.click_btn_update();
	}

	@Step
	public void enter_payment_tenor_term_code(String _paymentTenorTermCode) {
		glPaymentTenorTermPage.enter_payment_tenor_term_code(_paymentTenorTermCode);
	}

	@Step
	public void enter_description(String _description) {
		glPaymentTenorTermPage.enter_description(_description);
	}

	// Tag company
	@Step
	public void tag_company(String _companyName) {
		glPaymentTenorTermPage.chooseCompany(_companyName);
	}
}
