package com.synergix.operations.leave.processing.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.operations.leave.processing.pages.LeaveEntitlementPage;

public class LeaveEntitlementSteps extends ScenarioSteps {

	LeaveEntitlementPage onLeaveEntitlementPage;

	public void add_new() {
		onLeaveEntitlementPage.click_add_new_button_on_functional_panel();
	}

	@Step
	public void add_new_leave_entitlement_by_empolyee() {
		onLeaveEntitlementPage.add_new_leave_entitlement_by_empolyee();
	}

	@Step
	public void switch_to_draft_tab_in_By_Leave_Type_tab() {
		onLeaveEntitlementPage.switch_to_tab("By Leave Type");
		onLeaveEntitlementPage.switch_to_tab("Draft", 1);
	}

	@Step
	public void switch_to_Leave_Type_tab() {
		onLeaveEntitlementPage.switch_to_tab("Leave Type");
	}

	@Step
	public void switch_to_By_Employee_tab() {
		onLeaveEntitlementPage.switch_to_tab("By Employee");
	}

	@Step
	public void switch_to_Draf_tab_in_Employee_tab() {
		onLeaveEntitlementPage.switch_to_tab("Draft", 2);
	}

	@Step
	public void switch_to_Employee_tab_beside_Remark_tab() {
		onLeaveEntitlementPage.switch_to_tab("Employee");
	}

	public String getLeaveEntitlementVoucherNo() {
		return onLeaveEntitlementPage
				.getTextWithLabel("Leave Entitlement Voucher No.");
	}

	@Step
	public void year(String year) {
		onLeaveEntitlementPage.enterInputFieldWithLabel("Year", year);
	}

	@Step
	public void select_leave_type_beside_Remark_tab(String leaveType) {
		onLeaveEntitlementPage.selectDdlWithLabelByText("Leave Type:",
				leaveType.toUpperCase());
		onLeaveEntitlementPage.waitForAllJSCompletes();
	}

	@Step
	public void add_mutltiple_employees(String epcCode) {
		onLeaveEntitlementPage.click_Add_Multiple_btn();
		onLeaveEntitlementPage.add_by_employees_payroll_category_code(epcCode);
	}

	@Step
	public void filter_employee_by_code(String employeeCode) {
		onLeaveEntitlementPage.filter_employee_by_code(employeeCode);
	}

	public String expected_leave_entitlement() {
		return onLeaveEntitlementPage.get_expected_leave_entitlement();
	}

	public String total_entitlement_before() {
		return onLeaveEntitlementPage.total_entitlement_before();
	}

	public String available_entitlement_before() {
		return onLeaveEntitlementPage.available_entitlement_before();
	}

	public String no_of_days() {
		return onLeaveEntitlementPage.no_of_days();
	}

	public String total_entitlement_after() {
		return onLeaveEntitlementPage.total_entitlement_after();
	}

	public String available_entitlement_after() {
		return onLeaveEntitlementPage.available_entitlement_after();
	}

	@Step
	public void verify_expected_leave_entitlement(String value) {
		assertThat(expected_leave_entitlement(), equalTo(value));
	}

	@Step
	public void verify_total_entitlement_before(String value) {
		assertThat(total_entitlement_before(), equalTo(value));
	}

	@Step
	public void verify_available_entitlement_before(String value) {
		assertThat(available_entitlement_before(), equalTo(value));
	}

	@Step
	public void verify_no_of_days(String value) {
		assertThat(no_of_days(), equalTo(value));
	}

	@Step
	public void verify_total_entitlement_after(String value) {
		assertThat(total_entitlement_after(), equalTo(value));
	}

	@Step
	public void verify_available_entitlement_after(String value) {
		assertThat(available_entitlement_after(), equalTo(value));
	}

	@Step
	public void voucher_date(String value) {
		onLeaveEntitlementPage.enterInputFieldWithLabel("Voucher Date", value);
	}

	@Step
	public void submit() {
		onLeaveEntitlementPage.click_submit_button_on_functional_panel();
		onLeaveEntitlementPage.chooseYesOnUpdateConfirmation();
	}

	@Step
	public void default_adjusment_type(String defaultAdjusmentType) {
		onLeaveEntitlementPage.selectDdlWithLabelByText(
				"Default Adjustment Type", defaultAdjusmentType.toUpperCase());
		onLeaveEntitlementPage.waitForAllJSCompletes();
	}

	@Step
	public void typeEmployeeCodeByLT(String empCode) {
		onLeaveEntitlementPage.typeEmployeeCodeByLT(empCode);
	}

	@Step
	public void add_leave_type_code(String leaveTypeCode) {
		onLeaveEntitlementPage.add_leave_type_code(leaveTypeCode);
	}

	@Step
	public void chooseAdjustmentTypeByLT(String adjustmentType) {
		onLeaveEntitlementPage.chooseAdjustmentTypeByLT(adjustmentType);
	}

	@Step
	public void chooseAdjustmentTypeByEmp(String adjustmentType) {
		onLeaveEntitlementPage.chooseAdjustmentTypeByEmp(adjustmentType);
	}

	@Step
	public void typeNoOfDayByLT(String noOfDay) {
		onLeaveEntitlementPage.typeNoOfDayByLT(noOfDay);
	}

	@Step
	public void typeNoOfDayByEmp(String noOfDay) {
		onLeaveEntitlementPage.typeNoOfDayByEmp(noOfDay);
	}

	@Step
	public void close() {
		onLeaveEntitlementPage.click_close_button_on_functional_panel();
	}

	@Step
	public void back() {
		// onLeaveEntitlementPage.click_back_button_on_functional_panel();
	}

	@Step
	public void filter_leave_entitlement_voucher_by_employee(String voucherNo) {
		onLeaveEntitlementPage
				.filter_leave_entitlement_voucher_by_employee(voucherNo);
		onLeaveEntitlementPage.select_voucher_in_the_table(voucherNo);
	}

	@Step
	public void default_no_of_days(String noOfday) {
		onLeaveEntitlementPage.enterInputFieldWithLabel("Default No. of Days",
				noOfday);
	}

	@Step
	public void add_new_leave_entitlement_by_leave_type() {
		onLeaveEntitlementPage.add_new_leave_entitlement_by_leave_type();
	}

	@Step
	public void filter_leave_entitlement_voucher_by_leave_type(String voucherNo) {
		onLeaveEntitlementPage
				.filter_leave_entitlement_voucher_by_leave_type(voucherNo);
		onLeaveEntitlementPage.select_voucher_in_the_table(voucherNo);
	}

	public void switchToIFrame() {
		onLeaveEntitlementPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onLeaveEntitlementPage.switchOutDefaultIFrame();
	}

	public void clickOnAddEmployeeByLT() {
		onLeaveEntitlementPage.clickBtn(
				"//div[contains(@id, 'DetailFrmId:EmployeesPnlId')]", "Add");
		onLeaveEntitlementPage.waitForAllJSCompletes();
	}

	public int countRowIndexByLeaveType() {
		return onLeaveEntitlementPage.countRowIndexByLeaveType();
	}

	public void searchLeaveEntitlementVCHByEmp(String leaveEntitlementVCH) {
		onLeaveEntitlementPage
				.searchLeaveEntitlementVCH(leaveEntitlementVCH, 2);// 2= By
																	// Employee
	}

	public void searchLeaveEntitlementVCHByLT(String leaveEntitlementVCH) {
		onLeaveEntitlementPage
				.searchLeaveEntitlementVCH(leaveEntitlementVCH, 1);// 1= By
																	// Leave
																	// Type
	}

	public void moveToByLeaveTypeTab() {
		onLeaveEntitlementPage.switch_to_tab("By Leave Type");
	}

	public void moveToByEmployeeTab() {
		onLeaveEntitlementPage.switch_to_tab("By Employee");
	}

	public void clickOnSubmitBtn() {
		onLeaveEntitlementPage.clickBtn("Submit");
		onLeaveEntitlementPage.chooseYesOnUpdateConfirmation();
	}

	@Step
	public void chooseEmployeeCode(String employeeCode) {
		onLeaveEntitlementPage.chooseEmployeeCode(employeeCode);
	}

	public void clickOnAddLeaveTypeByEmp() {
		onLeaveEntitlementPage.clickBtn(
				"//div[@id='DetailFrmId:LeaveTypesPnlId']", "Add");
		onLeaveEntitlementPage.waitForAllJSCompletes();
	}
}
