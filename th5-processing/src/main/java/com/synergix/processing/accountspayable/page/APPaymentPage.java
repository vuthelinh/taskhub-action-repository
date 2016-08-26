package com.synergix.processing.accountspayable.page;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APPaymentPage extends TH5PageObject {

	public APPaymentPage(WebDriver driver) {
		super(driver);
	}

	private String xParentDrafTb = "//table[contains(@id, 'apPayNewHdrsTable')]";

	public void typeSupplier(String supplier) {
		enterInputFieldCodeWithLabel("Supplier", supplier);
	}

	public void typePaymentVoucherDate(String paymentVoucherDate) {
		enterInputFieldWithLabel("Payment Voucher Date", paymentVoucherDate);
	}

	public void typeChequeDate(String chequeDate) {
		enterInputFieldWithLabel("Cheque Date", chequeDate);
	}

	public void typeChequeNo(String chequeNo) {
		enterInputFieldWithLabel("Cheque No.", chequeNo);
	}

	public void typeBankDraftNo(String bankDraftNo) {
		enterInputFieldWithLabel("Bank Draft No", bankDraftNo);
	}

	public void choosePayeeName(String payeeName) {
		enterInputFieldWithLabel("Payee Name", payeeName);
	}

	public void chooseExchangeRate(String exchangeRate) {
		enterInputFieldWithLabelNoVerify("Exchange Rate", exchangeRate);
	}

	public void typeChequeAmount(String chequeAmount) {
		enterInputFieldWithLabelNoVerify("Cheque Amount", chequeAmount);
	}

	public void typeRefNo(String refNo) {
		enterInputFieldWithLabel("Ref No.", refNo);
	}

	public boolean searchPaymentVch(String xParentTb,
			String paymentVoucherNumber) {
		// int colIndex=getTbColHeaderIndex(xParentTb,"Pymt Vch No");
		waitTypeAndEnter(xPathTbHeaderCell(xParentTb, "Pymt Vch No")
				+ "//input", paymentVoucherNumber);
		String xRowSelect = xParentTb
				+ "//td[2 and descendant-or-self::a[@href and text()='"
				+ paymentVoucherNumber + "']]//a[@href]";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

	// ========================================
	// =========== APPLICATION ================

	private String xParentApplication = "//table[contains(@id, 'aplToInvTable')]";

	public int typeInvNo(String invNo, String supInvNo) {
		waitTypeAndEnter(
				xPathTbHeaderCell(xParentApplication, "Inv No. Sup Inv No")
						+ "//input", supInvNo);
		String xRowSelect = xParentApplication
				+ "/tbody/tr[child::td[1 and descendant::*[text()='" + invNo
				+ "']]]";
		if (findAll(xRowSelect).size() > 0)
			return getTbRowIndexOfDataCell(xRowSelect);
		else
			return 0;
	}

	public void typeInvDueDate(String invDueDate) {
	}

	public void typeSupInvDate(String supInvDate) {
	}

	public void typeAgeDate(String ageDate) {
	}

	public void typeChqAmtHomeAmt(String chqAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentApplication,
				"Chq Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentApplication, rowIndex,
						colIndex) + "//input", chqAmtHomeAmt);
	}

	public void typeInvAmtHomeAmt(String invAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentApplication,
				"Inv Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentApplication, rowIndex,
						colIndex) + "//input", invAmtHomeAmt);
	}

	public void typeCrossRateRealizedExch(String crossRateRealizedExch,
			int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentApplication,
				"Cross Rate Realized Exch");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentApplication, rowIndex,
						colIndex) + "//input", crossRateRealizedExch);
	}

	public void chooseApplyFull(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentApplication, "Apply Full");
		clickOnElement(xPathTbDataCellByPosition(xParentApplication, rowIndex,
				colIndex) + "//a[@href]");
	}

	public void typeAmtToPayInInvCcy(String amtToPayInInvCcy, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentApplication,
				"Amt to Pay in Inv Ccy Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentApplication, rowIndex,
						colIndex) + "//input", amtToPayInInvCcy);

	}

	public void typeApplicationDate(String applicationDate) {
		enterInputFieldWithLabel("Application Date", applicationDate);
	}

	public void getPaymentVchNo(String ssPymNo) {
		String vchNo = getTextValueWithLabel("Payment Voucher Number", 2);
		List<String> list = new ArrayList<>();
		list.add(vchNo);
		Serenity.setSessionVariable(ssPymNo).to(list);
	}
}
