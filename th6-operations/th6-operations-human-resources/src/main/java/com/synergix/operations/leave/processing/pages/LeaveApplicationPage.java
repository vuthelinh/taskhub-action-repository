package com.synergix.operations.leave.processing.pages;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class LeaveApplicationPage extends TH5PageObject {

	public LeaveApplicationPage(WebDriver driver) {
		super(driver);
	}

	public void chooseApplicant(String applicant) {
		String xSearchIcon = "//td[preceding-sibling::td[text()='Applicant']]//a[@href and child::img]";
		$(xSearchIcon).waitUntilClickable().click();
		waitForAllJSCompletes();
		if (!getResultSearch("Employee Code", applicant)) {
			closePopup();
		}
	}

	public void typeApplicationDate(String applicationDate) {
		enterInputFieldWithLabel("Application Date", applicationDate);
		waitForAllJSCompletes();
	}

	public void typeSBU(String sBU) {
		enterInputFieldCodeWithLabel("SBU", sBU);
		waitForAllJSCompletes();
	}

	public void searchLeaveApplication(String leaveAppNo) {
		String xHeaderCell = xPathTbHeaderCell("//td[@id='tabDraft']",
				"Leave Application No.");
		filterDataByHeader(xHeaderCell, leaveAppNo);
		waitForAllJSCompletes();
		String xFirstRow = xHeaderCell
				+ "/ancestor::thead/following-sibling::tbody/tr[1]/td[1]/a[@href]";
		if (findAll(xFirstRow).size() > 0) {
			if ($(xFirstRow).getText().toLowerCase()
					.equals(leaveAppNo.toLowerCase())) {
				$(xFirstRow).waitUntilClickable().click();
				waitForAllJSCompletes();
			}
		}
	}

	private String xParentLeaveTypeTb = "//table[contains(@id, 'LeaveTypeTblId') and child::thead]";

	public void typeLeaveType(String leaveType, int rowIndex) {
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentLeaveTypeTb, rowIndex,
						getTbColHeaderIndexByText("Leave Type"))
						+ "//input[@type='text']", leaveType);
	}

	public void typeDateFrom(String dateFrom, int rowIndex) {
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentLeaveTypeTb, rowIndex,
						getTbColHeaderIndexByText("Date From"))
						+ "//input[@type='text']", dateFrom);
	}

	public void typeDateTo(String dateTo, int rowIndex) {
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentLeaveTypeTb, rowIndex,
						getTbColHeaderIndexByText("Date To"))
						+ "//input[@type='text']", dateTo);
	}

	public void typeDurationType(String durationType, int rowIndex) {
		selectDdlByText(
				xPathTbDataCellByPosition(xParentLeaveTypeTb, rowIndex,
						getTbColHeaderIndexByText("Duration Type")) + "/select",
				durationType);
	}

	public int countRowIndex() {
		String xTable = "//table[contains(@id, 'LeaveTypeTblId')]/tbody/tr[@class]";
		return findAll(xTable).size();
	}

	public int getRowIndex(String leaveType) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqual(
				xParentLeaveTypeTb, leaveType, 1));
	}

	public void getLANo(String ssLANo) {
		List<String> listLANo = new ArrayList<>();
		String lANo = getTextValueWithLabel("Leave Application No.");
		listLANo = Serenity.sessionVariableCalled(ssLANo);
		listLANo.add(lANo);
		Serenity.setSessionVariable(ssLANo).to(listLANo);
	}

}
