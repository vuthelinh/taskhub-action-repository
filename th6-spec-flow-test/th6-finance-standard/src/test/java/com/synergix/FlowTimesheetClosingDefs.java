package com.synergix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.operations.payroll.timesheet.steps.TimesheetClosingSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class FlowTimesheetClosingDefs {

	@Steps
	TimesheetClosingSteps onTimesheetClosingSteps;

	private String ssMessageEmail = "TSC Message Email";

	private String ssSubmit = "TSC Expected Submit";
	private String ssSendEmail = "TSC Expected Send Email";
	private String ssExpectedResult = "TSC Expected Result";

	@When("^user fill data for timesheet closing$")
	public void user_fill_data_for_timesheet_closing(
			List<List<String>> dataTable) {
		String dataTableKey = "TimesheetClosing";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colFrom = "From";
		String colTo = "To";
		String colPostingDate = "Posting Date";
		String colEmployee = "Employee";

		for (int rowTimesheetClosing : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String from = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colFrom);
			String to = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colTo);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colPostingDate);
			String employee = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colEmployee);

			if (!from.isEmpty()) {
				onTimesheetClosingSteps.typeFrom(from);
			}
			if (!to.isEmpty()) {
				onTimesheetClosingSteps.typeTo(to);
			}
			if (!postingDate.isEmpty()) {
				onTimesheetClosingSteps.typePostingDate(postingDate);
			}
			if (!employee.isEmpty()) {
				onTimesheetClosingSteps.typeEmployee(employee);
			}
		}
	}

	@When("^user fill data then send email for timesheet closing$")
	public void user_fill_data_then_send_email_for_timesheet_closing(
			List<List<String>> dataTable) {
		String dataTableKey = "TimesheetClosing1";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colFrom = "From";
		String colTo = "To";
		String colPostingDate = "Posting Date";
		String colEmployee = "Employee";
		String colExpectedMessage = "Expected Message";

		String expectedMessage = "";
		List<String> listMesgEmail = new ArrayList<String>();
		listMesgEmail.addAll(Arrays.asList("From", "To", "Employee",
				"Actual Message", "Expected Message", "Result"));
		SessionData.addRowToTbDataReport(ssMessageEmail, listMesgEmail);

		for (int rowTimesheetClosing : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			List<String> listTemp = new ArrayList<>();

			String from = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colFrom);
			String to = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colTo);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colPostingDate);
			String employee = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colEmployee);
			expectedMessage = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colExpectedMessage);

			if (!from.isEmpty()) {
				onTimesheetClosingSteps.typeFrom(from);
			}
			if (!to.isEmpty()) {
				onTimesheetClosingSteps.typeTo(to);
			}
			if (!postingDate.isEmpty()) {
				onTimesheetClosingSteps.typePostingDate(postingDate);
			}
			if (!employee.isEmpty()) {
				onTimesheetClosingSteps.typeEmployee(employee);
				onTimesheetClosingSteps.chooseSendMailForEmployee(employee);
			}
			String actualMessage = onTimesheetClosingSteps
					.clickOnSendMailBtnAndReturnMesg();
			String result = "";
			if (actualMessage.equals(expectedMessage))
				result = "PASSED";
			else
				result = "FAILED";
			listTemp.addAll(Arrays.asList(from, to, employee, actualMessage,
					expectedMessage, result));
			SessionData.addRowToTbDataReport(ssMessageEmail, listTemp);
		}
		onTimesheetClosingSteps.query(SessionData.generateTbDataReport(
				ssMessageEmail).toString());
		onTimesheetClosingSteps.verify(ssMessageEmail, 3, 4);
	}

	@When("^user fill data then send email and submit for timesheet closing$")
	public void user_fill_data_then_send_email_and_submit_for_timesheet_closing(
			List<List<String>> dataTable) {
		String dataTableKey = "TimesheetClosing2";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colFrom = "From";
		String colTo = "To";
		String colPostingDate = "Posting Date";
		String colEmployee = "Employee";
		String colExpectedSendEmail = "Expected Send Email";
		String colExpectedSubmit = "Expected Submit";

		List<String> listReportSendEmail = new ArrayList<String>();
		List<String> listReportSubmit = new ArrayList<>();

		listReportSendEmail.addAll(Arrays.asList("From", "To", "Employee",
				"Actual Send Email", "Expected Send Email", "Result"));
		listReportSubmit.addAll(Arrays.asList("From", "To", "Employee",
				"Actual Submit", "Expected Submit", "Result"));

		SessionData.addRowToTbDataReport(ssSendEmail, listReportSendEmail);
		SessionData.addRowToTbDataReport(ssSubmit, listReportSubmit);

		for (int rowTimesheetClosing : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String from = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colFrom);
			String to = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colTo);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colPostingDate);
			String employee = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colEmployee);
			String expectedSendEmail = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colExpectedSendEmail);
			String expectedSubmit = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colExpectedSubmit);

			if (!from.isEmpty()) {
				onTimesheetClosingSteps.typeFrom(from);
				from = onTimesheetClosingSteps.convertDate(from);
			}
			if (!to.isEmpty()) {
				onTimesheetClosingSteps.typeTo(to);
				to = onTimesheetClosingSteps.convertDate(to);
			}
			if (!postingDate.isEmpty()) {
				onTimesheetClosingSteps.typePostingDate(postingDate);
			}
			if (!employee.isEmpty()) {
				onTimesheetClosingSteps.typeEmployee(employee);
				onTimesheetClosingSteps.chooseSendMailForEmployee(employee);
			}
			expectedSubmit = expectedSubmit.replace("^$1", from).replace("^$2",
					to);

			String actualMessageEmail = onTimesheetClosingSteps
					.clickOnSendMailBtnAndReturnMesg();
			String actualMessageSubmit = onTimesheetClosingSteps
					.clickOnSubmitBtnAndReturnMesg();
			String result1, result2;
			if (actualMessageEmail.equals(expectedSendEmail))
				result1 = "PASSED";
			else
				result1 = "FAILED";

			if (actualMessageSubmit.equals(expectedSubmit))
				result2 = "PASSED";
			else
				result2 = "FAILED";

			List<String> listReportSendEmail1 = new ArrayList<>();
			List<String> listReportSubmit1 = new ArrayList<>();

			listReportSendEmail1.addAll(Arrays.asList(from, to, employee,
					actualMessageEmail, expectedSendEmail, result1));
			listReportSubmit1.addAll(Arrays.asList(from, to, employee,
					actualMessageSubmit, expectedSubmit, result2));

			SessionData.addRowToTbDataReport(ssSubmit, listReportSubmit1);
			SessionData.addRowToTbDataReport(ssSendEmail, listReportSendEmail1);
		}
		onTimesheetClosingSteps.query(SessionData.generateTbDataReport(
				ssSendEmail).toString());
		onTimesheetClosingSteps.query(SessionData
				.generateTbDataReport(ssSubmit).toString());
		onTimesheetClosingSteps.verify(ssSendEmail, 3, 4);
		onTimesheetClosingSteps.verify(ssSubmit, 3, 4);
	}

	@When("^user fill data without employee then submit for timesheet closing$")
	public void user_fill_data_without_employee_then_submit_for_timesheet_closing(
			List<List<String>> dataTable) {
		String dataTableKey = "TimesheetClosing3";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colFrom = "From";
		String colTo = "To";
		String colPostingDate = "Posting Date";
		String colExpectedSubmit = "Expected Submit";

		List<String> listMesg = new ArrayList<String>();
		listMesg.addAll(Arrays.asList("From", "To", "Actual Message",
				"Expected Message", "Result"));
		SessionData.addRowToTbDataReport(ssExpectedResult, listMesg);

		for (int rowTimesheetClosing : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String from = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colFrom);
			String to = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colTo);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colPostingDate);
			String expectedResult = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colExpectedSubmit);

			if (!from.isEmpty()) {
				onTimesheetClosingSteps.typeFrom(from);
				from = onTimesheetClosingSteps.convertDate(from);
			}
			if (!to.isEmpty()) {
				onTimesheetClosingSteps.typeTo(to);
				to = onTimesheetClosingSteps.convertDate(to);
			}
			if (!postingDate.isEmpty()) {
				onTimesheetClosingSteps.typePostingDate(postingDate);
			}

			String actualMessage = onTimesheetClosingSteps
					.clickOnSubmitBtnAndReturnMesg();
			expectedResult = expectedResult.replace("^$1", from).replace("^$2",
					to);
			String result;
			if (actualMessage.equals(expectedResult))
				result = "PASSED";
			else
				result = "FAILED";
			List<String> listReport = new ArrayList<>();
			listReport.addAll(Arrays.asList(from, to, actualMessage,
					expectedResult, result));
			SessionData.addRowToTbDataReport(ssExpectedResult, listReport);
		}
		onTimesheetClosingSteps.query(SessionData.generateTbDataReport(
				ssExpectedResult).toString());
		onTimesheetClosingSteps.verify(ssExpectedResult, 2, 3);
	}

	@When("^user fill data then submit for timesheet closing$")
	public void user_fill_data_then_submit_for_timesheet_closing(
			List<List<String>> dataTable) {
		String dataTableKey = "TimesheetClosing4";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colFrom = "From";
		String colTo = "To";
		String colPostingDate = "Posting Date";
		String colEmployee = "Employee";
		String colExpectedSubmit = "Expected Submit";

		List<String> listMesg = new ArrayList<String>();
		List<String> listVerify = new ArrayList<>();

		for (int rowTimesheetClosing : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String from = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colFrom);
			String to = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colTo);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colPostingDate);
			String employee = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colEmployee);
			String expectedSubmit = SessionData.getDataTbVal(dataTableKey,
					rowTimesheetClosing, colExpectedSubmit);

			if (!from.isEmpty()) {
				onTimesheetClosingSteps.typeFrom(from);
				from = onTimesheetClosingSteps.convertDate(from);
			}
			if (!to.isEmpty()) {
				onTimesheetClosingSteps.typeTo(to);
				to = onTimesheetClosingSteps.convertDate(to);
			}
			if (!postingDate.isEmpty()) {
				onTimesheetClosingSteps.typePostingDate(postingDate);
			}
			if (!employee.isEmpty()) {
				onTimesheetClosingSteps.typeEmployee(employee);
			}

			String sVerifySubmit = "";
			String mesgSubmit = onTimesheetClosingSteps
					.clickOnSubmitBtnAndReturnMesg();

			listMesg.add(mesgSubmit);
			listVerify.add(sVerifySubmit);
		}
		onTimesheetClosingSteps.verifyMesg(listMesg, listVerify);
	}
}
