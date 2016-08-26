package com.synergix.processing.accountspayable.page;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APPaymentToCustomerPage extends TH5PageObject {

	public APPaymentToCustomerPage(WebDriver driver) {
		super(driver);
	}

	private String xDrafTb = "//table[contains(@id, 'apPayNewHdrsTable')]";
	private String xHistoryTb = "//table[contains(@id, 'apPayNewHdrsTable')]";
	private String xAppToReceiptTb = "//table[child::thead[descendant::th[1 and descendant-or-self::*[text()='Rcpt No']]]]";
	private String xAppToCrnTb = "//table[child::thead[descendant::th[1 and descendant-or-self::*[text()='Crn No']]]]";

	public void typeCustomer(String customer) {
		enterInputFieldCodeWithLabel("Customer", customer);
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

	public void getPaymentVchNo(String ssPymtCusNo) {
		String vchNo = getTextValueWithLabel("Payment Voucher Number", 2);
		List<String> list = new ArrayList<>();
		list.add(vchNo);
		Serenity.setSessionVariable(ssPymtCusNo).to(list);
	}

	public boolean searchDraftPaymentVch(String paymentVoucherNumber) {
		return searchByFilter(xDrafTb, "Pymt Vch No", paymentVoucherNumber);
	}

	public boolean searchHSTPaymentVch(String paymentVoucherNumber) {
		return searchByFilter(xHistoryTb, "Pymt Vch No", paymentVoucherNumber);
	}

	// ======================================
	// ======== APPLICATION TAB =============
	public void typeRcptNo(String rcptNo) {
		waitTypeAndEnter(xPathTbHeaderCell(xAppToReceiptTb, "Rcpt No")
				+ "//input", rcptNo);
	}

	public void typeRcptDate(String rcptDate) {
		waitTypeAndEnter(xPathTbHeaderCell(xAppToReceiptTb, "Rcpt Date")
				+ "//input", rcptDate);
	}

	public void typeCCY(String cCY) {
		waitTypeAndEnter(xPathTbHeaderCell(xAppToReceiptTb, "CCY") + "//input",
				cCY);
	}

	public void typedPymtAmtHomeAmt(String dPymtAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAppToReceiptTb,
				"d Pymt Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAppToReceiptTb, rowIndex, colIndex)
						+ "//input", dPymtAmtHomeAmt);
	}

	public void typedRecAmtHomeAmt(String dRecAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAppToReceiptTb,
				"d Rec Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAppToReceiptTb, rowIndex, colIndex)
						+ "//input", dRecAmtHomeAmt);
	}

	public void typeCrossRateRealizedExch(String crossRateRealizedExch,
			int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAppToReceiptTb,
				"Cross Rate Realized Exch");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAppToReceiptTb, rowIndex, colIndex)
						+ "//input", crossRateRealizedExch);
	}

	public void typeCrnNo(String crnNo) {

		waitTypeAndEnter(xPathTbHeaderCell(xAppToCrnTb, "Crn No") + "//input",
				crnNo);

	}

	public void typeCrnDate(String crnDate) {
		waitTypeAndEnter(
				xPathTbHeaderCell(xAppToCrnTb, "Crn Date") + "//input", crnDate);
	}

	public void typeCrnCcy(String crnCcy) {
		waitTypeAndEnter(xPathTbHeaderCell(xAppToCrnTb, "Crn Ccy") + "//input",
				crnCcy);
	}

	public void typeAppliedChqAmtHomeAmt(String appliedChqAmtHomeAmt,
			int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAppToCrnTb,
				"Applied Chq Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAppToCrnTb, rowIndex, colIndex)
						+ "//input", appliedChqAmtHomeAmt);
	}

	public void typeAppliedCrnAmtHomeAmt(String appliedCrnAmtHomeAmt,
			int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAppToCrnTb,
				"Applied Crn Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAppToCrnTb, rowIndex, colIndex)
						+ "//input", appliedCrnAmtHomeAmt);
	}
}
