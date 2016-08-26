package com.synergix.mastersetup.party.customer.customer.steps;

import com.synergix.mastersetup.party.customer.customer.page.IndustryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class IndustrySteps extends ScenarioSteps{
	
	IndustryPage industryPage;
	
	@Step
	public void create_new_industry(String industrycode, String description) {

		industryPage.switchToIFrame("th5frame");
		industryPage.click_btn_search();
		
		if (!industryPage.search_result(industrycode)) {
			industryPage.click_on_brand_code_link();
			industryPage.click_btn_new();
			industryPage.waitForAllJSCompletes();
			industryPage.enter_industry_code(industrycode);
			industryPage.waitForAllJSCompletes();
			industryPage.enter_description(description);
			industryPage.waitForAllJSCompletes();
			industryPage.click_btn_update();
			industryPage.waitForAllJSCompletes();
			industryPage.clickBtnYesOnConfirmUpdate();
			industryPage.waitForAllJSCompletes();
			industryPage.click_btn_status_popup();
		}

		industryPage.switchOutDefaultIFrame();
	}
}
