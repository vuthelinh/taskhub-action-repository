package com.synergix.steps;

import java.util.List;

import com.synergix.page.FixedAssetPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FixedAssetSteps extends ScenarioSteps {

	FixedAssetPage onFixedAssetPage;

	public void switchToIFrame() {
		onFixedAssetPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onFixedAssetPage.switchOutDefaultIFrame();
	}

	@Step
	public boolean checkSegment() {
		return onFixedAssetPage.isSegment();
	}

	@Step
	public void clickOnSubmit() {
		onFixedAssetPage.clickOnSubmitButton();
	}

	@Step
	public void addDetail() {
		onFixedAssetPage.clickOnAddNewBtn();
	}

	@Step
	public void clickInfoCumulativeDepnAmt(int row) {
		onFixedAssetPage.clickInfoIcon(row, 7);
	}

	@Step
	public void clickOnOKBtn() {
		onFixedAssetPage.clickOnOkBtn();
	}

	@Step
	public void clickInfoSegmt(int row) {
		onFixedAssetPage.clickInfoIcon(row, 8);
	}

	@Step
	public void clickOnDoneBtn() {
		onFixedAssetPage.clickOnDoneBtn();
	}

	@Step
	public void moveToDetailTab() {
		onFixedAssetPage.switch_to_tab("Detail");
	}

	@Step
	public void moveToRemarksTab() {
		onFixedAssetPage.switch_to_tab("Remarks");
	}

	@Step
	public void moveToHeaderTab() {
		onFixedAssetPage.switch_to_tab("Header");
	}

	@Step
	public void addNewFixedAsset() {
		onFixedAssetPage.clickOnNewBtn();
	}

	@Step
	public void typeFixedAssetCode(String fixedAssetCode) {
		onFixedAssetPage.typeFixedAssetCode(fixedAssetCode);
	}

	@Step
	public void typeTransactionDate(String transactionDate) {
		onFixedAssetPage.typeTransactionDate(transactionDate);
	}

	@Step
	public void typeSupplier(String supplier) {
		onFixedAssetPage.typeSupplier(supplier);
	}

	@Step
	public void typeSupplierInvoiceNo(String supplierInvoiceNo) {
		onFixedAssetPage.typeSupplierInvoiceNo(supplierInvoiceNo);
	}

	@Step
	public void typeSupplierInvoiceDate(String supplierInvoiceDate) {
		onFixedAssetPage.typeSupplierInvoiceDate(supplierInvoiceDate);
	}

	@Step
	public void typeSubject(String subject) {
		onFixedAssetPage.typeSubject(subject);
	}

	@Step
	public void typeDescription(String description) {
		onFixedAssetPage.typeDescription(description);
	}

	@Step
	public void typeSegment1(String segment1) {
		onFixedAssetPage.typeSegment1(segment1);
	}

	@Step
	public void typeSegment2(String segment2) {
		onFixedAssetPage.typeSegment2(segment2);
	}

	@Step
	public void typeSegment3(String segment3) {
		onFixedAssetPage.typeSegment3(segment3);
	}

	@Step
	public void typeSegment4(String segment4) {
		onFixedAssetPage.typeSegment4(segment4);
	}

	@Step
	public void typeInternalRemarksCode(String internalRemarksCode) {
		onFixedAssetPage.typeInternalRemarksCode(internalRemarksCode);
	}

	@Step
	public void typeExternalRemarksCode(String externalRemarksCode) {
		onFixedAssetPage.typeExternalRemarksCode(externalRemarksCode);
	}

	@Step
	public void typeInternalRemarks(String internalRemarks) {
		onFixedAssetPage.typeInternalRemarks(internalRemarks);
	}

	@Step
	public void typeExternalRemarks(String externalRemarks) {
		onFixedAssetPage.typeExternalRemarks(externalRemarks);
	}

	@Step
	public void typeSerialNo(String serialNo, int rowIndex) {
		onFixedAssetPage.typeSerialNo(serialNo, rowIndex);
	}

	@Step
	public void typeLocation(String location, int rowIndex) {
		onFixedAssetPage.typeLocation(location, rowIndex);
	}

	@Step
	public void typeAssetCost(String assetCost, int rowIndex) {
		onFixedAssetPage.typeAssetCost(assetCost, rowIndex);
	}

	@Step
	public void typeResidualValue(String residualValue, int rowIndex) {
		onFixedAssetPage.typeResidualValue(residualValue, rowIndex);
	}

	@Step
	public void typeLastDepreciationDate(String lastDepreciationDate) {
		onFixedAssetPage.typeLastDepreciationDate(lastDepreciationDate);
	}

	@Step
	public void typeNoofDepreciation(String noofDepreciation) {
		onFixedAssetPage.typeNoofDepreciation(noofDepreciation);
	}

	@Step
	public void typeRemainingUsefulLife(String remainingUsefulLife) {
		onFixedAssetPage.typeRemainingUsefulLife(remainingUsefulLife);
	}

	@Step
	public void typeDetailSegment1(String detailSegment1) {
		onFixedAssetPage.typeDetailSegment1(detailSegment1);
	}

	@Step
	public void typeDetailSegment2(String detailSegment2) {
		onFixedAssetPage.typeDetailSegment2(detailSegment2);
	}

	@Step
	public void typeDetailSegment3(String detailSegment3) {
		onFixedAssetPage.typeDetailSegment3(detailSegment3);
	}

	@Step
	public void typeDetailSegment4(String detailSegment4) {
		onFixedAssetPage.typeDetailSegment4(detailSegment4);
	}

	public boolean isSegment() {
		return onFixedAssetPage.isSegment();
	}

	public void update(String vchNo) {
		onFixedAssetPage.update(vchNo);
	}

	public void setSegment(List<String> listSegment) {
		onFixedAssetPage.setSegment(listSegment);
	}

	public void setSegment(List<String> listSegment, int rowIndex) {
		String xParentDetailTb = "//table[child::thead[descendant::*[text()='Sgmts']]]";
		onFixedAssetPage.setSegment(xParentDetailTb, listSegment, rowIndex);
	}

	public String getDateToday() {
		return onFixedAssetPage.getToday();
	}

	public int countRowTb() {
		String xParentDetailTb = "//table[contains(@id, 'detailTable') and child::thead]";
		return onFixedAssetPage.getTbCountDataRow(xParentDetailTb);
	}
}
