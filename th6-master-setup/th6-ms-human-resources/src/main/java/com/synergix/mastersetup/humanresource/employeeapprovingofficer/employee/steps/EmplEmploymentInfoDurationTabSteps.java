package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplEmploymentInfoDurationTabPage;

public class EmplEmploymentInfoDurationTabSteps extends ScenarioSteps {

	EmplEmploymentInfoDurationTabPage onEmploymentInfoDurationTabPage;

	public void moveToEmploymentInfoDurationTab() {
		onEmploymentInfoDurationTabPage.moveToTab("Employment Info & Duration");
	}

	// Info
	public void clickOnDesignationIcon() {
		onEmploymentInfoDurationTabPage.clickOnDesignationIcon();
	}

	@Step
	public void typeDesignationEffectiveDate(String designationEffectiveDate) {
		onEmploymentInfoDurationTabPage
				.typeDesignationEffectiveDate(designationEffectiveDate);
	}

	@Step
	public void typeDesignation(String designation) {
		onEmploymentInfoDurationTabPage.typeDesignation(designation);
	}

	public void clickOnSubmitDesignationBtn() {
		onEmploymentInfoDurationTabPage.clickOnSubmitDesignationBtn();
	}

	public void clickOnCloseDesignationIcon() {
		onEmploymentInfoDurationTabPage.clickOnCloseDesignationIcon();
	}

	// Duration
	public void clickOnAddDurationBtn() {
		onEmploymentInfoDurationTabPage.clickOnAddDurationBtn();
	}

	@Step
	public void typeJoinDate(String joinDate, int rowIndex) {
		onEmploymentInfoDurationTabPage.typeJoinDate(joinDate, rowIndex);
	}

	public int countRowDurationTbl() {
		return onEmploymentInfoDurationTabPage.countRowDurationTbl();
	}

	@Step
	public void typeCompanyCode(String companyCode, int rowIndex) {
		onEmploymentInfoDurationTabPage.typeCompanyCode(companyCode, rowIndex);
	}

}
