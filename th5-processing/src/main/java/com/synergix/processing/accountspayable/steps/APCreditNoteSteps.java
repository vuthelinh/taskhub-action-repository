package com.synergix.processing.accountspayable.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountspayable.page.APCreditNotePage;

public class APCreditNoteSteps extends ScenarioSteps {
	APCreditNotePage onAPCreditNotePage;

	public void switchToIFrame() {
		onAPCreditNotePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onAPCreditNotePage.switchOutDefaultIFrame();
	}

	@Step
	public void getCrnNo(String ssCrnNo) {
		onAPCreditNotePage.getCrnNo(ssCrnNo);
	}

	@Step
	public void clickOnNewBtn() {
		onAPCreditNotePage.clickBtn("New");
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onAPCreditNotePage.clickBtn("Submit");
		onAPCreditNotePage.chooseYesOnUpdateConfirmation();
		onAPCreditNotePage.chooseOkOnInforPanel();
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddAllocBtn() {
		onAPCreditNotePage.clickOnAddAllocBtn();
	}

	@Step
	public void clickOnPreviewBtn() {
		onAPCreditNotePage.clickPreviewBtn();
	}

	@Step
	public void clickOnPreviewHSTBtn(String crnNo) {
		onAPCreditNotePage.clickPreviewHST("Crn No.", crnNo);
	}

	@Step
	public boolean searchDrafCrnNo(String crnNo) {
		String xDrafTb = "//table[contains(@id,'apCrnNewHdrTable')]";
		return onAPCreditNotePage.searchCrnNo(xDrafTb, crnNo);
	}

	@Step
	public boolean searchHSTCrnNo(String crnNo) {
		String xHSTTb = "//table[contains(@id,'apCrnHstHdrTable')]";
		return onAPCreditNotePage.searchCrnNo(xHSTTb, crnNo);
	}

	@Step
	public boolean searchOSTCrnNo(String crnNo) {
		String xDrafTb = "//table[contains(@id,'apCrnOstHdrTable')]";
		return onAPCreditNotePage.searchCrnNo(xDrafTb, crnNo);
	}

	@Step
	public void typeSupplier(String supplier) {
		onAPCreditNotePage.typeSupplier(supplier);
	}

	@Step
	public void typeCurrency(String currency) {
		onAPCreditNotePage.typeCurrency(currency);
	}

	@Step
	public void typePostingDate(String postingDate) {
		onAPCreditNotePage.typePostingDate(postingDate);
	}

	@Step
	public void typeSupplierCreditNoteNo(String supplierCreditNoteNo) {
		onAPCreditNotePage.typeSupplierCreditNoteNo(supplierCreditNoteNo);
	}

	@Step
	public void typeCreditNoteCategory(String creditNoteCategory) {
		onAPCreditNotePage.typeCreditNoteCategory(creditNoteCategory);
	}

	@Step
	public void typeSalesTax(String salesTax) {
		onAPCreditNotePage.typeSalesTax(salesTax);
	}

	@Step
	public void typeLocation(String location) {
		onAPCreditNotePage.typeLocation(location);
	}

	@Step
	public void typeSupplierCreditNoteDate(String supplierCreditNoteDate) {
		onAPCreditNotePage.typeSupplierCreditNoteDate(supplierCreditNoteDate);
	}

	@Step
	public void typeDefaultDisc(String defaultDisc) {
		onAPCreditNotePage.typeDefaultDisc(defaultDisc);
	}

	@Step
	public void typeReferenceNo(String referenceNo) {
		onAPCreditNotePage.typeReferenceNo(referenceNo);
	}

	@Step
	public void typeCreditNoteJustification(String creditNoteJustification) {
		onAPCreditNotePage.typeCreditNoteJustification(creditNoteJustification);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onAPCreditNotePage.setSegment(listSegment);
		// onAPCreditNotePage.typeSegment1("NA");
		// onAPCreditNotePage.typeSegment2("NA");
		// onAPCreditNotePage.typeSegment3("NA");
		// onAPCreditNotePage.typeSegment4("NA");
	}

	// =================== HEADER TAB ====================
	// Detail
	@Step
	public void moveToHeaderTab() {
		onAPCreditNotePage.switch_to_tab("Header");
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBtn() {
		onAPCreditNotePage.clickBtn("Add");
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnDeleteBtn() {
		onAPCreditNotePage.clickBtn("Delete");
		onAPCreditNotePage.waitForAllJSCompletes();
		onAPCreditNotePage.chooseYesOnUpdateConfirmation();
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void chooseType(String type, int rowIndex) {
		onAPCreditNotePage.chooseType(type, rowIndex);
	}

	@Step
	public void typeItemCode(String itemCode, int rowIndex) {
		onAPCreditNotePage.typeItemCode(itemCode, rowIndex);
	}

	@Step
	public void typeRemarks(String remarks, int rowIndex) {
		onAPCreditNotePage.typeRemarks(remarks, rowIndex);
	}

	@Step
	public void typeQtyUOM(String qtyUOM, int rowIndex) {
		onAPCreditNotePage.typeQtyUOM(qtyUOM, rowIndex);
	}

	@Step
	public void typePackSize(String packSize, int rowIndex) {
		onAPCreditNotePage.choosePackSize(packSize, rowIndex);
	}

	@Step
	public void chooseCostType(String costType, int rowIndex) {
		onAPCreditNotePage.chooseCostType(costType, rowIndex);
	}

	@Step
	public void typeUnitCost(String unitCost, int rowIndex) {
		onAPCreditNotePage.typeUnitCost(unitCost, rowIndex);
	}

	@Step
	public void typeDiscount(String discountAmount, int rowIndex) {
		onAPCreditNotePage.typeDiscount(discountAmount, rowIndex);
	}

	@Step
	public void typeAmount(String amount, int rowIndex) {
		onAPCreditNotePage.typeAmount(amount, rowIndex);
	}

	@Step
	public void typeSalestax(String salestax, int rowIndex) {
		onAPCreditNotePage.typeSalestax(salestax, rowIndex);
	}

	public int countRowDetailTb() {
		String xDetailTb = "//table[@id='lineItemsForm:lineItemsTable']";
		return onAPCreditNotePage.getTbCountDataRow(xDetailTb);
	}

	@Step
	public void chooseSerialNo(String serialNo, int rowIndex) {
		onAPCreditNotePage.chooseSerialNo(serialNo, rowIndex);
	}

	@Step
	public void chooseDelete(int rowIndex) {
		onAPCreditNotePage.chooseDelete(rowIndex);
	}

	@Step
	public void chooseDel(int rowIndex) {
		onAPCreditNotePage.chooseDel(rowIndex);
	}

	@Step
	public void setSegment(List<String> listSegment, int rowIndex) {
		onAPCreditNotePage.setSegment(listSegment, rowIndex);
	}

	// ALLOC

	public int countRowAllocTb() {
		String xAllocTb = "//table[@id='allocsForm:allocsTable']";
		return onAPCreditNotePage.getTbCountDataRow(xAllocTb);
	}

	@Step
	public void chooseLIno(String lIno) {
		onAPCreditNotePage.chooseLIno(lIno);
	}

	@Step
	public void setSegmentAlloc(List<String> listSegment) {
		String xAllocPopup = "//table[@id='popupModalPanelContentTable']";
		onAPCreditNotePage.setSegment(xAllocPopup, listSegment);
	}

	@Step
	public void chooseTypeAlloc(String type, int rowIndex) {
		onAPCreditNotePage.chooseTypeAlloc(type, rowIndex);
	}

	@Step
	public void typeVoucherNo(String voucherNo, int rowIndex) {
		onAPCreditNotePage.typeVoucherNo(voucherNo, rowIndex);
	}

	@Step
	public void typeQty(String qty, int rowIndex) {
		onAPCreditNotePage.typeQty(qty, rowIndex);
	}

	@Step
	public void chooseDeleteAlloc(int rowIndex) {
		onAPCreditNotePage.chooseDeleteAlloc(rowIndex);
	}

	@Step
	public void chooseSelAlloc(int rowIndex) {
		onAPCreditNotePage.chooseSelAlloc(rowIndex);
	}

	@Step
	public void clickOnDoneAllocBtn() {
		onAPCreditNotePage.clickOnDoneAllocBtn();
	}

	// ==================== APPLICATION TAB ===============
	@Step
	public void moveToApplicationTab() {
		onAPCreditNotePage.switch_to_tab("Application");
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void typeInvNo(String invNo) {
		onAPCreditNotePage.typeInvNo(invNo);
	}

	@Step
	public void typeSupInvNo(String supInvNo) {
		onAPCreditNotePage.typeSupInvNo(supInvNo);
	}

	@Step
	public void typeInvDate(String invDate) {
		onAPCreditNotePage.typeInvDate(invDate);
	}

	@Step
	public void typeDueDate(String dueDate) {
		onAPCreditNotePage.typeDueDate(dueDate);
	}

	@Step
	public void typeInvCcyRefNo(String invCcyRefNo) {
		onAPCreditNotePage.typeInvCcyRefNo(invCcyRefNo);
	}

	@Step
	public void typeApldCrnAmtHomeAmt(String apldCrnAmtHomeAmt) {
		onAPCreditNotePage.typeApldCrnAmtHomeAmt(apldCrnAmtHomeAmt);
	}

	@Step
	public void typeApldInvAmtHomeAmt(String apldInvAmtHomeAmt) {
		onAPCreditNotePage.typeApldInvAmtHomeAmt(apldInvAmtHomeAmt);
	}

	@Step
	public void typeCrossRateRealizedExch(String crossRateRealizedExch) {
		onAPCreditNotePage.typeCrossRateRealizedExch(crossRateRealizedExch);
	}

	@Step
	public void chooseApplyFull(String applyFull) {
		onAPCreditNotePage.chooseApplyFull(applyFull);
	}

	@Step
	public void typeApplicationDate(String applicationDate) {
		onAPCreditNotePage.typeApplicationDate(applicationDate);
	}

	@Step
	public void gotoHistoryTab() {
		onAPCreditNotePage.switch_to_tab("History");
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	@Step
	public void gotoOutstandingTab() {
		onAPCreditNotePage.switch_to_tab("Outstanding");
		onAPCreditNotePage.waitForAllJSCompletes();
	}

	public String getToday() {
		return onAPCreditNotePage.getToday();
	}
}
