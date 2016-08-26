package com.synergix.processing.accountspayable.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APInvoicePage extends TH5PageObject {

	public APInvoicePage(WebDriver driver) {
		super(driver);
	}

	public String xParentDetailTb = "//table[@id='lineItemsForm:lineItemsTable']";

	public void typeSupplier(String supplier) {
		enterInputFieldCodeWithLabel("Supplier", supplier);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typePostingDate(String postingDate) {
		enterInputFieldWithLabel("Posting Date", postingDate);
	}

	public void typeSupplierInvoiceNo(String supplierInvoiceNo) {
		enterInputFieldWithLabel("Supplier Invoice No.", supplierInvoiceNo);
	}

	public void typeDiscDate(String discDate) {
		enterInputFieldWithLabel("Disc Date", discDate);
	}

	public void typeSupplierDONo(String supplierDONo) {
		enterInputFieldWithLabel("Supplier DO No.", supplierDONo);
	}

	public void typeBillOfLadingNo(String billOfLadingNo) {
		enterInputFieldWithLabel("Bill Of Lading No.", billOfLadingNo);
	}

	public void chooseCustomTaxInvoice(String customTaxInvoice) {
		selectRadioButton("Custom Tax Invoice", customTaxInvoice);
	}

	public void typeSalesTax(String salesTax) {
		enterInputFieldCodeWithLabel("Sales Tax", salesTax);
	}

	public void typeDueDate(String dueDate) {
		enterInputFieldWithLabel("Due Date", dueDate);
	}

	public void typeSupplierInvoiceDate(String supplierInvoiceDate) {
		enterInputFieldWithLabel("Supplier Invoice Date", supplierInvoiceDate);
	}

	public void typeDefaultDiscount(String defaultDiscount) {
		enterInputFieldWithLabel("Default Discount %", defaultDiscount);
	}

	public void typeSupplierDODate(String supplierDODate) {
		enterInputFieldWithLabel("Supplier DO Date", supplierDODate);
	}

	public void typeImportPermitNo(String importPermitNo) {
		enterInputFieldWithLabel("Import Permit No.", importPermitNo);
	}

	public void typeReferenceNo(String referenceNo) {
		enterInputFieldWithLabel("Reference No.", referenceNo);
	}

	public void typeInventoryLocation(String inventoryLocation) {
		enterInputFieldCodeWithLabel("Inventory Location", inventoryLocation);
	}

	public boolean searchVchNo(String voucherNo) {
		filterDataByHeader(xPathTbHeaderCell("Voucher No."), voucherNo);
		String xRowSelect = "//table[contains(@id, 'InvNewHdrTable') and child::thead]/tbody/tr/td[2]//*[text()='"
				+ voucherNo + "' and @href]";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

	// ======= DETAIL HEADER TAB ===========
	public void chooseType(String type, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//select", type);
	}

	public void typeItemCodeRemarks(String itemCodeRemarks, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Item Code Remarks");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//input", itemCodeRemarks);
	}

	public void typeQtyUOM(String qtyUOM, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Qty UOM");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//input", qtyUOM);
	}

	public void choosePackSize(String packSize, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Pack Size");
		selectDdlByText(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//select", packSize);
	}

	public void typeCostType(String costType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Cost Type");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//input", costType);
	}

	public void typeDiscount(String discount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Discount");
		waitTypeAndEnter(
				"("
						+ xPathTbDataCellByPosition(xParentDetailTb, rowIndex,
								colIndex) + "//input)[1]", discount);
	}

	public void typeTotalAmt(String totalAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Total Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//input", totalAmt);
	}

	public void typeSalesTax(String salesTax, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentDetailTb, "Sales Tax");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentDetailTb, rowIndex, colIndex)
						+ "//input", salesTax);
	}

	public int countRowDetail() {
		return getTbCountDataRow(xParentDetailTb);
	}

	// ======= PAYMENT INFORMATION TAB ===========
	public void choosePaymentOption(String paymentOption) {
		selectDdlWithLabelByText("Payment Option", paymentOption);
	}

	public void choosePaymentTerm(String paymentTerm) {
		selectDdlWithLabelByText("Payment Term", paymentTerm);
	}

	public void typePaymentTermTenor(String paymentTermTenor) {
		if (paymentTermTenor.contains(">")) {
			String[] listInfo = paymentTermTenor.split(">");
			if (!listInfo[0].isEmpty())
				enterInputFieldWithLabel("Payment Term Tenor",
						listInfo[0].trim(), 1);
			if (!listInfo[1].isEmpty())
				enterInputFieldWithLabel("Payment Term Tenor", listInfo[1]
						.trim().toUpperCase(), 2);
		} else {
			enterInputFieldWithLabel("Payment Term Tenor", paymentTermTenor, 1);
		}
	}

	public void choosePaymentMethod(String paymentMethod) {
		selectDdlWithLabelByText("Payment Method", paymentMethod);
	}

	public void typePaymentAmount(String paymentAmount) {
		enterInputFieldWithLabel("Payment Amount", paymentAmount);
	}

	public void typePaymentParty(String paymentParty) {
		enterInputFieldWithLabel("Payment Party", paymentParty);
	}

	public void typePaymentAddress(String paymentAddress) {
		enterInputFieldCodeWithLabel("Payment Address", paymentAddress);
	}

	public void typePaymentContact(String paymentContact) {
		enterInputFieldCodeWithLabel("Payment Contact", paymentContact);
	}

	public void chooseDelDetailRow(int rowIndex) {
		String xDelRowSelect = xParentDetailTb + "/tbody/tr[" + rowIndex
				+ "]//*[@href and text()='delete']";
		if (isElementExist(xDelRowSelect)) {
			clickOnElement(xDelRowSelect);
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public void chooseDelAllDetailRow() {
		if (findAll(xParentDetailTb).size() > 0) {
			int countRow = getTbCountDataRow(xParentDetailTb);
			for (int i = 1; i <= countRow; i++) {
				chooseDelDetailRow(i);
			}
		}
	}

	public void getAPInvoiceNo(String ssAPInvNo) {
		String invNo = getTextValueWithLabel("Voucher No.", 2);
		System.out.println("INVOICE NO:" + invNo);
		setDataToSession(invNo, ssAPInvNo);
	}
}
