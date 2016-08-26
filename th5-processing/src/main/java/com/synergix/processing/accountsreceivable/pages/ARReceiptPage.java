package com.synergix.processing.accountsreceivable.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ARReceiptPage extends TH5PageObject {
	public ARReceiptPage(WebDriver driver) {
		super(driver);
	}

	String xDrafTb = "//table[contains(@id, 'arRecNewHdrTable') and child::thead]";
	String xOutstandingTb = "//table[contains(@id, 'arRecOstHdrTable') and child::thead]";
	String xHistoryTb = "//table[contains(@id, 'arRecHstHdrTable') and child::thead]";
	String xPaymentDetailTb = "//div[descendant::*[text()='Payment Detail']]//table[child::thead]";
	String xApplicationInvTb = "//table[contains(@id, 'arInvOstHdrAplTable') and child::thead]";

	public int countRowTb(String xParentTb) {
		return findAll(xParentTb + "/tbody/tr[@class]").size();
	}

	public void typeCustomer(String customer) {
		enterInputFieldCodeWithLabel("Customer", customer);
	}

	public void typeReceiptDate(String receiptDate) {
		enterInputFieldWithLabel("Receipt Date", receiptDate);
	}

	public void typeReceiptCurrency(String receiptCurrency) {
		enterInputFieldCodeWithLabel("Receipt Currency", receiptCurrency);
	}

	public void typeExchangeRate(String exchangeRate) {
		enterInputFieldWithLabelNoVerify("Exchange Rate", exchangeRate);
	}

	public void typeReferenceNo(String referenceNo) {
		enterInputFieldWithLabel("Reference No.", referenceNo);
	}

	public void typeBankDraftNo(String bankDraftNo) {
		enterInputFieldWithLabel("Bank Draft No", bankDraftNo);
	}

	public void typeDepositSlipNo(String depositSlipNo) {
		enterInputFieldWithLabel("Deposit Slip No", depositSlipNo);
	}

	// ====================== Payment Detail ========================

	public void searchBankAccount(int rowIndex, String bankPartyCode,
			String bankAccountNo) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb, "Bank Name");
		clickOnElement(xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex,
				colIndex) + "//img");
		waitForAllJSCompletes();

		searchBankAccount(bankPartyCode, bankAccountNo);
	}

	public void choosePymtMethod(String pymtMethod, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb, "Pymt Method");
		selectDdlByText(
				xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex, colIndex)
						+ "//select", pymtMethod);
		waitForAllJSCompletes();
	}

	public void typeChequeNo(String chequeNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb,
				"Cheque No. Cheque Date");
		waitTypeAndEnter(
				xPathTbDataCellByPosition("(" + xPaymentDetailTb, rowIndex,
						colIndex) + "//input)[1]", chequeNo);
	}

	public void typeChequeDate(String chequeDate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb,
				"Cheque No. Cheque Date");
		waitTypeAndEnter(
				xPathTbDataCellByPosition("(" + xPaymentDetailTb, rowIndex,
						colIndex) + "//input)[2]", chequeDate);
	}

	public void typeCustomerBank(String customerBank, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb, "Customer Bank");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex, colIndex)
						+ "//input", customerBank);
	}

	public void chooseCardType(String cardType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb, "Card Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex, colIndex)
						+ "//select", cardType);
		waitForAllJSCompletes();
	}

	public void chooseInstmtCodeInstmtDesc(String instmtCodeInstmtDesc,
			int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb,
				"Instmt Code Instmt Desc");
		selectDdlByText(
				xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex, colIndex)
						+ "//select", instmtCodeInstmtDesc);
		waitForAllJSCompletes();
	}

	public void typePymtAmt(String pymtAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb, "Pymt Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex, colIndex)
						+ "//input", pymtAmt);
	}

	public void typeTenderedAmt(String tenderedAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xPaymentDetailTb, "Tendered Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xPaymentDetailTb, rowIndex, colIndex)
						+ "//input", tenderedAmt);
	}

	// =============== APPLICATION TAB ==========
	public void typedCrnAmtHomeAmt(String dCrnAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xApplicationInvTb,
				"d Rec Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xApplicationInvTb, rowIndex, colIndex)
						+ "//input", dCrnAmtHomeAmt);
	}

	public void typedInvAmtHomeAmt(String dInvAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xApplicationInvTb,
				"d Inv Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xApplicationInvTb, rowIndex, colIndex)
						+ "//input", dInvAmtHomeAmt);
	}

	public void typeApplyFull(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xApplicationInvTb, "Apply Full");
		clickOnElement(xPathTbDataCellByPosition(xApplicationInvTb, rowIndex,
				colIndex) + "//a[@href]");
		waitForAllJSCompletes();
	}

	public boolean searchReceiptNoApplied(String invNo) {
		if (invNo.isEmpty()) {
			String xRowSelect = xApplicationInvTb + "/tbody/tr[@class] ";
			if (findAll(xRowSelect).size() > 0)
				return true;
			else
				return false;
		} else {
			int colIndex = getTbColHeaderIndex(xApplicationInvTb, "Inv No.");
			waitTypeAndEnter(
					"(" + xPathTbHeaderCell(xApplicationInvTb, "Inv No.")
							+ "//input[@type='text'])[" + 1 + "]", invNo);

			String xRowSelect = xApplicationInvTb + "/tbody/tr[child::td["
					+ colIndex + " and descendant-or-self::*[text()='"
					+ invNo.toUpperCase() + "']]]//a[@href]";
			if (findAll(xRowSelect).size() > 0)
				return true;
			else
				return false;
		}
	}

	public void getInvoiceNo(String ssCrnInv) {
		String invNo = getTextValueWithLabel("Receipt No", 2);
		setDataToNewSession(invNo, ssCrnInv);
	}

	public void clickOnPreviewHST(String invNo, String reportName) {
		clickPreviewHST(xHistoryTb, "Receipt No", invNo, reportName);
	}

	public boolean searchOstCrnNo(String invNo) {
		return searchByFilter(xOutstandingTb, "Receipt No", invNo);
	}

	public void typeApplicationDate(String applicationDate) {
		enterInputFieldCodeWithLabel("Application Date", applicationDate);
	}
}
