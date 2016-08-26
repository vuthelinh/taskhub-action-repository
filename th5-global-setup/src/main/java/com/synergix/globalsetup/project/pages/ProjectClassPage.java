package com.synergix.globalsetup.project.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ProjectClassPage extends TH5PageObject {
	
	private static final String SEARCH = "Search";
	private static final String UPDATE = "Update";
	private static final String STATUS = "Status";
	private static final String LOCAL_INFO = "Local Info";
	private static final int GLAN_INPUT_FIELD_ORDER = 2;
	private static final String SUBCON_ADVANCE_PAYMENT = "Subcon Advance Payment";
	private static final String LIQUIDATED_DAMAGE = "Liquidated Damage";
	private static final String RETENTION_MATERIAL_ON_SITE = "Retention Material on Site";
	private static final String MATERIAL_ON_SITE = "Material on Site";
	private static final String SUBCON_CERTIFICATION_PAYABLE = "Subcon Certification Payable";
	private static final String SUBCON_CLAIM_PAYABLE = "Subcon Claim Payable";
	private static final String RETENTION_CLEARING = "Retention Clearing";
	private static final String OTHER_PAYABLE = "Other Payable";
	private static final String CERTIFICATION_DEBTOR = "Certification Debtor";
	private static final String CLAIM_DEBTOR = "Claim Debtor";
	private static final String ATTRIBUTABLE_PROFIT = "Attributable Profit";
	private static final String DOWNPAYMENT_UNEARNED = "Downpayment Unearned";
	private static final String REVENUE_ACCRUAL = "Revenue Accrual";
	private static final String COST_ACCRUAL = "Cost Accrual";
	private static final String RECOGNITION_EXCH_GAIN_LOSS_TH2 = "Recognition Exch Gain/Loss (TH2)";
	private static final String PROJECT_COST = "Project Cost";
	private static final String PROJECT_REVENUE = "Project Revenue";
	private static final String RETENTION = "Retention";
	private static final String WORK_IN_PROGRESS = "Work In Progress";
	private static final String UNEARNED_REVENUE = "Unearned Revenue";
	private static final String PROJECT_CLASS_DESCRIPTION = "Project Class Description";
	public final String PROJECT_CLASS_CODE = "Project Class Code";
	public ProjectClassPage(WebDriver driver){
		super(driver);
	}
	
	public void click_btn_update(){
		clickBtn(UPDATE);
		waitForAllJSCompletes();
	}
	public void click_btn_search(){
		clickBtn(SEARCH);
		waitForAllJSCompletes();
	}
	
	public void enter_project_class_code(String projectClassCode){
		enterInputFieldCodeWithLabel(PROJECT_CLASS_CODE, projectClassCode);
	}
	
	private String tableXpath = "//table";
	public String get_text_project_class_code(){
		waitForAllJSCompletes();
		return getTextValueWithLabel(tableXpath, PROJECT_CLASS_CODE);
	}
	
	public void enter_project_class_description(String projectClassDescription){
		enterInputFieldWithLabel(PROJECT_CLASS_DESCRIPTION, projectClassDescription);
	}
	public String get_text_project_class_description(){
		waitForAllJSCompletes();
		return getTextValueWithLabel(tableXpath, PROJECT_CLASS_DESCRIPTION);
	}
	
	public void enter_unearned_revenue(String unearnedRevenue){
		enterInputFieldWithLabel(UNEARNED_REVENUE, unearnedRevenue);
	}
	public String get_text_unearned_revenue(){
		return getTextValueWithLabel(tableXpath, UNEARNED_REVENUE, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_work_in_progress(String workInProgress){
		enterInputFieldWithLabel(WORK_IN_PROGRESS, workInProgress);
	}
	public String get_text_work_in_progress(){
		return getTextValueWithLabel(tableXpath, WORK_IN_PROGRESS, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_retention(String retention){
		enterInputFieldWithLabel(RETENTION, retention);
	}
	public String get_text_retention(){
		return getTextValueWithLabel(tableXpath, RETENTION, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_project_revenue(String projectRevenue){
		enterInputFieldWithLabel(PROJECT_REVENUE, projectRevenue);
	}
	public String get_text_project_revenue(){
		return getTextValueWithLabel(tableXpath, PROJECT_REVENUE, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_project_cost(String projectCost){
		enterInputFieldWithLabel(PROJECT_COST, projectCost);
	}
	public String get_text_project_cost(){
		return getTextValueWithLabel(tableXpath, PROJECT_COST, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_recognition_exch_gain_or_loss_th2(String recognitionExchGainOrLoss){
		enterInputFieldWithLabel(RECOGNITION_EXCH_GAIN_LOSS_TH2, recognitionExchGainOrLoss);
	}
	public String get_text_recognition_exch_gain_or_loss_th2(){
		return getTextValueWithLabel(tableXpath, RECOGNITION_EXCH_GAIN_LOSS_TH2, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_cost_accrual(String costAccrual){
		enterInputFieldWithLabel(COST_ACCRUAL, costAccrual);
	}
	public String get_text_cost_accrual(){
		return getTextValueWithLabel(tableXpath, COST_ACCRUAL, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_revenue_accrual(String revenueAccrual){
		enterInputFieldWithLabel(REVENUE_ACCRUAL, revenueAccrual);
	}
	public String get_text_revenue_accrual(){
		return getTextValueWithLabel(tableXpath, REVENUE_ACCRUAL, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_downpayment_unearned(String downpaymentUnearned){
		enterInputFieldWithLabel(DOWNPAYMENT_UNEARNED, downpaymentUnearned);
	}
	public String get_text_downpayment_unearned(){
		return getTextValueWithLabel(tableXpath, DOWNPAYMENT_UNEARNED, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_attributable_profit(String attributableProfit){
		enterInputFieldWithLabel(ATTRIBUTABLE_PROFIT, attributableProfit);
	}
	public String get_text_attributable_profit(){
		return getTextValueWithLabel(tableXpath, ATTRIBUTABLE_PROFIT, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_claim_debtor(String claimDebtor){
		enterInputFieldWithLabel(CLAIM_DEBTOR, claimDebtor);
	}
	public String get_text_claim_debtor(){
		return getTextValueWithLabel(tableXpath, CLAIM_DEBTOR, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_certification_debtor(String certificationDebtor){
		enterInputFieldWithLabel(CERTIFICATION_DEBTOR, certificationDebtor);
	}
	public String get_text_certification_debtor(){
		return getTextValueWithLabel(tableXpath, CERTIFICATION_DEBTOR, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_other_payable(String otherPayable){
		enterInputFieldWithLabel(OTHER_PAYABLE, otherPayable);
	}
	public String get_text_other_payable(){
		return getTextValueWithLabel(tableXpath, OTHER_PAYABLE, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_retention_clearing(String retentionClearing){
		enterInputFieldWithLabel(RETENTION_CLEARING, retentionClearing);
	}
	public String get_text_retention_clearing(){
		return getTextValueWithLabel(tableXpath, RETENTION_CLEARING, GLAN_INPUT_FIELD_ORDER);
	}
	
	public void enter_subcon_claim_payable(String subconClaimPayable){
		enterInputFieldWithLabel(SUBCON_CLAIM_PAYABLE, subconClaimPayable);
	}
	public String get_text_subcon_claim_payable(){
		return getTextValueWithLabel(tableXpath, SUBCON_CLAIM_PAYABLE, GLAN_INPUT_FIELD_ORDER);
	}

	public void enter_subcon_certification_payable(String subconCertificationPayable){
		enterInputFieldWithLabel(SUBCON_CERTIFICATION_PAYABLE, subconCertificationPayable);
	}
	public String get_text_subcon_certification_payable(){
		return getTextValueWithLabel(tableXpath, SUBCON_CERTIFICATION_PAYABLE, GLAN_INPUT_FIELD_ORDER);
	}

	public void enter_material_on_site(String materialOnSite){
		enterInputFieldWithLabel(MATERIAL_ON_SITE, materialOnSite);
	}
	public String get_text_material_on_site(){
		return getTextValueWithLabel(tableXpath, MATERIAL_ON_SITE, GLAN_INPUT_FIELD_ORDER);
	}

	public void enter_retention_material_on_site(String retentionMaterialOnSite){
		enterInputFieldWithLabel(RETENTION_MATERIAL_ON_SITE, retentionMaterialOnSite);
	}
	public String get_text_retention_material_on_site(){
		return getTextValueWithLabel(tableXpath, RETENTION_MATERIAL_ON_SITE, GLAN_INPUT_FIELD_ORDER);
	}

	public void enter_liquidated_damage(String liquidatedDamage){
		enterInputFieldWithLabel(LIQUIDATED_DAMAGE, liquidatedDamage);
	}
	public String get_text_liquidated_damage(){
		return getTextValueWithLabel(tableXpath, LIQUIDATED_DAMAGE, GLAN_INPUT_FIELD_ORDER);
	}

	public void enter_subcon_advance_payment(String subconAdvancePayment){
		enterInputFieldWithLabel(SUBCON_ADVANCE_PAYMENT, subconAdvancePayment);
	}
	public String get_text_subcon_advance_payment(){
		return getTextValueWithLabel(tableXpath, SUBCON_ADVANCE_PAYMENT, GLAN_INPUT_FIELD_ORDER);
	}
	
	//Tab Local Info
	public void switch_tab_local_info(){
		switch_to_tab(LOCAL_INFO);
		waitForAllJSCompletes();
	}
	
	public void select_status(String status){
		selectRadioButton(STATUS, status);
		waitForAllJSCompletes();
	}
	public boolean is_selected_status(String status){
		return getChecked(STATUS, status);
	}
}
