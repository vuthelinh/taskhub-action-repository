package com.synergix.mtsetup.financial.accounting.steps;

import java.util.List;

import com.synergix.mtsetup.financial.accounting.pages.MTGLRecurringVCHPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MTGLRecurringVCHSteps extends ScenarioSteps {

	MTGLRecurringVCHPage onMTGLRecurringVCHPage;

	public void switchToIFrame() {
		onMTGLRecurringVCHPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onMTGLRecurringVCHPage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onMTGLRecurringVCHPage.clickBtn("New");
		onMTGLRecurringVCHPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnCloseBtn() {
		onMTGLRecurringVCHPage.clickBtn("Close");
		onMTGLRecurringVCHPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBtn() {
		onMTGLRecurringVCHPage.clickBtn("Add");
		onMTGLRecurringVCHPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnDone() {
		onMTGLRecurringVCHPage.clickBtn("Done");
	}

	@Step
	public boolean isSegment() {
		return onMTGLRecurringVCHPage.isSegment();
	}

	@Step
	public void typeRecurringVoucherCode(String recurringVoucherCode) {
		onMTGLRecurringVCHPage.typeRecurringVoucherCode(recurringVoucherCode);
	}

	@Step
	public void typeDescription(String description) {
		onMTGLRecurringVCHPage.typeDescription(description);
	}

	@Step
	public void typeCurrency(String currency) {
		onMTGLRecurringVCHPage.typeCurrency(currency);
	}

	@Step
	public void chooseExchangeRateType(String exchangeRateType) {
		onMTGLRecurringVCHPage.chooseExchangeRateType(exchangeRateType);
	}

	@Step
	public void typeSourceDocumentType(String sourceDocumentType) {
		onMTGLRecurringVCHPage.typeSourceDocumentType(sourceDocumentType);
	}

	@Step
	public void typeSourceDocumentNo(String sourceDocumentNo) {
		onMTGLRecurringVCHPage.typeSourceDocumentNo(sourceDocumentNo);
	}

	@Step
	public void chooseRecurringDay(String recurringDay) {
		onMTGLRecurringVCHPage.chooseRecurringDay(recurringDay);
	}

	@Step
	public void chooseRecurringFrequency(String recurringFrequency) {
		onMTGLRecurringVCHPage.chooseRecurringFrequency(recurringFrequency);
	}

	@Step
	public void typeRecurrenceStartDate(String recurrenceStartDate) {
		onMTGLRecurringVCHPage.typeRecurrenceStartDate(recurrenceStartDate);
	}

	@Step
	public void typeRecurrenceEndDate(String recurrenceEndDate) {
		onMTGLRecurringVCHPage.typeRecurrenceEndDate(recurrenceEndDate);
	}

	@Step
	public void typeNextRecurrenceDate(String nextRecurrenceDate) {
		onMTGLRecurringVCHPage.typeNextRecurrenceDate(nextRecurrenceDate);
	}

	@Step
	public void typeSegment1(String segment1) {
		onMTGLRecurringVCHPage.typeSegment1(segment1);
	}

	@Step
	public void typeSegment2(String segment2) {
		onMTGLRecurringVCHPage.typeSegment2(segment2);
	}

	@Step
	public void typeSegment3(String segment3) {
		onMTGLRecurringVCHPage.typeSegment3(segment3);
	}

	@Step
	public void typeSegment4(String segment4) {
		onMTGLRecurringVCHPage.typeSegment4(segment4);
	}

	@Step
	public void typeGLAccountCode(String gLAccountCode, int rowIndex) {
		onMTGLRecurringVCHPage.typeGLAccountCode(gLAccountCode, rowIndex);
	}

	@Step
	public void typeDetailDescription(String detailDescription, int rowIndex) {
		onMTGLRecurringVCHPage.typeDetailDescription(detailDescription, rowIndex);
	}

	@Step
	public void typeNatureDebit(String natureDebit, int rowIndex) {
		onMTGLRecurringVCHPage.typeNatureDebit(natureDebit, rowIndex);
	}

	@Step
	public void typeNaturalCredit(String naturalCredit, int rowIndex) {
		onMTGLRecurringVCHPage.typeNaturalCredit(naturalCredit, rowIndex);
	}

	@Step
	public void typeDetailSegment1(String detailSegment1) {
		onMTGLRecurringVCHPage.typeDetailSegment1(detailSegment1);
	}

	@Step
	public void typeDetailSegment2(String detailSegment2) {
		onMTGLRecurringVCHPage.typeDetailSegment2(detailSegment2);
	}

	@Step
	public void typeDetailSegment3(String detailSegment3) {
		onMTGLRecurringVCHPage.typeDetailSegment3(detailSegment3);
	}

	@Step
	public void typeDetailSegment4(String detailSegment4) {
		onMTGLRecurringVCHPage.typeDetailSegment4(detailSegment4);
	}

	@Step
	public void clickOnInfoSgmts(int rowIndex) {
		onMTGLRecurringVCHPage.clickOnInfoSgmts(rowIndex);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onMTGLRecurringVCHPage.setSegment(listSegment);
	}

	@Step
	public void setSegment(List<String> listSegment, int rowIndex) {
		String xParentDetailTb = "//table[contains(@id, 'lineItemsForm:lineItemsTable')]";
		onMTGLRecurringVCHPage.setSegment(xParentDetailTb, listSegment, rowIndex);
	}

	public int getRowDetailTb() {
		return onMTGLRecurringVCHPage.getRowDetailTb();
	}

	@Step
	public boolean searchVCH(String recurringVoucherCode) {
		onMTGLRecurringVCHPage.clickBtn("Search");
		return onMTGLRecurringVCHPage.getResultSearch("Recurring Voucher Code", recurringVoucherCode);
	}

	public void deleteValueBySearchBtn(String recurringVoucherCode) {
		onMTGLRecurringVCHPage.deleteValueBySearchBtn("Search", "Recurring Voucher Code", recurringVoucherCode);
	}

}
