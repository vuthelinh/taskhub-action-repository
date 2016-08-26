package com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.page.DesignationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DesignationSteps extends ScenarioSteps {

	DesignationPage onDesignationPage;

	@Step
	public void typeDesignationCode(String designationCode) {
		onDesignationPage.typeDesignationCode(designationCode);
	}

	@Step
	public void typeDesignationDescription(String designationDescription) {
		onDesignationPage.typeDesignationDescription(designationDescription);
	}

	@Step
	public void chooseAllCompany() {
		onDesignationPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String listCompanyName) {
		onDesignationPage.chooseCompany(listCompanyName);
	}

	public void clickOnNewBtn() {
		onDesignationPage.clickBtn("New");
		onDesignationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnUpdateBtn() {
		onDesignationPage.clickBtn("Update");
		onDesignationPage.chooseYesOnUpdateConfirmation();
		onDesignationPage.waitForAllJSCompletes();
	}

	public void moveToCompanyTab() {
		onDesignationPage.switch_to_tab("Company");
		onDesignationPage.waitForAllJSCompletes();
	}

	// LOCAL INFO TAB
	public void moveToLocalInfoTab() {
		onDesignationPage.switch_to_tab("Local Info");
	}

	@Step
	public void clickOnAddIcon() {
		onDesignationPage.clickOnAddIcon();

	}

	@Step
	public void typeEffectiveDateFrom(String effectiveDateFrom, int rowIndex) {
		onDesignationPage.typeEffectiveDateFrom(effectiveDateFrom, rowIndex);
	}

	@Step
	public void typeEffectiveDateTo(String effectiveDateTo, int rowIndex) {
		onDesignationPage.typeEffectiveDateTo(effectiveDateTo, rowIndex);
	}

	@Step
	public void typeNormalHourlyRate(String normalHourlyRate, int rowIndex) {
		onDesignationPage.typeNormalHourlyRate(normalHourlyRate, rowIndex);
	}

	@Step
	public void typeOTHourlyRate(String oTHourlyRate, int rowIndex) {
		onDesignationPage.typeOTHourlyRate(oTHourlyRate, rowIndex);
	}

	public int countRowTbl() {
		return onDesignationPage.countRowTbl();
	}

	@Step
	public void deleteDesignation(String designationCode) {
		onDesignationPage.deleteValueByFilter("", "Designation Code", designationCode);
	}

}
