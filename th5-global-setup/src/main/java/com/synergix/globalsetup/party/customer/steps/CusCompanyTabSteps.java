package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CustomerPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CusCompanyTabSteps extends ScenarioSteps {

	CustomerPage oncustomerPage;

	@Step
	public void chooseAllCompany() {
		oncustomerPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String company) {
		oncustomerPage.chooseCompany(company);
	}
}
