package com.synergix.globalsetup.party.customer.steps;

import com.synergix.globalsetup.party.customer.page.CustomerClassPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CustomerClassSteps extends ScenarioSteps {

	private static final String CUSTOMER_CLASS_CODE = "Customer Class Code";
	CustomerClassPage onCustomerClassPage;

	public void switchToIFrame() {
		onCustomerClassPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onCustomerClassPage.switchOutDefaultIFrame();
	}

	@Step
	public void moveToCompanyTab() {
		onCustomerClassPage.switch_to_tab("Company");
	}

	@Step
	public void clickOnUpdateButton() {
		onCustomerClassPage.onClickUpdateButton();
	}

	@Step
	public void typeCustomerClassCode(String customerClassCode) {
		onCustomerClassPage.typeCustomerClassCode(customerClassCode);
	}
	
	/**
	 * Created by Steve
	 * @param customerClassCode
	 * @return
	 */
	public boolean searchCustomerClassCode(String customerClassCode){
		onCustomerClassPage.clickBtn("Search");
		onCustomerClassPage.waitForAllJSCompletes();
		return onCustomerClassPage.search("Customer Class Code", customerClassCode);
	}

	@Step
	public void typeDescription(String description) {
		onCustomerClassPage.typeDescription(description);
	}

	@Step
	public void typeReceivableGLAN(String receivableGLAN) {
		onCustomerClassPage.typeReceivableGLAN(receivableGLAN);
	}

	@Step
	public void typeRealizedGLAN(String realizedGLAN) {
		onCustomerClassPage.typeRealizedGLAN(realizedGLAN);
	}

	@Step
	public void typeUnrealizedGLAN(String unrealizedGLAN) {
		onCustomerClassPage.typeUnrealizedGLAN(unrealizedGLAN);
	}

	@Step
	public void typeCorporateClearingGLAN(String corporateClearingGLAN) {
		onCustomerClassPage.typeCorporateClearingGLAN(corporateClearingGLAN);
	}

	@Step
	public void typeAmtRefundabletoCustomer(String amtRefundabletoCustomer) {
		onCustomerClassPage.typeAmtRefundabletoCustomer(amtRefundabletoCustomer);
	}

	@Step
	public void typeReceivableMedisaveGLAN(String receivableMedisaveGLAN) {
		onCustomerClassPage.typeReceivableMedisaveGLAN(receivableMedisaveGLAN);
	}

	@Step
	public void typeMedisaveClearingGLAN(String medisaveClearingGLAN) {
		onCustomerClassPage.typeMedisaveClearingGLAN(medisaveClearingGLAN);
	}

	@Step
	public void typeAmtBillabletoCustomer(String amtBillabletoCustomer) {
		onCustomerClassPage.typeAmtBillabletoCustomer(amtBillabletoCustomer);
	}

	@Step
	public void typeRecognizedAccruedCost(String recognizedAccruedCost) {
		onCustomerClassPage.typeRecognizedAccruedCost(recognizedAccruedCost);
	}

	@Step
	public void typeRecognizedAccruedRevenue(String recognizedAccruedRevenue) {
		onCustomerClassPage.typeRecognizedAccruedRevenue(recognizedAccruedRevenue);
	}

	@Step
	public void typeRentalRevenueGLAN(String rentalRevenueGLAN) {
		onCustomerClassPage.typeRentalRevenueGLAN(rentalRevenueGLAN);
	}

	@Step
	public void typeSalesGLAN(String salesGLAN) {
		onCustomerClassPage.typeSalesGLAN(salesGLAN);
	}

	@Step
	public void typeCostsofSalesGLAN(String costsofSalesGLAN) {
		onCustomerClassPage.typeCostsofSalesGLAN(costsofSalesGLAN);
	}

	@Step
	public void typeSalesReturnGLAN(String salesReturnGLAN) {
		onCustomerClassPage.typeSalesReturnGLAN(salesReturnGLAN);
	}

	@Step
	public void typeCostsofSalesReturnGLAN(String costsofSalesReturnGLAN) {
		onCustomerClassPage.typeCostsofSalesReturnGLAN(costsofSalesReturnGLAN);
	}

	@Step
	public void typeCostsofSalesRetClearingGLAN(String costsofSalesRetClearingGLAN) {
		onCustomerClassPage.typeCostsofSalesRetClearingGLAN(costsofSalesRetClearingGLAN);
	}

	@Step
	public void typeDeliveryClearingGLAN(String deliveryClearingGLAN) {
		onCustomerClassPage.typeDeliveryClearingGLAN(deliveryClearingGLAN);
	}

	@Step
	public void typeInventoryWithCustomerGLAN(String inventoryWithCustomerGLAN) {
		onCustomerClassPage.typeInventoryWithCustomerGLAN(inventoryWithCustomerGLAN);
	}

	@Step
	public void typeCostofServicingGLAN(String costofServicingGLAN) {
		onCustomerClassPage.typeCostofServicingGLAN(costofServicingGLAN);
	}

	@Step
	public void typeUnearnedRevenueGLAN(String unearnedRevenueGLAN) {
		onCustomerClassPage.typeUnearnedRevenueGLAN(unearnedRevenueGLAN);
	}

	@Step
	public void typeWorkinProgressGLAN(String workinProgressGLAN) {
		onCustomerClassPage.typeWorkinProgressGLAN(workinProgressGLAN);
	}

	@Step
	public void typeRetentionGLAN(String retentionGLAN) {
		onCustomerClassPage.typeRetentionGLAN(retentionGLAN);
	}

	@Step
	public void typeProjectRevenueGLAN(String projectRevenueGLAN) {
		onCustomerClassPage.typeProjectRevenueGLAN(projectRevenueGLAN);
	}

	@Step
	public void typeProjectCostGLAN(String projectCostGLAN) {
		onCustomerClassPage.typeProjectCostGLAN(projectCostGLAN);
	}

	@Step
	public void typeRecognitionExchGainLossGLAN(String recognitionExchGainLossGLAN) {
		onCustomerClassPage.typeRecognitionExchGainLossGLAN(recognitionExchGainLossGLAN);
	}

	@Step
	public void typeCostAccrualGLAN(String costAccrualGLAN) {
		onCustomerClassPage.typeCostAccrualGLAN(costAccrualGLAN);
	}

	@Step
	public void typeAccruedIncomeGLAN(String accruedIncomeGLAN) {
		onCustomerClassPage.typeAccruedIncomeGLAN(accruedIncomeGLAN);
	}

	@Step
	public void typeAttributableProfit(String attributableProfit) {
		onCustomerClassPage.typeAttributableProfit(attributableProfit);
	}

	@Step
	public void typeClaimDebtor(String claimDebtor) {
		onCustomerClassPage.typeClaimDebtor(claimDebtor);
	}

	@Step
	public void typeCertificationDebtor(String certificationDebtor) {
		onCustomerClassPage.typeCertificationDebtor(certificationDebtor);
	}

	@Step
	public void typeOtherPayable(String otherPayable) {
		onCustomerClassPage.typeOtherPayable(otherPayable);
	}

	@Step
	public void typeRetentionClearing(String retentionClearing) {
		onCustomerClassPage.typeRetentionClearing(retentionClearing);
	}

	@Step
	public void typeMaterialonSite(String materialonSite) {
		onCustomerClassPage.typeMaterialonSite(materialonSite);
	}

	@Step
	public void typeRetentionMaterialonSite(String retentionMaterialonSite) {
		onCustomerClassPage.typeRetentionMaterialonSite(retentionMaterialonSite);
	}

	@Step
	public void typeDownpaymentUnearnedGLAN(String downpaymentUnearnedGLAN) {
		onCustomerClassPage.typeDownpaymentUnearnedGLAN(downpaymentUnearnedGLAN);
	}

	@Step
	public void typeDownpaymentExchGainLossGLAN(String downpaymentExchGainLossGLAN) {
		onCustomerClassPage.typeDownpaymentExchGainLossGLAN(downpaymentExchGainLossGLAN);
	}

	@Step
	public void typeContractRevenueGLAN(String contractRevenueGLAN) {
		onCustomerClassPage.typeContractRevenueGLAN(contractRevenueGLAN);
	}

	@Step
	public void typeContractUnearnedRevenueGLAN(String contractUnearnedRevenueGLAN) {
		onCustomerClassPage.typeContractUnearnedRevenueGLAN(contractUnearnedRevenueGLAN);
	}

	@Step
	public void clickOnNewBtn() {
		onCustomerClassPage.onClickNewButton();
	}

	@Step
	public void chooseAllCompany() {
		onCustomerClassPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String company) {
		onCustomerClassPage.chooseCompany(company);
	}

	@Step
	public void chooseDelCusClass(String customerClassCode) {
		onCustomerClassPage.deleteValueBySearchBtn("Search", CUSTOMER_CLASS_CODE, customerClassCode);
	}

	@Step
	public void typeRevenueAccrualGLAN(String revenueAccrualGLAN) {
		onCustomerClassPage.typeRevenueAccrualGLAN(revenueAccrualGLAN);
	}
}
