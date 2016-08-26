package com.synergix.operations.leave.processing.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.operations.leave.processing.pages.LeaveApplicationPage;

public class LeaveApplicationSteps extends ScenarioSteps {

	LeaveApplicationPage onLeaveApplicationPage;

	@Step
	public void chooseApplicant(String applicant) {
		onLeaveApplicationPage.chooseApplicant(applicant);
	}

	@Step
	public void typeApplicationDate(String applicationDate) {
		onLeaveApplicationPage.typeApplicationDate(applicationDate);
	}

	@Step
	public void typeSBU(String sBU) {
		onLeaveApplicationPage.typeSBU(sBU);
	}

	public void switchToIFrame() {
		onLeaveApplicationPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onLeaveApplicationPage.switchOutDefaultIFrame();
	}

	public void clickOnSubmitBtn() {
		onLeaveApplicationPage.clickBtn("Submit");
		onLeaveApplicationPage.chooseYesOnUpdateConfirmation();
		onLeaveApplicationPage.waitForAllJSCompletes();
	}

	public void clickOnNewBtn() {
		onLeaveApplicationPage.clickBtn("New");
		onLeaveApplicationPage.waitForAllJSCompletes();
	}

	public void searchLeaveApplication(String leaveAppNo) {
		onLeaveApplicationPage.searchLeaveApplication(leaveAppNo);
	}

	public void clickOnAddBtn() {
		onLeaveApplicationPage.clickBtn("Add");
		onLeaveApplicationPage.waitForAllJSCompletes();
	}

	@Step
	public void typeLeaveType(String leaveType, int rowIndex) {
		onLeaveApplicationPage.typeLeaveType(leaveType, rowIndex);
	}

	@Step
	public void typeDateFrom(String dateFrom, int rowIndex) {
		onLeaveApplicationPage.typeDateFrom(dateFrom, rowIndex);
	}

	@Step
	public void typeDateTo(String dateTo, int rowIndex) {
		onLeaveApplicationPage.typeDateTo(dateTo, rowIndex);
	}

	@Step
	public void typeDurationType(String durationType, int rowIndex) {
		onLeaveApplicationPage.typeDurationType(durationType, rowIndex);
	}

	public int getRowIndex(String leaveType) {
		return onLeaveApplicationPage.getRowIndex(leaveType);
	}

	public void getLANo(String ssLANo) {
		onLeaveApplicationPage.getLANo(ssLANo);
	}

}
