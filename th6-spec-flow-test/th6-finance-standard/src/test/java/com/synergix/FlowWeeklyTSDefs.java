package com.synergix;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import com.synergix.common.actions.PageSteps;
import com.synergix.globalsetup.leave.steps.LeaveTypeSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplCompanyTabSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplEmploymentInfoDurationTabSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplLocalInfoTabSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplParticularsTabSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.DesignationSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.EmployeeSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.TimesheetActivitySteps;
import com.synergix.mtsetup.moduleconfig.steps.ModuleConfigSteps;
import com.synergix.operations.leave.processing.steps.LeaveApplicationSteps;
import com.synergix.operations.leave.processing.steps.LeaveEntitlementSteps;
import com.synergix.operations.payroll.timesheet.steps.WeeklyTimesheetSteps;
import com.synergix.processing.project.quotationorder.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class FlowWeeklyTSDefs {
	@Steps
	ModuleConfigSteps onModuleConfigSteps;
	@Steps
	TimesheetActivitySteps onTimesheetActivitySteps;
	@Steps
	DesignationSteps onDesignationSteps;

	// STEP EMPLOYEE
	@Steps
	EmplEmploymentInfoDurationTabSteps onEmploymentInfoDurationTabSteps;
	@Steps
	EmplLocalInfoTabSteps onLocalInfoTabSteps;
	@Steps
	EmplParticularsTabSteps onParticularsTabSteps;
	@Steps
	EmployeeSteps onEmployeeSteps;
	@Steps
	EmplCompanyTabSteps onCompanyTabSteps;
	// **********************************

	@Steps
	LeaveTypeSteps onLeaveTypeSteps;
	@Steps
	LeaveEntitlementSteps onLeaveEntitlementSteps;
	@Steps
	ProjectEstimationSteps projectEstimationSteps;
	@Steps
	LeaveApplicationSteps onLeaveApplicationSteps;
	@Steps
	WeeklyTimesheetSteps onWeeklyTimesheetSteps;

	@Steps
	PageSteps onPageSteps;

	private String ssLANo = "LANo";
	private String ssWTSVch = "WTSVchNo";

	// MODULE CONFIG OPTION
	@Given("^set module config option for TS$")
	public void set_module_config_option_for_TS(List<List<String>> dataTable) {
		String dataTableKey = "WTS_ModuleConfig";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colTab = "Tab";
		String colModuleConfiguration = "Module Configuration";
		String colValue = "Value";

		onModuleConfigSteps.switchToIFrame();
		for (int row : SessionData.getDataTbRowsNoHeader("WTS_ModuleConfig")
				.keySet()) {
			String tab = SessionData.getDataTbVal(dataTableKey, row, colTab);
			String moduleConfiguration = SessionData.getDataTbVal(dataTableKey,
					row, colModuleConfiguration);
			String value = SessionData
					.getDataTbVal(dataTableKey, row, colValue);

			onModuleConfigSteps.moveToTab(tab);
			onModuleConfigSteps.chooseModuleConfiguration(tab,
					moduleConfiguration, value);
		}
		onModuleConfigSteps.switchOutDefaultIFrame();
	}

	// ACTIVITY TIMESHEET
	@When("^user create activity$")
	public void user_create_activity(List<List<String>> dataTable) {
		String dataTableKey = "WTS_Activity";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colActivityCode = "Activity Code";
		String colActivityDescription = "Activity Description";
		String colDetailDescription = "Detail Description";
		String colCompany = "Company";
		String colType = "Type";

		for (int rowWTS_Activity : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String activityCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Activity, colActivityCode);
			String activityDescription = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Activity, colActivityDescription);
			String detailDescription = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Activity, colDetailDescription);
			String type = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Activity, colType);
			String company = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Activity, colCompany);

			onTimesheetActivitySteps.clickOnNewBtn();

			if (!activityCode.isEmpty()) {
				onTimesheetActivitySteps.typeActivityCode(activityCode);
			}
			if (!activityDescription.isEmpty()) {
				onTimesheetActivitySteps
						.typeActivityDescription(activityDescription);
			}
			if (!detailDescription.isEmpty()) {
				onTimesheetActivitySteps
						.typeDetailDescription(detailDescription);
			}
			if (!type.isEmpty()) {
				onTimesheetActivitySteps.chooseType(" " + type);
			}
			if (!company.isEmpty()) {
				onTimesheetActivitySteps.moveToCompanyTab();
				if (company.toLowerCase().equals("all"))
					onTimesheetActivitySteps.chooseAllCompany();
				else
					onTimesheetActivitySteps.chooseCompany(company);
			}
			onTimesheetActivitySteps.clickOnUpdateBtn();
		}

	}

	@When("^user delete timesheet activity$")
	public void the_user_delete_Timesheet_Activity(List<List<String>> dataTable) {
		String dataTableKey = "WTS_Del_TSActivity";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colActivityCode = "Activity Code";
		for (int rowWTS_LeaveType : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String activityCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colActivityCode);

			if (!activityCode.isEmpty()) {
				onTimesheetActivitySteps.deleteTSActivity(activityCode);
			}
		}

	}

	// DESIGNATION
	@Given("^user create designation as \"([^\"]*)\"$")
	public void user_create_Designation_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_Designation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colDesignationCode = "Designation Code";
		String colDesignationDescription = "Designation Description";
		String colCompany = "Company";

		for (int rowWTS_Designation : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, "Key", dataKey).keySet()) {
			String designationCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Designation, colDesignationCode);
			String designationDescription = SessionData
					.getDataTbVal(dataTableKey, rowWTS_Designation,
							colDesignationDescription);
			String company = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Designation, colCompany);

			onDesignationSteps.clickOnNewBtn();
			if (!designationCode.isEmpty()) {
				onDesignationSteps.typeDesignationCode(designationCode);
			}
			if (!designationDescription.isEmpty()) {
				onDesignationSteps
						.typeDesignationDescription(designationDescription);
			}
			if (!company.isEmpty()) {
				onDesignationSteps.moveToCompanyTab();
				if (company.toLowerCase().equals("all"))
					onDesignationSteps.chooseAllCompany();
				else
					onDesignationSteps.chooseCompany(company);
			}
			onDesignationSteps.clickOnUpdateBtn();
		}

	}

	@Given("^designation is created with local info as \"([^\"]*)\"$")
	public void designation_is_created_with_local_info_as(String dataKey,
			List<List<String>> dataTable) throws ParseException {
		String dataTableKey = "WTS_Deatil_Designation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colEffectiveDateFrom = "Effective Date From";
		String colNormalHourlyRate = "Normal Hourly Rate";
		String colOTHourlyRate = "OT Hourly Rate";

		onDesignationSteps.moveToLocalInfoTab();

		List<List<String>> listHourlyDate = new ArrayList<>();
		for (int rowWTS_Designation : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, "Key", dataKey).keySet()) {

			String effectiveDateFrom = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Designation, colEffectiveDateFrom);
			String normalHourlyRate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Designation, colNormalHourlyRate);
			String oTHourlyRate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Designation, colOTHourlyRate);

			if (!effectiveDateFrom.isEmpty() && !normalHourlyRate.isEmpty()
					&& !oTHourlyRate.isEmpty()) {
				listHourlyDate.add(Arrays.asList(effectiveDateFrom,
						normalHourlyRate, oTHourlyRate));
			}
		}

		for (int j = 0; j < listHourlyDate.size(); j++) {
			onDesignationSteps.clickOnAddIcon();
			onDesignationSteps.typeEffectiveDateFrom(
					listHourlyDate.get(j).get(0), j + 1);

			if (j == listHourlyDate.size() - 1) {
				onDesignationSteps.typeEffectiveDateTo("", j + 1);
			} else {
				onDesignationSteps.typeEffectiveDateTo(listHourlyDate
						.get(j + 1).get(0), j + 1);
			}
			onDesignationSteps.typeNormalHourlyRate(listHourlyDate.get(0)
					.get(1), j + 1);
			onDesignationSteps.typeOTHourlyRate(listHourlyDate.get(0).get(2),
					j + 1);

		}
		onDesignationSteps.clickOnUpdateBtn();
	}

	@When("^user delete designation$")
	public void the_user_delete_Designation(List<List<String>> dataTable) {
		String dataTableKey = "WTS_Del_Designation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colDesignationCode = "Designation Code";
		for (int rowWTS_LeaveType : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String designationCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colDesignationCode);

			if (!designationCode.isEmpty()) {
				onDesignationSteps.deleteDesignation(designationCode);
			}
		}

	}

	// EMPLOYEE
	@Given("^user create employee as \"([^\"]*)\"$")
	public void user_create_employee_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_Employee";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colEmployeeCode = "Employee Code";
		String colEmployeeName = "Employee Name";
		String colCompany = "Company";

		for (int rowWTS_Employee : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, "Key Emp", dataKey).keySet()) {
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Employee, colEmployeeCode);
			String employeeName = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Employee, colEmployeeName);
			String company = SessionData.getDataTbVal(dataTableKey,
					rowWTS_Employee, colCompany);

			onEmployeeSteps.clickOnNewBtn();
			if (!employeeCode.isEmpty()) {
				onEmployeeSteps.typeEmployeeCode(employeeCode);
			}
			if (!employeeName.isEmpty()) {
				onEmployeeSteps.typeEmployeeName(employeeName);
			}
			if (!company.isEmpty()) {
				onCompanyTabSteps.moveToCompanyTab();
				if (company.toLowerCase().equals("all")) {
					onCompanyTabSteps.chooseAllCompany();
				} else
					onCompanyTabSteps.chooseCompany(company);
			}
		}
	}

	@Given("^employees is created with particulars info as \"([^\"]*)\"$")
	public void the_Employees_is_created_with_Particulars_info_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "WTS_EmployeeParticular";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colDateofBirth = "Date of Birth";
		onEmployeeSteps.moveToParticularsTab();
		for (int rowWTS_EmployeeParticular : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key Emp", dataKey)
				.keySet()) {
			String dateofBirth = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeParticular, colDateofBirth);
			if (!dateofBirth.isEmpty()) {
				onParticularsTabSteps.typeDateofBirth(dateofBirth);
			}
		}
	}

	@Given("^employees is created with employment info as \"([^\"]*)\"$")
	public void the_Employees_is_created_with_Employment_Info_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "WTS_EmployeeInfo";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colDesignationEffectiveDate = "Designation Effective Date";
		String colDesignation = "Designation";
		onEmploymentInfoDurationTabSteps.moveToEmploymentInfoDurationTab();
		onEmploymentInfoDurationTabSteps.clickOnDesignationIcon();
		for (int rowWTS_EmployeeInfo : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key Emp", dataKey)
				.keySet()) {
			String designationEffectiveDate = SessionData.getDataTbVal(
					dataTableKey, rowWTS_EmployeeInfo,
					colDesignationEffectiveDate);
			String designation = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeInfo, colDesignation);

			if (!designationEffectiveDate.isEmpty()) {
				onEmploymentInfoDurationTabSteps
						.typeDesignationEffectiveDate(designationEffectiveDate);
			}
			if (!designation.isEmpty()) {
				onEmploymentInfoDurationTabSteps.typeDesignation(designation);
			}
			onEmploymentInfoDurationTabSteps.clickOnSubmitDesignationBtn();
		}
		onEmploymentInfoDurationTabSteps.clickOnCloseDesignationIcon();
	}

	@Given("^employees is created with employment duration as \"([^\"]*)\"$")
	public void the_Employees_is_created_with_Employment_Duration_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "WTS_EmployeeDuration";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colJoinDate = "Join Date";
		String colCompanyCode = "Company Code";
		int rowIndex;
		onEmploymentInfoDurationTabSteps.moveToEmploymentInfoDurationTab();
		for (int rowWTS_EmployeeDuration : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key Emp", dataKey)
				.keySet()) {
			String joinDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeDuration, colJoinDate);
			String companyCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeDuration, colCompanyCode);
			onEmploymentInfoDurationTabSteps.clickOnAddDurationBtn();
			rowIndex = onEmploymentInfoDurationTabSteps.countRowDurationTbl();
			if (!joinDate.isEmpty()) {
				onEmploymentInfoDurationTabSteps.typeJoinDate(joinDate,
						rowIndex);
			}
			if (!companyCode.isEmpty()) {
				onEmploymentInfoDurationTabSteps.typeCompanyCode(companyCode,
						rowIndex);
			}
		}
	}

	@Given("^employees is created with local info hr tab as \"([^\"]*)\"$")
	public void the_Employees_is_created_with_Local_Info_HR_Tab_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "WTS_EmployeeHR";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colSat = "Sat";
		String colTotalWorkingHoursPerDay = "Total Working Hours Per Day";
		String colTotalWorkingHoursPerWeek = "Total Working Hours Per Week";
		String colAMTimeFrom = "AM Time From";
		String colAMTimeTo = "AM Time To";
		String colPMTimeFrom = "PM Time From";
		String colPMTimeTo = "PM Time To";
		String colSalaryTypeEffectiveDate = "Salary Type Effective Date";
		String colSalaryType = "Salary Type";
		String colRelatedToTimesheet = "Related To Timesheet";
		String colPaymentCycle = "Payment Cycle";
		String colEPCEffectiveDate = "EPC Effective Date";
		String colEPC = "EPC";
		String colGraceEffectiveDate = "Grace Effective Date";
		String colGrace = "Grace";
		onLocalInfoTabSteps.moveToLocalInfoTab();
		for (int rowWTS_EmployeeHR : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, "Key Emp", dataKey).keySet()) {
			String sat = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colSat);
			String totalWorkingHoursPerDay = SessionData
					.getDataTbVal(dataTableKey, rowWTS_EmployeeHR,
							colTotalWorkingHoursPerDay);
			String totalWorkingHoursPerWeek = SessionData.getDataTbVal(
					dataTableKey, rowWTS_EmployeeHR,
					colTotalWorkingHoursPerWeek);
			String aMTimeFrom = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colAMTimeFrom);
			String aMTimeTo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colAMTimeTo);
			String pMTimeFrom = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colPMTimeFrom);
			String pMTimeTo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colPMTimeTo);
			String salaryTypeEffectiveDate = SessionData
					.getDataTbVal(dataTableKey, rowWTS_EmployeeHR,
							colSalaryTypeEffectiveDate);
			String salaryType = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colSalaryType);
			String relatedToTimesheet = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colRelatedToTimesheet);
			String paymentCycle = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colPaymentCycle);
			String ePCEffectiveDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colEPCEffectiveDate);
			String ePC = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colEPC);
			String graceEffectiveDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colGraceEffectiveDate);
			String grace = SessionData.getDataTbVal(dataTableKey,
					rowWTS_EmployeeHR, colGrace);

			if (!salaryTypeEffectiveDate.isEmpty() && !salaryType.isEmpty()) {
				onLocalInfoTabSteps.chooseSalaryType(salaryTypeEffectiveDate,
						salaryType);
			}
			if (!relatedToTimesheet.isEmpty()) {
				onLocalInfoTabSteps
						.chooseRelatedToTimesheet(relatedToTimesheet);
			}

			if (!paymentCycle.isEmpty()) {
				onLocalInfoTabSteps.typePaymentCycle(paymentCycle);
			}
			if (!ePCEffectiveDate.isEmpty() && !ePC.isEmpty()) {
				onLocalInfoTabSteps.typeEPC(ePC, ePCEffectiveDate);
			}
			if (!graceEffectiveDate.isEmpty() && !grace.isEmpty()) {
				onLocalInfoTabSteps.typeGrace(grace, graceEffectiveDate);
			}

			if (!sat.isEmpty()) {
				onLocalInfoTabSteps.chooseDesignatedWorkingDays("Sat", sat);
			}
			if (!totalWorkingHoursPerDay.isEmpty()) {
				onLocalInfoTabSteps
						.typeTotalWorkingHoursPerDay(totalWorkingHoursPerDay);
			}
			if (!totalWorkingHoursPerWeek.isEmpty()) {
				onLocalInfoTabSteps
						.typeTotalWorkingHoursPerWeek(totalWorkingHoursPerWeek);
			}
			if (!aMTimeFrom.isEmpty()) {
				onLocalInfoTabSteps.typeAMTimeFrom(aMTimeFrom);
			}
			if (!aMTimeTo.isEmpty()) {
				onLocalInfoTabSteps.typeAMTimeTo(aMTimeTo);
			}
			if (!pMTimeFrom.isEmpty()) {
				onLocalInfoTabSteps.typePMTimeFrom(pMTimeFrom);
			}
			if (!pMTimeTo.isEmpty()) {
				onLocalInfoTabSteps.typePMTimeTo(pMTimeTo);
			}
		}
	}

	@Given("^employee is updated$")
	public void the_Employee_is_updated() {
		onEmployeeSteps.clickOnUpdateBtn();
	}

	@When("^user delete employee$")
	public void the_user_delete_Employee(List<List<String>> dataTable) {
		String dataTableKey = "WTS_Del_Employee";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colEmployeeCode = "Employee Code";
		for (int rowWTS_LeaveType : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colEmployeeCode);

			if (!employeeCode.isEmpty()) {
				onEmployeeSteps.deleteEmployee(employeeCode);
			}
		}

	}

	// LEAVE TYPE
	@Given("^user create leave type$")
	public void user_create_leave_type(List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveType";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colLeavetypecode = "Leave type code";
		String colDescription = "Description";
		String colExcludeNonworkingDays = "Exclude Non-working Days";
		String colPaidLeave = "Paid Leave";
		String colDeductSalary = "Deduct Salary";
		String colEncashmentUponResignation = "Encashment Upon Resignation";
		String colLeaveEncashmentOnEarnBasis = "Leave Encashment On Earn Basis";
		String colEntitlementonEarnBasis = "Entitlement on Earn Basis";
		String colCutoffDatefor1stMthEntitlement = "Cut-off Date for 1st Mth Entitlement";
		String colProrateExpectedLeaveEntitlement = "Prorate Expected Leave Entitlement";
		String colChildcareLeave = "Childcare Leave";
		String colTypeofChildcareLeave = "Type of Childcare Leave";
		String colCarriedForwardToNextYear = "Carried Forward To Next Year";
		String colMaxNoofDaysCarriedForward = "Max. No. of Days Carried Forward";
		String colValidityofCarriedForwardLeave = "Validity of Carried Forward Leave";
		String colDeductonedayifleavetakenonhalfworkingday = "Deduct one day if leave taken on half working day";
		String colPayHourlyRateEmployeeifleaveisapplied = "Pay Hourly Rate Employee if leave is applied";
		String colSetCompanyDeclaredHolidayasNonworkingdays = "Set Company Declared Holiday as Non-working days";
		String colDeductCondition = "Deduct Condition";
		String colDeductConditionCalendarDay = "Deduct Condition Calendar Day";
		String colCompany = "Company";

		onLeaveTypeSteps.switchToIFrame();
		for (int rowWTS_LeaveType : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String leavetypecode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colLeavetypecode);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colDescription);
			String excludeNonworkingDays = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType, colExcludeNonworkingDays);
			String paidLeave = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colPaidLeave);
			String deductSalary = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colDeductSalary);
			String encashmentUponResignation = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colEncashmentUponResignation);
			String leaveEncashmentOnEarnBasis = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colLeaveEncashmentOnEarnBasis);
			String entitlementonEarnBasis = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType, colEntitlementonEarnBasis);
			String cutoffDatefor1stMthEntitlement = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colCutoffDatefor1stMthEntitlement);
			String prorateExpectedLeaveEntitlement = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colProrateExpectedLeaveEntitlement);
			String childcareLeave = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colChildcareLeave);
			String typeofChildcareLeave = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType, colTypeofChildcareLeave);
			String carriedForwardToNextYear = SessionData
					.getDataTbVal(dataTableKey, rowWTS_LeaveType,
							colCarriedForwardToNextYear);
			String maxNoofDaysCarriedForward = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colMaxNoofDaysCarriedForward);
			String validityofCarriedForwardLeave = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colValidityofCarriedForwardLeave);
			String deductonedayifleavetakenonhalfworkingday = SessionData
					.getDataTbVal(dataTableKey, rowWTS_LeaveType,
							colDeductonedayifleavetakenonhalfworkingday);
			String payHourlyRateEmployeeifleaveisapplied = SessionData
					.getDataTbVal(dataTableKey, rowWTS_LeaveType,
							colPayHourlyRateEmployeeifleaveisapplied);
			String setCompanyDeclaredHolidayasNonworkingdays = SessionData
					.getDataTbVal(dataTableKey, rowWTS_LeaveType,
							colSetCompanyDeclaredHolidayasNonworkingdays);
			String deductCondition = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colDeductCondition);
			String deductConditionCalendarDay = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveType,
					colDeductConditionCalendarDay);
			String company = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colCompany);

			onLeaveTypeSteps.clickOnNewBtn();

			if (!leavetypecode.isEmpty()) {
				onLeaveTypeSteps.typeLeavetypecode(leavetypecode);
			}
			if (!description.isEmpty()) {
				onLeaveTypeSteps.typeDescription(description);
			}
			if (!excludeNonworkingDays.isEmpty()) {
				onLeaveTypeSteps
						.chooseExcludeNonworkingDays(excludeNonworkingDays);
			}
			if (!paidLeave.isEmpty()) {
				onLeaveTypeSteps.choosePaidLeave(paidLeave);
			}
			if (!deductSalary.isEmpty()) {
				onLeaveTypeSteps.chooseDeductSalary(deductSalary);
			}
			if (!encashmentUponResignation.isEmpty()) {
				onLeaveTypeSteps
						.chooseEncashmentUponResignation(encashmentUponResignation);
			}
			if (!leaveEncashmentOnEarnBasis.isEmpty()) {
				onLeaveTypeSteps
						.chooseLeaveEncashmentOnEarnBasis(leaveEncashmentOnEarnBasis);
			}
			if (!entitlementonEarnBasis.isEmpty()) {
				onLeaveTypeSteps
						.chooseEntitlementonEarnBasis(entitlementonEarnBasis);
			}
			if (!cutoffDatefor1stMthEntitlement.isEmpty()) {
				onLeaveTypeSteps
						.typeCutoffDatefor1stMthEntitlement(cutoffDatefor1stMthEntitlement);
			}
			if (!prorateExpectedLeaveEntitlement.isEmpty()) {
				onLeaveTypeSteps
						.chooseProrateExpectedLeaveEntitlement(prorateExpectedLeaveEntitlement);
			}
			if (!childcareLeave.isEmpty()) {
				onLeaveTypeSteps.chooseChildcareLeave(childcareLeave);
			}
			if (!typeofChildcareLeave.isEmpty()) {
				onLeaveTypeSteps
						.chooseTypeofChildcareLeave(typeofChildcareLeave);
			}
			if (!carriedForwardToNextYear.isEmpty()) {
				onLeaveTypeSteps
						.chooseCarriedForwardToNextYear(carriedForwardToNextYear);
			}
			if (!maxNoofDaysCarriedForward.isEmpty()) {
				onLeaveTypeSteps
						.typeMaxNoofDaysCarriedForward(maxNoofDaysCarriedForward);
			}
			if (!validityofCarriedForwardLeave.isEmpty()) {
				onLeaveTypeSteps
						.typeValidityofCarriedForwardLeave(validityofCarriedForwardLeave);
			}
			if (!deductonedayifleavetakenonhalfworkingday.isEmpty()) {
				onLeaveTypeSteps
						.chooseDeductonedayifleavetakenonhalfworkingday(deductonedayifleavetakenonhalfworkingday);
			}
			if (!payHourlyRateEmployeeifleaveisapplied.isEmpty()) {
				onLeaveTypeSteps
						.choosePayHourlyRateEmployeeifleaveisapplied(payHourlyRateEmployeeifleaveisapplied);
			}
			if (!setCompanyDeclaredHolidayasNonworkingdays.isEmpty()) {
				onLeaveTypeSteps
						.chooseSetCompanyDeclaredHolidayasNonworkingdays(setCompanyDeclaredHolidayasNonworkingdays);
			}
			if (!deductCondition.isEmpty()) {
				onLeaveTypeSteps.chooseDeductCondition(deductCondition);
			}

			if (!deductConditionCalendarDay.isEmpty()) {
				onLeaveTypeSteps
						.typeDeductConditionCalendarDay(deductConditionCalendarDay);
			}

			if (!company.isEmpty()) {
				if (company.toLowerCase().equals("all"))
					onLeaveTypeSteps.chooseAllCompany();
				else
					onLeaveTypeSteps.chooseCompany(company);
			}

			onLeaveTypeSteps.clickOnUpdateBtn();
		}
		onLeaveTypeSteps.switchOutIFrame();
	}

	@When("^user delete leave type$")
	public void the_user_delete_Leave_Type(List<List<String>> dataTable) {
		String dataTableKey = "WTS_Del_LeaveType";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colLeavetypecode = "Leave type code";

		onLeaveTypeSteps.switchToIFrame();
		for (int rowWTS_LeaveType : SessionData.getDataTbRowsNoHeader(
				dataTableKey).keySet()) {
			String leavetypecode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveType, colLeavetypecode);

			if (!leavetypecode.isEmpty()) {
				onLeaveTypeSteps.deleteLeaveType(leavetypecode);
			}
		}
		onLeaveTypeSteps.switchOutIFrame();
	}

	// LEAVE ENTITLEMENT
	@When("^user create leave entitlement by leave type as \"([^\"]*)\"$")
	public void user_create_leave_entitlement_by_leave_type_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveEntitlement_LvT";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colVoucherDate = "Voucher Date";
		String colYear = "Year";
		String colDefaultAdjustmentType = "Default Adjustment Type";
		String colLeaveType = "Leave Type";
		String colDefaultNoofDays = "Default No. of Days";

		onLeaveEntitlementSteps.switchToIFrame();
		onLeaveEntitlementSteps.moveToByLeaveTypeTab();

		for (int rowWTS_LeaveEntitlement_LvT : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {

			String voucherDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvT, colVoucherDate);
			String year = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvT, colYear);
			String defaultAdjustmentType = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveEntitlement_LvT,
					colDefaultAdjustmentType);
			String leaveType = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvT, colLeaveType);
			String defaultNoofDays = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvT, colDefaultNoofDays);

			onLeaveEntitlementSteps.add_new_leave_entitlement_by_leave_type();
			// onLeaveEntitlementSteps.searchLeaveEntitlementVCHByLT("LE00000014");

			if (!voucherDate.isEmpty()) {
				onLeaveEntitlementSteps.voucher_date(voucherDate);
			}
			if (!year.isEmpty()) {
				onLeaveEntitlementSteps.year(year);
			}
			if (!defaultAdjustmentType.isEmpty()) {
				onLeaveEntitlementSteps
						.default_adjusment_type(defaultAdjustmentType);
			}
			if (!leaveType.isEmpty()) {
				onLeaveEntitlementSteps
						.select_leave_type_beside_Remark_tab(leaveType);
			}
			if (!defaultNoofDays.isEmpty()) {
				onLeaveEntitlementSteps.default_no_of_days(defaultNoofDays);
			}
		}
		onLeaveEntitlementSteps.switchOutDefaultIFrame();
	}

	@When("^leave entitlement is created by leave type with employee as \"([^\"]*)\"$")
	public void leave_entitlement_is_created_by_leave_type_with_employee_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveEntitlement_LvTEmp";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colEmployeeCode = "Employee Code";
		String colAdjustmentType = "Adjustment Type";
		String colNoOfDays = "No. Of Days";

		onLeaveEntitlementSteps.switchToIFrame();

		for (int rowWTS_LeaveEntitlement_LvTEmp : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvTEmp, colEmployeeCode);
			String adjustmentType = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvTEmp, colAdjustmentType);
			String noOfDays = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_LvTEmp, colNoOfDays);

			onLeaveEntitlementSteps.clickOnAddEmployeeByLT();

			if (!employeeCode.isEmpty()) {
				onLeaveEntitlementSteps.typeEmployeeCodeByLT(employeeCode);
			}
			if (!adjustmentType.isEmpty()) {
				onLeaveEntitlementSteps
						.chooseAdjustmentTypeByLT(adjustmentType);
			}
			if (!noOfDays.isEmpty()) {
				onLeaveEntitlementSteps.typeNoOfDayByLT(noOfDays);
			}
		}
		onLeaveEntitlementSteps.switchOutDefaultIFrame();
	}

	@When("^user create leave entitlement by employee as \"([^\"]*)\"$")
	public void user_create_leave_entitlement_by_employee_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveEntitlement_Emp";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colVoucherDate = "Voucher Date";
		String colYear = "Year";
		String colDefaultAdjustmentType = "Default Adjustment Type";
		String colEmployeeCode = "Employee Code";

		onLeaveEntitlementSteps.switchToIFrame();
		onLeaveEntitlementSteps.moveToByEmployeeTab();

		for (int rowWTS_LeaveEntitlement_Emp : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			String voucherDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_Emp, colVoucherDate);
			String year = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_Emp, colYear);
			String defaultAdjustmentType = SessionData.getDataTbVal(
					dataTableKey, rowWTS_LeaveEntitlement_Emp,
					colDefaultAdjustmentType);
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_Emp, colEmployeeCode);
			onLeaveEntitlementSteps.add_new_leave_entitlement_by_empolyee();
			// onLeaveEntitlementSteps.searchLeaveEntitlementVCHByEmp("LE00000017");

			if (!voucherDate.isEmpty()) {
				onLeaveEntitlementSteps.voucher_date(voucherDate);
			}
			if (!year.isEmpty()) {
				onLeaveEntitlementSteps.year(year);
			}
			if (!defaultAdjustmentType.isEmpty()) {
				onLeaveEntitlementSteps
						.default_adjusment_type(defaultAdjustmentType);
			}
			if (!employeeCode.isEmpty()) {
				onLeaveEntitlementSteps.chooseEmployeeCode(employeeCode);
			}
		}
		onLeaveEntitlementSteps.switchOutDefaultIFrame();
	}

	@When("^leave entitlement is created by employee with leave types as \"([^\"]*)\"$")
	public void leave_entitlement_is_created_by_employee_with_leave_types_as(
			String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveEntitlement_EmpLV";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colLeaveTypeCode = "Leave Type Code";
		String colAdjustmentType = "Adjustment Type";
		String colNoOfDays = "No. Of Days";

		onLeaveEntitlementSteps.switchToIFrame();

		for (int rowWTS_LeaveEntitlement_EmpLV : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			String leaveTypeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_EmpLV, colLeaveTypeCode);
			String adjustmentType = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_EmpLV, colAdjustmentType);
			String noOfDays = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveEntitlement_EmpLV, colNoOfDays);

			onLeaveEntitlementSteps.clickOnAddLeaveTypeByEmp();

			if (!leaveTypeCode.isEmpty()) {
				onLeaveEntitlementSteps.add_leave_type_code(leaveTypeCode);
			}
			if (!adjustmentType.isEmpty()) {
				onLeaveEntitlementSteps
						.chooseAdjustmentTypeByEmp(adjustmentType);
			}
			if (!noOfDays.isEmpty()) {
				onLeaveEntitlementSteps.typeNoOfDayByEmp(noOfDays);
			}
		}
		onLeaveEntitlementSteps.switchOutDefaultIFrame();
	}

	@When("^user submit leave entitlement$")
	public void user_submit_leave_entitlement() {
		onLeaveEntitlementSteps.switchToIFrame();
		onLeaveEntitlementSteps.clickOnSubmitBtn();
		onLeaveEntitlementSteps.switchOutDefaultIFrame();
	}

	// PROJECT

	private List<String> listProjectNo = new ArrayList<String>();
	private boolean isNewProject;
	private String ssProjectNo = "ProjectNo";
	private String ssMessageProject = "WTS Message Project";

	@When("^user create project estimation as \"([^\"]*)\"$")
	public void the_user_create_project_estimation_as(String keyPrj,
			List<List<String>> dataset) {
		projectEstimationSteps.switchToIFrame();
		String dataTableKey = "WTS_ProjectEstimation";
		SessionData.addDataTable(dataTableKey, dataset, false);

		isNewProject = false;
		String colCustomer = "Customer";

		for (int rowWTS_ProjectEstimation : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "PE KEY", keyPrj)
				.keySet()) {
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowWTS_ProjectEstimation, colCustomer);
			// projectEstimationSteps.searchProjectNo("PJE0000066");
			projectEstimationSteps.createNewVoucherPE();
			isNewProject = true;
			if (!customer.isEmpty()) {
				projectEstimationSteps.customer_code(colCustomer, customer);
			}
		}
		projectEstimationSteps.switchOutDefaultIFrame();
	}

	@When("^user update project estimation as \"([^\"]*)\"$")
	public void the_user_update_project_estimation_as(String keyPrj,
			List<List<String>> dataset) {
		projectEstimationSteps.switchToIFrame();
		String dataTableKey = "WTS_ProjectEstimation";
		SessionData.addDataTable(dataTableKey, dataset, false);

		isNewProject = false;
		String colProjectNo = "Project No";

		for (int rowWTS_ProjectEstimation : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "PE KEY", keyPrj)
				.keySet()) {
			String projectNo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_ProjectEstimation, colProjectNo);
			isNewProject = true;
			if (!projectNo.isEmpty()) {
				projectEstimationSteps.searchProjectNo(projectNo);
			}
		}
		projectEstimationSteps.switchOutDefaultIFrame();
	}

	@When("^project estimation is created with header tab as \"([^\"]*)\"$")
	public void project_estimation_is_created_with_header_tab_as(String keyPrj,
			List<List<String>> dataTable) {
		if (isNewProject) {
			String dataTableKey = "WTS_ProjectEstimation_Header";
			SessionData.addDataTable(dataTableKey, dataTable, false);

			projectEstimationSteps.switchToIFrame();

			String colCurrency = "Currency";
			String colSalesTax = "Sales Tax";
			String colEstimateDate = "Estimate Date";
			String colStartDate = "Start Date";
			String colEndDate = "End Date";
			String colProjectClass = "Project Class";
			String colPaymentTermTenor = "Payment Term Tenor";

			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowWTS_ProjectEstimation_Header : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, "PE KEY",
							keyPrj).keySet()) {

				projectEstimationSteps.go_to_tab("Header");

				String currency = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colCurrency);
				String salesTax = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSalesTax);
				String estimateDate = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colEstimateDate);
				String startDate = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colStartDate);
				String endDate = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colEndDate);
				String projectClass = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colProjectClass);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment4);

				String paymentTermTenor = SessionData.getDataTbVal(
						dataTableKey, rowWTS_ProjectEstimation_Header,
						colPaymentTermTenor);

				if (!currency.isEmpty()) {
					projectEstimationSteps.currency(colCurrency, currency);
				}
				if (!salesTax.isEmpty()) {
					projectEstimationSteps.sales_tax(colSalesTax, salesTax);
				}
				if (!estimateDate.isEmpty()) {
					projectEstimationSteps.estimate_date(colEstimateDate,
							estimateDate);
				}
				if (!startDate.isEmpty()) {
					projectEstimationSteps.start_date(colStartDate, startDate);
				}
				if (!endDate.isEmpty()) {
					projectEstimationSteps.end_date(colEndDate, endDate);
				}
				if (!projectClass.isEmpty()) {
					projectEstimationSteps.project_class(colProjectClass,
							projectClass);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				projectEstimationSteps.setSegment(listSegment);

				if (!paymentTermTenor.isEmpty()) {
					projectEstimationSteps.go_to_tab("Payment Info");
					projectEstimationSteps.payment_term_tenor_date(
							colPaymentTermTenor, paymentTermTenor);
				}
			}
			projectEstimationSteps.switchOutDefaultIFrame();
		}
	}

	@When("^project estimation is created with detail tab with phase as \"([^\"]*)\"$")
	public void project_estimation_is_created_with_detail_tab_with_phase_as(
			String keyPrj, List<List<String>> dataset) {
		if (isNewProject) {
			projectEstimationSteps.switchToIFrame();
			projectEstimationSteps.go_to_tab("Detail");
			projectEstimationSteps.setPhaseInfor(keyPrj, dataset);
			projectEstimationSteps.switchOutDefaultIFrame();
		}
	}

	@When("^project estimation is created with detail tab with item as \"([^\"]*)\"$")
	public void project_estimation_is_created_with_detail_tab_with_item_as(
			String keyPrj, List<List<String>> dataset) {
		if (isNewProject) {
			projectEstimationSteps.switchToIFrame();
			projectEstimationSteps.setItemInfor(keyPrj, dataset);
			projectEstimationSteps.switchOutDefaultIFrame();
		}
	}

	@When("^project estimation is submitted$")
	public void project_estimation_is_submitted() {
		if (isNewProject) {
			projectEstimationSteps.switchToIFrame();

			String projectNo = projectEstimationSteps.getProjectNo();

			try {
				listProjectNo = Serenity.sessionVariableCalled(ssProjectNo);
				if (listProjectNo == null) {
					listProjectNo = new ArrayList<String>();
				}
			} catch (Exception e) {
				System.out
						.println("***** WARNING ***** : ProjectNo Variable Not created yet ");
			}

			listProjectNo.add(projectNo);
			Serenity.setSessionVariable(ssProjectNo).to(listProjectNo);

			projectEstimationSteps.click_summit();
			projectEstimationSteps.switchOutDefaultIFrame();
		}
	}

	// LEAVE APPLICATION
	@When("^user create leave application as \"([^\"]*)\"$")
	public void user_create_leave_application_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveApplication";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colApplicationDate = "Application Date";
		String colApplicant = "Applicant";
		String colSBU = "SBU";

		onLeaveApplicationSteps.switchToIFrame();

		for (int rowWTS_LeaveApplication : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			String applicationDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplication, colApplicationDate);
			String applicant = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplication, colApplicant);
			String sBU = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplication, colSBU);

			onLeaveApplicationSteps.clickOnNewBtn();
			// onLeaveApplicationSteps.searchLeaveApplication("LA00000034");

			if (!applicationDate.isEmpty()) {
				onLeaveApplicationSteps.typeApplicationDate(applicationDate);
			}
			if (!applicant.isEmpty()) {
				onLeaveApplicationSteps.chooseApplicant(applicant);
			}
			if (!sBU.isEmpty()) {
				onLeaveApplicationSteps.typeSBU(sBU);
			}
		}
		onLeaveApplicationSteps.switchOutDefaultIFrame();
	}

	@When("^leave application is created with leave type as \"([^\"]*)\"$")
	public void leave_application_is_created_with_leave_type_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_LeaveApplicationLT";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colLeaveType = "Leave Type";
		String colDateFrom = "Date From";
		String colDateTo = "Date To";
		String colDurationType = "Duration Type";
		onLeaveApplicationSteps.switchToIFrame();

		for (int rowWTS_LeaveApplicationLT : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			int rowIndex = 1;
			String leaveType = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplicationLT, colLeaveType);
			String dateFrom = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplicationLT, colDateFrom);
			String dateTo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplicationLT, colDateTo);
			String durationType = SessionData.getDataTbVal(dataTableKey,
					rowWTS_LeaveApplicationLT, colDurationType);

			onLeaveApplicationSteps.clickOnAddBtn();

			if (!leaveType.isEmpty()) {
				onLeaveApplicationSteps.typeLeaveType(leaveType, rowIndex);
			}
			if (!durationType.isEmpty()) {
				onLeaveApplicationSteps
						.typeDurationType(durationType, rowIndex);
			}
			if (!dateFrom.isEmpty()) {
				onLeaveApplicationSteps.typeDateFrom(dateFrom, rowIndex);
			}
			if (!dateTo.isEmpty() && durationType.toLowerCase().equals("full")) {
				rowIndex = onLeaveApplicationSteps.getRowIndex(dateFrom);
				onLeaveApplicationSteps.typeDateTo(dateTo, rowIndex);
			}
		}
		onLeaveApplicationSteps.switchOutDefaultIFrame();
	}

	@When("^leave application is submitted$")
	public void leave_application_is_submitted() {
		onLeaveApplicationSteps.switchToIFrame();
		onLeaveApplicationSteps.getLANo(ssLANo);
		onLeaveApplicationSteps.clickOnSubmitBtn();
		onLeaveApplicationSteps.switchOutDefaultIFrame();
	}

	// WEEKLY TIMESHEET
	@When("^user create weekly timesheet for employee as \"([^\"]*)\"$")
	public void user_create_weekly_timesheet_for_employees(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "WTS_WeeklyTimesheet";
		SessionData.addDataTable(dataTableKey, dataTable, false);
		String colYear = "Year";
		String colWeekNo = "Week No";
		String colEmployeeCode = "Employee Code";
		String colTimesheetDate = "Timesheet Date";
		String colApprovingOfficer = "Approving Officer";

		for (int rowWTS_WeeklyTimesheet : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			String year = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colYear);
			String weekNo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colWeekNo);
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colEmployeeCode);
			String timesheetDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colTimesheetDate);
			String approvingOfficer = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colApprovingOfficer);
			System.out.println("[*** NANCY ***] Employee Code = "
					+ employeeCode);

			if (!year.isEmpty() && !timesheetDate.isEmpty()) {
				onWeeklyTimesheetSteps.chooseYear(timesheetDate);
			}
			if (!weekNo.isEmpty()) {
				onWeeklyTimesheetSteps.typeWeekNo(weekNo);
			}
			if (!employeeCode.isEmpty()) {
				onWeeklyTimesheetSteps.typeEmployeeCode(employeeCode);
			}
			if (!approvingOfficer.isEmpty()) {
				onWeeklyTimesheetSteps.typeApprovingOfficer(approvingOfficer);
			}
		}
	}

	@When("^weekly timesheet is created with data as \"([^\"]*)\"$")
	public void weekly_timesheet_is_created_with_data_as(String dataKey,
			List<List<String>> dataTable) throws SQLException {
		String dataTableKey = "WTS_WeeklyTimesheet_Hours";
		SessionData.addDataTable(dataTableKey, dataTable, false);

		String colTimesheetDate = "Timesheet Date";
		String colActivity = "Activity";
		String colProject = "Project";
		String colPhaseDescRemarks = "Phase Desc/Remarks";

		String colNormalHrs = "Normal Hrs";
		String colOTHrs = "OT Hrs";
		String colExpectedMessage = "Expected Message";

		List<String> listMessageProject = new ArrayList<>();
		listMessageProject.addAll(Arrays.asList("Project No.",
				"Actual Message", "Expected Message", "Result"));
		SessionData.addRowToTbDataReport(ssMessageProject, listMessageProject);

		List<String> listProject = new ArrayList<>();
		listProject.addAll(Arrays.asList("PJ00000120", "PJE4000035",
				"PJ00000121", "PJE4000036", "PJE4000037"));
		// listProject = Serenity.sessionVariableCalled(ssProjectNo);

		if (listProject == null)
			listProject = new ArrayList<>();

		System.out.println("[*** NANCY ***] List Project.: " + listProject);

		for (int rowWTS_WeeklyTimesheet : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "Key", dataKey)
				.keySet()) {
			String timesheetDate = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colTimesheetDate);
			String activity = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colActivity);
			String project = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colProject);
			String normalHrs = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colNormalHrs);
			String oTHrs = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colOTHrs);
			String phaseDescRemarks = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colPhaseDescRemarks);
			String expectedMessage = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet, colExpectedMessage);

			if (!activity.isEmpty()) {
				onWeeklyTimesheetSteps.chooseActivity(activity);
			}
			if (!project.isEmpty()) {
				if (project.length() <= 2) {
					int index = Integer.parseInt(project);
					project = listProject.get(index - 1);
				}
				onWeeklyTimesheetSteps.typeProject(project, expectedMessage,
						ssMessageProject);
			}

			if (!timesheetDate.isEmpty()) {
				if (!normalHrs.isEmpty()) {
					onWeeklyTimesheetSteps.typeNormalHrs(normalHrs,
							timesheetDate, phaseDescRemarks);
				}
				if (!oTHrs.isEmpty()) {
					onWeeklyTimesheetSteps.typeOTHrs(oTHrs, timesheetDate,
							phaseDescRemarks);
				}
			}
			onWeeklyTimesheetSteps.closeProjectNoTb();
		}
		onWeeklyTimesheetSteps.getWTSVoucher(ssWTSVch);
		onWeeklyTimesheetSteps.clickOnSubmitBtn();
		onWeeklyTimesheetSteps.query(SessionData.generateTbDataReport(
				ssMessageProject).toString());
		onWeeklyTimesheetSteps.verifyMessage(ssMessageProject, 1, 2);
		listMessageProject = new ArrayList<>();
		Serenity.setSessionVariable(ssMessageProject).to(listMessageProject);
	}

	@When("^user delete weekly timesheet$")
	public void user_delete_weekly_timesheet(List<List<String>> dataTable)
			throws SQLException {
		String dataTableKey = "WTS_WeeklyTimesheet_Del";
		SessionData.addDataTable(dataTableKey, dataTable, false);
		String coldataBase = "DataBase";
		String colYear = "Year";
		String colWeekNo = "Week No";
		String colEmployeeCode = "Employee Code";

		for (int rowWTS_WeeklyTimesheet_Del : SessionData
				.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String weekNo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet_Del, colWeekNo);
			String year = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet_Del, colYear);
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet_Del, colEmployeeCode);
			String dataBase = SessionData.getDataTbVal(dataTableKey,
					rowWTS_WeeklyTimesheet_Del, coldataBase);

			if (!weekNo.isEmpty() && !employeeCode.isEmpty()
					&& !dataBase.isEmpty() && !year.isEmpty()) {
				if (weekNo.length() == 1) {
					weekNo = "0" + weekNo;
				}
				String dateCode = year + weekNo;
				onWeeklyTimesheetSteps.deleteWTS(dataBase, employeeCode,
						dateCode);
			}
		}
	}

	@When("^user approval summary for payrol$")
	public void user_approval_summary_for_payrol() {
		List<String> listWTSVchNo = new ArrayList<>();
		listWTSVchNo = Serenity.sessionVariableCalled(ssWTSVch);

		if (listWTSVchNo.size() > 0) {
			onWeeklyTimesheetSteps.clickOnPayrollTimesheet();
			for (String VchNo : listWTSVchNo) {
				onWeeklyTimesheetSteps.filterVchNoAndSubmit(VchNo);
			}
			listWTSVchNo.clear();
			Serenity.setSessionVariable("WTSVchNo").to(listWTSVchNo);
		}
	}

	@When("^user approve leave application$")
	public void user_approve_leave_application() {
		List<String> listLANo = new ArrayList<>();
		listLANo = Serenity.sessionVariableCalled(ssLANo);
		if (listLANo == null) {
			listLANo = new ArrayList<>();
		}
		onLeaveTypeSteps.switchToIFrame();
		if (listLANo.size() > 0) {
			// if (onWeeklyTimesheetSteps.clickOnApproveLeaveApplication()) {
			for (String lANo : listLANo) {
				onWeeklyTimesheetSteps.filterLANooAndSubmit(lANo);
			}
			listLANo.clear();
			Serenity.setSessionVariable("ssLANo").to(listLANo);
		}
		onLeaveTypeSteps.switchOutIFrame();
	}

	@When("^user delete leave application by employee$")
	public void user_delete_leave_application_by_employee(
			List<List<String>> dataTable) {
		String dataTableKey = "Del_LANo";
		SessionData.addDataTable(dataTableKey, dataTable, false);
		String colEmployeeCode = "Employee Code";

		for (int rowW : SessionData.getDataTbRowsNoHeader(dataTableKey)
				.keySet()) {
			String employeeCode = SessionData.getDataTbVal(dataTableKey, rowW,
					colEmployeeCode);

			if (!employeeCode.isEmpty()) {
				onWeeklyTimesheetSteps.deleteLeaveApplication(employeeCode);
			}
		}
	}

	@When("^user delete leave entitlement by leave type$")
	public void user_delete_leave_entitlement_by_leave_type(
			List<List<String>> dataTable) {
		String dataTableKey = "Del_LENo";
		SessionData.addDataTable(dataTableKey, dataTable, false);
		String colLeaveType = "Leave Type";

		for (int rowW : SessionData.getDataTbRowsNoHeader(dataTableKey)
				.keySet()) {
			String leaveType = SessionData.getDataTbVal(dataTableKey, rowW,
					colLeaveType);

			if (!leaveType.isEmpty()) {
				onWeeklyTimesheetSteps.deleteLeaveEntitlement(leaveType);
			}
		}
	}
}
