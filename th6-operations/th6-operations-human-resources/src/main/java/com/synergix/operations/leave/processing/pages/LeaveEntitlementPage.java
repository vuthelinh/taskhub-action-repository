package com.synergix.operations.leave.processing.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class LeaveEntitlementPage extends TH5PageObject {
	public LeaveEntitlementPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "DetailFrmId:AddMultipleBtnIdNoEPC")
	private WebElementFacade addMulti;

	public void click_Add_Multiple_btn() {
		waitForAllJSCompletes();
		addMulti.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void add_by_employees_payroll_category_code(String epcCode) {
		search("Employee Payroll Category Code", epcCode);
	}

	public void filter_employee_by_code(String employeeCode) {
		String xPathHeaderCell = "//*[text()='Employee Code']";
		filterDataByHeader(xPathHeaderCell, employeeCode);
	}

	public String get_expected_leave_entitlement() {
		return $("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr/td[5]")
				.getText();
	}

	public String total_entitlement_before() {
		return $("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr/td[6]")
				.getText();
	}

	public String available_entitlement_before() {
		return $("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr/td[7]")
				.getText();
	}

	public String no_of_days() {
		return $("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr/td[9]/input")
				.getTextValue();
	}

	public String total_entitlement_after() {
		return $("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr/td[10]")
				.getText();
	}

	public String available_entitlement_after() {
		return $("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr/td[11]")
				.getText();
	}

	public void add_new_leave_entitlement_by_empolyee() {
		waitElementToBePresent(
				"//td[@id='LvEmpDraftTabId']//input[@value='New']")
				.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	@FindBy(xpath = "//img[@alt='Employee Lookup']")
	private WebElementFacade employeeLookup;

	public void typeEmployeeCodeByLT(String empCode) {
		waitForAllJSCompletes();
		employeeLookup.click();
		if (!getResultSearch("Employee Code", empCode)) {
			closePopup();
			String xDelCbx = "//td[9]/input";
			if (!$(xDelCbx).isSelected())
				$("//td[9]/input").click();
			clickBtn("//div[contains(@id, 'DetailFrmId:EmployeesPnlId')]",
					"Delete");
			chooseYesOnUpdateConfirmation();
		}
		waitForAllJSCompletes();
	}

	@FindBy(id = "DetailFrmId:btnAddLeaveType")
	private WebElementFacade btnAddLeaveType;

	public void add_leave_type_code(String leaveTypeCode) {
		waitElementToBePresent(
				"//input[@id='DetailFrmId:tblLeaveTypes:0:txtLeaveTypeCode']")
				.waitUntilEnabled().typeAndTab(leaveTypeCode);
		waitForAllJSCompletes();
	}

	public void chooseAdjustmentTypeByLT(String adjusmentType) {
		String xAdjusmentType = "//select[@id='DetailFrmId:EmployeesTblId:0:AdjustsmentTypeId']";
		selectDdlByText(xAdjusmentType, adjusmentType);
		waitForAllJSCompletes();
	}

	public void chooseAdjustmentTypeByEmp(String adjusmentType) {
		String xAdjusmentType = "//select[@id='DetailFrmId:tblLeaveTypes:0:txtAdjType']";
		selectDdlByText(xAdjusmentType, adjusmentType);
		waitForAllJSCompletes();
	}

	public void typeNoOfDayByEmp(String noOfDay) {
		waitElementToBePresent("//td[8]/input").waitUntilPresent().typeAndTab(
				noOfDay);
		waitForAllJSCompletes();
	}

	public void typeNoOfDayByLT(String noOfDay) {
		waitElementToBePresent("//td[9]/input").waitUntilPresent().typeAndTab(
				noOfDay);
		waitForAllJSCompletes();
	}

	public void filter_leave_entitlement_voucher_by_employee(String voucherNo) {
		waitForAllJSCompletes();
		waitElementToBePresent(
				"//td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/form/table/thead/tr/th/div/span/span/input")
				.waitUntilPresent().typeAndTab(voucherNo);
		waitForAllJSCompletes();
	}

	public void select_voucher_in_the_table(String voucherNo) {
		waitForAllJSCompletes();
		waitElementToBePresent("//a[contains(text(),'" + voucherNo + "')]")
				.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void add_new_leave_entitlement_by_leave_type() {
		clickBtn("//td[@id='LvTypeDraftTabId']", "New");
		waitForAllJSCompletes();
	}

	public void filter_leave_entitlement_voucher_by_leave_type(String voucherNo) {
		waitForAllJSCompletes();
		waitElementToBePresent("//span/input").waitUntilPresent().typeAndTab(
				voucherNo);
		waitForAllJSCompletes();
	}

	public int countRowIndexByLeaveType() {
		String xTableByLeaveType = "//table[@id='DetailFrmId:EmployeesTblId']/tbody/tr";
		return findAll(xTableByLeaveType).size();
	}

	public void searchLeaveEntitlementVCH(String leaveEntitlementVCH,
			int indexTab) {
		String xHeaderCell = "";
		if (indexTab == 1) {
			xHeaderCell = xPathTbHeaderCell(
					"//td[@id='LeByLeaveTypeTabId']//td[@id='LvTypeDraftTabId']",
					"Leave Entitlement Voucher");
		} else if (indexTab == 2) {
			xHeaderCell = xPathTbHeaderCell(
					"//td[@id='LeByEmployeeTabId']//td[@id='LvEmpDraftTabId']",
					"Leave Entitlement Voucher");
		}

		filterDataByHeader(xHeaderCell, leaveEntitlementVCH);
		waitForAllJSCompletes();
		String xFirstRow = xHeaderCell
				+ "/ancestor::thead/following-sibling::tbody/tr[1]/td[1]/a[@href]";
		if (findAll(xFirstRow).size() > 0) {
			if ($(xFirstRow).getText().toLowerCase()
					.equals(leaveEntitlementVCH.toLowerCase())) {
				$(xFirstRow).waitUntilClickable().click();
				waitForAllJSCompletes();
			}
		}
	}

	public void chooseEmployeeCode(String employeeCode) {
		String xSearchIcon = "//td[preceding-sibling::td[text()='Employee Code']]/a[@href and child::img]";
		$(xSearchIcon).waitUntilClickable().click();

		if (!getResultSearch("Employee Code", employeeCode)) {
			closePopup();
		}
	}

}
