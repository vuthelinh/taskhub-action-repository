package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.EmployeePage;

public class EmployeeSteps extends ScenarioSteps {

	EmployeePage onEmployeePage;

	@Step
	public void switchOutDefaultIFrame() {
		onEmployeePage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onEmployeePage.switchToIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onEmployeePage.clickBtn("New");
		onEmployeePage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnUpdateBtn() {
		onEmployeePage.clickBtn("Update");
		onEmployeePage.chooseYesOnUpdateConfirmation();
		onEmployeePage.waitForAllJSCompletes();
	}

	@Step
	public void deleteEmployee(String employeeCode) {
		onEmployeePage.deleteValueByFilter("", "Employee Code", employeeCode);
	}

	@Step
	public void typeEmployeeCode(String employeeCode) {
		if (!employeeCode.isEmpty())
			onEmployeePage.typeEmployeeCode(employeeCode);
	}

	@Step
	public void typeEmployeeName(String employeeName) {
		if (!employeeName.isEmpty())
			onEmployeePage.typeEmployeeName(employeeName);
	}

	@Step
	public void typeEmployeeShortName(String employeeShortName) {
		if (!employeeShortName.isEmpty())
			onEmployeePage.typeEmployeeShortName(employeeShortName);
	}

	@Step
	public void changeUserIDStatus(String userIdStatus) {
		if (!userIdStatus.isEmpty())
			onEmployeePage.changeUserIDStatus(userIdStatus);
	}

	@Step
	public void back_to_summary() {
		onEmployeePage.backToSummary();
	}

	@Step
	public void search_employee_by_code(String employee_code) {
		onEmployeePage.searchEmployeeByCode(employee_code);
	}

	@Step
	public void search_employee_by_userName(String userName) {
		onEmployeePage.searchEmployeeByUserName(userName);
	}

	@Step
	public boolean searchEmployeeByEmployeeCode(String employeeCode) {
		return onEmployeePage.searchEmployeeByEmployeeCode(employeeCode);
	}

	@Step
	public void moveToEmployeeDurationTab() {
		onEmployeePage.moveToTab("Employment Info & Duration");
	}

	@Step
	public void moveToParticularsTab() {
		onEmployeePage.moveToTab("Particulars");
	}

	@Step
	public void moveToContactTab() {
		onEmployeePage.moveToTab("Contact");
	}

	@Step
	public void generate_account() {
		onEmployeePage.clickBtn("Generate");
		onEmployeePage.chooseYesOnUpdateConfirmation();
		onEmployeePage.waitForAllJSCompletes();
	}

	@Step
	public String getPassword() {
		return onEmployeePage.getPwd();
	}

	@Step
	public void addRemarks(String sRemarks) {
		onEmployeePage.add_remarks(sRemarks);
	}

	@Step
	public void clickOnRsetPasswordBtn() {
		onEmployeePage.clickBtn("Reset Password");
		onEmployeePage.chooseYesOnUpdateConfirmation();
		onEmployeePage.waitForAllJSCompletes();
	}
}
