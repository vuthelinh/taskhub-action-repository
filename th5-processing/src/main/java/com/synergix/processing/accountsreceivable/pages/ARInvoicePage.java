package com.synergix.processing.accountsreceivable.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ARInvoicePage extends TH5PageObject {
	private static final String PAYMENT_TERM_TENOR = "Payment Term Tenor";

	public ARInvoicePage(WebDriver driver) {
		super(driver);
	}

	public void type_Customer(String customer) {
		enterInputFieldCodeWithLabel("Customer", customer);
	}

	public void type_InvoiceDate(String invoiceDate) {
		enterInputFieldWithLabel("Invoice Date", invoiceDate);
	}

	public void type_RefNo(String refNo) {
		enterInputFieldWithLabel("Ref No.", refNo);
	}

	public void type_Currency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void type_salesPerson(String salesPerson) {
		enterInputFieldCodeWithLabel("Sales Person", salesPerson);
	}

	public void type_defaultSalesTax(String defaultSalesTax) {
		enterInputFieldCodeWithLabel("Default Sales Tax", defaultSalesTax);
	}

	public void type_customerPONo(String customerPONo) {
		enterInputFieldWithLabel("Customer PO No.", customerPONo);
	}

	public void type_defaultDisc(String defaultDisc) {
		enterInputFieldWithLabelNoVerify("Default Disc %", defaultDisc);
	}

	public void type_location(String location) {
		enterInputFieldCodeWithLabel("Location", location);
	}

	public void search(String invNo) {
		filterDataByHeader(
				"//table[contains(@id ,'arInvNewHdrTable')]//descendant::th[2]",
				invNo);
	}

	// add LI

	private String xBillingTb = "//table[contains(@id, 'lineItemsTable') and child::thead]";

	public void select_Type(String type, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//select", type.toUpperCase());
		waitForAllJSCompletes();
	}

	public void type_ItemCode(String itemCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb,
				"Item Code/Remarks Description");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input", itemCode);
		waitForAllJSCompletes();
	}

	public void type_QtyUOM(String qtyUOM, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Qty UOM");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input", qtyUOM);
		waitForAllJSCompletes();
	}

	public void select_NoOfPacksPackSize(String noOfPacksPackSize, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "No. Of Packs Pack Size");
		selectDdlByText(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//select", noOfPacksPackSize);
		waitForAllJSCompletes();
	}

	public void type_unitPricePriceType(String unitPricePriceType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Unit Price Price Type");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input", unitPricePriceType);
		waitForAllJSCompletes();
	}

	public void type_disc(String disc, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Disc % Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input[1]", disc);
		waitForAllJSCompletes();
	}

	public void type_amount(String amount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Disc % Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input[2]", amount);
		waitForAllJSCompletes();
	}

	public void type_salesTax(String salesTax, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Sales Tax");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input", salesTax);
		waitForAllJSCompletes();
	}

	public void type_serialNo(String serialNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Serial No");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(xBillingTb, rowIndex, colIndex)
						+ "//input", serialNo);
		waitForAllJSCompletes();
	}

	public void check_Delete(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Serial No") + 2;
		clickOnElement("((" + xBillingTb
				+ "/tbody/tr/td[contains(@class,'rich-table-cell')]["
				+ colIndex + "])[" + rowIndex + "]//input)");
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void clickOnDeletetext(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xBillingTb, "Serial No") + 1;
		clickOnElement("((" + xBillingTb
				+ "/tbody/tr/td[contains(@class,'rich-table-cell')]["
				+ colIndex + "])[" + rowIndex + "]//a[@href])");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void clickINv(String invNo) {
		clickOnElement("//table[contains(@id,'arInvNewHdrTable')]//descendant::a[text()='"
				+ invNo + "']");
	}

	public void select_in_payment_option(String paymentOption) {
		selectDdlWithLabelByText("Payment Option", paymentOption);
	}

	public void select_in_payment_term(String paymentTerm) {
		selectDdlWithLabelByText("Payment Term", paymentTerm);
	}

	public void select_in_payment_method(String paymentTerm) {
		selectDdlWithLabelByText("Payment Method", paymentTerm);
	}

	public void enter_payment_term_tenor(String paymentTermTenor) {
		enterInputFieldWithLabel(PAYMENT_TERM_TENOR,
				paymentTermTenor.toUpperCase(), 1);
	}

	public void enter_payment_term_tenor_code(String paymentTermTenorCode) {
		enterInputFieldWithLabel(PAYMENT_TERM_TENOR, paymentTermTenorCode, 2);
	}

	public void enter_billingParty(String billingParty) {
		enterInputFieldWithLabel("Billing Party", billingParty);
	}

	public void enter_billing_address(String billingAddress) {
		enterInputFieldCodeWithLabel("Billing Address", billingAddress);

	}

	public void enter_billing_contact(String billingContact) {
		enterInputFieldCodeWithLabel("Billing Contact", billingContact);
	}

	public void getInvoiceNo(String ssARInv) {
		String invNo = getTextValueWithLabel("Invoice No.", 2);
		setDataToNewSession(invNo, ssARInv);
	}
}
