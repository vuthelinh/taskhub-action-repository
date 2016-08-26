package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupSBUTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupSBUTabSteps extends ScenarioSteps {

	SupSBUTabPage onSupSBUTabPage;

	@Step
	public void typeDescription(String description, int rowIndex) {
		onSupSBUTabPage.typeDescription(description, rowIndex);
	}

	@Step
	public void moveToSBUTab() {
		onSupSBUTabPage.switch_to_tab("SBU");
		onSupSBUTabPage.waitForAllJSCompletes();
	}

	@Step
	public void clickAddSBU() {
		onSupSBUTabPage.clickOnAddSBU();
	}

	@Step
	public int countRowSBU() {
		return onSupSBUTabPage.countRowSBU();
	}

	@Step
	public void typeSBU(String sBU, int rowIndex) {
		onSupSBUTabPage.typeSBU(sBU, rowIndex);
	}

	@Step
	public void typeSBUDescription(String description, int rowIndex) {
		onSupSBUTabPage.typeSBUDescription(description, rowIndex);
	}

	@Step
	public void chooseDelSBU(int rowIndex) {
		onSupSBUTabPage.chooseDelSBU(rowIndex);
	}

	public boolean isSBUExit(String sBU) {
		return onSupSBUTabPage.isSBUExit(sBU);
	}

	public void chooseDelSBU(String sBU) {
		onSupSBUTabPage.chooseDelSBU(sBU);
	}
}
