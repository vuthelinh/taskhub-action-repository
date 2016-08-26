package com.synergix.operations.payroll.timesheet.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.operations.others.approval.pages.AprrovalPages;
import com.synergix.operations.payroll.timesheet.pages.WeeklyTimesheetPage;
import com.synergix.utilities.SessionData;

public class WeeklyTimesheetSteps extends ScenarioSteps {

	WeeklyTimesheetPage onWeeklyTimesheetPage;
	AprrovalPages onAprrovalPages;

	@Step
	public void chooseYear(String year) {
		onWeeklyTimesheetPage.chooseYear(year);
	}

	@Step
	public void typeWeekNo(String weekNo) {
		onWeeklyTimesheetPage.typeWeekNo(weekNo);
	}

	@Step
	public void typeEmployeeCode(String employeeCode) {
		onWeeklyTimesheetPage.typeEmployeeCode(employeeCode);
	}

	@Step
	public void chooseActivity(String activity) {
		onWeeklyTimesheetPage.chooseActivity(activity);
	}

	@Step
	public void typeProject(String project, String expectedMessage,
			String ssMessageProject) throws SQLException {
		onWeeklyTimesheetPage.typeProject(project, expectedMessage,
				ssMessageProject);
	}

	@Step
	public void typeNormalHrs(String normalHrs, String timesheetDate,
			String phaseDescRemarks) {
		onWeeklyTimesheetPage.typeNormalHrs(normalHrs, timesheetDate,
				phaseDescRemarks);
	}

	@Step
	public void typeOTHrs(String oTHrs, String timesheetDate,
			String phaseDescRemarks) {
		onWeeklyTimesheetPage.typeOTHrs(oTHrs, timesheetDate, phaseDescRemarks);
	}

	@Step
	public void clickOnSubmitBtn() {
		onWeeklyTimesheetPage.clickBtn("Submit");
		onWeeklyTimesheetPage.chooseYesOnUpdateConfirmation();
		String mess = onWeeklyTimesheetPage.hasPopupMessage();
		assertThat(mess == null).isTrue();
		onWeeklyTimesheetPage.backToTimesheetScreen();
	}

	@Step
	public void backToTimesheetScreen() {
		onWeeklyTimesheetPage.backToTimesheetScreen();
	}

	public void closeProjectNoTb() {
		onWeeklyTimesheetPage.closeProjectNoTb();
	}

	@Step
	public void typeApprovingOfficer(String approvingOfficer) {
		onWeeklyTimesheetPage.typeApprovingOfficer(approvingOfficer);
	}

	public void deleteWTS(String dataBase, String employeeCode, String dateCode)
			throws SQLException {
		onWeeklyTimesheetPage.deleteWTS(dataBase, employeeCode, dateCode);
	}

	@Step
	public String generateReport(String ssMessageProject) {
		return SessionData.generateTbDataReport(ssMessageProject);
	}

	public void getWTSVoucher(String ssWTSVch) {
		onWeeklyTimesheetPage.getWTSVoucher(ssWTSVch);
	}

	@Step
	public void query(String string) {

	}

	@Step
	public void filterVchNoAndSubmit(String vchNo) {
		onWeeklyTimesheetPage.filterVchNo(vchNo);

	}

	public void clickOnPayrollTimesheet() {
		onWeeklyTimesheetPage.clickOnPayrollTimesheet();
	}

	public void verifyMessage(String ssMessageProject, int colActualMessage,
			int colExpectedMessage) {
		onWeeklyTimesheetPage.verifyMessage(ssMessageProject, colActualMessage,
				colExpectedMessage);
	}

	public boolean clickOnApproveLeaveApplication() {
		return onWeeklyTimesheetPage.clickOnApproveLeaveApplication();
	}

	public void filterLANooAndSubmit(String lANo) {
		onAprrovalPages
				.clickInQueue("Approve", "Leave Application (TH5)", lANo);
	}

	public void deleteLeaveApplication(String employeeCode) {
		onWeeklyTimesheetPage.deleteLeaveApplication(employeeCode);
	}

	public void deleteLeaveEntitlement(String leaveType) {
		onWeeklyTimesheetPage.deleteLeaveEntitlement(leaveType);
	}
}
