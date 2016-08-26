package com.synergix.processing.generalledger.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.generalledger.pages.GLJournalVchPage;

public class GLJournalVchSteps extends ScenarioSteps {
	GLJournalVchPage onGLJournalVchPage;

	public void switchOutDefaultIFrame() {
		onGLJournalVchPage.switchOutDefaultIFrame();
	}

	public void switchToIFrame() {
		onGLJournalVchPage.switchToIFrame();
	}

	@Step
	public void chooseType(String type) {
		onGLJournalVchPage.chooseType(type);
	}

	@Step
	public void typeVoucherNo(String voucherNo) {
		onGLJournalVchPage.typeVoucherNo(voucherNo);
	}

	@Step
	public void typeDescription(String description) {
		onGLJournalVchPage.typeDescription(description);
	}

	@Step
	public void typeVoucherDate(String voucherDate) {
		onGLJournalVchPage.typeVoucherDate(voucherDate);
	}

	@Step
	public void typeCurrency(String currency) {
		onGLJournalVchPage.typeCurrency(currency);
	}

	@Step
	public void typeDocumentType(String documentType) {
		onGLJournalVchPage.typeDocumentType(documentType);
	}

	@Step
	public void chooseExchangeRateType(String exchangeRateType) {
		onGLJournalVchPage.chooseExchangeRateType(exchangeRateType);
	}

	@Step
	public void typeExchangeRate(String exchangeRate) {
		onGLJournalVchPage.typeExchangeRate(exchangeRate);
	}

	@Step
	public void typeDocumentNo(String documentNo) {
		onGLJournalVchPage.typeDocumentNo(documentNo);
	}

	@Step
	public void clickOnNewBtn() {
		onGLJournalVchPage.clickBtn("New");
		onGLJournalVchPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnSubmitBtn() {
		onGLJournalVchPage.clickBtn("Submit");
		onGLJournalVchPage.chooseYesOnUpdateConfirmation();
		onGLJournalVchPage.chooseOkOnInforPanel();
		onGLJournalVchPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAddBtn() {
		onGLJournalVchPage.clickBtn("Add");
		onGLJournalVchPage.waitForAllJSCompletes();
		waitABit(500);
	}

	@Step
	public void setSegment(List<String> listSegment) {
		onGLJournalVchPage.setSegment(listSegment);
	}

	@Step
	public void setSegment(List<String> listSegment, int rowIndex) {
		onGLJournalVchPage.setSegmentTb(listSegment, rowIndex);
	}

	public String getToday() {
		return onGLJournalVchPage.getToday();
	}

	@Step
	public void clickOnPreview(String reportName) {
		onGLJournalVchPage.clickPreviewBtn(reportName);
	}

	@Step
	public String getDataWithSession(String ssGLJV) {
		return onGLJournalVchPage.getDataWithSession(ssGLJV, 0);
	}

	@Step
	public void getVchNoToSession(String ssGLJV) {
		onGLJournalVchPage.getVchNoToSession(ssGLJV);
	}

	@Step
	public void clickPreviewHST(String vchNo, String reportName) {
		onGLJournalVchPage.clickPreviewHSTTab(vchNo, reportName);
	}

	// ================ DETAILS ====================
	@Step
	public void typeGLAccountNo(String gLAccountNo, int rowIndex) {
		onGLJournalVchPage.typeGLAccountNo(gLAccountNo, rowIndex);
	}

	@Step
	public void typeRemark(String remark, int rowIndex) {
		onGLJournalVchPage.typeRemark(remark, rowIndex);
	}

	@Step
	public void typeNatureDebit(String natureDebit, int rowIndex) {
		onGLJournalVchPage.typeNatureDebit(natureDebit, rowIndex);
	}

	@Step
	public void typeHomeDebit(String homeDebit, int rowIndex) {
		onGLJournalVchPage.typeHomeDebit(homeDebit, rowIndex);
	}

	@Step
	public void typeNatureCredit(String natureCredit, int rowIndex) {
		onGLJournalVchPage.typeNatureCredit(natureCredit, rowIndex);
	}

	@Step
	public void typeHomeCredit(String homeCredit, int rowIndex) {
		onGLJournalVchPage.typeHomeCredit(homeCredit, rowIndex);
	}

	@Step
	public void chooseDelete(String delete, int rowIndex) {
		onGLJournalVchPage.chooseDelete(delete, rowIndex);
	}

	@Step
	public boolean searchVchNo(String voucherNo) {
		return onGLJournalVchPage.searchVchNo(voucherNo);
	}

	@Step
	public void chooseDeleteAll() {
		onGLJournalVchPage.chooseDeleteAll();
	}

}
