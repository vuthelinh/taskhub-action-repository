package com.synergix.mastersetup.customerrelationmanagement.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;

import com.synergix.mastersetup.customerrelationmanagement.page.GlobalMarketingContactGroupPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class GlobalMarketingContactGroupSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GlobalMarketingContactGroupPage globalMarketingContactGroupPage;

	@Step
	public void enter_global_marketing_contact_group_code(String globalMarketingContactGroupCode) {
		globalMarketingContactGroupPage.enter_global_marketing_contact_group_code(globalMarketingContactGroupCode);
	}

	@Step
	public void verify_global_marketing_contact_group_code(String globalM) {
		assertThat(globalMarketingContactGroupPage.get_text_global_marketing_contact_group_code(), equalTo(globalM));

	}

	@Step
	public void enter_global_marketing_contact_group_code_1(String globalMarketingContactGroupCode) {
		globalMarketingContactGroupPage.enter_global_marketing_contact_group_code_1(globalMarketingContactGroupCode);
	}

	@Step
	public String get_text_global_marketing_contact_group_code() {
		return globalMarketingContactGroupPage.get_text_global_marketing_contact_group_code();
	}

	@Step
	public void enter_description(String description) {
		globalMarketingContactGroupPage.enter_description(description);
	}

	@Step
	public String get_text_description(String description) {
		return globalMarketingContactGroupPage.get_text_description(description);
	}

	@Step
	public void verify_global_description(String description) {
		assertThat(globalMarketingContactGroupPage.get_text_description(description), equalTo(description));

	}

	@Step
	public void click_btn_new() {
		globalMarketingContactGroupPage.click_btn_new();
	}

	@Step
	public void click_btn_back_to_summary() {
		globalMarketingContactGroupPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_update() {
		globalMarketingContactGroupPage.click_btn_update();
	}

	@Step
	public void search_by_code(String sMarketingContactGroupCode) {
		globalMarketingContactGroupPage.enterSearchByInputField(
				GlobalMarketingContactGroupPage.MARKETING_CONTACT_GROUP_CODE, sMarketingContactGroupCode);

	}

	@Step
	public void click_btn_delete() {
		globalMarketingContactGroupPage.click_btn_delete();
	}

	@Step
	public void verify_mCode_not_found(String sMarketingContactGroupCode) {

		globalMarketingContactGroupPage.enter_code(sMarketingContactGroupCode);
		assertThat(globalMarketingContactGroupPage.get_result_code(), equalTo("No records found."));

	}

}
