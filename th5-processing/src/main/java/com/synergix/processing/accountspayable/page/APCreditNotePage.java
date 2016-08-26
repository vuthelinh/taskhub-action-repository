package com.synergix.processing.accountspayable.page;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APCreditNotePage extends TH5PageObject {

	public APCreditNotePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public int getTbCountDataRow(String xParentTb) {
		String xPath = xParentTb + "/tbody/tr[@class]";
		return findAll(xPath).size();
	}

	public void getCrnNo(String ssCrnNo) {
		List<String> listCrnNo = new ArrayList<>();
		String crnNo = getTextValueWithLabel("Crn No.", 2);
		listCrnNo.add(crnNo);
		Serenity.setSessionVariable(ssCrnNo).to(listCrnNo);
	}

	public boolean searchCrnNo(String xParentTable, String crnNo) {
		waitTypeAndEnter(xPathTbHeaderCell("Crn No.") + "//input", crnNo);
		waitForAllJSCompletes();
		String xSelectRow = xParentTable
				+ "/tbody/tr/td[2]//a[@href and text()='" + crnNo + "']";
		try {
			clickOnElement(xSelectRow);
			waitForAllJSCompletes();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void typeSupplier(String supplier) {
		enterInputFieldCodeWithLabel("Supplier", supplier);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typePostingDate(String postingDate) {
		enterInputFieldWithLabel("Posting Date", postingDate);
	}

	public void typeSupplierCreditNoteNo(String supplierCreditNoteNo) {
		enterInputFieldWithLabel("Supplier Credit Note No",
				supplierCreditNoteNo);
	}

	public void typeCreditNoteCategory(String creditNoteCategory) {
		enterInputFieldCodeWithLabel("Credit Note Category", creditNoteCategory);
	}

	public void typeSalesTax(String salesTax) {
		enterInputFieldCodeWithLabel("Sales Tax", salesTax);
	}

	public void typeLocation(String location) {
		enterInputFieldCodeWithLabel("Location", location);
	}

	public void typeSupplierCreditNoteDate(String supplierCreditNoteDate) {
		enterInputFieldWithLabel("Supplier Credit Note Date",
				supplierCreditNoteDate);
	}

	public void typeDefaultDisc(String defaultDisc) {
		enterInputFieldWithLabel("Default Disc %", defaultDisc);
	}

	public void typeReferenceNo(String referenceNo) {
		enterInputFieldWithLabel("Reference No.", referenceNo);
	}

	public void typeCreditNoteJustification(String creditNoteJustification) {
		enterTextAreaWithLabel("Credit Note Justification",
				creditNoteJustification);
	}

	// =================== HEADER TAB ====================

	// Detail
	private String xDetailTb = "//table[@id='lineItemsForm:lineItemsTable']";

	public void chooseType(String type, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//select", type);
	}

	public void typeItemCode(String itemCodeRemarks, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb,
				"Item Code/Remarks Description");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input", itemCodeRemarks);
	}

	public void typeRemarks(String remarks, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb,
				"Item Code/Remarks Description");
		clickOnElement("("
				+ xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
				+ "//a[@href and descendant::img])[2]");
		String xRemarksPopUp = "//table[@id='remarksModalPanelContentTable']";
		waitTypeAndEnter(xRemarksPopUp + "//textarea[1]", remarks);
		clickBtn(xRemarksPopUp, "Ok");
		waitForAllJSCompletes();
	}

	public void typeQtyUOM(String qtyUOM, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Qty UOM");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input", qtyUOM);
	}

	public void choosePackSize(String packSize, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Pack Size No. Of Packs");
		selectDdlByText(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//select", packSize);
	}

	public void chooseCostType(String costType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Cost Type Unit Cost");
		selectDdlByText(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//select", costType);
	}

	public void typeUnitCost(String unitCost, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Cost Type Unit Cost");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input", unitCost);
	}

	public void typeDiscount(String discountAmount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Discount %/Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input[1]", discountAmount);
	}

	public void typeAmount(String amount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Discount %/Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input[2]", amount);
	}

	public void typeSalestax(String salestax, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Sales Tax");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex)
						+ "//input", salestax);
	}

	public void chooseSerialNo(String serialNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Serial No");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xDetailTb, rowIndex, colIndex),
				serialNo);
	}

	public void chooseDelete(int rowIndex) {
		String xDelete = xDetailTb + "/tbody/tr[" + rowIndex
				+ "]/td//a[@href and text()='Delete']";
		clickOnElement(xDelete);
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseDel(int rowIndex) {
		String xDelCheckBox = xDetailTb + "//tbody/tr[" + rowIndex
				+ "]/td//input[contains(@id, 'selected') and @type='checkbox']";
		clickOnElement(xDelCheckBox);
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	// ALLOC
	private String xAllocPopup = "//table[@id= 'popupModalPanelContentTable']";
	private String xAllocTb = "//table[@id='allocsForm:allocsTable']";

	public void clickOnAddAllocBtn() {
		clickBtn(xAllocPopup, "Add");
		waitForAllJSCompletes();
	}

	public void chooseLIno(String lIno) {
		try {
			int rowIndex = Integer.parseInt(lIno);
			int colIndex = getTbColHeaderIndex(xDetailTb, "Allocation");
			clickOnElement(xPathTbDataCellByPosition(xDetailTb, rowIndex,
					colIndex));
			waitForAllJSCompletes();
		} catch (Exception ex) {
			System.out.println("***[Error Message]***:" + ex);
		}
	}

	public void typeSegment1(String segment1) {
		enterInputFieldCodeWithLabel(xAllocPopup, "Segment 1", segment1);
	}

	public void typeSegment2(String segment2) {
		enterInputFieldCodeWithLabel(xAllocPopup, "Segment 2", segment2);
	}

	public void typeSegment3(String segment3) {
		enterInputFieldCodeWithLabel(xAllocPopup, "Segment 3", segment3);
	}

	public void typeSegment4(String segment4) {
		enterInputFieldCodeWithLabel(xAllocPopup, "Segment 4", segment4);
	}

	public void chooseTypeAlloc(String typeAlloc, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocTb, "Type");
		selectDdlByText(xPathTbDataCellByPosition(xAllocTb, rowIndex, colIndex)
				+ "//select", typeAlloc);
		waitForAllJSCompletes();
	}

	public void typeVoucherNo(String voucherNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocTb, "Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xAllocTb, rowIndex, colIndex)
				+ "//a[@href and descendant::img]");
		waitForAllJSCompletes();
		if (!getResultSearch("Project No.", voucherNo)) {
			String xCloseIcon = "//table[@id='searchModalPanelContentTable']/preceding-sibling::div//a[@href]";
			$(xCloseIcon).waitUntilClickable().click();
		}
		waitForAllJSCompletes();
	}

	public void typeQty(String qty, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocTb, "Qty");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAllocTb, rowIndex, colIndex)
						+ "//input", qty);
	}

	public void chooseDeleteAlloc(int rowIndex) {
		String xDelete = xAllocTb + "//tbody/tr[" + rowIndex
				+ "]/td//a[@href and text()='Delete']";
		clickOnElement(xDelete);
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseSelAlloc(int rowIndex) {
		String xDelCheckBox = xAllocTb + "//tbody/tr[" + rowIndex
				+ "]/td//input[contains(@id, 'selected') and @type='checkbox']";
		clickOnElement(xDelCheckBox);
		waitForAllJSCompletes();
		clickBtn("Delete");
		waitForAllJSCompletes();
	}

	// ==================== APPLICATION TAB ===============
	private String xApplicationTb = "//table[contains(@id, 'apInvOstHdrAplTable')]";

	public void typeInvNo(String invNo) {
		waitTypeAndEnter(xPathTbHeaderCell(xApplicationTb, "Inv No.")
				+ "//input", invNo);
	}

	public void typeSupInvNo(String supInvNo) {
		enterInputFieldWithLabel("Sup Inv No", supInvNo);
	}

	public void typeInvDate(String invDate) {
		enterInputFieldWithLabel("Inv Date", invDate);
	}

	public void typeDueDate(String dueDate) {
		enterInputFieldWithLabel("Due Date", dueDate);
	}

	public void typeInvCcyRefNo(String invCcyRefNo) {
		enterInputFieldWithLabel("Inv Ccy Ref No.", invCcyRefNo);
	}

	public void typeApldCrnAmtHomeAmt(String apldCrnAmtHomeAmt) {
		int colIndex = getTbColHeaderIndex(xApplicationTb, "Crn Amt Home Amt");
		waitTypeAndEnter(xPathTbDataCellByPosition(xApplicationTb, 1, colIndex)
				+ "//input", apldCrnAmtHomeAmt);
	}

	public void typeApldInvAmtHomeAmt(String apldInvAmtHomeAmt) {
		int colIndex = getTbColHeaderIndex(xApplicationTb, "Inv Amt Home Amt");
		waitTypeAndEnter(xPathTbDataCellByPosition(xApplicationTb, 1, colIndex)
				+ "//input", apldInvAmtHomeAmt);
	}

	public void typeCrossRateRealizedExch(String crossRateRealizedExch) {
		int colIndex = getTbColHeaderIndex(xApplicationTb,
				"Cross Rate Realized Exch");
		waitTypeAndEnter(xPathTbDataCellByPosition(xApplicationTb, 1, colIndex)
				+ "//input", crossRateRealizedExch);
	}

	public void chooseApplyFull(String applyFull) {
		int colIndex = getTbColHeaderIndex(xApplicationTb, "Apply Full");
		clickOnElement(xPathTbDataCellByPosition(xApplicationTb, 1, colIndex)
				+ "//a[@href]");
	}

	public void clickOnDoneAllocBtn() {
		clickBtn(xAllocPopup, "Done");
		waitForAllJSCompletes();
	}

	public void typeApplicationDate(String applicationDate) {
		enterInputFieldWithLabel("Application Date", applicationDate);
	}
}
