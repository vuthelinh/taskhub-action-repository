package com.synergix.globalsetup.salespurchase.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160121
 */
public class PaymentTenorTermPage extends TH5PageObject {
	public PaymentTenorTermPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Payment Tenor Term";
	private static final String xPathPanelPaymentTenorTerm = "//div[text()='Global Payment Tenor Term']//ancestor::form[1]";

	public void click_btn_new() {
		clickBtn(xPathPanelPaymentTenorTerm, "New");
	}

	public void click_btn_delete() {
		clickBtn(xPathPanelPaymentTenorTerm, "Delete");
	}

	public void click_btn_close() {
		clickBtn(xPathPanelPaymentTenorTerm, "Close");
	}

	public void click_btn_update() {
		clickBtn(xPathPanelPaymentTenorTerm, "Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public void enter_payment_tenor_term_code(String _paymentTenorTermCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathInputFieldWithLabel(xPathPanelPaymentTenorTerm, "Payment Tenor Term Code"), _paymentTenorTermCode);
	}

	public void enter_description(String _description) {
		enterInputFieldWithLabel("Description", _description);
	}

	// Tag company
	private String xPathTbCompanyTag = "(" + xPathPanelPaymentTenorTerm
			+ "//table[contains(@id, 'tblCompanyList')])[1]";

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}
}
