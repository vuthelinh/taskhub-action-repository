package com.synergix.processing.bankbook.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class BKReconciliationVchPage extends TH5PageObject {

	public BKReconciliationVchPage(WebDriver driver) {
		super(driver);
	}

	public void typeReconciliationVoucherDate(String reconciliationVoucherDate) {
		enterInputFieldWithLabel("Reconciliation Voucher Date",
				reconciliationVoucherDate);
	}

	public void typeBankStatementNo(String bankStatementNo) {
		enterInputFieldWithLabel("Bank Statement No", bankStatementNo);
	}

	public void typeBankStatementAmount(String bankStatementAmount) {
		enterInputFieldWithLabelNoVerify("Bank Statement Amount",
				bankStatementAmount);
	}

	public void typeBankStatementDate(String bankStatementDate) {
		enterInputFieldWithLabel("Bank Statement Date", bankStatementDate);
	}

	String xSourceVchNoTb = "//table[contains(@id, 'draftLineItemsTable')]";

	public void typeSourceVoucherNo(String sourceVoucherNo) {
		waitTypeAndEnter(
				xPathTbHeaderCell(xSourceVchNoTb, "Source Voucher No."),
				sourceVoucherNo);
		waitForAllJSCompletes();
	}

	public void typeType(String type) {
		waitTypeAndEnter(xPathTbHeaderCell(xSourceVchNoTb, "Type"), type);
		waitForAllJSCompletes();
	}

	public void typeChequeNo(String chequeNo) {
		waitTypeAndEnter(xPathTbHeaderCell(xSourceVchNoTb, "Cheque No"),
				chequeNo);
		waitForAllJSCompletes();
	}

	public void typeSourceVoucherDocNo(String sourceVoucherDocNo) {
		waitTypeAndEnter(
				xPathTbHeaderCell(xSourceVchNoTb, "Source Voucher Doc No"),
				sourceVoucherDocNo);
		waitForAllJSCompletes();
	}

	public void chooseSourceVchNo(int rowIndex) {
		String xRowSelect = xSourceVchNoTb
				+ "/tbody/tr[1]/td[2]//input[@type='checkbox']";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
		}
	}

	public void chooseAllSourceVchNo() {
		String xRowSelect = xSourceVchNoTb
				+ "/thead//th[2]//input[@type='checkbox']";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
		}
	}
}
