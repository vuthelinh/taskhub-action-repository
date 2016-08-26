package com.synergix.mastersetup.humanresource.employeeapprovingofficer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class DesignationPage extends TH6PageObject {

	public DesignationPage(WebDriver driver) {
		super(driver);
	}

	String xParentDetailLocalInfo = "//div[contains(@id, 'detailTabs:localInfo')]";

	private String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "(" + _parentXpath + "/tbody/tr)[" + _rowIndex + "]/td[" + _headerIndex + "]";
	}

	private int getColumnIndex(String _parentXpath, String colName) {
		String xHeaderCell = _parentXpath + "//th[descendant::span[text()='" + colName + "']]/preceding-sibling::th";
		return findAll(xHeaderCell).size() + 1;
	}

	public int countRowTbl() {
		String xPath = xParentDetailTbl + "/tbody/tr";
		return findAll(xPath).size();
	}

	public void typeDesignationCode(String designationCode) {
		enterInputFieldCodeWithLabel("Designation Code", designationCode);
	}

	public void typeDesignationDescription(String designationDescription) {
		enterInputFieldWithLabel("Designation Description", designationDescription);
	}

	// LOCAL INFO TAB

	private String xDetailTab = "//div[contains(@id, 'glbDsgDetailInclude:detailTabs') and @aria-hidden='false']";
	private String xAddIcon = "(//form[contains(@id, 'detailTabs:localInfo')]//button)[1]";
	private String xDelIcon = "(//form[contains(@id, 'detailTabs:localInfo')]//button)[2]";
	private String xParentDetailTbl = "//form[contains(@id, 'detailTabs:localInfo')]//table[child::thead]";

	public void clickOnAddIcon() {
		$(xAddIcon).click();
		waitForAllJSCompletes();
	}

	public void clickOnDelIcon() {
		$(xDelIcon).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void typeEffectiveDateFrom(String effectiveDateFrom, int rowIndex) {
		int colIndex = getColumnIndex(xParentDetailTbl, "Effective Date From");
		waitTypeAndEnterThenUpdateDate(xCellByPosition(xParentDetailTbl, rowIndex, colIndex) + "//input",
				effectiveDateFrom);
	}

	public void typeEffectiveDateTo(String effectiveDateFrom, int rowIndex) {
		if (effectiveDateFrom.isEmpty()) {
			effectiveDateFrom = "31/12/2020";
		} else {
			effectiveDateFrom = previousDay(effectiveDateFrom);
		}

		int colIndex = getColumnIndex(xParentDetailTbl, "Effective Date To");
		waitTypeAndEnterThenUpdateDate(xCellByPosition(xParentDetailTbl, rowIndex, colIndex) + "//input",
				effectiveDateFrom);
	}

	public void typeNormalHourlyRate(String normalHourlyRate, int rowIndex) {
		int colIndex = getColumnIndex(xParentDetailTbl, "Normal Hourly Rate");
		waitTypeAndEnterThenUpdateValue(xCellByPosition(xParentDetailTbl, rowIndex, colIndex) + "//input",
				normalHourlyRate);
	}

	public void typeOTHourlyRate(String oTHourlyRate, int rowIndex) {
		int colIndex = getColumnIndex(xParentDetailTbl, "OT Hourly Rate");
		waitTypeAndEnterThenUpdateValue(xCellByPosition(xParentDetailTbl, rowIndex, colIndex) + "//input",
				oTHourlyRate);
	}

}
