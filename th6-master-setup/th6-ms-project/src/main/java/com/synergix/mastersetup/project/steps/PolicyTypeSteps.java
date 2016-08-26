package com.synergix.mastersetup.project.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.mastersetup.project.pages.PolicyTypePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian on 8/4/2016.
 */
public class PolicyTypeSteps extends ScenarioSteps {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PolicyTypePage policyTypePage;

    @Step
    public void create_new_policy_type(String policyTypeCode, String description) {
    	policyTypePage.clickAddNewButtonOnFunctionalPanel();
    	policyTypePage.enterPolicyTypeCodeAndEnter(policyTypeCode);
    	policyTypePage.waitForAllJSCompletes();
    	policyTypePage.enterPolicyTypeDescriptionForPolicyType(policyTypeCode, description);
    	policyTypePage.clickUpdateForPolicyType(policyTypeCode);
    	policyTypePage.waitForAllJSCompletes();
    	policyTypePage.clickBtnYesOnConfirmUpdate();
    }
    
    /**
     * Created by Zoe on 8/9/2016.
     */
    
    @Step
	public void enter_policy_type_code(String policyTypeCode) {
		policyTypePage.enterPolicyTypeCodeAndEnter(policyTypeCode);
	}

	@Step
	public String get_text_policy_type_code(String policyTypeCode) {
		return policyTypePage.get_text_policy_type_code(policyTypeCode);
	}

	

	@Step
	public void enter_description(String policyTypeCode, String description) {
		policyTypePage.enterPolicyTypeDescriptionForPolicyType(policyTypeCode, description);
	}

	@Step
	public String get_text_description(String description) {
		return policyTypePage.get_text_description(description);
	}

	
	@Step
	public void select_status(String status) {
		policyTypePage.select_status(status);
	}

	@Step
	public void click_btn_update(){
		policyTypePage.click_btn_update();
	}

	@Step
	public void click_btn_delete(){
		policyTypePage.choose_policy_type();
		policyTypePage.click_btn_delete();
	}
	@Step
	public void click_btn_add(){
		policyTypePage.click_add_new();
	}

	@Step
	public void enter_policy_type_code_1(String policyTypeCode) {
		policyTypePage.enter_code(policyTypeCode);
		
	}
	@Step
	public void verify_policy_code(String policyTypeCode){
		assertThat(policyTypePage.get_text_policy_type_code(policyTypeCode), equalTo(policyTypeCode));
	}
	@Step
	public void verify_description(String description){
		assertThat(policyTypePage.get_text_description(description), equalTo(description));

		
	}
	@Step
	public void verify_policy_type_not_found(String policyTypeCode) {

		policyTypePage.enter_code(policyTypeCode);
		assertThat(policyTypePage.get_result_code(), equalTo("No records found."));

	}
	
}
