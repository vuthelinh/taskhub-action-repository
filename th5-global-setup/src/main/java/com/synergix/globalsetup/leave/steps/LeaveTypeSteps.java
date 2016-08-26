package com.synergix.globalsetup.leave.steps;

import com.synergix.globalsetup.leave.pages.LeaveTypePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LeaveTypeSteps extends ScenarioSteps {

	LeaveTypePage onLeaveTypePage;

	public void clickOnNewBtn() {
		onLeaveTypePage.clickBtn("New");
		onLeaveTypePage.waitForAllJSCompletes();
	}

	public void clickOnUpdateBtn() {
		onLeaveTypePage.clickBtn("Update");
		onLeaveTypePage.chooseYesOnUpdateConfirmation();
		onLeaveTypePage.chooseOKOnInfoPanel();
		onLeaveTypePage.waitForAllJSCompletes();
	}

	public void switchToIFrame() {
		onLeaveTypePage.switchToIFrame();
	}

	public void switchOutIFrame() {
		onLeaveTypePage.switchOutDefaultIFrame();
	}

	@Step
	public void deleteLeaveType(String leavetypecode) {
		onLeaveTypePage.deleteValueBySearchBtn("Search", "Leave Type Code", leavetypecode);
	}

	@Step
	public void typeLeavetypecode(String leavetypecode) {
		onLeaveTypePage.typeLeavetypecode(leavetypecode);
	}

	@Step
	public void typeDescription(String description) {
		onLeaveTypePage.typeDescription(description);
	}

	@Step
	public void chooseExcludeNonworkingDays(String excludeNonworkingDays) {
		onLeaveTypePage.chooseExcludeNonworkingDays(excludeNonworkingDays);
	}

	@Step
	public void choosePaidLeave(String paidLeave) {
		onLeaveTypePage.choosePaidLeave(paidLeave);
	}

	@Step
	public void chooseDeductSalary(String deductSalary) {
		onLeaveTypePage.chooseDeductSalary(deductSalary);
	}

	@Step
	public void chooseEncashmentUponResignation(String encashmentUponResignation) {
		onLeaveTypePage.chooseEncashmentUponResignation(encashmentUponResignation);
	}

	@Step
	public void chooseLeaveEncashmentOnEarnBasis(String leaveEncashmentOnEarnBasis) {
		onLeaveTypePage.chooseLeaveEncashmentOnEarnBasis(leaveEncashmentOnEarnBasis);
	}

	@Step
	public void chooseEntitlementonEarnBasis(String entitlementonEarnBasis) {
		onLeaveTypePage.chooseEntitlementonEarnBasis(entitlementonEarnBasis);
	}

	@Step
	public void typeCutoffDatefor1stMthEntitlement(String cutoffDatefor1stMthEntitlement) {
		onLeaveTypePage.typeCutoffDatefor1stMthEntitlement(cutoffDatefor1stMthEntitlement);
	}

	@Step
	public void chooseProrateExpectedLeaveEntitlement(String prorateExpectedLeaveEntitlement) {
		onLeaveTypePage.chooseProrateExpectedLeaveEntitlement(prorateExpectedLeaveEntitlement);
	}

	@Step
	public void chooseChildcareLeave(String childcareLeave) {
		onLeaveTypePage.chooseChildcareLeave(childcareLeave);
	}

	@Step
	public void chooseTypeofChildcareLeave(String typeofChildcareLeave) {
		onLeaveTypePage.chooseTypeofChildcareLeave(typeofChildcareLeave);
	}

	@Step
	public void chooseCarriedForwardToNextYear(String carriedForwardToNextYear) {
		onLeaveTypePage.chooseCarriedForwardToNextYear(carriedForwardToNextYear);
	}

	@Step
	public void typeMaxNoofDaysCarriedForward(String maxNoofDaysCarriedForward) {
		onLeaveTypePage.typeMaxNoofDaysCarriedForward(maxNoofDaysCarriedForward);
	}

	@Step
	public void typeValidityofCarriedForwardLeave(String validityofCarriedForwardLeave) {
		onLeaveTypePage.typeValidityofCarriedForwardLeave(validityofCarriedForwardLeave);
	}

	@Step
	public void chooseDeductonedayifleavetakenonhalfworkingday(String deductonedayifleavetakenonhalfworkingday) {
		onLeaveTypePage.chooseDeductonedayifleavetakenonhalfworkingday(deductonedayifleavetakenonhalfworkingday);
	}

	@Step
	public void choosePayHourlyRateEmployeeifleaveisapplied(String payHourlyRateEmployeeifleaveisapplied) {
		onLeaveTypePage.choosePayHourlyRateEmployeeifleaveisapplied(payHourlyRateEmployeeifleaveisapplied);
	}

	@Step
	public void chooseSetCompanyDeclaredHolidayasNonworkingdays(String setCompanyDeclaredHolidayasNonworkingdays) {
		onLeaveTypePage.chooseSetCompanyDeclaredHolidayasNonworkingdays(setCompanyDeclaredHolidayasNonworkingdays);
	}

	@Step
	public void chooseDeductCondition(String deductCondition) {
		onLeaveTypePage.chooseDeductCondition(deductCondition);
	}

	@Step
	public void typeDeductConditionCalendarDay(String deductConditionCalendarDay) {
		onLeaveTypePage.typeDeductConditionCalendarDay(deductConditionCalendarDay);
	}

	@Step
	public void chooseAllCompany() {
		onLeaveTypePage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String company) {
		onLeaveTypePage.chooseCompany(company);
	}

}
