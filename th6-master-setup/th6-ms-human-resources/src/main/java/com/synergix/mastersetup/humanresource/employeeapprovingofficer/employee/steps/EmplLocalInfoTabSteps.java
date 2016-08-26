package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplLocalInfoTabPage;

public class EmplLocalInfoTabSteps extends ScenarioSteps {

	EmplLocalInfoTabPage onLocalInfoTabPage;

	public void moveToLocalInfoTab() {
		onLocalInfoTabPage.moveToTab("Local Info");
	}

	// *************************************************************
	// *************************************************************
	// HR TAB

	@Step
	public void chooseDesignatedWorkingDays(String workingDay, String option) {
		onLocalInfoTabPage.chooseDesignatedWorkingDays(workingDay, option);
	}

	@Step
	public void typeTotalWorkingHoursPerDay(String totalWorkingHoursPerDay) {
		onLocalInfoTabPage.typeTotalWorkingHoursPerDay(totalWorkingHoursPerDay);
	}

	@Step
	public void typeTotalWorkingHoursPerWeek(String totalWorkingHoursPerWeek) {
		onLocalInfoTabPage
				.typeTotalWorkingHoursPerWeek(totalWorkingHoursPerWeek);
	}

	@Step
	public void typeAMTimeFrom(String aMTimeFrom) {
		onLocalInfoTabPage.typeAMTimeFrom(aMTimeFrom);
	}

	@Step
	public void typeAMTimeTo(String aMTimeTo) {
		onLocalInfoTabPage.typeAMTimeTo(aMTimeTo);
	}

	@Step
	public void typePMTimeFrom(String pMTimeFrom) {
		onLocalInfoTabPage.typePMTimeFrom(pMTimeFrom);
	}

	@Step
	public void typePMTimeTo(String pMTimeTo) {
		onLocalInfoTabPage.typePMTimeTo(pMTimeTo);
	}

	@Step
	public void chooseSalaryType(String effectiveDate, String salaryType) {
		if (onLocalInfoTabPage.clickOnSalaryTypeIcon()) {
			onLocalInfoTabPage.typeSalaryTypeEffectiveDate(effectiveDate);
			onLocalInfoTabPage.chooseSalaryType(salaryType);
			onLocalInfoTabPage.clickBtn("Submit");
			onLocalInfoTabPage.clickOnCloseSalaryTypeIcon();
		}
	}

	@Step
	public void chooseRelatedToTimesheet(String relatedToTimesheet) {
		onLocalInfoTabPage.chooseRelatedToTimesheet(relatedToTimesheet);
	}

	@Step
	public void typePaymentCycle(String paymentCycle) {
		onLocalInfoTabPage.typePaymentCycle(paymentCycle);
	}

	@Step
	public void typeEPC(String effectiveDate, String ePC) {
		onLocalInfoTabPage.waitForAllJSCompletes();
		if (onLocalInfoTabPage.clickOnEPCIcon()) {
			onLocalInfoTabPage.calendarSetDate(effectiveDate);
			onLocalInfoTabPage.typeEPC(ePC);
			onLocalInfoTabPage.clickBtn("Submit");
			onLocalInfoTabPage.clickOnCloseEPC();
		}
	}

	@Step
	public void typeGrace(String effectiveDate, String grace) {
		if (onLocalInfoTabPage.clickOnGradeIcon()) {
			onLocalInfoTabPage.typeEffectiveDateGrace(effectiveDate);
			onLocalInfoTabPage.typeGrace(grace);
			onLocalInfoTabPage.clickBtn("Submit");
			onLocalInfoTabPage.clickOnCloseGrace();
		}
	}

	// *************************************************************
	// *************************************************************
	// PAYROLL TAB

	// *************************************************************
	// *************************************************************
	// SBU TAB
}
