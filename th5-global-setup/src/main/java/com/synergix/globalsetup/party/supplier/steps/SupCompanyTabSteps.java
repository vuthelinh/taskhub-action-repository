package com.synergix.globalsetup.party.supplier.steps;

import com.synergix.globalsetup.party.supplier.page.SupCompanyTabPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SupCompanyTabSteps extends ScenarioSteps {

	SupCompanyTabPage onSupCompanyTabPage;

	@Step
	public void chooseAllCompany() {
		onSupCompanyTabPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String company) {
		onSupCompanyTabPage.chooseCompany(company);
	}

}
