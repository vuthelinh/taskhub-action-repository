package com.synergix.common.steps;


import com.synergix.common.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomeSteps extends ScenarioSteps {

	HomePage homePage;

	@Step
	public void logOut() {
		homePage.log_out();
	}

}
