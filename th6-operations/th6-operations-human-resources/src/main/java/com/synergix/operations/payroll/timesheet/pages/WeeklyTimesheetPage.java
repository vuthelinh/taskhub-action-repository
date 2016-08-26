package com.synergix.operations.payroll.timesheet.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.serenitybdd.core.Serenity;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;
import com.synergix.utilities.DBConnect;
import com.synergix.utilities.SessionData;

public class WeeklyTimesheetPage extends TH6PageObject {

	public WeeklyTimesheetPage(WebDriver driver) {
		super(driver);
	}

	private String xMonthYear = "//span[@id='syn:weeklyTimesheetPanel']/table//div[@class='fc-center']";
	private String xPrevBtn = "//span[@id='syn:weeklyTimesheetPanel']/table//button[contains(@class, 'fc-prev-button')]";
	private String xNextBtn = "//span[@id='syn:weeklyTimesheetPanel']/table//button[contains(@class, 'fc-next-button')]";

	public void chooseYear(String timesheetDate) {
		String[] arrTimeSheetDate = timesheetDate.split("/");
		int month = Integer.parseInt(arrTimeSheetDate[1]);
		int year = Integer.parseInt(arrTimeSheetDate[2]);

		int curYear = getYear();
		int subYear = Math.abs(year - curYear);

		if (year < curYear) {
			for (int i = 0; i < subYear; i++) {
				$(xPrevBtn).click();
				waitABit(500);
			}
		} else if (year > curYear) {
			for (int i = 0; i < subYear; i++) {
				$(xNextBtn).click();
				waitABit(500);
			}
		}

		int curMonth = getMonth();
		int subMonth = Math.abs(month - curMonth);

		if (month > curMonth) {
			for (int i = 0; i < subMonth; i++) {
				$(xNextBtn).click();
				waitABit(500);
			}
		} else if (month < curMonth) {
			for (int i = 0; i < subMonth; i++) {
				$(xPrevBtn).click();
				waitABit(500);
			}
		}
	}

	public void typeWeekNo(String weekNo) {
		String xWeekNo = "//td[@class='fc-week-number' and child::span[text()='"
				+ weekNo + "']]";
		$(xWeekNo).click();
		waitForAllJSCompletes();
	}

	public void typeEmployeeCode(String employeeCode) {
		String xParentEmployeeList = "//table[child::thead[contains(@id, 'selectForm:selectTable')]]";
		filterDataByHeader(
				xPathTbHeaderCell(xParentEmployeeList, "Employee Code"),
				employeeCode);
		waitForAllJSCompletes();
		String xActionBtn = xParentEmployeeList
				+ "/tbody/tr[child::td[1][descendant-or-self::*[text()='"
				+ employeeCode.toUpperCase() + "']]]/td[5]/button";
		$(xActionBtn).click();
		waitForAllJSCompletes();
	}

	public void typeApprovingOfficer(String approvingOfficer) {
		enterInputFieldCodeWithLabel("Approving Officer", approvingOfficer);
	}

	private String xActivityRow;
	private String xProjectRow;
	private String description;
	private String type;
	private String xProjectRelatedTb = "//table[descendant::th[@aria-label='Activities <br/> (Project Related)']]";
	private String xInHouseTb = "//table[descendant::th[@aria-label='Activities <br/> (Project Related (In-House))']]";
	private String xNonProjectRelated = "//table[descendant::th[@aria-label='Activities/Public Holiday/Leave Types<br/>(Non-Project Related)']]";
	private boolean hasProjectNo = false;

	public void chooseActivity(String activity) {
		String sSQL = "select ACTIVITY_DESC, TYPE from MT_ACTIVITY where ACTIVITY_CODE='"
				+ activity.toUpperCase() + "'";
		DBConnect.connect("AUTO1", "172.18.0.21");
		ResultSet rs = null;
		rs = DBConnect.executeQuery(sSQL);
		try {
			while (rs.next()) {
				description = rs.getString("ACTIVITY_DESC");
				type = rs.getString("TYPE");
			}
			if (type.equals("P")) {
				xActivityRow = xProjectRelatedTb
						+ "/tbody/tr[descendant::span[text()='" + description
						+ "']]";
				String xArrowIcon = xActivityRow + "/td[1]/div";
				$(xArrowIcon).click();
				waitForAllJSCompletes();
			} else if (type.equals("I")) {
				xActivityRow = xInHouseTb
						+ "/tbody/tr[descendant::span[text()='" + description
						+ "']]";
				String xArrowIcon = xActivityRow + "/td[1]/div";
				$(xArrowIcon).click();
				waitForAllJSCompletes();
			} else if (type.equals("N")) {
				xActivityRow = xNonProjectRelated
						+ "/tbody/tr[descendant::span[text()='" + description
						+ "']]";
			}
			DBConnect.close();
		} catch (Exception ex) {
			System.out.println("Exception Occur: " + ex);
		}
	}

	public void typeProject(String project, String expectedMessage,
			String ssMessageProject) throws SQLException {
		String xProjectNoTb = "//tr[contains(@class, 'ui-expanded-row-content')]";
		String xAddPrjBtn = xProjectNoTb + "//span[1][child::button]/button";

		String actualMessage = "";
		String result = "";

		if (type.equals("P")) {
			if (isElementExist(xProjectNoTb + "//span[text()='" + project
					+ "']")) {
				hasProjectNo = true;
				$(xProjectNoTb + "//span[text()='" + project + "']/button")
						.click();
			} else {
				clickOnElement(xAddPrjBtn);
				waitForAllJSCompletes();
				String xSearchIcon = "//div[child::div[child::*[text()='Normal and OT Hours by Phase']]]//form//span[contains(@class, 'fa-search')]";
				$(xSearchIcon).click();
				waitForAllJSCompletes();
				if (!searchAndSelectByInputCode("Project No.", project)) {
					hasProjectNo = false;
					String xcloseSearchIcon = "//div[parent::div[@id='searchPanel']]//a[@href and @aria-label='Close']";
					clickOnElement(xcloseSearchIcon);
					String xCloseHoursIcon = "//div[child::div[child::*[text()='Normal and OT Hours by Phase']]]/div/a[@href]";
					clickOnElement(xCloseHoursIcon);
					waitForAllJSCompletes();
				} else
					hasProjectNo = true;
			}

		} else if (type.equals("I")) {
			if (!isElementExist(xProjectNoTb + "//input[@value='" + project
					+ "' and @role='textbox']")) {
				$(xAddPrjBtn).click();
				waitForAllJSCompletes();
				int rowIndex = getTbCountDataRow(xProjectNoTb);
				String xProjectNo = xProjectNoTb + "//tbody/tr[" + rowIndex
						+ "]/td[2]//input[@type='text']";
				$(xProjectNo).typeAndTab(project);
				actualMessage = verifyProjectNo().trim();

				if (!actualMessage.isEmpty())
					hasProjectNo = false;
				else
					hasProjectNo = true;
			}
			xProjectRow = xProjectNoTb + "//input[@value='" + project
					+ "' and @role='textbox']";
		} else if (type.equals("N"))
			hasProjectNo = true;

		System.out.println("[*** NANCY ***] Mess Actual:===" + actualMessage
				+ "===");
		if (actualMessage.equals(expectedMessage))
			result = "PASSED";
		else
			result = "FAILED";

		List<String> listMessageProject = new ArrayList<>();
		listMessageProject.addAll(Arrays.asList(project, actualMessage,
				expectedMessage, result));
		SessionData.addRowToTbDataReport(ssMessageProject, listMessageProject);
		waitForAllJSCompletes();
	}

	public void typeNormalHrs(String normalHrs, String timesheetDate,
			String phaseDescRemarks) {
		if (hasProjectNo) {
			if (type.equals("P")) {
				String xParent = "//div[child::div[child::*[text()='Normal and OT Hours by Phase']]]";
				int rowIndex;
				if (phaseDescRemarks.isEmpty()) {
					String xRowIndex = "("
							+ xParent
							+ "//tbody[preceding-sibling::thead]/tr[descendant::input])[1]";
					rowIndex = getTbRowIndexOfDataCell(xRowIndex);
				} else {
					rowIndex = findAll(
							xParent + "//table[child::thead]//tr[td[text()='"
									+ phaseDescRemarks
									+ "']]/preceding-sibling::tr").size() + 1;
				}
				int colIndex = findAll(
						xParent
								+ "//table/thead//th[descendant::*[contains(text(),'"
								+ timesheetDate + "')]]/preceding-sibling::th")
						.size();
				colIndex = colIndex * 2 - 1;
				waitTypeAndEnter(xParent + "//tbody/tr[" + rowIndex + "]/td["
						+ colIndex + "]//input", normalHrs);
			} else if (type.equals("I")) {
				int colIndex = findAll(
						"//tr[contains(@class, 'ui-expanded-row-content')]//table/thead//th[descendant::*[contains(text(),'"
								+ timesheetDate + "')]]/preceding-sibling::th")
						.size();
				colIndex = colIndex * 2 - 1;
				waitTypeAndEnter("(" + xProjectRow
						+ "/ancestor::tr)[last()]/td[" + colIndex + "]//input",
						normalHrs);
			} else if (type.equals("N")) {
				int colIndex = findAll(
						"//table[descendant::th[@aria-label='Activities/Public Holiday/Leave Types<br/>(Non-Project Related)']]/thead//th[descendant::*[contains(text(),'"
								+ timesheetDate + "')]]/preceding-sibling::th")
						.size();
				colIndex = colIndex * 2 - 1;
				waitTypeAndEnter(xActivityRow + "/td[" + colIndex + "]//input",
						normalHrs);
			}
			// waitForAllJSCompletes();
		}
	}

	public void typeOTHrs(String oTHrs, String timesheetDate,
			String phaseDescRemarks) {
		if (hasProjectNo) {
			if (type.equals("P")) {
				String xParent = "//div[child::div[child::*[text()='Normal and OT Hours by Phase']]]";
				String xCloseIcon = xParent + "/div/a[@href]";
				int rowIndex;
				if (phaseDescRemarks.isEmpty()) {
					String xRowIndex = "("
							+ xParent
							+ "//tbody[preceding-sibling::thead]/tr[descendant::input])[1]";
					rowIndex = getTbRowIndexOfDataCell(xRowIndex);
				} else {
					rowIndex = findAll(
							xParent + "//table[child::thead]//tr[td[text()='"
									+ phaseDescRemarks
									+ "']]/preceding-sibling::tr").size() + 1;
				}
				int colIndex = findAll(
						xParent
								+ "//table/thead//th[descendant::*[contains(text(),'"
								+ timesheetDate + "')]]/preceding-sibling::th")
						.size();
				colIndex = colIndex * 2;
				waitTypeAndEnter(xParent + "//tbody/tr[" + rowIndex + "]/td["
						+ colIndex + "]//input", oTHrs);
				waitForAllJSCompletes();
				$(xCloseIcon).click();
			} else if (type.equals("I")) {
				int colIndex = findAll(
						"//tr[contains(@class, 'ui-expanded-row-content')]//table/thead//th[descendant::*[contains(text(),'"
								+ timesheetDate + "')]]/preceding-sibling::th")
						.size();
				colIndex = colIndex * 2;
				waitTypeAndEnter("(" + xProjectRow
						+ "/ancestor::tr)[last()]/td[" + colIndex + "]//input",
						oTHrs);
			} else if (type.equals("N")) {
				int colIndex = findAll(
						"//table[descendant::th[@aria-label='Activities/Public Holiday/Leave Types<br/>(Non-Project Related)']]/thead//th[descendant::*[contains(text(),'"
								+ timesheetDate + "')]]/preceding-sibling::th")
						.size();
				colIndex = colIndex * 2;
				waitTypeAndEnter(xActivityRow + "/td[" + colIndex + "]//input",
						oTHrs);
			}
			// waitForAllJSCompletes();
		}
	}

	public int getYear() {
		try {
			String[] sMonthYear = $(xMonthYear + "/h2").getText().split(" ");
			return Integer.parseInt(sMonthYear[1].trim());
		} catch (Exception ex) {
			return 0;
		}
	}

	public int getMonth() {
		String[] sMonthYear = $(xMonthYear + "/h2").getText().split(" ");
		return convertMonth(sMonthYear[0].trim());
	}

	public int convertMonth(String month) {
		if (month.toLowerCase().equals("january")) {
			return 1;
		}
		if (month.toLowerCase().equals("february ")) {
			return 2;
		}
		if (month.toLowerCase().equals("march")) {
			return 3;
		}
		if (month.toLowerCase().equals("april")) {
			return 4;
		}
		if (month.toLowerCase().equals("may")) {
			return 5;
		}
		if (month.toLowerCase().equals("june")) {
			return 6;
		}
		if (month.toLowerCase().equals("july")) {
			return 7;
		}
		if (month.toLowerCase().equals("august")) {
			return 8;
		}
		if (month.toLowerCase().equals("september")) {
			return 9;
		}
		if (month.toLowerCase().equals("october")) {
			return 10;
		}
		if (month.toLowerCase().equals("november")) {
			return 11;
		}
		if (month.toLowerCase().equals("december")) {
			return 12;
		} else
			return 0;

	}

	public void backToTimesheetScreen() {
		if (isElementExist("//button[child::*[text()='Back To Summary']]")) {
			$("//button[child::*[text()='Back To Summary']]").click();
		}
		String xCloseIcon = "//span[@class='ui-dialog-title' and contains(text(), 'Employee List for Year:')]/following-sibling::a[@href]";
		$(xCloseIcon).click();
		waitForAllJSCompletes();
	}

	public void closeProjectNoTb() {
		if (!type.equals("N")) {
			String xArrowIcon = xActivityRow + "/td[1]/div";
			$(xArrowIcon).click();
		}
	}

	public String verifyProjectNo() {
		waitForAllJSCompletes();
		String xMessageProject = "//div[@id='growl_container']//div[@class='ui-growl-message']/p";
		if (isElementExist(xMessageProject)) {
			return $(xMessageProject).getText();
		} else
			return "";
	}

	public void deleteWTS(String dataBase, String employeeCode, String dateCode)
			throws SQLException {
		String nameDB = dataBase.split(">")[0].trim();
		String ipServer = dataBase.split(">")[1].trim();

		DBConnect.connect(nameDB, ipServer);
		String getVchNo = "(Select TIMESHEET_NO from PY_TIMESHEET where EMPLOYEE_CODE = '"
				+ employeeCode + "' and DATE_RANGE_CODE=" + dateCode + ")";
		ResultSet rs = DBConnect.executeQuery(getVchNo);
		String timesheetNo = "";
		while (rs.next()) {
			timesheetNo = rs.getString("TIMESHEET_NO").trim();
		}

		if (!timesheetNo.isEmpty()) {
			String del_approval1 = "DELETE FROM VH_HST_APPROVAL_OFFICER WHERE VOUCHER_NO ='"
					+ timesheetNo + "'";
			String del_approval2 = "DELETE FROM VH_OST_APPROVAL_PEND_OFFICER WHERE MODULE_CODE = 'PY' AND TRANSACTION_TYPE_CODE = 'WT' AND VOUCHER_NO = '"
					+ timesheetNo + "'";
			String del_approval3 = "DELETE FROM VH_OST_APPROVAL WHERE MODULE_CODE = 'PY' AND TRANSACTION_TYPE_CODE = 'WT' AND VOUCHER_NO = '"
					+ timesheetNo + "'";

			String sql1 = "DELETE FROM PY_TIMESHEET_DAILY_DET WHERE TIMESHEET_NO = '"
					+ timesheetNo + "'";
			String sql2 = "DELETE FROM PY_TIMESHEET_DAILY WHERE TIMESHEET_NO = '"
					+ timesheetNo + "'";
			String sql3 = "DELETE FROM PY_TIMESHEET WHERE EMPLOYEE_CODE = '"
					+ employeeCode + "' and DATE_RANGE_CODE=" + dateCode;

			DBConnect.executeUpdate(del_approval1);
			DBConnect.executeUpdate(del_approval2);
			DBConnect.executeUpdate(del_approval3);

			DBConnect.executeUpdate(sql1);
			DBConnect.executeUpdate(sql2);
			DBConnect.executeUpdate(sql3);
			DBConnect.close();
			System.out
					.println("[*** NANCY ***] Deleted successful data with Employee Code = "
							+ employeeCode
							+ ", Date Code = "
							+ dateCode
							+ ", Timesheet No. = " + timesheetNo);
		}
	}

	public void addSession(List<String> listString, String keySession) {
		listString = Serenity.sessionVariableCalled(keySession);
		listString.clear();
	}

	public void getWTSVoucher(String ssWTSVch) {
		String xVoucherNo = "//td[contains(@class, 'synfaces-grid-item')][child::div[text()='Voucher No.']]/div[2]";
		List<String> listWTSVchNo = new ArrayList<>();
		if (isElementExist(xVoucherNo)) {
			String voucherNo = $(xVoucherNo).getText().split("-")[0].trim();
			if (!voucherNo.isEmpty()) {
				listWTSVchNo = Serenity.sessionVariableCalled(ssWTSVch);
				if (listWTSVchNo == null)
					listWTSVchNo = new ArrayList<>();
				listWTSVchNo.add(voucherNo);
				Serenity.setSessionVariable(ssWTSVch).to(listWTSVchNo);
			}
		}
	}

	private String xThead = "//div[preceding-sibling::div[descendant::*[text()='Submit']] [@class='synfaces-button-bar']]//tbody[parent::table[child::thead]]";
	private String xTBody = "//div[preceding-sibling::div[descendant::*[text()='Submit']] [@class='synfaces-button-bar']]//tbody[parent::table[child::thead]]";

	public void filterVchNo(String vchNo) {
		vchNo = vchNo.trim();
		String xFilter = "//div[preceding-sibling::div[descendant::*[text()='Submit']] [@class='synfaces-button-bar']]//thead/tr/th[1]//input";
		waitTypeAndEnter(xFilter, vchNo);
		waitForAllJSCompletes();

		if (isElementExist(xTBody + "/tr[child::td[1][descendant::*[text()='"
				+ vchNo + "']]]")) {
			String xApproveOption = xTBody
					+ "/tr[child::td[1][descendant::*[text()='"
					+ vchNo
					+ "']]]//input[following-sibling::label[text()=' Approve']]";
			clickOnElement(xApproveOption);
			waitForAllJSCompletes();
			clickBtn("Submit");
			chooseYesOnUpdateConfirmation();
			if (getInfoPanelMessagesThenClickOK() == null) {
				assertThat(getErrorMessagesThenClickOK() == null).isTrue();
			}
			System.out
					.println("[*** NANCY ***] Approved Timsheet Voucher No.: "
							+ vchNo);
		}
	}

	public void clickOnPayrollTimesheet() {
		String xPayrolTimsheet = "//tbody[contains(@id, 'approvalSummaryTable_data')]/tr[descendant-or-self::*[text()='Payroll'] and descendant-or-self::*[text()='Weekly Timesheet']]";
		clickOnElement(xPayrolTimsheet);
		waitForAllJSCompletes();
	}

	public boolean clickOnApproveLeaveApplication() {
		String xInQueue = "//table[contains(@id, 'approvalSummaryTable')]/tbody/tr[descendant-or-self::*[text()='Leave Application (TH5)']]/td/*[@href]";
		waitForAllJSCompletes();
		if (isElementExist(xInQueue)) {
			clickOnElement(xInQueue);
			return true;
		}
		return false;
	}

	public void filterLANooAndSubmit(String lANo) {
		String xFilter = "//form[preceding-sibling::form[descendant::*[@value='Submit']]]//div[child::*[text()='Leave Application No.']]//input";
		lANo = lANo.trim();
		waitTypeAndEnter(xFilter, lANo);
		waitForAllJSCompletes();

		String xRowSelect = "//form[preceding-sibling::form[descendant::*[@value='Submit']]]//tbody/tr[child::td[1 and descendant::*[text()='"
				+ lANo
				+ "']]]/td[6]//td[descendant::*[text()='Approve']]/input";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			clickBtn("Submit");
			chooseYesOnUpdateConfirmation();
			if (getInfoPanelMessagesThenClickOK() == null) {
				assertThat(getErrorMessagesThenClickOK() == null).isTrue();
			}
			System.out
					.println("[*** NANCY ***] Approved Leave Application No.: "
							+ lANo);
		}
	}

	public void deleteLeaveApplication(String employeeCode) {
		DBConnect.connect("AUTO1", "172.18.0.21");
		String sql1 = "DELETE FROM LV_APPLICATION_LV_TYPE WHERE LV_APP_VOUCHER_NO in (select LV_APP_VOUCHER_NO from LV_APPLICATION where APPLICANT_CODE='"
				+ employeeCode + "')";
		String sql2 = "DELETE FROM LV_APPLICATION WHERE LV_APP_VOUCHER_NO in (select LV_APP_VOUCHER_NO from LV_APPLICATION where APPLICANT_CODE='"
				+ employeeCode + "')";

		DBConnect.executeUpdate(sql1);
		DBConnect.executeUpdate(sql2);
		DBConnect.close();
		System.out
				.println("[*** NANCY ***] Deleted Leave Application successful data with Employee Code = "
						+ employeeCode);

	}

	public void deleteLeaveEntitlement(String leaveType) {
		DBConnect.connect("AUTO1", "172.18.0.21");
		String sql1 = "DELETE FROM LV_ENTITLEMENT_LV_TYPE_EMP WHERE LEAVE_ENTITLEMENT_NO in (select LEAVE_ENTITLEMENT_NO from LV_ENTITLEMENT where LEAVE_TYPE_CODE='"
				+ leaveType + "')";
		String sql2 = "DELETE FROM LV_ENTITLEMENT WHERE LEAVE_ENTITLEMENT_NO in (select LEAVE_ENTITLEMENT_NO from LV_ENTITLEMENT where LEAVE_TYPE_CODE='"
				+ leaveType + "')";

		DBConnect.executeUpdate(sql1);
		DBConnect.executeUpdate(sql2);
		DBConnect.close();
		System.out
				.println("[*** NANCY ***] Deleted Leave Entitlement successful data with Leave Type = "
						+ leaveType);

	}
}
