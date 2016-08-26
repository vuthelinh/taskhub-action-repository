package com.synergix.globalsetup.project.steps;

import com.synergix.globalsetup.project.pages.ProjectClassPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProjectClassSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	private ProjectClassPage onProjectClassPage;

	@Step
	public void click_add_new_button_on_functional_panel() {
		onProjectClassPage.click_add_new_button_on_functional_panel();
	}

	@Step
	public void switch_to_iframe() {
		onProjectClassPage.switchToIFrame();
	}

	@Step
	public void switch_out_default_iframe() {
		onProjectClassPage.switchOutDefaultIFrame();
	}

	@Step
	public void update() {
		onProjectClassPage.click_btn_update();
		onProjectClassPage.waitForAllJSCompletes();
		onProjectClassPage.chooseYesOnUpdateConfirmation();
		onProjectClassPage.waitForAllJSCompletes();
		onProjectClassPage.chooseOKOnInfoPanel();
	}

	@Step
	public void delete() {
		onProjectClassPage.click_delete_button_on_functional_panel();
	}

	@Step
	public void enter_project_class_code(String projectClassCode) {
		onProjectClassPage.enter_project_class_code(projectClassCode);
	}

	@Step
	public String get_text_project_class_code() {
		return onProjectClassPage.get_text_project_class_code();
	}

	@Step
	public void enter_project_class_description(String projectClassDescription) {
		onProjectClassPage.enter_project_class_description(projectClassDescription);
	}

	@Step
	public String get_text_project_class_description() {
		return onProjectClassPage.get_text_project_class_description();
	}

	@Step
	public void enter_unearned_revenue(String unearnedRevenue) {
		onProjectClassPage.enter_unearned_revenue(unearnedRevenue);
	}

	@Step
	public String get_text_unearned_revenue() {
		return onProjectClassPage.get_text_unearned_revenue();
	}

	@Step
	public void enter_work_in_progress(String workInProgress) {
		onProjectClassPage.enter_work_in_progress(workInProgress);
	}

	@Step
	public String get_text_work_in_progress() {
		return onProjectClassPage.get_text_work_in_progress();
	}

	@Step
	public void enter_retention(String retention) {
		onProjectClassPage.enter_retention(retention);
	}

	@Step
	public String get_text_retention() {
		return onProjectClassPage.get_text_retention();
	}

	@Step
	public void enter_project_revenue(String projectRevenue) {
		onProjectClassPage.enter_project_revenue(projectRevenue);
	}

	@Step
	public String get_text_project_revenue() {
		return onProjectClassPage.get_text_project_revenue();
	}

	@Step
	public void enter_project_cost(String projectCost) {
		onProjectClassPage.enter_project_cost(projectCost);
	}

	@Step
	public String get_text_project_cost() {
		return onProjectClassPage.get_text_project_cost();
	}

	@Step
	public void enter_recognition_exch_gain_or_loss_th2(String recognitionExchGainOrLoss) {
		onProjectClassPage.enter_recognition_exch_gain_or_loss_th2(recognitionExchGainOrLoss);
	}

	@Step
	public String get_text_recognition_exch_gain_or_loss_th2() {
		return onProjectClassPage.get_text_recognition_exch_gain_or_loss_th2();
	}

	@Step
	public void enter_cost_accrual(String costAccrual) {
		onProjectClassPage.enter_cost_accrual(costAccrual);
	}

	@Step
	public String get_text_cost_accrual() {
		return onProjectClassPage.get_text_cost_accrual();
	}

	@Step
	public void enter_revenue_accrual(String revenueAccrual) {
		onProjectClassPage.enter_revenue_accrual(revenueAccrual);
	}

	@Step
	public String get_text_revenue_accrual() {
		return onProjectClassPage.get_text_revenue_accrual();
	}

	@Step
	public void enter_downpayment_unearned(String downpaymentUnearned) {
		onProjectClassPage.enter_downpayment_unearned(downpaymentUnearned);
	}

	@Step
	public String get_text_downpayment_unearned() {
		return onProjectClassPage.get_text_downpayment_unearned();
	}

	@Step
	public void enter_attributable_profit(String attributableProfit) {
		onProjectClassPage.enter_attributable_profit(attributableProfit);
	}

	@Step
	public String get_text_attributable_profit() {
		return onProjectClassPage.get_text_attributable_profit();
	}

	@Step
	public void enter_claim_debtor(String claimDebtor) {
		onProjectClassPage.enter_claim_debtor(claimDebtor);
	}

	@Step
	public String get_text_claim_debtor() {
		return onProjectClassPage.get_text_claim_debtor();
	}

	@Step
	public void enter_certification_debtor(String certificationDebtor) {
		onProjectClassPage.enter_certification_debtor(certificationDebtor);
	}

	@Step
	public String get_text_certification_debtor() {
		return onProjectClassPage.get_text_certification_debtor();
	}

	@Step
	public void enter_other_payable(String otherPayable) {
		onProjectClassPage.enter_other_payable(otherPayable);
	}

	@Step
	public String get_text_other_payable() {
		return onProjectClassPage.get_text_other_payable();
	}

	@Step
	public void enter_retention_clearing(String retentionClearing) {
		onProjectClassPage.enter_retention_clearing(retentionClearing);
	}

	@Step
	public String get_text_retention_clearing() {
		return onProjectClassPage.get_text_retention_clearing();
	}

	@Step
	public void enter_subcon_claim_payable(String subconClaimPayable) {
		onProjectClassPage.enter_subcon_claim_payable(subconClaimPayable);
	}

	@Step
	public String get_text_subcon_claim_payable() {
		return onProjectClassPage.get_text_subcon_claim_payable();
	}

	@Step
	public void enter_subcon_certification_payable(String subconCertificationPayable) {
		onProjectClassPage.enter_subcon_certification_payable(subconCertificationPayable);
	}

	@Step
	public String get_text_subcon_certification_payable() {
		return onProjectClassPage.get_text_subcon_certification_payable();
	}

	@Step
	public void enter_material_on_site(String materialOnSite) {
		onProjectClassPage.enter_material_on_site(materialOnSite);
	}

	@Step
	public String get_text_material_on_site() {
		return onProjectClassPage.get_text_material_on_site();
	}

	@Step
	public void enter_retention_material_on_site(String retentionMaterialOnSite) {
		onProjectClassPage.enter_retention_material_on_site(retentionMaterialOnSite);
	}

	@Step
	public String get_text_retention_material_on_site() {
		return onProjectClassPage.get_text_retention_material_on_site();
	}

	@Step
	public void enter_liquidated_damage(String liquidatedDamage) {
		onProjectClassPage.enter_liquidated_damage(liquidatedDamage);
	}

	@Step
	public String get_text_liquidated_damage() {
		return onProjectClassPage.get_text_liquidated_damage();
	}

	@Step
	public void enter_subcon_advance_payment(String subconAdvancePayment) {
		onProjectClassPage.enter_subcon_advance_payment(subconAdvancePayment);
	}

	@Step
	public String get_text_subcon_advance_payment() {
		return onProjectClassPage.get_text_subcon_advance_payment();
	}

	@Step
	public void switch_tab_local_info() {
		onProjectClassPage.switch_tab_local_info();
	}

	@Step
	public void select_status(String status) {
		onProjectClassPage.select_status(status);
	}

	@Step
	public boolean search_project_class(String projectClass) {
		onProjectClassPage.click_btn_search();
		onProjectClassPage.waitForAllJSCompletes();
		return onProjectClassPage.search(onProjectClassPage.PROJECT_CLASS_CODE, projectClass);
	}

	@Step
	public void verify_status(String status) {
		assertThat(onProjectClassPage.is_selected_status(status), equalTo(true));
	}

	@Step
	public void choose_company(String companyList) {
		onProjectClassPage.switch_to_tab_company();
		onProjectClassPage.waitForAllJSCompletes();
		onProjectClassPage.chooseCompany(companyList);
	}

	@Step
	public void verify_project_class_code(String projectClassCode) {
		assertThat(onProjectClassPage.get_text_project_class_code(), equalTo(projectClassCode));
	}

	@Step
	public void verify_project_class_description(String projectClassDescription) {
		assertThat(onProjectClassPage.get_text_project_class_description(), equalTo(projectClassDescription));
	}

	@Step
	public void verify_unearned_revenue(String unearnedRevenue) {
		assertThat(onProjectClassPage.get_text_unearned_revenue(), equalTo(unearnedRevenue));
	}

	@Step
	public void verify_work_in_progress(String workInProgress) {
		assertThat(onProjectClassPage.get_text_work_in_progress(), equalTo(workInProgress));
	}

	@Step
	public void verify_retention(String retention) {
		assertThat(onProjectClassPage.get_text_retention(), equalTo(retention));
	}

	@Step
	public void verify_project_revenue(String projectRevenue) {
		assertThat(onProjectClassPage.get_text_project_revenue(), equalTo(projectRevenue));
	}

	@Step
	public void verify_project_cost(String projectCost) {
		assertThat(onProjectClassPage.get_text_project_cost(), equalTo(projectCost));
	}

	@Step
	public void verify_recognition_exch_gain_loss_th2(String recognitionExchGainLossTh2) {
		assertThat(onProjectClassPage.get_text_recognition_exch_gain_or_loss_th2(),
				equalTo(recognitionExchGainLossTh2));
	}

	@Step
	public void verify_cost_accrual(String costAccrual) {
		assertThat(onProjectClassPage.get_text_cost_accrual(), equalTo(costAccrual));
	}

	@Step
	public void verify_revenue_accrual(String revenueAccural) {
		assertThat(onProjectClassPage.get_text_revenue_accrual(), equalTo(revenueAccural));
	}

	@Step
	public void verify_downpayment_unearned(String downpaymentUnearned) {
		assertThat(onProjectClassPage.get_text_downpayment_unearned(), equalTo(downpaymentUnearned));
	}

	@Step
	public void verify_attributable_profit(String attributableProfit) {
		assertThat(onProjectClassPage.get_text_attributable_profit(), equalTo(attributableProfit));
	}

	@Step
	public void verify_claim_debtor(String claimDebtor) {
		assertThat(onProjectClassPage.get_text_claim_debtor(), equalTo(claimDebtor));
	}

	@Step
	public void verify_certification_debtor(String certificationDebtor) {
		assertThat(onProjectClassPage.get_text_certification_debtor(), equalTo(certificationDebtor));
	}

	@Step
	public void verify_other_payable(String otherPayable) {
		assertThat(onProjectClassPage.get_text_other_payable(), equalTo(otherPayable));
	}

	@Step
	public void verify_retention_clearing(String retentionClearing) {
		assertThat(onProjectClassPage.get_text_retention_clearing(), equalTo(retentionClearing));
	}

	@Step
	public void verify_subcon_claim_payable(String subconClaimPayable) {
		assertThat(onProjectClassPage.get_text_subcon_claim_payable(), equalTo(subconClaimPayable));
	}

	@Step
	public void verify_subcon_certification_payable(String subconCertificationPayable) {
		assertThat(onProjectClassPage.get_text_subcon_certification_payable(), equalTo(subconCertificationPayable));
	}

	@Step
	public void verify_material_on_site(String materialOnSite) {
		assertThat(onProjectClassPage.get_text_material_on_site(), equalTo(materialOnSite));
	}

	@Step
	public void verify_retention_material_on_site(String retentionMaterialOnSite) {
		assertThat(onProjectClassPage.get_text_retention_material_on_site(), equalTo(retentionMaterialOnSite));
	}

	@Step
	public void verify_liquidated_damage(String liquidatedDamage) {
		assertThat(onProjectClassPage.get_text_liquidated_damage(), equalTo(liquidatedDamage));
	}

	@Step
	public void verify_subcon_advance_payment(String subconAdvancePayment) {
		assertThat(onProjectClassPage.get_text_subcon_advance_payment(), equalTo(subconAdvancePayment));
	}

	@Step
	public void verify_search_project_class_not_found(String projectClass) {
		assertThat(search_project_class(projectClass), equalTo(false));
	}
}
