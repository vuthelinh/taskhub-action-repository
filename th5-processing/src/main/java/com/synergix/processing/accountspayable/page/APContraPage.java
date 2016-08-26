package com.synergix.processing.accountspayable.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APContraPage extends TH5PageObject {
	public APContraPage(WebDriver driver) {
		super(driver);
	}

	private String xDrafTb = "//table[contains(@id, 'draftTable') and child::thead]";
	private String xHSTTb = "//table[contains(@id, 'hstTable') and child::thead]";

	public void typeParty(String party) {
		enterInputFieldCodeWithLabel("Party", party);
	}

	public boolean searchDrafVoucherNo(String contraVoucherNo) {
		return searchByFilter(xDrafTb, "Contra Voucher", contraVoucherNo);
	}

	public boolean searchHSTVoucherNo(String contraVoucherNo) {
		return searchByFilter(xHSTTb, "Contra Voucher", contraVoucherNo);
	}

	// =====================================
	// ============= HEADER TAB ============

	public void chooseContraVoucherDate(String contraVoucherDate) {
		enterInputFieldWithLabel("Contra Voucher Date", contraVoucherDate);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeExchRateBuyRate(String exchRateBuyRate) {
		enterInputFieldWithLabelNoVerify("Exch Rate - Buy Rate",
				exchRateBuyRate);
	}

	public void typeExchRateSellRate(String exchRateSellRate) {
		enterInputFieldWithLabelNoVerify("Exch Rate - Sell Rate",
				exchRateSellRate);
	}

	public void typeRemarksCode(String remarksCode) {
		enterInputFieldCodeWithLabel("Remarks Code", remarksCode);
	}

	public void typeRemarks(String remarks) {
		enterTextAreaWithLabel("Remarks", remarks);
	}

	// ====================================================
	// =================== AP INVOICE TAB ==================
	private String xAPInvoiceTb = "//table[@id='apInvForm:AP_INVOICE_TABLE']";

	public int typeAPInvNo(String invNo) {
		if (!invNo.isEmpty()) {

			int colIndex = getTbColHeaderIndex(xAPInvoiceTb,
					"Inv No. Sup Inv No");
			// waitTypeAndEnter(xPathTbHeaderCell(xAPInvoiceTb,
			// "Inv No. Sup Inv No")+ "//input", invNo);
			String xRowSelect = xAPInvoiceTb + "/tbody/tr[child::td["
					+ colIndex + " and descendant-or-self::*[text()='"
					+ invNo.toUpperCase() + "']]]";

			if (findAll(xRowSelect).size() > 0)
				return findAll(xRowSelect + "/preceding-sibling::tr").size() + 1;
			else
				return 0;
		} else {
			int rowIndex = findAll(xAPInvoiceTb + "/tbody/tr[1 and @class]")
					.size();
			if (rowIndex > 0)
				return 1;
			else
				return 0;
		}
	}

	public void typeAgeDate(String ageDate) {
		waitTypeAndEnter(xPathTbHeaderCell(xARInvoiceTb, "Age Date")
				+ "//input", ageDate);
	}

	// ====================================================
	// =================== AR INVOICE TAB ==================

	private String xARInvoiceTb = "//table[@id='arInvForm:AR_INVOICE_TABLE']";

	public int typeARInvoiceNo(String invoiceNo) {
		if (!invoiceNo.isEmpty()) {
			int colIndex = getTbColHeaderIndex(xARInvoiceTb, "Invoice No.");
			waitTypeAndEnter(xPathTbHeaderCell(xARInvoiceTb, "Invoice No.")
					+ "//input", invoiceNo);
			waitForAllJSCompletes();
			String xRowSelect = xARInvoiceTb + "/tbody/tr[child::td["
					+ colIndex + " and descendant-or-self::*[text()='"
					+ invoiceNo.toUpperCase() + "']]]";

			if (findAll(xRowSelect).size() > 0)
				return findAll(xRowSelect + "/preceding-sibling::tr").size() + 1;
			else
				return 0;
		} else {
			int rowIndex = findAll(xARInvoiceTb + "/tbody/tr[1 and @class]")
					.size();
			if (rowIndex > 0)
				return 1;
			else
				return 0;
		}
	}

	public void typeInvoiceDate(String invoiceDate) {
		waitTypeAndEnter(xPathTbHeaderCell(xARInvoiceTb, "Invoice Date")
				+ "//input", invoiceDate);
	}

	public void typeDueDate(String dueDate) {
		waitTypeAndEnter(xPathTbHeaderCell(xARInvoiceTb, "Due Date")
				+ "//input", dueDate);
	}

	public void typeInvCcyRefNo(String xParentTb, String invCcyRefNo) {
		waitTypeAndEnter(xPathTbHeaderCell(xParentTb, "Inv Ccy Ref No.")
				+ "//input", invCcyRefNo);
	}

	public void typedInvAmtHomeAmt(String xParentTb, String dInvAmtHomeAmt,
			int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "d Inv Amt Home Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input", dInvAmtHomeAmt);
		waitForAllJSCompletes();
		waitABit(1000);
	}

	public void chooseApplyFull(String xParentTb, String applyFull, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Apply Full");
		clickOnElement(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
				+ "//a[@href]");
	}

	public void getVchNo(String ssContraVch) {
		String voucherNo = getTextValueWithLabel("Contra Voucher No.", 2);
		setDataToNewSession(voucherNo, ssContraVch);
	}

	public void clickPreviewHSTBtn(String voucherNo, String reportName) {
		clickPreviewHST(xHSTTb, "Contra Voucher", voucherNo, reportName);
	}
}
