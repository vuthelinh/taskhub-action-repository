package com.synergix.processing.bankbook.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class BKRevaluationPage extends TH5PageObject {

	public BKRevaluationPage(WebDriver driver) {
		super(driver);
	}

	public void typeRevaluationVoucherDate(String revaluationVoucherDate) {
		enterInputFieldWithLabel("Revaluation Voucher Date",
				revaluationVoucherDate);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeExchangeRate(String exchangeRate) {
		enterInputFieldWithLabelNoVerify("Exchange Rate", exchangeRate);
	}

	public void typeDescription(String description) {
		enterTextAreaWithLabel("Description", description);
	}

	public void searchGLAccount(String gLAccountCode) {
		getResultSearch("GL Account Code", gLAccountCode);
	}

}
