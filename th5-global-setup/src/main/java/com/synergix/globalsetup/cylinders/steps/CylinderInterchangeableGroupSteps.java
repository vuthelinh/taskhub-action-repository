package com.synergix.globalsetup.cylinders.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.globalsetup.cylinders.pages.CylinderInterchangeableGroupPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CylinderInterchangeableGroupSteps extends ScenarioSteps {

	CylinderInterchangeableGroupPage onCylChangeGrpPage;

	@Step
	public void enter_interchangeable_group_code(String interchangeableGroupCode) {
		onCylChangeGrpPage
				.enter_interchangeable_group_code(interchangeableGroupCode);
	}

	@Step
	public void enter_description(String description) {
		onCylChangeGrpPage.enter_description(description);
	}

	@Step
	public void select_enable_deposit_or_refund_or_purchase(
			String enableDepositOrRefundOrPurchase) {
		onCylChangeGrpPage
				.select_enable_deposit_or_refund_or_purchase(enableDepositOrRefundOrPurchase);
	}

	@Step
	public void enter_unit_deposit_amount(String unitDepositAmount) {
		onCylChangeGrpPage
				.enter_unit_deposit_amount(unitDepositAmount);
	}

	@Step
	public void enter_unit_refund_amount(String unitRefundAmount) {
		onCylChangeGrpPage
				.enter_unit_refund_amount(unitRefundAmount);
	}

	@Step
	public void enter_unit_purchase_amount(String unitPurchaseAmount) {
		onCylChangeGrpPage.enter_unit_purchase_amount(unitPurchaseAmount);
	}

	public void add_new() {
		onCylChangeGrpPage.clickBtn("New");
		onCylChangeGrpPage.waitForAllJSCompletes();
	}

	public void update() {
		onCylChangeGrpPage.clickBtn("Update");
		onCylChangeGrpPage.waitForAllJSCompletes();
		onCylChangeGrpPage.chooseYesOnUpdateConfirmation();
		onCylChangeGrpPage.waitForAllJSCompletes();
		onCylChangeGrpPage.chooseOKOnInfoPanel();
		onCylChangeGrpPage.waitForAllJSCompletes();
	}

	public void searchCylinderInterchangeableGroup(String sInterchangeableGroupCode) {
		add_new();
		onCylChangeGrpPage.click_search_button_on_functional_panel();
		onCylChangeGrpPage.searchCylinderInterchangeableGroup(sInterchangeableGroupCode);

	}

	public void delete() {
		onCylChangeGrpPage.clickBtn("Delete");
		onCylChangeGrpPage.waitForAllJSCompletes();
		onCylChangeGrpPage.chooseYesOnUpdateConfirmation();
		onCylChangeGrpPage.waitForAllJSCompletes();

	}
	
	@Step
	public void create_cylinder_interchangeable_group(String sInterchangeableGroupCode, String sDescription,
			String sEnableDRP, String sUnitDepositAmount, String sUnitRefundAmount,
			String sUnitPurchaseAmount) {
		
		add_new();
		enter_interchangeable_group_code(sInterchangeableGroupCode);
		enter_description(sDescription);
		select_enable_deposit_or_refund_or_purchase(sEnableDRP);
		if(sEnableDRP.equals("Yes"))
		{
			enter_unit_deposit_amount(sUnitDepositAmount);
			enter_unit_refund_amount(sUnitRefundAmount);
			enter_unit_purchase_amount(sUnitPurchaseAmount);
		}
		
		update();
	}

	@Step
	public void verify_cylinder_interchangeable_group_is_updated(String sInterchangeableGroupCode, String sDescription,
			String sEnableDRP, String sUnitDepositAmount, String sUnitRefundAmount,
			String sUnitPurchaseAmount) {
		
		assertThat(onCylChangeGrpPage.get_interchangeable_group_code(), equalTo(sInterchangeableGroupCode));
		assertThat(onCylChangeGrpPage.get_description(), equalTo(sDescription));
		if(sEnableDRP.equals("Yes"))
		{
			assertThat(onCylChangeGrpPage.get_enable_deposit_or_refund_or_purchase(sEnableDRP), equalTo("checked"));
			assertThat(onCylChangeGrpPage.get_unit_deposit_amount(), equalTo(sUnitDepositAmount));
			assertThat(onCylChangeGrpPage.get_unit_refund_amount(), equalTo(sUnitRefundAmount));
			assertThat(onCylChangeGrpPage.get_unit_purchase_amount(), equalTo(sUnitPurchaseAmount));
			
		}else{
			assertThat(onCylChangeGrpPage.get_enable_deposit_or_refund_or_purchase(sEnableDRP), equalTo("checked"));
		}

	}

	@Step
	public void verfiy_cylinder_interchangeable_group_is_deleted(String CylinderIGCode) {
		add_new();	
		onCylChangeGrpPage.click_search_button_on_functional_panel();
		boolean found = onCylChangeGrpPage.search_cylinder_interchangeable_group(CylinderIGCode);
		assertThat(found, equalTo(false));
	}

	@Step
	public String isAlreadyExistsInDatabase(String sChangeGroupCode) {
		return onCylChangeGrpPage.check_database_exist("MT_CYL_INTERCHANGEABLE", "INTERCHANGEABLE_CODE", sChangeGroupCode);
	}

}
