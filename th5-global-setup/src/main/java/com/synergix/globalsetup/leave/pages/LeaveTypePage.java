package com.synergix.globalsetup.leave.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class LeaveTypePage extends TH5PageObject {

	public LeaveTypePage(WebDriver driver) {
		super(driver);
	}

	public void typeLeavetypecode(String leavetypecode) {
		String xPath = "(//td[preceding-sibling::td[descendant-or-self::*[text()='Leave Type Code']]]//input[@type='text'])";
		waitElementToBePresent(xPath).typeAndEnter(leavetypecode);
		waitForAllJSCompletes();
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void chooseExcludeNonworkingDays(String excludeNonworkingDays) {
		selectRadioButton("Exclude Non-working Days", excludeNonworkingDays);
	}

	public void choosePaidLeave(String paidLeave) {
		selectRadioButton("Paid Leave", paidLeave);
		waitForAllJSCompletes();
	}

	public void chooseDeductSalary(String deductSalary) {
		selectRadioButton("Deduct Salary", deductSalary);
	}

	public void chooseEncashmentUponResignation(String encashmentUponResignation) {
		selectRadioButton("Encashment Upon Resignation", encashmentUponResignation);
		waitForAllJSCompletes();
	}

	public void chooseLeaveEncashmentOnEarnBasis(String leaveEncashmentOnEarnBasis) {
		selectRadioButton("Leave Encashment On Earn Basis", leaveEncashmentOnEarnBasis);
	}

	public void chooseEntitlementonEarnBasis(String entitlementonEarnBasis) {
		selectRadioButton("Entitlement on Earn Basis", entitlementonEarnBasis);
		waitForAllJSCompletes();
	}

	public void typeCutoffDatefor1stMthEntitlement(String cutoffDatefor1stMthEntitlement) {
		enterInputFieldWithLabel("Cut-off Date for 1st Mth Entitlement", cutoffDatefor1stMthEntitlement);
	}

	public void chooseProrateExpectedLeaveEntitlement(String prorateExpectedLeaveEntitlement) {
		selectRadioButton("Prorate Expected Leave Entitlement", prorateExpectedLeaveEntitlement);
	}

	public void chooseChildcareLeave(String childcareLeave) {
		selectRadioButton("Childcare Leave", childcareLeave);
		waitForAllJSCompletes();
	}

	public void chooseTypeofChildcareLeave(String typeofChildcareLeave) {
		selectRadioButton("Type of Childcare Leave", typeofChildcareLeave);
	}

	public void chooseCarriedForwardToNextYear(String carriedForwardToNextYear) {
		selectRadioButton("Carried Forward To Next Year", carriedForwardToNextYear);
		waitForAllJSCompletes();
	}

	public void typeMaxNoofDaysCarriedForward(String maxNoofDaysCarriedForward) {
		enterInputFieldWithLabel("Max. No. of Days Carried Forward", maxNoofDaysCarriedForward);
	}

	public void typeValidityofCarriedForwardLeave(String validityofCarriedForwardLeave) {
		enterInputFieldWithLabel("Validity of Carried Forward Leave", validityofCarriedForwardLeave);
	}

	public void chooseDeductonedayifleavetakenonhalfworkingday(String deductonedayifleavetakenonhalfworkingday) {
		selectRadioButton("Deduct one day if leave taken on half working day",
				deductonedayifleavetakenonhalfworkingday);
	}

	public void choosePayHourlyRateEmployeeifleaveisapplied(String payHourlyRateEmployeeifleaveisapplied) {
		selectRadioButton("Pay Hourly Rate Employee if leave is applied", payHourlyRateEmployeeifleaveisapplied);
	}

	public void chooseSetCompanyDeclaredHolidayasNonworkingdays(String setCompanyDeclaredHolidayasNonworkingdays) {
		selectRadioButton("Set Company Declared Holiday as Non-working days",
				setCompanyDeclaredHolidayasNonworkingdays);
	}

	public void chooseDeductCondition(String deductCondition) {
		selectDdlWithLabelByText("Deduct Condition", deductCondition);
	}

	public void typeDeductConditionCalendarDay(String deductConditionCalendarDay) {
		enterInputFieldWithLabel("Deduct Condition Calendar Day", deductConditionCalendarDay);
	}

}
