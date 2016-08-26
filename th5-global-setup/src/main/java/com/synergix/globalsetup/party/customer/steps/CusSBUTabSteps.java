package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CusSBUTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusSBUTabSteps extends ScenarioSteps {

	CusSBUTabPage onCusSBUTabPage;

	/**
	 * Region SBU Tab
	 **/

	@Step
	public void clickAddSBU() {
		onCusSBUTabPage.clickOnAddSBU();
	}

	@Step
	public int countRowSBU() {
		return onCusSBUTabPage.countRowSBU();
	}

	@Step
	public void typeSBU(String sBU, int rowIndex) {
		onCusSBUTabPage.typeSBU(sBU, rowIndex);
	}

	@Step
	public void typeSBUDescription(String description, int rowIndex) {
		onCusSBUTabPage.typeSBUDescription(description, rowIndex);
	}

	@Step
	public void chooseDelSBU(int rowIndex) {
		onCusSBUTabPage.chooseDelSBU(rowIndex);
	}

	@Step
	public void typeDescription(String description, int rowIndex) {

	}

	public int getRowIndexSBU(String sBU) {
		return onCusSBUTabPage.getRowIndexSBU(sBU);
	}

	public boolean isSBUExit(String sBU) {
		return onCusSBUTabPage.isSBUExit(sBU);
	}
}
