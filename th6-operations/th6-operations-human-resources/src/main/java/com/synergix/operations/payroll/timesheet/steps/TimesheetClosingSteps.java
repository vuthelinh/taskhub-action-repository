package com.synergix.operations.payroll.timesheet.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.operations.payroll.timesheet.pages.TimesheetClosingPage;

public class TimesheetClosingSteps extends ScenarioSteps {

	TimesheetClosingPage onTimesheetClosingPage;

	@Step
	public void typeFrom(String from) {
		onTimesheetClosingPage.typeFrom(from);
	}

	@Step
	public void typeTo(String to) {
		onTimesheetClosingPage.typeTo(to);
	}

	@Step
	public void typePostingDate(String postingDate) {
		onTimesheetClosingPage.typePostingDate(postingDate);
	}

	@Step
	public void typeEmployee(String employee) {
		onTimesheetClosingPage.typeEmployee(employee);
	}

	@Step
	public void chooseSendMailForEmployee(String employee) {
		onTimesheetClosingPage.chooseSendMailForEmployee(employee);
	}

	@Step
	public String clickOnSendMailBtnAndReturnMesg() {
		return onTimesheetClosingPage.clickOnSendMailBtnAndReturnMesg();
	}

	@Step
	public void verifyMesg(List<String> listMesg, List<String> listVerify) {
		onTimesheetClosingPage.verifyMesg(listMesg, listVerify);
	}

	@Step
	public void verifyMesg(List<String> listMesg, String sVerify) {
		onTimesheetClosingPage.verifyMesg(listMesg, sVerify);
	}

	public String clickOnSubmitBtnAndReturnMesg() {
		return onTimesheetClosingPage.clickOnSubmitBtnAndReturnMesg();
	}

	public String convertDate(String date) {
		return onTimesheetClosingPage.convertDate(date, 1);
	}

	@Step
	public void query(String a) {
	}

	@Step
	public void verify(String sessionKey, int colActual, int colExpected) {
		onTimesheetClosingPage
				.verifyMessage(sessionKey, colActual, colExpected);
	}

}
