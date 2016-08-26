package com.synergix.processing.accountsreceivable.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ARCreditNotePage extends TH5PageObject {
	public ARCreditNotePage(WebDriver driver) {
		super(driver);
	}

	String xDrafTb = "//table[contains(@id, 'arCrnNewHdrTable') and child::thead]";
	String xOutstandingTb = "//table[contains(@id, 'arCrnOstHdrTable') and child::thead]";
	String xHistoryTb = "//table[contains(@id, 'arCrnHstHdrTable') and child::thead]";
	String xBillingDetailTb = "//table[contains(@id, 'lineItemsTable') and child::thead]";
	String xApplicationInvTb = "//table[contains(@id, 'arInvOstHdrAplTable') and child::thead]";

	public void typeCustomer(String customer) {
		enterInputFieldCodeWithLabel("Customer", customer);
	}

	public void typeCreditNoteDate(String creditNoteDate) {
		enterInputFieldWithLabel("Credit Note Date", creditNoteDate);
	}

	public void typeRefNo(String refNo) {
		enterInputFieldWithLabel("Ref No.", refNo);
	}

	public void typeCustomerPONo(String customerPONo) {
		enterInputFieldWithLabel("Customer PO No.", customerPONo);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeDefaultSalesTax(String defaultSalesTax) {
		enterInputFieldCodeWithLabel("Default Sales Tax", defaultSalesTax);
	}

	public void choosePaymentOption(String paymentOption) {
		selectDdlWithLabelByText("Payment Option", paymentOption);
	}

	public void typeBillingContact(String billingContact) {
		enterInputFieldCodeWithLabel("Billing Contact", billingContact);
	}

	public void typeDefaultDisc(String defaultDisc) {
		enterInputFieldWithLabel("Default Disc %", defaultDisc);
	}

	public void typeLocation(String location) {
		enterInputFieldCodeWithLabel("Location", location);
	}

	public void typeSalesPerson(String salesPerson) {
		enterInputFieldCodeWithLabel("Sales Person", salesPerson);
	}

	public void typeBillingAddress(String billingAddress) {
		enterInputFieldCodeWithLabel("Billing Address", billingAddress);
	}

	public void typeCreditNoteCategory(String creditNoteCategory) {
		enterInputFieldCodeWithLabel("Credit Note Category", creditNoteCategory);
	}

	public void typeCreditNoteJustification(String creditNoteJustification) {
		enterTextAreaWithLabel("Credit Note Justification",
				creditNoteJustification);
	}

	public void typeRemarksToCustomer(String remarksToCustomer) {
		enterTextAreaWithLabel("Remarks To Customer", remarksToCustomer);
	}

	public void deleteAllBillingDetail() {
		int rowTb = countRowTb(xBillingDetailTb);

		for (int i = 1; i <= rowTb; i++) {
			String xRowSelect = xBillingDetailTb + "/tbody/tr[" + i
					+ "]//a[@href and text()='Delete']";
			clickOnElement(xRowSelect);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public int countRowTb(String xParentTb) {
		return findAll(xParentTb + "/tbody/tr[@class]").size();
	}

	// ============= BILLING DETAIL =================

	public int countRowBillingTb() {
		return countRowTb(xBillingDetailTb);
	}

	public void chooseType(String type, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb, "Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//select", type);
		waitForAllJSCompletes();
	}

	public void typeItemCode(String itemCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Item Code/Remarks Description");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//input", itemCode);
	}

	public void typeRemarksDescription(String remarksDescription, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Item Code/Remarks Description");
		clickOnElement(xPathTbDataCellByPosition(xBillingDetailTb, rowIndex,
				colIndex) + "//tbody//td[3]//a[@href]");
		waitForAllJSCompletes();
		String xRemarkPopup = "//table[@id='remarksModalPanelContentTable']";
		String xRemark = "//table[@id='remarksModalPanelContentTable']//textarea";
		waitTypeAndEnter(xRemark, remarksDescription);
		clickBtn(xRemarkPopup, "Ok");
		waitForAllJSCompletes();
	}

	public void typeQtyUOM(String qtyUOM, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb, "Qty UOM");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//input", qtyUOM);
	}

	public void choosePackSizeNoOfPacks(String packSizeNoOfPacks, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Pack Size No. Of Packs");
		selectDdlByText(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//select", packSizeNoOfPacks);
	}

	public void typePriceType(String priceType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Price Type Unit Price");
		selectDdlByText(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//select", priceType);
	}

	public void typeUnitPrice(String unitPrice, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Price Type Unit Price");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//input", unitPrice);
	}

	public void typeDiscount(String discount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Discount %/ Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//input[1]", discount);
	}

	public void chooseAmount(String amount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb,
				"Discount %/ Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//input[2]", amount);
	}

	public void typeSalesTax(String salesTax, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingDetailTb, "Sales Tax");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingDetailTb, rowIndex, colIndex)
						+ "//input", salesTax);
	}

	public void chooseDelete(int rowIndex) {
		String xRowSelect = xBillingDetailTb + "/tbody/tr[" + rowIndex
				+ "]//a[@href and text()='Delete']";
		clickOnElement(xRowSelect);
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	// =============== APPLICATION TAB ==========
	public void typedCrnAmtHomeAmt(String dCrnAmtHomeAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xApplicationInvTb,
				"d Crn Amt Home Amt");
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

	public boolean searchInvNoApplied(String invNo) {
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
		String invNo = getTextValueWithLabel("Crn No.", 2);
		setDataToNewSession(invNo, ssCrnInv);
	}

	public void clickOnPreviewHST(String invNo, String reportName) {
		clickPreviewHST(xHistoryTb, "Crn No.", invNo, reportName);
	}

	public boolean searchOstCrnNo(String invNo) {
		return searchByFilter(xOutstandingTb, "Crn No.", invNo);
	}

	public void typeApplicationDate(String applicationDate) {
		enterInputFieldCodeWithLabel("Application Date", applicationDate);
	}

}
